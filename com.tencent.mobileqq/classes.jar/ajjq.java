import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.qphone.base.util.QLog;

public class ajjq
  implements Runnable
{
  public ajjq(SnapshotService paramSnapshotService, Bitmap paramBitmap, ajju paramajju, ajjw paramajjw) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "ScreenShot Finish Callback");
    }
    SnapshotService.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Ajju, this.jdField_a_of_type_Ajjw);
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService.a.post(new ajjr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajjq
 * JD-Core Version:    0.7.0.1
 */