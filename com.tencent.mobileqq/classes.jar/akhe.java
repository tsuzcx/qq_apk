import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class akhe
  extends akhc
  implements akes
{
  private akhg jdField_a_of_type_Akhg;
  private Map<Long, Float> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private akhd b;
  
  public akhe()
  {
    this.jdField_a_of_type_Akev = new aker();
    ((aker)this.jdField_a_of_type_Akev).a(this);
  }
  
  public float a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return ((Float)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).floatValue();
    }
    return 0.0F;
  }
  
  public void a(akhd paramakhd)
  {
    this.b = paramakhd;
    ((aker)this.jdField_a_of_type_Akev).a(new akhf(this));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Akhg != null)) {
      this.jdField_a_of_type_Akhg.a(paramString);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Akhh == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay mInfo is null");
    }
    do
    {
      do
      {
        return false;
      } while (!super.b());
      this.jdField_a_of_type_Akhh.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay id:" + this.jdField_a_of_type_Akhh.jdField_a_of_type_Long + " set played flag");
      }
    } while ((this.jdField_a_of_type_Ahul == null) || (!this.jdField_a_of_type_Akhh.jdField_a_of_type_Boolean));
    String str = anni.a(2131715007) + atwl.a(this.jdField_a_of_type_Akhh.jdField_c_of_type_Long) + "/" + atwl.a(this.jdField_a_of_type_Akhh.jdField_b_of_type_Long) + ")";
    float f = (float)this.jdField_a_of_type_Akhh.jdField_c_of_type_Long / (float)this.jdField_a_of_type_Akhh.jdField_b_of_type_Long;
    this.b.a(this.jdField_a_of_type_Akhh.jdField_a_of_type_Long, f, str);
    this.jdField_a_of_type_Ahul.a(this.jdField_a_of_type_Akhh.jdField_a_of_type_Long, 11, null);
    return false;
  }
  
  public long c()
  {
    if (aker.class.isInstance(this.jdField_a_of_type_Akev)) {
      return ((aker)this.jdField_a_of_type_Akev).a();
    }
    return 0L;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Akhh == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause mInfo is null");
    }
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("PauseDebug", 1, "OnFileVideoPause : " + this.jdField_a_of_type_Akhh.jdField_a_of_type_Long);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause user set cancel,igon!");
      return;
    } while ((this.jdField_a_of_type_Int != 3) || (!this.jdField_a_of_type_Akhh.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Akhh.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Ahul == null));
    this.jdField_a_of_type_Akhh.jdField_c_of_type_Boolean = false;
    Bundle localBundle = new Bundle();
    localBundle.putFloat("progress", a(this.jdField_a_of_type_Akhh.jdField_a_of_type_Long));
    this.jdField_a_of_type_Ahul.a(this.jdField_a_of_type_Akhh.jdField_a_of_type_Long, 10, localBundle);
    this.jdField_a_of_type_Akev.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Akhh == null)
    {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel mInfo is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel id:" + this.jdField_a_of_type_Akhh.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Akev.a();
    this.jdField_a_of_type_Ahul.a(this.jdField_a_of_type_Akhh.jdField_a_of_type_Long, 12, null);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Akhh == null) {
      super.f();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "VideoPlayControllerForFile onItemClick");
      }
      if ((this.jdField_a_of_type_Akhh.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Akhh.jdField_a_of_type_Boolean) && (c()))
      {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "file[" + this.jdField_a_of_type_Akhh.jdField_a_of_type_Long + "] is downloading return!");
        return;
      }
      super.f();
    } while ((!this.jdField_a_of_type_Akhh.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Akhh.d) || (this.jdField_a_of_type_Akhh.jdField_a_of_type_ArrayOfJavaLangString.length <= 0) || (TextUtils.isEmpty(this.jdField_a_of_type_Akhh.jdField_a_of_type_ArrayOfJavaLangString[0])) || (this.jdField_a_of_type_Akev.a == null));
    b();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Akev != null) {
      this.jdField_a_of_type_Akev.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhe
 * JD-Core Version:    0.7.0.1
 */