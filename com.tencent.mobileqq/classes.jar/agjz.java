import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.PokeEmoItemBuilder.1;
import com.tencent.mobileqq.activity.aio.stickerbubble.PokeEmoItemView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleReceiverAnimationRunnable;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class agjz
  extends BaseBubbleBuilder
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StickerBubbleReceiverAnimationRunnable jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable;
  protected long c;
  
  public agjz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(agkb paramagkb, MessageForPokeEmo paramMessageForPokeEmo)
  {
    int i = paramMessageForPokeEmo.pokeemoId;
    int j = paramMessageForPokeEmo.pokeemoPressCount;
    paramagkb.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramMessageForPokeEmo;
    agkg.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool = agkg.b;
    if (bool)
    {
      Drawable localDrawable = ahly.a(i);
      paramagkb.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable(localDrawable);
      paramagkb.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setText("x" + Integer.toString(paramMessageForPokeEmo.pokeemoPressCount));
      paramagkb.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setIsSend(paramMessageForPokeEmo.isSend());
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, String.format(" initBubbleView.forbidPoke=%b,isResDownload = %b,pokeMsg.isPlay = %b,animatingCount = %d,emoId = %d", new Object[] { Boolean.valueOf(AIOUtils.isForbidPokeMessageAnimationPlay), Boolean.valueOf(bool), Boolean.valueOf(paramMessageForPokeEmo.isNeedPlayed), Integer.valueOf(AIOUtils.pokeEmoAnimatingCount), Integer.valueOf(paramMessageForPokeEmo.pokeemoId) }));
      }
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "sGesturePWDUnlockShowing: " + GesturePWDUnlockActivity.c);
      }
      if (!AIOUtils.isForbidPokeMessageAnimationPlay) {
        break label269;
      }
    }
    label269:
    label397:
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841511);
        }
        paramagkb.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramagkb.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setText("x" + paramMessageForPokeEmo.pokeemoPressCount * 1000);
        break;
        if ((!bool) || (paramMessageForPokeEmo.isSend()) || (!paramMessageForPokeEmo.isNeedPlayed) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) || (GesturePWDUnlockActivity.c)) {
          break label397;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PokeEmoItemBuilder", 2, "show animation from item builder");
        }
        AIOUtils.pokeEmoAnimatingCount += 1;
        paramMessageForPokeEmo.setIsNeedPlayed(false);
        paramagkb = ((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362294);
      } while (paramagkb == null);
      paramMessageForPokeEmo = ahly.b(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable = new StickerBubbleReceiverAnimationRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, paramagkb, paramMessageForPokeEmo);
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable);
      return;
    } while (paramMessageForPokeEmo.isNeedPlayed);
    paramMessageForPokeEmo.setIsNeedPlayed(false);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aezf a()
  {
    return new agkb(this);
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    paramBaseChatItemLayout = (MessageForPokeEmo)paramChatMessage;
    agkb localagkb = (agkb)paramaezf;
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "type: " + paramBaseChatItemLayout.pokeemoId + " count: " + paramBaseChatItemLayout.pokeemoPressCount);
    }
    paramaezf = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "[getBubbleView]:content is null");
      }
      paramaezf = new RelativeLayout((Context)localObject);
      paramaezf.setId(2131376679);
      paramView = new PokeEmoItemView((Context)localObject);
      paramView.setId(2131372829);
      paramaezf.addView(paramView, new ViewGroup.LayoutParams(-1, AIOUtils.dp2px(80.0F, ((Context)localObject).getResources())));
      localagkb.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView = paramView;
      localObject = ahly.a;
      if (localObject != null)
      {
        QLog.e("PokeEmoItemBuilder", 1, "mTypeface  != null ");
        paramView.setTypeFace((Typeface)localObject);
        paramView.setText("x3");
        bfpm.a(paramView, false);
      }
    }
    else
    {
      if ((!localagkb.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.a()) && (ahly.a != null)) {
        localagkb.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setTypeFace(ahly.a);
      }
      if ("PEPanelHelper.mTypeface != null :" + ahly.a == null) {
        break label358;
      }
    }
    label358:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("PokeEmoItemBuilder", 1, new Object[] { Boolean.valueOf(bool) });
      paramaezf.setTag(localagkb);
      paramaezf.setOnTouchListener(paramafce);
      paramaezf.setOnLongClickListener(paramafce);
      a(localagkb, paramBaseChatItemLayout);
      if (e)
      {
        if ((localagkb.b != null) && (localagkb.b.length() > 0)) {
          localagkb.b.setLength(0);
        }
        paramaezf.setContentDescription(a(paramChatMessage));
      }
      return paramaezf;
      if ((!agkg.b) || (ahly.b)) {
        break;
      }
      ahly.b = true;
      ThreadManager.executeOnSubThread(new PokeEmoItemBuilder.1(this));
      break;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bfzl.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    MessageForPokeEmo localMessageForPokeEmo = (MessageForPokeEmo)paramChatMessage;
    if (paramChatMessage.isSend()) {
      localStringBuilder.append("我向" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick + String.format("发出%d个轻互动表情%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localMessageForPokeEmo.summary }));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick + String.format("发来%d个轻互动表情%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localMessageForPokeEmo.summary }));
    }
  }
  
  public void a()
  {
    super.a();
    AIOUtils.pokeEmoAnimatingCount = 0;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365382: 
      acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.getMessage(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPokeEmo)AIOUtils.getMessage(paramView);
    } while (!paramView.isSendFromLocal());
    bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbjnw.a(2131689947, 5);
    localbjnw.c(2131690620);
    localbjnw.a(new agka(this, paramView, localbjnw));
    localbjnw.show();
  }
  
  public bgbb[] a(View paramView)
  {
    bgaz localbgaz = new bgaz();
    paramView = (aezy)AIOUtils.getHolder(paramView);
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPokeEmo)) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 0)) {
      a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbgaz);
    }
    acvv.a(localbgaz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.e(localbgaz, this.jdField_a_of_type_AndroidContentContext);
    return localbgaz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjz
 * JD-Core Version:    0.7.0.1
 */