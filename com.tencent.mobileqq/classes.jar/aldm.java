import android.view.View;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import cooperation.troop.TroopPluginManager.TroopPluginCallback;

public class aldm
  implements TroopPluginManager.TroopPluginCallback
{
  public aldm(ProfileCardMoreInfoView paramProfileCardMoreInfoView, View paramView) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.e = true;
      ProfileCardMoreInfoView.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aldm
 * JD-Core Version:    0.7.0.1
 */