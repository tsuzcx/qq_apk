import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class aamy
  implements aanf
{
  private GdtDwellTimeStatisticsAfterClick a;
  
  public boolean a(aamm paramaamm, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramaamm != null) {}
    GdtHandler.Params localParams;
    for (Activity localActivity = paramaamm.a();; localActivity = null)
    {
      localParams = new GdtHandler.Params();
      boolean bool = GdtHandler.a(localParams, paramVarArgs[0]);
      if ((paramaamm != null) && (localActivity != null) && (bool)) {
        break;
      }
      aanp.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        aanp.b("GdtHandleAdJsCallHandler", new JSONObject(paramVarArgs[0]).toString());
        localParams.c = 7;
        localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localActivity);
        localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramaamm.a());
        localParams.jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
        localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
        paramVarArgs = paramaamm.a().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key")))
        {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
          localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
          localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramVarArgs);
          this.a = new GdtDwellTimeStatisticsAfterClick(localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd, new WeakReference(paramaamm.mRuntime.a()));
          this.a.a();
          GdtHandler.a(localParams);
          paramaamm.callJs(paramString, null);
          paramString = localObject;
          if (paramaamm != null) {
            paramString = paramaamm.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "handleClick", paramString, localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
          return true;
        }
      }
      catch (Throwable paramaamm)
      {
        aanp.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error", paramaamm);
        return true;
      }
      paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamy
 * JD-Core Version:    0.7.0.1
 */