import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment;
import com.tencent.qphone.base.util.QLog;

public class afdv
  implements View.OnClickListener
{
  public afdv(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onclick requestLBSPermissionOnClickListener");
    }
    axqw.b(null, "dc00899", "Grp_find_new", "", "grptab", "location_set_exp", 0, 0, "", "", "", "");
    this.a.getActivity().requestPermissions(new afdw(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afdv
 * JD-Core Version:    0.7.0.1
 */