import android.content.Context;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARFacePreviewResample;
import com.tencent.mobileqq.ar.arengine.ARLocalControl;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.qphone.base.util.QLog;

public class aace
  implements Runnable
{
  public aace(ARLocalControl paramARLocalControl, int paramInt1, int paramInt2, Context paramContext, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, long paramLong) {}
  
  public void run()
  {
    if ((ARLocalControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl) & 0x4) != 0L)
    {
      ??? = new ARFacePreviewResample();
      ((ARFacePreviewResample)???).a(this.jdField_a_of_type_Int, this.b, 17);
      int i = ((ARFacePreviewResample)???).a();
      int j = ((ARFacePreviewResample)???).b();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a = new ARLocalFaceRecog();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a.a((ARFacePreviewResample)???);
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a.a(this.jdField_a_of_type_AndroidContentContext, i, j, this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a = null;
      }
    }
    synchronized (ARLocalControl.a())
    {
      ARLocalControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl, true);
      ARLocalControl.a().notifyAll();
      QLog.i("AREngine_ARLocalControl", 1, String.format("initFaceRecogAsync end. time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aace
 * JD-Core Version:    0.7.0.1
 */