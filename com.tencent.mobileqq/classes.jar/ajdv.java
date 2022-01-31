import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajdv
{
  private static volatile ajdv jdField_a_of_type_Ajdv;
  private String jdField_a_of_type_JavaLangString = "https://i.gtimg.cn/channel/imglib/201907/upload_1988f0d818d7c94c1ff6476193401b15.zip";
  private boolean jdField_a_of_type_Boolean;
  
  public static ajdv a()
  {
    if (jdField_a_of_type_Ajdv == null) {}
    try
    {
      if (jdField_a_of_type_Ajdv == null) {
        jdField_a_of_type_Ajdv = new ajdv();
      }
      return jdField_a_of_type_Ajdv;
    }
    finally {}
  }
  
  public void a(ajdx paramajdx)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramajdx != null) {
        paramajdx.a(true);
      }
      return;
    }
    try
    {
      JSONObject localJSONObject = BaseHbFragment.getHbPannelConfig(10);
      if (localJSONObject != null) {
        this.jdField_a_of_type_JavaLangString = localJSONObject.optString("aLib", "https://i.gtimg.cn/channel/imglib/201907/upload_1988f0d818d7c94c1ff6476193401b15.zip");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TensorFlowlibManager", 2, "init libUrl=" + this.jdField_a_of_type_JavaLangString);
    }
    azmy.a().a("tensorflowlite_jni", new ajdw(this, paramajdx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdv
 * JD-Core Version:    0.7.0.1
 */