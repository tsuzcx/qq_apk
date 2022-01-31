import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShakeWindow;

public class adod
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  private long c = -1L;
  
  public adod(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adoe(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acju a()
  {
    return new adoh(this);
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    adoh localadoh = (adoh)paramacju;
    paramacju = paramView;
    if (paramView == null)
    {
      paramacju = new LinearLayout(paramBaseChatItemLayout);
      paramacju.setOrientation(0);
      paramView = new ImageView(paramBaseChatItemLayout);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      paramacju.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131101278));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.e);
      ((TextView)localObject).setId(2131298555);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramacju.addView((View)localObject, localLayoutParams);
      localadoh.jdField_a_of_type_AndroidWidgetImageView = paramView;
      localadoh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    localadoh.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    int i = BaseChatItemLayout.n;
    localadoh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843943);
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.o;
      j = BaseChatItemLayout.n;
      i = BaseChatItemLayout.o;
      localadoh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843944);
    }
    localadoh.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, 0, 0);
    localadoh.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    localadoh.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131653574));
    paramacju.setOnTouchListener(paramacmv);
    paramacju.setOnLongClickListener(paramacmv);
    paramacju.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (e)
    {
      if ((localadoh.b != null) && (localadoh.b.length() > 0)) {
        localadoh.b.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L) {
        paramView.append(baiu.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L)).append(" ");
      }
      if (!paramChatMessage.isSend()) {
        break label417;
      }
      paramView.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("一下");
    }
    for (;;)
    {
      paramacju.setContentDescription(paramView.toString());
      return paramacju;
      label417:
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("抖了你一下");
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(baiu.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    if (paramChatMessage.isSend()) {
      localStringBuilder.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("一下");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("抖了你一下");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131299417: 
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(acju paramacju, View paramView, ChatMessage paramChatMessage, almt paramalmt)
  {
    adoh localadoh = (adoh)paramacju;
    if ((paramalmt.a == 0) || (!paramalmt.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacju = paramView.getColorStateList(2131101282);
        if (paramacju != null) {
          localadoh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacju);
        }
        if (!paramChatMessage.isSend()) {
          break label88;
        }
      }
      label88:
      for (paramacju = paramView.getColorStateList(2131101281);; paramacju = paramView.getColorStateList(2131101280))
      {
        localadoh.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacju);
        return;
        paramacju = paramView.getColorStateList(2131101278);
        break;
      }
    }
    if (paramalmt.b == 0) {
      localadoh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramalmt.c == 0)
    {
      localadoh.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131101280));
      return;
      localadoh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramalmt.b);
    }
    localadoh.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramalmt.c);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForShakeWindow)aciy.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624443);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131624444);
    if (paramView.isSendFromLocal()) {
      babr.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adof(this, paramView), new adog(this)).show();
    }
  }
  
  public bakj[] a(View paramView)
  {
    paramView = new bakh();
    aael.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.d(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adod
 * JD-Core Version:    0.7.0.1
 */