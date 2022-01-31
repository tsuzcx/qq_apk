import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.hotpic.HotVideoData.HotVideoGetUrlCallBack;
import com.tencent.mobileqq.hotpic.HotVideoData.HotVideoGetUrlResult;
import com.tencent.mobileqq.widget.QQToastNotifier;

public class adgm
  implements HotVideoData.HotVideoGetUrlCallBack
{
  public adgm(HotPicPageView paramHotPicPageView, HotVideoData paramHotVideoData, HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder) {}
  
  public void a(HotVideoData.HotVideoGetUrlResult paramHotVideoGetUrlResult)
  {
    if (paramHotVideoGetUrlResult.a)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.originalUrl = paramHotVideoGetUrlResult.a();
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a == 1) {}
    }
    while (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a != 1)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new adgn(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a(-11);
    new QQToastNotifier(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_AndroidContentContext).a("网络错误，请稍后重试", 100, 0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adgm
 * JD-Core Version:    0.7.0.1
 */