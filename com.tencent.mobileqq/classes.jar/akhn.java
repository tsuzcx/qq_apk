import android.view.View;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;

public class akhn
  implements TroopPluginManager.TroopPluginCallback
{
  public akhn(ProfileCardMoreInfoView paramProfileCardMoreInfoView, View paramView) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.d = true;
      ProfileCardMoreInfoView.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akhn
 * JD-Core Version:    0.7.0.1
 */