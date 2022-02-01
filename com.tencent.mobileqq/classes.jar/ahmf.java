import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahmf
  extends BaseBubbleBuilder
{
  public ahmf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, afqr paramafqr, View paramView)
  {
    int i = 0;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isUpComingPrevious)) {}
    for (boolean bool = false;; bool = true)
    {
      lah locallah;
      if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000))
      {
        paramContext = lap.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        locallah = lal.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (locallah == null) {
          break label325;
        }
      }
      label325:
      for (paramContext = locallah.a(paramChatMessage.msg, paramChatMessage.uniseq, paramContext);; paramContext = null)
      {
        if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend())) {}
        for (paramafqr.jdField_a_of_type_Aqhi = aqii.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool);; paramafqr.jdField_a_of_type_Aqhi = aqii.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool))
        {
          if (paramafqr.jdField_a_of_type_Aqhi != null) {
            paramafqr.jdField_a_of_type_Aqhi.a(paramafqr.jdField_a_of_type_AndroidViewView, null);
          }
          if (paramafqr.jdField_a_of_type_Aqhi != null)
          {
            int j = paramChatMessage.vipBubbleDiyTextId;
            i = j;
            if (j <= 0) {
              i = aocy.b(paramChatMessage.vipBubbleID);
            }
            paramafqr.jdField_a_of_type_Aqhi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), true, paramView, gb.a(paramChatMessage), i);
          }
          if (paramafqr.jdField_a_of_type_AndroidViewView != null)
          {
            paramContext = paramafqr.jdField_a_of_type_AndroidViewView.getBackground();
            if (paramContext != null) {
              paramContext.setAlpha(jdField_a_of_type_Int);
            }
          }
          super.a(paramView, paramChatMessage);
          return;
        }
        if (!paramChatMessage.needVipBubble()) {}
        for (;;)
        {
          paramafqr.jdField_a_of_type_Aqhi = aqii.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), null, bool);
          break;
          i = ((aocy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramChatMessage);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new ahmi();
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    Object localObject2;
    Object localObject1;
    TextView localTextView;
    if (paramView == null)
    {
      localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramBaseChatItemLayout = (RelativeLayout)localObject2;
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setMaxWidth(BaseChatItemLayout.e);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167045));
      localTextView.setLinkTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167038));
      localTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
      localTextView.setId(2131374016);
      ((RelativeLayout)localObject1).setId(2131374017);
      ((RelativeLayout)localObject1).addView(localTextView);
      paramView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setSingleLine(true);
      paramView.setGravity(17);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(1, 13.0F);
      paramView.setBackgroundResource(2130842656);
      paramView.setId(2131374019);
      paramView.setText(anvx.a(2131715188));
      paramBaseChatItemLayout.addView((View)localObject1);
      paramBaseChatItemLayout.addView(paramView);
      localObject1 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131374017);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131374017);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
      localObject1 = paramView;
      ((TextView)localObject1).setPadding((int)(5.0F * this.jdField_a_of_type_Float), 0, (int)(5.0F * this.jdField_a_of_type_Float), 0);
      ((TextView)localObject1).getLayoutParams().height = ((int)(20.0F * this.jdField_a_of_type_Float));
      paramView = (MessageForWantGiftMsg)paramChatMessage;
      ((TextView)localObject1).setOnClickListener(new ahmg(this, paramChatMessage, paramView));
      int j = BaseChatItemLayout.o;
      int i = BaseChatItemLayout.p;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.p;
        i = BaseChatItemLayout.o;
      }
      localTextView.setPadding(j, BaseChatItemLayout.m, i, BaseChatItemLayout.n);
      localTextView.setText(paramView.msg);
      localTextView.setBackgroundResource(2130838408);
      a(paramChatMessage, this.jdField_a_of_type_AndroidContentContext, paramafqr, paramBaseChatItemLayout.findViewById(2131374017));
      if (paramView.wantGiftSenderUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
        break label466;
      }
      ((TextView)localObject1).setVisibility(8);
    }
    for (;;)
    {
      ((View)localObject2).setOnLongClickListener(paramaftk);
      ((View)localObject2).setOnTouchListener(new ahmh(this, paramaftk));
      return localObject2;
      paramBaseChatItemLayout = (RelativeLayout)paramView;
      localTextView = (TextView)paramBaseChatItemLayout.findViewById(2131374016);
      localObject1 = (TextView)paramBaseChatItemLayout.findViewById(2131374019);
      localObject2 = paramView;
      break;
      label466:
      ((TextView)localObject1).setVisibility(0);
      new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_send_him").a(0).a(new String[] { paramChatMessage.frienduin + "", "29" }).a();
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.msg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131376534: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, 0, 0, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(0, 0, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = AIOUtils.getMessage(paramView);
    a(paramView, localbhjq);
    admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    b(paramView, localbhjq);
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmf
 * JD-Core Version:    0.7.0.1
 */