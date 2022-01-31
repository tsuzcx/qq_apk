import android.content.Context;
import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;

public final class ajbk
  extends DirectForwarder.CallBack
{
  public ajbk(Context paramContext) {}
  
  protected void a(AsyncTask paramAsyncTask, int paramInt)
  {
    super.a(paramAsyncTask, paramInt);
    DirectForwarder.a(this.a, paramAsyncTask, paramInt, new ajbl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajbk
 * JD-Core Version:    0.7.0.1
 */