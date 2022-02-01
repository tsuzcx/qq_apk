import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajlp
  extends aqwt<ajlk>
{
  @NonNull
  public ajlk a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new ajlk();
  }
  
  @Nullable
  public ajlk a(aqxa[] paramArrayOfaqxa)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("ReportExposeConfigProcessor", 2, "onParsed :" + paramArrayOfaqxa);
      if (paramArrayOfaqxa != null)
      {
        j = paramArrayOfaqxa.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfaqxa[i];
          if (localObject1 != null) {
            QLog.d("ReportExposeConfigProcessor", 2, "onParsed item: " + ((aqxa)localObject1).a);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      j = paramArrayOfaqxa.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfaqxa[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((aqxa)localObject2).a))) {
          try
          {
            localObject1 = new ajlk();
            localObject2 = new JSONObject(((aqxa)localObject2).a);
            if (((JSONObject)localObject2).has("enable")) {
              ((ajlk)localObject1).jdField_a_of_type_Boolean = ((JSONObject)localObject2).getBoolean("enable");
            }
            if (((JSONObject)localObject2).has("interval")) {
              ((ajlk)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("interval");
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
  
  public void a(ajlk paramajlk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onUpdate");
    }
    if (paramajlk != null) {
      ContactReportUtils.a(paramajlk);
    }
  }
  
  public Class<ajlk> clazz()
  {
    return ajlk.class;
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
 * Qualified Name:     ajlp
 * JD-Core Version:    0.7.0.1
 */