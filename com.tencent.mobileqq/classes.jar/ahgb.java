import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;

class ahgb
  implements ahbt
{
  ahgb(ahfz paramahfz) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    int j = 1;
    int i;
    if (paramInt == 0)
    {
      i = 1;
      if (paramPathResult == null) {
        break label114;
      }
    }
    for (;;)
    {
      if (((j & i) != 0) && (!bbjw.a(paramPathResult.filePath)))
      {
        Bitmap localBitmap = ahfz.a(this.a, paramPathResult.filePath, false);
        if (localBitmap != null)
        {
          ahfz.a(this.a, localBitmap);
          ahfz.a(this.a, false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("springHb_SpringEntryManager", 2, "getTransitionOrDefaultBitmap resCode:" + paramInt + ",pathRes:" + paramPathResult);
      }
      return;
      i = 0;
      break;
      label114:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgb
 * JD-Core Version:    0.7.0.1
 */