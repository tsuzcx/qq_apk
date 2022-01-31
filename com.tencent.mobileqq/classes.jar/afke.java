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

public class afke
  extends afjv
  implements View.OnClickListener
{
  public afke(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
  }
  
  public View a(int paramInt, View paramView)
  {
    afkf localafkf;
    if ((paramView == null) || (!(paramView.getTag() instanceof afkf)))
    {
      localafkf = new afkf();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560922, null);
      localafkf.a = ((TextView)paramView.findViewById(2131370415));
      if (ThemeUtil.isDefaultTheme())
      {
        paramView.setBackgroundResource(2130839184);
        paramView.setTag(localafkf);
      }
    }
    for (;;)
    {
      NewFriendMoreInfo localNewFriendMoreInfo = ((atyz)this.jdField_a_of_type_Atyy).a;
      localafkf.a.setText(localNewFriendMoreInfo.moreInfo);
      paramView.setOnClickListener(this);
      return paramView;
      paramView.setBackgroundResource(2130839129);
      break;
      localafkf = (afkf)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof afkf))) {}
    switch (((atyz)this.jdField_a_of_type_Atyy).a.type)
    {
    default: 
      return;
    case 1000: 
      int i = this.jdField_a_of_type_Aipp.a();
      NewFriendMoreSysMsgActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, 225, i);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007704", "0X8007704", 0, 0, "", "", "", "");
      return;
    }
    paramView = (akbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 4);
    localIntent.putExtra("EntranceId", 6);
    ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 226);
    paramView.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afke
 * JD-Core Version:    0.7.0.1
 */