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

public class adtw
  extends BaseBubbleBuilder
  implements acum
{
  private static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  private static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected View.OnClickListener a;
  bcjb a;
  
  public adtw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Bcjb = new adua(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adub(this);
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
  
  public acum a(View paramView)
  {
    paramView = actn.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  public acun a()
  {
    return new aduc(this);
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    aduc localaduc = (aduc)paramacun;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131166872));
        paramView.setMaxWidth(BaseChatItemLayout.d);
        paramView.setSpannableFactory(ayki.a);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131364113);
        localaduc.jdField_a_of_type_AndroidWidgetTextView = paramView;
        localaduc.jdField_a_of_type_Aibs = new aibs();
        localaduc.jdField_a_of_type_Aibs.a(paramView);
        localaduc.jdField_a_of_type_Aibs.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      if ((i == 2) && (localaduc.jdField_a_of_type_AndroidViewViewGroup == null)) {
        paramView = a(localContext, localaduc, paramBaseChatItemLayout);
      }
      for (;;)
      {
        if (localaduc.jdField_a_of_type_AndroidWidgetTextView != null) {
          localaduc.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        }
        if (i == 2)
        {
          localaduc.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          adyh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaduc.jdField_a_of_type_AndroidViewViewGroup, localMessageForLongMsg.mSourceMsgInfo, localMessageForLongMsg.frienduin, localMessageForLongMsg.istroop, paramChatMessage, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localaduc.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localaduc.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramacxn);
          localaduc.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramacxn);
          label261:
          paramView.setOnTouchListener(paramacxn);
          paramView.setOnLongClickListener(paramacxn);
          if (localaduc.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localaduc.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramacxn);
            localaduc.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramacxn);
            if (!TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
              break label575;
            }
            localaduc.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb);
          }
        }
        for (;;)
        {
          if ((localaduc.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
          {
            paramBaseChatItemLayout = (AnimationTextView)localaduc.jdField_a_of_type_AndroidWidgetTextView;
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramBaseChatItemLayout, paramacun.jdField_b_of_type_Int, paramacun.c, true);
            paramBaseChatItemLayout.onDoubleClick = this.jdField_a_of_type_Bcjb;
            paramBaseChatItemLayout.onSingleClick = new adtx(this, paramChatMessage.isSend());
            paramBaseChatItemLayout.setStrokeColor(false, 0);
          }
          if ((localaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bcjb;
          }
          if ((localaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_Bcjb;
          }
          paramacun = ia.a(paramChatMessage);
          if (localaduc.jdField_a_of_type_AndroidWidgetTextView != null) {
            localaduc.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramacun);
          }
          if (localaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            localaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramacun);
          }
          if (localaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null) {
            localaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramacun);
          }
          if (localaduc.jdField_b_of_type_AndroidWidgetTextView != null) {
            localaduc.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramacun);
          }
          if (localaduc.jdField_a_of_type_Aibs != null) {
            localaduc.jdField_a_of_type_Aibs.b(paramChatMessage);
          }
          return paramView;
          paramView = a(localContext, localaduc, paramBaseChatItemLayout);
          break;
          if (localaduc.jdField_a_of_type_AndroidViewViewGroup == null) {
            break label261;
          }
          localaduc.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          break label261;
          label575:
          localaduc.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb2);
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, aduc paramaduc, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = adyh.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramaduc.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramaduc.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131370647));
    paramaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131370453));
    paramaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131370470));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131166872));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.d);
    ((AnimationTextView)localObject).setSpannableFactory(ayki.a);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131364113);
    localLinearLayout.addView((View)localObject);
    paramaduc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    int i = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    paramaduc.jdField_a_of_type_Aibs = new aibs();
    paramaduc.jdField_a_of_type_Aibs.a((aice)localObject);
    paramaduc.jdField_a_of_type_Aibs.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    return localLinearLayout;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajyc.a(2131706379) + ayla.e(paramChatMessage.msg);
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
    case 2131364985: 
    case 2131370537: 
    case 2131364825: 
    case 2131375174: 
    case 2131366632: 
    case 2131361810: 
      do
      {
        do
        {
          return;
          str1 = "";
          break;
          aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          return;
          super.d(paramChatMessage);
          return;
          if (aibp.a().c())
          {
            paramContext = aibp.a().a();
            if (paramContext != null) {
              if (paramContext.length() == aibp.a().a()) {
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
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
            return;
            paramInt = 0;
            continue;
            paramInt = 0;
            continue;
            paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
            paramInt = 1;
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        aaod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
        return;
        paramContext = new Bundle();
        paramContext.putInt("forward_type", -1);
        paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
        paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (aibp.a().c())
        {
          paramChatMessage = aibp.a().a();
          paramContext.putString("forward_text", paramChatMessage);
          if (paramChatMessage != null) {
            if (paramChatMessage.length() == aibp.a().a()) {
              paramInt = 1;
            }
          }
        }
        for (;;)
        {
          paramChatMessage = new Intent();
          paramChatMessage.putExtras(paramContext);
          aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramInt == 0) {
            break;
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
          paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
          paramInt = 1;
        }
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
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
    case 2131370494: 
      super.a(paramChatMessage);
      return;
    }
    aibp.a().a(paramChatMessage);
  }
  
  public void a(acun paramacun, View paramView, ChatMessage paramChatMessage, ambh paramambh)
  {
    aduc localaduc = (aduc)paramacun;
    if ((paramambh.jdField_a_of_type_Int == 0) || (!paramambh.a()))
    {
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend())
      {
        paramacun = paramView.getColorStateList(2131166876);
        if (paramacun != null)
        {
          localaduc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacun);
          if (localaduc.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localaduc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramacun);
            localaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacun);
            localaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacun);
          }
        }
        if (arqn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          if (!paramChatMessage.isSend()) {
            break label239;
          }
          i = -1;
          label110:
          localaduc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
          if (localaduc.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localaduc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
            localaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
            localaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label247;
        }
      }
      label239:
      label247:
      for (paramacun = paramView.getColorStateList(2131166875);; paramacun = paramView.getColorStateList(2131166874))
      {
        localaduc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacun);
        if (localaduc.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
          localaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
          localaduc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacun);
          ImmersiveUtils.a(localaduc.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        }
        return;
        paramacun = paramView.getColorStateList(2131166872);
        break;
        i = -16777216;
        break label110;
      }
    }
    if (paramambh.jdField_b_of_type_Int == 0)
    {
      localaduc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (localaduc.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localaduc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      }
      if (paramambh.c != 0) {
        break label520;
      }
      paramacun = paramView.getResources().getColorStateList(2131166874);
      localaduc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacun);
      if (localaduc.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
        localaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacun);
      }
      label372:
      if ((localaduc.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        if (!paramambh.jdField_a_of_type_Boolean) {
          break label570;
        }
        ((AnimationTextView)localaduc.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramambh.d);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramambh.d);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.a(localaduc.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      return;
      localaduc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambh.jdField_b_of_type_Int);
      if (localaduc.jdField_a_of_type_AndroidViewViewGroup == null) {
        break;
      }
      localaduc.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramambh.jdField_b_of_type_Int);
      localaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramambh.jdField_b_of_type_Int);
      localaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramambh.jdField_b_of_type_Int);
      break;
      label520:
      localaduc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramambh.c);
      if (localaduc.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label372;
      }
      localaduc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramambh.c);
      localaduc.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramambh.c);
      break label372;
      label570:
      if ((paramambh.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaduc.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localaduc.jdField_a_of_type_Ambh.jdField_a_of_type_Double) == 1))
      {
        paramacun = (AnimationTextView)localaduc.jdField_a_of_type_AndroidWidgetTextView;
        float f2 = paramacun.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramacun.setTextColor(-1);
        paramacun.setShadowLayer(f1, 0.0F, 0.0F, paramambh.d);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (actn.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)actn.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689995);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689996);
    } while (!paramView.isSendFromLocal());
    bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adty(this, paramView), new adtz(this)).show();
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
      acun localacun = (acun)paramView.getTag();
      if (localacun != null) {
        a(localacun, paramView, paramChatMessage, localacun.jdField_a_of_type_Ambh);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacun, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!aibp.a().c()) {
        break label115;
      }
      str = aibp.a().a();
      if (str == null) {
        break label110;
      }
      if (str.length() != aibp.a().a()) {
        break label105;
      }
      i = 1;
      if ((i == 0) && (str != null)) {
        break label122;
      }
      bgpd.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramMessageForLongMsg.istroop);
    }
    for (;;)
    {
      bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
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
      bgpd.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramMessageForLongMsg.istroop);
    }
  }
  
  public bblt[] a(View paramView)
  {
    paramView = (MessageForLongMsg)actn.a(paramView);
    bblr localbblr = new bblr();
    if (ApolloUtil.a(paramView)) {
      return localbblr.a();
    }
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localbblr.a(2131364825, this.jdField_a_of_type_AndroidContentContext.getString(2131718649), 2130838597);
      localbblr.a(2131375174, this.jdField_a_of_type_AndroidContentContext.getString(2131718656), 2130838611);
    }
    for (;;)
    {
      localbblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692752), 2130838606);
      a(paramView, localbblr);
      if ((paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
        localbblr.a(2131361810, this.jdField_a_of_type_AndroidContentContext.getString(2131717253), 2130838584);
      }
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbblr, paramView);
      if (actn.a(5) == 1) {
        localbblr.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      b(paramView, localbblr);
      super.c(localbblr, this.jdField_a_of_type_AndroidContentContext);
      super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
      return localbblr.a();
      localbblr.a(2131364825, ajyc.a(2131706378), 2130838597);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adtw
 * JD-Core Version:    0.7.0.1
 */