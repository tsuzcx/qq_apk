import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import org.json.JSONObject;

class abqw
  implements abqx
{
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 0;
    }
    if (paramInt == 2) {
      return 8;
    }
    return -2147483648;
  }
  
  public boolean a(abqc paramabqc, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramabqc != null) {}
    GdtHandler.Options localOptions;
    for (Activity localActivity = paramabqc.a();; localActivity = null)
    {
      localOptions = new GdtHandler.Options();
      boolean bool = GdtHandler.a(localOptions, paramVarArgs[0]);
      if ((paramabqc != null) && (localActivity != null) && (bool)) {
        break;
      }
      abrl.d("GdtInterstitialJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        abrl.b("GdtInterstitialJsCallHandler", paramVarArgs.toString());
        paramVarArgs = paramVarArgs.getJSONObject("options");
        int i = paramVarArgs.optInt("style", 0);
        int j = a(paramVarArgs.optInt("orientation"));
        paramVarArgs = paramabqc.a().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key")))
        {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
          localOptions.jdField_a_of_type_AndroidOsBundle = new Bundle();
          localOptions.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramVarArgs);
          abrl.b("GdtInterstitialJsCallHandler", String.format("handleJsCallRequest Source.KEY_REF_ID:%s", new Object[] { paramVarArgs }));
          paramVarArgs = new GdtInterstitialParams();
          paramVarArgs.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options = localOptions;
          paramVarArgs.jdField_a_of_type_Int = i;
          paramVarArgs.b = j;
          paramVarArgs.jdField_a_of_type_Boolean = true;
          i = GdtInterstitialFragment.a(localActivity, paramVarArgs);
          paramabqc.callJs(paramString, null);
          absa.a(localActivity, paramVarArgs, i);
          paramString = localObject;
          if (paramabqc != null) {
            paramString = paramabqc.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, true, "showInterstitial", paramString, localOptions.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
          return true;
        }
      }
      catch (Throwable paramabqc)
      {
        abrl.d("GdtInterstitialJsCallHandler", "handleJsCallRequest error", paramabqc);
        return true;
      }
      paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqw
 * JD-Core Version:    0.7.0.1
 */