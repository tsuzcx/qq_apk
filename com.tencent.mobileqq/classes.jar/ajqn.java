import com.tencent.mobileqq.activity.photo.album.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajqn
  extends AlbumListAdapter
{
  long jdField_a_of_type_Long;
  private QQAlbumInfo jdField_a_of_type_ComTencentMobileqqDataQQAlbumInfo;
  
  public ajqn(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  private static void c(ajqo paramajqo, String paramString, QQAlbumInfo paramQQAlbumInfo)
  {
    String str = paramQQAlbumInfo.name;
    if (paramString.contains("/qq_collection/"))
    {
      paramajqo.f += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if ((str.equals("qq_images")) || (paramString.contains("/mobileqq/photo")) || (paramString.contains("/mobileqq/diskcache")))
    {
      paramajqo.g += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (str.equals("qqfile_recv"))
    {
      paramajqo.h += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (str.equals("qq_favorite"))
    {
      paramajqo.j += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (paramString.contains("/zebra/cache"))
    {
      paramajqo.i += 1;
      return;
    }
    if ((str.equals("weixin")) || (str.equals("wechat")) || (str.equals("micromsg")))
    {
      paramajqo.k += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (ajpv.a(paramString))
    {
      paramajqo.d += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    paramajqo.e += paramQQAlbumInfo.mMediaFileCount;
  }
  
  private static void d(ajqo paramajqo, String paramString, QQAlbumInfo paramQQAlbumInfo)
  {
    String str = paramQQAlbumInfo.name;
    if (str.equals("qq_screenshot"))
    {
      paramajqo.b += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if ((paramString.contains("screenshot")) || (paramString.contains("截屏")) || (paramString.contains("截图")) || (paramString.equals("screen_cap")) || (paramString.equals("ScreenCapture")))
    {
      paramajqo.c += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if ((str.contains("camera")) || (str.equals("dcim")) || (str.equals("100MEDIA")) || (str.equals("100ANDRO")) || (str.contains("相机")) || (str.contains("照片")) || (str.contains("相片")))
    {
      paramajqo.a += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (ajpv.a(paramString))
    {
      paramajqo.d += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    paramajqo.e += paramQQAlbumInfo.mMediaFileCount;
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
 * Qualified Name:     ajqn
 * JD-Core Version:    0.7.0.1
 */