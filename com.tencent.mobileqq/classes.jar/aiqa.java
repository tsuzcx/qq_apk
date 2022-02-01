import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aiqa
  extends aptq<aipv>
{
  @NonNull
  public aipv a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new aipv();
  }
  
  @Nullable
  public aipv a(aptx[] paramArrayOfaptx)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("ReportExposeConfigProcessor", 2, "onParsed :" + paramArrayOfaptx);
      if (paramArrayOfaptx != null)
      {
        j = paramArrayOfaptx.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfaptx[i];
          if (localObject1 != null) {
            QLog.d("ReportExposeConfigProcessor", 2, "onParsed item: " + ((aptx)localObject1).a);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      j = paramArrayOfaptx.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfaptx[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((aptx)localObject2).a))) {
          try
          {
            localObject1 = new aipv();
            localObject2 = new JSONObject(((aptx)localObject2).a);
            if (((JSONObject)localObject2).has("enable")) {
              ((aipv)localObject1).jdField_a_of_type_Boolean = ((JSONObject)localObject2).getBoolean("enable");
            }
            if (((JSONObject)localObject2).has("interval")) {
              ((aipv)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("interval");
            }
            return localObject1;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("ReportExposeConfigProcessor", 1, localThrowable, new Object[0]);
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void a(aipv paramaipv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onUpdate");
    }
    if (paramaipv != null) {
      ContactReportUtils.a(paramaipv);
    }
  }
  
  public Class<aipv> clazz()
  {
    return aipv.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 438;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqa
 * JD-Core Version:    0.7.0.1
 */