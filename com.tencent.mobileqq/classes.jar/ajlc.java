import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.FileUploadMgrObserver;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import java.util.Set;

public class ajlc
  extends TroopFileUploadMgr.FileUploadMgrObserver
{
  public ajlc(TroopFileTransferMgr paramTroopFileTransferMgr) {}
  
  protected void a(Set paramSet)
  {
    this.a.a = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(TroopFileTransferMgr.a(this.a))))) {
      this.a.a = 2;
    }
    TroopFileTransferUtil.Log.c("TroopFileTransferMgr", TroopFileTransferUtil.Log.a, "onW2MPausedUpload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.b > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        TroopFileError.a(TroopFileTransferMgr.a(this.a), TroopFileTransferMgr.b(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlc
 * JD-Core Version:    0.7.0.1
 */