import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

class aabw
  implements nph
{
  aabw(aabq paramaabq) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.a();
    if (localObject == null) {}
    for (;;)
    {
      return;
      bguj localbguj = this.a.mRuntime.a(this.a.mRuntime.a());
      if ((localbguj != null) && ((localbguj instanceof bgzi)) && (((bgzi)localbguj).getTopActivity() != localObject))
      {
        localObject = this.a.mRuntime.a();
        if (localObject != null) {
          try
          {
            localbguj = this.a.mRuntime.a(this.a.mRuntime.a());
            if ((localbguj instanceof bgzu))
            {
              ((WebView)localObject).loadUrl(((bgzu)localbguj).getCurrentUrl());
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
 * Qualified Name:     aabw
 * JD-Core Version:    0.7.0.1
 */