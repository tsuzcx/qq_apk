import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.tencent.mobileqq.forward.ForwardBaseOption;

public class adal
  extends DirectForwarder.CallBack
{
  public adal(ForwardBaseOption paramForwardBaseOption) {}
  
  protected void a(AsyncTask paramAsyncTask, int paramInt)
  {
    super.a(paramAsyncTask, paramInt);
    DirectForwarder.a(this.a.a, paramAsyncTask, paramInt, new adam(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adal
 * JD-Core Version:    0.7.0.1
 */