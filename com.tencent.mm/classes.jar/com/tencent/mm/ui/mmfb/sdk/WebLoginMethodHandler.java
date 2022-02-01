package com.tencent.mm.ui.mmfb.sdk;

import android.os.Bundle;
import android.os.Parcel;
import java.util.Locale;

abstract class WebLoginMethodHandler
  extends LoginMethodHandler
{
  WebLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  WebLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  protected final Bundle a(Bundle paramBundle, LoginClient.Request paramRequest)
  {
    paramBundle.putString("redirect_uri", jBN());
    paramBundle.putString("client_id", paramRequest.afyt);
    paramBundle.putString("e2e", LoginClient.jBS());
    paramBundle.putString("response_type", "token,signed_request,graph_domain");
    paramBundle.putString("return_scopes", "true");
    paramBundle.putString("auth_type", "rerequest");
    paramBundle.putString("login_behavior", "NATIVE_WITH_FALLBACK");
    paramBundle.putString("sdk", String.format(Locale.ROOT, "android-%s", new Object[] { "android-8.2.0" }));
    if (jBO() != null) {
      paramBundle.putString("sso", "chrome_custom_tab");
    }
    paramBundle.putString("cct_prefetching", "0");
    return paramBundle;
  }
  
  protected String jBN()
  {
    return "fb290293790992170://authorize";
  }
  
  protected String jBO()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.WebLoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */