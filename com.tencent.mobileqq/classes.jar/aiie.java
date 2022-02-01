import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aiie
  extends aqwt<aiid>
{
  @NonNull
  public aiid a(int paramInt)
  {
    return new aiid();
  }
  
  @Nullable
  public aiid a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      aiid localaiid = aiid.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecConfigProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localaiid;
    }
    return null;
  }
  
  public void a(aiid paramaiid)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str = ((QQAppInterface)localObject).getCurrentUin();
      aiin.a(BaseApplicationImpl.getApplication(), str, paramaiid.a());
      aiin.a((QQAppInterface)localObject, paramaiid.a());
    }
  }
  
  public Class<aiid> clazz()
  {
    return aiid.class;
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
 * Qualified Name:     aiie
 * JD-Core Version:    0.7.0.1
 */