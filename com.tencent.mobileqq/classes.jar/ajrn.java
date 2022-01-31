import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import mqq.util.WeakReference;

class ajrn
  implements Runnable
{
  ajrn(ajrm paramajrm, TroopUploadingThread.UploadState paramUploadState) {}
  
  public void run()
  {
    AvatarWallAdapter.g = 0;
    this.jdField_a_of_type_Ajrm.a.h = 0;
    int i = this.jdField_a_of_type_Ajrm.a.jdField_b_of_type_Int - this.jdField_a_of_type_Ajrm.a.jdField_d_of_type_Int;
    if (i >= 8) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a != 1) {
                break;
              }
              this.jdField_a_of_type_Ajrm.a.a(i, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.c);
            } while (this.jdField_a_of_type_Ajrm.a.a(this.jdField_a_of_type_Ajrm.a.jdField_b_of_type_JavaLangString));
            this.jdField_a_of_type_Ajrm.a.jdField_d_of_type_Boolean = false;
            this.jdField_a_of_type_Ajrm.a.a();
            return;
          } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a != 2);
          ReportController.b(this.jdField_a_of_type_Ajrm.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", this.jdField_a_of_type_Ajrm.a.c, "upload_head_cancel", 0, 0, this.jdField_a_of_type_Ajrm.a.jdField_b_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.jdField_b_of_type_Int), "", "");
        } while (this.jdField_a_of_type_Ajrm.a.jdField_a_of_type_MqqUtilWeakReference == null);
        localObject = (Activity)this.jdField_a_of_type_Ajrm.a.jdField_a_of_type_MqqUtilWeakReference.get();
      } while (localObject == null);
      localObject = AvatarWallAdapter.a((Context)localObject, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.jdField_b_of_type_Int);
    } while (localObject == null);
    this.jdField_a_of_type_Ajrm.a.a((String)localObject, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrn
 * JD-Core Version:    0.7.0.1
 */