import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;

public class abci
  extends ArkAppCGI.ArkAppCGICallback
{
  public abci(ArkLocalAppMgr paramArkLocalAppMgr) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, Object paramObject)
  {
    ThreadManager.post(new abcj(this, paramBoolean, paramArrayOfByte, paramObject), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abci
 * JD-Core Version:    0.7.0.1
 */