import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.qphone.base.util.QLog;

public class ajxu
  implements Runnable
{
  public ajxu(SnapshotService paramSnapshotService, Bitmap paramBitmap, ajxy paramajxy, ajya paramajya) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "ScreenShot Finish Callback");
    }
    SnapshotService.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Ajxy, this.jdField_a_of_type_Ajya);
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService.a.post(new ajxv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxu
 * JD-Core Version:    0.7.0.1
 */