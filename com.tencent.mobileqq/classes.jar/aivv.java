import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import mqq.app.QQPermissionCallback;

class aivv
  implements QQPermissionCallback
{
  aivv(aivu paramaivu) {}
  
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
    if (LbsManagerService.getCachedLbsInfo("recommend_troop") == null)
    {
      LbsManagerService.startLocation(new aivw(this, "recommend_troop"));
      return;
    }
    this.a.a.jdField_a_of_type_Aivl.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivv
 * JD-Core Version:    0.7.0.1
 */