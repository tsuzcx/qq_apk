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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agnu
  extends BaseBubbleBuilder
  implements afsn
{
  Handler b = new Handler();
  
  public agnu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(agnv paramagnv, MessageForApproval paramMessageForApproval, View paramView, aftk paramaftk)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramagnv.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramagnv.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (paramMessageForApproval.isSend())
    {
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
    }
    for (localLayoutParams1.leftMargin = ((int)(16.0F * this.jdField_a_of_type_Float));; localLayoutParams1.leftMargin = ((int)(24.0F * this.jdField_a_of_type_Float)))
    {
      paramagnv.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      paramagnv.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
      paramagnv.jdField_a_of_type_AndroidWidgetLinearLayout.invalidate();
      paramagnv.jdField_a_of_type_AndroidWidgetTextView.invalidate();
      paramView.setOnLongClickListener(paramaftk);
      paramView.setOnTouchListener(paramaftk);
      paramView.setOnClickListener(this);
      return;
      localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
      localLayoutParams.rightMargin = 0;
    }
  }
  
  private void a(MessageForApproval paramMessageForApproval, agnv paramagnv)
  {
    for (;;)
    {
      int i;
      Object localObject5;
      Object localObject3;
      Object localObject4;
      try
      {
        paramagnv.d.setText(paramMessageForApproval.summary);
        String[] arrayOfString = paramMessageForApproval.title.split("\002");
        if (arrayOfString.length == 1)
        {
          paramagnv.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForApproval.title.substring(3));
          paramagnv.c.setVisibility(8);
          return;
        }
        localObject1 = anvx.a(2131700128);
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
            localObject3 = paramMessageForApproval + anvx.a(2131700125);
          }
          paramagnv.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          paramagnv.c.setText((String)localObject2 + (String)localObject3);
          return;
        }
      }
      catch (Exception paramMessageForApproval)
      {
        if (QLog.isDevelopLevel())
        {
          paramagnv.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131700129));
          paramagnv.c.setText(anvx.a(2131700126));
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
    paramView = (MessageForApproval)AIOUtils.getMessage(paramView);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new agnv(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramChatMessage = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    paramView = (agnv)paramChatMessage.getTag();
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
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramafqr = (agnv)paramafqr;
    paramBaseChatItemLayout = (MessageForApproval)paramChatMessage;
    paramBaseChatItemLayout.parse();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558858, null);
      paramafqr.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131370736));
      paramafqr.c = ((TextView)paramChatMessage.findViewById(2131378293));
      paramafqr.d = ((TextView)paramChatMessage.findViewById(2131378299));
      paramafqr.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramChatMessage.findViewById(2131371660));
      paramafqr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131369203));
    }
    a(paramafqr, paramBaseChatItemLayout, paramChatMessage, paramaftk);
    a(paramBaseChatItemLayout, paramafqr);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bhfj.a(paramChatMessage.issend)) {
      return anvx.a(2131700127);
    }
    return anvx.a(2131700130);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (agnv)AIOUtils.getHolder(paramView);
    a((MessageForApproval)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView);
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = new bhjq();
    admh.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.isUserOperatedInAIO = true;
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      switch (paramView.getId())
      {
      case 2131364530: 
      default: 
        break;
      case 2131364522: 
        e(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnu
 * JD-Core Version:    0.7.0.1
 */