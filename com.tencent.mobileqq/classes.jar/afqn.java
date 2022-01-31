import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class afqn
  extends ampb<afsu>
{
  public int a()
  {
    return 438;
  }
  
  @NonNull
  public afsu a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new afsu();
  }
  
  @Nullable
  public afsu a(ampi[] paramArrayOfampi)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("ReportExposeConfigProcessor", 2, "onParsed :" + paramArrayOfampi);
      if (paramArrayOfampi != null)
      {
        j = paramArrayOfampi.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfampi[i];
          if (localObject1 != null) {
            QLog.d("ReportExposeConfigProcessor", 2, "onParsed item: " + ((ampi)localObject1).a);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      j = paramArrayOfampi.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfampi[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((ampi)localObject2).a))) {
          try
          {
            localObject1 = new afsu();
            localObject2 = new JSONObject(((ampi)localObject2).a);
            if (((JSONObject)localObject2).has("enable")) {
              ((afsu)localObject1).jdField_a_of_type_Boolean = ((JSONObject)localObject2).getBoolean("enable");
            }
            if (((JSONObject)localObject2).has("interval")) {
              ((afsu)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("interval");
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
  
  public Class<afsu> a()
  {
    return afsu.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(afsu paramafsu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onUpdate");
    }
    if (paramafsu != null) {
      ContactReportUtils.a(paramafsu);
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqn
 * JD-Core Version:    0.7.0.1
 */