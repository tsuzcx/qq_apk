import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;

public class akuc
  extends aksu
{
  boolean a;
  
  protected akuc(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", false);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Akst.recentImagesMaxCount = paramIntent.getIntExtra("PhotoConst.RECENT_IMAGES_MAX_COUNT", 100);
      this.jdField_a_of_type_Akst.recentImagesLimitSize = paramIntent.getIntExtra("PhotoConst.RECENT_IMAGES_LIMIT_SIZE", 0);
      this.jdField_a_of_type_Akst.recentImagesLimitWidth = paramIntent.getIntExtra("PhotoConst.RECENT_IMAGES_LIMIT_WIDTH", -1);
      this.jdField_a_of_type_Akst.recentImagesBlockPaths = paramIntent.getStringArrayListExtra("PhotoConst.RECENT_IMAGES_BLOCK_PATHS");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuc
 * JD-Core Version:    0.7.0.1
 */