import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class agqz
  extends agqx
{
  private Map<Long, Float> a;
  private agqy b;
  
  public agqz()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Agmg = new aglr();
  }
  
  public float a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return ((Float)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).floatValue();
    }
    return 0.0F;
  }
  
  public void a(agqy paramagqy)
  {
    this.b = paramagqy;
    ((aglr)this.jdField_a_of_type_Agmg).a(new agra(this));
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Agrc == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay mInfo is null");
    }
    do
    {
      do
      {
        return false;
      } while (!super.b());
      this.jdField_a_of_type_Agrc.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay id:" + this.jdField_a_of_type_Agrc.jdField_a_of_type_Long + " set played flag");
      }
    } while ((this.jdField_a_of_type_Aejd == null) || (!this.jdField_a_of_type_Agrc.jdField_a_of_type_Boolean));
    String str = ajyc.a(2131716335) + apvb.a(this.jdField_a_of_type_Agrc.jdField_c_of_type_Long) + "/" + apvb.a(this.jdField_a_of_type_Agrc.jdField_b_of_type_Long) + ")";
    float f = (float)this.jdField_a_of_type_Agrc.jdField_c_of_type_Long / (float)this.jdField_a_of_type_Agrc.jdField_b_of_type_Long;
    this.b.a(this.jdField_a_of_type_Agrc.jdField_a_of_type_Long, f, str);
    this.jdField_a_of_type_Aejd.a(this.jdField_a_of_type_Agrc.jdField_a_of_type_Long, 11, null);
    return false;
  }
  
  public long c()
  {
    if (aglr.class.isInstance(this.jdField_a_of_type_Agmg)) {
      return ((aglr)this.jdField_a_of_type_Agmg).a();
    }
    return 0L;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Agrc == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause mInfo is null");
    }
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("PauseDebug", 1, "OnFileVideoPause : " + this.jdField_a_of_type_Agrc.jdField_a_of_type_Long);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause user set cancel,igon!");
      return;
    } while ((this.jdField_a_of_type_Int != 3) || (!this.jdField_a_of_type_Agrc.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Agrc.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Aejd == null));
    this.jdField_a_of_type_Agrc.jdField_c_of_type_Boolean = false;
    Bundle localBundle = new Bundle();
    localBundle.putFloat("progress", a(this.jdField_a_of_type_Agrc.jdField_a_of_type_Long));
    this.jdField_a_of_type_Aejd.a(this.jdField_a_of_type_Agrc.jdField_a_of_type_Long, 10, localBundle);
    this.jdField_a_of_type_Agmg.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Agrc == null)
    {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel mInfo is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel id:" + this.jdField_a_of_type_Agrc.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Agmg.a();
    this.jdField_a_of_type_Aejd.a(this.jdField_a_of_type_Agrc.jdField_a_of_type_Long, 12, null);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Agrc == null) {
      super.f();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "VideoPlayControllerForFile onItemClick");
      }
      if ((this.jdField_a_of_type_Agrc.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Agrc.jdField_a_of_type_Boolean) && (c()))
      {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "file[" + this.jdField_a_of_type_Agrc.jdField_a_of_type_Long + "] is downloading return!");
        return;
      }
      super.f();
    } while ((!this.jdField_a_of_type_Agrc.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Agrc.d) || (TextUtils.isEmpty(this.jdField_a_of_type_Agrc.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Agmg.a == null));
    b();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Agmg != null) {
      this.jdField_a_of_type_Agmg.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agqz
 * JD-Core Version:    0.7.0.1
 */