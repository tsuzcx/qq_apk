import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NewFriendMoreInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aizp
  extends aiyz
  implements View.OnClickListener
{
  public aizp(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
  }
  
  public View a(int paramInt, View paramView)
  {
    aizq localaizq;
    if ((paramView == null) || (!(paramView.getTag() instanceof aizq)))
    {
      localaizq = new aizq();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561308, null);
      localaizq.a = ((TextView)paramView.findViewById(2131371555));
      if (ThemeUtil.isDefaultTheme())
      {
        paramView.setBackgroundResource(2130839511);
        paramView.setTag(localaizq);
      }
    }
    for (;;)
    {
      NewFriendMoreInfo localNewFriendMoreInfo = ((ajbo)this.jdField_a_of_type_Ajbn).a;
      localaizq.a.setText(localNewFriendMoreInfo.moreInfo);
      paramView.setOnClickListener(this);
      return paramView;
      paramView.setBackgroundResource(2130839455);
      break;
      localaizq = (aizq)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof aizq))) {
      switch (((ajbo)this.jdField_a_of_type_Ajbn).a.type)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = this.jdField_a_of_type_Ajav.a();
      NewFriendMoreSysMsgActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, 225, i);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007704", "0X8007704", 0, 0, "", "", "", "");
      continue;
      localObject = (aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
      localIntent.putExtra("entrence_data_report", 4);
      localIntent.putExtra("EntranceId", 6);
      ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 226);
      ((aizi)localObject).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizp
 * JD-Core Version:    0.7.0.1
 */