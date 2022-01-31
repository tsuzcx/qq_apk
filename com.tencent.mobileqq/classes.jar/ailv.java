import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ailv
  extends ailt
  implements aijj
{
  private ailx jdField_a_of_type_Ailx;
  private Map<Long, Float> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ailu b;
  
  public ailv()
  {
    this.jdField_a_of_type_Aijm = new aiji();
    ((aiji)this.jdField_a_of_type_Aijm).a(this);
  }
  
  public float a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return ((Float)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).floatValue();
    }
    return 0.0F;
  }
  
  public void a(ailu paramailu)
  {
    this.b = paramailu;
    ((aiji)this.jdField_a_of_type_Aijm).a(new ailw(this));
  }
  
  public void a(ailx paramailx)
  {
    this.jdField_a_of_type_Ailx = paramailx;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Ailx != null)) {
      this.jdField_a_of_type_Ailx.a(paramString);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Aijm != null) && ((this.jdField_a_of_type_Aijm instanceof aiji))) {
      ((aiji)this.jdField_a_of_type_Aijm).a(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Ailz == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay mInfo is null");
    }
    do
    {
      do
      {
        return false;
      } while (!super.b());
      this.jdField_a_of_type_Ailz.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay id:" + this.jdField_a_of_type_Ailz.jdField_a_of_type_Long + " set played flag");
      }
    } while ((this.jdField_a_of_type_Agft == null) || (!this.jdField_a_of_type_Ailz.jdField_a_of_type_Boolean));
    String str = alpo.a(2131716718) + arof.a(this.jdField_a_of_type_Ailz.jdField_c_of_type_Long) + "/" + arof.a(this.jdField_a_of_type_Ailz.jdField_b_of_type_Long) + ")";
    float f = (float)this.jdField_a_of_type_Ailz.jdField_c_of_type_Long / (float)this.jdField_a_of_type_Ailz.jdField_b_of_type_Long;
    this.b.a(this.jdField_a_of_type_Ailz.jdField_a_of_type_Long, f, str);
    this.jdField_a_of_type_Agft.a(this.jdField_a_of_type_Ailz.jdField_a_of_type_Long, 11, null);
    return false;
  }
  
  public long c()
  {
    if (aiji.class.isInstance(this.jdField_a_of_type_Aijm)) {
      return ((aiji)this.jdField_a_of_type_Aijm).a();
    }
    return 0L;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ailz == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause mInfo is null");
    }
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("PauseDebug", 1, "OnFileVideoPause : " + this.jdField_a_of_type_Ailz.jdField_a_of_type_Long);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause user set cancel,igon!");
      return;
    } while ((this.jdField_a_of_type_Int != 3) || (!this.jdField_a_of_type_Ailz.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Ailz.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Agft == null));
    this.jdField_a_of_type_Ailz.jdField_c_of_type_Boolean = false;
    Bundle localBundle = new Bundle();
    localBundle.putFloat("progress", a(this.jdField_a_of_type_Ailz.jdField_a_of_type_Long));
    this.jdField_a_of_type_Agft.a(this.jdField_a_of_type_Ailz.jdField_a_of_type_Long, 10, localBundle);
    this.jdField_a_of_type_Aijm.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ailz == null)
    {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel mInfo is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel id:" + this.jdField_a_of_type_Ailz.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Aijm.a();
    this.jdField_a_of_type_Agft.a(this.jdField_a_of_type_Ailz.jdField_a_of_type_Long, 12, null);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ailz == null) {
      super.f();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "VideoPlayControllerForFile onItemClick");
      }
      if ((this.jdField_a_of_type_Ailz.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Ailz.jdField_a_of_type_Boolean) && (c()))
      {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "file[" + this.jdField_a_of_type_Ailz.jdField_a_of_type_Long + "] is downloading return!");
        return;
      }
      super.f();
    } while ((!this.jdField_a_of_type_Ailz.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Ailz.d) || (TextUtils.isEmpty(this.jdField_a_of_type_Ailz.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Aijm.a == null));
    b();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Aijm != null) {
      this.jdField_a_of_type_Aijm.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailv
 * JD-Core Version:    0.7.0.1
 */