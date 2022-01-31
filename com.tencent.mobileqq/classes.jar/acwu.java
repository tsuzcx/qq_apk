import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class acwu
{
  public long a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  
  private acwu(FMSettings paramFMSettings) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 0).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, this.b + this.c);
    Object localObject = FMSettings.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, this.b + this.c);
    String str = FMSettings.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, this.b + this.c);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, paramContext);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, str);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, (String)localObject);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (acwu)this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a.get(localObject);
      if ((((acwu)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        FMSettings.a(2, "getDefaultStorage[" + ((acwu)localObject).b + "]");
        ((acwu)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwu
 * JD-Core Version:    0.7.0.1
 */