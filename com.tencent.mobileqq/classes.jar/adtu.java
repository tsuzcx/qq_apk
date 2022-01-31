import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class adtu
  extends BaseBubbleBuilder
  implements acui
{
  private static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  private static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected View.OnClickListener a;
  bcjp a;
  
  public adtu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Bcjp = new adty(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adtz(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public int a(MessageForLongMsg paramMessageForLongMsg)
  {
    if ((paramMessageForLongMsg != null) && (paramMessageForLongMsg.mSourceMsgInfo != null)) {
      return 2;
    }
    return 1;
  }
  
  public acui a(View paramView)
  {
    paramView = actj.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  public acuj a()
  {
    return new adua(this);
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    adua localadua = (adua)paramacuj;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131166872));
        paramView.setMaxWidth(BaseChatItemLayout.d);
        paramView.setSpannableFactory(aykk.a);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131364112);
        localadua.jdField_a_of_type_AndroidWidgetTextView = paramView;
        localadua.jdField_a_of_type_Aibq = new aibq();
        localadua.jdField_a_of_type_Aibq.a(paramView);
        localadua.jdField_a_of_type_Aibq.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      if ((i == 2) && (localadua.jdField_a_of_type_AndroidViewViewGroup == null)) {
        paramView = a(localContext, localadua, paramBaseChatItemLayout);
      }
      for (;;)
      {
        if (localadua.jdField_a_of_type_AndroidWidgetTextView != null) {
          localadua.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        }
        if (i == 2)
        {
          localadua.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          adyf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localadua.jdField_a_of_type_AndroidViewViewGroup, localMessageForLongMsg.mSourceMsgInfo, localMessageForLongMsg.frienduin, localMessageForLongMsg.istroop, paramChatMessage, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localadua.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localadua.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramacxj);
          localadua.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramacxj);
          label261:
          paramView.setOnTouchListener(paramacxj);
          paramView.setOnLongClickListener(paramacxj);
          if (localadua.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localadua.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramacxj);
            localadua.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramacxj);
            if (!TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
              break label575;
            }
            localadua.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb);
          }
        }
        for (;;)
        {
          if ((localadua.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
          {
            paramBaseChatItemLayout = (AnimationTextView)localadua.jdField_a_of_type_AndroidWidgetTextView;
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramBaseChatItemLayout, paramacuj.jdField_b_of_type_Int, paramacuj.c, true);
            paramBaseChatItemLayout.onDoubleClick = this.jdField_a_of_type_Bcjp;
            paramBaseChatItemLayout.onSingleClick = new adtv(this, paramChatMessage.isSend());
            paramBaseChatItemLayout.setStrokeColor(false, 0);
          }
          if ((localadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bcjp;
          }
          if ((localadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bcjp;
          }
          paramacuj = ia.a(paramChatMessage);
          if (localadua.jdField_a_of_type_AndroidWidgetTextView != null) {
            localadua.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramacuj);
          }
          if (localadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            localadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramacuj);
          }
          if (localadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null) {
            localadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramacuj);
          }
          if (localadua.jdField_b_of_type_AndroidWidgetTextView != null) {
            localadua.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramacuj);
          }
          if (localadua.jdField_a_of_type_Aibq != null) {
            localadua.jdField_a_of_type_Aibq.b(paramChatMessage);
          }
          return paramView;
          paramView = a(localContext, localadua, paramBaseChatItemLayout);
          break;
          if (localadua.jdField_a_of_type_AndroidViewViewGroup == null) {
            break label261;
          }
          localadua.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          break label261;
          label575:
          localadua.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb2);
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, adua paramadua, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = adyf.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramadua.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramadua.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131370647));
    paramadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131370452));
    paramadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131370469));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131166872));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.d);
    ((AnimationTextView)localObject).setSpannableFactory(aykk.a);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131364112);
    localLinearLayout.addView((View)localObject);
    paramadua.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    int i = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    paramadua.jdField_a_of_type_Aibq = new aibq();
    paramadua.jdField_a_of_type_Aibq.a((aicc)localObject);
    paramadua.jdField_a_of_type_Aibq.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    return localLinearLayout;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajya.a(2131706390) + aylc.e(paramChatMessage.msg);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "";
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131364984: 
    case 2131370536: 
    case 2131364824: 
    case 2131375176: 
    case 2131366632: 
    case 2131361809: 
      do
      {
        do
        {
          return;
          str1 = "";
          break;
          aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          return;
          super.d(paramChatMessage);
          return;
          if (aibn.a().c())
          {
            paramContext = aibn.a().a();
            if (paramContext != null) {
              if (paramContext.length() == aibn.a().a()) {
                paramInt = 1;
              }
            }
          }
          for (;;)
          {
            ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext);
            if (paramInt == 0) {
              break;
            }
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
            return;
            paramInt = 0;
            continue;
            paramInt = 0;
            continue;
            paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
            paramInt = 1;
          }
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
        return;
        paramContext = new Bundle();
        paramContext.putInt("forward_type", -1);
        paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
        paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (aibn.a().c())
        {
          paramChatMessage = aibn.a().a();
          paramContext.putString("forward_text", paramChatMessage);
          if (paramChatMessage != null) {
            if (paramChatMessage.length() == aibn.a().a()) {
              paramInt = 1;
            }
          }
        }
        for (;;)
        {
          paramChatMessage = new Intent();
          paramChatMessage.putExtras(paramContext);
          aqbe.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramInt == 0) {
            break;
          }
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
          paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
          paramInt = 1;
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      axrn.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramContext.putExtra("url", "http://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
    case 2131365928: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    case 2131370493: 
      super.a(paramChatMessage);
      return;
    }
    aibn.a().a(paramChatMessage);
  }
  
  public void a(acuj paramacuj, View paramView, ChatMessage paramChatMessage, ambg paramambg)
  {
    adua localadua = (adua)paramacuj;
    if ((paramambg.jdField_a_of_type_Int == 0) || (!paramambg.a()))
    {
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend())
      {
        paramacuj = paramView.getColorStateList(2131166876);
        if (paramacuj != null)
        {
          localadua.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacuj);
          if (localadua.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localadua.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramacuj);
            localadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacuj);
            localadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacuj);
          }
        }
        if (arqp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          if (!paramChatMessage.isSend()) {
            break label239;
          }
          i = -1;
          label110:
          localadua.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
          if (localadua.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localadua.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
            localadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
            localadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label247;
        }
      }
      label239:
      label247:
      for (paramacuj = paramView.getColorStateList(2131166875);; paramacuj = paramView.getColorStateList(2131166874))
      {
        localadua.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacuj);
        if (localadua.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacuj);
          localadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacuj);
          localadua.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacuj);
          ImmersiveUtils.a(localadua.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        }
        return;
        paramacuj = paramView.getColorStateList(2131166872);
        break;
        i = -16777216;
        break label110;
      }
    }
    if (paramambg.jdField_b_of_type_Int == 0)
    {
      localadua.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (localadua.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localadua.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      }
      if (paramambg.c != 0) {
        break label520;
      }
      paramacuj = paramView.getResources().getColorStateList(2131166874);
      localadua.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacuj);
      if (localadua.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacuj);
        localadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacuj);
      }
      label372:
      if ((localadua.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        if (!paramambg.jdField_a_of_type_Boolean) {
          break label570;
        }
        ((AnimationTextView)localadua.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramambg.d);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramambg.d);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.a(localadua.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      return;
      localadua.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambg.jdField_b_of_type_Int);
      if (localadua.jdField_a_of_type_AndroidViewViewGroup == null) {
        break;
      }
      localadua.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramambg.jdField_b_of_type_Int);
      localadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramambg.jdField_b_of_type_Int);
      localadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramambg.jdField_b_of_type_Int);
      break;
      label520:
      localadua.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramambg.c);
      if (localadua.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label372;
      }
      localadua.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramambg.c);
      localadua.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramambg.c);
      break label372;
      label570:
      if ((paramambg.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localadua.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localadua.jdField_a_of_type_Ambg.jdField_a_of_type_Double) == 1))
      {
        paramacuj = (AnimationTextView)localadua.jdField_a_of_type_AndroidWidgetTextView;
        float f2 = paramacuj.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramacuj.setTextColor(-1);
        paramacuj.setShadowLayer(f1, 0.0F, 0.0F, paramambg.d);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (actj.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)actj.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689995);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689996);
    } while (!paramView.isSendFromLocal());
    bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adtw(this, paramView), new adtx(this)).show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = paramView.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(f, c, e, d);
      return;
    }
    paramView.setPadding(e, c, f, d);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if (paramInt == 1)
    {
      acuj localacuj = (acuj)paramView.getTag();
      if (localacuj != null) {
        a(localacuj, paramView, paramChatMessage, localacuj.jdField_a_of_type_Ambg);
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acuj paramacuj, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacuj, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!aibn.a().c()) {
        break label115;
      }
      str = aibn.a().a();
      if (str == null) {
        break label110;
      }
      if (str.length() != aibn.a().a()) {
        break label105;
      }
      i = 1;
      if ((i == 0) && (str != null)) {
        break label122;
      }
      bgpu.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramMessageForLongMsg.istroop);
    }
    for (;;)
    {
      bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
      return;
      label105:
      i = 0;
      break;
      label110:
      i = 0;
      break;
      label115:
      str = null;
      i = 1;
      break;
      label122:
      bgpu.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramMessageForLongMsg.istroop);
    }
  }
  
  public bbmh[] a(View paramView)
  {
    paramView = (MessageForLongMsg)actj.a(paramView);
    bbmf localbbmf = new bbmf();
    if (ApolloUtil.a(paramView)) {
      return localbbmf.a();
    }
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localbbmf.a(2131364824, this.jdField_a_of_type_AndroidContentContext.getString(2131718660), 2130838597);
      localbbmf.a(2131375176, this.jdField_a_of_type_AndroidContentContext.getString(2131718667), 2130838611);
    }
    for (;;)
    {
      localbbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
      a(paramView, localbbmf);
      if ((paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
        localbbmf.a(2131361809, this.jdField_a_of_type_AndroidContentContext.getString(2131717264), 2130838584);
      }
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbbmf, paramView);
      if (actj.a(5) == 1) {
        localbbmf.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      b(paramView, localbbmf);
      super.c(localbbmf, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
      return localbbmf.a();
      localbbmf.a(2131364824, ajya.a(2131706389), 2130838597);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adtu
 * JD-Core Version:    0.7.0.1
 */