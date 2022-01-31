import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;

class aalm
  extends ArkAppCGI.ArkAppCGICallback
{
  aalm(aall paramaall) {}
  
  public void a(boolean paramBoolean, long paramLong, byte[] paramArrayOfByte)
  {
    ThreadManager.post(new aaln(this, paramArrayOfByte, paramBoolean), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aalm
 * JD-Core Version:    0.7.0.1
 */