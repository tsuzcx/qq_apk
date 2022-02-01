import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class abaj
  extends arac<abai>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate() apply new widget config");
    if (!TextUtils.isEmpty(paramString2))
    {
      abac.a().a("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(true));
      abac.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", paramString1);
      abac.a().a("KEY_VS_ENTRANCE_WIDGET_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public abai a(int paramInt)
  {
    return new abai();
  }
  
  @Nullable
  public abai a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      abai localabai = abai.a(paramArrayOfaraj[0].a);
      if (localabai == null)
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)abac.a().a("KEY_VS_ENTRANCE_WIDGET_MD5", "");
      if ((!TextUtils.isEmpty(localabai.b())) && (!localabai.b().equals(str)))
      {
        abav.a().a(localabai);
        a(localabai.b(), paramArrayOfaraj[0].a);
      }
      return localabai;
    }
    QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(abai paramabai)
  {
    if (paramabai != null) {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate:" + paramabai.toString());
    }
  }
  
  public Class<abai> clazz()
  {
    return abai.class;
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
    return 474;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abaj
 * JD-Core Version:    0.7.0.1
 */