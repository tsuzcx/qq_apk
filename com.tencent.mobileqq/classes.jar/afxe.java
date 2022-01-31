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

public class afxe
  extends BaseBubbleBuilder
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StickerBubbleReceiverAnimationRunnable jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable;
  protected long c;
  
  public afxe(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(afxg paramafxg, MessageForPokeEmo paramMessageForPokeEmo)
  {
    int i = paramMessageForPokeEmo.pokeemoId;
    int j = paramMessageForPokeEmo.pokeemoPressCount;
    paramafxg.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramMessageForPokeEmo;
    afxl.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool = afxl.b;
    if (bool)
    {
      Drawable localDrawable = agxd.a(i);
      paramafxg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable(localDrawable);
      paramafxg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setText("x" + Integer.toString(paramMessageForPokeEmo.pokeemoPressCount));
      paramafxg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setIsSend(paramMessageForPokeEmo.isSend());
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, String.format(" initBubbleView.forbidPoke=%b,isResDownload = %b,pokeMsg.isPlay = %b,animatingCount = %d,emoId = %d", new Object[] { Boolean.valueOf(aepi.k), Boolean.valueOf(bool), Boolean.valueOf(paramMessageForPokeEmo.isNeedPlayed), Integer.valueOf(aepi.b), Integer.valueOf(paramMessageForPokeEmo.pokeemoId) }));
      }
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "sGesturePWDUnlockShowing: " + GesturePWDUnlockActivity.c);
      }
      if (!aepi.k) {
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
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841162);
        }
        paramafxg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramafxg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setText("x" + paramMessageForPokeEmo.pokeemoPressCount * 1000);
        break;
        if ((!bool) || (paramMessageForPokeEmo.isSend()) || (!paramMessageForPokeEmo.isNeedPlayed) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) || (GesturePWDUnlockActivity.c)) {
          break label397;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PokeEmoItemBuilder", 2, "show animation from item builder");
        }
        aepi.b += 1;
        paramMessageForPokeEmo.setIsNeedPlayed(false);
        paramafxg = ((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362208);
      } while (paramafxg == null);
      paramMessageForPokeEmo = agxd.b(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable = new StickerBubbleReceiverAnimationRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, paramafxg, paramMessageForPokeEmo);
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable);
      return;
    } while (paramMessageForPokeEmo.isNeedPlayed);
    paramMessageForPokeEmo.setIsNeedPlayed(false);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aeqi a()
  {
    return new afxg(this);
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    paramBaseChatItemLayout = (MessageForPokeEmo)paramChatMessage;
    afxg localafxg = (afxg)paramaeqi;
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "type: " + paramBaseChatItemLayout.pokeemoId + " count: " + paramBaseChatItemLayout.pokeemoPressCount);
    }
    paramaeqi = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "[getBubbleView]:content is null");
      }
      paramaeqi = new RelativeLayout((Context)localObject);
      paramaeqi.setId(2131376034);
      paramView = new PokeEmoItemView((Context)localObject);
      paramView.setId(2131372171);
      paramaeqi.addView(paramView, new ViewGroup.LayoutParams(-1, aepi.a(80.0F, ((Context)localObject).getResources())));
      localafxg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView = paramView;
      localObject = agxd.a;
      if (localObject != null)
      {
        QLog.e("PokeEmoItemBuilder", 1, "mTypeface  != null ");
        paramView.setTypeFace((Typeface)localObject);
        paramView.setText("x3");
        bczz.a(paramView, false);
      }
    }
    else
    {
      if ((!localafxg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.a()) && (agxd.a != null)) {
        localafxg.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setTypeFace(agxd.a);
      }
      if ("PEPanelHelper.mTypeface != null :" + agxd.a == null) {
        break label358;
      }
    }
    label358:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("PokeEmoItemBuilder", 1, new Object[] { Boolean.valueOf(bool) });
      paramaeqi.setTag(localafxg);
      paramaeqi.setOnTouchListener(paramaetk);
      paramaeqi.setOnLongClickListener(paramaetk);
      a(localafxg, paramBaseChatItemLayout);
      if (e)
      {
        if ((localafxg.b != null) && (localafxg.b.length() > 0)) {
          localafxg.b.setLength(0);
        }
        paramaeqi.setContentDescription(a(paramChatMessage));
      }
      return paramaeqi;
      if ((!afxl.b) || (agxd.b)) {
        break;
      }
      agxd.b = true;
      ThreadManager.executeOnSubThread(new PokeEmoItemBuilder.1(this));
      break;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bdns.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
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
    aepi.b = 0;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365071: 
      acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aepi.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPokeEmo)aepi.a(paramView);
    } while (!paramView.isSendFromLocal());
    bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbhuf.a(2131690042, 5);
    localbhuf.c(2131690648);
    localbhuf.a(new afxf(this, paramView, localbhuf));
    localbhuf.show();
  }
  
  public bdpk[] a(View paramView)
  {
    bdpi localbdpi = new bdpi();
    paramView = (aeqz)aepi.a(paramView);
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPokeEmo)) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 0)) {
      a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbdpi);
    }
    acjm.a(localbdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    return localbdpi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxe
 * JD-Core Version:    0.7.0.1
 */