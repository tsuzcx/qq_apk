import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class aczm
  extends AsyncTask
{
  aczm(aczl paramaczl) {}
  
  protected Integer a(Object... paramVarArgs)
  {
    paramVarArgs = FMDataCache.b().iterator();
    int i = 0;
    File localFile;
    for (;;)
    {
      if (!paramVarArgs.hasNext()) {
        break label150;
      }
      FileInfo localFileInfo = (FileInfo)paramVarArgs.next();
      if (!SendBottomBar.a(this.a.a).a().a(localFileInfo.c())) {
        try
        {
          localFile = new File(localFileInfo.c());
          if (!localFile.exists()) {
            QLog.e("delDownloadFiles<FileAssistant>", 1, "local file can scan, is not existed? file:" + localFileInfo.c());
          }
        }
        catch (Exception localException)
        {
          QLog.e("delDownloadFiles<FileAssistant>", 1, "del file error:" + localException.toString());
        }
      }
    }
    for (;;)
    {
      break;
      localFile.delete();
      i += 1;
    }
    label150:
    StorageReport.a().a(true);
    return Integer.valueOf(i);
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.a.d();
    if (paramInteger.intValue() != FMDataCache.a()) {
      FMToastUtil.a(2131428145);
    }
    FMDataCache.b();
    this.a.a.a();
    SendBottomBar.a(this.a.a).n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aczm
 * JD-Core Version:    0.7.0.1
 */