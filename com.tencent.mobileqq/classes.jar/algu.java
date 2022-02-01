import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherPreloadWebPageConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherPreloadWebPageConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/activity/weather/webpage/WeatherPreloadWebPageConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class algu
  extends aptq<algw>
{
  public static final algv a = new algv(null);
  
  @NotNull
  public algw a(int paramInt)
  {
    return new algw();
  }
  
  @Nullable
  public algw a(@Nullable aptx[] paramArrayOfaptx)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("WeatherPreloadWebPageConfigProcessor", 2, "onParsed");
    }
    algw localalgw = new algw();
    if (paramArrayOfaptx != null)
    {
      if (paramArrayOfaptx.length != 0) {
        break label68;
      }
      i = 1;
      if (i != 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        paramArrayOfaptx = paramArrayOfaptx[0].a;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfaptx, "confFiles[0].content");
        localalgw.a(paramArrayOfaptx);
      }
      return localalgw;
      i = 0;
      break;
    }
  }
  
  public void a(@Nullable algw paramalgw) {}
  
  @NotNull
  public Class<algw> clazz()
  {
    return algw.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 638;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algu
 * JD-Core Version:    0.7.0.1
 */