import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.RegisterActivity;

public class abnz
  extends Handler
{
  public abnz(RegisterActivity paramRegisterActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    this.a.c();
    switch (paramMessage.what)
    {
    case -1: 
    case 0: 
    case 2: 
    default: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        return;
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_Byte = ((byte)(paramMessage.jdField_a_of_type_Byte + 1));
        this.a.a();
        return;
        this.a.d();
        return;
        this.a.b();
        return;
      } while (this.a.jdField_a_of_type_JavaLangString == null);
      Toast.makeText(this.a.getApplicationContext(), this.a.jdField_a_of_type_JavaLangString, 1).show();
      this.a.jdField_a_of_type_JavaLangString = null;
      return;
    case 6: 
      paramMessage = paramMessage.getData().getString("url");
      this.a.a(paramMessage);
      return;
    case 7: 
      this.a.a(paramMessage.getData().getString("telNum"), paramMessage.getData().getString("msg"));
      return;
    }
    this.a.jdField_a_of_type_Byte = 3;
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abnz
 * JD-Core Version:    0.7.0.1
 */