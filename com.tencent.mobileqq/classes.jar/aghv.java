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

public class aghv
  extends BaseBubbleBuilder
  implements aeze
{
  private static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  protected View.OnClickListener a;
  bhba a;
  
  public aghv(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Bhba = new aghz(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agia(this);
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
  
  private void a(ChatMessage paramChatMessage, agib paramagib)
  {
    paramChatMessage = gm.a(paramChatMessage);
    if (paramagib.jdField_a_of_type_AndroidWidgetTextView != null) {
      paramagib.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
    }
    if (paramagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
      paramagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
    if (paramagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null) {
      paramagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
    if (paramagib.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramagib.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
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
        localObject = (bdgh)((BaseChatPie)localObject).getHelper(74);
        if ((localObject != null) && ((paramChatMessage instanceof MessageForLongMsg))) {
          ((bdgh)localObject).b(((MessageForLongMsg)paramChatMessage).sb.toString(), 3);
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
  
  public aeze a(View paramView)
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
  
  public aezf a()
  {
    return new agib(this);
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    agib localagib = (agib)paramaezf;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131167031));
        paramView.setMaxWidth(BaseChatItemLayout.e);
        paramView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131364444);
        localagib.jdField_a_of_type_AndroidWidgetTextView = paramView;
        localagib.jdField_a_of_type_Akxy = new akxy();
        localagib.jdField_a_of_type_Akxy.a(paramView);
        localagib.jdField_a_of_type_Akxy.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      if ((i == 2) && (localagib.jdField_a_of_type_AndroidViewViewGroup == null)) {
        paramView = a(localContext, localagib, paramBaseChatItemLayout);
      }
      for (;;)
      {
        if (localagib.jdField_a_of_type_AndroidWidgetTextView != null) {
          localagib.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
        }
        if (i == 2)
        {
          localagib.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          agmk.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localagib.jdField_a_of_type_AndroidViewViewGroup, localMessageForLongMsg.mSourceMsgInfo, localMessageForLongMsg.frienduin, localMessageForLongMsg.istroop, paramChatMessage, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localagib.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localagib.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramafce);
          localagib.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramafce);
          label263:
          paramView.setOnTouchListener(paramafce);
          paramView.setOnLongClickListener(paramafce);
          if (localagib.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localagib.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramafce);
            localagib.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramafce);
            if (!android.text.TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
              break label564;
            }
            localagib.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb);
          }
        }
        for (;;)
        {
          if ((localagib.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
          {
            paramafce = (AnimationTextView)localagib.jdField_a_of_type_AndroidWidgetTextView;
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramafce, paramaezf.jdField_b_of_type_Int, paramaezf.c, true);
            paramafce.onDoubleClick = this.jdField_a_of_type_Bhba;
            paramafce.onSingleClick = new aghw(this, paramChatMessage.isSend());
            paramafce.setStrokeColor(false, 0);
          }
          if ((localagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bhba;
          }
          if ((localagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bhba;
          }
          a(paramChatMessage, localagib);
          if (localagib.jdField_a_of_type_Akxy != null) {
            localagib.jdField_a_of_type_Akxy.b(paramChatMessage);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localagib.c = super.a(localagib.c, localagib, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
            super.a(localagib.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
          }
          return paramView;
          paramView = a(localContext, localagib, paramBaseChatItemLayout);
          break;
          if (localagib.jdField_a_of_type_AndroidViewViewGroup == null) {
            break label263;
          }
          localagib.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          break label263;
          label564:
          localagib.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb2);
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, agib paramagib, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = agmk.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramagib.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramagib.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131371615));
    paramagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371413));
    paramagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371430));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167031));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
    ((AnimationTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131364444);
    localLinearLayout.addView((View)localObject);
    paramagib.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    int i = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    paramagib.jdField_a_of_type_Akxy = new akxy();
    paramagib.jdField_a_of_type_Akxy.a((akyk)localObject);
    paramagib.jdField_a_of_type_Akxy.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    return localLinearLayout;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return amtj.a(2131705502) + com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
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
    case 2131365382: 
    case 2131371498: 
    case 2131365216: 
    case 2131376333: 
      do
      {
        return;
        str1 = "";
        break;
        acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
        super.d(paramChatMessage);
        return;
        if (akxv.a().c())
        {
          paramContext = akxv.a().b();
          if (paramContext != null) {
            if (paramContext.length() == akxv.a().a()) {
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
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
          paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
          paramInt = 1;
        }
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      acvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
      return;
    case 2131367094: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      if (akxv.a().c())
      {
        paramChatMessage = akxv.a().b();
        paramContext.putString("forward_text", paramChatMessage);
        if (paramChatMessage != null) {
          if (paramChatMessage.length() == akxv.a().a()) {
            paramInt = 1;
          }
        }
      }
      for (;;)
      {
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        atky.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (paramInt == 0) {
          break;
        }
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
        return;
        paramInt = 0;
        continue;
        paramInt = 0;
        continue;
        paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
        paramInt = 1;
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      return;
    case 2131366347: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    case 2131371455: 
      super.a(paramChatMessage);
      return;
    case 2131377014: 
      akxv.a().a(paramChatMessage);
      return;
    }
    h(paramChatMessage);
  }
  
  public void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage, apee paramapee)
  {
    agib localagib = (agib)paramaezf;
    if ((paramapee.jdField_a_of_type_Int == 0) || (!paramapee.a()))
    {
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend())
      {
        paramaezf = paramView.getColorStateList(2131167035);
        if (paramaezf != null)
        {
          localagib.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaezf);
          if (localagib.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localagib.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaezf);
            localagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaezf);
            localagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaezf);
          }
        }
        if (auyo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          if (!paramChatMessage.isSend()) {
            break label240;
          }
          i = -1;
          label110:
          localagib.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
          if (localagib.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localagib.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
            localagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
            localagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label248;
        }
      }
      label240:
      label248:
      for (paramaezf = paramView.getColorStateList(2131167034);; paramaezf = paramView.getColorStateList(2131167033))
      {
        localagib.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaezf);
        if (localagib.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaezf);
          localagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaezf);
          localagib.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaezf);
          ImmersiveUtils.a(localagib.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        }
        return;
        paramaezf = paramView.getColorStateList(2131167031);
        break;
        i = -16777216;
        break label110;
      }
    }
    if (paramapee.jdField_b_of_type_Int == 0)
    {
      localagib.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (localagib.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localagib.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      }
      if (paramapee.c != 0) {
        break label520;
      }
      paramaezf = paramView.getResources().getColorStateList(2131167033);
      localagib.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaezf);
      if (localagib.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaezf);
        localagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaezf);
      }
      label373:
      if ((localagib.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        if (!paramapee.jdField_a_of_type_Boolean) {
          break label570;
        }
        ((AnimationTextView)localagib.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramapee.d);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramapee.d);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.a(localagib.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      return;
      localagib.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramapee.jdField_b_of_type_Int);
      if (localagib.jdField_a_of_type_AndroidViewViewGroup == null) {
        break;
      }
      localagib.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramapee.jdField_b_of_type_Int);
      localagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramapee.jdField_b_of_type_Int);
      localagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramapee.jdField_b_of_type_Int);
      break;
      label520:
      localagib.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramapee.c);
      if (localagib.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label373;
      }
      localagib.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramapee.c);
      localagib.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramapee.c);
      break label373;
      label570:
      if ((paramapee.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localagib.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localagib.jdField_a_of_type_Apee.jdField_a_of_type_Double) == 1))
      {
        paramaezf = (AnimationTextView)localagib.jdField_a_of_type_AndroidWidgetTextView;
        float f2 = paramaezf.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramaezf.setTextColor(-1);
        paramaezf.setShadowLayer(f1, 0.0F, 0.0F, paramapee.d);
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
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689947);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689948);
    } while (!paramView.isSendFromLocal());
    bfur.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new aghx(this, paramView), new aghy(this)).show();
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
      aezf localaezf = (aezf)paramView.getTag();
      if (localaezf != null) {
        a(localaezf, paramView, paramChatMessage, localaezf.jdField_a_of_type_Apee);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaezf, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!akxv.a().c()) {
        break label115;
      }
      str = akxv.a().b();
      if (str == null) {
        break label110;
      }
      if (str.length() != akxv.a().a()) {
        break label105;
      }
      i = 1;
      if ((i == 0) && (str != null)) {
        break label122;
      }
      bkov.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramMessageForLongMsg.istroop);
    }
    for (;;)
    {
      bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
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
      bkov.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramMessageForLongMsg.istroop);
    }
  }
  
  public bgbb[] a(View paramView)
  {
    paramView = (MessageForLongMsg)AIOUtils.getMessage(paramView);
    bgaz localbgaz = new bgaz();
    if (ApolloUtil.a(paramView)) {
      return localbgaz.a();
    }
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localbgaz.a(2131365216, this.jdField_a_of_type_AndroidContentContext.getString(2131717628), 2130838962);
      localbgaz.a(2131376333, this.jdField_a_of_type_AndroidContentContext.getString(2131717631), 2130838978);
    }
    for (;;)
    {
      localbgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
      a(paramView, localbgaz);
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localbgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
      }
      a(localbgaz, paramView);
      if ((aqeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (d())) {
        b(localbgaz, this.jdField_a_of_type_AndroidContentContext, paramView);
      }
      if (AIOUtils.getAIOMsgMenuDpcConfig(5) == 1) {
        localbgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131692036), 2130838970);
      }
      super.a(localbgaz, this.jdField_a_of_type_AndroidContentContext, paramView);
      if (paramView.msgtype == -1037) {
        c(paramView, localbgaz);
      }
      b(paramView, localbgaz);
      super.c(localbgaz, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbgaz, this.jdField_a_of_type_AndroidContentContext);
      return localbgaz.a();
      localbgaz.a(2131365216, amtj.a(2131705501), 2130838962);
    }
  }
  
  protected void b(bgaz parambgaz, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (parambgaz != null) && (paramContext != null) && (bdgn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      parambgaz.a(2131381228, paramContext.getString(2131719695), 0);
    }
  }
  
  protected boolean d()
  {
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    localObject = (bdgh)((BaseChatPie)localObject).getHelper(74);
    if ((localObject != null) && (((bdgh)localObject).a())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghv
 * JD-Core Version:    0.7.0.1
 */