import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;

public class ahit
  implements View.OnClickListener
{
  public ahit(TroopView paramTroopView) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.jdField_a_of_type_Ahhc.a(), SearchContactsActivity.class);
    paramView.putExtra("from_key", 1);
    paramView.putExtra("fromType", 13);
    this.a.jdField_a_of_type_Ahhc.a().startActivity(paramView);
    this.a.jdField_a_of_type_Ahhc.a().overridePendingTransition(0, 0);
    ayvm.a("add_page", "search", "active_frame", 2, 0, new String[] { "" });
    azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahit
 * JD-Core Version:    0.7.0.1
 */