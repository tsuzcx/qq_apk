import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.qphone.base.util.QLog;

public class akfi
  implements Runnable
{
  public akfi(SnapshotService paramSnapshotService, Bitmap paramBitmap, akfm paramakfm, akfo paramakfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "ScreenShot Finish Callback");
    }
    SnapshotService.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Akfm, this.jdField_a_of_type_Akfo);
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService.a.post(new akfj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfi
 * JD-Core Version:    0.7.0.1
 */