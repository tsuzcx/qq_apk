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

public class adzc
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  private long c = -1L;
  
  public adzc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adzd(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acun a()
  {
    return new adzg(this);
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    adzg localadzg = (adzg)paramacun;
    paramacun = paramView;
    if (paramView == null)
    {
      paramacun = new LinearLayout(paramBaseChatItemLayout);
      paramacun.setOrientation(0);
      paramView = new ImageView(paramBaseChatItemLayout);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      paramacun.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131166872));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.e);
      ((TextView)localObject).setId(2131364113);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramacun.addView((View)localObject, localLayoutParams);
      localadzg.jdField_a_of_type_AndroidWidgetImageView = paramView;
      localadzg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    localadzg.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    int i = BaseChatItemLayout.n;
    localadzg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844023);
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.o;
      j = BaseChatItemLayout.n;
      i = BaseChatItemLayout.o;
      localadzg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844024);
    }
    localadzg.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, 0, 0);
    localadzg.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    localadzg.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131719403));
    paramacun.setOnTouchListener(paramacxn);
    paramacun.setOnLongClickListener(paramacxn);
    paramacun.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (e)
    {
      if ((localadzg.b != null) && (localadzg.b.length() > 0)) {
        localadzg.b.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L) {
        paramView.append(bbkb.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L)).append(" ");
      }
      if (!paramChatMessage.isSend()) {
        break label417;
      }
      paramView.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("一下");
    }
    for (;;)
    {
      paramacun.setContentDescription(paramView.toString());
      return paramacun;
      label417:
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("抖了你一下");
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bbkb.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
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
    case 2131364985: 
      aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(acun paramacun, View paramView, ChatMessage paramChatMessage, ambh paramambh)
  {
    adzg localadzg = (adzg)paramacun;
    if ((paramambh.a == 0) || (!paramambh.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacun = paramView.getColorStateList(2131166876);
        if (paramacun != null) {
          localadzg.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacun);
        }
        if (!paramChatMessage.isSend()) {
          break label88;
        }
      }
      label88:
      for (paramacun = paramView.getColorStateList(2131166875);; paramacun = paramView.getColorStateList(2131166874))
      {
        localadzg.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacun);
        return;
        paramacun = paramView.getColorStateList(2131166872);
        break;
      }
    }
    if (paramambh.b == 0) {
      localadzg.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramambh.c == 0)
    {
      localadzg.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131166874));
      return;
      localadzg.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambh.b);
    }
    localadzg.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramambh.c);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForShakeWindow)actn.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689995);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689996);
    if (paramView.isSendFromLocal()) {
      bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adze(this, paramView), new adzf(this)).show();
    }
  }
  
  public bblt[] a(View paramView)
  {
    paramView = new bblr();
    aaod.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzc
 * JD-Core Version:    0.7.0.1
 */