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

public class afqf
  extends BaseBubbleBuilder
{
  private static final int jdField_c_of_type_Int = BaseChatItemLayout.g + BaseChatItemLayout.l;
  private static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  atna jdField_a_of_type_Atna = new atna();
  private long jdField_c_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  
  public afqf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131166919);
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
      localList = atpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
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
  
  public aelt a()
  {
    return new afqg(this);
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    paramBaseChatItemLayout = (afqg)paramaelt;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramaelt = paramView;
    if (paramView == null)
    {
      paramaelt = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramaelt.setId(2131364174);
      paramaelt.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      paramaelt.setTextSize(localResources.getDimensionPixelOffset(2131296368));
      paramaelt.setGravity(16);
      paramBaseChatItemLayout.a = paramaelt;
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
        if (!bhxo.a()) {
          if (paramView.isSend()) {
            i = 2130837991;
          }
        }
        for (;;)
        {
          j = localResources.getColor(2131166901);
          a(paramBaseChatItemLayout.a, i);
          paramBaseChatItemLayout.a.setTextColor(j);
          paramBaseChatItemLayout.a.setText(paramChatMessage.msg);
          paramaelt.setOnTouchListener(paramaeov);
          paramaelt.setOnLongClickListener(paramaeov);
          this.jdField_a_of_type_Atna = new atna();
          this.jdField_a_of_type_Atna.a(paramView);
          this.jdField_a_of_type_Atna.a = this.jdField_f_of_type_Boolean;
          paramaelt.setOnClickListener(this.jdField_a_of_type_Atna);
          if (AppSetting.c) {
            paramaelt.setContentDescription(paramChatMessage.msg);
          }
          return paramaelt;
          i = 2130837986;
          continue;
          i = 2130837987;
        }
      }
      if (!bhxo.a()) {
        if (paramView.isSend()) {
          i = 2130837990;
        }
      }
      for (;;)
      {
        j = Color.parseColor("#6603081A");
        break;
        i = 2130837989;
        continue;
        i = 2130837988;
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
    if (paramInt == 2131365069)
    {
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131370842)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(aelt paramaelt, View paramView, ChatMessage paramChatMessage, ansf paramansf)
  {
    afqg localafqg = (afqg)paramaelt;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    localafqg.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    if ((paramansf.a == 0) || (!paramansf.a()))
    {
      paramaelt = paramView.getResources();
      paramView = (MessageForLocationShare)paramChatMessage;
    }
    try
    {
      a(paramView);
      label62:
      if (paramView.isSharingLocation)
      {
        if (paramChatMessage.isSend()) {}
        for (paramaelt = paramaelt.getColorStateList(2131166923);; paramaelt = paramaelt.getColorStateList(2131166919))
        {
          localafqg.a.setTextColor(paramaelt);
          return;
        }
      }
      if ((paramChatMessage.isSend()) || (bhxo.a())) {}
      for (paramaelt = paramaelt.getColorStateList(2131166924);; paramaelt = paramaelt.getColorStateList(2131166920))
      {
        localafqg.a.setTextColor(paramaelt);
        return;
      }
      if (paramansf.b == 0) {
        localafqg.a.setTextColor(-16777216);
      }
      while (paramansf.jdField_c_of_type_Int == 0)
      {
        localafqg.a.setLinkTextColor(paramView.getResources().getColorStateList(2131166921));
        return;
        localafqg.a.setTextColor(paramansf.b);
      }
      localafqg.a.setLinkTextColor(paramansf.jdField_c_of_type_Int);
      return;
    }
    catch (Throwable paramansf)
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
    this.jdField_a_of_type_Atna.a = paramBoolean;
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    aekt.a(paramView);
    acex.a(localbdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqf
 * JD-Core Version:    0.7.0.1
 */