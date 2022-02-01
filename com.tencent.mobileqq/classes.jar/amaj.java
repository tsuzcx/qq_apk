import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebPageConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebPageConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebPageConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amaj
  extends aqkz<amal>
{
  public static final amak a = new amak(null);
  
  @NotNull
  public amal a(int paramInt)
  {
    return new amal();
  }
  
  @Nullable
  public amal a(@Nullable aqlg[] paramArrayOfaqlg)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("WeatherConfigProcessor", 2, "onParsed");
    }
    amal localamal = new amal();
    if (paramArrayOfaqlg != null)
    {
      if (paramArrayOfaqlg.length != 0) {
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
        paramArrayOfaqlg = paramArrayOfaqlg[0].a;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfaqlg, "confFiles[0].content");
        localamal.a(paramArrayOfaqlg);
      }
      return localamal;
      i = 0;
      break;
    }
  }
  
  public void a(@Nullable amal paramamal) {}
  
  @NotNull
  public Class<amal> clazz()
  {
    return amal.class;
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
    return 624;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amaj
 * JD-Core Version:    0.7.0.1
 */