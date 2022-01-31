import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteEvaluateViewHolder;

public class ajij
  implements URLDrawable.DownloadListener
{
  public ajij(ReciteEvaluateViewHolder paramReciteEvaluateViewHolder) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    ReciteEvaluateViewHolder.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajij
 * JD-Core Version:    0.7.0.1
 */