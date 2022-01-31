import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aewv
  extends ampb<aewu>
{
  public int a()
  {
    return 410;
  }
  
  @NonNull
  public aewu a(int paramInt)
  {
    return new aewu();
  }
  
  @Nullable
  public aewu a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      aewu localaewu = aewu.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecConfigProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localaewu;
    }
    return null;
  }
  
  public Class<aewu> a()
  {
    return aewu.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aewu paramaewu)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str = ((QQAppInterface)localObject).c();
      aexd.a(BaseApplicationImpl.getApplication(), str, paramaewu.a());
      aexd.a((QQAppInterface)localObject, paramaewu.a());
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
 * Qualified Name:     aewv
 * JD-Core Version:    0.7.0.1
 */