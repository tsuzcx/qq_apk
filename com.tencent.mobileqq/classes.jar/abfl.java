import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

class abfl
  implements nnx
{
  abfl(abff paramabff) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      biod localbiod = this.a.mRuntime.a(this.a.mRuntime.a());
      if ((localbiod != null) && ((localbiod instanceof bitg)) && (((bitg)localbiod).getTopActivity() != localObject))
      {
        localObject = this.a.mRuntime.a();
        if (localObject != null) {
          try
          {
            localbiod = this.a.mRuntime.a(this.a.mRuntime.a());
            if ((localbiod instanceof bits))
            {
              ((WebView)localObject).loadUrl(((bits)localbiod).getCurrentUrl());
              return;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public void loaded(String paramString, int paramInt)
  {
    paramString = this.a.a.obtainMessage();
    paramString.arg1 = 5;
    paramString.arg2 = paramInt;
    this.a.a.sendMessage(paramString);
  }
  
  public void progress(int paramInt)
  {
    Message localMessage = this.a.a.obtainMessage();
    localMessage.arg1 = 4;
    localMessage.arg2 = paramInt;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abfl
 * JD-Core Version:    0.7.0.1
 */