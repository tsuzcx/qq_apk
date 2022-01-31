import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class afeq
  extends alzl<afgx>
{
  public int a()
  {
    return 438;
  }
  
  @NonNull
  public afgx a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new afgx();
  }
  
  @Nullable
  public afgx a(alzs[] paramArrayOfalzs)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("ReportExposeConfigProcessor", 2, "onParsed :" + paramArrayOfalzs);
      if (paramArrayOfalzs != null)
      {
        j = paramArrayOfalzs.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfalzs[i];
          if (localObject1 != null) {
            QLog.d("ReportExposeConfigProcessor", 2, "onParsed item: " + ((alzs)localObject1).a);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      j = paramArrayOfalzs.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfalzs[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((alzs)localObject2).a))) {
          try
          {
            localObject1 = new afgx();
            localObject2 = new JSONObject(((alzs)localObject2).a);
            if (((JSONObject)localObject2).has("enable")) {
              ((afgx)localObject1).jdField_a_of_type_Boolean = ((JSONObject)localObject2).getBoolean("enable");
            }
            if (((JSONObject)localObject2).has("interval")) {
              ((afgx)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("interval");
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
  
  public Class<afgx> a()
  {
    return afgx.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(afgx paramafgx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onUpdate");
    }
    if (paramafgx != null) {
      ContactReportUtils.a(paramafgx);
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
 * Qualified Name:     afeq
 * JD-Core Version:    0.7.0.1
 */