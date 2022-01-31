import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.tencent.mobileqq.forward.ForwardBaseOption;

public class adki
  extends DirectForwarder.CallBack
{
  public adki(ForwardBaseOption paramForwardBaseOption) {}
  
  protected void a(AsyncTask paramAsyncTask, int paramInt)
  {
    super.a(paramAsyncTask, paramInt);
    DirectForwarder.a(this.a.a, paramAsyncTask, paramInt, new adkj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adki
 * JD-Core Version:    0.7.0.1
 */