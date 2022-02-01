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

public class aclc
{
  private aclb jdField_a_of_type_Aclb;
  private acld jdField_a_of_type_Acld;
  
  public aclc(acld paramacld, aclb paramaclb)
  {
    acqy.a("GdtAdBoxPresenter", "GdtAdBoxPresenter() called with: view = [" + paramacld + "], model = [" + paramaclb + "]");
    this.jdField_a_of_type_Acld = paramacld;
    this.jdField_a_of_type_Aclb = paramaclb;
    paramaclb.a(this);
  }
  
  public void a()
  {
    acqy.a("GdtAdBoxPresenter", "onCreate() called");
    this.jdField_a_of_type_Acld.b(this.jdField_a_of_type_Aclb);
  }
  
  public void a(Activity paramActivity, View paramView, acnu paramacnu, acnt paramacnt)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    GdtAppReceiver localGdtAppReceiver = new GdtAppReceiver();
    localParams.c = 11;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    paramActivity = paramView.getTag(2131367365);
    if (paramActivity == null) {
      acqy.d("GdtAdBoxPresenter", "onClick() tag == null");
    }
    do
    {
      return;
      paramActivity = (GdtAd)paramActivity;
      acqy.a("GdtAdBoxPresenter", "onClick() open url = [" + paramActivity.info.dest_info.landing_page.get() + "]");
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
          paramView = paramacnt.a(paramActivity, paramacnu);
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
    acqy.a("GdtAdBoxPresenter", "onResume() called");
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclc
 * JD-Core Version:    0.7.0.1
 */