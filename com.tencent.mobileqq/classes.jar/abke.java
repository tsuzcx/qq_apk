import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class abke
  implements bkzq
{
  abke(abkd paramabkd, MessageForShortVideo paramMessageForShortVideo, ahgk paramahgk, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
      this.jdField_a_of_type_Abkd.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      if ((NetworkUtil.isNetSupport(BaseApplication.getContext())) && (this.jdField_a_of_type_Ahgk != null) && (this.jdField_a_of_type_Ahgk.a != null))
      {
        this.jdField_a_of_type_Ahgk.a.setFailedIconVisable(false, this.jdField_a_of_type_Abkd);
        abkd.a(this.jdField_a_of_type_Abkd, this.jdField_a_of_type_Ahgk, ShortVideoUtils.getDisplayProgress(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress, 10), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abke
 * JD-Core Version:    0.7.0.1
 */