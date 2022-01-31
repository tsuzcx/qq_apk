import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class agyn
  extends aokh<agym>
{
  public int a()
  {
    return 410;
  }
  
  @NonNull
  public agym a(int paramInt)
  {
    return new agym();
  }
  
  @Nullable
  public agym a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      agym localagym = agym.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecConfigProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localagym;
    }
    return null;
  }
  
  public Class<agym> a()
  {
    return agym.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(agym paramagym)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str = ((QQAppInterface)localObject).c();
      agyv.a(BaseApplicationImpl.getApplication(), str, paramagym.a());
      agyv.a((QQAppInterface)localObject, paramagym.a());
    }
  }
  
  public boolean a()
  {
    return super.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyn
 * JD-Core Version:    0.7.0.1
 */