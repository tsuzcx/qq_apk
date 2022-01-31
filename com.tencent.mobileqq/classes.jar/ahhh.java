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
import com.tencent.mobileqq.data.NewFriendMoreInfo;
import com.tencent.mobileqq.theme.ThemeUtil;

public class ahhh
  extends ahgy
  implements View.OnClickListener
{
  public ahhh(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
  }
  
  public View a(int paramInt, View paramView)
  {
    ahhi localahhi;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahhi)))
    {
      localahhi = new ahhi();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561104, null);
      localahhi.a = ((TextView)paramView.findViewById(2131370720));
      if (ThemeUtil.isDefaultTheme())
      {
        paramView.setBackgroundResource(2130839268);
        paramView.setTag(localahhi);
      }
    }
    for (;;)
    {
      NewFriendMoreInfo localNewFriendMoreInfo = ((avqf)this.jdField_a_of_type_Avqe).a;
      localahhi.a.setText(localNewFriendMoreInfo.moreInfo);
      paramView.setOnClickListener(this);
      return paramView;
      paramView.setBackgroundResource(2130839213);
      break;
      localahhi = (ahhi)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof ahhi))) {}
    switch (((avqf)this.jdField_a_of_type_Avqe).a.type)
    {
    default: 
      return;
    case 1000: 
      int i = this.jdField_a_of_type_Akgy.a();
      NewFriendMoreSysMsgActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, 225, i);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007704", "0X8007704", 0, 0, "", "", "", "");
      return;
    }
    paramView = (altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 4);
    localIntent.putExtra("EntranceId", 6);
    ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 226);
    paramView.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhh
 * JD-Core Version:    0.7.0.1
 */