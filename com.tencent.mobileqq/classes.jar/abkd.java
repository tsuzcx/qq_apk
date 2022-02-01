import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.device.msg.activities.DevShortVideoItemBuilder.1;
import com.tencent.device.msg.activities.DevShortVideoItemBuilder.2;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class abkd
  extends ahfz
  implements abhx
{
  public abkd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    if (paramChatMessage == null) {
      return null;
    }
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    ((abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramView, this);
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramViewGroup = (ahgk)AIOUtils.getHolder(paramView);
    if (paramChatMessage.videoFileStatus == 1005) {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    }
    for (;;)
    {
      return paramView;
      if (paramChatMessage.videoFileStatus == 1002)
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        a(paramViewGroup, ShortVideoUtils.getDisplayProgress(paramChatMessage.videoFileProgress, 10), false);
      }
      else
      {
        a(paramViewGroup);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
    }
  }
  
  protected void a(ahgk paramahgk)
  {
    paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    paramView = (ahgk)AIOUtils.getHolder(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbkzi.a(2131689976, 5);
      localbkzi.c(2131690697);
      localbkzi.a(new abke(this, localMessageForShortVideo, paramView, localbkzi));
      localbkzi.show();
    }
  }
  
  public void a(View paramView, abhy paramabhy)
  {
    paramView = (ahgk)AIOUtils.getHolder(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.uniseq != paramabhy.jdField_a_of_type_Long) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DeviceShortVideo", 2, "updateView msg.uniseq:" + localMessageForShortVideo.uniseq + " ===> fileStatus:" + ShortVideoUtils.getFileStatusStr(paramabhy.jdField_a_of_type_Int));
      }
      i = (int)(100.0F * paramabhy.jdField_a_of_type_Float);
      switch (paramabhy.jdField_a_of_type_Int)
      {
      case 1004: 
      default: 
        return;
      case 1001: 
        a(paramView, ShortVideoUtils.getDisplayProgress(i, 10), true);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
      case 1003: 
        a(paramView);
        b();
        return;
      case 1005: 
        b(paramView);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        return;
      }
    } while (!localMessageForShortVideo.isSendFromLocal());
    a(paramView, ShortVideoUtils.getDisplayProgress(i, 10), true);
    if (QLog.isColorLevel()) {
      QLog.d("DeviceShortVideo", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS, progress=" + i);
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    return;
    b(paramView);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    return;
    b(paramView);
    b();
    return;
    b(paramView);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718862, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
    return;
    b(paramView);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      paramMessageForShortVideo = Looper.getMainLooper();
      if (Thread.currentThread() == paramMessageForShortVideo.getThread())
      {
        audr.a(2131693647);
        return;
      }
      new Handler(paramMessageForShortVideo).post(new DevShortVideoItemBuilder.1(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceShortVideo", 2, "startUploadVideo");
    }
    ThreadManager.getFileThreadHandler().post(new DevShortVideoItemBuilder.2(this, paramMessageForShortVideo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkd
 * JD-Core Version:    0.7.0.1
 */