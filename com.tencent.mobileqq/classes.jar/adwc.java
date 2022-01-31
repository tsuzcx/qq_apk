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

public class adwc
  extends BaseBubbleBuilder
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StickerBubbleReceiverAnimationRunnable jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable;
  protected long c;
  
  public adwc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(adwe paramadwe, MessageForPokeEmo paramMessageForPokeEmo)
  {
    int i = paramMessageForPokeEmo.pokeemoId;
    int j = paramMessageForPokeEmo.pokeemoPressCount;
    paramadwe.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramMessageForPokeEmo;
    adwj.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool = adwj.b;
    if (bool)
    {
      Drawable localDrawable = aevj.a(i);
      paramadwe.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable(localDrawable);
      paramadwe.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setText("x" + Integer.toString(paramMessageForPokeEmo.pokeemoPressCount));
      paramadwe.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setIsSend(paramMessageForPokeEmo.isSend());
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, String.format(" initBubbleView.forbidPoke=%b,isResDownload = %b,pokeMsg.isPlay = %b,animatingCount = %d,emoId = %d", new Object[] { Boolean.valueOf(actj.k), Boolean.valueOf(bool), Boolean.valueOf(paramMessageForPokeEmo.isNeedPlayed), Integer.valueOf(actj.b), Integer.valueOf(paramMessageForPokeEmo.pokeemoId) }));
      }
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "sGesturePWDUnlockShowing: " + GesturePWDUnlockActivity.c);
      }
      if (!actj.k) {
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
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841042);
        }
        paramadwe.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramadwe.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setText("x" + paramMessageForPokeEmo.pokeemoPressCount * 1000);
        break;
        if ((!bool) || (paramMessageForPokeEmo.isSend()) || (!paramMessageForPokeEmo.isNeedPlayed) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) || (GesturePWDUnlockActivity.c)) {
          break label397;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PokeEmoItemBuilder", 2, "show animation from item builder");
        }
        actj.b += 1;
        paramMessageForPokeEmo.setIsNeedPlayed(false);
        paramadwe = ((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362188);
      } while (paramadwe == null);
      paramMessageForPokeEmo = aevj.b(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable = new StickerBubbleReceiverAnimationRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, paramadwe, paramMessageForPokeEmo);
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable);
      return;
    } while (paramMessageForPokeEmo.isNeedPlayed);
    paramMessageForPokeEmo.setIsNeedPlayed(false);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return new adwe(this);
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    paramBaseChatItemLayout = (MessageForPokeEmo)paramChatMessage;
    adwe localadwe = (adwe)paramacuj;
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "type: " + paramBaseChatItemLayout.pokeemoId + " count: " + paramBaseChatItemLayout.pokeemoPressCount);
    }
    paramacuj = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "[getBubbleView]:content is null");
      }
      paramacuj = new RelativeLayout((Context)localObject);
      paramacuj.setId(2131375493);
      paramView = new PokeEmoItemView((Context)localObject);
      paramView.setId(2131371833);
      paramacuj.addView(paramView, new ViewGroup.LayoutParams(-1, actj.a(80.0F, ((Context)localObject).getResources())));
      localadwe.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView = paramView;
      localObject = aevj.a;
      if (localObject != null)
      {
        QLog.e("PokeEmoItemBuilder", 1, "mTypeface  != null ");
        paramView.setTypeFace((Typeface)localObject);
        paramView.setText("x3");
        baww.a(paramView, false);
      }
    }
    else
    {
      if ((!localadwe.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.a()) && (aevj.a != null)) {
        localadwe.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setTypeFace(aevj.a);
      }
      if ("PEPanelHelper.mTypeface != null :" + aevj.a == null) {
        break label358;
      }
    }
    label358:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("PokeEmoItemBuilder", 1, new Object[] { Boolean.valueOf(bool) });
      paramacuj.setTag(localadwe);
      paramacuj.setOnTouchListener(paramacxj);
      paramacuj.setOnLongClickListener(paramacxj);
      a(localadwe, paramBaseChatItemLayout);
      if (e)
      {
        if ((localadwe.b != null) && (localadwe.b.length() > 0)) {
          localadwe.b.setLength(0);
        }
        paramacuj.setContentDescription(a(paramChatMessage));
      }
      return paramacuj;
      if ((!adwj.b) || (aevj.b)) {
        break;
      }
      aevj.b = true;
      ThreadManager.executeOnSubThread(new PokeEmoItemBuilder.1(this));
      break;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bbkp.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
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
    actj.b = 0;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131364984: 
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (actj.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPokeEmo)actj.a(paramView);
    } while (!paramView.isSendFromLocal());
    bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbfpc.a(2131689995, 5);
    localbfpc.c(2131690596);
    localbfpc.a(new adwd(this, paramView, localbfpc));
    localbfpc.show();
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = (acva)actj.a(paramView);
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPokeEmo)) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 0)) {
      a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbbmf);
    }
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwc
 * JD-Core Version:    0.7.0.1
 */