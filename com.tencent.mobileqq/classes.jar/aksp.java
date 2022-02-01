import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class aksp
  extends aksn
  implements akqd
{
  private aksr jdField_a_of_type_Aksr;
  private Map<Long, Float> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private akso b;
  
  public aksp()
  {
    this.jdField_a_of_type_Akqg = new akqc();
    ((akqc)this.jdField_a_of_type_Akqg).a(this);
  }
  
  public float a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return ((Float)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).floatValue();
    }
    return 0.0F;
  }
  
  public void a(akso paramakso)
  {
    this.b = paramakso;
    ((akqc)this.jdField_a_of_type_Akqg).a(new aksq(this));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Aksr != null)) {
      this.jdField_a_of_type_Aksr.a(paramString);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Akss == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay mInfo is null");
    }
    do
    {
      do
      {
        return false;
      } while (!super.b());
      this.jdField_a_of_type_Akss.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay id:" + this.jdField_a_of_type_Akss.jdField_a_of_type_Long + " set played flag");
      }
    } while ((this.jdField_a_of_type_Aidz == null) || (!this.jdField_a_of_type_Akss.jdField_a_of_type_Boolean));
    String str = anzj.a(2131715116) + auog.a(this.jdField_a_of_type_Akss.jdField_c_of_type_Long) + "/" + auog.a(this.jdField_a_of_type_Akss.jdField_b_of_type_Long) + ")";
    float f = (float)this.jdField_a_of_type_Akss.jdField_c_of_type_Long / (float)this.jdField_a_of_type_Akss.jdField_b_of_type_Long;
    this.b.a(this.jdField_a_of_type_Akss.jdField_a_of_type_Long, f, str);
    this.jdField_a_of_type_Aidz.a(this.jdField_a_of_type_Akss.jdField_a_of_type_Long, 11, null);
    return false;
  }
  
  public long c()
  {
    if (akqc.class.isInstance(this.jdField_a_of_type_Akqg)) {
      return ((akqc)this.jdField_a_of_type_Akqg).a();
    }
    return 0L;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Akss == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause mInfo is null");
    }
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("PauseDebug", 1, "OnFileVideoPause : " + this.jdField_a_of_type_Akss.jdField_a_of_type_Long);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause user set cancel,igon!");
      return;
    } while ((this.jdField_a_of_type_Int != 3) || (!this.jdField_a_of_type_Akss.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Akss.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Aidz == null));
    this.jdField_a_of_type_Akss.jdField_c_of_type_Boolean = false;
    Bundle localBundle = new Bundle();
    localBundle.putFloat("progress", a(this.jdField_a_of_type_Akss.jdField_a_of_type_Long));
    this.jdField_a_of_type_Aidz.a(this.jdField_a_of_type_Akss.jdField_a_of_type_Long, 10, localBundle);
    this.jdField_a_of_type_Akqg.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Akss == null)
    {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel mInfo is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel id:" + this.jdField_a_of_type_Akss.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Akqg.a();
    this.jdField_a_of_type_Aidz.a(this.jdField_a_of_type_Akss.jdField_a_of_type_Long, 12, null);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Akss == null) {
      super.f();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "VideoPlayControllerForFile onItemClick");
      }
      if ((this.jdField_a_of_type_Akss.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Akss.jdField_a_of_type_Boolean) && (c()))
      {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "file[" + this.jdField_a_of_type_Akss.jdField_a_of_type_Long + "] is downloading return!");
        return;
      }
      super.f();
    } while ((!this.jdField_a_of_type_Akss.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Akss.d) || (this.jdField_a_of_type_Akss.jdField_a_of_type_ArrayOfJavaLangString.length <= 0) || (TextUtils.isEmpty(this.jdField_a_of_type_Akss.jdField_a_of_type_ArrayOfJavaLangString[0])) || (this.jdField_a_of_type_Akqg.a == null));
    b();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Akqg != null) {
      this.jdField_a_of_type_Akqg.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksp
 * JD-Core Version:    0.7.0.1
 */