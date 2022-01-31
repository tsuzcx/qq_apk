import android.content.Context;
import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;

public final class ajpo
  extends DirectForwarder.CallBack
{
  public ajpo(Context paramContext) {}
  
  protected void a(AsyncTask paramAsyncTask, int paramInt)
  {
    super.a(paramAsyncTask, paramInt);
    DirectForwarder.a(this.a, paramAsyncTask, paramInt, new ajpp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpo
 * JD-Core Version:    0.7.0.1
 */