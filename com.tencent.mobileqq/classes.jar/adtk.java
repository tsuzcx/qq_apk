import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class adtk
  implements Handler.Callback
{
  public adtk(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      ForwardSdkBaseOption.a(this.a);
    }
    for (;;)
    {
      return true;
      ForwardSdkBaseOption.b(this.a);
      continue;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (this.a.jdField_a_of_type_Adtz != null)) {
        this.a.jdField_a_of_type_Adtz.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adtk
 * JD-Core Version:    0.7.0.1
 */