import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class aham
  extends BaseBubbleBuilder
  implements afqq
{
  private static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  protected View.OnClickListener a;
  bils a;
  
  public aham(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Bils = new ahaq(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahar(this);
  }
  
  private BaseChatPie a()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if (localChatFragment == null)
    {
      QLog.e("ChatItemBuilder", 1, "[getChatPie] ChatFragment is null");
      return null;
    }
    return localChatFragment.a();
  }
  
  private void a(ChatMessage paramChatMessage, ahas paramahas)
  {
    paramChatMessage = gm.a(paramChatMessage);
    if (paramahas.jdField_a_of_type_AndroidWidgetTextView != null) {
      paramahas.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
    }
    if (paramahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
      paramahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
    if (paramahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null) {
      paramahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
    if (paramahas.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramahas.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
    }
  }
  
  private void b(View paramView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LongMsgItemBuilder", 2, "SingleTap invoked!");
    }
    Object localObject;
    float f1;
    float f2;
    float f3;
    int k;
    boolean bool;
    int j;
    if ((paramView instanceof AnimationTextView))
    {
      localObject = (AnimationTextView)paramView;
      f1 = ((AnimationTextView)localObject).touchL - e;
      f2 = ((AnimationTextView)localObject).touchT;
      f3 = c;
      if (paramBoolean) {
        f1 = ((AnimationTextView)localObject).touchL - f;
      }
      localObject = ((AnimationTextView)localObject).getText();
      if ((localObject instanceof QQText))
      {
        localObject = (QQText)localObject;
        localObject = (QQText.EmoticonSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), QQText.EmoticonSpan.class);
        if (!(paramView instanceof ETTextView)) {
          break label317;
        }
        paramView = (ETTextView)paramView;
        k = paramView.mClickEpId;
        int m = paramView.mClickcEId;
        if ((paramView.mFont == null) || (paramView.mFont.mFontId == 0) || (paramView.mFont.mFontType != 1)) {
          break label300;
        }
        bool = true;
        i = k;
        j = m;
        paramBoolean = bool;
        if (bool)
        {
          i = k;
          j = m;
          paramBoolean = bool;
          if (paramView.getETLayout() != null)
          {
            paramView = paramView.getETLayout();
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "isHanYiFont, onlyEmoji: " + paramView.jdField_a_of_type_Boolean);
            }
            if (paramView.jdField_a_of_type_Boolean) {
              break label306;
            }
            paramBoolean = true;
            label243:
            j = m;
          }
        }
      }
    }
    for (int i = k;; i = -1)
    {
      if ((i != -1) && (j != -1)) {}
      for (bool = true;; bool = false)
      {
        EmoticonUtils.clickSmallEmoticon((QQText.EmoticonSpan[])localObject, f1, f2 - f3, bool, i, j, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Activity)this.jdField_a_of_type_AndroidContentContext, paramBoolean);
        return;
        label300:
        bool = false;
        break;
        label306:
        paramBoolean = false;
        break label243;
      }
      label317:
      paramBoolean = false;
      j = -1;
    }
  }
  
  private void h(ChatMessage paramChatMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      if (localObject != null)
      {
        localObject = (benk)((BaseChatPie)localObject).getHelper(74);
        if ((localObject != null) && ((paramChatMessage instanceof MessageForLongMsg))) {
          ((benk)localObject).b(((MessageForLongMsg)paramChatMessage).sb.toString(), 3);
        }
      }
    }
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
  
  public afqq a(View paramView)
  {
    paramView = AIOUtils.getMessage(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  public afqr a()
  {
    return new ahas(this);
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    ahas localahas = (ahas)paramafqr;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131167045));
        paramView.setMaxWidth(BaseChatItemLayout.e);
        paramView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131364525);
        localahas.jdField_a_of_type_AndroidWidgetTextView = paramView;
        localahas.jdField_a_of_type_Alvu = new alvu();
        localahas.jdField_a_of_type_Alvu.a(paramView);
        localahas.jdField_a_of_type_Alvu.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      if ((i == 2) && (localahas.jdField_a_of_type_AndroidViewViewGroup == null)) {
        paramView = a(localContext, localahas, paramBaseChatItemLayout);
      }
      for (;;)
      {
        if (localahas.jdField_a_of_type_AndroidWidgetTextView != null) {
          localahas.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
        }
        if (i == 2)
        {
          localahas.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          ahfa.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localahas.jdField_a_of_type_AndroidViewViewGroup, localMessageForLongMsg.mSourceMsgInfo, localMessageForLongMsg.frienduin, localMessageForLongMsg.istroop, paramChatMessage, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localahas.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localahas.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramaftk);
          localahas.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramaftk);
          label263:
          paramView.setOnTouchListener(paramaftk);
          paramView.setOnLongClickListener(paramaftk);
          if (localahas.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localahas.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramaftk);
            localahas.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramaftk);
            if (!android.text.TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
              break label564;
            }
            localahas.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb);
          }
        }
        for (;;)
        {
          if ((localahas.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
          {
            paramaftk = (AnimationTextView)localahas.jdField_a_of_type_AndroidWidgetTextView;
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramaftk, paramafqr.jdField_b_of_type_Int, paramafqr.c, true);
            paramaftk.onDoubleClick = this.jdField_a_of_type_Bils;
            paramaftk.onSingleClick = new ahan(this, paramChatMessage.isSend());
            paramaftk.setStrokeColor(false, 0);
          }
          if ((localahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bils;
          }
          if ((localahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bils;
          }
          a(paramChatMessage, localahas);
          if (localahas.jdField_a_of_type_Alvu != null) {
            localahas.jdField_a_of_type_Alvu.b(paramChatMessage);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localahas.c = super.a(localahas.c, localahas, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
            super.a(localahas.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
          }
          return paramView;
          paramView = a(localContext, localahas, paramBaseChatItemLayout);
          break;
          if (localahas.jdField_a_of_type_AndroidViewViewGroup == null) {
            break label263;
          }
          localahas.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          break label263;
          label564:
          localahas.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb2);
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, ahas paramahas, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = ahfa.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramahas.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramahas.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131371803));
    paramahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371598));
    paramahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371616));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167045));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
    ((AnimationTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131364525);
    localLinearLayout.addView((View)localObject);
    paramahas.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    int i = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    paramahas.jdField_a_of_type_Alvu = new alvu();
    paramahas.jdField_a_of_type_Alvu.a((alwg)localObject);
    paramahas.jdField_a_of_type_Alvu.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    return localLinearLayout;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anvx.a(2131705853) + com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      str1 = str2;
      if (android.text.TextUtils.isEmpty(str2)) {
        str1 = "";
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131365475: 
    case 2131371684: 
    case 2131365307: 
    case 2131376588: 
      do
      {
        return;
        str1 = "";
        break;
        admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
        super.d(paramChatMessage);
        return;
        if (alvr.a().c())
        {
          paramContext = alvr.a().b();
          if (paramContext != null) {
            if (paramContext.length() == alvr.a().a()) {
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
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
          paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
          paramInt = 1;
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
      return;
    case 2131367213: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      if (alvr.a().c())
      {
        paramChatMessage = alvr.a().b();
        paramContext.putString("forward_text", paramChatMessage);
        if (paramChatMessage != null) {
          if (paramChatMessage.length() == alvr.a().a()) {
            paramInt = 1;
          }
        }
      }
      for (;;)
      {
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (paramInt == 0) {
          break;
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
        return;
        paramInt = 0;
        continue;
        paramInt = 0;
        continue;
        paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
        paramInt = 1;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      return;
    case 2131366456: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    case 2131371641: 
      super.a(paramChatMessage);
      return;
    case 2131377287: 
      alvr.a().a(paramChatMessage);
      return;
    }
    h(paramChatMessage);
  }
  
  public void a(afqr paramafqr, View paramView, ChatMessage paramChatMessage, aqhi paramaqhi)
  {
    ahas localahas = (ahas)paramafqr;
    if ((paramaqhi.jdField_a_of_type_Int == 0) || (!paramaqhi.a()))
    {
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend())
      {
        paramafqr = paramView.getColorStateList(2131167049);
        if (paramafqr != null)
        {
          localahas.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramafqr);
          if (localahas.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localahas.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramafqr);
            localahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramafqr);
            localahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramafqr);
          }
        }
        if (aweo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          if (!paramChatMessage.isSend()) {
            break label240;
          }
          i = -1;
          label110:
          localahas.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
          if (localahas.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localahas.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
            localahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
            localahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label248;
        }
      }
      label240:
      label248:
      for (paramafqr = paramView.getColorStateList(2131167048);; paramafqr = paramView.getColorStateList(2131167047))
      {
        localahas.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramafqr);
        if (localahas.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
          localahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
          localahas.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramafqr);
          ImmersiveUtils.a(localahas.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        }
        return;
        paramafqr = paramView.getColorStateList(2131167045);
        break;
        i = -16777216;
        break label110;
      }
    }
    if (paramaqhi.jdField_b_of_type_Int == 0)
    {
      localahas.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (localahas.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localahas.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      }
      if (paramaqhi.c != 0) {
        break label520;
      }
      paramafqr = paramView.getResources().getColorStateList(2131167047);
      localahas.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramafqr);
      if (localahas.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
        localahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafqr);
      }
      label373:
      if ((localahas.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        if (!paramaqhi.jdField_a_of_type_Boolean) {
          break label570;
        }
        ((AnimationTextView)localahas.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramaqhi.d);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramaqhi.d);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.a(localahas.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      return;
      localahas.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
      if (localahas.jdField_a_of_type_AndroidViewViewGroup == null) {
        break;
      }
      localahas.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
      localahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
      localahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
      break;
      label520:
      localahas.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaqhi.c);
      if (localahas.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label373;
      }
      localahas.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqhi.c);
      localahas.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqhi.c);
      break label373;
      label570:
      if ((paramaqhi.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localahas.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localahas.jdField_a_of_type_Aqhi.jdField_a_of_type_Double) == 1))
      {
        paramafqr = (AnimationTextView)localahas.jdField_a_of_type_AndroidWidgetTextView;
        float f2 = paramafqr.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramafqr.setTextColor(-1);
        paramafqr.setShadowLayer(f1, 0.0F, 0.0F, paramaqhi.d);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.getMessage(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)AIOUtils.getMessage(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689976);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689977);
    } while (!paramView.isSendFromLocal());
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahao(this, paramView), new ahap(this)).show();
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
      afqr localafqr = (afqr)paramView.getTag();
      if (localafqr != null) {
        a(localafqr, paramView, paramChatMessage, localafqr.jdField_a_of_type_Aqhi);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afqr paramafqr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafqr, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!alvr.a().c()) {
        break label115;
      }
      str = alvr.a().b();
      if (str == null) {
        break label110;
      }
      if (str.length() != alvr.a().a()) {
        break label105;
      }
      i = 1;
      if ((i == 0) && (str != null)) {
        break label122;
      }
      bmad.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramMessageForLongMsg.istroop);
    }
    for (;;)
    {
      bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
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
      bmad.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramMessageForLongMsg.istroop);
    }
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = (MessageForLongMsg)AIOUtils.getMessage(paramView);
    bhjq localbhjq = new bhjq();
    if (ApolloUtil.a(paramView)) {
      return localbhjq.a();
    }
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localbhjq.a(2131365307, this.jdField_a_of_type_AndroidContentContext.getString(2131717995), 2130838982);
      localbhjq.a(2131376588, this.jdField_a_of_type_AndroidContentContext.getString(2131717998), 2130838998);
    }
    for (;;)
    {
      localbhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
      a(paramView, localbhjq);
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
      }
      a(localbhjq, paramView);
      if ((arhn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (d())) {
        b(localbhjq, this.jdField_a_of_type_AndroidContentContext, paramView);
      }
      if (AIOUtils.getAIOMsgMenuDpcConfig(5) == 1) {
        localbhjq.a(2131366456, this.jdField_a_of_type_AndroidContentContext.getString(2131692126), 2130838990);
      }
      super.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, paramView);
      if (paramView.msgtype == -1037) {
        c(paramView, localbhjq);
      }
      b(paramView, localbhjq);
      super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
      return localbhjq.a();
      localbhjq.a(2131365307, anvx.a(2131705852), 2130838982);
    }
  }
  
  protected void b(bhjq parambhjq, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (parambhjq != null) && (paramContext != null) && (benq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      parambhjq.a(2131381591, paramContext.getString(2131720148), 0);
    }
  }
  
  protected boolean d()
  {
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    localObject = (benk)((BaseChatPie)localObject).getHelper(74);
    if ((localObject != null) && (((benk)localObject).a())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aham
 * JD-Core Version:    0.7.0.1
 */