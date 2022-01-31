import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import mqq.app.QQPermissionCallback;

class aeta
  implements QQPermissionCallback
{
  aeta(aesz paramaesz) {}
  
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
    if (akfu.a("recommend_troop") == null)
    {
      akfu.a(new aetb(this, "recommend_troop"));
      return;
    }
    this.a.a.jdField_a_of_type_Aesq.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeta
 * JD-Core Version:    0.7.0.1
 */