import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amai
  extends alzl<amaj>
{
  public static amaj a()
  {
    return (amaj)alzw.a().a(457);
  }
  
  public int a()
  {
    return 457;
  }
  
  @NonNull
  public amaj a(int paramInt)
  {
    return new amaj();
  }
  
  @Nullable
  public amaj a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length == 0)) {
      return null;
    }
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor onParsed, content:" + paramArrayOfalzs);
    }
    return amaj.a(paramArrayOfalzs);
  }
  
  public Class<amaj> a()
  {
    return amaj.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amaj paramamaj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor update.");
    }
    ((ajls)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(159)).a();
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
 * Qualified Name:     amai
 * JD-Core Version:    0.7.0.1
 */