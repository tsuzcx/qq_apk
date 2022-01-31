import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amar
  extends alzl<amaq>
{
  public static void b()
  {
    amaq localamaq = (amaq)alzw.a().a(430);
    amaq.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localamaq);
  }
  
  public int a()
  {
    return 430;
  }
  
  @NonNull
  public amaq a(int paramInt)
  {
    return new amaq();
  }
  
  @Nullable
  public amaq a(alzs[] paramArrayOfalzs)
  {
    return amaq.a(paramArrayOfalzs);
  }
  
  public Class<amaq> a()
  {
    return amaq.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("ApolloConfig_GrayProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(amaq paramamaq)
  {
    QLog.w("ApolloConfig_GrayProcessor", 1, "onUpdate");
    amaq.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramamaq);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amar
 * JD-Core Version:    0.7.0.1
 */