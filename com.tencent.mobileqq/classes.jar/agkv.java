import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class agkv
  implements MessageQueue.IdleHandler
{
  public agkv(AlbumListActivity paramAlbumListActivity, int paramInt1, int paramInt2) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "load Scroll Position,index:" + this.jdField_a_of_type_Int + " top:" + this.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListActivity.a.setSelectionFromTop(this.jdField_a_of_type_Int, this.b);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agkv
 * JD-Core Version:    0.7.0.1
 */