import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;

final class aaob
  implements View.OnClickListener
{
  aaob(aany paramaany, aanx paramaanx) {}
  
  public void onClick(View paramView)
  {
    aany localaany = this.jdField_a_of_type_Aany;
    paramView = aany.a.onClick(paramView);
    if (!TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Aanx.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a = paramView;
      aase.d("GdtBannerViewBuilder", "onclick:" + this.jdField_a_of_type_Aanx.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a);
    }
    if (this.jdField_a_of_type_Aanx.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick != null) {
      this.jdField_a_of_type_Aanx.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick.a();
    }
    GdtHandler.a(this.jdField_a_of_type_Aanx.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaob
 * JD-Core Version:    0.7.0.1
 */