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

class aart
  implements aaru
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
  
  public boolean a(aarb paramaarb, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramaarb != null) {}
    GdtHandler.Options localOptions;
    for (Activity localActivity = paramaarb.a();; localActivity = null)
    {
      localOptions = new GdtHandler.Options();
      boolean bool = GdtHandler.a(localOptions, paramVarArgs[0]);
      if ((paramaarb != null) && (localActivity != null) && (bool)) {
        break;
      }
      aase.d("GdtInterstitialJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        aase.b("GdtInterstitialJsCallHandler", paramVarArgs.toString());
        int i = a(paramVarArgs.getJSONObject("options").optInt("orientation"));
        paramVarArgs = paramaarb.a().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key")))
        {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
          localOptions.jdField_a_of_type_AndroidOsBundle = new Bundle();
          localOptions.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramVarArgs);
          aase.b("GdtInterstitialJsCallHandler", String.format("handleJsCallRequest Source.KEY_REF_ID:%s", new Object[] { paramVarArgs }));
          paramVarArgs = new GdtInterstitialParams();
          paramVarArgs.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options = localOptions;
          paramVarArgs.jdField_a_of_type_Int = i;
          paramVarArgs.jdField_a_of_type_Boolean = true;
          i = GdtInterstitialFragment.a(localActivity, paramVarArgs);
          paramaarb.callJs(paramString, null);
          aasr.a(localActivity, paramVarArgs, i);
          paramString = localObject;
          if (paramaarb != null) {
            paramString = paramaarb.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, true, "showInterstitial", paramString, localOptions.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
          return true;
        }
      }
      catch (Throwable paramaarb)
      {
        aase.d("GdtInterstitialJsCallHandler", "handleJsCallRequest error", paramaarb);
        return true;
      }
      paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aart
 * JD-Core Version:    0.7.0.1
 */