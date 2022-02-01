import com.tencent.biz.richframework.download.RFWDownloader.3;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class aaab
  implements zzv
{
  public aaab(RFWDownloader.3 param3) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if ((!paramBoolean2) || (paramBoolean3))
    {
      if (zzz.a(this.a.this$0).contains(this.a.a))
      {
        QLog.i("RFWDownloader", 1, "getFile ..., file is downloading");
        return;
      }
      QLog.i("RFWDownloader", 1, "getFile ..., start download");
      zzz.b(this.a.this$0, this.a.a, paramString);
      return;
    }
    paramString = this.a.this$0.b(this.a.a);
    QLog.i("RFWDownloader", 1, "getFile success, the file is exist path:" + paramString);
    zzz.a(this.a.this$0, this.a.a, true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaab
 * JD-Core Version:    0.7.0.1
 */