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

public class afqh
  extends BaseBubbleBuilder
  implements aels
{
  private static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  private static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected View.OnClickListener a;
  beiq a;
  
  public afqh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Beiq = new afql(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afqm(this);
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
  
  public aels a(View paramView)
  {
    paramView = aekt.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  public aelt a()
  {
    return new afqn(this);
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    afqn localafqn = (afqn)paramaelt;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131166919));
        paramView.setMaxWidth(BaseChatItemLayout.d);
        paramView.setSpannableFactory(baig.a);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131364174);
        localafqn.jdField_a_of_type_AndroidWidgetTextView = paramView;
        localafqn.jdField_a_of_type_Ajta = new ajta();
        localafqn.jdField_a_of_type_Ajta.a(paramView);
        localafqn.jdField_a_of_type_Ajta.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      if ((i == 2) && (localafqn.jdField_a_of_type_AndroidViewViewGroup == null)) {
        paramView = a(localContext, localafqn, paramBaseChatItemLayout);
      }
      for (;;)
      {
        if (localafqn.jdField_a_of_type_AndroidWidgetTextView != null) {
          localafqn.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        }
        if (i == 2)
        {
          localafqn.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          afus.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localafqn.jdField_a_of_type_AndroidViewViewGroup, localMessageForLongMsg.mSourceMsgInfo, localMessageForLongMsg.frienduin, localMessageForLongMsg.istroop, paramChatMessage, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localafqn.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localafqn.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramaeov);
          localafqn.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramaeov);
          label261:
          paramView.setOnTouchListener(paramaeov);
          paramView.setOnLongClickListener(paramaeov);
          if (localafqn.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localafqn.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramaeov);
            localafqn.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramaeov);
            if (!TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
              break label575;
            }
            localafqn.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb);
          }
        }
        for (;;)
        {
          if ((localafqn.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
          {
            paramBaseChatItemLayout = (AnimationTextView)localafqn.jdField_a_of_type_AndroidWidgetTextView;
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramBaseChatItemLayout, paramaelt.jdField_b_of_type_Int, paramaelt.c, true);
            paramBaseChatItemLayout.onDoubleClick = this.jdField_a_of_type_Beiq;
            paramBaseChatItemLayout.onSingleClick = new afqi(this, paramChatMessage.isSend());
            paramBaseChatItemLayout.setStrokeColor(false, 0);
          }
          if ((localafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Beiq;
          }
          if ((localafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Beiq;
          }
          paramaelt = gj.a(paramChatMessage);
          if (localafqn.jdField_a_of_type_AndroidWidgetTextView != null) {
            localafqn.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramaelt);
          }
          if (localafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            localafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramaelt);
          }
          if (localafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null) {
            localafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramaelt);
          }
          if (localafqn.jdField_b_of_type_AndroidWidgetTextView != null) {
            localafqn.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramaelt);
          }
          if (localafqn.jdField_a_of_type_Ajta != null) {
            localafqn.jdField_a_of_type_Ajta.b(paramChatMessage);
          }
          return paramView;
          paramView = a(localContext, localafqn, paramBaseChatItemLayout);
          break;
          if (localafqn.jdField_a_of_type_AndroidViewViewGroup == null) {
            break label261;
          }
          localafqn.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          break label261;
          label575:
          localafqn.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb2);
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, afqn paramafqn, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = afus.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramafqn.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramafqn.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131370958));
    paramafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131370758));
    paramafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131370775));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131166919));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.d);
    ((AnimationTextView)localObject).setSpannableFactory(baig.a);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131364174);
    localLinearLayout.addView((View)localObject);
    paramafqn.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    int i = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    paramafqn.jdField_a_of_type_Ajta = new ajta();
    paramafqn.jdField_a_of_type_Ajta.a((ajtm)localObject);
    paramafqn.jdField_a_of_type_Ajta.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    return localLinearLayout;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return alpo.a(2131706762) + baiy.e(paramChatMessage.msg);
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
    case 2131365069: 
    case 2131370842: 
    case 2131364910: 
    case 2131375657: 
    case 2131366750: 
    case 2131361809: 
      do
      {
        do
        {
          return;
          str1 = "";
          break;
          acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          return;
          super.d(paramChatMessage);
          return;
          if (ajsx.a().c())
          {
            paramContext = ajsx.a().a();
            if (paramContext != null) {
              if (paramContext.length() == ajsx.a().a()) {
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
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
            return;
            paramInt = 0;
            continue;
            paramInt = 0;
            continue;
            paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
            paramInt = 1;
          }
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
        return;
        paramContext = new Bundle();
        paramContext.putInt("forward_type", -1);
        paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
        paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (ajsx.a().c())
        {
          paramChatMessage = ajsx.a().a();
          paramContext.putString("forward_text", paramChatMessage);
          if (paramChatMessage != null) {
            if (paramChatMessage.length() == ajsx.a().a()) {
              paramInt = 1;
            }
          }
        }
        for (;;)
        {
          paramChatMessage = new Intent();
          paramChatMessage.putExtras(paramContext);
          arum.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramInt == 0) {
            break;
          }
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
          paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
          paramInt = 1;
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      azmz.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramContext.putExtra("url", "http://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
    case 2131366015: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    case 2131370799: 
      super.a(paramChatMessage);
      return;
    }
    ajsx.a().a(paramChatMessage);
  }
  
  public void a(aelt paramaelt, View paramView, ChatMessage paramChatMessage, ansf paramansf)
  {
    afqn localafqn = (afqn)paramaelt;
    if ((paramansf.jdField_a_of_type_Int == 0) || (!paramansf.a()))
    {
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend())
      {
        paramaelt = paramView.getColorStateList(2131166923);
        if (paramaelt != null)
        {
          localafqn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaelt);
          if (localafqn.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localafqn.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaelt);
            localafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaelt);
            localafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaelt);
          }
        }
        if (athk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          if (!paramChatMessage.isSend()) {
            break label239;
          }
          i = -1;
          label110:
          localafqn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
          if (localafqn.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localafqn.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
            localafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
            localafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label247;
        }
      }
      label239:
      label247:
      for (paramaelt = paramView.getColorStateList(2131166922);; paramaelt = paramView.getColorStateList(2131166921))
      {
        localafqn.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaelt);
        if (localafqn.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaelt);
          localafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaelt);
          localafqn.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaelt);
          ImmersiveUtils.a(localafqn.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        }
        return;
        paramaelt = paramView.getColorStateList(2131166919);
        break;
        i = -16777216;
        break label110;
      }
    }
    if (paramansf.jdField_b_of_type_Int == 0)
    {
      localafqn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (localafqn.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localafqn.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      }
      if (paramansf.c != 0) {
        break label520;
      }
      paramaelt = paramView.getResources().getColorStateList(2131166921);
      localafqn.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaelt);
      if (localafqn.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaelt);
        localafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaelt);
      }
      label372:
      if ((localafqn.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        if (!paramansf.jdField_a_of_type_Boolean) {
          break label570;
        }
        ((AnimationTextView)localafqn.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramansf.d);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramansf.d);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.a(localafqn.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      return;
      localafqn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramansf.jdField_b_of_type_Int);
      if (localafqn.jdField_a_of_type_AndroidViewViewGroup == null) {
        break;
      }
      localafqn.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramansf.jdField_b_of_type_Int);
      localafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramansf.jdField_b_of_type_Int);
      localafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramansf.jdField_b_of_type_Int);
      break;
      label520:
      localafqn.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramansf.c);
      if (localafqn.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label372;
      }
      localafqn.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramansf.c);
      localafqn.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramansf.c);
      break label372;
      label570:
      if ((paramansf.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localafqn.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localafqn.jdField_a_of_type_Ansf.jdField_a_of_type_Double) == 1))
      {
        paramaelt = (AnimationTextView)localafqn.jdField_a_of_type_AndroidWidgetTextView;
        float f2 = paramaelt.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramaelt.setTextColor(-1);
        paramaelt.setShadowLayer(f1, 0.0F, 0.0F, paramansf.d);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aekt.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)aekt.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690042);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690043);
    } while (!paramView.isSendFromLocal());
    bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new afqj(this, paramView), new afqk(this)).show();
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
      aelt localaelt = (aelt)paramView.getTag();
      if (localaelt != null) {
        a(localaelt, paramView, paramChatMessage, localaelt.jdField_a_of_type_Ansf);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaelt, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!ajsx.a().c()) {
        break label115;
      }
      str = ajsx.a().a();
      if (str == null) {
        break label110;
      }
      if (str.length() != ajsx.a().a()) {
        break label105;
      }
      i = 1;
      if ((i == 0) && (str != null)) {
        break label122;
      }
      biqt.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramMessageForLongMsg.istroop);
    }
    for (;;)
    {
      birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
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
      biqt.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramMessageForLongMsg.istroop);
    }
  }
  
  public bdlb[] a(View paramView)
  {
    paramView = (MessageForLongMsg)aekt.a(paramView);
    bdkz localbdkz = new bdkz();
    if (ApolloUtil.a(paramView)) {
      return localbdkz.a();
    }
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localbdkz.a(2131364910, this.jdField_a_of_type_AndroidContentContext.getString(2131719133), 2130838668);
      localbdkz.a(2131375657, this.jdField_a_of_type_AndroidContentContext.getString(2131719140), 2130838682);
    }
    for (;;)
    {
      localbdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
      a(paramView, localbdkz);
      if ((paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
        localbdkz.a(2131361809, this.jdField_a_of_type_AndroidContentContext.getString(2131717636), 2130838655);
      }
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbdkz, paramView);
      if (aekt.a(5) == 1) {
        localbdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838676);
      }
      b(paramView, localbdkz);
      super.c(localbdkz, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
      return localbdkz.a();
      localbdkz.a(2131364910, alpo.a(2131706761), 2130838668);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqh
 * JD-Core Version:    0.7.0.1
 */