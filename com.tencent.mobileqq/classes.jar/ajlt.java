import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.MD5;

public class ajlt
  implements Runnable
{
  public ajlt(TroopFileDownloadWorker paramTroopFileDownloadWorker) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] start. had stoped");
      return;
    }
    this.a.b();
    String str = MD5.toMD5(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.a.d = (this.a.c + str);
    str = this.a.c + HexUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath.getBytes()) + ".tmp";
    if (FileUtil.a(str) > 0L)
    {
      TroopFileTransferUtil.Log.b("TroopFileDownloadWorker", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] start. use oldVerTmpPath to resume.");
      this.a.d = str;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile = this.a.d;
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlt
 * JD-Core Version:    0.7.0.1
 */