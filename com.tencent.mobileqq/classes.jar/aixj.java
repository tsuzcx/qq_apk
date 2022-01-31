import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aixj
{
  private aixl a;
  
  private boolean a(aixl paramaixl)
  {
    if (this.a == null) {}
    while (paramaixl.a <= this.a.a) {
      return true;
    }
    return false;
  }
  
  public int a(ajfs paramajfs, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (this.a != null) {
      return this.a.a(paramajfs, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public aixl a()
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
  
  public void a(aixl paramaixl)
  {
    if (a(paramaixl))
    {
      this.a = paramaixl;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDrawerContext", 2, "set status success class=" + paramaixl.getClass().getSimpleName());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloDrawerContext", 2, "set status fail class=" + paramaixl.getClass().getSimpleName());
  }
  
  public void a(ajfs paramajfs, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.a(paramajfs, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(ajfs paramajfs, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramajfs, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ajfs paramajfs)
  {
    if (this.a != null)
    {
      this.a.a(paramQQAppInterface, paramajfs);
      this.a.a = 9999;
    }
  }
  
  public void b(ajfs paramajfs, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.b(paramajfs, paramContext, paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixj
 * JD-Core Version:    0.7.0.1
 */