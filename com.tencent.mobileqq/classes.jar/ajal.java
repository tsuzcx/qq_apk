import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.GetFileListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.List;

public class ajal
  extends TroopFileProtocol.GetFileListObserver
{
  public ajal(TroopFileManager paramTroopFileManager) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, ByteStringMicro paramByteStringMicro, List paramList, Bundle paramBundle)
  {
    ThreadManager.post(new ajam(this, paramBundle, paramInt2, paramByteStringMicro, paramBoolean1, paramList, paramBoolean2, paramInt3, paramInt1), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajal
 * JD-Core Version:    0.7.0.1
 */