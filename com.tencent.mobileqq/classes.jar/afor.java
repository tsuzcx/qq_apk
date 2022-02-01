import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.miniaio.MiniChatLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public abstract class afor
  extends afrj
{
  public Context a;
  protected BaseAdapter a;
  public SessionInfo a;
  public QQAppInterface a;
  
  public afor(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  protected abstract afos a();
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    Object localObject1 = paramViewGroup.getContext();
    afos localafos;
    Object localObject2;
    if (paramView == null)
    {
      paramView = new MiniChatLinearLayout((Context)localObject1);
      ((LinearLayout)paramView).setOrientation(1);
      localafos = a();
      paramView.setTag(localafos);
      localafos.jdField_a_of_type_Int = paramInt1;
      localafos.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      if (!paramChatMessage.mNeedTimeStamp) {
        break label507;
      }
      if (localafos.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        localObject2 = new TextView((Context)localObject1);
        ((TextView)localObject2).setId(2131364553);
        paramInt2 = AIOUtils.dp2px(14.0F, ((Context)localObject1).getResources());
        ((TextView)localObject2).setTextSize(2, 11.0F);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.a != null) {
          ((TextView)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.a);
        }
        ((TextView)localObject2).setPadding(paramInt2, 0, paramInt2, 0);
        ((TextView)localObject2).setGravity(17);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 1;
        localLayoutParams.topMargin = BaseChatItemLayout.G;
        localLayoutParams.bottomMargin = BaseChatItemLayout.G;
        ((ViewGroup)paramView).addView((View)localObject2, 0, localLayoutParams);
        localafos.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
        ((TextView)localObject2).setTag(Long.valueOf(0L));
      }
      localObject2 = (LinearLayout.LayoutParams)localafos.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (!paramChatMessage.isFirstMsg) {
        break label496;
      }
      ((LinearLayout.LayoutParams)localObject2).topMargin = (BaseChatItemLayout.G * 2);
      label247:
      localafos.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (((Long)localafos.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != paramChatMessage.time)
      {
        localObject1 = bhid.a((Context)localObject1, 3, paramChatMessage.time * 1000L);
        localafos.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      afum.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      label312:
      paramaftk = a(paramChatMessage, localafos, localafos.jdField_a_of_type_AndroidViewView, (LinearLayout)paramView, paramaftk);
      if (paramaftk != null) {
        break label528;
      }
      paramaftk = "getItemView return null, builder: " + getClass() + ", position: " + paramInt1 + ", msgtype: " + paramChatMessage.msgtype;
      new IllegalArgumentException(paramaftk);
      QLog.e("ChatItemBuilder", 1, paramaftk);
    }
    label496:
    label507:
    while (localafos.jdField_a_of_type_AndroidViewView == paramaftk)
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
            localafos = (afos)paramView.getTag();
          }
          catch (ClassCastException paramViewGroup)
          {
            paramChatMessage = paramView;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatItemBuilder", 2, "AbstractChatItemBuilder getview  e" + paramViewGroup + "position=" + paramInt1 + "size=" + this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount());
      return paramView;
      ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.G;
      break label247;
      if (localafos.jdField_a_of_type_AndroidWidgetTextView == null) {
        break label312;
      }
      localafos.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label312;
    }
    label528:
    if (localafos.jdField_a_of_type_AndroidViewView != null) {
      ((ViewGroup)paramView).removeView(localafos.jdField_a_of_type_AndroidViewView);
    }
    if (paramaftk.getLayoutParams() == null) {
      ((ViewGroup)paramView).addView(paramaftk, -1, -2);
    }
    for (;;)
    {
      localafos.jdField_a_of_type_AndroidViewView = paramaftk;
      break;
      ((ViewGroup)paramView).addView(paramaftk);
    }
  }
  
  protected abstract View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk);
  
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
  
  protected void a(bhjq parambhjq)
  {
    parambhjq.a(2131362494, this.jdField_a_of_type_AndroidContentContext.getString(2131689979), 2130839001);
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
    ((AIOLongShotHelper)((BaseChatPie)localObject).getHelper(15)).a(paramChatMessage);
    ((BaseChatPie)localObject).hideTroopFCView(true);
    ancb.a(((BaseChatPie)localObject).app, "select_more_msg", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afor
 * JD-Core Version:    0.7.0.1
 */