import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/recent/guidebanner/NewerGuideBannerPreloadWebProcessConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/activity/recent/guidebanner/NewerGuideBannerPreloadWebProcessConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "isNeedUpgradeReset", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/activity/recent/guidebanner/NewerGuideBannerPreloadWebProcessConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class alkg
  extends aqwt<alki>
{
  public static final alkh a = new alkh(null);
  
  @NotNull
  public alki a(int paramInt)
  {
    return new alki();
  }
  
  @Nullable
  public alki a(@Nullable aqxa[] paramArrayOfaqxa)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewerBannerGuidePreloadWebProcessConfigProcessor", 2, "onParsed");
    }
    alki localalki = new alki();
    if (paramArrayOfaqxa != null)
    {
      if (paramArrayOfaqxa.length != 0) {
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
        paramArrayOfaqxa = paramArrayOfaqxa[0].a;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfaqxa, "confFiles[0].content");
        localalki.a(paramArrayOfaqxa);
      }
      return localalki;
      i = 0;
      break;
    }
  }
  
  public void a(@Nullable alki paramalki) {}
  
  @NotNull
  public Class<alki> clazz()
  {
    return alki.class;
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
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 699;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkg
 * JD-Core Version:    0.7.0.1
 */