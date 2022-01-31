import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;

class aasn
  extends ArkAppCGI.ArkAppCGICallback
{
  aasn(aasm paramaasm) {}
  
  public void a(boolean paramBoolean, long paramLong, byte[] paramArrayOfByte)
  {
    ThreadManager.post(new aaso(this, paramArrayOfByte, paramBoolean), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aasn
 * JD-Core Version:    0.7.0.1
 */