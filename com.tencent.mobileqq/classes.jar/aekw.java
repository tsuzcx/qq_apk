import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.miniaio.MiniChatLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public abstract class aekw
  extends aemj
{
  public Context a;
  protected BaseAdapter a;
  public SessionInfo a;
  public QQAppInterface a;
  
  public aekw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  protected abstract aekx a();
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    Object localObject1 = paramViewGroup.getContext();
    aekx localaekx;
    Object localObject2;
    if (paramView == null)
    {
      paramView = new MiniChatLinearLayout((Context)localObject1);
      ((LinearLayout)paramView).setOrientation(1);
      localaekx = a();
      paramView.setTag(localaekx);
      localaekx.jdField_a_of_type_Int = paramInt1;
      localaekx.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      if (!paramChatMessage.mNeedTimeStamp) {
        break label507;
      }
      if (localaekx.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        localObject2 = new TextView((Context)localObject1);
        ((TextView)localObject2).setId(2131364202);
        paramInt2 = aekt.a(14.0F, ((Context)localObject1).getResources());
        ((TextView)localObject2).setTextSize(2, 11.0F);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a != null) {
          ((TextView)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a);
        }
        ((TextView)localObject2).setPadding(paramInt2, 0, paramInt2, 0);
        ((TextView)localObject2).setGravity(17);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 1;
        localLayoutParams.topMargin = BaseChatItemLayout.F;
        localLayoutParams.bottomMargin = BaseChatItemLayout.F;
        ((ViewGroup)paramView).addView((View)localObject2, 0, localLayoutParams);
        localaekx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
        ((TextView)localObject2).setTag(Long.valueOf(0L));
      }
      localObject2 = (LinearLayout.LayoutParams)localaekx.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (!paramChatMessage.isFirstMsg) {
        break label496;
      }
      ((LinearLayout.LayoutParams)localObject2).topMargin = (BaseChatItemLayout.F * 2);
      label247:
      localaekx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (((Long)localaekx.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != paramChatMessage.time)
      {
        localObject1 = bdjj.a((Context)localObject1, 3, paramChatMessage.time * 1000L);
        localaekx.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      aepv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      label312:
      paramaeov = a(paramChatMessage, localaekx, localaekx.jdField_a_of_type_AndroidViewView, (LinearLayout)paramView, paramaeov);
      if (paramaeov != null) {
        break label528;
      }
      paramaeov = "getItemView return null, builder: " + getClass() + ", position: " + paramInt1 + ", msgtype: " + paramChatMessage.msgtype;
      new IllegalArgumentException(paramaeov);
      QLog.e("ChatItemBuilder", 1, paramaeov);
    }
    label496:
    label507:
    while (localaekx.jdField_a_of_type_AndroidViewView == paramaeov)
    {
      a(paramInt1, paramChatMessage, (MiniChatLinearLayout)paramView, paramViewGroup);
      paramChatMessage = paramView;
      do
      {
        for (;;)
        {
          return paramChatMessage;
          try
          {
            localaekx = (aekx)paramView.getTag();
          }
          catch (ClassCastException paramViewGroup)
          {
            paramChatMessage = paramView;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatItemBuilder", 2, "AbstractChatItemBuilder getview  e" + paramViewGroup + "position=" + paramInt1 + "size=" + this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount());
      return paramView;
      ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.F;
      break label247;
      if (localaekx.jdField_a_of_type_AndroidWidgetTextView == null) {
        break label312;
      }
      localaekx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label312;
    }
    label528:
    if (localaekx.jdField_a_of_type_AndroidViewView != null) {
      ((ViewGroup)paramView).removeView(localaekx.jdField_a_of_type_AndroidViewView);
    }
    if (paramaeov.getLayoutParams() == null) {
      ((ViewGroup)paramView).addView(paramaeov, -1, -2);
    }
    for (;;)
    {
      localaekx.jdField_a_of_type_AndroidViewView = paramaeov;
      break;
      ((ViewGroup)paramView).addView(paramaeov);
    }
  }
  
  protected abstract View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov);
  
  public void a() {}
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage, MiniChatLinearLayout paramMiniChatLinearLayout, ViewGroup paramViewGroup)
  {
    int j = 0;
    AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
    int i = j;
    if (localAIOLongShotHelper != null)
    {
      i = j;
      if (localAIOLongShotHelper.a()) {
        i = 1;
      }
    }
    if (i != 0) {
      paramMiniChatLinearLayout.setCheckBox(paramInt, paramChatMessage, paramMiniChatLinearLayout, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramViewGroup);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(bdkz parambdkz)
  {
    parambdkz.a(2131362377, this.jdField_a_of_type_AndroidContentContext.getString(2131690046), 2130838685);
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
    if ((localFragmentActivity == null) || (localFragmentActivity.getChatFragment() == null))
    {
      localObject = new StringBuilder().append("onClickScreenShot Error:");
      if (localFragmentActivity != null) {}
      for (paramChatMessage = localFragmentActivity.toString();; paramChatMessage = "ca is null ")
      {
        QLog.e("AbstractChatItemBuilder", 1, paramChatMessage);
        return;
      }
    }
    Object localObject = localFragmentActivity.getChatFragment().a();
    ((AIOLongShotHelper)((BaseChatPie)localObject).a(15)).a(paramChatMessage);
    ((BaseChatPie)localObject).j(true);
    akwk.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekw
 * JD-Core Version:    0.7.0.1
 */