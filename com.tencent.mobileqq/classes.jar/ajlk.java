import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr;

public class ajlk
  implements Runnable
{
  public ajlk(TroopFileDownloadMgr paramTroopFileDownloadMgr) {}
  
  public void run()
  {
    if (!this.a.a) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.a);
    this.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlk
 * JD-Core Version:    0.7.0.1
 */