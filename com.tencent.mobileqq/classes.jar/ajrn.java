import android.content.Context;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ajrn
  implements AsyncCallBack
{
  public ajrn(SoLibraryChecker paramSoLibraryChecker, long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = OfflineEnvHelper.a(SoLibraryChecker.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsSoLibraryChecker)) + SoLibraryChecker.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsSoLibraryChecker) + File.separator + SoLibraryChecker.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsSoLibraryChecker);
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLibraryLoader", 2, "file not exist! path = " + paramString);
      }
      return;
    }
    FileUtils.d(paramString, SoLibraryChecker.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsSoLibraryChecker).getFilesDir().getAbsolutePath() + File.separator + SoLibraryChecker.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsSoLibraryChecker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrn
 * JD-Core Version:    0.7.0.1
 */