import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aizg
{
  private static volatile aizg jdField_a_of_type_Aizg;
  private String jdField_a_of_type_JavaLangString = "https://i.gtimg.cn/channel/imglib/201907/upload_1988f0d818d7c94c1ff6476193401b15.zip";
  private boolean jdField_a_of_type_Boolean;
  
  public static aizg a()
  {
    if (jdField_a_of_type_Aizg == null) {}
    try
    {
      if (jdField_a_of_type_Aizg == null) {
        jdField_a_of_type_Aizg = new aizg();
      }
      return jdField_a_of_type_Aizg;
    }
    finally {}
  }
  
  public void a(aizi paramaizi)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramaizi != null) {
        paramaizi.a(true);
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
    azip.a().a("tensorflowlite_jni", new aizh(this, paramaizi));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizg
 * JD-Core Version:    0.7.0.1
 */