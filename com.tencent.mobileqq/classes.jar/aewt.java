import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aewt
  extends ampa<aews>
{
  public int a()
  {
    return 410;
  }
  
  @NonNull
  public aews a(int paramInt)
  {
    return new aews();
  }
  
  @Nullable
  public aews a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      aews localaews = aews.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecConfigProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localaews;
    }
    return null;
  }
  
  public Class<aews> a()
  {
    return aews.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aews paramaews)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str = ((QQAppInterface)localObject).c();
      aexb.a(BaseApplicationImpl.getApplication(), str, paramaews.a());
      aexb.a((QQAppInterface)localObject, paramaews.a());
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
 * Qualified Name:     aewt
 * JD-Core Version:    0.7.0.1
 */