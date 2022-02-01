import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ahnk
  extends aptq<ahnj>
{
  @NonNull
  public ahnj a(int paramInt)
  {
    return new ahnj();
  }
  
  @Nullable
  public ahnj a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      ahnj localahnj = ahnj.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecConfigProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localahnj;
    }
    return null;
  }
  
  public void a(ahnj paramahnj)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str = ((QQAppInterface)localObject).getCurrentUin();
      ahns.a(BaseApplicationImpl.getApplication(), str, paramahnj.a());
      ahns.a((QQAppInterface)localObject, paramahnj.a());
    }
  }
  
  public Class<ahnj> clazz()
  {
    return ahnj.class;
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
 * Qualified Name:     ahnk
 * JD-Core Version:    0.7.0.1
 */