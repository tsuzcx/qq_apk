import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.qphone.base.util.QLog;

public class afvd
  extends agda
  implements aeqh
{
  public afvd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public aeqh a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    if (paramChatMessage == null) {
      return null;
    }
    MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramChatMessage;
    if ((localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("0")) || (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("1")))
    {
      if ((paramView != null) && ((paramView instanceof TextView))) {
        return super.a(paramChatMessage, paramaeqi, paramView, paramBaseChatItemLayout, paramaetk);
      }
      return super.a(paramChatMessage, paramaeqi, null, paramBaseChatItemLayout, paramaetk);
    }
    Object localObject1 = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (agdh)paramaeqi;
    if (paramView != null)
    {
      paramaeqi = paramView;
      if (!(paramView instanceof TextView)) {}
    }
    else
    {
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramaeqi = new RelativeLayout((Context)localObject1);
      paramaeqi.setPadding(paramView.getDimensionPixelSize(2131296294), paramView.getDimensionPixelSize(2131296296), paramView.getDimensionPixelSize(2131296293), paramView.getDimensionPixelSize(2131296295));
      localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.d, -2);
      int i = paramView.getDimensionPixelSize(2131298815);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(i, 0, i, 0);
      paramaeqi.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      i = aepi.a(6.0F, ((Context)localObject1).getResources());
      int j = aepi.a(7.0F, ((Context)localObject1).getResources());
      int k = aepi.a(13.0F, ((Context)localObject1).getResources());
      int m = aepi.a(15.0F, ((Context)localObject1).getResources());
      paramView = new LinearLayout((Context)localObject1);
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(BaseChatItemLayout.e, -2));
      paramView.setId(2131364174);
      paramView.setOrientation(1);
      paramView.setBackgroundResource(2130849854);
      paramView.setPadding(k, m, k, m);
      localObject2 = new ETTextView((Context)localObject1);
      banh.a((TextView)localObject2);
      ((ETTextView)localObject2).setTextSize(2, 15.0F);
      ((ETTextView)localObject2).setId(2131364176);
      ((ETTextView)localObject2).setTextColor(-16777216);
      ((ETTextView)localObject2).setPadding(0, 0, 0, i);
      paramBaseChatItemLayout.d = ((TextView)localObject2);
      paramView.addView((View)localObject2);
      localObject2 = new View((Context)localObject1);
      ((View)localObject2).setBackgroundColor(((Context)localObject1).getResources().getColor(2131166275));
      paramView.addView((View)localObject2, BaseChatItemLayout.e, 2);
      localObject1 = new ETTextView((Context)localObject1);
      ((ETTextView)localObject1).setTextSize(2, 15.0F);
      ((ETTextView)localObject1).setId(2131364175);
      ((ETTextView)localObject1).setPadding(0, j, 0, 0);
      ((ETTextView)localObject1).setTextColor(-7829368);
      paramView.addView((View)localObject1);
      paramaeqi.addView(paramView);
    }
    paramView = (TextView)paramaeqi.findViewById(2131364176);
    Object localObject2 = paramaeqi.findViewById(2131364174);
    localObject1 = (TextView)paramaeqi.findViewById(2131364175);
    paramView.setMaxLines(4);
    if (!TextUtils.isEmpty(localMessageForLongTextMsg.sb)) {
      if (!TextUtils.isEmpty(localMessageForLongTextMsg.sb2))
      {
        paramBaseChatItemLayout.d.setText(localMessageForLongTextMsg.sb2);
        ((View)localObject2).setOnTouchListener(paramaetk);
        ((View)localObject2).setOnLongClickListener(paramaetk);
        if ((!localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3")) || (!localMessageForLongTextMsg.loading)) {
          break label621;
        }
        ((TextView)localObject1).setText(alud.a(2131706775));
        ((View)localObject2).setTag(null);
        paramaeqi.setClickable(false);
        ((View)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      paramChatMessage = gj.a(paramChatMessage);
      paramView.setTypeface(paramChatMessage);
      ((TextView)localObject1).setTypeface(paramChatMessage);
      return paramaeqi;
      paramBaseChatItemLayout.d.setText(localMessageForLongTextMsg.sb);
      break;
      paramView.setText(localMessageForLongTextMsg.msg);
      break;
      label621:
      if (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3"))
      {
        ((TextView)localObject1).setText(alud.a(2131706776));
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
  
  public bdpk[] a(View paramView)
  {
    ChatMessage localChatMessage = aepi.a(paramView);
    if (((localChatMessage instanceof MessageForLongTextMsg)) && ((localChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (localChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("3"))))
    {
      paramView = new bdpi();
      if (localChatMessage.istroop == 1) {}
      a(localChatMessage, paramView);
      acjm.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      b(localChatMessage, paramView);
      super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
      super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
      return paramView.a();
    }
    return super.a(paramView);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364174)
    {
      if (paramView.getTag() == null) {
        return;
      }
      MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramView.getTag();
      Context localContext = paramView.getContext();
      Object localObject = (FragmentActivity)localContext;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        int i = ((FragmentActivity)localObject).getChatFragment().a().b();
        String str1 = ((FragmentActivity)localObject).getChatFragment().a().a();
        String str2 = ((FragmentActivity)localObject).getChatFragment().a().c();
        localObject = new Intent(localContext, MultiForwardActivity.class);
        ((Intent)localObject).putExtra("chat_subType", 3);
        ((Intent)localObject).putExtra("uin", str1);
        ((Intent)localObject).putExtra("uintype", i);
        ((Intent)localObject).putExtra("troop_code", str2);
        str1 = localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_msg_resid");
        if (TextUtils.isEmpty(str1)) {
          QLog.e("ChatItemBuilder", 1, "LongTextMsg resid is null!");
        }
        ((Intent)localObject).putExtra("multi_url", str1);
        ((Intent)localObject).putExtra("multi_uniseq", localMessageForLongTextMsg.uniseq);
        ((Intent)localObject).putExtra("callback_type", 2);
        localContext.startActivity((Intent)localObject);
      }
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvd
 * JD-Core Version:    0.7.0.1
 */