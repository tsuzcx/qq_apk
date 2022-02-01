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
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahwt
  extends BaseBubbleBuilder
{
  public ahwt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, aggl paramaggl, View paramView)
  {
    int i = 0;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n)) {}
    for (boolean bool = false;; bool = true)
    {
      lan locallan;
      if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000))
      {
        paramContext = lav.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        locallan = lar.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (locallan == null) {
          break label324;
        }
      }
      label324:
      for (paramContext = locallan.a(paramChatMessage.msg, paramChatMessage.uniseq, paramContext);; paramContext = null)
      {
        if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend())) {}
        for (paramaggl.jdField_a_of_type_Aqkt = aqlt.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool);; paramaggl.jdField_a_of_type_Aqkt = aqlt.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool))
        {
          if (paramaggl.jdField_a_of_type_Aqkt != null) {
            paramaggl.jdField_a_of_type_Aqkt.a(paramaggl.jdField_a_of_type_AndroidViewView, null);
          }
          if (paramaggl.jdField_a_of_type_Aqkt != null)
          {
            int j = paramChatMessage.vipBubbleDiyTextId;
            i = j;
            if (j <= 0) {
              i = aogu.b(paramChatMessage.vipBubbleID);
            }
            paramaggl.jdField_a_of_type_Aqkt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), true, paramView, gc.a(paramChatMessage), i);
          }
          if (paramaggl.jdField_a_of_type_AndroidViewView != null)
          {
            paramContext = paramaggl.jdField_a_of_type_AndroidViewView.getBackground();
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
          paramaggl.jdField_a_of_type_Aqkt = aqlt.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), null, bool);
          break;
          i = ((aogu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramChatMessage);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggl a()
  {
    return new ahww();
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
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
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167009));
      localTextView.setLinkTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167002));
      localTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      localTextView.setId(2131373876);
      ((RelativeLayout)localObject1).setId(2131373877);
      ((RelativeLayout)localObject1).addView(localTextView);
      paramView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setSingleLine(true);
      paramView.setGravity(17);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(1, 13.0F);
      paramView.setBackgroundResource(2130842581);
      paramView.setId(2131373879);
      paramView.setText(anzj.a(2131714608));
      paramBaseChatItemLayout.addView((View)localObject1);
      paramBaseChatItemLayout.addView(paramView);
      localObject1 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131373877);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131373877);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
      localObject1 = paramView;
      ((TextView)localObject1).setPadding((int)(5.0F * this.jdField_a_of_type_Float), 0, (int)(5.0F * this.jdField_a_of_type_Float), 0);
      ((TextView)localObject1).getLayoutParams().height = ((int)(20.0F * this.jdField_a_of_type_Float));
      paramView = (MessageForWantGiftMsg)paramChatMessage;
      ((TextView)localObject1).setOnClickListener(new ahwu(this, paramChatMessage, paramView));
      int j = BaseChatItemLayout.o;
      int i = BaseChatItemLayout.p;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.p;
        i = BaseChatItemLayout.o;
      }
      localTextView.setPadding(j, BaseChatItemLayout.m, i, BaseChatItemLayout.n);
      localTextView.setText(paramView.msg);
      localTextView.setBackgroundResource(2130838370);
      a(paramChatMessage, this.jdField_a_of_type_AndroidContentContext, paramaggl, paramBaseChatItemLayout.findViewById(2131373877));
      if (paramView.wantGiftSenderUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
        break label465;
      }
      ((TextView)localObject1).setVisibility(8);
    }
    for (;;)
    {
      ((View)localObject2).setOnLongClickListener(paramagjk);
      ((View)localObject2).setOnTouchListener(new ahwv(this, paramagjk));
      return localObject2;
      paramBaseChatItemLayout = (RelativeLayout)paramView;
      localTextView = (TextView)paramBaseChatItemLayout.findViewById(2131373876);
      localObject1 = (TextView)paramBaseChatItemLayout.findViewById(2131373879);
      localObject2 = paramView;
      break;
      label465:
      ((TextView)localObject1).setVisibility(0);
      new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_send_him").a(0).a(new String[] { paramChatMessage.frienduin + "", "29" }).a();
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
    case 2131376511: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    paramView = agej.a(paramView);
    a(paramView, localbhuk);
    aean.a(localbhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    b(paramView, localbhuk);
    super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    return localbhuk.a();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwt
 * JD-Core Version:    0.7.0.1
 */