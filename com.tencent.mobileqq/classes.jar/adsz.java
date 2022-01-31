import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import java.io.IOException;
import java.io.InputStream;

public class adsz
  implements DialogInterface.OnClickListener
{
  public adsz(ForwardFileBaseOption paramForwardFileBaseOption, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption.a.finish();
      return;
    }
    catch (IOException paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adsz
 * JD-Core Version:    0.7.0.1
 */