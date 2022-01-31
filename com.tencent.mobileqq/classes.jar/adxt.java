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

public class adxt
  extends BaseBubbleBuilder
  implements acvf
{
  public static final String a;
  private static int m;
  private static int n;
  private static int o;
  aela jdField_a_of_type_Aela;
  private ajzd jdField_a_of_type_Ajzd;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adxu(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
  protected float b;
  protected String b;
  protected final int c = 2131373641;
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
    jdField_a_of_type_JavaLangString = adxt.class.getSimpleName();
  }
  
  public adxt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Aela = new aela(paramContext);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131717336);
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
    this.jdField_a_of_type_Ajzd = ((ajzd)paramQQAppInterface.getManager(131));
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.e;
    localLayoutParams.bottomMargin = this.g;
    localLayoutParams.leftMargin = (this.d + this.h);
    localLayoutParams.rightMargin = (this.d + this.h);
    localLayoutParams.addRule(3, 2131364109);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130843962);
    paramContext.setPadding(this.f, this.h, this.f, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.h, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131373641);
    return paramContext;
  }
  
  private void a(aelj paramaelj, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, acxj paramacxj)
  {
    aekr localaekr = new aekr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, 0, this);
    paramMessageForQQWalletMsg.specifyIcon = null;
    try
    {
      localaekr.a();
      localaekr.e();
      localaekr.f();
      localaekr.b();
      localaekr.g();
      localaekr.b();
      localaekr.i();
      paramaelj.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramacxj);
      paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramacxj);
      paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramMessageForQQWalletMsg);
      this.jdField_a_of_type_Aela.a(paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout, paramQQWalletTransferMsgElem.title + this.jdField_b_of_type_JavaLangString);
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
  
  private void a(aelj paramaelj, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, acxj paramacxj, boolean paramBoolean)
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
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleRedPacketLayout holder=" + paramaelj + ",elem=" + paramQQWalletTransferMsgElem + ",qqWalletMsg=" + paramMessageForQQWalletMsg + (String)localObject + ",fromItemRefresh=" + paramBoolean);
        }
      }
      else
      {
        int i2 = aelp.a(paramMessageForQQWalletMsg.messageType);
        i1 = i2;
        if (i2 == 4)
        {
          i1 = i2;
          if (paramQQWalletTransferMsgElem.skinId > 0) {
            i1 = 0;
          }
        }
        localObject = aelp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, i1, this);
        if ((localObject instanceof aelm)) {
          ((aelm)localObject).a(this.jdField_a_of_type_Baxy);
        }
      }
      try
      {
        ((aekw)localObject).a();
        ((aekw)localObject).e();
        ((aekw)localObject).f();
        ((aekw)localObject).b();
        ((aekw)localObject).g();
        ((aekw)localObject).b();
        ((aekw)localObject).h();
        ((aekw)localObject).c();
        ((aekw)localObject).i();
        if (!paramBoolean)
        {
          paramaelj.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramaelj.c.setOnLongClickListener(paramacxj);
          paramaelj.c.setOnTouchListener(paramacxj);
          paramaelj.c.setTag(paramMessageForQQWalletMsg);
          this.jdField_a_of_type_Aela.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramaelj.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1, paramQQWalletTransferMsgElem.skinId, this.jdField_b_of_type_JavaLangString);
          if (i1 == 1)
          {
            paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajya.a(2131711179) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajya.a(2131711184));
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
          paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajya.a(2131711186) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajya.a(2131711174));
          return;
        }
        if (i1 == 8)
        {
          paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("K歌红包:" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajya.a(2131711193));
          return;
        }
        if (i1 == 9)
        {
          paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajya.a(2131711176) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajya.a(2131711185));
          return;
        }
        if (i1 == 10)
        {
          paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajya.a(2131711192) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajya.a(2131711195));
          return;
        }
        if (i1 == 11)
        {
          paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(ajya.a(2131711182) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + ajya.a(2131711181));
          return;
        }
        paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return new aelj();
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    paramView = null;
    aelj localaelj = (aelj)paramacuj;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (paramacuj = (MessageForQQWalletMsg)paramChatMessage;; paramacuj = null)
    {
      if ((paramacuj == null) || ((paramacuj.mQQWalletTransferMsg == null) && (paramacuj.mQQWalletRedPacketMsg == null))) {
        return null;
      }
      if (QWalletHelper.graphbSpeedEnable) {
        a(paramacuj.istroop);
      }
      if ((localaelj.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || ((localaelj.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (localaelj.jdField_a_of_type_Long != paramChatMessage.uniseq)))
      {
        localaelj.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_Aela.a(localaelj, this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
      }
      localaelj.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (paramacuj.mQQWalletRedPacketMsg != null)
      {
        paramChatMessage = paramacuj.mQQWalletRedPacketMsg.elem;
        if (paramChatMessage == null) {
          return localaelj.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        a(localaelj, paramChatMessage, paramacuj, paramacxj, false);
        paramacuj = (TextView)paramBaseChatItemLayout.findViewById(2131373641);
        if (paramacuj != null)
        {
          if ((paramChatMessage == null) || (TextUtils.isEmpty(paramChatMessage.blackStripe))) {
            break label247;
          }
          paramacuj.setText(paramChatMessage.blackStripe);
          paramacuj.setVisibility(0);
        }
      }
      for (;;)
      {
        return localaelj.jdField_a_of_type_AndroidWidgetRelativeLayout;
        paramChatMessage = paramView;
        if (paramacuj.mQQWalletTransferMsg == null) {
          break;
        }
        paramChatMessage = paramacuj.mQQWalletTransferMsg.elem;
        if (paramChatMessage == null) {
          return localaelj.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        a(localaelj, paramChatMessage, paramacuj, paramacxj);
        break;
        label247:
        paramacuj.setVisibility(8);
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
          if (bbfh.a(paramChatMessage.issend)) {
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
    ahjj.a().c();
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
    case 2131364984: 
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
      paramView.setPadding(m, o, n, paramView.getResources().getDimensionPixelSize(2131296289));
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
      if ((paramView instanceof aelj))
      {
        paramChatMessage = (aelj)paramView;
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acuj paramacuj, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacuj, paramInt1, paramInt2);
    paramChatMessage = (aelj)paramacuj;
    paramContext = paramBaseChatItemLayout.findViewById(2131373548);
    if (paramChatMessage.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView != null)
    {
      paramInt1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingLeft();
      paramInt2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingRight();
      int i1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingTop();
      int i2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingBottom();
      paramChatMessage.jdField_a_of_type_AndroidViewView.setPadding(this.g + paramInt1, i1, paramInt2 + this.g, i2);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.k, this.l);
      paramBaseChatItemLayout.addRule(5, 2131364109);
      paramBaseChatItemLayout.addRule(6, 2131364109);
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
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = actj.a(paramView);
    a(paramView, localbbmf);
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbbmf);
    super.c(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
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
 * Qualified Name:     adxt
 * JD-Core Version:    0.7.0.1
 */