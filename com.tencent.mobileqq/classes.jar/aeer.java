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

public class aeer
  extends BaseBubbleBuilder
{
  public aeer(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, acuj paramacuj, View paramView)
  {
    int i = 0;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {}
    for (boolean bool = false;; bool = true)
    {
      lbf locallbf;
      if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000))
      {
        paramContext = lbn.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        locallbf = lbj.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (locallbf == null) {
          break label314;
        }
      }
      label314:
      for (paramContext = locallbf.a(paramChatMessage.msg, paramChatMessage.uniseq, paramContext);; paramContext = null)
      {
        if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend())) {}
        for (paramacuj.jdField_a_of_type_Ambg = amcg.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool);; paramacuj.jdField_a_of_type_Ambg = amcg.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool))
        {
          if (paramacuj.jdField_a_of_type_Ambg != null) {
            paramacuj.jdField_a_of_type_Ambg.a(paramacuj.jdField_a_of_type_AndroidViewView, null);
          }
          if (paramacuj.jdField_a_of_type_Ambg != null)
          {
            int j = paramChatMessage.vipBubbleDiyTextId;
            i = j;
            if (j <= 0) {
              i = akfv.b(paramChatMessage.vipBubbleID);
            }
            paramacuj.jdField_a_of_type_Ambg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), true, paramView, ho.a(paramChatMessage), i);
          }
          if (paramacuj.jdField_a_of_type_AndroidViewView != null)
          {
            paramContext = paramacuj.jdField_a_of_type_AndroidViewView.getBackground();
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
          paramacuj.jdField_a_of_type_Ambg = amcg.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), null, bool);
          break;
          i = ((akfv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramChatMessage);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return new aeeu();
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
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
      localTextView.setMaxWidth(BaseChatItemLayout.d);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166872));
      localTextView.setLinkTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166866));
      localTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      localTextView.setId(2131372749);
      ((RelativeLayout)localObject1).setId(2131372750);
      ((RelativeLayout)localObject1).addView(localTextView);
      paramView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setSingleLine(true);
      paramView.setGravity(17);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(1, 13.0F);
      paramView.setBackgroundResource(2130842092);
      paramView.setId(2131372752);
      paramView.setText(ajya.a(2131715834));
      paramBaseChatItemLayout.addView((View)localObject1);
      paramBaseChatItemLayout.addView(paramView);
      localObject1 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131372750);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131372750);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
      localObject1 = paramView;
      ((TextView)localObject1).setPadding((int)(5.0F * this.jdField_a_of_type_Float), 0, (int)(5.0F * this.jdField_a_of_type_Float), 0);
      ((TextView)localObject1).getLayoutParams().height = ((int)(20.0F * this.jdField_a_of_type_Float));
      paramView = (MessageForWantGiftMsg)paramChatMessage;
      ((TextView)localObject1).setOnClickListener(new aees(this, paramChatMessage, paramView));
      int j = BaseChatItemLayout.n;
      int i = BaseChatItemLayout.o;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.o;
        i = BaseChatItemLayout.n;
      }
      localTextView.setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
      localTextView.setText(paramView.msg);
      localTextView.setBackgroundResource(2130838183);
      a(paramChatMessage, this.jdField_a_of_type_AndroidContentContext, paramacuj, paramBaseChatItemLayout.findViewById(2131372750));
      if (paramView.wantGiftSenderUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
        break label463;
      }
      ((TextView)localObject1).setVisibility(8);
    }
    for (;;)
    {
      ((View)localObject2).setOnLongClickListener(paramacxj);
      ((View)localObject2).setOnTouchListener(new aeet(this, paramacxj));
      return localObject2;
      paramBaseChatItemLayout = (RelativeLayout)paramView;
      localTextView = (TextView)paramBaseChatItemLayout.findViewById(2131372749);
      localObject1 = (TextView)paramBaseChatItemLayout.findViewById(2131372752);
      localObject2 = paramView;
      break;
      label463:
      ((TextView)localObject1).setVisibility(0);
      new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_send_him").a(0).a(new String[] { paramChatMessage.frienduin + "", "29" }).a();
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
    case 2131375125: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, 0, 0, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(0, 0, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = actj.a(paramView);
    a(paramView, localbbmf);
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    b(paramView, localbbmf);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeer
 * JD-Core Version:    0.7.0.1
 */