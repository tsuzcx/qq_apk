import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.io.File;

class ahsk
  implements bkhw
{
  ahsk(ahsd paramahsd, bkho parambkho, AIOImageData paramAIOImageData, File paramFile) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_Bkho.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_Bkho.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_Bkho.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Bkho.dismiss();
      return;
    }
    if (this.jdField_a_of_type_Ahsd.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_JavaIoFile)) {}
    this.jdField_a_of_type_Bkho.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsk
 * JD-Core Version:    0.7.0.1
 */