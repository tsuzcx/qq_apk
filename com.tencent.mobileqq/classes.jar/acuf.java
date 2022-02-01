import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtBaseHalfScreenFragmentForJs;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class acuf
  implements acun
{
  private GdtDwellTimeStatisticsAfterClick a;
  
  public boolean a(acts paramacts, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramacts != null) {}
    GdtHandler.Params localParams;
    for (Activity localActivity = paramacts.a();; localActivity = null)
    {
      localParams = new GdtHandler.Params();
      boolean bool = GdtHandler.a(localParams, paramVarArgs[0]);
      if ((paramacts != null) && (localActivity != null) && (bool)) {
        break;
      }
      acvc.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        acvc.b("GdtHandleAdJsCallHandler", new JSONObject(paramVarArgs[0]).toString());
        localParams.jdField_c_of_type_Int = 7;
        localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localActivity);
        localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramacts.a());
        localParams.jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
        localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
        localParams.jdField_c_of_type_JavaLangClass = GdtBaseHalfScreenFragmentForJs.class;
        paramVarArgs = paramacts.a().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key")))
        {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
          localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
          localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramVarArgs);
          this.a = new GdtDwellTimeStatisticsAfterClick(localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd, new WeakReference(paramacts.mRuntime.a()));
          this.a.a();
          GdtHandler.a(localParams);
          paramacts.callJs(paramString, null);
          paramString = localObject;
          if (paramacts != null) {
            paramString = paramacts.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "handleClick", paramString, localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
          return true;
        }
      }
      catch (Throwable paramacts)
      {
        acvc.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error", paramacts);
        return true;
      }
      paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acuf
 * JD-Core Version:    0.7.0.1
 */