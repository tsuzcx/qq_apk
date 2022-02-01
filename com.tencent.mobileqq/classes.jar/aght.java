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

public class aght
  extends BaseBubbleBuilder
{
  private static final int jdField_c_of_type_Int = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  avel jdField_a_of_type_Avel = new avel();
  private long jdField_c_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  
  public aght(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131167031);
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
      int k = localResources.getDimensionPixelSize(2131297641);
      m = localResources.getDimensionPixelSize(2131297642);
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
      localList = avhf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
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
  
  public aezf a()
  {
    return new aghu(this);
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    paramBaseChatItemLayout = (aghu)paramaezf;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramaezf = paramView;
    if (paramView == null)
    {
      paramaezf = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramaezf.setId(2131364444);
      paramaezf.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      paramaezf.setTextSize(localResources.getDimensionPixelOffset(2131296459));
      paramaezf.setGravity(16);
      paramBaseChatItemLayout.a = paramaezf;
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
        if (!bjuk.a()) {
          if (paramView.isSend()) {
            i = 2130838121;
          }
        }
        for (;;)
        {
          j = localResources.getColor(2131167012);
          a(paramBaseChatItemLayout.a, i);
          paramBaseChatItemLayout.a.setTextColor(j);
          paramBaseChatItemLayout.a.setText(paramChatMessage.msg);
          paramaezf.setOnTouchListener(paramafce);
          paramaezf.setOnLongClickListener(paramafce);
          this.jdField_a_of_type_Avel = new avel();
          this.jdField_a_of_type_Avel.a(paramView);
          this.jdField_a_of_type_Avel.a = this.jdField_f_of_type_Boolean;
          paramaezf.setOnClickListener(this.jdField_a_of_type_Avel);
          if (AppSetting.c) {
            paramaezf.setContentDescription(paramChatMessage.msg);
          }
          return paramaezf;
          i = 2130838116;
          continue;
          i = 2130838117;
        }
      }
      if (!bjuk.a()) {
        if (paramView.isSend()) {
          i = 2130838120;
        }
      }
      for (;;)
      {
        j = Color.parseColor("#6603081A");
        break;
        i = 2130838119;
        continue;
        i = 2130838118;
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
    if (paramInt == 2131365382)
    {
      acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131371498)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage, apee paramapee)
  {
    aghu localaghu = (aghu)paramaezf;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    localaghu.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
    if ((paramapee.a == 0) || (!paramapee.a()))
    {
      paramaezf = paramView.getResources();
      paramView = (MessageForLocationShare)paramChatMessage;
    }
    try
    {
      a(paramView);
      label62:
      if (paramView.isSharingLocation)
      {
        if (paramChatMessage.isSend()) {}
        for (paramaezf = paramaezf.getColorStateList(2131167035);; paramaezf = paramaezf.getColorStateList(2131167031))
        {
          localaghu.a.setTextColor(paramaezf);
          return;
        }
      }
      if ((paramChatMessage.isSend()) || (bjuk.a())) {}
      for (paramaezf = paramaezf.getColorStateList(2131167036);; paramaezf = paramaezf.getColorStateList(2131167032))
      {
        localaghu.a.setTextColor(paramaezf);
        return;
      }
      if (paramapee.b == 0) {
        localaghu.a.setTextColor(-16777216);
      }
      while (paramapee.jdField_c_of_type_Int == 0)
      {
        localaghu.a.setLinkTextColor(paramView.getResources().getColorStateList(2131167033));
        return;
        localaghu.a.setTextColor(paramapee.b);
      }
      localaghu.a.setLinkTextColor(paramapee.jdField_c_of_type_Int);
      return;
    }
    catch (Throwable paramapee)
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
    this.jdField_a_of_type_Avel.a = paramBoolean;
  }
  
  public bgbb[] a(View paramView)
  {
    bgaz localbgaz = new bgaz();
    AIOUtils.getMessage(paramView);
    acvv.a(localbgaz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.c(localbgaz, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbgaz, this.jdField_a_of_type_AndroidContentContext);
    return localbgaz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aght
 * JD-Core Version:    0.7.0.1
 */