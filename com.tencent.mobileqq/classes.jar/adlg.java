import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.qphone.base.util.QLog;

public class adlg
  extends BaseBubbleBuilder
  implements acwb
{
  Handler b = new Handler();
  
  public adlg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(adlh paramadlh, MessageForApproval paramMessageForApproval, View paramView, acxj paramacxj)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramadlh.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramadlh.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (paramMessageForApproval.isSend())
    {
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
    }
    for (localLayoutParams1.leftMargin = ((int)(16.0F * this.jdField_a_of_type_Float));; localLayoutParams1.leftMargin = ((int)(24.0F * this.jdField_a_of_type_Float)))
    {
      paramadlh.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      paramadlh.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
      paramadlh.jdField_a_of_type_AndroidWidgetLinearLayout.invalidate();
      paramadlh.jdField_a_of_type_AndroidWidgetTextView.invalidate();
      paramView.setOnLongClickListener(paramacxj);
      paramView.setOnTouchListener(paramacxj);
      paramView.setOnClickListener(this);
      return;
      localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
      localLayoutParams.rightMargin = 0;
    }
  }
  
  private void a(MessageForApproval paramMessageForApproval, adlh paramadlh)
  {
    for (;;)
    {
      int i;
      Object localObject5;
      Object localObject3;
      Object localObject4;
      try
      {
        paramadlh.d.setText(paramMessageForApproval.summary);
        String[] arrayOfString = paramMessageForApproval.title.split("\002");
        if (arrayOfString.length == 1)
        {
          paramadlh.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForApproval.title.substring(3));
          paramadlh.c.setVisibility(8);
          return;
        }
        localObject1 = ajya.a(2131700629);
        int j = arrayOfString.length;
        String str1 = "";
        paramMessageForApproval = "";
        localObject2 = "";
        i = 0;
        if (i < j)
        {
          String str2 = arrayOfString[i];
          if (str2.startsWith("000"))
          {
            localObject5 = (String)localObject1 + str2.substring(3);
            localObject3 = paramMessageForApproval;
            localObject4 = localObject2;
          }
          else if (str2.startsWith("001"))
          {
            localObject4 = str2.substring(3);
            localObject3 = paramMessageForApproval;
            localObject5 = localObject1;
          }
          else if (str2.startsWith("002"))
          {
            localObject3 = str2.substring(3);
            localObject4 = localObject2;
            localObject5 = localObject1;
          }
          else
          {
            localObject3 = paramMessageForApproval;
            localObject4 = localObject2;
            localObject5 = localObject1;
            if (str2.startsWith("003"))
            {
              str1 = str2.substring(3);
              localObject3 = paramMessageForApproval;
              localObject4 = localObject2;
              localObject5 = localObject1;
            }
          }
        }
        else
        {
          localObject3 = paramMessageForApproval;
          if ("1".equalsIgnoreCase(str1) == true) {
            localObject3 = paramMessageForApproval + ajya.a(2131700626);
          }
          paramadlh.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          paramadlh.c.setText((String)localObject2 + (String)localObject3);
          return;
        }
      }
      catch (Exception paramMessageForApproval)
      {
        if (QLog.isDevelopLevel())
        {
          paramadlh.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131700630));
          paramadlh.c.setText(ajya.a(2131700627));
        }
        QLog.e("ApprovalMsgBuilder", 1, paramMessageForApproval.toString());
        return;
      }
      i += 1;
      paramMessageForApproval = (MessageForApproval)localObject3;
      Object localObject2 = localObject4;
      Object localObject1 = localObject5;
    }
  }
  
  private void d(View paramView)
  {
    paramView = (MessageForApproval)actj.a(paramView);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return new adlh(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramChatMessage = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    paramView = (adlh)paramChatMessage.getTag();
    paramView.jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.d;
    if (e) {}
    try
    {
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(paramView.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(paramView.c.getText());
      paramView.jdField_b_of_type_JavaLangStringBuilder.append("审批");
      paramChatMessage.setContentDescription(paramView.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramChatMessage;
    }
    catch (Exception paramView) {}
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    paramacuj = (adlh)paramacuj;
    paramBaseChatItemLayout = (MessageForApproval)paramChatMessage;
    paramBaseChatItemLayout.parse();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558726, null);
      paramacuj.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131369757));
      paramacuj.c = ((TextView)paramChatMessage.findViewById(2131376703));
      paramacuj.d = ((TextView)paramChatMessage.findViewById(2131376712));
      paramacuj.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramChatMessage.findViewById(2131370512));
      paramacuj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131368404));
    }
    a(paramacuj, paramBaseChatItemLayout, paramChatMessage, paramacxj);
    a(paramBaseChatItemLayout, paramacuj);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bbfh.a(paramChatMessage.issend)) {
      return ajya.a(2131700628);
    }
    return ajya.a(2131700631);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, ayqo paramayqo, int paramInt1, int paramInt2)
  {
    paramView = (adlh)actj.a(paramView);
    a((MessageForApproval)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView);
  }
  
  public bbmh[] a(View paramView)
  {
    paramView = new bbmf();
    aanz.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    actj.n = true;
    if (super.a()) {
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131364117: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adlg
 * JD-Core Version:    0.7.0.1
 */