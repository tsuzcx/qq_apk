import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.widget.QQToastNotifier;

class adyp
  implements Runnable
{
  adyp(adyo paramadyo) {}
  
  public void run()
  {
    HotVideoData localHotVideoData = this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a();
    if ((localHotVideoData == null) || (this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.jdField_a_of_type_Int != 1) || (localHotVideoData.picIndex != this.a.a.jdField_a_of_type_Int))
    {
      new QQToastNotifier(this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a).a("视频插件安装成功", 100, 0, 2);
      return;
    }
    this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.c(this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder, this.a.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyp
 * JD-Core Version:    0.7.0.1
 */