import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.qphone.base.util.QLog;

class akpe
  implements aukx
{
  akpe(akpd paramakpd) {}
  
  public void a(NoColumnError paramNoColumnError)
  {
    if ((paramNoColumnError != null) && (("unreadGiftCount".equals(paramNoColumnError.mColumnName)) || ("unreadMark".equals(paramNoColumnError.mColumnName))))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.unread.Proxy", 2, paramNoColumnError.getMessage(), paramNoColumnError);
      }
      akpd.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akpe
 * JD-Core Version:    0.7.0.1
 */