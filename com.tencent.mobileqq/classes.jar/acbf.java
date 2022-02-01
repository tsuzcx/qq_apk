import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class acbf
{
  private acbe jdField_a_of_type_Acbe;
  private acbg jdField_a_of_type_Acbg;
  
  public acbf(acbg paramacbg, acbe paramacbe)
  {
    acho.a("GdtAdBoxPresenter", "GdtAdBoxPresenter() called with: view = [" + paramacbg + "], model = [" + paramacbe + "]");
    this.jdField_a_of_type_Acbg = paramacbg;
    this.jdField_a_of_type_Acbe = paramacbe;
    paramacbe.a(this);
  }
  
  public void a()
  {
    acho.a("GdtAdBoxPresenter", "onCreate() called");
    this.jdField_a_of_type_Acbg.b(this.jdField_a_of_type_Acbe);
  }
  
  public void a(Activity paramActivity, View paramView, acdt paramacdt, acds paramacds)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    GdtAppReceiver localGdtAppReceiver = new GdtAppReceiver();
    localParams.c = 11;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    paramActivity = paramView.getTag(2131367584);
    if (paramActivity == null) {
      acho.d("GdtAdBoxPresenter", "onClick() tag == null");
    }
    do
    {
      return;
      paramActivity = (GdtAd)paramActivity;
      acho.a("GdtAdBoxPresenter", "onClick() open url = [" + paramActivity.info.dest_info.landing_page.get() + "]");
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramActivity;
      localParams.jdField_a_of_type_Boolean = true;
      localParams.jdField_b_of_type_Boolean = true;
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localGdtAppReceiver);
      paramActivity = new Bundle();
      paramActivity.putString("big_brother_ref_source_key", "biz_src_miniapp");
      localParams.jdField_a_of_type_AndroidOsBundle = paramActivity;
      paramView = null;
      paramActivity = paramView;
      if (localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info != null)
      {
        paramActivity = paramView;
        if (localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.report_info != null)
        {
          paramActivity = localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.report_info.click_url.get();
          paramView = paramacds.a(paramActivity, paramacdt);
          localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.report_info.click_url.set(paramView);
        }
      }
      GdtHandler.a(localParams);
    } while (TextUtils.isEmpty(paramActivity));
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.report_info.click_url.set(paramActivity);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    acho.a("GdtAdBoxPresenter", "onResume() called");
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbf
 * JD-Core Version:    0.7.0.1
 */