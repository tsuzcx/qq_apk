import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

class abbi
  implements nmc
{
  abbi(abbc paramabbc) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      bhni localbhni = this.a.mRuntime.a(this.a.mRuntime.a());
      if ((localbhni != null) && ((localbhni instanceof bhsl)) && (((bhsl)localbhni).getTopActivity() != localObject))
      {
        localObject = this.a.mRuntime.a();
        if (localObject != null) {
          try
          {
            localbhni = this.a.mRuntime.a(this.a.mRuntime.a());
            if ((localbhni instanceof bhsx))
            {
              ((WebView)localObject).loadUrl(((bhsx)localbhni).getCurrentUrl());
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
 * Qualified Name:     abbi
 * JD-Core Version:    0.7.0.1
 */