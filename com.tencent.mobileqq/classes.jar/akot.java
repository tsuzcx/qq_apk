import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class akot
{
  private akov a;
  
  private boolean a(akov paramakov)
  {
    if (this.a == null) {}
    while (paramakov.a <= this.a.a) {
      return true;
    }
    return false;
  }
  
  public int a(akxc paramakxc, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (this.a != null) {
      return this.a.a(paramakxc, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public akov a()
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
  
  public void a(akov paramakov)
  {
    if (a(paramakov))
    {
      this.a = paramakov;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDrawerContext", 2, "set status success class=" + paramakov.getClass().getSimpleName());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloDrawerContext", 2, "set status fail class=" + paramakov.getClass().getSimpleName());
  }
  
  public void a(akxc paramakxc, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.a(paramakxc, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(akxc paramakxc, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramakxc, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, akxc paramakxc)
  {
    if (this.a != null)
    {
      this.a.a(paramQQAppInterface, paramakxc);
      this.a.a = 9999;
    }
  }
  
  public void b(akxc paramakxc, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.b(paramakxc, paramContext, paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akot
 * JD-Core Version:    0.7.0.1
 */