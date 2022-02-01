import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aita
  extends arac<aisz>
{
  @NonNull
  public aisz a(int paramInt)
  {
    return new aisz();
  }
  
  @Nullable
  public aisz a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      aisz localaisz = aisz.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecConfigProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localaisz;
    }
    return null;
  }
  
  public void a(aisz paramaisz)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str = ((QQAppInterface)localObject).c();
      aiti.a(BaseApplicationImpl.getApplication(), str, paramaisz.a());
      aiti.a((QQAppInterface)localObject, paramaisz.a());
    }
  }
  
  public Class<aisz> clazz()
  {
    return aisz.class;
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
 * Qualified Name:     aita
 * JD-Core Version:    0.7.0.1
 */