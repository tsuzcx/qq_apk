import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

class aari
  implements nwi
{
  aari(aarc paramaarc) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      bifb localbifb = this.a.mRuntime.a(this.a.mRuntime.a());
      if ((localbifb != null) && ((localbifb instanceof bika)) && (((bika)localbifb).getTopActivity() != localObject))
      {
        localObject = this.a.mRuntime.a();
        if (localObject != null) {
          try
          {
            localbifb = this.a.mRuntime.a(this.a.mRuntime.a());
            if ((localbifb instanceof bikm))
            {
              ((WebView)localObject).loadUrl(((bikm)localbifb).getCurrentUrl());
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
 * Qualified Name:     aari
 * JD-Core Version:    0.7.0.1
 */