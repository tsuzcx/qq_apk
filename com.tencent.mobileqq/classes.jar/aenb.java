import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class aenb
  extends akat
{
  aenb(aemy paramaemy) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    a(paramBoolean, paramString, paramLong, null);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, akaq paramakaq)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.a.a)) {
      return;
    }
    this.a.u = true;
    this.a.a(262144, paramakaq, paramLong);
  }
  
  public void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.e(131072);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.e(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aenb
 * JD-Core Version:    0.7.0.1
 */