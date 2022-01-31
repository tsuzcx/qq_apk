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

public class afkc
  extends afjt
  implements View.OnClickListener
{
  public afkc(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
  }
  
  public View a(int paramInt, View paramView)
  {
    afkd localafkd;
    if ((paramView == null) || (!(paramView.getTag() instanceof afkd)))
    {
      localafkd = new afkd();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560921, null);
      localafkd.a = ((TextView)paramView.findViewById(2131370414));
      if (ThemeUtil.isDefaultTheme())
      {
        paramView.setBackgroundResource(2130839184);
        paramView.setTag(localafkd);
      }
    }
    for (;;)
    {
      NewFriendMoreInfo localNewFriendMoreInfo = ((atzb)this.jdField_a_of_type_Atza).a;
      localafkd.a.setText(localNewFriendMoreInfo.moreInfo);
      paramView.setOnClickListener(this);
      return paramView;
      paramView.setBackgroundResource(2130839129);
      break;
      localafkd = (afkd)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof afkd))) {}
    switch (((atzb)this.jdField_a_of_type_Atza).a.type)
    {
    default: 
      return;
    case 1000: 
      int i = this.jdField_a_of_type_Aipn.a();
      NewFriendMoreSysMsgActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, 225, i);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007704", "0X8007704", 0, 0, "", "", "", "");
      return;
    }
    paramView = (akbn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 4);
    localIntent.putExtra("EntranceId", 6);
    ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 226);
    paramView.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkc
 * JD-Core Version:    0.7.0.1
 */