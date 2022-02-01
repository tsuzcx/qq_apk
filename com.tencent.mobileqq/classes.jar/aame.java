import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;

public class aame
  extends aqwt<aamd>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      VSConfigManager.getInstance().setValue("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      VSConfigManager.getInstance().setValue("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      VSConfigManager.getInstance().setValue("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public aamd a(int paramInt)
  {
    return new aamd();
  }
  
  @Nullable
  public aamd a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      aamd localaamd = aamd.a(paramArrayOfaqxa[0].a);
      if (localaamd == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)VSConfigManager.getInstance().getValue("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(localaamd.b())) && (!localaamd.b().equals(str)))
      {
        aams.a().a(localaamd);
        a(localaamd.b(), paramArrayOfaqxa[0].a);
      }
      return localaamd;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(aamd paramaamd)
  {
    if (paramaamd != null) {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + paramaamd.toString());
    }
  }
  
  public Class<aamd> clazz()
  {
    return aamd.class;
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
 * Qualified Name:     aame
 * JD-Core Version:    0.7.0.1
 */