import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ahoc
  extends aofy<ahqk>
{
  public int a()
  {
    return 438;
  }
  
  @NonNull
  public ahqk a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new ahqk();
  }
  
  @Nullable
  public ahqk a(aogf[] paramArrayOfaogf)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("ReportExposeConfigProcessor", 2, "onParsed :" + paramArrayOfaogf);
      if (paramArrayOfaogf != null)
      {
        j = paramArrayOfaogf.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfaogf[i];
          if (localObject1 != null) {
            QLog.d("ReportExposeConfigProcessor", 2, "onParsed item: " + ((aogf)localObject1).a);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      j = paramArrayOfaogf.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfaogf[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((aogf)localObject2).a))) {
          try
          {
            localObject1 = new ahqk();
            localObject2 = new JSONObject(((aogf)localObject2).a);
            if (((JSONObject)localObject2).has("enable")) {
              ((ahqk)localObject1).jdField_a_of_type_Boolean = ((JSONObject)localObject2).getBoolean("enable");
            }
            if (((JSONObject)localObject2).has("interval")) {
              ((ahqk)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("interval");
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
  
  public Class<ahqk> a()
  {
    return ahqk.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(ahqk paramahqk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onUpdate");
    }
    if (paramahqk != null) {
      ContactReportUtils.a(paramahqk);
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
 * Qualified Name:     ahoc
 * JD-Core Version:    0.7.0.1
 */