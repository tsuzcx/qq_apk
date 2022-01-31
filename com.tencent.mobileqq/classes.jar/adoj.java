import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;

public class adoj
  implements CUKingCardHelper.CUKingDialogListener
{
  public adoj(FileModel paramFileModel, FMDialogUtil.FMDialogInterface paramFMDialogInterface) {}
  
  public void callback(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFMDialogUtil$FMDialogInterface.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFMDialogUtil$FMDialogInterface.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adoj
 * JD-Core Version:    0.7.0.1
 */