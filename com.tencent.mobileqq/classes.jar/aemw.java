import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceTextUpdateListener;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;

public class aemw
  implements MagicfaceActionManager.MagicfaceTextUpdateListener
{
  public aemw(MagicfaceViewController paramMagicfaceViewController, int paramInt, TextView paramTextView) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.a.post(new aemx(this, paramString));
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.a.post(new aemy(this, paramString));
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.a.post(new aemz(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemw
 * JD-Core Version:    0.7.0.1
 */