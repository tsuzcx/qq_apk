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
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class afug
  extends BaseBubbleBuilder
  implements aemp
{
  public static final String a;
  public static Map<MessageForQQWalletMsg, Long> a;
  private static int o;
  private static int p;
  private static int q;
  aghr jdField_a_of_type_Aghr;
  private alqr jdField_a_of_type_Alqr;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afuh(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
  protected float b;
  protected String b;
  protected final int c = 2131374094;
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
    jdField_a_of_type_JavaLangString = afug.class.getSimpleName();
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public afug(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Aghr = new aghr(paramContext);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131717708);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseAdapter.getChatFragment().a();
    }
    this.jdField_a_of_type_Alqr = ((alqr)paramQQAppInterface.getManager(131));
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.e;
    localLayoutParams.bottomMargin = this.g;
    localLayoutParams.leftMargin = (this.d + this.h);
    localLayoutParams.rightMargin = (this.d + this.h);
    localLayoutParams.addRule(3, 2131364171);
    localLayoutParams.addRule(14);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setBackgroundResource(2130844305);
    paramContext.setPadding(this.f, this.h, this.f, 0);
    paramContext.setClickable(false);
    paramContext.setVisibility(8);
    paramContext.setGravity(16);
    paramContext.setIncludeFontPadding(false);
    paramContext.setLineSpacing(this.h, 1.0F);
    paramContext.setTextSize(12.0F);
    paramContext.setId(2131374094);
    return paramContext;
  }
  
  private void a(agia paramagia, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, aeov paramaeov)
  {
    aghi localaghi = new aghi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramagia, paramQQWalletTransferMsgElem, 0, this);
    paramMessageForQQWalletMsg.specifyIcon = null;
    try
    {
      localaghi.a();
      localaghi.e();
      localaghi.f();
      localaghi.b();
      localaghi.g();
      localaghi.b();
      localaghi.i();
      paramagia.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramagia.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramaeov);
      paramagia.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramaeov);
      paramagia.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramMessageForQQWalletMsg);
      this.jdField_a_of_type_Aghr.a(paramagia.jdField_a_of_type_AndroidWidgetRelativeLayout, paramQQWalletTransferMsgElem.title + this.jdField_b_of_type_JavaLangString);
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
  
  private void a(agia paramagia, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, MessageForQQWalletMsg paramMessageForQQWalletMsg, aeov paramaeov, boolean paramBoolean)
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
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleRedPacketLayout holder=" + paramagia + ",elem=" + paramQQWalletTransferMsgElem + ",qqWalletMsg=" + paramMessageForQQWalletMsg + (String)localObject + ",fromItemRefresh=" + paramBoolean);
        }
      }
      else
      {
        int i2 = agig.a(paramMessageForQQWalletMsg.messageType);
        i1 = i2;
        if (i2 == 4)
        {
          i1 = i2;
          if (paramQQWalletTransferMsgElem.skinId > 0) {
            i1 = 0;
          }
        }
        localObject = agig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramagia, paramQQWalletTransferMsgElem, i1, this);
        if ((localObject instanceof agid)) {
          ((agid)localObject).a(this.jdField_a_of_type_Bcws);
        }
      }
      try
      {
        ((aghn)localObject).a();
        ((aghn)localObject).e();
        ((aghn)localObject).f();
        ((aghn)localObject).b();
        ((aghn)localObject).g();
        ((aghn)localObject).b();
        ((aghn)localObject).h();
        ((aghn)localObject).c();
        ((aghn)localObject).i();
        if (!paramBoolean)
        {
          this.m = paramQQWalletTransferMsgElem.skinId;
          this.n = paramMessageForQQWalletMsg.messageType;
          paramagia.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramagia.c.setOnLongClickListener(paramaeov);
          paramagia.c.setOnTouchListener(paramaeov);
          paramagia.c.setTag(paramMessageForQQWalletMsg);
          this.jdField_a_of_type_Aghr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramagia.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1, paramQQWalletTransferMsgElem.skinId, this.jdField_b_of_type_JavaLangString);
          if (i1 == 1)
          {
            paramagia.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(alpo.a(2131711551) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + alpo.a(2131711556));
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
          paramagia.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(alpo.a(2131711558) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + alpo.a(2131711546));
          return;
        }
        if (i1 == 8)
        {
          paramagia.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("K歌红包:" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + alpo.a(2131711565));
          return;
        }
        if (i1 == 9)
        {
          paramagia.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(alpo.a(2131711548) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + alpo.a(2131711557));
          return;
        }
        if (i1 == 10)
        {
          paramagia.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(alpo.a(2131711564) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + alpo.a(2131711567));
          return;
        }
        if (i1 == 11)
        {
          paramagia.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(alpo.a(2131711554) + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + alpo.a(2131711553));
          return;
        }
        paramagia.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new agia();
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    paramView = null;
    agia localagia = (agia)paramaelt;
    if ((paramChatMessage instanceof MessageForQQWalletMsg)) {}
    for (paramaelt = (MessageForQQWalletMsg)paramChatMessage;; paramaelt = null)
    {
      if ((paramaelt == null) || ((paramaelt.mQQWalletTransferMsg == null) && (paramaelt.mQQWalletRedPacketMsg == null))) {
        return null;
      }
      if (QWalletHelper.graphbSpeedEnable) {
        a(paramaelt.istroop);
      }
      if ((localagia.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || ((localagia.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (localagia.jdField_a_of_type_Long != paramChatMessage.uniseq)))
      {
        localagia.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_Aghr.a(localagia, this.jdField_a_of_type_AndroidContentContext);
        paramBaseChatItemLayout.addView(a(this.jdField_a_of_type_AndroidContentContext));
      }
      localagia.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (paramaelt.mQQWalletRedPacketMsg != null)
      {
        paramChatMessage = paramaelt.mQQWalletRedPacketMsg.elem;
        if (paramChatMessage == null) {
          return localagia.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        a(localagia, paramChatMessage, paramaelt, paramaeov, false);
        paramaelt = (TextView)paramBaseChatItemLayout.findViewById(2131374094);
        if (paramaelt != null)
        {
          if ((paramChatMessage == null) || (TextUtils.isEmpty(paramChatMessage.blackStripe))) {
            break label247;
          }
          paramaelt.setText(paramChatMessage.blackStripe);
          paramaelt.setVisibility(0);
        }
      }
      for (;;)
      {
        return localagia.jdField_a_of_type_AndroidWidgetRelativeLayout;
        paramChatMessage = paramView;
        if (paramaelt.mQQWalletTransferMsg == null) {
          break;
        }
        paramChatMessage = paramaelt.mQQWalletTransferMsg.elem;
        if (paramChatMessage == null) {
          return localagia.jdField_a_of_type_AndroidWidgetRelativeLayout;
        }
        a(localagia, paramChatMessage, paramaelt, paramaeov);
        break;
        label247:
        paramaelt.setVisibility(8);
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
          if (bdec.a(paramChatMessage.issend)) {
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
    ajas.a().c();
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
    case 2131365069: 
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
      paramView.setPadding(o, q, p, paramView.getResources().getDimensionPixelSize(2131296295));
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
      if ((paramView instanceof agia))
      {
        paramChatMessage = (agia)paramView;
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaelt, paramInt1, paramInt2);
    paramChatMessage = (agia)paramaelt;
    paramContext = paramBaseChatItemLayout.findViewById(2131374001);
    if (paramChatMessage.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView != null)
    {
      paramInt1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingLeft();
      paramInt2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingRight();
      int i1 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingTop();
      int i2 = paramChatMessage.jdField_a_of_type_AndroidViewView.getPaddingBottom();
      paramChatMessage.jdField_a_of_type_AndroidViewView.setPadding(this.g + paramInt1, i1, paramInt2 + this.g, i2);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(this.k, this.l);
      paramBaseChatItemLayout.addRule(5, 2131364171);
      paramBaseChatItemLayout.addRule(6, 2131364171);
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
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = aekt.a(paramView);
    a(paramView, localbdkz);
    acex.a(localbdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbdkz);
    super.c(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
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
 * Qualified Name:     afug
 * JD-Core Version:    0.7.0.1
 */