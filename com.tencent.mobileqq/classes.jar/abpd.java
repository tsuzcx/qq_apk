import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class abpd
  implements ValueCallback<String>
{
  abpd(abpc paramabpc) {}
  
  public void a(String paramString)
  {
    QLog.i("GdtMvElementsHelper", 1, "callJs onReceiveValue " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpd
 * JD-Core Version:    0.7.0.1
 */