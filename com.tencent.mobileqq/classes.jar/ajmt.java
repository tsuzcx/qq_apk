import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr;

public class ajmt
  implements Runnable
{
  public ajmt(TroopFileUploadMgr paramTroopFileUploadMgr) {}
  
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
 * Qualified Name:     ajmt
 * JD-Core Version:    0.7.0.1
 */