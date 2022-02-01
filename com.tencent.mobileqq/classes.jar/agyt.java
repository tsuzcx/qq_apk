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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agyt
  extends BaseBubbleBuilder
  implements agif
{
  Handler b = new Handler();
  
  public agyt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(agyu paramagyu, MessageForApproval paramMessageForApproval, View paramView, agjk paramagjk)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramagyu.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramagyu.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (paramMessageForApproval.isSend())
    {
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
    }
    for (localLayoutParams1.leftMargin = ((int)(16.0F * this.jdField_a_of_type_Float));; localLayoutParams1.leftMargin = ((int)(24.0F * this.jdField_a_of_type_Float)))
    {
      paramagyu.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      paramagyu.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
      paramagyu.jdField_a_of_type_AndroidWidgetLinearLayout.invalidate();
      paramagyu.jdField_a_of_type_AndroidWidgetTextView.invalidate();
      paramView.setOnLongClickListener(paramagjk);
      paramView.setOnTouchListener(paramagjk);
      paramView.setOnClickListener(this);
      return;
      localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
      localLayoutParams.rightMargin = 0;
    }
  }
  
  private void a(MessageForApproval paramMessageForApproval, agyu paramagyu)
  {
    for (;;)
    {
      int i;
      Object localObject5;
      Object localObject3;
      Object localObject4;
      try
      {
        paramagyu.d.setText(paramMessageForApproval.summary);
        String[] arrayOfString = paramMessageForApproval.title.split("\002");
        if (arrayOfString.length == 1)
        {
          paramagyu.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForApproval.title.substring(3));
          paramagyu.c.setVisibility(8);
          return;
        }
        localObject1 = anzj.a(2131699542);
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
            localObject3 = paramMessageForApproval + anzj.a(2131699539);
          }
          paramagyu.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          paramagyu.c.setText((String)localObject2 + (String)localObject3);
          return;
        }
      }
      catch (Exception paramMessageForApproval)
      {
        if (QLog.isDevelopLevel())
        {
          paramagyu.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131699543));
          paramagyu.c.setText(anzj.a(2131699540));
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
  
  private void e(View paramView)
  {
    paramView = (MessageForApproval)agej.a(paramView);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggl a()
  {
    return new agyu(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramChatMessage = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    paramView = (agyu)paramChatMessage.getTag();
    paramView.jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.e;
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
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramaggl = (agyu)paramaggl;
    paramBaseChatItemLayout = (MessageForApproval)paramChatMessage;
    paramBaseChatItemLayout.parse();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558825, null);
      paramaggl.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131370585));
      paramaggl.c = ((TextView)paramChatMessage.findViewById(2131378235));
      paramaggl.d = ((TextView)paramChatMessage.findViewById(2131378243));
      paramaggl.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramChatMessage.findViewById(2131371506));
      paramaggl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131369014));
    }
    a(paramaggl, paramBaseChatItemLayout, paramChatMessage, paramagjk);
    a(paramBaseChatItemLayout, paramaggl);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bhnt.a(paramChatMessage.issend)) {
      return anzj.a(2131699541);
    }
    return anzj.a(2131699544);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    paramView = (agyu)agej.a(paramView);
    a((MessageForApproval)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView);
  }
  
  public bhum[] a(View paramView)
  {
    paramView = new bhuk();
    aean.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    agej.n = true;
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      switch (paramView.getId())
      {
      case 2131364431: 
      default: 
        break;
      case 2131364423: 
        e(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyt
 * JD-Core Version:    0.7.0.1
 */