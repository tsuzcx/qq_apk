import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aawe
  extends aqkz<aawd>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      aavz.a().a("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      aavz.a().a("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      aavz.a().a("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public aawd a(int paramInt)
  {
    return new aawd();
  }
  
  @Nullable
  public aawd a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      aawd localaawd = aawd.a(paramArrayOfaqlg[0].a);
      if (localaawd == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)aavz.a().a("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(localaawd.b())) && (!localaawd.b().equals(str)))
      {
        aaws.a().a(localaawd);
        a(localaawd.b(), paramArrayOfaqlg[0].a);
      }
      return localaawd;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(aawd paramaawd)
  {
    if (paramaawd != null) {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + paramaawd.toString());
    }
  }
  
  public Class<aawd> clazz()
  {
    return aawd.class;
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
 * Qualified Name:     aawe
 * JD-Core Version:    0.7.0.1
 */