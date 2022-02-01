import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.StoryChatVideoView;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

public class ahwp
  extends QQStoryItemBuilder
{
  public ahwp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForTroopStory localMessageForTroopStory = (MessageForTroopStory)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365352: 
      aean.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131367078: 
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.troopstory.share", 2, "start forward from aio");
      }
      paramContext = new Bundle();
      zmw.a(localMessageForTroopStory, paramContext);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      auxu.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
    case 2131371487: 
      super.a(paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  public void a(ahpk paramahpk)
  {
    if ((paramahpk != null) && ((paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopStory)))
    {
      localObject = (MessageForTroopStory)paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!TextUtils.isEmpty(((MessageForTroopStory)localObject).storyId)) {
        break label33;
      }
    }
    label33:
    do
    {
      return;
      if ((!paramahpk.jdField_a_of_type_Boolean) && (bcyh.b))
      {
        a(paramahpk, ((MessageForTroopStory)localObject).thumbUrl, ((MessageForTroopStory)localObject).storyId, ((MessageForTroopStory)localObject).uniseq, true);
        return;
      }
    } while (zps.b());
    if (((MessageForTroopStory)localObject).istroop == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.troopstory", 2, "openTroopStoryVideo, enter=" + ((MessageForTroopStory)localObject).storyId);
      }
      localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1003).a();
      ((OpenPlayerBuilder.Data)localObject).mUIStyle.mPlayerRepeatMode = 2;
      xlj.a(this.jdField_b_of_type_AndroidContentContext, (OpenPlayerBuilder.Data)localObject, paramahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView);
      return;
    }
    Object localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1007);
    xlj.a(this.jdField_b_of_type_AndroidContentContext, ((OpenPlayerBuilder)localObject).a(), paramahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView);
  }
  
  public void a(ahpk paramahpk, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramahpk, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if ((paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1) && ((paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopStory)) && (!bhjz.a().a(paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_obj")))
    {
      bhjz.a().a(paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_obj");
      yup.a("aio_msg", "play_msg_obj", 0, 0, new String[] { "", "", "", ((MessageForTroopStory)paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage).storyId });
    }
  }
  
  public void a(View paramView)
  {
    paramView = (MessageForTroopStory)((ahpk)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!paramView.isSendFromLocal()) {
      return;
    }
    blir localblir = (blir)blji.a(this.jdField_b_of_type_AndroidContentContext, null);
    localblir.a(2131689933, 5);
    localblir.c(2131690580);
    localblir.a(new ahwq(this, paramView, localblir));
    localblir.show();
  }
  
  public void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopStory)paramChatMessage;
    paramChatMessage.parse();
    ahpk localahpk = (ahpk)paramViewGroup.getTag();
    boolean bool = paramChatMessage.isSend();
    if (TextUtils.isEmpty(paramChatMessage.sourceName))
    {
      if (localahpk.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        localahpk.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      localahpk.b.setVisibility(8);
      if ((!TextUtils.isEmpty(paramChatMessage.storyId)) && (bcyh.b)) {
        break label233;
      }
      localahpk.jdField_a_of_type_Boolean = false;
      localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localahpk.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, paramChatMessage.thumbUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    }
    label233:
    do
    {
      return;
      if (localahpk.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        a(localahpk, paramViewGroup, bool);
      }
      paramViewGroup = (FrameLayout.LayoutParams)localahpk.c.getLayoutParams();
      if (bool) {}
      for (paramViewGroup.leftMargin = BaseChatItemLayout.k;; paramViewGroup.leftMargin = (bhgr.a(this.jdField_b_of_type_AndroidContentContext, localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a) + BaseChatItemLayout.j))
      {
        localahpk.c.setLayoutParams(paramViewGroup);
        localahpk.c.setText(paramChatMessage.sourceName);
        localahpk.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        break;
      }
      paramViewGroup = (Long)localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == paramChatMessage.uniseq));
    localahpk.jdField_a_of_type_Boolean = false;
    localahpk.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    a(localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, paramChatMessage.thumbUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localahpk, paramChatMessage.thumbUrl, paramChatMessage.storyId, paramChatMessage.uniseq, false);
    localahpk.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setTag(Long.valueOf(paramChatMessage.uniseq));
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (((paramChatMessage instanceof MessageForTroopStory)) && (TextUtils.isEmpty(((MessageForTroopStory)paramChatMessage).storyId)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
      return true;
    }
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    paramView = (ahpk)agej.a(paramView);
    boolean bool = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"));
    paramView = (MessageForTroopStory)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!TextUtils.isEmpty(paramView.storyId))
    {
      if (bool) {
        localbhuk.a(2131367078, this.jdField_b_of_type_AndroidContentContext.getString(2131692400), 2130838939);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView)) {
        a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
      }
    }
    a(localbhuk, paramView);
    super.e(localbhuk, this.jdField_b_of_type_AndroidContentContext);
    return localbhuk.a();
  }
  
  public void b(ahpk paramahpk)
  {
    try
    {
      paramahpk = (MessageForTroopStory)paramahpk.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "storyMsg onSourceOnClick:" + paramahpk.toString() + ", sourceType = " + paramahpk.sourceActionData + ", sourceActionData = " + paramahpk.sourceActionData);
      }
      if ("plugin".equals(paramahpk.sourceActionType))
      {
        paramahpk = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramahpk.sourceActionData);
        if (paramahpk != null) {
          paramahpk.a();
        }
      }
      return;
    }
    catch (Exception paramahpk)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "storyMsg onSourceOnClick exp:", paramahpk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwp
 * JD-Core Version:    0.7.0.1
 */