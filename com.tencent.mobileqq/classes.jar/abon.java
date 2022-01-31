import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.qphone.base.util.QLog;

class abon
  implements awcg
{
  abon(abom paramabom) {}
  
  public void a(NoColumnError paramNoColumnError)
  {
    if ((paramNoColumnError != null) && (("unreadGiftCount".equals(paramNoColumnError.mColumnName)) || ("unreadMark".equals(paramNoColumnError.mColumnName))))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.unread.Proxy", 2, paramNoColumnError.getMessage(), paramNoColumnError);
      }
      abom.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abon
 * JD-Core Version:    0.7.0.1
 */