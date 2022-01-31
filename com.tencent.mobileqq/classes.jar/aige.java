import com.tencent.filter.Frame;
import com.tencent.mobileqq.shortvideo.filter.QQPtvVideoFilter;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.thread.SegmentGLThread;
import com.tencent.ttpic.util.OnSegmentReadyListener;

public class aige
  implements OnSegmentReadyListener
{
  public aige(QQPtvVideoFilter paramQQPtvVideoFilter) {}
  
  public SegmentDataPipe getReadyData()
  {
    return QQPtvVideoFilter.a(this.a).getCurrentDataPipe();
  }
  
  public boolean needWait()
  {
    return QQPtvVideoFilter.a(this.a).needWait();
  }
  
  public void onTextureReady(Frame paramFrame)
  {
    if (QQPtvVideoFilter.a(this.a) != null) {
      QQPtvVideoFilter.a(this.a).postSegJob(paramFrame);
    }
  }
  
  public void reset()
  {
    if (QQPtvVideoFilter.a(this.a) != null)
    {
      QQPtvVideoFilter.a(this.a).reset();
      if (SLog.a()) {
        SLog.d("QQPtvVideoFilter", "initSegmentGLThread reset!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aige
 * JD-Core Version:    0.7.0.1
 */