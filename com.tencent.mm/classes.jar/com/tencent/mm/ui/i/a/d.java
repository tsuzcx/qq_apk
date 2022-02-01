package com.tencent.mm.ui.i.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Calendar;
import org.json.JSONObject;

public final class d
{
  long XGQ;
  public AccessToken XGX;
  private CallbackManager XGY;
  b XGZ;
  private FacebookCallback XHa;
  private final String mAppId;
  
  public d(String paramString)
  {
    AppMethodBeat.i(152826);
    this.XHa = new FacebookCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(152822);
        Log.i("MicroMsg.FacebookAndroid", "facebook auth cancel!");
        if (d.this.XGZ != null) {
          d.this.XGZ.onCancel();
        }
        AppMethodBeat.o(152822);
      }
      
      public final void onError(FacebookException paramAnonymousFacebookException)
      {
        AppMethodBeat.i(152823);
        Log.e("MicroMsg.FacebookAndroid", "facebook auth error! %s", new Object[] { paramAnonymousFacebookException.getMessage() });
        if (d.this.XGZ != null) {
          d.this.XGZ.onError(paramAnonymousFacebookException.getMessage());
        }
        AppMethodBeat.o(152823);
      }
    };
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
      AppMethodBeat.o(152826);
      throw paramString;
    }
    this.mAppId = paramString;
    AppMethodBeat.o(152826);
  }
  
  private static void hWU()
  {
    AppMethodBeat.i(152828);
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(1, localCalendar.get(1) + 100);
      Field localField1 = AttributionIdentifiers.class.getDeclaredField("recentlyFetchedIdentifiers");
      Field localField2 = AttributionIdentifiers.class.getDeclaredField("fetchTime");
      localField2.setAccessible(true);
      AttributionIdentifiers localAttributionIdentifiers = new AttributionIdentifiers();
      localField2.set(localAttributionIdentifiers, Long.valueOf(localCalendar.getTimeInMillis()));
      localField1.setAccessible(true);
      localField1.set(AttributionIdentifiers.class, localAttributionIdentifiers);
      AppMethodBeat.o(152828);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.FacebookAndroid", localException.getMessage());
      RuntimeException localRuntimeException = new RuntimeException(localException);
      AppMethodBeat.o(152828);
      throw localRuntimeException;
    }
  }
  
  public final void a(Activity paramActivity, b paramb, String[] paramArrayOfString)
  {
    AppMethodBeat.i(152829);
    LoginManager.getInstance().registerCallback(this.XGY, this.XHa);
    this.XGZ = paramb;
    LoginManager.getInstance().logInWithReadPermissions(paramActivity, Arrays.asList(paramArrayOfString));
    AppMethodBeat.o(152829);
  }
  
  public final void a(String paramString, final a parama)
  {
    AppMethodBeat.i(152830);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", paramString);
    new GraphRequest(this.XGX, "me", localBundle, HttpMethod.GET, new GraphRequest.Callback()
    {
      public final void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(152825);
        if (paramAnonymousGraphResponse != null) {
          try
          {
            paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
            parama.C(paramAnonymousGraphResponse);
            AppMethodBeat.o(152825);
            return;
          }
          catch (Exception paramAnonymousGraphResponse)
          {
            parama.onError("Retrieve Failed, Error Format!");
            AppMethodBeat.o(152825);
            return;
          }
        }
        parama.onError("Retrieve Failed, No response!");
        AppMethodBeat.o(152825);
      }
    }).executeAsync();
    AppMethodBeat.o(152830);
  }
  
  public final void dbv()
  {
    AppMethodBeat.i(152833);
    this.XGX = null;
    this.XGQ = 0L;
    this.XGZ = null;
    LoginManager.getInstance().logOut();
    AppMethodBeat.o(152833);
  }
  
  public final boolean hWS()
  {
    AppMethodBeat.i(152831);
    if ((this.XGX != null) && ((this.XGQ == 0L) || (System.currentTimeMillis() < this.XGQ)))
    {
      AppMethodBeat.o(152831);
      return true;
    }
    AppMethodBeat.o(152831);
    return false;
  }
  
  public final void hWT()
  {
    AppMethodBeat.i(152827);
    hWU();
    FacebookSdk.setApplicationId(this.mAppId);
    FacebookSdk.sdkInitialize(MMApplicationContext.getContext());
    Log.i("MicroMsg.FacebookAndroid", "installerPkg %s", new Object[] { AttributionIdentifiers.getAttributionIdentifiers(MMApplicationContext.getContext()).getAndroidInstallerPackage() });
    this.XGY = CallbackManager.Factory.create();
    AppMethodBeat.o(152827);
  }
  
  public final void j(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(152832);
    if (this.XGY != null) {
      this.XGY.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(152832);
  }
  
  public static abstract interface a
  {
    public abstract void C(JSONObject paramJSONObject);
    
    public abstract void onError(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void onCancel();
    
    public abstract void onError(String paramString);
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.i.a.d
 * JD-Core Version:    0.7.0.1
 */