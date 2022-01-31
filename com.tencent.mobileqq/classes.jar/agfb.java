import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class agfb
  extends agez
{
  private Map<Long, Float> a;
  private agfa b;
  
  public agfb()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Agai = new afzt();
  }
  
  public float a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return ((Float)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).floatValue();
    }
    return 0.0F;
  }
  
  public void a(agfa paramagfa)
  {
    this.b = paramagfa;
    ((afzt)this.jdField_a_of_type_Agai).a(new agfc(this));
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Agfe == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay mInfo is null");
    }
    do
    {
      do
      {
        return false;
      } while (!super.b());
      this.jdField_a_of_type_Agfe.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay id:" + this.jdField_a_of_type_Agfe.jdField_a_of_type_Long + " set played flag");
      }
    } while ((this.jdField_a_of_type_Adye == null) || (!this.jdField_a_of_type_Agfe.jdField_a_of_type_Boolean));
    String str = ajjy.a(2131650544) + apdh.a(this.jdField_a_of_type_Agfe.jdField_c_of_type_Long) + "/" + apdh.a(this.jdField_a_of_type_Agfe.jdField_b_of_type_Long) + ")";
    float f = (float)this.jdField_a_of_type_Agfe.jdField_c_of_type_Long / (float)this.jdField_a_of_type_Agfe.jdField_b_of_type_Long;
    this.b.a(this.jdField_a_of_type_Agfe.jdField_a_of_type_Long, f, str);
    this.jdField_a_of_type_Adye.a(this.jdField_a_of_type_Agfe.jdField_a_of_type_Long, 11, null);
    return false;
  }
  
  public long c()
  {
    if (afzt.class.isInstance(this.jdField_a_of_type_Agai)) {
      return ((afzt)this.jdField_a_of_type_Agai).a();
    }
    return 0L;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Agfe == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause mInfo is null");
    }
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("PauseDebug", 1, "OnFileVideoPause : " + this.jdField_a_of_type_Agfe.jdField_a_of_type_Long);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause user set cancel,igon!");
      return;
    } while ((this.jdField_a_of_type_Int != 3) || (!this.jdField_a_of_type_Agfe.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Agfe.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Adye == null));
    this.jdField_a_of_type_Agfe.jdField_c_of_type_Boolean = false;
    Bundle localBundle = new Bundle();
    localBundle.putFloat("progress", a(this.jdField_a_of_type_Agfe.jdField_a_of_type_Long));
    this.jdField_a_of_type_Adye.a(this.jdField_a_of_type_Agfe.jdField_a_of_type_Long, 10, localBundle);
    this.jdField_a_of_type_Agai.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Agfe == null)
    {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel mInfo is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel id:" + this.jdField_a_of_type_Agfe.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Agai.a();
    this.jdField_a_of_type_Adye.a(this.jdField_a_of_type_Agfe.jdField_a_of_type_Long, 12, null);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Agfe == null) {
      super.f();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "VideoPlayControllerForFile onItemClick");
      }
      if ((this.jdField_a_of_type_Agfe.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Agfe.jdField_a_of_type_Boolean) && (c()))
      {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "file[" + this.jdField_a_of_type_Agfe.jdField_a_of_type_Long + "] is downloading return!");
        return;
      }
      super.f();
    } while ((!this.jdField_a_of_type_Agfe.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Agfe.d) || (TextUtils.isEmpty(this.jdField_a_of_type_Agfe.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Agai.a == null));
    b();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Agai != null) {
      this.jdField_a_of_type_Agai.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfb
 * JD-Core Version:    0.7.0.1
 */