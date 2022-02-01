import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ajqf
  extends ajqd
  implements ajoc
{
  private ajqh jdField_a_of_type_Ajqh;
  private Map<Long, Float> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ajqe b;
  
  public ajqf()
  {
    this.jdField_a_of_type_Ajoe = new ajob();
    ((ajob)this.jdField_a_of_type_Ajoe).a(this);
  }
  
  public float a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return ((Float)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).floatValue();
    }
    return 0.0F;
  }
  
  public void a(ajqe paramajqe)
  {
    this.b = paramajqe;
    ((ajob)this.jdField_a_of_type_Ajoe).a(new ajqg(this));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Ajqh != null)) {
      this.jdField_a_of_type_Ajqh.a(paramString);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Ajqi == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay mInfo is null");
    }
    do
    {
      do
      {
        return false;
      } while (!super.b());
      this.jdField_a_of_type_Ajqi.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay id:" + this.jdField_a_of_type_Ajqi.jdField_a_of_type_Long + " set played flag");
      }
    } while ((this.jdField_a_of_type_Ahap == null) || (!this.jdField_a_of_type_Ajqi.jdField_a_of_type_Boolean));
    String str = amtj.a(2131715350) + FileUtil.filesizeToString(this.jdField_a_of_type_Ajqi.jdField_c_of_type_Long) + "/" + FileUtil.filesizeToString(this.jdField_a_of_type_Ajqi.jdField_b_of_type_Long) + ")";
    float f = (float)this.jdField_a_of_type_Ajqi.jdField_c_of_type_Long / (float)this.jdField_a_of_type_Ajqi.jdField_b_of_type_Long;
    this.b.a(this.jdField_a_of_type_Ajqi.jdField_a_of_type_Long, f, str);
    this.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_Ajqi.jdField_a_of_type_Long, 11, this.jdField_a_of_type_Ajqi.jdField_a_of_type_AndroidOsBundle);
    return false;
  }
  
  public long c()
  {
    if (ajob.class.isInstance(this.jdField_a_of_type_Ajoe)) {
      return ((ajob)this.jdField_a_of_type_Ajoe).a();
    }
    return 0L;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajqi == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause mInfo is null");
    }
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("PauseDebug", 1, "OnFileVideoPause : " + this.jdField_a_of_type_Ajqi.jdField_a_of_type_Long);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause user set cancel,igon!");
      return;
    } while ((this.jdField_a_of_type_Int != 3) || (!this.jdField_a_of_type_Ajqi.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Ajqi.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Ahap == null));
    this.jdField_a_of_type_Ajqi.jdField_c_of_type_Boolean = false;
    Bundle localBundle = new Bundle();
    localBundle.putFloat("progress", a(this.jdField_a_of_type_Ajqi.jdField_a_of_type_Long));
    this.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_Ajqi.jdField_a_of_type_Long, 10, localBundle);
    this.jdField_a_of_type_Ajoe.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ajqi == null)
    {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel mInfo is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel id:" + this.jdField_a_of_type_Ajqi.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Ajoe.a();
    this.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_Ajqi.jdField_a_of_type_Long, 12, this.jdField_a_of_type_Ajqi.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ajqi == null) {
      super.f();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "VideoPlayControllerForFile onItemClick");
      }
      if ((this.jdField_a_of_type_Ajqi.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Ajqi.jdField_a_of_type_Boolean) && (c()))
      {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "file[" + this.jdField_a_of_type_Ajqi.jdField_a_of_type_Long + "] is downloading return!");
        return;
      }
      super.f();
    } while ((!this.jdField_a_of_type_Ajqi.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Ajqi.d) || (this.jdField_a_of_type_Ajqi.jdField_a_of_type_ArrayOfJavaLangString.length <= 0) || (TextUtils.isEmpty(this.jdField_a_of_type_Ajqi.jdField_a_of_type_ArrayOfJavaLangString[0])) || (this.jdField_a_of_type_Ajoe.a == null));
    b();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Ajoe != null) {
      this.jdField_a_of_type_Ajoe.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqf
 * JD-Core Version:    0.7.0.1
 */