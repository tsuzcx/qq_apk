import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;

public class abqk
{
  public static float a;
  public static int a;
  public static SparseArray<abql> a;
  public static boolean a;
  public static final int[] a;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  public static boolean g;
  public static boolean h;
  public static boolean i;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 101, 102, 103, 104, 105, 106, 107, 108, 109, 119, 121, 123, 124, 126, 129 };
    jdField_a_of_type_Boolean = true;
    b = true;
    c = true;
    d = true;
    e = true;
    f = true;
    g = true;
    h = true;
    i = true;
    jdField_a_of_type_Float = 0.1F;
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(6);
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new abql(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new abql(0.001F, 100, 10, 0.01F, 0));
    jdField_a_of_type_AndroidUtilSparseArray.put(6, new abql(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(7, new abql(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(14, new abql(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(9, new abql(0.001F, 85, 10, 0.1F, 6));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new abql(0.001F, 100, 10, 0.1F, 6));
    jdField_a_of_type_Int = 100;
  }
  
  public static void a()
  {
    boolean bool2 = true;
    abqr.a();
    if (MagnifierSDK.jdField_a_of_type_Abrd != null)
    {
      SparseArray localSparseArray = MagnifierSDK.jdField_a_of_type_Abrd.a();
      if ((localSparseArray != null) && (localSparseArray.size() > 0)) {
        jdField_a_of_type_AndroidUtilSparseArray = localSparseArray;
      }
    }
    if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      int j = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("config_reporter_type", 0);
      if (j > 0) {
        ReporterMachine.a(j);
      }
      j = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getInt("config_switch", 0);
      if (j > 0)
      {
        if ((j & 0x1) <= 0) {
          break label167;
        }
        bool1 = true;
        jdField_a_of_type_Boolean = bool1;
        if ((j & 0x2) <= 0) {
          break label172;
        }
        bool1 = true;
        label95:
        b = bool1;
        if ((j & 0x4) <= 0) {
          break label177;
        }
        bool1 = true;
        label107:
        c = bool1;
        if ((j & 0x8) <= 0) {
          break label182;
        }
        bool1 = true;
        label120:
        g = bool1;
        if ((j & 0x10) <= 0) {
          break label187;
        }
        bool1 = true;
        label133:
        h = bool1;
        if ((j & 0x20) <= 0) {
          break label192;
        }
      }
    }
    label167:
    label172:
    label177:
    label182:
    label187:
    label192:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      i = bool1;
      try
      {
        jdField_a_of_type_Float = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences.getFloat("inspectrate", jdField_a_of_type_Float);
        return;
      }
      catch (Exception localException) {}
      bool1 = false;
      break;
      bool1 = false;
      break label95;
      bool1 = false;
      break label107;
      bool1 = false;
      break label120;
      bool1 = false;
      break label133;
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Config", 2, "loadLocalConfigsparseConfig obj=" + paramJSONObject + "");
    }
    if (paramJSONObject.getInt("pid") != MagnifierSDK.jdField_a_of_type_Int) {}
    label145:
    label159:
    label173:
    label188:
    label203:
    label250:
    do
    {
      return;
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        int j;
        boolean bool;
        float f1;
        if ("host".equals(str))
        {
          j = paramJSONObject.getInt(str);
          ReporterMachine.a(j);
          if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null) {
            MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("config_reporter_type", j);
          }
        }
        else
        {
          if ("switch".equals(str))
          {
            j = paramJSONObject.getInt(str);
            if ((j & 0x1) > 0)
            {
              bool = true;
              jdField_a_of_type_Boolean = bool;
              if ((j & 0x2) <= 0) {
                break label250;
              }
              bool = true;
              b = bool;
              if ((j & 0x4) <= 0) {
                break label256;
              }
              bool = true;
              c = bool;
              if ((j & 0x8) <= 0) {
                break label262;
              }
              bool = true;
              g = bool;
              if ((j & 0x10) <= 0) {
                break label268;
              }
              bool = true;
              h = bool;
              if ((j & 0x20) <= 0) {
                break label274;
              }
            }
            for (bool = true;; bool = false)
            {
              i = bool;
              if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor == null) {
                break;
              }
              MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("config_switch", j);
              break;
              bool = false;
              break label145;
              bool = false;
              break label159;
              bool = false;
              break label173;
              bool = false;
              break label188;
              bool = false;
              break label203;
            }
          }
          if ("inspectrate".equals(str)) {
            try
            {
              jdField_a_of_type_Float = Float.valueOf(paramJSONObject.getString("inspectrate")).floatValue();
              if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor == null) {
                continue;
              }
              MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putFloat("inspectrate", jdField_a_of_type_Float);
            }
            catch (Exception localException1) {}
          } else if ("gsample".equals(localException1)) {
            f1 = 0.0F;
          }
        }
        try
        {
          f2 = Float.valueOf(paramJSONObject.getString("gsample")).floatValue();
          f1 = f2;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            float f2;
            Object localObject;
            int n;
            abql localabql;
            int k;
            int m;
            continue;
            continue;
            continue;
            continue;
          }
        }
        if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null)
        {
          localObject = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor;
          if (f1 >= Math.random()) {}
          for (bool = true;; bool = false)
          {
            ((SharedPreferences.Editor)localObject).putBoolean("qapm_enable", bool);
            break;
          }
          if (((String)localObject).startsWith("p_"))
          {
            n = Integer.parseInt(((String)localObject).replace("p_", ""));
            localabql = (abql)jdField_a_of_type_AndroidUtilSparseArray.get(n);
            f1 = localabql.jdField_a_of_type_Float;
            j = localabql.jdField_a_of_type_Int;
            k = localabql.jdField_b_of_type_Int;
            f2 = localabql.jdField_b_of_type_Float;
            m = localabql.c;
            localObject = paramJSONObject.getString((String)localObject).split(",");
            if (localObject.length >= 5)
            {
              if (TextUtils.isEmpty(localObject[0])) {
                break label669;
              }
              f1 = Float.parseFloat(localObject[0]);
              if (TextUtils.isEmpty(localObject[1])) {
                break label666;
              }
              j = Integer.parseInt(localObject[1]);
              if (TextUtils.isEmpty(localObject[2])) {
                break label663;
              }
              k = Integer.parseInt(localObject[2]);
              if (TextUtils.isEmpty(localObject[3])) {
                break label660;
              }
              f2 = Float.parseFloat(localObject[3]);
              if (TextUtils.isEmpty(localObject[4])) {
                break label657;
              }
              m = Integer.parseInt(localObject[4]);
              localObject = new abql(f1, j, k, f2, m);
              jdField_a_of_type_AndroidUtilSparseArray.setValueAt(jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(n), localObject);
            }
          }
        }
      }
      if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null) {
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      }
    } while (MagnifierSDK.jdField_a_of_type_Abrd == null);
    label256:
    label262:
    label268:
    label274:
    MagnifierSDK.jdField_a_of_type_Abrd.a(jdField_a_of_type_AndroidUtilSparseArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqk
 * JD-Core Version:    0.7.0.1
 */