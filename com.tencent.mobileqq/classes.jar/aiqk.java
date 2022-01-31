import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class aiqk
  extends aiqi
  implements ainy
{
  private aiqm jdField_a_of_type_Aiqm;
  private Map<Long, Float> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private aiqj b;
  
  public aiqk()
  {
    this.jdField_a_of_type_Aiob = new ainx();
    ((ainx)this.jdField_a_of_type_Aiob).a(this);
  }
  
  public float a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return ((Float)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).floatValue();
    }
    return 0.0F;
  }
  
  public void a(aiqj paramaiqj)
  {
    this.b = paramaiqj;
    ((ainx)this.jdField_a_of_type_Aiob).a(new aiql(this));
  }
  
  public void a(aiqm paramaiqm)
  {
    this.jdField_a_of_type_Aiqm = paramaiqm;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Aiqm != null)) {
      this.jdField_a_of_type_Aiqm.a(paramString);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Aiob != null) && ((this.jdField_a_of_type_Aiob instanceof ainx))) {
      ((ainx)this.jdField_a_of_type_Aiob).a(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aiqo == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay mInfo is null");
    }
    do
    {
      do
      {
        return false;
      } while (!super.b());
      this.jdField_a_of_type_Aiqo.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay id:" + this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long + " set played flag");
      }
    } while ((this.jdField_a_of_type_Agki == null) || (!this.jdField_a_of_type_Aiqo.jdField_a_of_type_Boolean));
    String str = alud.a(2131716730) + arso.a(this.jdField_a_of_type_Aiqo.jdField_c_of_type_Long) + "/" + arso.a(this.jdField_a_of_type_Aiqo.jdField_b_of_type_Long) + ")";
    float f = (float)this.jdField_a_of_type_Aiqo.jdField_c_of_type_Long / (float)this.jdField_a_of_type_Aiqo.jdField_b_of_type_Long;
    this.b.a(this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long, f, str);
    this.jdField_a_of_type_Agki.a(this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long, 11, null);
    return false;
  }
  
  public long c()
  {
    if (ainx.class.isInstance(this.jdField_a_of_type_Aiob)) {
      return ((ainx)this.jdField_a_of_type_Aiob).a();
    }
    return 0L;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aiqo == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause mInfo is null");
    }
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("PauseDebug", 1, "OnFileVideoPause : " + this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause user set cancel,igon!");
      return;
    } while ((this.jdField_a_of_type_Int != 3) || (!this.jdField_a_of_type_Aiqo.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Aiqo.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Agki == null));
    this.jdField_a_of_type_Aiqo.jdField_c_of_type_Boolean = false;
    Bundle localBundle = new Bundle();
    localBundle.putFloat("progress", a(this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long));
    this.jdField_a_of_type_Agki.a(this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long, 10, localBundle);
    this.jdField_a_of_type_Aiob.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aiqo == null)
    {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel mInfo is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel id:" + this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Aiob.a();
    this.jdField_a_of_type_Agki.a(this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long, 12, null);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Aiqo == null) {
      super.f();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "VideoPlayControllerForFile onItemClick");
      }
      if ((this.jdField_a_of_type_Aiqo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Aiqo.jdField_a_of_type_Boolean) && (c()))
      {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "file[" + this.jdField_a_of_type_Aiqo.jdField_a_of_type_Long + "] is downloading return!");
        return;
      }
      super.f();
    } while ((!this.jdField_a_of_type_Aiqo.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Aiqo.d) || (TextUtils.isEmpty(this.jdField_a_of_type_Aiqo.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Aiob.a == null));
    b();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Aiob != null) {
      this.jdField_a_of_type_Aiob.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqk
 * JD-Core Version:    0.7.0.1
 */