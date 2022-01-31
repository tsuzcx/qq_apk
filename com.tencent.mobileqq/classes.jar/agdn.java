import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.io.File;

class agdn
  implements bhqd
{
  agdn(agdi paramagdi, bhpy parambhpy, AIOImageData paramAIOImageData, File paramFile) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_Bhpy.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
    if (this.jdField_a_of_type_Agdi.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_JavaIoFile)) {}
    this.jdField_a_of_type_Bhpy.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdn
 * JD-Core Version:    0.7.0.1
 */