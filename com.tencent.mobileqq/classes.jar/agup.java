import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class agup
  implements agpe
{
  agup(aguo paramaguo, agtt paramagtt) {}
  
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
      if (((j & i) == 0) || (baip.a(paramPathResult.folderPath))) {
        break label162;
      }
      aguo.a(this.jdField_a_of_type_Aguo, paramPathResult.folderPath + File.separator + "pendant" + File.separator);
      aguo.b(this.jdField_a_of_type_Aguo);
      if (!aguo.b()) {
        break label162;
      }
      aguo.a(this.jdField_a_of_type_Aguo, this.jdField_a_of_type_Agtt);
      aguo.c(this.jdField_a_of_type_Aguo);
      aguo.d(this.jdField_a_of_type_Aguo);
      return;
      i = 0;
      break;
      label156:
      j = 0;
    }
    label162:
    aguo.b(this.jdField_a_of_type_Aguo, this.jdField_a_of_type_Agtt);
    QLog.e("springHb_SpringHbEntryPendantHolder", 2, "tryLoadDefaultRes --> PreloadFailed，resCode：" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agup
 * JD-Core Version:    0.7.0.1
 */