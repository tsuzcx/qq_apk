import android.content.Context;
import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;

public final class acxr
  extends DirectForwarder.CallBack
{
  public acxr(Context paramContext) {}
  
  protected void a(AsyncTask paramAsyncTask, int paramInt)
  {
    try
    {
      DirectForwarder.a(this.a, paramAsyncTask, paramInt, new acxs(this));
      super.a(paramAsyncTask, paramInt);
      return;
    }
    catch (Exception paramAsyncTask)
    {
      paramAsyncTask.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acxr
 * JD-Core Version:    0.7.0.1
 */