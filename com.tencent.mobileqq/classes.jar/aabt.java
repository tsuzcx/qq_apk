import android.graphics.Bitmap;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.mobileqq.arcard.ARCardUtils;
import java.io.File;

public class aabt
  implements Runnable
{
  public aabt(AREngine paramAREngine, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a())) {
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).a(null, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 1001)
      {
        Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaLangObject;
        ARCardUtils.a(localBitmap, new File("/sdcard/test/ARCloudSucessResult.jpg"), true);
        localBitmap.recycle();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabt
 * JD-Core Version:    0.7.0.1
 */