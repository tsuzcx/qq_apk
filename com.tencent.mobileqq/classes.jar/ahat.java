import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahat
  extends ahit
  implements afqq
{
  public ahat(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public afqq a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    if (paramChatMessage == null)
    {
      paramView = null;
      return paramView;
    }
    MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramChatMessage;
    if ((localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("0")) || (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("1")))
    {
      if ((paramView != null) && ((paramView instanceof TextView))) {
        return super.a(paramChatMessage, paramafqr, paramView, paramBaseChatItemLayout, paramaftk);
      }
      return super.a(paramChatMessage, paramafqr, null, paramBaseChatItemLayout, paramaftk);
    }
    Object localObject1 = paramBaseChatItemLayout.getContext();
    ahjb localahjb = (ahjb)paramafqr;
    if (paramView != null)
    {
      paramafqr = paramView;
      if (!(paramView instanceof TextView)) {}
    }
    else
    {
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramafqr = new RelativeLayout((Context)localObject1);
      paramafqr.setPadding(paramView.getDimensionPixelSize(2131296385), paramView.getDimensionPixelSize(2131296387), paramView.getDimensionPixelSize(2131296384), paramView.getDimensionPixelSize(2131296386));
      localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.e, -2);
      int i = paramView.getDimensionPixelSize(2131298980);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(i, 0, i, 0);
      paramafqr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      i = AIOUtils.dp2px(6.0F, ((Context)localObject1).getResources());
      int j = AIOUtils.dp2px(7.0F, ((Context)localObject1).getResources());
      int k = AIOUtils.dp2px(13.0F, ((Context)localObject1).getResources());
      int m = AIOUtils.dp2px(15.0F, ((Context)localObject1).getResources());
      paramView = new LinearLayout((Context)localObject1);
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(BaseChatItemLayout.f, -2));
      paramView.setId(2131364523);
      paramView.setOrientation(1);
      paramView.setBackgroundResource(2130850486);
      paramView.setPadding(k, m, k, m);
      localObject2 = new ETTextView((Context)localObject1);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10((TextView)localObject2);
      ((ETTextView)localObject2).setTextSize(2, 15.0F);
      ((ETTextView)localObject2).setId(2131364525);
      ((ETTextView)localObject2).setTextColor(-16777216);
      ((ETTextView)localObject2).setPadding(0, 0, 0, i);
      localahjb.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      paramView.addView((View)localObject2);
      localObject2 = new View((Context)localObject1);
      ((View)localObject2).setBackgroundColor(((Context)localObject1).getResources().getColor(2131166378));
      paramView.addView((View)localObject2, BaseChatItemLayout.f, 2);
      localObject1 = new ETTextView((Context)localObject1);
      ((ETTextView)localObject1).setTextSize(2, 15.0F);
      ((ETTextView)localObject1).setId(2131364524);
      ((ETTextView)localObject1).setPadding(0, j, 0, 0);
      ((ETTextView)localObject1).setTextColor(-7829368);
      paramView.addView((View)localObject1);
      paramafqr.addView(paramView);
    }
    paramView = (TextView)paramafqr.findViewById(2131364525);
    Object localObject2 = paramafqr.findViewById(2131364523);
    localObject1 = (TextView)paramafqr.findViewById(2131364524);
    paramView.setMaxLines(4);
    if (!android.text.TextUtils.isEmpty(localMessageForLongTextMsg.sb)) {
      if (!android.text.TextUtils.isEmpty(localMessageForLongTextMsg.sb2))
      {
        localahjb.jdField_d_of_type_AndroidWidgetTextView.setText(localMessageForLongTextMsg.sb2);
        label513:
        ((View)localObject2).setOnTouchListener(paramaftk);
        ((View)localObject2).setOnLongClickListener(paramaftk);
        if ((!localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3")) || (!localMessageForLongTextMsg.loading)) {
          break label687;
        }
        ((TextView)localObject1).setText(anvx.a(2131705854));
        ((View)localObject2).setTag(null);
        paramafqr.setClickable(false);
        ((View)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      paramaftk = gm.a(paramChatMessage);
      paramView.setTypeface(paramaftk);
      ((TextView)localObject1).setTypeface(paramaftk);
      paramView = paramafqr;
      if (localahjb == null) {
        break;
      }
      paramView = paramafqr;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      localahjb.jdField_d_of_type_AndroidViewView = super.a(localahjb.jdField_d_of_type_AndroidViewView, localahjb, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      super.a(localahjb.jdField_d_of_type_AndroidViewView, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
      return paramafqr;
      localahjb.jdField_d_of_type_AndroidWidgetTextView.setText(localMessageForLongTextMsg.sb);
      break label513;
      paramView.setText(localMessageForLongTextMsg.msg);
      break label513;
      label687:
      if (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3"))
      {
        ((TextView)localObject1).setText(anvx.a(2131705855));
        ((TextView)localObject1).setClickable(false);
        ((View)localObject2).setTag(localMessageForLongTextMsg);
        ((View)localObject2).setOnClickListener(this);
        ((View)localObject2).setClickable(false);
        ((View)localObject2).setVisibility(0);
      }
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = paramView.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramChatMessage;
    if ((localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {
      return;
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(f, c, e, d);
      return;
    }
    paramView.setPadding(e, c, f, d);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  public bhjs[] a(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.getMessage(paramView);
    if (((localChatMessage instanceof MessageForLongTextMsg)) && ((localChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (localChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("3"))))
    {
      paramView = new bhjq();
      if (localChatMessage.istroop == 1) {}
      a(localChatMessage, paramView);
      admh.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      if ((arhn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (d())) {
        b(paramView, this.jdField_a_of_type_AndroidContentContext, localChatMessage);
      }
      c(localChatMessage, paramView);
      b(localChatMessage, paramView);
      super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
      super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
      return paramView.a();
    }
    return super.a(paramView);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364523) {
      if (paramView.getTag() != null) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramView.getTag();
      Context localContext = paramView.getContext();
      Object localObject = (FragmentActivity)localContext;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        int i = ((FragmentActivity)localObject).getChatFragment().a().getCurType();
        String str1 = ((FragmentActivity)localObject).getChatFragment().a().getCurFriendUin();
        String str2 = ((FragmentActivity)localObject).getChatFragment().a().getCurTroopUin();
        localObject = new Intent(localContext, MultiForwardActivity.class);
        ((Intent)localObject).putExtra("chat_subType", 3);
        ((Intent)localObject).putExtra("uin", str1);
        ((Intent)localObject).putExtra("uintype", i);
        ((Intent)localObject).putExtra("troop_code", str2);
        str1 = localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_msg_resid");
        if (android.text.TextUtils.isEmpty(str1)) {
          QLog.e("ChatItemBuilder", 1, "LongTextMsg resid is null!");
        }
        ((Intent)localObject).putExtra("multi_url", str1);
        ((Intent)localObject).putExtra("multi_uniseq", localMessageForLongTextMsg.uniseq);
        ((Intent)localObject).putExtra("callback_type", 2);
        localContext.startActivity((Intent)localObject);
      }
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahat
 * JD-Core Version:    0.7.0.1
 */