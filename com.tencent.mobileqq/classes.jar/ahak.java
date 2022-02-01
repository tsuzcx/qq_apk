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
import com.tencent.mobileqq.activity.aio.AIOUtils;
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

public class ahak
  extends BaseBubbleBuilder
{
  private static final int jdField_c_of_type_Int = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  awko jdField_a_of_type_Awko = new awko();
  private long jdField_c_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  
  public ahak(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131167045);
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
    for (paramInt = j;; paramInt = (int)((j * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem / paramInt + m) * 1.6D))
    {
      localDrawable.setBounds(0, 0, i, paramInt);
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.r);
      return;
      int k = localResources.getDimensionPixelSize(2131297642);
      m = localResources.getDimensionPixelSize(2131297643);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      i = (int)((i * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem / paramInt + m) * 1.6D);
    }
  }
  
  private void a(MessageForLocationShare paramMessageForLocationShare)
  {
    List localList;
    if (this.jdField_c_of_type_Long == 0L)
    {
      localList = awni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
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
  
  public afqr a()
  {
    return new ahal(this);
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramBaseChatItemLayout = (ahal)paramafqr;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramafqr = paramView;
    if (paramView == null)
    {
      paramafqr = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramafqr.setId(2131364525);
      paramafqr.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      paramafqr.setTextSize(localResources.getDimensionPixelOffset(2131296459));
      paramafqr.setGravity(16);
      paramBaseChatItemLayout.a = paramafqr;
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
        if (!blfw.a()) {
          if (paramView.isSend()) {
            i = 2130838135;
          }
        }
        for (;;)
        {
          j = localResources.getColor(2131167026);
          a(paramBaseChatItemLayout.a, i);
          paramBaseChatItemLayout.a.setTextColor(j);
          paramBaseChatItemLayout.a.setText(paramChatMessage.msg);
          paramafqr.setOnTouchListener(paramaftk);
          paramafqr.setOnLongClickListener(paramaftk);
          this.jdField_a_of_type_Awko = new awko();
          this.jdField_a_of_type_Awko.a(paramView);
          this.jdField_a_of_type_Awko.a = this.jdField_f_of_type_Boolean;
          paramafqr.setOnClickListener(this.jdField_a_of_type_Awko);
          if (AppSetting.c) {
            paramafqr.setContentDescription(paramChatMessage.msg);
          }
          return paramafqr;
          i = 2130838130;
          continue;
          i = 2130838131;
        }
      }
      if (!blfw.a()) {
        if (paramView.isSend()) {
          i = 2130838134;
        }
      }
      for (;;)
      {
        j = Color.parseColor("#6603081A");
        break;
        i = 2130838133;
        continue;
        i = 2130838132;
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
    if (paramInt == 2131365475)
    {
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131371684)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(afqr paramafqr, View paramView, ChatMessage paramChatMessage, aqhi paramaqhi)
  {
    ahal localahal = (ahal)paramafqr;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    localahal.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
    if ((paramaqhi.a == 0) || (!paramaqhi.a()))
    {
      paramafqr = paramView.getResources();
      paramView = (MessageForLocationShare)paramChatMessage;
    }
    try
    {
      a(paramView);
      label62:
      if (paramView.isSharingLocation)
      {
        if (paramChatMessage.isSend()) {}
        for (paramafqr = paramafqr.getColorStateList(2131167049);; paramafqr = paramafqr.getColorStateList(2131167045))
        {
          localahal.a.setTextColor(paramafqr);
          return;
        }
      }
      if ((paramChatMessage.isSend()) || (blfw.a())) {}
      for (paramafqr = paramafqr.getColorStateList(2131167050);; paramafqr = paramafqr.getColorStateList(2131167046))
      {
        localahal.a.setTextColor(paramafqr);
        return;
      }
      if (paramaqhi.b == 0) {
        localahal.a.setTextColor(-16777216);
      }
      while (paramaqhi.jdField_c_of_type_Int == 0)
      {
        localahal.a.setLinkTextColor(paramView.getResources().getColorStateList(2131167047));
        return;
        localahal.a.setTextColor(paramaqhi.b);
      }
      localahal.a.setLinkTextColor(paramaqhi.jdField_c_of_type_Int);
      return;
    }
    catch (Throwable paramaqhi)
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
    this.jdField_a_of_type_Awko.a = paramBoolean;
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    AIOUtils.getMessage(paramView);
    admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahak
 * JD-Core Version:    0.7.0.1
 */