import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;

class aazl
  implements nkm
{
  aazl(aazk paramaazk, long paramLong, Context paramContext, boolean paramBoolean, nkm paramnkm) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ViewPluginManager", 4, "transToLocalUrl transUrl:" + paramString);
    }
    this.jdField_a_of_type_Aazk.d = nko.a(this.jdField_a_of_type_Aazk.jdField_a_of_type_JavaLangString);
    String str = nku.a(this.jdField_a_of_type_Aazk.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_Aazk.jdField_a_of_type_JavaLangString + "/" + this.jdField_a_of_type_Aazk.b;
    try
    {
      Object localObject = new File(this.jdField_a_of_type_Aazk.c);
      if (!this.jdField_a_of_type_Aazk.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.jdField_a_of_type_Aazk.a(this.jdField_a_of_type_Aazk.jdField_a_of_type_JavaLangString), "-1").equals(this.jdField_a_of_type_Aazk.d))
      {
        if (!((File)localObject).exists()) {
          break label379;
        }
        bgmg.a(((File)localObject).getAbsolutePath());
        this.jdField_a_of_type_Aazk.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.jdField_a_of_type_Aazk.a(this.jdField_a_of_type_Aazk.jdField_a_of_type_JavaLangString), nko.a(this.jdField_a_of_type_Aazk.jdField_a_of_type_JavaLangString)).commit();
        ((File)localObject).mkdirs();
      }
      for (;;)
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = PluginUtils.getPluginLibPath(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aazk.b).getCanonicalPath();
        this.jdField_a_of_type_Aazk.jdField_a_of_type_JavaLangClassLoader = new DexClassLoader(str, this.jdField_a_of_type_Aazk.c, (String)localObject, this.jdField_a_of_type_AndroidContentContext.getClassLoader());
        this.jdField_a_of_type_Aazk.jdField_a_of_type_Aazf = new aazf(this.jdField_a_of_type_AndroidContentContext, 0, str, null, null, this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Nkm == null) {
          break;
        }
        this.jdField_a_of_type_Nkm.loaded(paramInt, paramString);
        return;
        label379:
        ((File)localObject).mkdirs();
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginManager", 2, "create classloader failed:" + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aazl
 * JD-Core Version:    0.7.0.1
 */