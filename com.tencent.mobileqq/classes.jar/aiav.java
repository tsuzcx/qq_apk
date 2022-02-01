import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiav
  implements View.OnClickListener
{
  public aiav(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onclick requestLBSPermissionOnClickListener");
    }
    bcef.b(null, "dc00899", "Grp_find_new", "", "grptab", "location_set_exp", 0, 0, "", "", "", "");
    this.a.getActivity().requestPermissions(new aiaw(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiav
 * JD-Core Version:    0.7.0.1
 */