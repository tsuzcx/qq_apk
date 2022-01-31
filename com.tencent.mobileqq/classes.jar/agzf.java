import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DataReport;

public class agzf
  extends Handler
{
  public agzf(DCAIOPreview paramDCAIOPreview, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = DataReport.a();
    int j = DCAIOPreview.a(this.a).size();
    int i = 0;
    while (i < j)
    {
      agzg localagzg = (agzg)DCAIOPreview.a(this.a).valueAt(i);
      paramMessage.a(new agzx("Pic.AioPreview", localagzg.a("Pic.AioPreview")));
      paramMessage.a(new agzx("Pic.AioPreview.Preload", localagzg.a("Pic.AioPreview.Preload")));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agzf
 * JD-Core Version:    0.7.0.1
 */