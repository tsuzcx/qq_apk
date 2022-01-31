import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.LocationShareItemBuilder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afuu
  extends BaseBubbleBuilder
{
  private static final int jdField_c_of_type_Int = BaseChatItemLayout.g + BaseChatItemLayout.l;
  private static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  atrj jdField_a_of_type_Atrj = new atrj();
  private long jdField_c_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  
  public afuu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131166921);
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, new Object[] { "LocationShareItemBuilder.new: invoked. ", " clickable: ", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
    }
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int i = localDrawable.getIntrinsicWidth();
    int j = localDrawable.getIntrinsicHeight();
    switch (this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    }
    int m;
    for (paramInt = j;; paramInt = (int)((j * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b / paramInt + m) * 1.6D))
    {
      localDrawable.setBounds(0, 0, i, paramInt);
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.q);
      return;
      int k = localResources.getDimensionPixelSize(2131297495);
      m = localResources.getDimensionPixelSize(2131297496);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      i = (int)((i * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b / paramInt + m) * 1.6D);
    }
  }
  
  private void a(MessageForLocationShare paramMessageForLocationShare)
  {
    List localList;
    if (this.jdField_c_of_type_Long == 0L)
    {
      localList = atud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
      if ((localList == null) || (localList.size() < 1)) {
        break label97;
      }
    }
    label97:
    for (this.jdField_c_of_type_Long = ((MessageRecord)localList.get(localList.size() - 1)).time;; this.jdField_c_of_type_Long = (System.currentTimeMillis() / 1000L))
    {
      if (this.jdField_c_of_type_Long > paramMessageForLocationShare.time)
      {
        paramMessageForLocationShare.isSharingLocation = false;
        ThreadManager.excute(new LocationShareItemBuilder.1(this, paramMessageForLocationShare), 32, null, true);
      }
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aeqi a()
  {
    return new afuv(this);
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    paramBaseChatItemLayout = (afuv)paramaeqi;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramaeqi = paramView;
    if (paramView == null)
    {
      paramaeqi = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramaeqi.setId(2131364176);
      paramaeqi.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      paramaeqi.setTextSize(localResources.getDimensionPixelOffset(2131296368));
      paramaeqi.setGravity(16);
      paramBaseChatItemLayout.a = paramaeqi;
    }
    paramView = (MessageForLocationShare)paramChatMessage;
    try
    {
      a(paramView);
      label81:
      int i;
      int j;
      if (paramView.isSharingLocation)
      {
        if (!bibv.a()) {
          if (paramView.isSend()) {
            i = 2130837992;
          }
        }
        for (;;)
        {
          j = localResources.getColor(2131166903);
          a(paramBaseChatItemLayout.a, i);
          paramBaseChatItemLayout.a.setTextColor(j);
          paramBaseChatItemLayout.a.setText(paramChatMessage.msg);
          paramaeqi.setOnTouchListener(paramaetk);
          paramaeqi.setOnLongClickListener(paramaetk);
          this.jdField_a_of_type_Atrj = new atrj();
          this.jdField_a_of_type_Atrj.a(paramView);
          this.jdField_a_of_type_Atrj.a = this.jdField_f_of_type_Boolean;
          paramaeqi.setOnClickListener(this.jdField_a_of_type_Atrj);
          if (AppSetting.c) {
            paramaeqi.setContentDescription(paramChatMessage.msg);
          }
          return paramaeqi;
          i = 2130837987;
          continue;
          i = 2130837988;
        }
      }
      if (!bibv.a()) {
        if (paramView.isSend()) {
          i = 2130837991;
        }
      }
      for (;;)
      {
        j = Color.parseColor("#6603081A");
        break;
        i = 2130837990;
        continue;
        i = 2130837989;
      }
    }
    catch (Throwable localThrowable)
    {
      break label81;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null) {
      return paramChatMessage.msg;
    }
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131365071)
    {
      acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131370861)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(aeqi paramaeqi, View paramView, ChatMessage paramChatMessage, anwo paramanwo)
  {
    afuv localafuv = (afuv)paramaeqi;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    localafuv.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    if ((paramanwo.a == 0) || (!paramanwo.a()))
    {
      paramaeqi = paramView.getResources();
      paramView = (MessageForLocationShare)paramChatMessage;
    }
    try
    {
      a(paramView);
      label62:
      if (paramView.isSharingLocation)
      {
        if (paramChatMessage.isSend()) {}
        for (paramaeqi = paramaeqi.getColorStateList(2131166925);; paramaeqi = paramaeqi.getColorStateList(2131166921))
        {
          localafuv.a.setTextColor(paramaeqi);
          return;
        }
      }
      if ((paramChatMessage.isSend()) || (bibv.a())) {}
      for (paramaeqi = paramaeqi.getColorStateList(2131166926);; paramaeqi = paramaeqi.getColorStateList(2131166922))
      {
        localafuv.a.setTextColor(paramaeqi);
        return;
      }
      if (paramanwo.b == 0) {
        localafuv.a.setTextColor(-16777216);
      }
      while (paramanwo.jdField_c_of_type_Int == 0)
      {
        localafuv.a.setLinkTextColor(paramView.getResources().getColorStateList(2131166923));
        return;
        localafuv.a.setTextColor(paramanwo.b);
      }
      localafuv.a.setLinkTextColor(paramanwo.jdField_c_of_type_Int);
      return;
    }
    catch (Throwable paramanwo)
    {
      break label62;
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(jdField_f_of_type_Int, jdField_c_of_type_Int, e, d);
      return;
    }
    paramView.setPadding(e, jdField_c_of_type_Int, jdField_f_of_type_Int, d);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Atrj.a = paramBoolean;
  }
  
  public bdpk[] a(View paramView)
  {
    bdpi localbdpi = new bdpi();
    aepi.a(paramView);
    acjm.a(localbdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    return localbdpi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afuu
 * JD-Core Version:    0.7.0.1
 */