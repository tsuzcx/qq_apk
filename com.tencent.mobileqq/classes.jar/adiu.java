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

public class adiu
  extends BaseBubbleBuilder
  implements acjt
{
  private static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  private static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected View.OnClickListener a;
  bbgb a;
  
  public adiu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Bbgb = new adiy(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adiz(this);
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
  
  public acjt a(View paramView)
  {
    paramView = aciy.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  public acju a()
  {
    return new adja(this);
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    adja localadja = (adja)paramacju;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131101278));
        paramView.setMaxWidth(BaseChatItemLayout.d);
        paramView.setSpannableFactory(axkd.a);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131298555);
        localadja.jdField_a_of_type_AndroidWidgetTextView = paramView;
        localadja.jdField_a_of_type_Ahpa = new ahpa();
        localadja.jdField_a_of_type_Ahpa.a(paramView);
        localadja.jdField_a_of_type_Ahpa.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      if ((i == 2) && (localadja.jdField_a_of_type_AndroidViewViewGroup == null)) {
        paramView = a(localContext, localadja, paramBaseChatItemLayout);
      }
      for (;;)
      {
        if (localadja.jdField_a_of_type_AndroidWidgetTextView != null) {
          localadja.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        }
        if (i == 2)
        {
          localadja.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          adni.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localadja.jdField_a_of_type_AndroidViewViewGroup, localMessageForLongMsg.mSourceMsgInfo, localMessageForLongMsg.frienduin, localMessageForLongMsg.istroop, paramChatMessage, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localadja.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localadja.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramacmv);
          localadja.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramacmv);
          label261:
          paramView.setOnTouchListener(paramacmv);
          paramView.setOnLongClickListener(paramacmv);
          if (localadja.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localadja.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramacmv);
            localadja.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramacmv);
            if (!TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
              break label575;
            }
            localadja.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb);
          }
        }
        for (;;)
        {
          if ((localadja.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
          {
            paramBaseChatItemLayout = (AnimationTextView)localadja.jdField_a_of_type_AndroidWidgetTextView;
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramBaseChatItemLayout, paramacju.jdField_b_of_type_Int, paramacju.c, true);
            paramBaseChatItemLayout.jdField_a_of_type_Bbgb = this.jdField_a_of_type_Bbgb;
            paramBaseChatItemLayout.jdField_a_of_type_Bbgc = new adiv(this, paramChatMessage.isSend());
            paramBaseChatItemLayout.setStrokeColor(false, 0);
          }
          if ((localadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView.jdField_a_of_type_Bbgb = this.jdField_a_of_type_Bbgb;
          }
          if ((localadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView.jdField_a_of_type_Bbgb = this.jdField_a_of_type_Bbgb;
          }
          paramacju = gh.a(paramChatMessage);
          if (localadja.jdField_a_of_type_AndroidWidgetTextView != null) {
            localadja.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramacju);
          }
          if (localadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
            localadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramacju);
          }
          if (localadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null) {
            localadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramacju);
          }
          if (localadja.jdField_b_of_type_AndroidWidgetTextView != null) {
            localadja.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramacju);
          }
          if (localadja.jdField_a_of_type_Ahpa != null) {
            localadja.jdField_a_of_type_Ahpa.b(paramChatMessage);
          }
          return paramView;
          paramView = a(localContext, localadja, paramBaseChatItemLayout);
          break;
          if (localadja.jdField_a_of_type_AndroidViewViewGroup == null) {
            break label261;
          }
          localadja.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          break label261;
          label575:
          localadja.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb2);
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, adja paramadja, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = adni.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramadja.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramadja.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131304981));
    paramadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131304792));
    paramadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131304808));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131101278));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.d);
    ((AnimationTextView)localObject).setSpannableFactory(axkd.a);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131298555);
    localLinearLayout.addView((View)localObject);
    paramadja.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    int i = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    paramadja.jdField_a_of_type_Ahpa = new ahpa();
    paramadja.jdField_a_of_type_Ahpa.a((ahpm)localObject);
    paramadja.jdField_a_of_type_Ahpa.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    return localLinearLayout;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajjy.a(2131640594) + axku.e(paramChatMessage.msg);
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
    case 2131299417: 
    case 2131304871: 
    case 2131299262: 
    case 2131309426: 
    case 2131301021: 
    case 2131296274: 
      do
      {
        do
        {
          return;
          str1 = "";
          break;
          aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          return;
          super.d(paramChatMessage);
          return;
          if (ahox.a().c())
          {
            paramContext = ahox.a().a();
            if (paramContext != null) {
              if (paramContext.length() == ahox.a().a()) {
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
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
            return;
            paramInt = 0;
            continue;
            paramInt = 0;
            continue;
            paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
            paramInt = 1;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
        return;
        paramContext = new Bundle();
        paramContext.putInt("forward_type", -1);
        paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
        paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (ahox.a().c())
        {
          paramChatMessage = ahox.a().a();
          paramContext.putString("forward_text", paramChatMessage);
          if (paramChatMessage != null) {
            if (paramChatMessage.length() == ahox.a().a()) {
              paramInt = 1;
            }
          }
        }
        for (;;)
        {
          paramChatMessage = new Intent();
          paramChatMessage.putExtras(paramContext);
          aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (paramInt == 0) {
            break;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
          paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
          paramInt = 1;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      awrn.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramContext.putExtra("url", "http://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
    case 2131300328: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    case 2131304829: 
      super.a(paramChatMessage);
      return;
    }
    ahox.a().a(paramChatMessage);
  }
  
  public void a(acju paramacju, View paramView, ChatMessage paramChatMessage, almt paramalmt)
  {
    adja localadja = (adja)paramacju;
    if ((paramalmt.jdField_a_of_type_Int == 0) || (!paramalmt.a()))
    {
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend())
      {
        paramacju = paramView.getColorStateList(2131101282);
        if (paramacju != null)
        {
          localadja.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacju);
          if (localadja.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localadja.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramacju);
            localadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacju);
            localadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramacju);
          }
        }
        if (aqux.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          if (!paramChatMessage.isSend()) {
            break label239;
          }
          i = -1;
          label110:
          localadja.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
          if (localadja.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localadja.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
            localadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
            localadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label247;
        }
      }
      label239:
      label247:
      for (paramacju = paramView.getColorStateList(2131101281);; paramacju = paramView.getColorStateList(2131101280))
      {
        localadja.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacju);
        if (localadja.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
          localadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
          localadja.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacju);
          ImmersiveUtils.a(localadja.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        }
        return;
        paramacju = paramView.getColorStateList(2131101278);
        break;
        i = -16777216;
        break label110;
      }
    }
    if (paramalmt.jdField_b_of_type_Int == 0)
    {
      localadja.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (localadja.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localadja.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      }
      if (paramalmt.c != 0) {
        break label520;
      }
      paramacju = paramView.getResources().getColorStateList(2131101280);
      localadja.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacju);
      if (localadja.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
        localadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramacju);
      }
      label372:
      if ((localadja.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        if (!paramalmt.jdField_a_of_type_Boolean) {
          break label570;
        }
        ((AnimationTextView)localadja.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramalmt.d);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramalmt.d);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.a(localadja.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      return;
      localadja.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
      if (localadja.jdField_a_of_type_AndroidViewViewGroup == null) {
        break;
      }
      localadja.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
      localadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
      localadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
      break;
      label520:
      localadja.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramalmt.c);
      if (localadja.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label372;
      }
      localadja.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramalmt.c);
      localadja.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramalmt.c);
      break label372;
      label570:
      if ((paramalmt.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localadja.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localadja.jdField_a_of_type_Almt.jdField_a_of_type_Double) == 1))
      {
        paramacju = (AnimationTextView)localadja.jdField_a_of_type_AndroidWidgetTextView;
        float f2 = paramacju.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramacju.setTextColor(-1);
        paramacju.setShadowLayer(f1, 0.0F, 0.0F, paramalmt.d);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aciy.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)aciy.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624443);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131624444);
    } while (!paramView.isSendFromLocal());
    babr.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adiw(this, paramView), new adix(this)).show();
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
      acju localacju = (acju)paramView.getTag();
      if (localacju != null) {
        a(localacju, paramView, paramChatMessage, localacju.jdField_a_of_type_Almt);
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacju, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    int i = 1;
    int j = 0;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!ahox.a().c()) {
        break label108;
      }
      str = ahox.a().a();
      if (str == null) {
        break label103;
      }
      if (str.length() != ahox.a().a()) {
        break label98;
      }
      if ((i == 0) && (str != null)) {
        break label116;
      }
      bfhl.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
    for (;;)
    {
      bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
      return;
      label98:
      i = 0;
      break;
      label103:
      i = j;
      break;
      label108:
      i = 1;
      str = null;
      break;
      label116:
      bfhl.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
  }
  
  public bakj[] a(View paramView)
  {
    paramView = (MessageForLongMsg)aciy.a(paramView);
    bakh localbakh = new bakh();
    if (ApolloUtil.a(paramView)) {
      return localbakh.a();
    }
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localbakh.a(2131299262, this.jdField_a_of_type_AndroidContentContext.getString(2131652824), 2130838590);
      localbakh.a(2131309426, this.jdField_a_of_type_AndroidContentContext.getString(2131652831), 2130838604);
    }
    for (;;)
    {
      localbakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
      a(paramView, localbakh);
      if ((paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
        localbakh.a(2131296274, this.jdField_a_of_type_AndroidContentContext.getString(2131651461), 2130838577);
      }
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbakh, paramView);
      if (aciy.a(5) == 1) {
        localbakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626722), 2130838598);
      }
      b(paramView, localbakh);
      super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
      super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
      return localbakh.a();
      localbakh.a(2131299262, ajjy.a(2131640593), 2130838590);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adiu
 * JD-Core Version:    0.7.0.1
 */