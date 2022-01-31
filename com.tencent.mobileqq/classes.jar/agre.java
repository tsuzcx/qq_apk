import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class agre
  implements MessageQueue.IdleHandler
{
  public agre(AlbumListFragment paramAlbumListFragment, int paramInt1, int paramInt2) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "load Scroll Position,index:" + this.jdField_a_of_type_Int + " top:" + this.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListFragment.a.setSelectionFromTop(this.jdField_a_of_type_Int, this.b);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agre
 * JD-Core Version:    0.7.0.1
 */