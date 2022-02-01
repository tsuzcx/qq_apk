import android.content.Intent;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;

public class akua
  extends aksu
{
  protected akua(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.mPhotoCommonData.filter.setSupportWebp(true);
  }
  
  public boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    int i;
    if (paramQQAlbumInfo._id.equals("$RecentAlbumId")) {
      i = 1;
    }
    for (;;)
    {
      bdll.b(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X800A917", "0X800A917", i, 0, "", "", "", "");
      return super.onItemClick(paramQQAlbumInfo, paramInt, paramIntent);
      if (paramQQAlbumInfo._id.equals("qzone_album")) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akua
 * JD-Core Version:    0.7.0.1
 */