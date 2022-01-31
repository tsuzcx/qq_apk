import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class ajlv
  implements Runnable
{
  public ajlv(TroopFileDownloader paramTroopFileDownloader) {}
  
  public void run()
  {
    if (this.a.a) {
      TroopFileTransferUtil.Log.b("TroopFileDownloader", TroopFileTransferUtil.Log.a, "[" + this.a.b + "] download. had stoped");
    }
    while (this.a.a()) {
      return;
    }
    if (!this.a.b())
    {
      this.a.a(true, -5001, "file open exception", "");
      return;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      this.a.a(true, 9004, "no network", "");
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlv
 * JD-Core Version:    0.7.0.1
 */