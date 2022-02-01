import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajvd
  extends arac<ajuy>
{
  @NonNull
  public ajuy a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new ajuy();
  }
  
  @Nullable
  public ajuy a(araj[] paramArrayOfaraj)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("ReportExposeConfigProcessor", 2, "onParsed :" + paramArrayOfaraj);
      if (paramArrayOfaraj != null)
      {
        j = paramArrayOfaraj.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfaraj[i];
          if (localObject1 != null) {
            QLog.d("ReportExposeConfigProcessor", 2, "onParsed item: " + ((araj)localObject1).a);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      j = paramArrayOfaraj.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfaraj[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((araj)localObject2).a))) {
          try
          {
            localObject1 = new ajuy();
            localObject2 = new JSONObject(((araj)localObject2).a);
            if (((JSONObject)localObject2).has("enable")) {
              ((ajuy)localObject1).jdField_a_of_type_Boolean = ((JSONObject)localObject2).getBoolean("enable");
            }
            if (((JSONObject)localObject2).has("interval")) {
              ((ajuy)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("interval");
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
  
  public void a(ajuy paramajuy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onUpdate");
    }
    if (paramajuy != null) {
      ContactReportUtils.a(paramajuy);
    }
  }
  
  public Class<ajuy> clazz()
  {
    return ajuy.class;
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
 * Qualified Name:     ajvd
 * JD-Core Version:    0.7.0.1
 */