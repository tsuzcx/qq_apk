import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.hotpic.HotVideoData.HotVideoGetUrlCallBack;
import com.tencent.mobileqq.hotpic.HotVideoData.HotVideoGetUrlResult;
import com.tencent.qphone.base.util.QLog;

class adqp
  implements HotVideoData.HotVideoGetUrlCallBack
{
  adqp(adqo paramadqo, HotVideoData paramHotVideoData, HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, URLDrawable paramURLDrawable) {}
  
  public void a(HotVideoData.HotVideoGetUrlResult paramHotVideoGetUrlResult)
  {
    if (paramHotVideoGetUrlResult.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.url = paramHotVideoGetUrlResult.a();
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a() == this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
        this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "onFileDownloadFailed:" + this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.picIndex + " GetUrlFailed msg:" + paramHotVideoGetUrlResult.jdField_a_of_type_JavaLangString);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a() != this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a(-10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqp
 * JD-Core Version:    0.7.0.1
 */