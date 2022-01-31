import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.ApolloManager.21;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class aisf
  implements mzb
{
  public aisf(ApolloManager.21 param21) {}
  
  public void loaded(String paramString, int paramInt)
  {
    QLog.d("ApolloManager", 1, new Object[] { "[predownloadForGameCenter] offline pkg bid:", this.a.jdField_a_of_type_JavaLangString, " loaded, param=", paramString, ", code=", Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(this.a.b, this.a.jdField_a_of_type_Int).commit();
    }
    VipUtils.a(this.a.this$0.a, "cmshow", "Apollo", "gamecenter_preload_res_android", 0, paramInt, new String[] { this.a.jdField_a_of_type_JavaLangString, String.valueOf(this.a.jdField_a_of_type_Int) });
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisf
 * JD-Core Version:    0.7.0.1
 */