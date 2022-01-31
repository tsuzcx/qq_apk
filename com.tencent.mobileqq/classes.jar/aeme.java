import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.ActionCountdownOver;
import java.util.TimerTask;

public class aeme
  extends TimerTask
{
  public aeme(ActionGlobalData paramActionGlobalData) {}
  
  public void run()
  {
    ActionGlobalData localActionGlobalData = this.a;
    localActionGlobalData.h += 1;
    localActionGlobalData = this.a;
    localActionGlobalData.jdField_a_of_type_Float -= 0.1F;
    if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver.b();
    }
    if (this.a.h * 100 == this.a.c * 1000)
    {
      this.a.jdField_a_of_type_Float = 0.0F;
      if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver.a();
      }
      cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeme
 * JD-Core Version:    0.7.0.1
 */