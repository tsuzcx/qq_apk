import com.tencent.biz.troop.file.TroopFileProtocol.GetOneFileInfoObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

public class ajbd
  extends TroopFileProtocol.GetOneFileInfoObserver
{
  public ajbd(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if ((paramBoolean) && (paramFileInfo != null))
    {
      String str = paramFileInfo.str_file_id.get();
      Object localObject = str;
      if (!str.startsWith("/")) {
        localObject = "/" + str;
      }
      localObject = this.a.a().a((String)localObject);
      if (localObject != null)
      {
        ((TroopFileInfo)localObject).a = paramFileInfo.uint32_bus_id.get();
        ((TroopFileInfo)localObject).c = paramFileInfo.uint32_dead_time.get();
      }
      this.a.a().d((TroopFileInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajbd
 * JD-Core Version:    0.7.0.1
 */