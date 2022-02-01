import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class acll
  implements View.OnClickListener
{
  acll(acli paramacli, aclh paramaclh) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Acli;
    localObject = acli.a.onClick(paramView);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_Aclh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a = ((String)localObject);
      acqy.d("GdtBannerViewBuilder", "onclick:" + this.jdField_a_of_type_Aclh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a);
    }
    if (this.jdField_a_of_type_Aclh.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick != null) {
      this.jdField_a_of_type_Aclh.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick.a();
    }
    GdtHandler.a(this.jdField_a_of_type_Aclh.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acll
 * JD-Core Version:    0.7.0.1
 */