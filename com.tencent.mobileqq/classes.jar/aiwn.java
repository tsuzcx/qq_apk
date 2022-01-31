import com.tencent.mobileqq.apollo.data.ApolloDress.1;
import com.tencent.mobileqq.apollo.data.ApolloDress.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class aiwn
  implements Cloneable
{
  public static final Map<String, Integer> a;
  public static final String[] a;
  public int a;
  public long a;
  public String a;
  public HashMap<Integer, aiwo> a;
  public boolean a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ApolloDress.1();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { ajyc.a(2131700325), ajyc.a(2131700322), ajyc.a(2131700318), ajyc.a(2131700324), ajyc.a(2131700323), ajyc.a(2131700319), ajyc.a(2131700321) };
  }
  
  public static aiwn a(String paramString)
  {
    boolean bool = true;
    aiwn localaiwn = new aiwn();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Object localObject1 = localJSONObject.getJSONObject("role");
        localaiwn.jdField_a_of_type_Int = ((JSONObject)localObject1).getInt("id");
        if (((JSONObject)localObject1).optInt("aiFlag", 0) == 1)
        {
          localaiwn.jdField_a_of_type_Boolean = bool;
          localaiwn.jdField_a_of_type_Long = ((JSONObject)localObject1).optLong("ts");
          localaiwn.c = ((JSONObject)localObject1).optInt("feeType");
          localaiwn.d = ((JSONObject)localObject1).optInt("tag");
          localaiwn.b = localJSONObject.optInt("sex");
          localaiwn.e = localJSONObject.optInt("belongCombId");
          localaiwn.f = localJSONObject.optInt("combIsCollected");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDress", 2, "parseApolloDress data:" + paramString);
          }
          paramString = localJSONObject.getJSONArray("dresslist");
          int i = 0;
          if (i < paramString.length())
          {
            Object localObject2 = paramString.getJSONObject(i);
            localObject1 = new aiwo();
            ((aiwo)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("id");
            ((aiwo)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("ts");
            ((aiwo)localObject1).b = ((JSONObject)localObject2).optInt("feeType");
            ((aiwo)localObject1).c = ((JSONObject)localObject2).optInt("tag");
            ((aiwo)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            localObject2 = ((JSONObject)localObject2).getJSONArray("parts");
            int j = 0;
            if (j < ((JSONArray)localObject2).length())
            {
              ((aiwo)localObject1).jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject2).getString(j));
              j += 1;
              continue;
            }
            if (localaiwn.jdField_a_of_type_JavaUtilHashMap == null) {
              localaiwn.jdField_a_of_type_JavaUtilHashMap = new HashMap();
            }
            localaiwn.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((aiwo)localObject1).jdField_a_of_type_Int), localObject1);
            i += 1;
            continue;
          }
          if ((localaiwn.jdField_a_of_type_JavaUtilHashMap == null) || (localaiwn.jdField_a_of_type_JavaUtilHashMap.size() < 7))
          {
            QLog.e("ApolloDress", 2, "parseApolloDress role dress do not complete :" + localJSONObject.toString());
            if (QLog.isColorLevel())
            {
              i = localaiwn.jdField_a_of_type_Int;
              ThreadManager.getUIHandler().post(new ApolloDress.2(i));
            }
          }
          return localaiwn;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloDress", 2, "parseApolloDress failed", paramString);
        }
        return null;
      }
      bool = false;
    }
  }
  
  public static aiwn a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while ((!paramJSONObject.has("role")) || (!paramJSONObject.has("dresslist"))) {
      return null;
    }
    aiwn localaiwn = new aiwn();
    localaiwn.b = paramJSONObject.optInt("sex");
    Object localObject1 = paramJSONObject.optJSONObject("role");
    if (localObject1 != null)
    {
      localaiwn.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("id");
      localaiwn.jdField_a_of_type_Long = ((JSONObject)localObject1).optLong("ts");
    }
    localObject1 = paramJSONObject.optJSONArray("dresslist");
    if (localObject1 != null)
    {
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        aiwo localaiwo = new aiwo();
        localaiwo.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("id");
        localaiwo.jdField_a_of_type_Long = ((JSONObject)localObject2).optLong("ts");
        localaiwo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject2 = ((JSONObject)localObject2).optJSONArray("parts");
        int j = 0;
        while ((localObject2 != null) && (j < ((JSONArray)localObject2).length()))
        {
          localaiwo.jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject2).optString(j));
          j += 1;
        }
        if (localaiwn.jdField_a_of_type_JavaUtilHashMap == null) {
          localaiwn.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        localaiwn.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localaiwo.jdField_a_of_type_Int), localaiwo);
        i += 1;
      }
    }
    localaiwn.jdField_a_of_type_JavaLangString = paramJSONObject.optString("faceData");
    return localaiwn;
  }
  
  public static aiwn b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("petList");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = a(paramString.getJSONObject(0).toString());
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloPet", 2, "parseApolloPetDress failed", paramString);
      }
    }
    return null;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_Int + "|");
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = new TreeSet(this.jdField_a_of_type_JavaUtilHashMap.keySet()).iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(localIterator.next()).append("|");
      }
    }
    return localStringBuilder.toString();
  }
  
  public int[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.keySet().size() == 0)) {
      return ajhw.a(this.jdField_a_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet();
    int[] arrayOfInt = new int[((Set)localObject).size()];
    localObject = ((Set)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[i] = ((Integer)((Iterator)localObject).next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  protected Object clone()
  {
    Object localObject = null;
    try
    {
      aiwn localaiwn = (aiwn)super.clone();
      localObject = localaiwn;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      localObject.jdField_a_of_type_JavaUtilHashMap = ((HashMap)this.jdField_a_of_type_JavaUtilHashMap.clone());
    }
    return localObject;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ApolloDress{");
    localStringBuffer.append("roleId=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mRoleGender=").append(this.b);
    localStringBuffer.append(", roleTimeStamp=").append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", feeType=").append(this.c);
    localStringBuffer.append(", tag=").append(this.d);
    localStringBuffer.append(", isAIRole=").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", belongCombId=").append(this.e);
    localStringBuffer.append(", combIsCollected=").append(this.f);
    localStringBuffer.append(", faceData='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet();
      localStringBuffer.append(",ids [");
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuffer.append((Integer)((Iterator)localObject).next()).append(",");
      }
      localStringBuffer.append("]");
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiwn
 * JD-Core Version:    0.7.0.1
 */