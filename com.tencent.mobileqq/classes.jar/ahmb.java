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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

public class ahmb
  extends QQStoryItemBuilder
{
  public ahmb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
    case 2131365475: 
      admh.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131367213: 
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.troopstory.share", 2, "start forward from aio");
      }
      paramContext = new Bundle();
      zcl.a(localMessageForTroopStory, paramContext);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      aupt.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
    case 2131371641: 
      super.a(paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  public void a(ahen paramahen)
  {
    if ((paramahen != null) && ((paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopStory)))
    {
      localObject = (MessageForTroopStory)paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!TextUtils.isEmpty(((MessageForTroopStory)localObject).storyId)) {
        break label33;
      }
    }
    label33:
    do
    {
      return;
      if ((!paramahen.jdField_a_of_type_Boolean) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO))
      {
        a(paramahen, ((MessageForTroopStory)localObject).thumbUrl, ((MessageForTroopStory)localObject).storyId, ((MessageForTroopStory)localObject).uniseq, true);
        return;
      }
    } while (UIUtils.isFastDoubleClick());
    if (((MessageForTroopStory)localObject).istroop == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.troopstory", 2, "openTroopStoryVideo, enter=" + ((MessageForTroopStory)localObject).storyId);
      }
      localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1003).a();
      ((OpenPlayerBuilder.Data)localObject).mUIStyle.mPlayerRepeatMode = 2;
      xbp.a(this.jdField_b_of_type_AndroidContentContext, (OpenPlayerBuilder.Data)localObject, paramahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView);
      return;
    }
    Object localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1007);
    xbp.a(this.jdField_b_of_type_AndroidContentContext, ((OpenPlayerBuilder)localObject).a(), paramahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView);
  }
  
  public void a(ahen paramahen, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramahen, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if ((paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1) && ((paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopStory)) && (!bhbz.a().a(paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_obj")))
    {
      bhbz.a().a(paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_obj");
      ykv.a("aio_msg", "play_msg_obj", 0, 0, new String[] { "", "", "", ((MessageForTroopStory)paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage).storyId });
    }
  }
  
  public void a(View paramView)
  {
    paramView = (MessageForTroopStory)((ahen)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!paramView.isSendFromLocal()) {
      return;
    }
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_b_of_type_AndroidContentContext, null);
    localbkzi.a(2131689976, 5);
    localbkzi.c(2131690697);
    localbkzi.a(new ahmc(this, paramView, localbkzi));
    localbkzi.show();
  }
  
  public void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopStory)paramChatMessage;
    paramChatMessage.parse();
    ahen localahen = (ahen)paramViewGroup.getTag();
    boolean bool = paramChatMessage.isSend();
    if (TextUtils.isEmpty(paramChatMessage.sourceName))
    {
      if (localahen.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        localahen.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      localahen.b.setVisibility(8);
      if ((!TextUtils.isEmpty(paramChatMessage.storyId)) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO)) {
        break label233;
      }
      localahen.jdField_a_of_type_Boolean = false;
      localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localahen.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, paramChatMessage.thumbUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    }
    label233:
    do
    {
      return;
      if (localahen.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        a(localahen, paramViewGroup, bool);
      }
      paramViewGroup = (FrameLayout.LayoutParams)localahen.c.getLayoutParams();
      if (bool) {}
      for (paramViewGroup.leftMargin = BaseChatItemLayout.k;; paramViewGroup.leftMargin = (DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a) + BaseChatItemLayout.j))
      {
        localahen.c.setLayoutParams(paramViewGroup);
        localahen.c.setText(paramChatMessage.sourceName);
        localahen.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        break;
      }
      paramViewGroup = (Long)localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == paramChatMessage.uniseq));
    localahen.jdField_a_of_type_Boolean = false;
    localahen.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    a(localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, paramChatMessage.thumbUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localahen, paramChatMessage.thumbUrl, paramChatMessage.storyId, paramChatMessage.uniseq, false);
    localahen.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setTag(Long.valueOf(paramChatMessage.uniseq));
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (((paramChatMessage instanceof MessageForTroopStory)) && (TextUtils.isEmpty(((MessageForTroopStory)paramChatMessage).storyId)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramChatMessage))) {
      return true;
    }
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = (ahen)AIOUtils.getHolder(paramView);
    boolean bool = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"));
    paramView = (MessageForTroopStory)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!TextUtils.isEmpty(paramView.storyId))
    {
      if (bool) {
        localbhjq.a(2131367213, this.jdField_b_of_type_AndroidContentContext.getString(2131692550), 2130838991);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView)) {
        a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
      }
    }
    a(localbhjq, paramView);
    super.e(localbhjq, this.jdField_b_of_type_AndroidContentContext);
    return localbhjq.a();
  }
  
  public void b(ahen paramahen)
  {
    try
    {
      paramahen = (MessageForTroopStory)paramahen.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "storyMsg onSourceOnClick:" + paramahen.toString() + ", sourceType = " + paramahen.sourceActionData + ", sourceActionData = " + paramahen.sourceActionData);
      }
      if ("plugin".equals(paramahen.sourceActionType))
      {
        paramahen = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramahen.sourceActionData);
        if (paramahen != null) {
          paramahen.a();
        }
      }
      return;
    }
    catch (Exception paramahen)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "storyMsg onSourceOnClick exp:", paramahen);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmb
 * JD-Core Version:    0.7.0.1
 */