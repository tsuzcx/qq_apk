import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.ui.RoundProgressBar;
import com.tencent.mobileqq.intervideo.now.NowLoadingActivity;
import com.tencent.mobileqq.utils.ViewUtils;

public class aedi
  implements Runnable
{
  public aedi(NowLoadingActivity paramNowLoadingActivity, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setCircleColor(-12829636);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setRoundWidth(ViewUtils.b(10.0F));
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setTextSize(ViewUtils.b(43.0F));
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setPercentMarkTextSize(ViewUtils.b(43.0F));
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setCircleProgressColor(Color.parseColor("#50ffcd"));
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setProgress(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.jdField_a_of_type_ComTencentBizUiRoundProgressBar.setNeedShowProgreeText(false);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.b.setText(this.jdField_a_of_type_Int + "%");
    NowLoadingActivity.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity, this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.getString(2131430835), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedi
 * JD-Core Version:    0.7.0.1
 */