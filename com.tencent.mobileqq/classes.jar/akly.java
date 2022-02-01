import android.app.Activity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

class akly
  implements asna
{
  akly(aklt paramaklt) {}
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.a.jdField_a_of_type_Boolean))
    {
      this.a.jdField_a_of_type_AndroidViewWindowManager.removeView(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      this.a.jdField_a_of_type_Boolean = false;
      paramKeyEvent = ((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().getAttributes();
      paramKeyEvent.y = 0;
      ((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().setAttributes(paramKeyEvent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akly
 * JD-Core Version:    0.7.0.1
 */