import android.media.ExifInterface;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;

public class ajpv
  implements ajwh
{
  public ajpv(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile) {}
  
  public void a_(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlowCameraActivity", 2, "onPictureToken path " + paramString);
    }
    bdhj.a(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.jdField_b_of_type_Double);
    if (QLog.isColorLevel()) {}
    try
    {
      Object localObject = Class.forName("android.media.ExifInterface").getDeclaredField("mAttributes");
      ((Field)localObject).setAccessible(true);
      localObject = (HashMap)((Field)localObject).get(new ExifInterface(paramString));
      QLog.i("FlowCameraActivity", 2, "exif " + localObject);
      if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a(this.jdField_a_of_type_JavaIoFile);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.jdField_b_of_type_AndroidWidgetButton.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.c.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpv
 * JD-Core Version:    0.7.0.1
 */