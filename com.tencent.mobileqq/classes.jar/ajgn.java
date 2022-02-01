import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import mqq.app.QQPermissionCallback;

class ajgn
  implements QQPermissionCallback
{
  ajgn(ajgm paramajgm) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "requestLBSPermissionOnClickListener deny");
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onclick requestLBSPermissionOnClickListener grant");
    }
    this.a.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.a.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    if (apch.a("recommend_troop") == null)
    {
      apch.a(new ajgo(this, "recommend_troop"));
      return;
    }
    this.a.a.jdField_a_of_type_Ajgd.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgn
 * JD-Core Version:    0.7.0.1
 */