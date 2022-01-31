import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aixh
{
  private aixj a;
  
  private boolean a(aixj paramaixj)
  {
    if (this.a == null) {}
    while (paramaixj.a <= this.a.a) {
      return true;
    }
    return false;
  }
  
  public int a(ajfq paramajfq, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (this.a != null) {
      return this.a.a(paramajfq, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public aixj a()
  {
    return this.a;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.a();
      this.a.a = 9999;
    }
  }
  
  public void a(aixj paramaixj)
  {
    if (a(paramaixj))
    {
      this.a = paramaixj;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDrawerContext", 2, "set status success class=" + paramaixj.getClass().getSimpleName());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloDrawerContext", 2, "set status fail class=" + paramaixj.getClass().getSimpleName());
  }
  
  public void a(ajfq paramajfq, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.a(paramajfq, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(ajfq paramajfq, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramajfq, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ajfq paramajfq)
  {
    if (this.a != null)
    {
      this.a.a(paramQQAppInterface, paramajfq);
      this.a.a = 9999;
    }
  }
  
  public void b(ajfq paramajfq, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.b(paramajfq, paramContext, paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixh
 * JD-Core Version:    0.7.0.1
 */