import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ahsr
  extends aokh<ahuz>
{
  public int a()
  {
    return 438;
  }
  
  @NonNull
  public ahuz a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new ahuz();
  }
  
  @Nullable
  public ahuz a(aoko[] paramArrayOfaoko)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("ReportExposeConfigProcessor", 2, "onParsed :" + paramArrayOfaoko);
      if (paramArrayOfaoko != null)
      {
        j = paramArrayOfaoko.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfaoko[i];
          if (localObject1 != null) {
            QLog.d("ReportExposeConfigProcessor", 2, "onParsed item: " + ((aoko)localObject1).a);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      j = paramArrayOfaoko.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfaoko[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((aoko)localObject2).a))) {
          try
          {
            localObject1 = new ahuz();
            localObject2 = new JSONObject(((aoko)localObject2).a);
            if (((JSONObject)localObject2).has("enable")) {
              ((ahuz)localObject1).jdField_a_of_type_Boolean = ((JSONObject)localObject2).getBoolean("enable");
            }
            if (((JSONObject)localObject2).has("interval")) {
              ((ahuz)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("interval");
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
  
  public Class<ahuz> a()
  {
    return ahuz.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(ahuz paramahuz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onUpdate");
    }
    if (paramahuz != null) {
      ContactReportUtils.a(paramahuz);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsr
 * JD-Core Version:    0.7.0.1
 */