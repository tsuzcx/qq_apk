import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class agur
  implements agpe
{
  agur(aguo paramaguo) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbEntryPendantHolder", 2, "tryLoadLogoRes resCode:" + paramInt + ",pathRes:" + paramPathResult);
    }
    if (paramInt == 0)
    {
      paramInt = 1;
      if (paramPathResult == null) {
        break label154;
      }
    }
    for (;;)
    {
      if (((i & paramInt) != 0) && (!baip.a(paramPathResult.folderPath)))
      {
        aguo.b(this.a, paramPathResult.folderPath + File.separator + "logo" + File.separator);
        aguo.e(this.a);
      }
      QLog.i("springHb_SpringHbEntryPendantHolder", 2, "tryLoadLogoRes -->mLogoDrawableLoaded：" + aguo.b(this.a));
      return;
      paramInt = 0;
      break;
      label154:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agur
 * JD-Core Version:    0.7.0.1
 */