package com.tencent.mm.ui.g.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.login.LoginManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Calendar;

public final class d
{
  long AnR;
  public AccessToken AnY;
  private CallbackManager AnZ;
  d.b Aoa;
  private FacebookCallback Aob;
  private final String mAppId;
  
  public d(String paramString)
  {
    AppMethodBeat.i(80314);
    this.Aob = new d.1(this);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
      AppMethodBeat.o(80314);
      throw paramString;
    }
    this.mAppId = paramString;
    AppMethodBeat.o(80314);
  }
  
  private static void dNh()
  {
    AppMethodBeat.i(80316);
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
      AppMethodBeat.o(80316);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.FacebookAndroid", localException.getMessage());
      RuntimeException localRuntimeException = new RuntimeException(localException);
      AppMethodBeat.o(80316);
      throw localRuntimeException;
    }
  }
  
  public final void a(Activity paramActivity, d.b paramb, String[] paramArrayOfString)
  {
    AppMethodBeat.i(80317);
    LoginManager.getInstance().registerCallback(this.AnZ, this.Aob);
    this.Aoa = paramb;
    LoginManager.getInstance().logInWithReadPermissions(paramActivity, Arrays.asList(paramArrayOfString));
    AppMethodBeat.o(80317);
  }
  
  public final void a(String paramString, d.a parama)
  {
    AppMethodBeat.i(80318);
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", paramString);
    new GraphRequest(this.AnY, "me", localBundle, HttpMethod.GET, new d.2(this, parama)).executeAsync();
    AppMethodBeat.o(80318);
  }
  
  public final boolean dNf()
  {
    AppMethodBeat.i(80319);
    if ((this.AnY != null) && ((this.AnR == 0L) || (System.currentTimeMillis() < this.AnR)))
    {
      AppMethodBeat.o(80319);
      return true;
    }
    AppMethodBeat.o(80319);
    return false;
  }
  
  public final void dNg()
  {
    AppMethodBeat.i(80315);
    dNh();
    FacebookSdk.setApplicationId(this.mAppId);
    FacebookSdk.sdkInitialize(ah.getContext());
    ab.i("MicroMsg.FacebookAndroid", "installerPkg %s", new Object[] { AttributionIdentifiers.getAttributionIdentifiers(ah.getContext()).getAndroidInstallerPackage() });
    this.AnZ = CallbackManager.Factory.create();
    AppMethodBeat.o(80315);
  }
  
  public final void h(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(80320);
    if (this.AnZ != null) {
      this.AnZ.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(80320);
  }
  
  public final void logout()
  {
    AppMethodBeat.i(80321);
    this.AnY = null;
    this.AnR = 0L;
    this.Aoa = null;
    LoginManager.getInstance().logOut();
    AppMethodBeat.o(80321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.d
 * JD-Core Version:    0.7.0.1
 */