import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class aheo
  extends BaseBubbleBuilder
  implements afrr
{
  public static final String a;
  public static Map<MessageForQQWalletMsg, Long> a;
  private static int o;
  private static int p;
  private static int q;
  ahxh jdField_a_of_type_Ahxh;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahep(this);
  private anxc jdField_a_of_type_Anxc;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
  protected float b;
  protected String b;
  protected final int c = 2131375017;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  int m;
  int n;
  
  static
  {
    jdField_a_of_type_JavaLangString = aheo.class.getSimpleName();
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public aheo(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Ahxh = new ahxh(paramContext);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131716638);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.d = ((int)(42.0F * this.jdField_b_of_type_Float + 0.5F));
    this.e = ((int)(10.0F * this.jdField_b_of_type_Float + 0.5F));
    this.f = ((int)(9.0F * this.jdField_b_of_type_Float + 0.5F));
    this.g = ((int)(6.5F * this.jdField_b_of_type_Float + 0.5F));
    this.h = ((int)(4.0F * this.jdField_b_of_type_Float + 0.5F));
    this.i = ((int)(this.jdField_b_of_type_Float * 1.0F + 0.5F));
    this.j = ((int)(7.0F * this.jdField_b_of_type_Float + 0.5F));
    this.k = ((int)(173.0F * this.jdField_b_of_type_Float + 0.5F));
    this.l = ((int)(255.0F * this.jdField_b_of_type_Float + 0.5F));
    o = this.i * 2;
    p = this.i * 2;
    q = this.j;
    paramBaseAdapter = (FragmentActivity)paramContext;
    if (paramBaseAdapter.getChatFragment() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseAdapter.getChatFragment().a();
    }
    this.jdField_a_of_type_Anxc = ((anxc)paramQQAppInterface.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER));
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.e;
    localLayoutParams.bottomMargin = this.g;
    localLayoutParams.leftMargin = (this.d + this.h);
    localLayoutParams.rightMargin = (this.d + this.h);
    localLayoutParams.addRule(3, 2131364522);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130844727);
    paramContext.setPadding(this.f, this.h, this.f, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.h, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131375017);
    return paramContext;
  }
  
  private void a(ahxr paramahxr, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, aftk paramaftk)
  {
    ahwx localahwx = new ahwx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, 0, this);
    paramMessageForQQWalletMsg.specifyIcon = null;
    try
    {
      localahwx.a();
      localahwx.e();
      localahwx.f();
      localahwx.b();
      localahwx.g();
      localahwx.b();
      localahwx.i();
      paramahxr.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramahxr.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramaftk);
      paramahxr.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramaftk);
      paramahxr.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramMessageForQQWalletMsg);
      this.jdField_a_of_type_Ahxh.a(paramahxr.jdField_a_of_type_AndroidWidgetRelativeLayout, paramQQWalletBaseMsgElem.title + this.jdField_b_of_type_JavaLangString);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleOldRedPacketLayout exception", localThrowable);
        }
      }
    }
  }
  
  private void a(ahxr paramahxr, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, aftk paramaftk, boolean paramBoolean)
  {
    if ((paramQQWalletBaseMsgElem == null) || (paramMessageForQQWalletMsg == null)) {}
    for (;;)
    {
      return;
      Object localObject;
      int i1;
      if (QLog.isColorLevel())
      {
        if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
        {
          localObject = ",QQWalletAioBodyReserve=" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body;
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleRedPacketLayout holder=" + paramahxr + ",elem=" + paramQQWalletBaseMsgElem + ",qqWalletMsg=" + paramMessageForQQWalletMsg + (String)localObject + ",fromItemRefresh=" + paramBoolean);
        }
      }
      else
      {
        int i2 = ahxx.a(paramMessageForQQWalletMsg.messageType);
        i1 = i2;
        if (i2 == 4)
        {
          i1 = i2;
          if (paramQQWalletBaseMsgElem.skinId > 0) {
            i1 = 0;
          }
        }
        localObject = ahxx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, i1, this);
        if ((localObject instanceof ahxu)) {
          ((ahxu)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
        }
      }
      try
      {
        ((ahxc)localObject).a();
        ((ahxc)localObject).e();
        ((ahxc)localObject).f();
        ((ahxc)localObject).b();
        ((ahxc)localObject).g();
        ((ahxc)localObject).b();
        ((ahxc)localObject).h();
        ((ahxc)localObject).c();
        ((ahxc)localObject).i();
        if (!paramBoolean)
        {
          this.m = paramQQWalletBaseMsgElem.skinId;
          this.n = paramMessageForQQWalletMsg.messageType;
          paramahxr.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramahxr.c.setOnLongClickListener(paramaftk);
          paramahxr.c.setOnTouchListener(paramaftk);
          paramahxr.c.setTag(paramMessageForQQWalletMsg);
          this.jdField_a_of_type_Ahxh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramahxr.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1, paramQQWalletBaseMsgElem.skinId, this.jdField_b_of_type_JavaLangString);
          if (i1 == 1)
          {
            paramahxr.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anvx.a(2131710627) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + anvx.a(2131710632));
            return;
            localObject = "";
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "handleRedPacketLayout exception", localThrowable);
          }
        }
        if (i1 == 2)
        {
          paramahxr.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anvx.a(2131710634) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + anvx.a(2131710622));
          return;
        }
        if (i1 == 8)
        {
          paramahxr.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("K歌红包:" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + anvx.a(2131710641));
          return;
        }
        if (i1 == 9)
        {
          paramahxr.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anvx.a(2131710624) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + anvx.a(2131710633));
          return;
        }
        if (i1 == 10)
        {
          paramahxr.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anvx.a(2131710640) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + anvx.a(2131710643));
          return;
        }
        if (i1 == 11)
        {
          paramahxr.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(anvx.a(2131710630) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + anvx.a(2131710629));
          return;
        }
        paramahxr.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new ahxr();
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramView = null;
    ahxr localahxr = (ahxr)paramafqr;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (paramafqr = (MessageForQQWalletMsg)paramChatMessage;; paramafqr = null)
    {
      if ((paramafqr == null) || ((paramafqr.mQQWalletTransferMsg == null) && (paramafqr.mQQWalletRedPacketMsg == null))) {
        return null;
      }
      if (QWalletHelper.graphbSpeedEnable) {
        a(paramafqr.istroop);
      }
      if ((localahxr.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || ((localahxr.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (localahxr.jdField_a_of_type_Long != paramChatMessage.uniseq)))
      {
        localahxr.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_Ahxh.a(localahxr, this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
      }
      localahxr.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (paramafqr.mQQWalletRedPacketMsg != null)
      {
        paramChatMessage = paramafqr.mQQWalletRedPacketMsg.elem;
        if (paramChatMessage == null) {
          return localahxr.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        a(localahxr, paramChatMessage, paramafqr, paramaftk, false);
        paramafqr = (TextView)paramBaseChatItemLayout.findViewById(2131375017);
        if (paramafqr != null)
        {
          if ((paramChatMessage == null) || (TextUtils.isEmpty(paramChatMessage.blackStripe))) {
            break label247;
          }
          paramafqr.setText(paramChatMessage.blackStripe);
          paramafqr.setVisibility(0);
        }
      }
      for (;;)
      {
        return localahxr.jdField_a_of_type_AndroidWidgetRelativeLayout;
        paramChatMessage = paramView;
        if (paramafqr.mQQWalletTransferMsg == null) {
          break;
        }
        paramChatMessage = paramafqr.mQQWalletTransferMsg.elem;
        if (paramChatMessage == null) {
          return localahxr.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        a(localahxr, paramChatMessage, paramafqr, paramaftk);
        break;
        label247:
        paramafqr.setVisibility(8);
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (Object localObject = (MessageForQQWalletMsg)paramChatMessage;; localObject = null)
    {
      if ((localObject == null) || ((((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg == null) && (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg == null))) {
        return paramChatMessage.msg;
      }
      if (((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg != null) {
        localObject = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg.elem;
      }
      for (;;)
      {
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (bhfj.a(paramChatMessage.issend)) {
            localStringBuilder.append("发出");
          }
          for (;;)
          {
            localStringBuilder.append(((QQWalletBaseMsgElem)localObject).content).append(((QQWalletBaseMsgElem)localObject).title).append("按钮");
            return localStringBuilder.toString();
            if (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg == null) {
              break label141;
            }
            localObject = ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem;
            break;
            localStringBuilder.append("发来");
          }
        }
        return paramChatMessage.msg;
        label141:
        localObject = null;
      }
    }
  }
  
  public void a()
  {
    super.a();
    CustomizeStrategyFactory.a().a();
    alcl.a().c();
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  protected void a(int paramInt)
  {
    ThreadManager.post(new QQWalletMsgItemBuilder.1(this, paramInt), 8, null, true);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365475: 
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(p, q, o, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(o, q, p, paramView.getResources().getDimensionPixelSize(2131296386));
      return;
    }
    paramView.setPadding(o, q, p, 0);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateView type=" + paramInt + ",message=" + paramChatMessage);
    }
    if (paramInt == 888)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof ahxr))
      {
        paramChatMessage = (ahxr)paramView;
        if (paramChatMessage.c == null) {
          break label117;
        }
      }
      label117:
      for (paramView = paramChatMessage.c.getTag();; paramView = null)
      {
        if ((paramView instanceof MessageForQQWalletMsg))
        {
          paramView = (MessageForQQWalletMsg)paramView;
          if (paramView.mQQWalletRedPacketMsg != null) {
            a(paramChatMessage, paramView.mQQWalletRedPacketMsg.elem, paramView, null, true);
          }
        }
        return;
      }
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afqr paramafqr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafqr, paramInt1, paramInt2);
    paramChatMessage = (ahxr)paramafqr;
    paramContext = paramBaseChatItemLayout.findViewById(2131374920);
    if (paramChatMessage.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView != null)
    {
      paramInt1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingLeft();
      paramInt2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingRight();
      int i1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingTop();
      int i2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingBottom();
      paramChatMessage.jdField_a_of_type_AndroidViewView.setPadding(this.g + paramInt1, i1, paramInt2 + this.g, i2);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.k, this.l);
      paramBaseChatItemLayout.addRule(5, 2131364522);
      paramBaseChatItemLayout.addRule(6, 2131364522);
      paramBaseChatItemLayout.leftMargin = paramInt1;
      paramBaseChatItemLayout.topMargin = (-this.i);
      if (paramContext != null)
      {
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.removeView(paramContext);
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView, paramBaseChatItemLayout);
      }
    }
    else
    {
      return;
    }
    paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView, paramBaseChatItemLayout);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        Message localMessage = new Message();
        localMessage.what = 78;
        localMessage.arg1 = 888;
        Bundle localBundle = new Bundle();
        localBundle.putLong("messageUniseq", paramMessageRecord.uniseq);
        localMessage.setData(localBundle);
        localMqqHandler.sendMessage(localMessage);
      }
    }
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = AIOUtils.getMessage(paramView);
    a(paramView, localbhjq);
    admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    b(paramView, localbhjq);
    super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramRedPacketInfo.skinType == 1) && ((paramRedPacketInfo.background != null) || (paramRedPacketInfo.animInfo != null))) {
              a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          } while ((paramRedPacketInfo.skinType != 3) || (paramRedPacketInfo.specailBackgroundAnimInfo == null));
          a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          return;
        } while (paramRedPacketInfo.animInfo == null);
        a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
      } while (paramRedPacketInfo.background == null);
      a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    } while ((!paramRedPacketInfo.a()) && (paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap == null));
    a(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aheo
 * JD-Core Version:    0.7.0.1
 */