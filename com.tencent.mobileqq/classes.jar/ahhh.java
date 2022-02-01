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

public class ahhh
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  private long c = -1L;
  
  public ahhh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahhi(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public afwr a()
  {
    return new ahhl(this);
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    ahhl localahhl = (ahhl)paramafwr;
    paramafwr = paramView;
    if (paramView == null)
    {
      paramafwr = new LinearLayout(paramBaseChatItemLayout);
      paramafwr.setOrientation(0);
      paramView = new ImageView(paramBaseChatItemLayout);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      paramafwr.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131167004));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.f);
      ((TextView)localObject).setId(2131364382);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramafwr.addView((View)localObject, localLayoutParams);
      localahhl.jdField_a_of_type_AndroidWidgetImageView = paramView;
      localahhl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    localahhl.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    int i = BaseChatItemLayout.o;
    localahhl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844833);
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.p;
      localahhl.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844834);
    }
    localahhl.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, 0, 0);
    localahhl.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    localahhl.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131717859));
    paramafwr.setOnTouchListener(paramafzq);
    paramafwr.setOnLongClickListener(paramafzq);
    paramafwr.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (e)
    {
      if ((localahhl.b != null) && (localahhl.b.length() > 0)) {
        localahhl.b.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L) {
        paramView.append(bgsu.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L)).append(" ");
      }
      if (!paramChatMessage.isSend()) {
        break label417;
      }
      paramView.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("一下");
    }
    for (;;)
    {
      paramafwr.setContentDescription(paramView.toString());
      return paramafwr;
      label417:
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("抖了你一下");
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bgsu.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
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
    case 2131365308: 
      adrm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(afwr paramafwr, View paramView, ChatMessage paramChatMessage, apwt paramapwt)
  {
    ahhl localahhl = (ahhl)paramafwr;
    if ((paramapwt.a == 0) || (!paramapwt.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramafwr = paramView.getColorStateList(2131167008);
        if (paramafwr != null) {
          localahhl.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramafwr);
        }
        if (!paramChatMessage.isSend()) {
          break label88;
        }
      }
      label88:
      for (paramafwr = paramView.getColorStateList(2131167007);; paramafwr = paramView.getColorStateList(2131167006))
      {
        localahhl.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramafwr);
        return;
        paramafwr = paramView.getColorStateList(2131167004);
        break;
      }
    }
    if (paramapwt.b == 0) {
      localahhl.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramapwt.c == 0)
    {
      localahhl.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167006));
      return;
      localahhl.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramapwt.b);
    }
    localahhl.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramapwt.c);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForShakeWindow)afur.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689926);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689927);
    if (paramView.isSendFromLocal()) {
      bglp.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahhj(this, paramView), new ahhk(this)).show();
    }
  }
  
  public bguj[] a(View paramView)
  {
    paramView = new bguh();
    adrm.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhh
 * JD-Core Version:    0.7.0.1
 */