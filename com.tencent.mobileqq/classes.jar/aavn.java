import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;

public class aavn
  extends ArkAppCGI.ArkAppCGICallback
{
  public aavn(ArkLocalAppMgr paramArkLocalAppMgr) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, Object paramObject)
  {
    ThreadManager.post(new aavo(this, paramBoolean, paramArrayOfByte, paramObject), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aavn
 * JD-Core Version:    0.7.0.1
 */