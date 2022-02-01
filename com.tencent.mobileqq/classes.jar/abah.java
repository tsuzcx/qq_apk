import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class abah
  extends arac<abag>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      abac.a().a("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      abac.a().a("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      abac.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public abag a(int paramInt)
  {
    return new abag();
  }
  
  @Nullable
  public abag a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      abag localabag = abag.a(paramArrayOfaraj[0].a);
      if (localabag == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)abac.a().a("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(localabag.b())) && (!localabag.b().equals(str)))
      {
        abav.a().a(localabag);
        a(localabag.b(), paramArrayOfaraj[0].a);
      }
      return localabag;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(abag paramabag)
  {
    if (paramabag != null) {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + paramabag.toString());
    }
  }
  
  public Class<abag> clazz()
  {
    return abag.class;
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
    return 473;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abah
 * JD-Core Version:    0.7.0.1
 */