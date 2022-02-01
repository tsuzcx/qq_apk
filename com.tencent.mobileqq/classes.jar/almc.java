import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class almc
  extends aqwt<almb>
{
  @NonNull
  public almb a(int paramInt)
  {
    return new almb();
  }
  
  @Nullable
  public almb a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgBoxConfigProcessor", 2, "onParsed : " + paramArrayOfaqxa[0].a);
      }
      return almb.a(paramArrayOfaqxa[0].a);
    }
    return new almb();
  }
  
  public void a(almb paramalmb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxConfigProcessor", 2, "onUpdate : " + paramalmb);
    }
    ((almg)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramalmb);
  }
  
  public Class<almb> clazz()
  {
    return almb.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxConfigProcessor", 2, "onReqFailed : " + paramInt);
    }
  }
  
  public int type()
  {
    return 704;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almc
 * JD-Core Version:    0.7.0.1
 */