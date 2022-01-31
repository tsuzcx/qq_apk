import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ahhd
  implements ahbr
{
  ahhd(ahhb paramahhb, ahgg paramahgg) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbEntryPendantHolder", 2, "tryLoadActivityRes resCode:" + paramInt + ",pathRes:" + paramPathResult);
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
      if (((j & i) == 0) || (bbkk.a(paramPathResult.folderPath))) {
        break label162;
      }
      ahhb.a(this.jdField_a_of_type_Ahhb, paramPathResult.folderPath + File.separator + "pendant" + File.separator);
      ahhb.b(this.jdField_a_of_type_Ahhb);
      if (!ahhb.b()) {
        break label162;
      }
      ahhb.a(this.jdField_a_of_type_Ahhb, this.jdField_a_of_type_Ahgg);
      ahhb.c(this.jdField_a_of_type_Ahhb);
      ahhb.d(this.jdField_a_of_type_Ahhb);
      return;
      i = 0;
      break;
      label156:
      j = 0;
    }
    label162:
    if (!bbkk.a(this.jdField_a_of_type_Ahgg.a)) {
      ahhb.c(this.jdField_a_of_type_Ahhb, this.jdField_a_of_type_Ahgg);
    }
    for (;;)
    {
      QLog.e("springHb_SpringHbEntryPendantHolder", 2, "tryLoadActivityRes --> PreloadFailed，resCode：" + paramInt);
      return;
      ahhb.b(this.jdField_a_of_type_Ahhb, this.jdField_a_of_type_Ahgg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhd
 * JD-Core Version:    0.7.0.1
 */