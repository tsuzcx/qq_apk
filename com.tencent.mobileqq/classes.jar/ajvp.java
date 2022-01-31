import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Label;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.Options;

public class ajvp
  implements Runnable
{
  public ajvp(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    TroopGiftToAllSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView, new Label(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView, this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b));
    TroopGiftToAllSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView).a(TroopGiftToAllSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView).jdField_a_of_type_Int / 2, TroopGiftToAllSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView).b * TroopGiftToAllSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView).f / 100);
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView.a(TroopGiftToAllSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView));
    TroopGiftToAllSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView).b = 0;
    DelayAction localDelayAction = new DelayAction(500);
    localDelayAction.a(new ajvq(this));
    TroopGiftToAllSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftToAllSurfaceView).a(new Action[] { localDelayAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvp
 * JD-Core Version:    0.7.0.1
 */