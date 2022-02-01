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

public class ahqr
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  private long c = -1L;
  
  public ahqr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahqs(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aggl a()
  {
    return new ahqv(this);
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    ahqv localahqv = (ahqv)paramaggl;
    paramaggl = paramView;
    if (paramView == null)
    {
      paramaggl = new LinearLayout(paramBaseChatItemLayout);
      paramaggl.setOrientation(0);
      paramView = new ImageView(paramBaseChatItemLayout);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      paramaggl.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131167009));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.f);
      ((TextView)localObject).setId(2131364426);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramaggl.addView((View)localObject, localLayoutParams);
      localahqv.jdField_a_of_type_AndroidWidgetImageView = paramView;
      localahqv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    localahqv.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    int i = BaseChatItemLayout.o;
    localahqv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844847);
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.p;
      localahqv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844848);
    }
    localahqv.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, 0, 0);
    localahqv.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    localahqv.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131717991));
    paramaggl.setOnTouchListener(paramagjk);
    paramaggl.setOnLongClickListener(paramagjk);
    paramaggl.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (e)
    {
      if ((localahqv.b != null) && (localahqv.b.length() > 0)) {
        localahqv.b.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L) {
        paramView.append(bhsw.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L)).append(" ");
      }
      if (!paramChatMessage.isSend()) {
        break label417;
      }
      paramView.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("一下");
    }
    for (;;)
    {
      paramaggl.setContentDescription(paramView.toString());
      return paramaggl;
      label417:
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("抖了你一下");
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bhsw.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
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
    case 2131365352: 
      aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(aggl paramaggl, View paramView, ChatMessage paramChatMessage, aqkt paramaqkt)
  {
    ahqv localahqv = (ahqv)paramaggl;
    if ((paramaqkt.a == 0) || (!paramaqkt.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramaggl = paramView.getColorStateList(2131167013);
        if (paramaggl != null) {
          localahqv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaggl);
        }
        if (!paramChatMessage.isSend()) {
          break label88;
        }
      }
      label88:
      for (paramaggl = paramView.getColorStateList(2131167012);; paramaggl = paramView.getColorStateList(2131167011))
      {
        localahqv.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaggl);
        return;
        paramaggl = paramView.getColorStateList(2131167009);
        break;
      }
    }
    if (paramaqkt.b == 0) {
      localahqv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramaqkt.c == 0)
    {
      localahqv.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167011));
      return;
      localahqv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.b);
    }
    localahqv.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaqkt.c);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForShakeWindow)agej.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689933);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689934);
    if (paramView.isSendFromLocal()) {
      bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahqt(this, paramView), new ahqu(this)).show();
    }
  }
  
  public bhum[] a(View paramView)
  {
    paramView = new bhuk();
    aean.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqr
 * JD-Core Version:    0.7.0.1
 */