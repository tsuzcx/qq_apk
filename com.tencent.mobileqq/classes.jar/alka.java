import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class alka
  extends aqwt<aljz>
{
  public static aljz a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerBannerConfigProcessor", 2, "[loadConfig] configId: 698");
    }
    return (aljz)aqxe.a().a(698);
  }
  
  @NonNull
  public aljz a(int paramInt)
  {
    return new aljz();
  }
  
  @Nullable
  public aljz a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return aljz.a(paramArrayOfaqxa[0].a);
    }
    QLog.e("BeginnerBannerConfigProcessor", 1, "[onParsed] confFiles: " + Arrays.toString(paramArrayOfaqxa));
    return new aljz();
  }
  
  public void a(aljz paramaljz) {}
  
  public Class<aljz> clazz()
  {
    return aljz.class;
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
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("BeginnerBannerConfigProcessor", 1, "[onReqFailed] failCode: " + paramInt);
  }
  
  public int type()
  {
    return 698;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alka
 * JD-Core Version:    0.7.0.1
 */