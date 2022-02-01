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

public class agne
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  private long c = -1L;
  
  public agne(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agnf(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aezf a()
  {
    return new agni(this);
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    agni localagni = (agni)paramaezf;
    paramaezf = paramView;
    if (paramView == null)
    {
      paramaezf = new LinearLayout(paramBaseChatItemLayout);
      paramaezf.setOrientation(0);
      paramView = new ImageView(paramBaseChatItemLayout);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      paramaezf.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131167031));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.f);
      ((TextView)localObject).setId(2131364444);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramaezf.addView((View)localObject, localLayoutParams);
      localagni.jdField_a_of_type_AndroidWidgetImageView = paramView;
      localagni.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    localagni.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
    int k = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    int i = BaseChatItemLayout.o;
    localagni.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844723);
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.p;
      localagni.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844724);
    }
    localagni.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, 0, 0);
    localagni.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    localagni.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131718232));
    paramaezf.setOnTouchListener(paramafce);
    paramaezf.setOnLongClickListener(paramafce);
    paramaezf.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (e)
    {
      if ((localagni.b != null) && (localagni.b.length() > 0)) {
        localagni.b.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L) {
        paramView.append(bfzl.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L)).append(" ");
      }
      if (!paramChatMessage.isSend()) {
        break label417;
      }
      paramView.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick).append("一下");
    }
    for (;;)
    {
      paramaezf.setContentDescription(paramView.toString());
      return paramaezf;
      label417:
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick).append("抖了你一下");
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bfzl.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
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
    case 2131365382: 
      acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage, apee paramapee)
  {
    agni localagni = (agni)paramaezf;
    if ((paramapee.a == 0) || (!paramapee.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramaezf = paramView.getColorStateList(2131167035);
        if (paramaezf != null) {
          localagni.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaezf);
        }
        if (!paramChatMessage.isSend()) {
          break label88;
        }
      }
      label88:
      for (paramaezf = paramView.getColorStateList(2131167034);; paramaezf = paramView.getColorStateList(2131167033))
      {
        localagni.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaezf);
        return;
        paramaezf = paramView.getColorStateList(2131167031);
        break;
      }
    }
    if (paramapee.b == 0) {
      localagni.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramapee.c == 0)
    {
      localagni.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167033));
      return;
      localagni.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramapee.b);
    }
    localagni.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramapee.c);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForShakeWindow)AIOUtils.getMessage(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689947);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689948);
    if (paramView.isSendFromLocal()) {
      bfur.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new agng(this, paramView), new agnh(this)).show();
    }
  }
  
  public bgbb[] a(View paramView)
  {
    paramView = new bgaz();
    acvv.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agne
 * JD-Core Version:    0.7.0.1
 */