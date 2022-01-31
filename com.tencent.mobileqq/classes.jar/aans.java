import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;

public class aans
{
  private aanr jdField_a_of_type_Aanr;
  private aant jdField_a_of_type_Aant;
  
  public aans(aant paramaant, aanr paramaanr)
  {
    aase.a("GdtAdBoxPresenter", "GdtAdBoxPresenter() called with: view = [" + paramaant + "], model = [" + paramaanr + "]");
    this.jdField_a_of_type_Aant = paramaant;
    this.jdField_a_of_type_Aanr = paramaanr;
    paramaanr.a(this);
  }
  
  public void a()
  {
    aase.a("GdtAdBoxPresenter", "onCreate() called");
    this.jdField_a_of_type_Aant.b(this.jdField_a_of_type_Aanr);
  }
  
  public void a(Activity paramActivity, View paramView, GdtAdBoxData paramGdtAdBoxData)
  {
    paramGdtAdBoxData = new GdtHandler.Params();
    GdtAppReceiver localGdtAppReceiver = new GdtAppReceiver();
    paramGdtAdBoxData.c = 11;
    paramGdtAdBoxData.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    paramActivity = paramView.getTag(2131367076);
    if (paramActivity == null)
    {
      aase.d("GdtAdBoxPresenter", "onClick() tag == null");
      return;
    }
    paramActivity = (GdtAd)paramActivity;
    aase.a("GdtAdBoxPresenter", "onClick() open url = [" + paramActivity.info.dest_info.landing_page.get() + "]");
    paramGdtAdBoxData.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramActivity;
    paramGdtAdBoxData.jdField_a_of_type_Boolean = true;
    paramGdtAdBoxData.jdField_b_of_type_Boolean = true;
    paramGdtAdBoxData.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localGdtAppReceiver);
    paramActivity = new Bundle();
    paramActivity.putString("big_brother_ref_source_key", "biz_src_miniapp");
    paramGdtAdBoxData.jdField_a_of_type_AndroidOsBundle = paramActivity;
    GdtHandler.a(paramGdtAdBoxData);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    aase.a("GdtAdBoxPresenter", "onResume() called");
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aans
 * JD-Core Version:    0.7.0.1
 */