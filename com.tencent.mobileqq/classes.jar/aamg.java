import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;

public class aamg
  extends aqwt<aamf>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate() apply new widget config");
    if (!TextUtils.isEmpty(paramString2))
    {
      VSConfigManager.getInstance().setValue("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(true));
      VSConfigManager.getInstance().setValue("KEY_VS_ENTRANCE_WIDGET_MD5", paramString1);
      VSConfigManager.getInstance().setValue("KEY_VS_ENTRANCE_WIDGET_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public aamf a(int paramInt)
  {
    return new aamf();
  }
  
  @Nullable
  public aamf a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      aamf localaamf = aamf.a(paramArrayOfaqxa[0].a);
      if (localaamf == null)
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)VSConfigManager.getInstance().getValue("KEY_VS_ENTRANCE_WIDGET_MD5", "");
      if ((!TextUtils.isEmpty(localaamf.b())) && (!localaamf.b().equals(str)))
      {
        aams.a().a(localaamf);
        a(localaamf.b(), paramArrayOfaqxa[0].a);
      }
      return localaamf;
    }
    QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(aamf paramaamf)
  {
    if (paramaamf != null) {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate:" + paramaamf.toString());
    }
  }
  
  public Class<aamf> clazz()
  {
    return aamf.class;
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
 * Qualified Name:     aamg
 * JD-Core Version:    0.7.0.1
 */