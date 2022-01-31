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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import mqq.os.MqqHandler;

public class admw
  extends BaseBubbleBuilder
  implements ackq
{
  public static final String a;
  private static int m;
  private static int n;
  private static int o;
  aead jdField_a_of_type_Aead;
  private ajkz jdField_a_of_type_Ajkz;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new admx(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
  protected float b;
  protected String b;
  protected final int c = 2131307923;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  
  static
  {
    jdField_a_of_type_JavaLangString = admw.class.getSimpleName();
  }
  
  public admw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Aead = new aead(paramContext);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131651533);
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
    m = this.i * 2;
    n = this.i * 2;
    o = this.j;
    paramBaseAdapter = (FragmentActivity)paramContext;
    if (paramBaseAdapter.getChatFragment() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseAdapter.getChatFragment().a();
    }
    this.jdField_a_of_type_Ajkz = ((ajkz)paramQQAppInterface.getManager(131));
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.e;
    localLayoutParams.bottomMargin = this.g;
    localLayoutParams.leftMargin = (this.d + this.h);
    localLayoutParams.rightMargin = (this.d + this.h);
    localLayoutParams.addRule(3, 2131298552);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130843881);
    paramContext.setPadding(this.f, this.h, this.f, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.h, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131307923);
    return paramContext;
  }
  
  private void a(aeam paramaeam, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, acmv paramacmv)
  {
    adzu localadzu = new adzu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, 0, this);
    paramMessageForQQWalletMsg.specifyIcon = null;
    try
    {
      localadzu.a();
      localadzu.e();
      localadzu.f();
      localadzu.b();
      localadzu.g();
      localadzu.b();
      localadzu.i();
      paramaeam.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramaeam.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramacmv);
      paramaeam.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramacmv);
      paramaeam.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramMessageForQQWalletMsg);
      this.jdField_a_of_type_Aead.a(paramaeam.jdField_a_of_type_AndroidWidgetRelativeLayout, paramQQWalletTransferMsgElem.title + this.jdField_b_of_type_JavaLangString);
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
  
  private void a(aeam paramaeam, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, acmv paramacmv, boolean paramBoolean)
  {
    if ((paramQQWalletTransferMsgElem == null) || (paramMessageForQQWalletMsg == null)) {}
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
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleRedPacketLayout holder=" + paramaeam + ",elem=" + paramQQWalletTransferMsgElem + ",qqWalletMsg=" + paramMessageForQQWalletMsg + (String)localObject + ",fromItemRefresh=" + paramBoolean);
        }
      }
      else
      {
        int i2 = aeas.a(paramMessageForQQWalletMsg.messageType);
        i1 = i2;
        if (i2 == 4)
        {
          i1 = i2;
          if (paramQQWalletTransferMsgElem.skinId > 0) {
            i1 = 0;
          }
        }
        localObject = aeas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, i1, this);
        if ((localObject instanceof aeap)) {
          ((aeap)localObject).a(this.jdField_a_of_type_Azwg);
        }
      }
      try
      {
        ((adzz)localObject).a();
        ((adzz)localObject).e();
        ((adzz)localObject).f();
        ((adzz)localObject).b();
        ((adzz)localObject).g();
        ((adzz)localObject).b();
        ((adzz)localObject).h();
        ((adzz)localObject).c();
        ((adzz)localObject).i();
        if (!paramBoolean)
        {
          paramaeam.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramaeam.c.setOnLongClickListener(paramacmv);
          paramaeam.c.setOnTouchListener(paramacmv);
          paramaeam.c.setTag(paramMessageForQQWalletMsg);
          this.jdField_a_of_type_Aead.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramaeam.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1, paramQQWalletTransferMsgElem.skinId, this.jdField_b_of_type_JavaLangString);
          if (i1 == 1)
          {
            paramaeam.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajjy.a(2131645380) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645385));
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
          paramaeam.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajjy.a(2131645387) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645375));
          return;
        }
        if (i1 == 8)
        {
          paramaeam.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("K歌红包:" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645394));
          return;
        }
        if (i1 == 9)
        {
          paramaeam.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajjy.a(2131645377) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645386));
          return;
        }
        if (i1 == 10)
        {
          paramaeam.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajjy.a(2131645393) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645396));
          return;
        }
        if (i1 == 11)
        {
          paramaeam.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajjy.a(2131645383) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajjy.a(2131645382));
          return;
        }
        paramaeam.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acju a()
  {
    return new aeam();
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    paramView = null;
    aeam localaeam = (aeam)paramacju;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (paramacju = (MessageForQQWalletMsg)paramChatMessage;; paramacju = null)
    {
      if ((paramacju == null) || ((paramacju.mQQWalletTransferMsg == null) && (paramacju.mQQWalletRedPacketMsg == null))) {
        return null;
      }
      if (QWalletHelper.graphbSpeedEnable) {
        a(paramacju.istroop);
      }
      if ((localaeam.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || ((localaeam.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (localaeam.jdField_a_of_type_Long != paramChatMessage.uniseq)))
      {
        localaeam.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_Aead.a(localaeam, this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
      }
      localaeam.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (paramacju.mQQWalletRedPacketMsg != null)
      {
        paramChatMessage = paramacju.mQQWalletRedPacketMsg.elem;
        if (paramChatMessage == null) {
          return localaeam.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        a(localaeam, paramChatMessage, paramacju, paramacmv, false);
        paramacju = (TextView)paramBaseChatItemLayout.findViewById(2131307923);
        if (paramacju != null)
        {
          if ((paramChatMessage == null) || (TextUtils.isEmpty(paramChatMessage.blackStripe))) {
            break label247;
          }
          paramacju.setText(paramChatMessage.blackStripe);
          paramacju.setVisibility(0);
        }
      }
      for (;;)
      {
        return localaeam.jdField_a_of_type_AndroidWidgetRelativeLayout;
        paramChatMessage = paramView;
        if (paramacju.mQQWalletTransferMsg == null) {
          break;
        }
        paramChatMessage = paramacju.mQQWalletTransferMsg.elem;
        if (paramChatMessage == null) {
          return localaeam.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        a(localaeam, paramChatMessage, paramacju, paramacmv);
        break;
        label247:
        paramacju.setVisibility(8);
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
          if (bado.a(paramChatMessage.issend)) {
            localStringBuilder.append("发出");
          }
          for (;;)
          {
            localStringBuilder.append(((QQWalletTransferMsgElem)localObject).content).append(((QQWalletTransferMsgElem)localObject).title).append("按钮");
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
    agww.a().c();
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
    case 2131299417: 
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(n, o, m, 0);
      return;
    }
    if (paramChatMessage.istroop == 1008)
    {
      paramView.setPadding(m, o, n, paramView.getResources().getDimensionPixelSize(2131165217));
      return;
    }
    paramView.setPadding(m, o, n, 0);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateView type=" + paramInt + ",message=" + paramChatMessage);
    }
    if (paramInt == 888)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof aeam))
      {
        paramChatMessage = (aeam)paramView;
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacju, paramInt1, paramInt2);
    paramChatMessage = (aeam)paramacju;
    paramContext = paramBaseChatItemLayout.findViewById(2131307830);
    if (paramChatMessage.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView != null)
    {
      paramInt1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingLeft();
      paramInt2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingRight();
      int i1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingTop();
      int i2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingBottom();
      paramChatMessage.jdField_a_of_type_AndroidViewView.setPadding(this.g + paramInt1, i1, paramInt2 + this.g, i2);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.k, this.l);
      paramBaseChatItemLayout.addRule(5, 2131298552);
      paramBaseChatItemLayout.addRule(6, 2131298552);
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
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    paramView = aciy.a(paramView);
    a(paramView, localbakh);
    aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbakh);
    super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
    super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
    return localbakh.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admw
 * JD-Core Version:    0.7.0.1
 */