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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiyy
  extends aiyi
  implements View.OnClickListener
{
  public aiyy(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
  }
  
  public View a(int paramInt, View paramView)
  {
    aiyz localaiyz;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiyz)))
    {
      localaiyz = new aiyz();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561333, null);
      localaiyz.a = ((TextView)paramView.findViewById(2131371295));
      if (ThemeUtil.isDefaultTheme())
      {
        paramView.setBackgroundResource(2130839447);
        paramView.setTag(localaiyz);
      }
    }
    for (;;)
    {
      NewFriendMoreInfo localNewFriendMoreInfo = ((ajay)this.jdField_a_of_type_Ajax).a;
      localaiyz.a.setText(localNewFriendMoreInfo.moreInfo);
      paramView.setOnClickListener(this);
      return paramView;
      paramView.setBackgroundResource(2130839391);
      break;
      localaiyz = (aiyz)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof aiyz))) {
      switch (((ajay)this.jdField_a_of_type_Ajax).a.type)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = this.jdField_a_of_type_Ajae.a();
      NewFriendMoreSysMsgActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, 225, i);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007704", "0X8007704", 0, 0, "", "", "", "");
      continue;
      localObject = (aiyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
      localIntent.putExtra("entrence_data_report", 4);
      localIntent.putExtra("EntranceId", 6);
      ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 226);
      ((aiyr)localObject).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyy
 * JD-Core Version:    0.7.0.1
 */