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

public class aeyo
  extends aeyf
  implements View.OnClickListener
{
  public aeyo(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
  }
  
  public View a(int paramInt, View paramView)
  {
    aeyp localaeyp;
    if ((paramView == null) || (!(paramView.getTag() instanceof aeyp)))
    {
      localaeyp = new aeyp();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495344, null);
      localaeyp.a = ((TextView)paramView.findViewById(2131304758));
      if (ThemeUtil.isDefaultTheme())
      {
        paramView.setBackgroundResource(2130839159);
        paramView.setTag(localaeyp);
      }
    }
    for (;;)
    {
      NewFriendMoreInfo localNewFriendMoreInfo = ((atcv)this.jdField_a_of_type_Atcu).a;
      localaeyp.a.setText(localNewFriendMoreInfo.moreInfo);
      paramView.setOnClickListener(this);
      return paramView;
      paramView.setBackgroundResource(2130839101);
      break;
      localaeyp = (aeyp)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof aeyp))) {}
    switch (((atcv)this.jdField_a_of_type_Atcu).a.type)
    {
    default: 
      return;
    case 1000: 
      int i = this.jdField_a_of_type_Aicw.a();
      NewFriendMoreSysMsgActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, 225, i);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007704", "0X8007704", 0, 0, "", "", "", "");
      return;
    }
    paramView = (ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 4);
    localIntent.putExtra("EntranceId", 6);
    ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 226);
    paramView.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeyo
 * JD-Core Version:    0.7.0.1
 */