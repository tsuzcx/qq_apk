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

public class adtu
  extends BaseBubbleBuilder
{
  private static final int jdField_c_of_type_Int = BaseChatItemLayout.g + BaseChatItemLayout.l;
  private static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  arwc jdField_a_of_type_Arwc = new arwc();
  private long jdField_c_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  
  public adtu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
      localList = aryw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
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
  
  public acun a()
  {
    return new adtv(this);
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    paramBaseChatItemLayout = (adtv)paramacun;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramacun = paramView;
    if (paramView == null)
    {
      paramacun = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramacun.setId(2131364113);
      paramacun.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      paramacun.setTextSize(localResources.getDimensionPixelOffset(2131296362));
      paramacun.setGravity(16);
      paramBaseChatItemLayout.a = paramacun;
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
        if (!bfwa.a()) {
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
          paramacun.setOnTouchListener(paramacxn);
          paramacun.setOnLongClickListener(paramacxn);
          this.jdField_a_of_type_Arwc = new arwc();
          this.jdField_a_of_type_Arwc.a(paramView);
          this.jdField_a_of_type_Arwc.a = this.jdField_f_of_type_Boolean;
          paramacun.setOnClickListener(this.jdField_a_of_type_Arwc);
          if (AppSetting.d) {
            paramacun.setContentDescription(paramChatMessage.msg);
          }
          return paramacun;
          i = 2130837930;
          continue;
          i = 2130837931;
        }
      }
      if (!bfwa.a()) {
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
    if (paramInt == 2131364985)
    {
      aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131370537)
    {
      super.d(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(acun paramacun, View paramView, ChatMessage paramChatMessage, ambh paramambh)
  {
    adtv localadtv = (adtv)paramacun;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    localadtv.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    if ((paramambh.a == 0) || (!paramambh.a()))
    {
      paramacun = paramView.getResources();
      paramView = (MessageForLocationShare)paramChatMessage;
    }
    try
    {
      a(paramView);
      label62:
      if (paramView.isSharingLocation)
      {
        if (paramChatMessage.isSend()) {}
        for (paramacun = paramacun.getColorStateList(2131166876);; paramacun = paramacun.getColorStateList(2131166872))
        {
          localadtv.a.setTextColor(paramacun);
          return;
        }
      }
      if ((paramChatMessage.isSend()) || (bfwa.a())) {}
      for (paramacun = paramacun.getColorStateList(2131166877);; paramacun = paramacun.getColorStateList(2131166873))
      {
        localadtv.a.setTextColor(paramacun);
        return;
      }
      if (paramambh.b == 0) {
        localadtv.a.setTextColor(-16777216);
      }
      while (paramambh.jdField_c_of_type_Int == 0)
      {
        localadtv.a.setLinkTextColor(paramView.getResources().getColorStateList(2131166874));
        return;
        localadtv.a.setTextColor(paramambh.b);
      }
      localadtv.a.setLinkTextColor(paramambh.jdField_c_of_type_Int);
      return;
    }
    catch (Throwable paramambh)
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
    this.jdField_a_of_type_Arwc.a = paramBoolean;
  }
  
  public bblt[] a(View paramView)
  {
    bblr localbblr = new bblr();
    actn.a(paramView);
    aaod.a(localbblr, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(localbblr, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
    return localbblr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adtu
 * JD-Core Version:    0.7.0.1
 */