import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class adld
  implements Handler.Callback
{
  public adld(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
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
      if ((this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (this.a.jdField_a_of_type_Adls != null)) {
        this.a.jdField_a_of_type_Adls.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adld
 * JD-Core Version:    0.7.0.1
 */