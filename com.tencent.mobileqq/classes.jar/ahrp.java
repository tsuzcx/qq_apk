import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.io.File;

class ahrp
  implements bkzq
{
  ahrp(ahri paramahri, bkzi parambkzi, AIOImageData paramAIOImageData, File paramFile) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_Bkzi.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    if (this.jdField_a_of_type_Ahri.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_JavaIoFile)) {}
    this.jdField_a_of_type_Bkzi.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrp
 * JD-Core Version:    0.7.0.1
 */