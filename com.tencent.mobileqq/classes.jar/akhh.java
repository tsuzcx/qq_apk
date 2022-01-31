import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class akhh
  implements bbpw
{
  akhh(akhf paramakhf, aymh paramaymh, Context paramContext, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    QLog.e("Theme.ThemeHandler", 1, "onQueryItemVer: " + paramInt + "," + paramString1 + "," + paramString2);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Aymh.a(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2);
      this.jdField_a_of_type_AndroidOsBundle.putString("themePath", this.jdField_a_of_type_Aymh.d());
      akhf.a(this.jdField_a_of_type_Akhf, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("themeId", "1000");
    this.jdField_a_of_type_AndroidOsBundle.remove("themePath");
    akhf.a(this.jdField_a_of_type_Akhf, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akhh
 * JD-Core Version:    0.7.0.1
 */