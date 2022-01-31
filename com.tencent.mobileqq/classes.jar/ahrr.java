import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

public class ahrr
  implements Runnable
{
  public ahrr(SplitEffectsCameraCaptureView paramSplitEffectsCameraCaptureView) {}
  
  public void run()
  {
    while (SplitEffectsCameraCaptureView.a(this.a).size() > 0)
    {
      String str = (String)SplitEffectsCameraCaptureView.a(this.a).get(0);
      if (!TextUtils.isEmpty(str))
      {
        FileUtils.d(str);
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.cameracapture.SplitEffectsCameraCaptureView", 2, "deleteLastSegment()：deleteFilePath=" + str);
        }
      }
      SplitEffectsCameraCaptureView.a(this.a).remove(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahrr
 * JD-Core Version:    0.7.0.1
 */