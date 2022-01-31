import android.content.ContentResolver;
import android.content.Context;
import android.os.Looper;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;

public class ahpl
{
  private static ahpl jdField_a_of_type_Ahpl;
  private long jdField_a_of_type_Long;
  public agvr a;
  private String jdField_a_of_type_JavaLangString = "yyyy-MM-dd";
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer(25);
  private HashMap<String, HashMap<String, String>> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, Boolean> b = new HashMap();
  
  private ahpl()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    d();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (localBaseApplicationImpl != null) {
      localObject1 = localBaseApplicationImpl.getContentResolver();
    }
    try
    {
      localObject1 = Settings.System.getString((ContentResolver)localObject1, "date_format");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (this.jdField_a_of_type_JavaLangString = ((String)localObject1);; this.jdField_a_of_type_JavaLangString = "yyyy-MM-dd")
      {
        this.jdField_a_of_type_Agvr = new agvr(Looper.getMainLooper());
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public static ahpl a()
  {
    if (jdField_a_of_type_Ahpl == null) {}
    try
    {
      if (jdField_a_of_type_Ahpl == null) {
        jdField_a_of_type_Ahpl = new ahpl();
      }
      return jdField_a_of_type_Ahpl;
    }
    finally {}
  }
  
  private boolean a()
  {
    if (System.currentTimeMillis() >= this.jdField_a_of_type_Long)
    {
      d();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return false;
    }
    return true;
  }
  
  private void d()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String arg1, long paramLong)
  {
    HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(???);
    if ((localHashMap == null) || (!a()))
    {
      localHashMap = new HashMap();
      this.jdField_a_of_type_JavaUtilHashMap.put(???, localHashMap);
      ??? = null;
    }
    for (;;)
    {
      String str = ???;
      if (??? == null) {}
      synchronized (this.jdField_a_of_type_JavaLangStringBuffer)
      {
        str = bbkb.a(this.jdField_a_of_type_JavaLangStringBuffer, 1000L * paramLong, true, this.jdField_a_of_type_JavaLangString);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "getMsgDisplayTime, " + this.jdField_a_of_type_JavaLangStringBuffer.toString() + "," + str);
        }
        localHashMap.put(String.valueOf(paramLong), str);
        return str;
        ??? = (String)localHashMap.get(String.valueOf(paramLong));
        if (??? == null) {
          localHashMap.clear();
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agvr != null) {
      this.jdField_a_of_type_Agvr.g();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.b.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) {
      if (TextUtils.isEmpty(paramString)) {
        break label43;
      }
    }
    label43:
    for (this.jdField_a_of_type_JavaLangString = paramString;; this.jdField_a_of_type_JavaLangString = "yyyy-MM-dd")
    {
      bool = true;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      return bool;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Agvr != null) {
      this.jdField_a_of_type_Agvr.d();
    }
  }
  
  public boolean b(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Agvr != null) {
      this.jdField_a_of_type_Agvr.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpl
 * JD-Core Version:    0.7.0.1
 */