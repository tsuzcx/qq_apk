package com.tencent.mm.ui.g.a;

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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Calendar;
import org.json.JSONObject;

public final class d
{
  public AccessToken HiC;
  private CallbackManager HiD;
  b HiE;
  private FacebookCallback HiF;
  long Hiv;
  private final String mAppId;
  
  public d(String paramString)
  {
    AppMethodBeat.i(152826);
    this.HiF = new FacebookCallback()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(152822);
        ad.i("MicroMsg.FacebookAndroid", "facebook auth cancel!");
        if (d.this.HiE != null) {
          d.this.HiE.onCancel();
        }
        AppMethodBeat.o(152822);
      }
      
      public final void onError(FacebookException paramAnonymousFacebookException)
      {
        AppMethodBeat.i(152823);
        ad.e("MicroMsg.FacebookAndroid", "facebook auth error! %s", new Object[] { paramAnonymousFacebookException.getMessage() });
        if (d.this.HiE != null) {
          d.this.HiE.onError(paramAnonymousFacebookException.getMessage());
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
  
  private static void fcW()
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
      ad.e("MicroMsg.FacebookAndroid", localException.getMessage());
      RuntimeException localRuntimeException = new RuntimeException(localException);
      AppMethodBeat.o(152828);
      throw localRuntimeException;
    }
  }
  
  public final void a(Activity paramActivity, b paramb, String[] paramArrayOfString)
  {
    AppMethodBeat.i(152829);
    LoginManager.getInstance().registerCallback(this.HiD, this.HiF);
    this.HiE = paramb;
    LoginManager.getInstance().logInWithReadPermissions(paramActivity, Arrays.asList(paramArrayOfString));
    AppMethodBeat.o(152829);
  }
  
  public final void a(String paramString, final a parama)
  {
    AppMethodBeat.i(152830);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", paramString);
    new GraphRequest(this.HiC, "me", localBundle, HttpMethod.GET, new GraphRequest.Callback()
    {
      public final void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppMethodBeat.i(152825);
        if (paramAnonymousGraphResponse != null) {
          try
          {
            paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
            parama.t(paramAnonymousGraphResponse);
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
  
  public final boolean fcU()
  {
    AppMethodBeat.i(152831);
    if ((this.HiC != null) && ((this.Hiv == 0L) || (System.currentTimeMillis() < this.Hiv)))
    {
      AppMethodBeat.o(152831);
      return true;
    }
    AppMethodBeat.o(152831);
    return false;
  }
  
  public final void fcV()
  {
    AppMethodBeat.i(152827);
    fcW();
    FacebookSdk.setApplicationId(this.mAppId);
    FacebookSdk.sdkInitialize(aj.getContext());
    ad.i("MicroMsg.FacebookAndroid", "installerPkg %s", new Object[] { AttributionIdentifiers.getAttributionIdentifiers(aj.getContext()).getAndroidInstallerPackage() });
    this.HiD = CallbackManager.Factory.create();
    AppMethodBeat.o(152827);
  }
  
  public final void i(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(152832);
    if (this.HiD != null) {
      this.HiD.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(152832);
  }
  
  public final void logout()
  {
    AppMethodBeat.i(152833);
    this.HiC = null;
    this.Hiv = 0L;
    this.HiE = null;
    LoginManager.getInstance().logOut();
    AppMethodBeat.o(152833);
  }
  
  public static abstract interface a
  {
    public abstract void onError(String paramString);
    
    public abstract void t(JSONObject paramJSONObject);
  }
  
  public static abstract interface b
  {
    public abstract void onCancel();
    
    public abstract void onError(String paramString);
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.d
 * JD-Core Version:    0.7.0.1
 */