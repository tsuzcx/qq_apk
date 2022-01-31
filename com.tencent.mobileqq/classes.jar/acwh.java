import android.app.Activity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;

public class acwh
  implements CUKingCardHelper.CUKingDialogListener
{
  public acwh(FileModel paramFileModel, Activity paramActivity) {}
  
  public void callback(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2)) {
      FileModel.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerRecreateFileModel, this.jdField_a_of_type_AndroidAppActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwh
 * JD-Core Version:    0.7.0.1
 */