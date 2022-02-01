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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ahfu
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  private long c = -1L;
  
  public ahfu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahfv(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public afqr a()
  {
    return new ahfy(this);
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    ahfy localahfy = (ahfy)paramafqr;
    paramafqr = paramView;
    if (paramView == null)
    {
      paramafqr = new LinearLayout(paramBaseChatItemLayout);
      paramafqr.setOrientation(0);
      paramView = new ImageView(paramBaseChatItemLayout);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      paramafqr.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131167045));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.f);
      ((TextView)localObject).setId(2131364525);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramafqr.addView((View)localObject, localLayoutParams);
      localahfy.jdField_a_of_type_AndroidWidgetImageView = paramView;
      localahfy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    localahfy.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
    int k = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    int i = BaseChatItemLayout.o;
    localahfy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844792);
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.p;
      localahfy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844793);
    }
    localahfy.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, 0, 0);
    localahfy.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    localahfy.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131718618));
    paramafqr.setOnTouchListener(paramaftk);
    paramafqr.setOnLongClickListener(paramaftk);
    paramafqr.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (e)
    {
      if ((localahfy.b != null) && (localahfy.b.length() > 0)) {
        localahfy.b.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L) {
        paramView.append(bhid.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L)).append(" ");
      }
      if (!paramChatMessage.isSend()) {
        break label417;
      }
      paramView.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick).append("一下");
    }
    for (;;)
    {
      paramafqr.setContentDescription(paramView.toString());
      return paramafqr;
      label417:
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick).append("抖了你一下");
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bhid.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    if (paramChatMessage.isSend()) {
      localStringBuilder.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick).append("一下");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick).append("抖了你一下");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131365475: 
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(afqr paramafqr, View paramView, ChatMessage paramChatMessage, aqhi paramaqhi)
  {
    ahfy localahfy = (ahfy)paramafqr;
    if ((paramaqhi.a == 0) || (!paramaqhi.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramafqr = paramView.getColorStateList(2131167049);
        if (paramafqr != null) {
          localahfy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramafqr);
        }
        if (!paramChatMessage.isSend()) {
          break label88;
        }
      }
      label88:
      for (paramafqr = paramView.getColorStateList(2131167048);; paramafqr = paramView.getColorStateList(2131167047))
      {
        localahfy.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramafqr);
        return;
        paramafqr = paramView.getColorStateList(2131167045);
        break;
      }
    }
    if (paramaqhi.b == 0) {
      localahfy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramaqhi.c == 0)
    {
      localahfy.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167047));
      return;
      localahfy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.b);
    }
    localahfy.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaqhi.c);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForShakeWindow)AIOUtils.getMessage(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689976);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689977);
    if (paramView.isSendFromLocal()) {
      bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahfw(this, paramView), new ahfx(this)).show();
    }
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = new bhjq();
    admh.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfu
 * JD-Core Version:    0.7.0.1
 */