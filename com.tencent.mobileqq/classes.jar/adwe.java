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

public class adwe
  extends BaseBubbleBuilder
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StickerBubbleReceiverAnimationRunnable jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable;
  protected long c;
  
  public adwe(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(adwg paramadwg, MessageForPokeEmo paramMessageForPokeEmo)
  {
    int i = paramMessageForPokeEmo.pokeemoId;
    int j = paramMessageForPokeEmo.pokeemoPressCount;
    paramadwg.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramMessageForPokeEmo;
    adwl.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool = adwl.b;
    if (bool)
    {
      Drawable localDrawable = aevl.a(i);
      paramadwg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable(localDrawable);
      paramadwg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setText("x" + Integer.toString(paramMessageForPokeEmo.pokeemoPressCount));
      paramadwg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setIsSend(paramMessageForPokeEmo.isSend());
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, String.format(" initBubbleView.forbidPoke=%b,isResDownload = %b,pokeMsg.isPlay = %b,animatingCount = %d,emoId = %d", new Object[] { Boolean.valueOf(actn.k), Boolean.valueOf(bool), Boolean.valueOf(paramMessageForPokeEmo.isNeedPlayed), Integer.valueOf(actn.b), Integer.valueOf(paramMessageForPokeEmo.pokeemoId) }));
      }
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "sGesturePWDUnlockShowing: " + GesturePWDUnlockActivity.c);
      }
      if (!actn.k) {
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
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841045);
        }
        paramadwg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramadwg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setText("x" + paramMessageForPokeEmo.pokeemoPressCount * 1000);
        break;
        if ((!bool) || (paramMessageForPokeEmo.isSend()) || (!paramMessageForPokeEmo.isNeedPlayed) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) || (GesturePWDUnlockActivity.c)) {
          break label397;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PokeEmoItemBuilder", 2, "show animation from item builder");
        }
        actn.b += 1;
        paramMessageForPokeEmo.setIsNeedPlayed(false);
        paramadwg = ((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362189);
      } while (paramadwg == null);
      paramMessageForPokeEmo = aevl.b(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable = new StickerBubbleReceiverAnimationRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, paramadwg, paramMessageForPokeEmo);
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable);
      return;
    } while (paramMessageForPokeEmo.isNeedPlayed);
    paramMessageForPokeEmo.setIsNeedPlayed(false);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acun a()
  {
    return new adwg(this);
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    paramBaseChatItemLayout = (MessageForPokeEmo)paramChatMessage;
    adwg localadwg = (adwg)paramacun;
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "type: " + paramBaseChatItemLayout.pokeemoId + " count: " + paramBaseChatItemLayout.pokeemoPressCount);
    }
    paramacun = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "[getBubbleView]:content is null");
      }
      paramacun = new RelativeLayout((Context)localObject);
      paramacun.setId(2131375491);
      paramView = new PokeEmoItemView((Context)localObject);
      paramView.setId(2131371833);
      paramacun.addView(paramView, new ViewGroup.LayoutParams(-1, actn.a(80.0F, ((Context)localObject).getResources())));
      localadwg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView = paramView;
      localObject = aevl.a;
      if (localObject != null)
      {
        QLog.e("PokeEmoItemBuilder", 1, "mTypeface  != null ");
        paramView.setTypeFace((Typeface)localObject);
        paramView.setText("x3");
        bawi.a(paramView, false);
      }
    }
    else
    {
      if ((!localadwg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.a()) && (aevl.a != null)) {
        localadwg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setTypeFace(aevl.a);
      }
      if ("PEPanelHelper.mTypeface != null :" + aevl.a == null) {
        break label358;
      }
    }
    label358:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("PokeEmoItemBuilder", 1, new Object[] { Boolean.valueOf(bool) });
      paramacun.setTag(localadwg);
      paramacun.setOnTouchListener(paramacxn);
      paramacun.setOnLongClickListener(paramacxn);
      a(localadwg, paramBaseChatItemLayout);
      if (e)
      {
        if ((localadwg.b != null) && (localadwg.b.length() > 0)) {
          localadwg.b.setLength(0);
        }
        paramacun.setContentDescription(a(paramChatMessage));
      }
      return paramacun;
      if ((!adwl.b) || (aevl.b)) {
        break;
      }
      aevl.b = true;
      ThreadManager.executeOnSubThread(new PokeEmoItemBuilder.1(this));
      break;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bbkb.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    MessageForPokeEmo localMessageForPokeEmo = (MessageForPokeEmo)paramChatMessage;
    if (paramChatMessage.isSend()) {
      localStringBuilder.append("我向" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + String.format("发出%d个轻互动表情%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localMessageForPokeEmo.summary }));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + String.format("发来%d个轻互动表情%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localMessageForPokeEmo.summary }));
    }
  }
  
  public void a()
  {
    super.a();
    actn.b = 0;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131364985: 
      aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (actn.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPokeEmo)actn.a(paramView);
    } while (!paramView.isSendFromLocal());
    bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbfol.a(2131689995, 5);
    localbfol.c(2131690596);
    localbfol.a(new adwf(this, paramView, localbfol));
    localbfol.show();
  }
  
  public bblt[] a(View paramView)
  {
    bblr localbblr = new bblr();
    paramView = (acve)actn.a(paramView);
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPokeEmo)) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 0)) {
      a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbblr);
    }
    aaod.a(localbblr, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
    return localbblr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwe
 * JD-Core Version:    0.7.0.1
 */