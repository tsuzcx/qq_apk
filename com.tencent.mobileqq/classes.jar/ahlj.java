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

public class ahlj
  extends BaseBubbleBuilder
  implements aggk
{
  private static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  protected View.OnClickListener a;
  biuy a;
  
  public ahlj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Biuy = new ahln(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahlo(this);
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
  
  public aggk a(View paramView)
  {
    paramView = agej.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  public aggl a()
  {
    return new ahlp(this);
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    ahlp localahlp = (ahlp)paramaggl;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131167009));
        paramView.setMaxWidth(BaseChatItemLayout.e);
        paramView.setSpannableFactory(begp.a);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131364426);
        localahlp.jdField_a_of_type_AndroidWidgetTextView = paramView;
        localahlp.jdField_a_of_type_Ambx = new ambx();
        localahlp.jdField_a_of_type_Ambx.a(paramView);
        localahlp.jdField_a_of_type_Ambx.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      if ((i == 2) && (localahlp.jdField_a_of_type_AndroidViewViewGroup == null)) {
        paramView = a(localContext, localahlp, paramBaseChatItemLayout);
      }
      for (;;)
      {
        if (localahlp.jdField_a_of_type_AndroidWidgetTextView != null) {
          localahlp.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        }
        if (i == 2)
        {
          localahlp.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          ahpx.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localahlp.jdField_a_of_type_AndroidViewViewGroup, localMessageForLongMsg.mSourceMsgInfo, localMessageForLongMsg.frienduin, localMessageForLongMsg.istroop, paramChatMessage, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localahlp.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localahlp.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramagjk);
          localahlp.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramagjk);
          label261:
          paramView.setOnTouchListener(paramagjk);
          paramView.setOnLongClickListener(paramagjk);
          if (localahlp.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localahlp.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramagjk);
            localahlp.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramagjk);
            if (!TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
              break label633;
            }
            localahlp.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb);
          }
        }
        for (;;)
        {
          if ((localahlp.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
          {
            paramagjk = (AnimationTextView)localahlp.jdField_a_of_type_AndroidWidgetTextView;
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramagjk, paramaggl.jdField_b_of_type_Int, paramaggl.c, true);
            paramagjk.onDoubleClick = this.jdField_a_of_type_Biuy;
            paramagjk.onSingleClick = new ahlk(this, paramChatMessage.isSend());
            paramagjk.setStrokeColor(false, 0);
          }
          if ((localahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Biuy;
          }
          if ((localahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Biuy;
          }
          paramaggl = go.a(paramChatMessage);
          if (localahlp.jdField_a_of_type_AndroidWidgetTextView != null) {
            localahlp.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramaggl);
          }
          if (localahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            localahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramaggl);
          }
          if (localahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null) {
            localahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramaggl);
          }
          if (localahlp.jdField_b_of_type_AndroidWidgetTextView != null) {
            localahlp.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramaggl);
          }
          if (localahlp.jdField_a_of_type_Ambx != null) {
            localahlp.jdField_a_of_type_Ambx.b(paramChatMessage);
          }
          if ((localahlp != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
          {
            localahlp.c = super.a(localahlp.c, localahlp, paramBaseChatItemLayout, paramChatMessage, -2, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
            super.a(localahlp.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
          }
          return paramView;
          paramView = a(localContext, localahlp, paramBaseChatItemLayout);
          break;
          if (localahlp.jdField_a_of_type_AndroidViewViewGroup == null) {
            break label261;
          }
          localahlp.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          break label261;
          label633:
          localahlp.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb2);
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, ahlp paramahlp, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = ahpx.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramahlp.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramahlp.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131371647));
    paramahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371445));
    paramahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371462));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167009));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
    ((AnimationTextView)localObject).setSpannableFactory(begp.a);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131364426);
    localLinearLayout.addView((View)localObject);
    paramahlp.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    int i = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    paramahlp.jdField_a_of_type_Ambx = new ambx();
    paramahlp.jdField_a_of_type_Ambx.a((amcj)localObject);
    paramahlp.jdField_a_of_type_Ambx.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    return localLinearLayout;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anzj.a(2131705272) + behh.e(paramChatMessage.msg);
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
    case 2131365352: 
    case 2131371530: 
    case 2131365191: 
    case 2131376567: 
      do
      {
        return;
        str1 = "";
        break;
        aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
        super.d(paramChatMessage);
        return;
        if (ambu.a().c())
        {
          paramContext = ambu.a().b();
          if (paramContext != null) {
            if (paramContext.length() == ambu.a().a()) {
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
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
          paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
          paramInt = 1;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
      return;
    case 2131367078: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (ambu.a().c())
      {
        paramChatMessage = ambu.a().b();
        paramContext.putString("forward_text", paramChatMessage);
        if (paramChatMessage != null) {
          if (paramChatMessage.length() == ambu.a().a()) {
            paramInt = 1;
          }
        }
      }
      for (;;)
      {
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (paramInt == 0) {
          break;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
        return;
        paramInt = 0;
        continue;
        paramInt = 0;
        continue;
        paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
        paramInt = 1;
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      return;
    case 2131366320: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    case 2131371487: 
      super.a(paramChatMessage);
      return;
    }
    ambu.a().a(paramChatMessage);
  }
  
  public void a(aggl paramaggl, View paramView, ChatMessage paramChatMessage, aqkt paramaqkt)
  {
    ahlp localahlp = (ahlp)paramaggl;
    if ((paramaqkt.jdField_a_of_type_Int == 0) || (!paramaqkt.a()))
    {
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend())
      {
        paramaggl = paramView.getColorStateList(2131167013);
        if (paramaggl != null)
        {
          localahlp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaggl);
          if (localahlp.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localahlp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaggl);
            localahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaggl);
            localahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaggl);
          }
        }
        if (awlm.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          if (!paramChatMessage.isSend()) {
            break label239;
          }
          i = -1;
          label110:
          localahlp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
          if (localahlp.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localahlp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
            localahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
            localahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label247;
        }
      }
      label239:
      label247:
      for (paramaggl = paramView.getColorStateList(2131167012);; paramaggl = paramView.getColorStateList(2131167011))
      {
        localahlp.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaggl);
        if (localahlp.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
          localahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
          localahlp.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaggl);
          ImmersiveUtils.a(localahlp.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        }
        return;
        paramaggl = paramView.getColorStateList(2131167009);
        break;
        i = -16777216;
        break label110;
      }
    }
    if (paramaqkt.jdField_b_of_type_Int == 0)
    {
      localahlp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (localahlp.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localahlp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      }
      if (paramaqkt.c != 0) {
        break label520;
      }
      paramaggl = paramView.getResources().getColorStateList(2131167011);
      localahlp.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaggl);
      if (localahlp.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
        localahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaggl);
      }
      label372:
      if ((localahlp.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        if (!paramaqkt.jdField_a_of_type_Boolean) {
          break label570;
        }
        ((AnimationTextView)localahlp.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramaqkt.d);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramaqkt.d);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.a(localahlp.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      return;
      localahlp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
      if (localahlp.jdField_a_of_type_AndroidViewViewGroup == null) {
        break;
      }
      localahlp.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
      localahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
      localahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
      break;
      label520:
      localahlp.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaqkt.c);
      if (localahlp.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label372;
      }
      localahlp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqkt.c);
      localahlp.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramaqkt.c);
      break label372;
      label570:
      if ((paramaqkt.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localahlp.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localahlp.jdField_a_of_type_Aqkt.jdField_a_of_type_Double) == 1))
      {
        paramaggl = (AnimationTextView)localahlp.jdField_a_of_type_AndroidWidgetTextView;
        float f2 = paramaggl.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramaggl.setTextColor(-1);
        paramaggl.setShadowLayer(f1, 0.0F, 0.0F, paramaqkt.d);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (agej.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)agej.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689933);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689934);
    } while (!paramView.isSendFromLocal());
    bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahll(this, paramView), new ahlm(this)).show();
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
      aggl localaggl = (aggl)paramView.getTag();
      if (localaggl != null) {
        a(localaggl, paramView, paramChatMessage, localaggl.jdField_a_of_type_Aqkt);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aggl paramaggl, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaggl, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!ambu.a().c()) {
        break label115;
      }
      str = ambu.a().b();
      if (str == null) {
        break label110;
      }
      if (str.length() != ambu.a().a()) {
        break label105;
      }
      i = 1;
      if ((i == 0) && (str != null)) {
        break label122;
      }
      bmko.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramMessageForLongMsg.istroop);
    }
    for (;;)
    {
      bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
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
      bmko.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramMessageForLongMsg.istroop);
    }
  }
  
  public bhum[] a(View paramView)
  {
    paramView = (MessageForLongMsg)agej.a(paramView);
    bhuk localbhuk = new bhuk();
    if (ApolloUtil.a(paramView)) {
      return localbhuk.a();
    }
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localbhuk.a(2131365191, this.jdField_a_of_type_AndroidContentContext.getString(2131717396), 2130838930);
      localbhuk.a(2131376567, this.jdField_a_of_type_AndroidContentContext.getString(2131717399), 2130838944);
    }
    for (;;)
    {
      localbhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
      a(paramView, localbhuk);
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbhuk, paramView);
      if (agej.a(5) == 1) {
        localbhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131691990), 2130838938);
      }
      super.a(localbhuk, this.jdField_a_of_type_AndroidContentContext, paramView);
      if (paramView.msgtype == -1037) {
        c(paramView, localbhuk);
      }
      b(paramView, localbhuk);
      super.c(localbhuk, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
      return localbhuk.a();
      localbhuk.a(2131365191, anzj.a(2131705271), 2130838930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlj
 * JD-Core Version:    0.7.0.1
 */