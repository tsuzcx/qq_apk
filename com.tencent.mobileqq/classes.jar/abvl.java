import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class abvl
{
  protected int a;
  protected String a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  protected String b;
  private Set<Integer> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private Set<String> c = new HashSet();
  
  public static abvl a(String paramString, JSONObject paramJSONObject)
  {
    if ("dex".equals(paramString))
    {
      if (!a(paramJSONObject)) {}
      do
      {
        return null;
        if (PatchCommonUtil.isDalvik()) {
          return new abvo(paramJSONObject);
        }
        if (PatchCommonUtil.isArtLM()) {
          return new abvn(paramJSONObject);
        }
      } while (!PatchCommonUtil.isArtGeN());
      return new abvm(paramJSONObject);
    }
    if ("Native".equals(paramString)) {
      return new abvp(paramJSONObject);
    }
    QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig createPatchItemConfig invalid patchType=" + paramString);
    return null;
  }
  
  private static boolean a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {
      return false;
    }
    Object localObject = paramJSONObject.optString("systemVersion", "");
    int i;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      i = 1;
    }
    for (;;)
    {
      localObject = paramJSONObject.optString("deviceInfo", "");
      int j;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        j = 1;
      }
      for (;;)
      {
        if ((i != 0) && (j != 0)) {}
        for (;;)
        {
          return bool;
          j = Build.VERSION.SDK_INT;
          localObject = ((String)localObject).split(";");
          if ((localObject == null) || (localObject.length <= 0)) {
            break label214;
          }
          int k = localObject.length;
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label214;
            }
            if (String.valueOf(j).equals(localObject[i]))
            {
              i = 1;
              break;
            }
            i += 1;
          }
          paramJSONObject = Build.BRAND + "-" + Build.MODEL;
          localObject = ((String)localObject).split(";");
          if ((localObject == null) || (localObject.length <= 0)) {
            break label209;
          }
          k = localObject.length;
          j = 0;
          for (;;)
          {
            if (j >= k) {
              break label209;
            }
            if (paramJSONObject.equals(localObject[j]))
            {
              j = 1;
              break;
            }
            j += 1;
          }
          bool = false;
        }
        label209:
        j = 0;
      }
      label214:
      i = 0;
    }
  }
  
  public String a()
  {
    Iterator localIterator;
    Object localObject;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("relaxEnable", this.jdField_a_of_type_Boolean);
      localJSONObject.put("nPatchEnable", this.jdField_b_of_type_Boolean);
      localStringBuilder = new StringBuilder("");
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.size() > 0))
      {
        localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localStringBuilder.append((String)localObject).append(";");
          }
        }
      }
      localJSONException.put("process", localStringBuilder.toString());
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PatchLogTag", 2, "AbscractPatchItemConfig writeToJsonString", localJSONException);
      }
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((this.jdField_b_of_type_JavaUtilSet != null) && (this.jdField_b_of_type_JavaUtilSet.size() > 0))
    {
      localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (Integer)localIterator.next();
        if (localObject != null) {
          localStringBuilder.append(((Integer)localObject).toString()).append(";");
        }
      }
    }
    localJSONException.put("systemVersion", localStringBuilder.toString());
    localStringBuilder = new StringBuilder("");
    if ((this.c != null) && (this.c.size() > 0))
    {
      localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localStringBuilder.append((String)localObject).append(";");
        }
      }
    }
    localJSONException.put("deviceInfo", localStringBuilder.toString());
    String str = localJSONException.toString();
    return str;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int k = 0;
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("relaxEnable", false);
    this.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("nPatchEnable", false);
    String[] arrayOfString = paramJSONObject.optString("process", "").split(";");
    int j;
    int i;
    String str;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilSet.add(str);
        }
        i += 1;
      }
    }
    arrayOfString = paramJSONObject.optString("systemVersion", "").split(";");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int m = arrayOfString.length;
      i = 0;
      for (;;)
      {
        if (i < m)
        {
          str = arrayOfString[i];
          try
          {
            j = Integer.parseInt(str);
            if (j > 0) {
              this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(j));
            }
            i += 1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              j = 0;
            }
          }
        }
      }
    }
    paramJSONObject = paramJSONObject.optString("deviceInfo", "").split(";");
    if ((paramJSONObject != null) && (paramJSONObject.length > 0))
    {
      j = paramJSONObject.length;
      i = k;
      while (i < j)
      {
        arrayOfString = paramJSONObject[i];
        if (!TextUtils.isEmpty(arrayOfString)) {
          this.c.add(arrayOfString);
        }
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilSet.size() > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString)))
    {
      QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig process not match");
      return false;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig patchName is null");
      return false;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig patchUrl is null");
      return false;
    }
    if (this.jdField_a_of_type_Int <= 0)
    {
      QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig patchSize is invalid");
      return false;
    }
    if ((this.jdField_b_of_type_JavaUtilSet.size() > 0) && (!this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(Build.VERSION.SDK_INT))))
    {
      QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig system version not match");
      return false;
    }
    if ((this.c.size() > 0) && (!this.c.contains(Build.BRAND + "-" + Build.MODEL)))
    {
      QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig device info not match");
      return false;
    }
    QLog.d("PatchLogTag", 1, "AbscractPatchItemConfig isValidConfig return true");
    return true;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abvl
 * JD-Core Version:    0.7.0.1
 */