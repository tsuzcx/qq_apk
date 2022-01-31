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

public class aksm
  implements Cloneable
{
  public static final Map<String, Integer> a;
  public static final String[] a;
  public int a;
  public long a;
  public String a;
  public HashMap<Integer, aksn> a;
  public boolean a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new ApolloDress.1();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { alud.a(2131700717), alud.a(2131700714), alud.a(2131700710), alud.a(2131700716), alud.a(2131700715), alud.a(2131700711), alud.a(2131700713) };
  }
  
  public static aksm a(String paramString)
  {
    boolean bool = true;
    aksm localaksm = new aksm();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Object localObject1 = localJSONObject.getJSONObject("role");
        localaksm.jdField_a_of_type_Int = ((JSONObject)localObject1).getInt("id");
        if (((JSONObject)localObject1).optInt("aiFlag", 0) == 1)
        {
          localaksm.jdField_a_of_type_Boolean = bool;
          localaksm.jdField_a_of_type_Long = ((JSONObject)localObject1).optLong("ts");
          localaksm.c = ((JSONObject)localObject1).optInt("feeType");
          localaksm.d = ((JSONObject)localObject1).optInt("tag");
          localaksm.b = localJSONObject.optInt("sex");
          localaksm.e = localJSONObject.optInt("belongCombId");
          localaksm.f = localJSONObject.optInt("combIsCollected");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDress", 2, "parseApolloDress data:" + paramString);
          }
          paramString = localJSONObject.getJSONArray("dresslist");
          int i = 0;
          if (i < paramString.length())
          {
            Object localObject2 = paramString.getJSONObject(i);
            localObject1 = new aksn();
            ((aksn)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("id");
            ((aksn)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("ts");
            ((aksn)localObject1).b = ((JSONObject)localObject2).optInt("feeType");
            ((aksn)localObject1).c = ((JSONObject)localObject2).optInt("tag");
            ((aksn)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            localObject2 = ((JSONObject)localObject2).getJSONArray("parts");
            int j = 0;
            if (j < ((JSONArray)localObject2).length())
            {
              ((aksn)localObject1).jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject2).getString(j));
              j += 1;
              continue;
            }
            if (localaksm.jdField_a_of_type_JavaUtilHashMap == null) {
              localaksm.jdField_a_of_type_JavaUtilHashMap = new HashMap();
            }
            localaksm.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((aksn)localObject1).jdField_a_of_type_Int), localObject1);
            i += 1;
            continue;
          }
          if ((localaksm.jdField_a_of_type_JavaUtilHashMap == null) || (localaksm.jdField_a_of_type_JavaUtilHashMap.size() < 7))
          {
            QLog.e("ApolloDress", 2, "parseApolloDress role dress do not complete :" + localJSONObject.toString());
            if (QLog.isColorLevel())
            {
              i = localaksm.jdField_a_of_type_Int;
              ThreadManager.getUIHandler().post(new ApolloDress.2(i));
            }
          }
          return localaksm;
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
  
  public static aksm a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while ((!paramJSONObject.has("role")) || (!paramJSONObject.has("dresslist"))) {
      return null;
    }
    aksm localaksm = new aksm();
    localaksm.b = paramJSONObject.optInt("sex");
    Object localObject1 = paramJSONObject.optJSONObject("role");
    if (localObject1 != null)
    {
      localaksm.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("id");
      localaksm.jdField_a_of_type_Long = ((JSONObject)localObject1).optLong("ts");
    }
    localObject1 = paramJSONObject.optJSONArray("dresslist");
    if (localObject1 != null)
    {
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        aksn localaksn = new aksn();
        localaksn.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("id");
        localaksn.jdField_a_of_type_Long = ((JSONObject)localObject2).optLong("ts");
        localaksn.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject2 = ((JSONObject)localObject2).optJSONArray("parts");
        int j = 0;
        while ((localObject2 != null) && (j < ((JSONArray)localObject2).length()))
        {
          localaksn.jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject2).optString(j));
          j += 1;
        }
        if (localaksm.jdField_a_of_type_JavaUtilHashMap == null) {
          localaksm.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        localaksm.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localaksn.jdField_a_of_type_Int), localaksn);
        i += 1;
      }
    }
    localaksm.jdField_a_of_type_JavaLangString = paramJSONObject.optString("faceData");
    return localaksm;
  }
  
  public static aksm b(String paramString)
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
      return aldv.a(this.jdField_a_of_type_Int);
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
      aksm localaksm = (aksm)super.clone();
      localObject = localaksm;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksm
 * JD-Core Version:    0.7.0.1
 */