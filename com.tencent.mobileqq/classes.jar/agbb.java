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

public class agbb
  extends QQStoryItemBuilder
{
  public agbb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
    case 2131365069: 
      acex.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131366750: 
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.troopstory.share", 2, "start forward from aio");
      }
      paramContext = new Bundle();
      xlh.a(localMessageForTroopStory, paramContext);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      arum.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
    case 2131370799: 
      super.a(paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  public void a(afuf paramafuf)
  {
    if ((paramafuf != null) && ((paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopStory)))
    {
      localObject = (MessageForTroopStory)paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!TextUtils.isEmpty(((MessageForTroopStory)localObject).storyId)) {
        break label33;
      }
    }
    label33:
    do
    {
      return;
      if ((!paramafuf.jdField_a_of_type_Boolean) && (azag.b))
      {
        a(paramafuf, ((MessageForTroopStory)localObject).thumbUrl, ((MessageForTroopStory)localObject).storyId, ((MessageForTroopStory)localObject).uniseq, true);
        return;
      }
    } while (xod.b());
    if (((MessageForTroopStory)localObject).istroop == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.troopstory", 2, "openTroopStoryVideo, enter=" + ((MessageForTroopStory)localObject).storyId);
      }
      localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1003).a();
      ((OpenPlayerBuilder.Data)localObject).mUIStyle.mPlayerRepeatMode = 2;
      vju.a(this.jdField_b_of_type_AndroidContentContext, (OpenPlayerBuilder.Data)localObject, paramafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView);
      return;
    }
    Object localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1007);
    vju.a(this.jdField_b_of_type_AndroidContentContext, ((OpenPlayerBuilder)localObject).a(), paramafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView);
  }
  
  public void a(afuf paramafuf, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramafuf, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if ((paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1) && ((paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopStory)) && (!bdan.a().a(paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_obj")))
    {
      bdan.a().a(paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_obj");
      wta.a("aio_msg", "play_msg_obj", 0, 0, new String[] { "", "", "", ((MessageForTroopStory)paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage).storyId });
    }
  }
  
  public void a(View paramView)
  {
    paramView = (MessageForTroopStory)((afuf)aekt.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!paramView.isSendFromLocal()) {
      return;
    }
    bhpy localbhpy = (bhpy)bhql.a(this.jdField_b_of_type_AndroidContentContext, null);
    localbhpy.a(2131690042, 5);
    localbhpy.c(2131690648);
    localbhpy.a(new agbc(this, paramView, localbhpy));
    localbhpy.show();
  }
  
  public void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopStory)paramChatMessage;
    paramChatMessage.parse();
    afuf localafuf = (afuf)paramViewGroup.getTag();
    boolean bool = paramChatMessage.isSend();
    if (TextUtils.isEmpty(paramChatMessage.sourceName))
    {
      if (localafuf.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        localafuf.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      localafuf.b.setVisibility(8);
      if ((!TextUtils.isEmpty(paramChatMessage.storyId)) && (azag.b)) {
        break label233;
      }
      localafuf.jdField_a_of_type_Boolean = false;
      localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localafuf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, paramChatMessage.thumbUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    }
    label233:
    do
    {
      return;
      if (localafuf.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        a(localafuf, paramViewGroup, bool);
      }
      paramViewGroup = (FrameLayout.LayoutParams)localafuf.c.getLayoutParams();
      if (bool) {}
      for (paramViewGroup.leftMargin = BaseChatItemLayout.j;; paramViewGroup.leftMargin = (bcwh.a(this.jdField_b_of_type_AndroidContentContext, localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a) + BaseChatItemLayout.i))
      {
        localafuf.c.setLayoutParams(paramViewGroup);
        localafuf.c.setText(paramChatMessage.sourceName);
        localafuf.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        break;
      }
      paramViewGroup = (Long)localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == paramChatMessage.uniseq));
    localafuf.jdField_a_of_type_Boolean = false;
    localafuf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    a(localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, paramChatMessage.thumbUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localafuf, paramChatMessage.thumbUrl, paramChatMessage.storyId, paramChatMessage.uniseq, false);
    localafuf.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setTag(Long.valueOf(paramChatMessage.uniseq));
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (((paramChatMessage instanceof MessageForTroopStory)) && (TextUtils.isEmpty(((MessageForTroopStory)paramChatMessage).storyId)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage))) {
      return true;
    }
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = (afuf)aekt.a(paramView);
    boolean bool = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"));
    paramView = (MessageForTroopStory)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!TextUtils.isEmpty(paramView.storyId))
    {
      if (bool) {
        localbdkz.a(2131366750, this.jdField_b_of_type_AndroidContentContext.getString(2131692835), 2130838677);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView)) {
        a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
      }
    }
    a(localbdkz, paramView);
    super.e(localbdkz, this.jdField_b_of_type_AndroidContentContext);
    return localbdkz.a();
  }
  
  public void b(afuf paramafuf)
  {
    try
    {
      paramafuf = (MessageForTroopStory)paramafuf.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "storyMsg onSourceOnClick:" + paramafuf.toString() + ", sourceType = " + paramafuf.sourceActionData + ", sourceActionData = " + paramafuf.sourceActionData);
      }
      if ("plugin".equals(paramafuf.sourceActionType))
      {
        paramafuf = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramafuf.sourceActionData);
        if (paramafuf != null) {
          paramafuf.c();
        }
      }
      return;
    }
    catch (Exception paramafuf)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "storyMsg onSourceOnClick exp:", paramafuf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbb
 * JD-Core Version:    0.7.0.1
 */