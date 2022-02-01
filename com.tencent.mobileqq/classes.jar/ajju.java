import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajju
  extends aqkz<ajjp>
{
  @NonNull
  public ajjp a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new ajjp();
  }
  
  @Nullable
  public ajjp a(aqlg[] paramArrayOfaqlg)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("ReportExposeConfigProcessor", 2, "onParsed :" + paramArrayOfaqlg);
      if (paramArrayOfaqlg != null)
      {
        j = paramArrayOfaqlg.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfaqlg[i];
          if (localObject1 != null) {
            QLog.d("ReportExposeConfigProcessor", 2, "onParsed item: " + ((aqlg)localObject1).a);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      j = paramArrayOfaqlg.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfaqlg[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((aqlg)localObject2).a))) {
          try
          {
            localObject1 = new ajjp();
            localObject2 = new JSONObject(((aqlg)localObject2).a);
            if (((JSONObject)localObject2).has("enable")) {
              ((ajjp)localObject1).jdField_a_of_type_Boolean = ((JSONObject)localObject2).getBoolean("enable");
            }
            if (((JSONObject)localObject2).has("interval")) {
              ((ajjp)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("interval");
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
  
  public void a(ajjp paramajjp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onUpdate");
    }
    if (paramajjp != null) {
      ContactReportUtils.a(paramajjp);
    }
  }
  
  public Class<ajjp> clazz()
  {
    return ajjp.class;
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
 * Qualified Name:     ajju
 * JD-Core Version:    0.7.0.1
 */