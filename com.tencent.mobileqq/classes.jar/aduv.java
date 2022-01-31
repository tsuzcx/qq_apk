import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.mobileqq.intervideo.now.NowLoadingActivity;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.mobileqq.intervideo.now.NowProxy;

public class aduv
  implements View.OnClickListener
{
  public aduv(NowLoadingActivity paramNowLoadingActivity, NowProxy paramNowProxy) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.d = false;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.a.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowProxy.a.a.a();
      NowLoadingActivity.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowLoadingActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduv
 * JD-Core Version:    0.7.0.1
 */