import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.DateUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class ahvs
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static ahvs a(SharedPreferences paramSharedPreferences, int paramInt)
  {
    String str2 = "bless_uin_list";
    String str1 = "bless_uin_list_time_millis";
    if (paramInt == 2)
    {
      str2 = "web_uin_list";
      str1 = "web_uin_list_time_millis";
    }
    ahvs localahvs = new ahvs();
    localahvs.jdField_a_of_type_Long = paramSharedPreferences.getLong(str1, 0L);
    if (DateUtils.isToday(localahvs.jdField_a_of_type_Long)) {
      try
      {
        paramSharedPreferences = paramSharedPreferences.getString(str2, "[]");
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "read uin list from mode=" + paramInt + " ,SP=" + paramSharedPreferences);
        }
        paramSharedPreferences = new JSONArray(paramSharedPreferences);
        paramInt = 0;
        while (paramInt + 1 < paramSharedPreferences.length())
        {
          localahvs.a(paramSharedPreferences.getString(paramInt), paramSharedPreferences.getInt(paramInt + 1));
          paramInt += 2;
          continue;
          localahvs.jdField_a_of_type_Long = System.currentTimeMillis();
        }
      }
      catch (Exception paramSharedPreferences)
      {
        paramSharedPreferences.printStackTrace();
        return null;
      }
    }
    return localahvs;
  }
  
  public static void a(SharedPreferences paramSharedPreferences, ahvs paramahvs, int paramInt)
  {
    paramahvs.a();
    Object localObject = new JSONArray();
    Iterator localIterator = paramahvs.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((JSONArray)localObject).put(localEntry.getKey());
      ((JSONArray)localObject).put(localEntry.getValue());
    }
    paramSharedPreferences = paramSharedPreferences.edit();
    localObject = ((JSONArray)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "save uin list to SP=" + (String)localObject);
    }
    if (paramInt == 2)
    {
      paramSharedPreferences.putString("web_uin_list", (String)localObject);
      paramSharedPreferences.putLong("web_uin_list_time_millis", paramahvs.jdField_a_of_type_Long);
    }
    for (;;)
    {
      paramSharedPreferences.commit();
      return;
      paramSharedPreferences.putString("bless_uin_list", (String)localObject);
      paramSharedPreferences.putLong("bless_uin_list_time_millis", paramahvs.jdField_a_of_type_Long);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int += paramInt;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap.size();
  }
  
  public void a()
  {
    if (!DateUtils.isToday(this.jdField_a_of_type_Long)) {
      b();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() + 1));
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvs
 * JD-Core Version:    0.7.0.1
 */