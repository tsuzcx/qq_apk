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

class agit
  extends URLImageView
{
  public agit(agif paramagif, Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(agis paramagis)
  {
    if ((!EmoticonUtils.isWifiOrG3OrG4()) || (2 != paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (this.a.jdField_a_of_type_Areb.f(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)) || (!avmr.a()) || (EmoticonUtils.needDisableAutoReceiveMagicFace()))
    {
      float f = this.a.jdField_a_of_type_Areb.a(paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      if ((f < 0.0F) || (1.0F == f))
      {
        paramagis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramagis.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
        }
      }
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (agis)AIOUtils.getHolder(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.c) {
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(amtj.a(2131705583));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    agis localagis = (agis)AIOUtils.getHolder(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localagis == null)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  holder == null url=" + paramURLDrawable.getURL());
      return;
    }
    if (localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null)
    {
      paramURLDrawable = localagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
      a(localagis);
      this.a.a(localagis, paramURLDrawable);
      if ((2 == localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (avmr.a()) && (this.a.jdField_a_of_type_Areb.f(localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)))
      {
        if (avlc.a(localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue) == 1) {
          localagis.f.setVisibility(8);
        }
      }
      else
      {
        if ((4 == localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (this.a.jdField_a_of_type_Areb.b()) && (this.a.jdField_a_of_type_Areb.a(localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, true, true)) && (!this.a.jdField_b_of_type_Boolean))
        {
          localagis.f.setImageResource(2130838039);
          localagis.f.setVisibility(0);
        }
        if ((agif.c != 0L) && (agif.c == localagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()))
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
            break label413;
          }
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131694732, 0).b(this.a.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
        }
      }
      for (;;)
      {
        if (!AppSetting.c) {
          break label432;
        }
        localagis.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        return;
        if (this.a.jdField_b_of_type_Boolean) {
          break;
        }
        localagis.f.setImageResource(2130838039);
        localagis.f.setVisibility(0);
        break;
        MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localagis.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agit
 * JD-Core Version:    0.7.0.1
 */