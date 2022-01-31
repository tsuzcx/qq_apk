import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ajxl
  implements ActionSheet.OnButtonClickListener
{
  public ajxl(TroopShareUtility paramTroopShareUtility) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.jdField_b_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "OnClick.chooseLinkType: " + paramInt);
    }
    this.a.jdField_b_of_type_Boolean = true;
    switch (paramInt)
    {
    default: 
      this.a.a(false);
      this.a.jdField_a_of_type_Int = -1;
      this.a.jdField_b_of_type_Int = -1;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
      break;
    }
    for (;;)
    {
      this.a.jdField_b_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.a.a(true);
      this.a.jdField_b_of_type_Int = 1;
      TroopShareUtility.a(this.a);
      continue;
      this.a.a(true);
      this.a.jdField_b_of_type_Int = 0;
      TroopShareUtility.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxl
 * JD-Core Version:    0.7.0.1
 */