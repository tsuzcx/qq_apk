import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class aiib
  extends aocj
{
  aiib(aihy paramaihy) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    a(paramBoolean, paramString, paramLong, null);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, aocg paramaocg)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.a.a)) {
      return;
    }
    this.a.t = true;
    this.a.a(262144, paramaocg, paramLong);
  }
  
  public void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.f(131072);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.f(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiib
 * JD-Core Version:    0.7.0.1
 */