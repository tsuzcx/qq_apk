import android.widget.Button;
import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper.CameraHelperCallback;
import java.io.File;

public class abvc
  implements CameraHelper.CameraHelperCallback
{
  public abvc(FlowCameraPhotoActivity paramFlowCameraPhotoActivity) {}
  
  public void a(String paramString)
  {
    this.a.jdField_a_of_type_JavaLangString = paramString;
    if (this.a.jdField_a_of_type_JavaLangString != null)
    {
      paramString = new File(this.a.jdField_a_of_type_JavaLangString);
      this.a.d = false;
      this.a.a(paramString, true);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvc
 * JD-Core Version:    0.7.0.1
 */