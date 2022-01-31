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

public class aeen
  extends QQStoryItemBuilder
{
  public aeen(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
    case 2131364984: 
      aanz.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131366632: 
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.troopstory.share", 2, "start forward from aio");
      }
      paramContext = new Bundle();
      vwp.a(localMessageForTroopStory, paramContext);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      aqbe.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
    case 2131370493: 
      super.a(paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  public void a(adxs paramadxs)
  {
    if ((paramadxs != null) && ((paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopStory)))
    {
      localObject = (MessageForTroopStory)paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!TextUtils.isEmpty(((MessageForTroopStory)localObject).storyId)) {
        break label33;
      }
    }
    label33:
    do
    {
      return;
      if ((!paramadxs.jdField_a_of_type_Boolean) && (axfa.b))
      {
        a(paramadxs, ((MessageForTroopStory)localObject).thumbUrl, ((MessageForTroopStory)localObject).storyId, ((MessageForTroopStory)localObject).uniseq, true);
        return;
      }
    } while (vzl.b());
    if (((MessageForTroopStory)localObject).istroop == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.troopstory", 2, "openTroopStoryVideo, enter=" + ((MessageForTroopStory)localObject).storyId);
      }
      localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1003).a();
      ((OpenPlayerBuilder.Data)localObject).mUIStyle.mPlayerRepeatMode = 2;
      tvc.a(this.jdField_b_of_type_AndroidContentContext, (OpenPlayerBuilder.Data)localObject, paramadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView);
      return;
    }
    Object localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1007);
    tvc.a(this.jdField_b_of_type_AndroidContentContext, ((OpenPlayerBuilder)localObject).a(), paramadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView);
  }
  
  public void a(adxs paramadxs, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramadxs, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if ((paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1) && ((paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopStory)) && (!bbbt.a().a(paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_obj")))
    {
      bbbt.a().a(paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_obj");
      vei.a("aio_msg", "play_msg_obj", 0, 0, new String[] { "", "", "", ((MessageForTroopStory)paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage).storyId });
    }
  }
  
  public void a(View paramView)
  {
    paramView = (MessageForTroopStory)((adxs)actj.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!paramView.isSendFromLocal()) {
      return;
    }
    bfpc localbfpc = (bfpc)bfpp.a(this.jdField_b_of_type_AndroidContentContext, null);
    localbfpc.a(2131689995, 5);
    localbfpc.c(2131690596);
    localbfpc.a(new aeeo(this, paramView, localbfpc));
    localbfpc.show();
  }
  
  public void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopStory)paramChatMessage;
    paramChatMessage.parse();
    adxs localadxs = (adxs)paramViewGroup.getTag();
    boolean bool = paramChatMessage.isSend();
    if (TextUtils.isEmpty(paramChatMessage.sourceName))
    {
      if (localadxs.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        localadxs.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      localadxs.b.setVisibility(8);
      if ((!TextUtils.isEmpty(paramChatMessage.storyId)) && (axfa.b)) {
        break label233;
      }
      localadxs.jdField_a_of_type_Boolean = false;
      localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localadxs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, paramChatMessage.thumbUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    }
    label233:
    do
    {
      return;
      if (localadxs.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        a(localadxs, paramViewGroup, bool);
      }
      paramViewGroup = (FrameLayout.LayoutParams)localadxs.c.getLayoutParams();
      if (bool) {}
      for (paramViewGroup.leftMargin = BaseChatItemLayout.j;; paramViewGroup.leftMargin = (baxn.a(this.jdField_b_of_type_AndroidContentContext, localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a) + BaseChatItemLayout.i))
      {
        localadxs.c.setLayoutParams(paramViewGroup);
        localadxs.c.setText(paramChatMessage.sourceName);
        localadxs.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        break;
      }
      paramViewGroup = (Long)localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == paramChatMessage.uniseq));
    localadxs.jdField_a_of_type_Boolean = false;
    localadxs.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    a(localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, paramChatMessage.thumbUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localadxs, paramChatMessage.thumbUrl, paramChatMessage.storyId, paramChatMessage.uniseq, false);
    localadxs.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setTag(Long.valueOf(paramChatMessage.uniseq));
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (((paramChatMessage instanceof MessageForTroopStory)) && (TextUtils.isEmpty(((MessageForTroopStory)paramChatMessage).storyId)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
      return true;
    }
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = (adxs)actj.a(paramView);
    boolean bool = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"));
    paramView = (MessageForTroopStory)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!TextUtils.isEmpty(paramView.storyId))
    {
      if (bool) {
        localbbmf.a(2131366632, this.jdField_b_of_type_AndroidContentContext.getString(2131692753), 2130838606);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView)) {
        a(localbbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
      }
    }
    a(localbbmf, paramView);
    super.e(localbbmf, this.jdField_b_of_type_AndroidContentContext);
    return localbbmf.a();
  }
  
  public void b(adxs paramadxs)
  {
    try
    {
      paramadxs = (MessageForTroopStory)paramadxs.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "storyMsg onSourceOnClick:" + paramadxs.toString() + ", sourceType = " + paramadxs.sourceActionData + ", sourceActionData = " + paramadxs.sourceActionData);
      }
      if ("plugin".equals(paramadxs.sourceActionType))
      {
        paramadxs = bbex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramadxs.sourceActionData);
        if (paramadxs != null) {
          paramadxs.c();
        }
      }
      return;
    }
    catch (Exception paramadxs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "storyMsg onSourceOnClick exp:", paramadxs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeen
 * JD-Core Version:    0.7.0.1
 */