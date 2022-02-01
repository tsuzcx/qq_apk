import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class aaus
  implements bjoe
{
  aaus(aaur paramaaur, MessageForShortVideo paramMessageForShortVideo, agnu paramagnu, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjnw.dismiss();
      return;
      this.jdField_a_of_type_Aaur.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      if ((NetworkUtil.isNetSupport(BaseApplication.getContext())) && (this.jdField_a_of_type_Agnu != null) && (this.jdField_a_of_type_Agnu.a != null))
      {
        this.jdField_a_of_type_Agnu.a.setFailedIconVisable(false, this.jdField_a_of_type_Aaur);
        aaur.a(this.jdField_a_of_type_Aaur, this.jdField_a_of_type_Agnu, ShortVideoUtils.getDisplayProgress(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress, 10), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaus
 * JD-Core Version:    0.7.0.1
 */