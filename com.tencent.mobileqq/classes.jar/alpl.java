import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import java.util.ArrayList;

class alpl
  implements IUploadTaskCallback
{
  alpl(alpk paramalpk) {}
  
  public void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qzonephotowall", 2, "onUploadError " + paramString + " path:" + paramAbstractUploadTask.uploadFilePath);
    }
    this.a.notifyUI(71, false, new Object[] { paramAbstractUploadTask.uploadFilePath });
  }
  
  public void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2)
    {
      this.a.b = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qzonephotowall", 2, "onUploadProgress is 100%");
      }
    }
  }
  
  public void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt) {}
  
  public void onUploadSucceed(AbstractUploadTask arg1, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "onUploadSucceed ");
    }
    synchronized (alpk.a(this.a))
    {
      if (alpk.a(this.a).size() != 0)
      {
        alpk.a(this.a);
        return;
      }
      this.a.notifyUI(71, true, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alpl
 * JD-Core Version:    0.7.0.1
 */