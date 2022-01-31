import com.tencent.mobileqq.shortvideo.filter.QQPtvVideoFilter;
import com.tencent.ttpic.gles.OnSegDataReadyListener;
import com.tencent.ttpic.gles.SegmentDataPipe;

public class ahnj
  implements OnSegDataReadyListener
{
  public ahnj(QQPtvVideoFilter paramQQPtvVideoFilter) {}
  
  public void onDataReady(SegmentDataPipe paramSegmentDataPipe)
  {
    QQPtvVideoFilter.a(this.a, paramSegmentDataPipe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnj
 * JD-Core Version:    0.7.0.1
 */