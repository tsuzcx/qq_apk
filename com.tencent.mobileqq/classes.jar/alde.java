import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZonePhotoWall;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.widget.PhotoWallView;
import java.util.ArrayList;

public class alde
  implements Runnable
{
  public alde(PhotoWallView paramPhotoWallView) {}
  
  public void run()
  {
    Object localObject = (QZonePhotoWall)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(QZonePhotoWall.class, this.a.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    this.a.a(((QZonePhotoWall)localObject).totalPic, ((QZonePhotoWall)localObject).hasMore, ((QZonePhotoWall)localObject).attachInfo, ((QZonePhotoWall)localObject).unpackPhotoWallData(), localArrayList);
    localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    ((Message)localObject).obj = localArrayList;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alde
 * JD-Core Version:    0.7.0.1
 */