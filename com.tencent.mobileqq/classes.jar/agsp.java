import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class agsp
{
  private static volatile agsp jdField_a_of_type_Agsp;
  private String jdField_a_of_type_JavaLangString = "https://i.gtimg.cn/channel/imglib/201907/upload_1988f0d818d7c94c1ff6476193401b15.zip";
  private boolean jdField_a_of_type_Boolean;
  
  public static agsp a()
  {
    if (jdField_a_of_type_Agsp == null) {}
    try
    {
      if (jdField_a_of_type_Agsp == null) {
        jdField_a_of_type_Agsp = new agsp();
      }
      return jdField_a_of_type_Agsp;
    }
    finally {}
  }
  
  public void a(agsr paramagsr)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramagsr != null) {
        paramagsr.a(true);
      }
      return;
    }
    try
    {
      localObject1 = BaseHbFragment.getHbPannelConfig(10);
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("aLib", "https://i.gtimg.cn/channel/imglib/201907/upload_1988f0d818d7c94c1ff6476193401b15.zip");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        localThrowable.printStackTrace();
        continue;
        Object localObject2 = null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TensorFlowlibManager", 2, "init libUrl=" + this.jdField_a_of_type_JavaLangString);
    }
    localObject1 = PreloadManager.a(this.jdField_a_of_type_JavaLangString, false, 1);
    if (!TextUtils.isEmpty(((ResourceInfo)localObject1).folderPath))
    {
      localObject1 = new File(((ResourceInfo)localObject1).folderPath, "libtensorflowlite_jni.so").getAbsolutePath();
      localObject1 = new besb().a(true).a((String)localObject1).a();
      besi.a().a("tensorflowlite_jni", new agsq(this, paramagsr), (besa)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agsp
 * JD-Core Version:    0.7.0.1
 */