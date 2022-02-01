import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.device.msg.activities.DevShortVideoItemBuilder.1;
import com.tencent.device.msg.activities.DevShortVideoItemBuilder.2;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class abyi
  extends ahqw
  implements abwc
{
  public abyi(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    if (paramChatMessage == null) {
      return null;
    }
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    ((abzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramView, this);
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramViewGroup = (ahrh)agej.a(paramView);
    if (paramChatMessage.videoFileStatus == 1005) {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    }
    for (;;)
    {
      return paramView;
      if (paramChatMessage.videoFileStatus == 1002)
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        a(paramViewGroup, ShortVideoUtils.a(paramChatMessage.videoFileProgress, 10), false);
      }
      else
      {
        a(paramViewGroup);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
    }
  }
  
  protected void a(ahrh paramahrh)
  {
    paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    paramView = (ahrh)agej.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
      localblir.a(2131689933, 5);
      localblir.c(2131690580);
      localblir.a(new abyj(this, localMessageForShortVideo, paramView, localblir));
      localblir.show();
    }
  }
  
  public void a(View paramView, abwd paramabwd)
  {
    paramView = (ahrh)agej.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.uniseq != paramabwd.jdField_a_of_type_Long) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DeviceShortVideo", 2, "updateView msg.uniseq:" + localMessageForShortVideo.uniseq + " ===> fileStatus:" + ShortVideoUtils.b(paramabwd.jdField_a_of_type_Int));
      }
      i = (int)(100.0F * paramabwd.jdField_a_of_type_Float);
      switch (paramabwd.jdField_a_of_type_Int)
      {
      case 1004: 
      default: 
        return;
      case 1001: 
        a(paramView, ShortVideoUtils.a(i, 10), true);
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
    a(paramView, ShortVideoUtils.a(i, 10), true);
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
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718235, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
    return;
    b(paramView);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!bhnv.d(BaseApplication.getContext()))
    {
      paramMessageForShortVideo = Looper.getMainLooper();
      if (Thread.currentThread() == paramMessageForShortVideo.getThread())
      {
        auna.a(2131693371);
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
 * Qualified Name:     abyi
 * JD-Core Version:    0.7.0.1
 */