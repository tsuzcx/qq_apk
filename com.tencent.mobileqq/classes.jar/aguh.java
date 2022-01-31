import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class aguh
  extends alih
{
  private agui jdField_a_of_type_Agui;
  
  private aguh(agud paramagud, View paramView)
  {
    super(paramView);
  }
  
  public void a(Drawable paramDrawable)
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      this.jdField_a_of_type_Agui = new agui(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      int j = this.jdField_a_of_type_AndroidViewView.getWidth();
      int i = j;
      if (j == 0) {
        i = awmc.a;
      }
      j = aciy.a(375.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      a(i - j - 0, 0, j, aciy.a(30.0F, this.jdField_a_of_type_AndroidViewView.getResources()), this.jdField_a_of_type_AndroidViewView);
      return;
    }
    catch (Throwable paramDrawable)
    {
      QLog.e("springHb_SpringHbLightPendantHolder", 1, paramDrawable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aguh
 * JD-Core Version:    0.7.0.1
 */