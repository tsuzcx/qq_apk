import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ahbk
  extends URLImageView
{
  public ahbk(ahaw paramahaw, Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(ahbj paramahbj)
  {
    if ((!EmoticonUtils.isWifiOrG3OrG4()) || (2 != paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (this.a.jdField_a_of_type_Asih.f(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)) || (!awsw.a()) || (EmoticonUtils.needDisableAutoReceiveMagicFace()))
    {
      float f = this.a.jdField_a_of_type_Asih.a(paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      if ((f < 0.0F) || (1.0F == f))
      {
        paramahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramahbj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
        }
      }
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (ahbj)AIOUtils.getHolder(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.c) {
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(anvx.a(2131705934));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ahbj localahbj = (ahbj)AIOUtils.getHolder(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localahbj == null)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  holder == null url=" + paramURLDrawable.getURL());
      return;
    }
    if (localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null)
    {
      paramURLDrawable = localahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!(paramURLDrawable instanceof MessageForMarketFace)) {
        break label434;
      }
      paramURLDrawable = ((MessageForMarketFace)paramURLDrawable).mMarkFaceMessage;
      if (paramURLDrawable == null) {
        break label434;
      }
    }
    label413:
    label432:
    label434:
    for (int i = paramURLDrawable.dwTabID;; i = -1)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  emoticonInfo == null epId = " + i);
      return;
      a(localahbj);
      this.a.a(localahbj, paramURLDrawable);
      if ((2 == localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (awsw.a()) && (this.a.jdField_a_of_type_Asih.f(localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)))
      {
        if (awrh.a(localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue) == 1) {
          localahbj.f.setVisibility(8);
        }
      }
      else
      {
        if ((4 == localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (this.a.jdField_a_of_type_Asih.b()) && (this.a.jdField_a_of_type_Asih.a(localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, true, true)) && (!this.a.jdField_b_of_type_Boolean))
        {
          localahbj.f.setImageResource(2130838053);
          localahbj.f.setVisibility(0);
        }
        if ((ahaw.c != 0L) && (ahaw.c == localahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()))
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
            break label413;
          }
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694935, 0).b(this.a.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label432;
        }
        localahbj.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        return;
        if (this.a.jdField_b_of_type_Boolean) {
          break;
        }
        localahbj.f.setImageResource(2130838053);
        localahbj.f.setVisibility(0);
        break;
        MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localahbj.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbk
 * JD-Core Version:    0.7.0.1
 */