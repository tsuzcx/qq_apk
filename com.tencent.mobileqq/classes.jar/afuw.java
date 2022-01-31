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

public class afuw
  extends BaseBubbleBuilder
  implements aeqh
{
  private static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  private static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected View.OnClickListener a;
  bemz a;
  
  public afuw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Bemz = new afva(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afvb(this);
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
  
  public aeqh a(View paramView)
  {
    paramView = aepi.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  public aeqi a()
  {
    return new afvc(this);
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    afvc localafvc = (afvc)paramaeqi;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131166921));
        paramView.setMaxWidth(BaseChatItemLayout.d);
        paramView.setSpannableFactory(bamp.a);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131364176);
        localafvc.jdField_a_of_type_AndroidWidgetTextView = paramView;
        localafvc.jdField_a_of_type_Ajxp = new ajxp();
        localafvc.jdField_a_of_type_Ajxp.a(paramView);
        localafvc.jdField_a_of_type_Ajxp.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      if ((i == 2) && (localafvc.jdField_a_of_type_AndroidViewViewGroup == null)) {
        paramView = a(localContext, localafvc, paramBaseChatItemLayout);
      }
      for (;;)
      {
        if (localafvc.jdField_a_of_type_AndroidWidgetTextView != null) {
          localafvc.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        }
        if (i == 2)
        {
          localafvc.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          afzh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localafvc.jdField_a_of_type_AndroidViewViewGroup, localMessageForLongMsg.mSourceMsgInfo, localMessageForLongMsg.frienduin, localMessageForLongMsg.istroop, paramChatMessage, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localafvc.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localafvc.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramaetk);
          localafvc.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramaetk);
          label261:
          paramView.setOnTouchListener(paramaetk);
          paramView.setOnLongClickListener(paramaetk);
          if (localafvc.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localafvc.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramaetk);
            localafvc.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramaetk);
            if (!TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
              break label575;
            }
            localafvc.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb);
          }
        }
        for (;;)
        {
          if ((localafvc.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
          {
            paramBaseChatItemLayout = (AnimationTextView)localafvc.jdField_a_of_type_AndroidWidgetTextView;
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramBaseChatItemLayout, paramaeqi.jdField_b_of_type_Int, paramaeqi.c, true);
            paramBaseChatItemLayout.onDoubleClick = this.jdField_a_of_type_Bemz;
            paramBaseChatItemLayout.onSingleClick = new afux(this, paramChatMessage.isSend());
            paramBaseChatItemLayout.setStrokeColor(false, 0);
          }
          if ((localafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bemz;
          }
          if ((localafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bemz;
          }
          paramaeqi = gj.a(paramChatMessage);
          if (localafvc.jdField_a_of_type_AndroidWidgetTextView != null) {
            localafvc.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramaeqi);
          }
          if (localafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            localafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramaeqi);
          }
          if (localafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null) {
            localafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramaeqi);
          }
          if (localafvc.jdField_b_of_type_AndroidWidgetTextView != null) {
            localafvc.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramaeqi);
          }
          if (localafvc.jdField_a_of_type_Ajxp != null) {
            localafvc.jdField_a_of_type_Ajxp.b(paramChatMessage);
          }
          return paramView;
          paramView = a(localContext, localafvc, paramBaseChatItemLayout);
          break;
          if (localafvc.jdField_a_of_type_AndroidViewViewGroup == null) {
            break label261;
          }
          localafvc.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          break label261;
          label575:
          localafvc.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb2);
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, afvc paramafvc, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = afzh.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramafvc.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramafvc.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131370977));
    paramafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131370777));
    paramafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131370794));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131166921));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.d);
    ((AnimationTextView)localObject).setSpannableFactory(bamp.a);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131364176);
    localLinearLayout.addView((View)localObject);
    paramafvc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    int i = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    paramafvc.jdField_a_of_type_Ajxp = new ajxp();
    paramafvc.jdField_a_of_type_Ajxp.a((ajyb)localObject);
    paramafvc.jdField_a_of_type_Ajxp.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    return localLinearLayout;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return alud.a(2131706774) + banh.e(paramChatMessage.msg);
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
    case 2131365071: 
    case 2131370861: 
    case 2131364912: 
    case 2131375708: 
    case 2131366760: 
    case 2131361809: 
      do
      {
        do
        {
          return;
          str1 = "";
          break;
          acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          return;
          super.d(paramChatMessage);
          return;
          if (ajxm.a().c())
          {
            paramContext = ajxm.a().a();
            if (paramContext != null) {
              if (paramContext.length() == ajxm.a().a()) {
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
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
            return;
            paramInt = 0;
            continue;
            paramInt = 0;
            continue;
            paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
            paramInt = 1;
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
        return;
        paramContext = new Bundle();
        paramContext.putInt("forward_type", -1);
        paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
        paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (ajxm.a().c())
        {
          paramChatMessage = ajxm.a().a();
          paramContext.putString("forward_text", paramChatMessage);
          if (paramChatMessage != null) {
            if (paramChatMessage.length() == ajxm.a().a()) {
              paramInt = 1;
            }
          }
        }
        for (;;)
        {
          paramChatMessage = new Intent();
          paramChatMessage.putExtras(paramContext);
          aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramInt == 0) {
            break;
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
          paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
          paramInt = 1;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramContext.putExtra("url", "http://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
    case 2131366017: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    case 2131370818: 
      super.a(paramChatMessage);
      return;
    }
    ajxm.a().a(paramChatMessage);
  }
  
  public void a(aeqi paramaeqi, View paramView, ChatMessage paramChatMessage, anwo paramanwo)
  {
    afvc localafvc = (afvc)paramaeqi;
    if ((paramanwo.jdField_a_of_type_Int == 0) || (!paramanwo.a()))
    {
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend())
      {
        paramaeqi = paramView.getColorStateList(2131166925);
        if (paramaeqi != null)
        {
          localafvc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaeqi);
          if (localafvc.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localafvc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaeqi);
            localafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaeqi);
            localafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaeqi);
          }
        }
        if (atlt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          if (!paramChatMessage.isSend()) {
            break label239;
          }
          i = -1;
          label110:
          localafvc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
          if (localafvc.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localafvc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
            localafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
            localafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label247;
        }
      }
      label239:
      label247:
      for (paramaeqi = paramView.getColorStateList(2131166924);; paramaeqi = paramView.getColorStateList(2131166923))
      {
        localafvc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaeqi);
        if (localafvc.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaeqi);
          localafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaeqi);
          localafvc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaeqi);
          ImmersiveUtils.a(localafvc.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        }
        return;
        paramaeqi = paramView.getColorStateList(2131166921);
        break;
        i = -16777216;
        break label110;
      }
    }
    if (paramanwo.jdField_b_of_type_Int == 0)
    {
      localafvc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (localafvc.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localafvc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      }
      if (paramanwo.c != 0) {
        break label520;
      }
      paramaeqi = paramView.getResources().getColorStateList(2131166923);
      localafvc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaeqi);
      if (localafvc.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaeqi);
        localafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaeqi);
      }
      label372:
      if ((localafvc.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        if (!paramanwo.jdField_a_of_type_Boolean) {
          break label570;
        }
        ((AnimationTextView)localafvc.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramanwo.d);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramanwo.d);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.a(localafvc.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      return;
      localafvc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramanwo.jdField_b_of_type_Int);
      if (localafvc.jdField_a_of_type_AndroidViewViewGroup == null) {
        break;
      }
      localafvc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramanwo.jdField_b_of_type_Int);
      localafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramanwo.jdField_b_of_type_Int);
      localafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramanwo.jdField_b_of_type_Int);
      break;
      label520:
      localafvc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramanwo.c);
      if (localafvc.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label372;
      }
      localafvc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramanwo.c);
      localafvc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramanwo.c);
      break label372;
      label570:
      if ((paramanwo.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localafvc.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localafvc.jdField_a_of_type_Anwo.jdField_a_of_type_Double) == 1))
      {
        paramaeqi = (AnimationTextView)localafvc.jdField_a_of_type_AndroidWidgetTextView;
        float f2 = paramaeqi.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramaeqi.setTextColor(-1);
        paramaeqi.setShadowLayer(f1, 0.0F, 0.0F, paramanwo.d);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aepi.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)aepi.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690042);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690043);
    } while (!paramView.isSendFromLocal());
    bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new afuy(this, paramView), new afuz(this)).show();
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
      aeqi localaeqi = (aeqi)paramView.getTag();
      if (localaeqi != null) {
        a(localaeqi, paramView, paramChatMessage, localaeqi.jdField_a_of_type_Anwo);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aeqi paramaeqi, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaeqi, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!ajxm.a().c()) {
        break label115;
      }
      str = ajxm.a().a();
      if (str == null) {
        break label110;
      }
      if (str.length() != ajxm.a().a()) {
        break label105;
      }
      i = 1;
      if ((i == 0) && (str != null)) {
        break label122;
      }
      biva.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramMessageForLongMsg.istroop);
    }
    for (;;)
    {
      bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
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
      biva.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramMessageForLongMsg.istroop);
    }
  }
  
  public bdpk[] a(View paramView)
  {
    paramView = (MessageForLongMsg)aepi.a(paramView);
    bdpi localbdpi = new bdpi();
    if (ApolloUtil.a(paramView)) {
      return localbdpi.a();
    }
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localbdpi.a(2131364912, this.jdField_a_of_type_AndroidContentContext.getString(2131719145), 2130838669);
      localbdpi.a(2131375708, this.jdField_a_of_type_AndroidContentContext.getString(2131719152), 2130838683);
    }
    for (;;)
    {
      localbdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
      a(paramView, localbdpi);
      if ((paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
        localbdpi.a(2131361809, this.jdField_a_of_type_AndroidContentContext.getString(2131717648), 2130838656);
      }
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbdpi, paramView);
      if (aepi.a(5) == 1) {
        localbdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
      }
      b(paramView, localbdpi);
      super.c(localbdpi, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
      return localbdpi.a();
      localbdpi.a(2131364912, alud.a(2131706773), 2130838669);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afuw
 * JD-Core Version:    0.7.0.1
 */