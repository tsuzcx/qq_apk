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

public class ajkh
  extends ajjr
  implements View.OnClickListener
{
  public ajkh(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
  }
  
  public View a(int paramInt, View paramView)
  {
    ajki localajki;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajki)))
    {
      localajki = new ajki();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561372, null);
      localajki.a = ((TextView)paramView.findViewById(2131371402));
      if (ThemeUtil.isDefaultTheme())
      {
        paramView.setBackgroundResource(2130839455);
        paramView.setTag(localajki);
      }
    }
    for (;;)
    {
      NewFriendMoreInfo localNewFriendMoreInfo = ((ajmg)this.jdField_a_of_type_Ajmf).a;
      localajki.a.setText(localNewFriendMoreInfo.moreInfo);
      paramView.setOnClickListener(this);
      return paramView;
      paramView.setBackgroundResource(2130839399);
      break;
      localajki = (ajki)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof ajki))) {
      switch (((ajmg)this.jdField_a_of_type_Ajmf).a.type)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = this.jdField_a_of_type_Ajln.a();
      NewFriendMoreSysMsgActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, 225, i);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007704", "0X8007704", 0, 0, "", "", "", "");
      continue;
      localObject = (ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
      localIntent.putExtra("entrence_data_report", 4);
      localIntent.putExtra("EntranceId", 6);
      ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 226);
      ((ajka)localObject).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkh
 * JD-Core Version:    0.7.0.1
 */