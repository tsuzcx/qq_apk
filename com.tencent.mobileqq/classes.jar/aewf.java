import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;

public class aewf
  implements View.OnClickListener
{
  public aewf(TroopView paramTroopView) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.jdField_a_of_type_Aeuo.a(), SearchContactsActivity.class);
    paramView.putExtra("from_key", 1);
    paramView.putExtra("fromType", 13);
    this.a.jdField_a_of_type_Aeuo.a().startActivity(paramView);
    this.a.jdField_a_of_type_Aeuo.a().overridePendingTransition(0, 0);
    avwf.a("add_page", "search", "active_frame", 2, 0, new String[] { "" });
    awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aewf
 * JD-Core Version:    0.7.0.1
 */