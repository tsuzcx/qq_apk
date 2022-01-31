import com.tencent.mobileqq.activity.photo.album.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aimd
  extends AlbumListAdapter
{
  long jdField_a_of_type_Long;
  private QQAlbumInfo jdField_a_of_type_ComTencentMobileqqDataQQAlbumInfo;
  
  public aimd(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "qzone_album";
    localQQAlbumInfo.name = "空间相册";
    localQQAlbumInfo.mMediaFileCount = ((int)this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListAdapter", 1, "setQzoneAlbumNum " + paramLong);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataQQAlbumInfo = localQQAlbumInfo;
  }
  
  public List<QQAlbumInfo> getDefaultAlbums()
  {
    List localList = super.getDefaultAlbums();
    if ((localList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataQQAlbumInfo != null)) {
      localList.add(0, this.jdField_a_of_type_ComTencentMobileqqDataQQAlbumInfo);
    }
    return localList;
  }
  
  public void setData()
  {
    super.setData();
    ThreadManager.post(new NewAlbumListAdapter.1(this), 2, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimd
 * JD-Core Version:    0.7.0.1
 */