import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiwc
  implements View.OnClickListener
{
  public aiwc(TroopView paramTroopView) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.jdField_a_of_type_Aitf.a(), SearchContactsActivity.class);
    localIntent.putExtra("from_key", 1);
    localIntent.putExtra("fromType", 13);
    this.a.jdField_a_of_type_Aitf.a().startActivity(localIntent);
    this.a.jdField_a_of_type_Aitf.a().overridePendingTransition(0, 0);
    bcnc.a("add_page", "search", "active_frame", 2, 0, new String[] { "" });
    bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 2, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwc
 * JD-Core Version:    0.7.0.1
 */