import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteEvaluateViewHolder;

public class ajpv
  implements URLDrawable.DownloadListener
{
  public ajpv(ReciteEvaluateViewHolder paramReciteEvaluateViewHolder) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    ReciteEvaluateViewHolder.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpv
 * JD-Core Version:    0.7.0.1
 */