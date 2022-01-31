import android.content.Context;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;

public class albg
{
  public static boolean a;
  public static final float[] a;
  private albi jdField_a_of_type_Albi;
  private alxt jdField_a_of_type_Alxt;
  private alxx jdField_a_of_type_Alxx = new albh(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private float[] c;
  private float[] d = new float[4];
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(jdField_a_of_type_ArrayOfFloat, 0);
    jdField_a_of_type_Boolean = true;
  }
  
  public static boolean a()
  {
    String str = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.ARCfg.name());
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "";
      int i = DeviceProfileManager.a(str, arrayOfString, new ajve());
      boolean bool;
      if (i >= 1) {
        if (Integer.valueOf(arrayOfString[0]).intValue() == 1) {
          bool = true;
        }
      }
      for (;;)
      {
        QLog.i("AREngine_SensorTrackManager", 1, "arCfg = " + str + ", size = " + i + ", params[0] = " + arrayOfString[0] + ", isUseGameRotationVector = " + bool);
        return bool;
        bool = false;
        continue;
        bool = false;
      }
    }
    return false;
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(Context paramContext, albi paramalbi)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Albi = paramalbi;
    b();
    jdField_a_of_type_Boolean = this.jdField_a_of_type_Alxt.b();
    aliq.a().c(System.currentTimeMillis() - l);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      QLog.d("SensorTrackManager", 2, "enableSensor enabled: " + paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Alxt == null) {
      if (!a()) {
        break label57;
      }
    }
    label57:
    for (this.jdField_a_of_type_Alxt = new alxt(this.jdField_a_of_type_AndroidContentContext, 5);; this.jdField_a_of_type_Alxt = new alxt(this.jdField_a_of_type_AndroidContentContext, 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorTrackManager", 2, "startupSensor");
      }
      this.jdField_a_of_type_Alxt.a(this.jdField_a_of_type_Alxx, 1);
      return;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SensorTrackManager", 2, "stopSensor");
    }
    if (this.jdField_a_of_type_Alxt != null)
    {
      this.jdField_a_of_type_Alxt.a();
      this.jdField_a_of_type_Alxt = null;
    }
  }
  
  public void d()
  {
    a(false);
  }
  
  public void e()
  {
    c();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_Boolean = false;
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     albg
 * JD-Core Version:    0.7.0.1
 */