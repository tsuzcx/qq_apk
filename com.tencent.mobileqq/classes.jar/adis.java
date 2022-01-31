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

public class adis
  extends BaseBubbleBuilder
{
  private static final int jdField_c_of_type_Int = BaseChatItemLayout.g + BaseChatItemLayout.l;
  private static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  arao jdField_a_of_type_Arao = new arao();
  private long jdField_c_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  
  public adis(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131101278);
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
      int k = localResources.getDimensionPixelSize(2131166387);
      m = localResources.getDimensionPixelSize(2131166388);
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
      localList = arde.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
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
  
  public acju a()
  {
    return new adit(this);
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    paramBaseChatItemLayout = (adit)paramacju;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramacju = paramView;
    if (paramView == null)
    {
      paramacju = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramacju.setId(2131298555);
      paramacju.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      paramacju.setTextSize(localResources.getDimensionPixelOffset(2131165290));
      paramacju.setGravity(16);
      paramBaseChatItemLayout.a = paramacju;
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
        if (!beog.a()) {
          if (paramView.isSend()) {
            i = 2130837926;
          }
        }
        for (;;)
        {
          j = localResources.getColor(2131101260);
          a(paramBaseChatItemLayout.a, i);
          paramBaseChatItemLayout.a.setTextColor(j);
          paramBaseChatItemLayout.a.setText(paramChatMessage.msg);
          paramacju.setOnTouchListener(paramacmv);
          paramacju.setOnLongClickListener(paramacmv);
          this.jdField_a_of_type_Arao = new arao();
          this.jdField_a_of_type_Arao.a(paramView);
          this.jdField_a_of_type_Arao.a = this.jdField_f_of_type_Boolean;
          paramacju.setOnClickListener(this.jdField_a_of_type_Arao);
          if (AppSetting.c) {
            paramacju.setContentDescription(paramChatMessage.msg);
          }
          return paramacju;
          i = 2130837921;
          continue;
          i = 2130837922;
        }
      }
      if (!beog.a()) {
        if (paramView.isSend()) {
          i = 2130837925;
        }
      }
      for (;;)
      {
        j = Color.parseColor("#6603081A");
        break;
        i = 2130837924;
        continue;
        i = 2130837923;
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
    if (paramInt == 2131299417)
    {
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131304871)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(acju paramacju, View paramView, ChatMessage paramChatMessage, almt paramalmt)
  {
    adit localadit = (adit)paramacju;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    localadit.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    if ((paramalmt.a == 0) || (!paramalmt.a()))
    {
      paramacju = paramView.getResources();
      paramView = (MessageForLocationShare)paramChatMessage;
    }
    try
    {
      a(paramView);
      label62:
      if (paramView.isSharingLocation)
      {
        if (paramChatMessage.isSend()) {}
        for (paramacju = paramacju.getColorStateList(2131101282);; paramacju = paramacju.getColorStateList(2131101278))
        {
          localadit.a.setTextColor(paramacju);
          return;
        }
      }
      if ((paramChatMessage.isSend()) || (beog.a())) {}
      for (paramacju = paramacju.getColorStateList(2131101283);; paramacju = paramacju.getColorStateList(2131101279))
      {
        localadit.a.setTextColor(paramacju);
        return;
      }
      if (paramalmt.b == 0) {
        localadit.a.setTextColor(-16777216);
      }
      while (paramalmt.jdField_c_of_type_Int == 0)
      {
        localadit.a.setLinkTextColor(paramView.getResources().getColorStateList(2131101280));
        return;
        localadit.a.setTextColor(paramalmt.b);
      }
      localadit.a.setLinkTextColor(paramalmt.jdField_c_of_type_Int);
      return;
    }
    catch (Throwable paramalmt)
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
    this.jdField_a_of_type_Arao.a = paramBoolean;
  }
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    aciy.a(paramView);
    aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
    super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
    return localbakh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adis
 * JD-Core Version:    0.7.0.1
 */