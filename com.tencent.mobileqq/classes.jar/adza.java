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

public class adza
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  private long c = -1L;
  
  public adza(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adzb(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acuj a()
  {
    return new adze(this);
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    adze localadze = (adze)paramacuj;
    paramacuj = paramView;
    if (paramView == null)
    {
      paramacuj = new LinearLayout(paramBaseChatItemLayout);
      paramacuj.setOrientation(0);
      paramView = new ImageView(paramBaseChatItemLayout);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      paramacuj.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131166872));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.e);
      ((TextView)localObject).setId(2131364112);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramacuj.addView((View)localObject, localLayoutParams);
      localadze.jdField_a_of_type_AndroidWidgetImageView = paramView;
      localadze.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    localadze.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    int i = BaseChatItemLayout.n;
    localadze.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844024);
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.o;
      j = BaseChatItemLayout.n;
      i = BaseChatItemLayout.o;
      localadze.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844025);
    }
    localadze.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, 0, 0);
    localadze.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    localadze.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131719414));
    paramacuj.setOnTouchListener(paramacxj);
    paramacuj.setOnLongClickListener(paramacxj);
    paramacuj.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (e)
    {
      if ((localadze.b != null) && (localadze.b.length() > 0)) {
        localadze.b.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L) {
        paramView.append(bbkp.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L)).append(" ");
      }
      if (!paramChatMessage.isSend()) {
        break label417;
      }
      paramView.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("一下");
    }
    for (;;)
    {
      paramacuj.setContentDescription(paramView.toString());
      return paramacuj;
      label417:
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("抖了你一下");
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bbkp.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
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
    case 2131364984: 
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(acuj paramacuj, View paramView, ChatMessage paramChatMessage, ambg paramambg)
  {
    adze localadze = (adze)paramacuj;
    if ((paramambg.a == 0) || (!paramambg.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacuj = paramView.getColorStateList(2131166876);
        if (paramacuj != null) {
          localadze.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacuj);
        }
        if (!paramChatMessage.isSend()) {
          break label88;
        }
      }
      label88:
      for (paramacuj = paramView.getColorStateList(2131166875);; paramacuj = paramView.getColorStateList(2131166874))
      {
        localadze.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacuj);
        return;
        paramacuj = paramView.getColorStateList(2131166872);
        break;
      }
    }
    if (paramambg.b == 0) {
      localadze.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramambg.c == 0)
    {
      localadze.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131166874));
      return;
      localadze.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambg.b);
    }
    localadze.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramambg.c);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForShakeWindow)actj.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689995);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689996);
    if (paramView.isSendFromLocal()) {
      bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adzc(this, paramView), new adzd(this)).show();
    }
  }
  
  public bbmh[] a(View paramView)
  {
    paramView = new bbmf();
    aanz.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adza
 * JD-Core Version:    0.7.0.1
 */