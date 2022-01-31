import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ahhe
  implements ahbt
{
  ahhe(ahhd paramahhd, ahgi paramahgi) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbEntryPendantHolder", 2, "tryLoadDefaultRes resCode:" + paramInt + ",pathRes:" + paramPathResult);
    }
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if (paramPathResult == null) {
        break label156;
      }
    }
    for (;;)
    {
      if (((j & i) == 0) || (bbjw.a(paramPathResult.folderPath))) {
        break label162;
      }
      ahhd.a(this.jdField_a_of_type_Ahhd, paramPathResult.folderPath + File.separator + "pendant" + File.separator);
      ahhd.b(this.jdField_a_of_type_Ahhd);
      if (!ahhd.b()) {
        break label162;
      }
      ahhd.a(this.jdField_a_of_type_Ahhd, this.jdField_a_of_type_Ahgi);
      ahhd.c(this.jdField_a_of_type_Ahhd);
      ahhd.d(this.jdField_a_of_type_Ahhd);
      return;
      i = 0;
      break;
      label156:
      j = 0;
    }
    label162:
    ahhd.b(this.jdField_a_of_type_Ahhd, this.jdField_a_of_type_Ahgi);
    QLog.e("springHb_SpringHbEntryPendantHolder", 2, "tryLoadDefaultRes --> PreloadFailed，resCode：" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhe
 * JD-Core Version:    0.7.0.1
 */