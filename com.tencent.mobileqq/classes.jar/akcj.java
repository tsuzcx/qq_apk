import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

class akcj
  implements akbj
{
  akcj(akci paramakci, File paramFile, AtomicBoolean paramAtomicBoolean) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult arg2)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(???.filePath))) {}
    synchronized (this.jdField_a_of_type_JavaIoFile)
    {
      this.jdField_a_of_type_JavaIoFile.notify();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
      QLog.e("QWalletPicDownloader", 2, "downloadImage file not succeed, pathRes=" + ???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcj
 * JD-Core Version:    0.7.0.1
 */