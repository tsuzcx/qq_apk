import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloMessageProgressView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

public class afdb
  extends afec
{
  private akjc jdField_a_of_type_Akjc;
  protected View.OnClickListener a;
  private bdfq jdField_a_of_type_Bdfq;
  private long c;
  private boolean f = true;
  
  public afdb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afdc(this);
    this.jdField_a_of_type_Akjc = ((akje)paramQQAppInterface.getManager(211)).a();
    akro.a(paramQQAppInterface);
  }
  
  protected static void a(afde paramafde, int paramInt)
  {
    if (paramInt < 100)
    {
      paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setDrawStatus(1);
      paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setAnimProgress(paramInt, paramafde.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafde.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setAnimProgress(paramInt, paramafde.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafde.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
  }
  
  private void a(afde paramafde, MessageForApollo paramMessageForApollo, View paramView)
  {
    if (paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView == null)
    {
      paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView = new ApolloMessageProgressView(this.jdField_a_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(aekt.a(242.66667F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(173.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(13);
      paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setRadius(15.0F, true);
      paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setShowCorner(false);
      paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setSharpCornerCor(BubbleImageView.a);
      paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setCornerDirection(false);
      ((RelativeLayout)paramView).addView(paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView, localLayoutParams);
    }
    paramMessageForApollo = ((akje)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211)).a(paramMessageForApollo.gameId);
    if ((paramMessageForApollo != null) && (paramMessageForApollo.uniseq == paramafde.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(8);
      return;
    }
    paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(4);
  }
  
  public static void a(afde paramafde, MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if ((paramafde == null) || (paramQQAppInterface == null) || (paramMessageForApollo == null)) {}
    for (;;)
    {
      return;
      if (paramMessageForApollo.uniseq == paramafde.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)
      {
        paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(0);
        a(paramafde, paramInt2);
        if (paramInt2 == 100) {
          paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(8);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ApolloGameItemBuilder", 2, new Object[] { "gameId = ", Integer.valueOf(paramInt1), ":", Integer.valueOf(paramInt2) });
        return;
        paramafde.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(8);
      }
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, View paramView)
  {
    if ((paramMessageForApollo == null) || (paramView == null)) {}
    while (TextUtils.isEmpty(ApolloUtil.b(paramMessageForApollo))) {
      return;
    }
    d(paramView);
  }
  
  private void d(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      int k = ((ViewGroup)paramView).getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView1 = ((ViewGroup)paramView).getChildAt(i);
        if ((localView1 instanceof ViewGroup))
        {
          int m = ((ViewGroup)localView1).getChildCount();
          int j = 0;
          while (j < m)
          {
            View localView2 = ((ViewGroup)localView1).getChildAt(j);
            if ((localView2 instanceof ArkAppView))
            {
              localView2.setOnTouchListener(null);
              localView2.setClickable(false);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public aelt a()
  {
    return new afde();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    if (!(paramChatMessage.getTag() instanceof afde))
    {
      QLog.w("ApolloGameItemBuilder", 1, "[getView], NOT GameHolder.");
      return paramChatMessage;
    }
    paramView = (afde)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramaeov = paramChatMessage.b();
    if ((paramaeov != null) && (paramaeov.getVisibility() == 0)) {
      paramViewGroup.addRule(3, 2131364189);
    }
    for (paramViewGroup.topMargin = BaseChatItemLayout.g;; paramViewGroup.topMargin = 0)
    {
      paramView.jdField_a_of_type_AndroidViewView.setLayoutParams(paramViewGroup);
      return paramChatMessage;
      paramViewGroup.addRule(6, 2131364180);
    }
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    if ((paramChatMessage == null) || (paramaelt == null) || (paramBaseChatItemLayout == null) || (this.jdField_a_of_type_Akjc == null)) {
      return paramView;
    }
    if (!(paramaelt instanceof afde))
    {
      QLog.w("ApolloGameItemBuilder", 1, "[getBubbleView], NOT GameHolder.");
      return paramView;
    }
    paramChatMessage = (MessageForApollo)paramChatMessage;
    paramaelt = (afde)paramaelt;
    MessageForArkApp localMessageForArkApp = this.jdField_a_of_type_Akjc.a(paramChatMessage, paramChatMessage.mApolloGameArkMsg);
    if (localMessageForArkApp.arkContainer == null) {
      localMessageForArkApp.arkContainer = new afds();
    }
    localMessageForArkApp.arkContainer.a(true);
    paramChatMessage.mApolloGameArkMsg = localMessageForArkApp;
    paramView = super.a(localMessageForArkApp, paramaelt, paramView, paramBaseChatItemLayout, paramaeov);
    a(paramaelt, paramChatMessage, paramView);
    paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a(paramChatMessage, paramView);
    return paramView;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return alpo.a(2131700747) + paramChatMessage.msg;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Bdfq != null)
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      this.jdField_a_of_type_Bdfq = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameItemBuilder", 2, "this:" + this + ", destroy(),apollo check game dialog dismiss");
    }
  }
  
  public void a(View paramView)
  {
    paramView = (afeg)aekt.a(paramView);
    try
    {
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
      {
        QLog.w("ApolloGameItemBuilder", 1, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
        bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != 0) || (super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)))
        {
          localbhpy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690133), 1);
          localbhpy.c(2131690648);
          localbhpy.a(new afdd(this, paramView, localbhpy));
          localbhpy.show();
        }
      }
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("ApolloGameItemBuilder", 1, paramView, new Object[0]);
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaelt, paramInt1, paramInt2);
    if (!(paramaelt instanceof afde)) {
      QLog.w("ApolloGameItemBuilder", 1, "[handleBubbleBg], NOT GameHolder.");
    }
    do
    {
      return;
      paramChatMessage = (afde)paramaelt;
    } while (paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView == null);
    paramChatMessage.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
    paramChatMessage.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
  }
  
  public void a(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    return BaseChatItemLayout.a;
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = aekt.a(paramView);
    if (ApolloUtil.a(paramView))
    {
      e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
      return localbdkz.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbdkz, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdb
 * JD-Core Version:    0.7.0.1
 */