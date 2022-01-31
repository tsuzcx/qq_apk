import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class akti
{
  private aktk a;
  
  private boolean a(aktk paramaktk)
  {
    if (this.a == null) {}
    while (paramaktk.a <= this.a.a) {
      return true;
    }
    return false;
  }
  
  public int a(albr paramalbr, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (this.a != null) {
      return this.a.a(paramalbr, paramInt, paramAppInterface, paramContext);
    }
    return -1;
  }
  
  public aktk a()
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
  
  public void a(aktk paramaktk)
  {
    if (a(paramaktk))
    {
      this.a = paramaktk;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDrawerContext", 2, "set status success class=" + paramaktk.getClass().getSimpleName());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloDrawerContext", 2, "set status fail class=" + paramaktk.getClass().getSimpleName());
  }
  
  public void a(albr paramalbr, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.a(paramalbr, paramContext, paramQQAppInterface);
    }
  }
  
  public void a(albr paramalbr, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramalbr, paramContext, paramQQAppInterface, paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, albr paramalbr)
  {
    if (this.a != null)
    {
      this.a.a(paramQQAppInterface, paramalbr);
      this.a.a = 9999;
    }
  }
  
  public void b(albr paramalbr, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (this.a != null) {
      this.a.b(paramalbr, paramContext, paramQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akti
 * JD-Core Version:    0.7.0.1
 */