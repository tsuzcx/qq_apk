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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ahbx
  extends BaseBubbleBuilder
  implements afwq
{
  private static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  protected View.OnClickListener a;
  bhud a;
  
  public ahbx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Bhud = new ahcb(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahcc(this);
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
  
  public afwq a(View paramView)
  {
    paramView = afur.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  public afwr a()
  {
    return new ahcd(this);
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    ahcd localahcd = (ahcd)paramafwr;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131167004));
        paramView.setMaxWidth(BaseChatItemLayout.e);
        paramView.setSpannableFactory(bdnt.a);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131364382);
        localahcd.jdField_a_of_type_AndroidWidgetTextView = paramView;
        localahcd.jdField_a_of_type_Alqf = new alqf();
        localahcd.jdField_a_of_type_Alqf.a(paramView);
        localahcd.jdField_a_of_type_Alqf.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      if ((i == 2) && (localahcd.jdField_a_of_type_AndroidViewViewGroup == null)) {
        paramView = a(localContext, localahcd, paramBaseChatItemLayout);
      }
      for (;;)
      {
        if (localahcd.jdField_a_of_type_AndroidWidgetTextView != null) {
          localahcd.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        }
        if (i == 2)
        {
          localahcd.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          ahgl.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localahcd.jdField_a_of_type_AndroidViewViewGroup, localMessageForLongMsg.mSourceMsgInfo, localMessageForLongMsg.frienduin, localMessageForLongMsg.istroop, paramChatMessage, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localahcd.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localahcd.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramafzq);
          localahcd.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramafzq);
          label261:
          paramView.setOnTouchListener(paramafzq);
          paramView.setOnLongClickListener(paramafzq);
          if (localahcd.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localahcd.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramafzq);
            localahcd.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramafzq);
            if (!TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
              break label575;
            }
            localahcd.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb);
          }
        }
        for (;;)
        {
          if ((localahcd.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
          {
            paramBaseChatItemLayout = (AnimationTextView)localahcd.jdField_a_of_type_AndroidWidgetTextView;
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramBaseChatItemLayout, paramafwr.jdField_b_of_type_Int, paramafwr.c, true);
            paramBaseChatItemLayout.onDoubleClick = this.jdField_a_of_type_Bhud;
            paramBaseChatItemLayout.onSingleClick = new ahby(this, paramChatMessage.isSend());
            paramBaseChatItemLayout.setStrokeColor(false, 0);
          }
          if ((localahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bhud;
          }
          if ((localahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bhud;
          }
          paramafwr = go.a(paramChatMessage);
          if (localahcd.jdField_a_of_type_AndroidWidgetTextView != null) {
            localahcd.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramafwr);
          }
          if (localahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            localahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramafwr);
          }
          if (localahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null) {
            localahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramafwr);
          }
          if (localahcd.jdField_b_of_type_AndroidWidgetTextView != null) {
            localahcd.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramafwr);
          }
          if (localahcd.jdField_a_of_type_Alqf != null) {
            localahcd.jdField_a_of_type_Alqf.b(paramChatMessage);
          }
          return paramView;
          paramView = a(localContext, localahcd, paramBaseChatItemLayout);
          break;
          if (localahcd.jdField_a_of_type_AndroidViewViewGroup == null) {
            break label261;
          }
          localahcd.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          break label261;
          label575:
          localahcd.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb2);
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, ahcd paramahcd, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = ahgl.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramahcd.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramahcd.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131371539));
    paramahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371338));
    paramahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371355));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167004));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
    ((AnimationTextView)localObject).setSpannableFactory(bdnt.a);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131364382);
    localLinearLayout.addView((View)localObject);
    paramahcd.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    int i = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    paramahcd.jdField_a_of_type_Alqf = new alqf();
    paramahcd.jdField_a_of_type_Alqf.a((alqr)localObject);
    paramahcd.jdField_a_of_type_Alqf.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    return localLinearLayout;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anni.a(2131705165) + bdol.e(paramChatMessage.msg);
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
    case 2131365308: 
    case 2131371422: 
    case 2131365147: 
    case 2131376435: 
      do
      {
        return;
        str1 = "";
        break;
        adrm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
        super.d(paramChatMessage);
        return;
        if (alqc.a().c())
        {
          paramContext = alqc.a().b();
          if (paramContext != null) {
            if (paramContext.length() == alqc.a().a()) {
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
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
          paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
          paramInt = 1;
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      adrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
      return;
    case 2131367027: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (alqc.a().c())
      {
        paramChatMessage = alqc.a().b();
        paramContext.putString("forward_text", paramChatMessage);
        if (paramChatMessage != null) {
          if (paramChatMessage.length() == alqc.a().a()) {
            paramInt = 1;
          }
        }
      }
      for (;;)
      {
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        aufz.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (paramInt == 0) {
          break;
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
        return;
        paramInt = 0;
        continue;
        paramInt = 0;
        continue;
        paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
        paramInt = 1;
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      return;
    case 2131366271: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    case 2131371380: 
      super.a(paramChatMessage);
      return;
    }
    alqc.a().a(paramChatMessage);
  }
  
  public void a(afwr paramafwr, View paramView, ChatMessage paramChatMessage, apwt paramapwt)
  {
    ahcd localahcd = (ahcd)paramafwr;
    if ((paramapwt.jdField_a_of_type_Int == 0) || (!paramapwt.a()))
    {
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend())
      {
        paramafwr = paramView.getColorStateList(2131167008);
        if (paramafwr != null)
        {
          localahcd.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramafwr);
          if (localahcd.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localahcd.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramafwr);
            localahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramafwr);
            localahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramafwr);
          }
        }
        if (avsr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          if (!paramChatMessage.isSend()) {
            break label239;
          }
          i = -1;
          label110:
          localahcd.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
          if (localahcd.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localahcd.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
            localahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
            localahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label247;
        }
      }
      label239:
      label247:
      for (paramafwr = paramView.getColorStateList(2131167007);; paramafwr = paramView.getColorStateList(2131167006))
      {
        localahcd.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramafwr);
        if (localahcd.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafwr);
          localahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafwr);
          localahcd.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramafwr);
          ImmersiveUtils.a(localahcd.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        }
        return;
        paramafwr = paramView.getColorStateList(2131167004);
        break;
        i = -16777216;
        break label110;
      }
    }
    if (paramapwt.jdField_b_of_type_Int == 0)
    {
      localahcd.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (localahcd.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localahcd.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      }
      if (paramapwt.c != 0) {
        break label520;
      }
      paramafwr = paramView.getResources().getColorStateList(2131167006);
      localahcd.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramafwr);
      if (localahcd.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafwr);
        localahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramafwr);
      }
      label372:
      if ((localahcd.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        if (!paramapwt.jdField_a_of_type_Boolean) {
          break label570;
        }
        ((AnimationTextView)localahcd.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramapwt.d);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramapwt.d);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.a(localahcd.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      return;
      localahcd.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramapwt.jdField_b_of_type_Int);
      if (localahcd.jdField_a_of_type_AndroidViewViewGroup == null) {
        break;
      }
      localahcd.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramapwt.jdField_b_of_type_Int);
      localahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramapwt.jdField_b_of_type_Int);
      localahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramapwt.jdField_b_of_type_Int);
      break;
      label520:
      localahcd.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramapwt.c);
      if (localahcd.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label372;
      }
      localahcd.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramapwt.c);
      localahcd.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramapwt.c);
      break label372;
      label570:
      if ((paramapwt.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localahcd.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localahcd.jdField_a_of_type_Apwt.jdField_a_of_type_Double) == 1))
      {
        paramafwr = (AnimationTextView)localahcd.jdField_a_of_type_AndroidWidgetTextView;
        float f2 = paramafwr.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramafwr.setTextColor(-1);
        paramafwr.setShadowLayer(f1, 0.0F, 0.0F, paramapwt.d);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (afur.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)afur.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689926);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689927);
    } while (!paramView.isSendFromLocal());
    bglp.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahbz(this, paramView), new ahca(this)).show();
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
      afwr localafwr = (afwr)paramView.getTag();
      if (localafwr != null) {
        a(localafwr, paramView, paramChatMessage, localafwr.jdField_a_of_type_Apwt);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafwr, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!alqc.a().c()) {
        break label115;
      }
      str = alqc.a().b();
      if (str == null) {
        break label110;
      }
      if (str.length() != alqc.a().a()) {
        break label105;
      }
      i = 1;
      if ((i == 0) && (str != null)) {
        break label122;
      }
      bljl.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramMessageForLongMsg.istroop);
    }
    for (;;)
    {
      bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
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
      bljl.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramMessageForLongMsg.istroop);
    }
  }
  
  public bguj[] a(View paramView)
  {
    paramView = (MessageForLongMsg)afur.a(paramView);
    bguh localbguh = new bguh();
    if (ApolloUtil.a(paramView)) {
      return localbguh.a();
    }
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localbguh.a(2131365147, this.jdField_a_of_type_AndroidContentContext.getString(2131717280), 2130838920);
      localbguh.a(2131376435, this.jdField_a_of_type_AndroidContentContext.getString(2131717283), 2130838934);
    }
    for (;;)
    {
      localbguh.a(2131367027, this.jdField_a_of_type_AndroidContentContext.getString(2131692395), 2130838929);
      a(paramView, localbguh);
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbguh, paramView);
      if (afur.a(5) == 1) {
        localbguh.a(2131366271, this.jdField_a_of_type_AndroidContentContext.getString(2131691986), 2130838928);
      }
      super.a(localbguh, this.jdField_a_of_type_AndroidContentContext, paramView);
      b(paramView, localbguh);
      super.c(localbguh, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbguh, this.jdField_a_of_type_AndroidContentContext);
      return localbguh.a();
      localbguh.a(2131365147, anni.a(2131705164), 2130838920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbx
 * JD-Core Version:    0.7.0.1
 */