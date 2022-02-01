import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aijh
  extends aqkz<aijg>
{
  @NonNull
  public aijg a(int paramInt)
  {
    return new aijg();
  }
  
  @Nullable
  public aijg a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aijg localaijg = aijg.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecConfigProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaijg;
    }
    return null;
  }
  
  public void a(aijg paramaijg)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str = ((QQAppInterface)localObject).c();
      aijp.a(BaseApplicationImpl.getApplication(), str, paramaijg.a());
      aijp.a((QQAppInterface)localObject, paramaijg.a());
    }
  }
  
  public Class<aijg> clazz()
  {
    return aijg.class;
  }
  
  public boolean isAccountRelated()
  {
    return super.isAccountRelated();
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 410;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijh
 * JD-Core Version:    0.7.0.1
 */