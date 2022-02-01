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

public class ahlh
  extends BaseBubbleBuilder
{
  private static final int jdField_c_of_type_Int = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  awrf jdField_a_of_type_Awrf = new awrf();
  private long jdField_c_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  
  public ahlh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131167009);
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
      paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.r);
      return;
      int k = localResources.getDimensionPixelSize(2131297586);
      m = localResources.getDimensionPixelSize(2131297587);
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
      localList = awtz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
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
  
  public aggl a()
  {
    return new ahli(this);
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramBaseChatItemLayout = (ahli)paramaggl;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramaggl = paramView;
    if (paramView == null)
    {
      paramaggl = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramaggl.setId(2131364426);
      paramaggl.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      paramaggl.setTextSize(localResources.getDimensionPixelOffset(2131296406));
      paramaggl.setGravity(16);
      paramBaseChatItemLayout.a = paramaggl;
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
        if (!blqj.a()) {
          if (paramView.isSend()) {
            i = 2130838096;
          }
        }
        for (;;)
        {
          j = localResources.getColor(2131166990);
          a(paramBaseChatItemLayout.a, i);
          paramBaseChatItemLayout.a.setTextColor(j);
          paramBaseChatItemLayout.a.setText(paramChatMessage.msg);
          paramaggl.setOnTouchListener(paramagjk);
          paramaggl.setOnLongClickListener(paramagjk);
          this.jdField_a_of_type_Awrf = new awrf();
          this.jdField_a_of_type_Awrf.a(paramView);
          this.jdField_a_of_type_Awrf.a = this.jdField_f_of_type_Boolean;
          paramaggl.setOnClickListener(this.jdField_a_of_type_Awrf);
          if (AppSetting.c) {
            paramaggl.setContentDescription(paramChatMessage.msg);
          }
          return paramaggl;
          i = 2130838091;
          continue;
          i = 2130838092;
        }
      }
      if (!blqj.a()) {
        if (paramView.isSend()) {
          i = 2130838095;
        }
      }
      for (;;)
      {
        j = Color.parseColor("#6603081A");
        break;
        i = 2130838094;
        continue;
        i = 2130838093;
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
    if (paramInt == 2131365352)
    {
      aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131371530)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(aggl paramaggl, View paramView, ChatMessage paramChatMessage, aqkt paramaqkt)
  {
    ahli localahli = (ahli)paramaggl;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    localahli.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    if ((paramaqkt.a == 0) || (!paramaqkt.a()))
    {
      paramaggl = paramView.getResources();
      paramView = (MessageForLocationShare)paramChatMessage;
    }
    try
    {
      a(paramView);
      label62:
      if (paramView.isSharingLocation)
      {
        if (paramChatMessage.isSend()) {}
        for (paramaggl = paramaggl.getColorStateList(2131167013);; paramaggl = paramaggl.getColorStateList(2131167009))
        {
          localahli.a.setTextColor(paramaggl);
          return;
        }
      }
      if ((paramChatMessage.isSend()) || (blqj.a())) {}
      for (paramaggl = paramaggl.getColorStateList(2131167014);; paramaggl = paramaggl.getColorStateList(2131167010))
      {
        localahli.a.setTextColor(paramaggl);
        return;
      }
      if (paramaqkt.b == 0) {
        localahli.a.setTextColor(-16777216);
      }
      while (paramaqkt.jdField_c_of_type_Int == 0)
      {
        localahli.a.setLinkTextColor(paramView.getResources().getColorStateList(2131167011));
        return;
        localahli.a.setTextColor(paramaqkt.b);
      }
      localahli.a.setLinkTextColor(paramaqkt.jdField_c_of_type_Int);
      return;
    }
    catch (Throwable paramaqkt)
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
    this.jdField_a_of_type_Awrf.a = paramBoolean;
  }
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    agej.a(paramView);
    aean.a(localbhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    return localbhuk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlh
 * JD-Core Version:    0.7.0.1
 */