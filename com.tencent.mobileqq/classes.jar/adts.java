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

public class adts
  extends BaseBubbleBuilder
{
  private static final int jdField_c_of_type_Int = BaseChatItemLayout.g + BaseChatItemLayout.l;
  private static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  arwe jdField_a_of_type_Arwe = new arwe();
  private long jdField_c_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  
  public adts(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131166872);
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
      int k = localResources.getDimensionPixelSize(2131297476);
      m = localResources.getDimensionPixelSize(2131297477);
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
      localList = aryy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
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
  
  public acuj a()
  {
    return new adtt(this);
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    paramBaseChatItemLayout = (adtt)paramacuj;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramacuj = paramView;
    if (paramView == null)
    {
      paramacuj = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramacuj.setId(2131364112);
      paramacuj.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      paramacuj.setTextSize(localResources.getDimensionPixelOffset(2131296362));
      paramacuj.setGravity(16);
      paramBaseChatItemLayout.a = paramacuj;
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
        if (!bfwr.a()) {
          if (paramView.isSend()) {
            i = 2130837935;
          }
        }
        for (;;)
        {
          j = localResources.getColor(2131166854);
          a(paramBaseChatItemLayout.a, i);
          paramBaseChatItemLayout.a.setTextColor(j);
          paramBaseChatItemLayout.a.setText(paramChatMessage.msg);
          paramacuj.setOnTouchListener(paramacxj);
          paramacuj.setOnLongClickListener(paramacxj);
          this.jdField_a_of_type_Arwe = new arwe();
          this.jdField_a_of_type_Arwe.a(paramView);
          this.jdField_a_of_type_Arwe.a = this.jdField_f_of_type_Boolean;
          paramacuj.setOnClickListener(this.jdField_a_of_type_Arwe);
          if (AppSetting.d) {
            paramacuj.setContentDescription(paramChatMessage.msg);
          }
          return paramacuj;
          i = 2130837930;
          continue;
          i = 2130837931;
        }
      }
      if (!bfwr.a()) {
        if (paramView.isSend()) {
          i = 2130837934;
        }
      }
      for (;;)
      {
        j = Color.parseColor("#6603081A");
        break;
        i = 2130837933;
        continue;
        i = 2130837932;
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
    if (paramInt == 2131364984)
    {
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131370536)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(acuj paramacuj, View paramView, ChatMessage paramChatMessage, ambg paramambg)
  {
    adtt localadtt = (adtt)paramacuj;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    localadtt.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    if ((paramambg.a == 0) || (!paramambg.a()))
    {
      paramacuj = paramView.getResources();
      paramView = (MessageForLocationShare)paramChatMessage;
    }
    try
    {
      a(paramView);
      label62:
      if (paramView.isSharingLocation)
      {
        if (paramChatMessage.isSend()) {}
        for (paramacuj = paramacuj.getColorStateList(2131166876);; paramacuj = paramacuj.getColorStateList(2131166872))
        {
          localadtt.a.setTextColor(paramacuj);
          return;
        }
      }
      if ((paramChatMessage.isSend()) || (bfwr.a())) {}
      for (paramacuj = paramacuj.getColorStateList(2131166877);; paramacuj = paramacuj.getColorStateList(2131166873))
      {
        localadtt.a.setTextColor(paramacuj);
        return;
      }
      if (paramambg.b == 0) {
        localadtt.a.setTextColor(-16777216);
      }
      while (paramambg.jdField_c_of_type_Int == 0)
      {
        localadtt.a.setLinkTextColor(paramView.getResources().getColorStateList(2131166874));
        return;
        localadtt.a.setTextColor(paramambg.b);
      }
      localadtt.a.setLinkTextColor(paramambg.jdField_c_of_type_Int);
      return;
    }
    catch (Throwable paramambg)
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
    this.jdField_a_of_type_Arwe.a = paramBoolean;
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    actj.a(paramView);
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adts
 * JD-Core Version:    0.7.0.1
 */