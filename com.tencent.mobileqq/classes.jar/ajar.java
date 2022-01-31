import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.logic.TroopAvatarWallEditCtrl;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

class ajar
  implements AdapterView.OnItemSelectedListener
{
  ajar(ajap paramajap) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    this.a.a.a.jdField_a_of_type_Int = paramInt;
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl.a(paramInt);
    if (this.a.a.a.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.a.a.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.a.a.jdField_a_of_type_JavaLangString, "0", "", "");
      return;
    }
    ReportController.b(this.a.a.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.a.a.jdField_a_of_type_JavaLangString, "1", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajar
 * JD-Core Version:    0.7.0.1
 */