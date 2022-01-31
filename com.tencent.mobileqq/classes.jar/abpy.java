import android.content.Context;
import com.tencent.kingkong.Common;
import com.tencent.kingkong.PatchManager;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class abpy
  extends abqd
{
  private static String f = File.separator;
  private int jdField_a_of_type_Int;
  private ArrayList<abqc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int;
  private ArrayList<abpz> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int;
  private ArrayList<abqa> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<abqb> d;
  
  public abpy(String paramString1, String paramString2)
  {
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
  }
  
  private int a()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      abqc localabqc = (abqc)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localabqc.jdField_b_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_Int) || (localabqc.jdField_c_of_type_JavaUtilArrayList.size() != this.jdField_b_of_type_Int) || (localabqc.jdField_d_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_Int)) {
        abpt.a("KingKongNativePatch", "Skip fingerprint/hookpoint count mismatch subpatch " + i);
      }
      label294:
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        for (;;)
        {
          if (j >= this.jdField_a_of_type_Int) {
            break label294;
          }
          Object localObject = (abpz)this.jdField_b_of_type_JavaUtilArrayList.get(j);
          String str1 = ((abpz)localObject).jdField_a_of_type_JavaLangString;
          String str2 = ((abpz)localObject).jdField_b_of_type_JavaLangString;
          int k = ((abpz)localObject).jdField_a_of_type_Int;
          int m = ((Integer)localabqc.jdField_d_of_type_JavaUtilArrayList.get(j)).intValue();
          localObject = (String)localabqc.jdField_b_of_type_JavaUtilArrayList.get(j);
          if ((m == -1) || ("null".equals(localObject)))
          {
            abpt.a("KingKongNativePatch", "Skip null fingerprint ");
            if (j == this.jdField_a_of_type_Int - 1)
            {
              abpt.a("KingKongNativePatch", "Well done, all fingerprints matched!");
              return i;
            }
          }
          else
          {
            str1 = a(str1, str2, m, k);
            if ((str1 == null) || (!str1.equals(localObject))) {
              break;
            }
            abpt.a("KingKongNativePatch", "Matches fingerprint " + str1);
            if (j == this.jdField_a_of_type_Int - 1)
            {
              abpt.a("KingKongNativePatch", "Well done, all fingerprints matched!");
              return i;
            }
          }
          j += 1;
        }
      }
    }
    abpt.a("KingKongNativePatch", "Unable to get valid subpatch by offset!");
    return -1;
  }
  
  private int a(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 2;
    }
    return i;
  }
  
  public static abqd a(String paramString, abqe paramabqe)
  {
    paramString = new abpy(paramString, paramabqe.jdField_a_of_type_JavaLangString);
    if ((paramString.a(paramString.a())) && (paramString.b())) {
      return paramString;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = PatchManager.nativeGetFingerprint(paramString1, paramString2, paramInt1, paramInt2);
    if ((paramString1 != null) && (paramString1.length != 0)) {
      return abqg.a(paramString1);
    }
    return "";
  }
  
  private ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((abpz)this.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
      i += 1;
    }
    return localArrayList;
  }
  
  private boolean a(String paramString)
  {
    paramString = abqg.a(paramString);
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_c_of_type_JavaLangString = paramString.getString("name");
        this.jdField_d_of_type_JavaLangString = paramString.getString("ver");
        this.e = paramString.getString("type");
        JSONObject localJSONObject = paramString.getJSONObject("basic_group");
        this.jdField_a_of_type_Int = localJSONObject.getInt("fingerprint_count");
        this.jdField_c_of_type_Int = localJSONObject.getInt("param_count");
        this.jdField_b_of_type_Int = localJSONObject.getInt("hookpoint_count");
        abpt.a("KingKongNativePatch", "--> Fingerprint count : " + this.jdField_a_of_type_Int);
        abpt.a("KingKongNativePatch", "--> Parameter count : " + this.jdField_c_of_type_Int);
        abpt.a("KingKongNativePatch", "--> HookPoint count : " + this.jdField_b_of_type_Int);
        i = 0;
        if (i < this.jdField_b_of_type_Int)
        {
          localJSONObject = paramString.getJSONObject("hookpoint_definition_" + String.valueOf(i + 1));
          Object localObject = new abqa(this);
          if (!((abqa)localObject).a(localJSONObject)) {
            break;
          }
          abpt.a("KingKongNativePatch", "--> HookPoint : " + localObject);
          this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
          i += 1;
          continue;
          if (i >= this.jdField_a_of_type_Int) {
            break label510;
          }
          localJSONObject = paramString.getJSONObject("fingerprint_definition_" + String.valueOf(i + 1));
          localObject = new abpz(this);
          if (!((abpz)localObject).a(localJSONObject)) {
            break;
          }
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          abpt.a("KingKongNativePatch", "--> Fingerprint " + localObject);
          i += 1;
          continue;
          if (i < this.jdField_c_of_type_Int)
          {
            localJSONObject = paramString.getJSONObject("parameter_definition_" + String.valueOf(i + 1));
            localObject = new abqb(this);
            if (!((abqb)localObject).a(localJSONObject)) {
              break;
            }
            if (((abqb)localObject).jdField_a_of_type_Int != i)
            {
              abpt.a("KingKongNativePatch", "Parameter index error!");
              return false;
            }
            abpt.a("KingKongNativePatch", "--> Parameter definition : " + localObject);
            this.jdField_d_of_type_JavaUtilArrayList.add(localObject);
            i += 1;
            continue;
          }
          return true;
        }
      }
      catch (JSONException paramString)
      {
        abpt.a("KingKongNativePatch", "Parse sub patches failed : " + paramString);
        return false;
      }
      int i = 0;
      continue;
      label510:
      i = 0;
    }
    return false;
  }
  
  private int[] a()
  {
    int[] arrayOfInt1 = Common.a(this.jdField_c_of_type_JavaLangString);
    if (arrayOfInt1 == null)
    {
      abpt.a("KingKongNativePatch", "No GOT Hookpoint found");
      return null;
    }
    if (arrayOfInt1.length != this.jdField_b_of_type_Int)
    {
      abpt.a("KingKongNativePatch", "Got Hookpoint length mismatch " + this.jdField_b_of_type_Int + ", " + arrayOfInt1.length);
      return null;
    }
    int[] arrayOfInt2 = new int[this.jdField_b_of_type_Int];
    int i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      arrayOfInt2[i] = PatchManager.nativeCalcParameter(2, ((abqa)this.jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString, "", arrayOfInt1[i]);
      if (arrayOfInt2[i] == -1)
      {
        abpt.a("KingKongNativePatch", "Calculate GOT Hookpoint failed " + i);
        return null;
      }
      i += 1;
    }
    return arrayOfInt2;
  }
  
  private String b()
  {
    return this.jdField_b_of_type_JavaLangString + f + this.jdField_c_of_type_JavaLangString + ".subpatch";
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_JavaUtilArrayList = abqc.a(b());
    return this.jdField_a_of_type_JavaUtilArrayList != null;
  }
  
  private int[] b()
  {
    int[] arrayOfInt1 = Common.b(this.jdField_c_of_type_JavaLangString);
    if (arrayOfInt1 == null)
    {
      abpt.a("KingKongNativePatch", "No Jumper point found");
      return null;
    }
    if (arrayOfInt1.length != this.jdField_b_of_type_Int)
    {
      abpt.a("KingKongNativePatch", "Jumper point length mismatch " + this.jdField_b_of_type_Int + ", " + arrayOfInt1.length);
      return null;
    }
    int[] arrayOfInt2 = new int[this.jdField_b_of_type_Int];
    int i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      arrayOfInt2[i] = PatchManager.nativeCalcParameter(2, ((abqa)this.jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString, "", arrayOfInt1[i]);
      if (arrayOfInt2[i] == -1)
      {
        abpt.a("KingKongNativePatch", "Calculate Jumper point failed " + i);
        return null;
      }
      i += 1;
    }
    return arrayOfInt2;
  }
  
  public int a(Context paramContext)
  {
    abpt.a("KingKongNativePatch", "---> Patching " + this.jdField_c_of_type_JavaLangString + "  <-------");
    int i = Common.a(this.jdField_c_of_type_JavaLangString, a());
    if ((i == -1) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      abpt.a("KingKongNativePatch", "Unable to find valid subpatch index " + i);
      return 12;
    }
    paramContext = (abqc)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if ((paramContext.jdField_c_of_type_JavaUtilArrayList.size() != this.jdField_b_of_type_Int) || (this.jdField_c_of_type_JavaUtilArrayList.size() != this.jdField_b_of_type_Int))
    {
      abpt.a("KingKongNativePatch", "SubPatch Hookpoint count mismatch ");
      return 11;
    }
    int[] arrayOfInt1 = a();
    int[] arrayOfInt2 = b();
    if ((arrayOfInt1 == null) || (arrayOfInt2 == null))
    {
      abpt.a("KingKongNativePatch", "Unable to get GOT HookPoint or Jumper point");
      return 8;
    }
    int j = paramContext.jdField_a_of_type_Int;
    i = 0;
    if (i < this.jdField_b_of_type_Int)
    {
      Object localObject2 = (abqa)this.jdField_c_of_type_JavaUtilArrayList.get(i);
      Object localObject1 = paramContext.jdField_a_of_type_JavaUtilArrayList;
      int n = ((Integer)paramContext.jdField_c_of_type_JavaUtilArrayList.get(i)).intValue();
      int k = arrayOfInt2[i];
      int m = arrayOfInt1[i];
      int i1 = ((abqa)localObject2).jdField_a_of_type_Int;
      String str = ((abqa)localObject2).jdField_a_of_type_JavaLangString;
      localObject2 = ((abqa)localObject2).jdField_b_of_type_JavaLangString;
      if (n == -1) {
        abpt.a("KingKongNativePatch", "Skip empty hook point " + i);
      }
      do
      {
        i += 1;
        break;
        n = PatchManager.nativeCalcParameter(a(i1), str, (String)localObject2, n);
        if (n == -1)
        {
          abpt.a("KingKongNativePatch", "Calculate hookPoint failed");
          return 7;
        }
        localObject1 = a(this.jdField_d_of_type_JavaUtilArrayList, (ArrayList)localObject1);
        if (localObject1 == null) {
          return 6;
        }
      } while (PatchManager.nativeDoPatch(Common.b("lib" + this.jdField_c_of_type_JavaLangString + ".so"), str, (String)localObject2, n, k, m, (int[])localObject1, this.jdField_c_of_type_Int, j));
      abpt.a("KingKongNativePatch", "Native do patch failed");
      return 10;
    }
    abpt.a("KingKongNativePatch", "---> Do patch OK <----");
    return 0;
  }
  
  public boolean a()
  {
    int j = a();
    if (j == -1) {
      return false;
    }
    abpt.a("KingKongNativePatch", "Valid subpatch index : " + this.jdField_c_of_type_JavaLangString + " : " + j);
    int[] arrayOfInt1 = new int[this.jdField_b_of_type_Int];
    int[] arrayOfInt2 = new int[this.jdField_b_of_type_Int];
    int i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      String str = ((abqa)this.jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
      int k = PatchManager.nativeCalcJumperPoint(str);
      int m = PatchManager.nativeCalcGotHookPoint(str);
      if ((k == -1) || (m == -1))
      {
        abpt.a("KingKongNativePatch", "Calculate jumper/got point failed");
        return false;
      }
      abpt.a("KingKongNativePatch", "Patch params " + i + ", " + str + ", " + k + ", " + m);
      arrayOfInt1[i] = k;
      arrayOfInt2[i] = m;
      i += 1;
    }
    Common.a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, arrayOfInt1, arrayOfInt2);
    Common.a(this.jdField_c_of_type_JavaLangString, j, a());
    return true;
  }
  
  public int[] a(ArrayList<abqb> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    int[] arrayOfInt = new int[paramArrayList.size()];
    int i = 0;
    while (i < paramArrayList.size())
    {
      abqb localabqb = (abqb)paramArrayList.get(i);
      int j = ((Integer)paramArrayList1.get(i)).intValue();
      arrayOfInt[i] = PatchManager.nativeCalcParameter(localabqb.jdField_b_of_type_Int, localabqb.jdField_a_of_type_JavaLangString, localabqb.jdField_b_of_type_JavaLangString, j);
      if (arrayOfInt[i] == -1)
      {
        abpt.a("KingKongNativePatch", "Calculate parameter failed " + i);
        return null;
      }
      i += 1;
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpy
 * JD-Core Version:    0.7.0.1
 */