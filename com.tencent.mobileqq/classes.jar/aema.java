import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aema
  extends alzl<aelz>
{
  public int a()
  {
    return 410;
  }
  
  @NonNull
  public aelz a(int paramInt)
  {
    return new aelz();
  }
  
  @Nullable
  public aelz a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      aelz localaelz = aelz.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecConfigProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localaelz;
    }
    return null;
  }
  
  public Class<aelz> a()
  {
    return aelz.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aelz paramaelz)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str = ((QQAppInterface)localObject).c();
      aemi.a(BaseApplicationImpl.getApplication(), str, paramaelz.a());
      aemi.a((QQAppInterface)localObject, paramaelz.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aema
 * JD-Core Version:    0.7.0.1
 */