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

public class afvo
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  private long c = -1L;
  
  public afvo(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afvp(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aelt a()
  {
    return new afvs(this);
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    afvs localafvs = (afvs)paramaelt;
    paramaelt = paramView;
    if (paramView == null)
    {
      paramaelt = new LinearLayout(paramBaseChatItemLayout);
      paramaelt.setOrientation(0);
      paramView = new ImageView(paramBaseChatItemLayout);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      paramaelt.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131166919));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.e);
      ((TextView)localObject).setId(2131364174);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramaelt.addView((View)localObject, localLayoutParams);
      localafvs.jdField_a_of_type_AndroidWidgetImageView = paramView;
      localafvs.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    localafvs.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    int i = BaseChatItemLayout.n;
    localafvs.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844367);
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.o;
      j = BaseChatItemLayout.n;
      i = BaseChatItemLayout.o;
      localafvs.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844368);
    }
    localafvs.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, 0, 0);
    localafvs.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    localafvs.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131719902));
    paramaelt.setOnTouchListener(paramaeov);
    paramaelt.setOnLongClickListener(paramaeov);
    paramaelt.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (e)
    {
      if ((localafvs.b != null) && (localafvs.b.length() > 0)) {
        localafvs.b.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L) {
        paramView.append(bdjj.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L)).append(" ");
      }
      if (!paramChatMessage.isSend()) {
        break label417;
      }
      paramView.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("一下");
    }
    for (;;)
    {
      paramaelt.setContentDescription(paramView.toString());
      return paramaelt;
      label417:
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("抖了你一下");
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bdjj.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
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
    case 2131365069: 
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(aelt paramaelt, View paramView, ChatMessage paramChatMessage, ansf paramansf)
  {
    afvs localafvs = (afvs)paramaelt;
    if ((paramansf.a == 0) || (!paramansf.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramaelt = paramView.getColorStateList(2131166923);
        if (paramaelt != null) {
          localafvs.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaelt);
        }
        if (!paramChatMessage.isSend()) {
          break label88;
        }
      }
      label88:
      for (paramaelt = paramView.getColorStateList(2131166922);; paramaelt = paramView.getColorStateList(2131166921))
      {
        localafvs.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaelt);
        return;
        paramaelt = paramView.getColorStateList(2131166919);
        break;
      }
    }
    if (paramansf.b == 0) {
      localafvs.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramansf.c == 0)
    {
      localafvs.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131166921));
      return;
      localafvs.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramansf.b);
    }
    localafvs.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramansf.c);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForShakeWindow)aekt.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690042);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690043);
    if (paramView.isSendFromLocal()) {
      bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new afvq(this, paramView), new afvr(this)).show();
    }
  }
  
  public bdlb[] a(View paramView)
  {
    paramView = new bdkz();
    acex.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvo
 * JD-Core Version:    0.7.0.1
 */