import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteEvaluateViewHolder;

public class aiuf
  implements URLDrawable.DownloadListener
{
  public aiuf(ReciteEvaluateViewHolder paramReciteEvaluateViewHolder) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    ReciteEvaluateViewHolder.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiuf
 * JD-Core Version:    0.7.0.1
 */