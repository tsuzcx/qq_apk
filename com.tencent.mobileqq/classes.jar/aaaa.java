import com.tencent.biz.richframework.download.RFWDownloader.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Set;

public class aaaa
  implements beuq
{
  public aaaa(RFWDownloader.2 param2) {}
  
  public void onResp(bevm parambevm)
  {
    zzz.a(this.a.this$0).remove(this.a.a);
    QLog.i("RFWDownloader", 1, "download  onResp url:  resultcode: " + parambevm.c);
    QLog.i("RFWDownloader", 1, "downloadFinish downloadSavePath" + this.a.b);
    if (zzz.a(this.a.this$0, this.a.a)) {
      try
      {
        parambevm = this.a.this$0.b(this.a.a);
        File localFile = new File(this.a.b);
        QLog.d("RFWDownloader", 4, "start unzip file to folderPath:" + parambevm);
        nof.a(localFile, parambevm);
        bhmi.a(localFile);
        QLog.i("RFWDownloader", 1, "unzip success");
        zzz.a(this.a.this$0, this.a.a, this.a.c);
        zzz.a(this.a.this$0, this.a.a, true, parambevm);
        return;
      }
      catch (Exception parambevm)
      {
        zzz.a(this.a.this$0, this.a.a, false, "");
        QLog.i("DownLoadZipFile", 1, "unzip file failed" + parambevm);
        return;
      }
    }
    QLog.i("RFWDownloader", 1, "is not zip file, not need upzip");
    zzz.a(this.a.this$0, this.a.a, this.a.c);
    zzz.a(this.a.this$0, this.a.a, true, this.a.b);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaaa
 * JD-Core Version:    0.7.0.1
 */