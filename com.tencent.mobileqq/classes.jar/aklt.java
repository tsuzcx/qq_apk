import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;

class aklt
  implements View.OnClickListener
{
  aklt(aklr paramaklr) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).d();
    }
    paramView = paramView.getTag();
    if (!(paramView instanceof TroopInfo)) {
      return;
    }
    localObject = (TroopInfo)paramView;
    boolean bool = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(((TroopInfo)localObject).troopuin);
    paramView = (aloz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
    int i;
    label100:
    label120:
    azqx localazqx;
    label190:
    String str;
    if (bool)
    {
      i = 1;
      if (!paramView.a(((TroopInfo)localObject).troopcode, i)) {
        break label241;
      }
      if (!bool) {
        break label243;
      }
      paramView = "Clk_uncommgrp";
      azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_contactlist", paramView, 0, 0, ((TroopInfo)localObject).troopuin, "", "", "");
      localazqx = new azqx(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_set").c("Grp_contactlist");
      if (!bool) {
        break label249;
      }
      paramView = "Clk_unstick";
      localazqx = localazqx.d(paramView);
      str = ((TroopInfo)localObject).troopuin;
      if (!((TroopInfo)localObject).hasSetTroopHead()) {
        break label255;
      }
    }
    label241:
    label243:
    label249:
    label255:
    for (paramView = "1";; paramView = "0")
    {
      localazqx.a(new String[] { str, paramView }).a();
      return;
      i = 0;
      break label100;
      break;
      paramView = "Clk_setcommgrp";
      break label120;
      paramView = "Clk_stick";
      break label190;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aklt
 * JD-Core Version:    0.7.0.1
 */