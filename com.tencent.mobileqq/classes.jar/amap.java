import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amap
  extends alzl<amao>
{
  public static void b()
  {
    amao localamao = (amao)alzw.a().a(67);
    amao.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localamao);
  }
  
  public static void c()
  {
    int i = alzw.a().a(67, "");
    QLog.w("ApolloConfig_GlobalProcessor", 1, "resetApolloConfVersion localVersion:" + i);
    alzw.a().a(67, 0);
  }
  
  public int a()
  {
    return 67;
  }
  
  @NonNull
  public amao a(int paramInt)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    if (paramInt == 1) {
      return new amao();
    }
    return amao.a();
  }
  
  @Nullable
  public amao a(alzs[] paramArrayOfalzs)
  {
    return amao.a(paramArrayOfalzs);
  }
  
  public Class<amao> a()
  {
    return amao.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloConfig_GlobalProcessor", 2, "onReqNoReceive");
    }
  }
  
  public void a(int paramInt)
  {
    QLog.e("ApolloConfig_GlobalProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(amao paramamao)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "onUpdate");
    amao.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramamao);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amap
 * JD-Core Version:    0.7.0.1
 */