import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aikq
{
  private aiks a;
  
  private boolean a(aiks paramaiks)
  {
    if (this.a == null) {}
    while (paramaiks.a <= this.a.a) {
      return true;
    }
    return false;
  }
  
  public int a(aisu paramaisu, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (this.a != null) {
      return this.a.a(paramaisu, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public aiks a()
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
  
  public void a(aiks paramaiks)
  {
    if (a(paramaiks))
    {
      this.a = paramaiks;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDrawerContext", 2, "set status success class=" + paramaiks.getClass().getSimpleName());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloDrawerContext", 2, "set status fail class=" + paramaiks.getClass().getSimpleName());
  }
  
  public void a(aisu paramaisu, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.a(paramaisu, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(aisu paramaisu, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramaisu, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, aisu paramaisu)
  {
    if (this.a != null)
    {
      this.a.a(paramQQAppInterface, paramaisu);
      this.a.a = 9999;
    }
  }
  
  public void b(aisu paramaisu, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.b(paramaisu, paramContext, paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aikq
 * JD-Core Version:    0.7.0.1
 */