import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.io.File;

class aegx
  implements bfph
{
  aegx(aegs paramaegs, bfpc parambfpc, AIOImageData paramAIOImageData, File paramFile) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_Bfpc.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_Bfpc.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_Bfpc.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Bfpc.dismiss();
      return;
    }
    if (this.jdField_a_of_type_Aegs.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_JavaIoFile)) {}
    this.jdField_a_of_type_Bfpc.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegx
 * JD-Core Version:    0.7.0.1
 */