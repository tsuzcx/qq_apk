import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import mqq.util.WeakReference;

public class agtl
  extends agrk
{
  boolean a;
  
  protected agtl(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static agrh b(AlbumListFragment paramAlbumListFragment)
  {
    if ((jdField_a_of_type_Agrh == null) || (jdField_a_of_type_Agrh.a.get() != paramAlbumListFragment)) {}
    try
    {
      if ((jdField_a_of_type_Agrh == null) || (jdField_a_of_type_Agrh.a.get() != paramAlbumListFragment)) {
        jdField_a_of_type_Agrh = new agtl(paramAlbumListFragment);
      }
      return jdField_a_of_type_Agrh;
    }
    finally {}
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", false);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Agrc.b = paramIntent.getIntExtra("PhotoConst.RECENT_IMAGES_MAX_COUNT", 100);
      this.jdField_a_of_type_Agrc.c = paramIntent.getIntExtra("PhotoConst.RECENT_IMAGES_LIMIT_SIZE", 0);
      this.jdField_a_of_type_Agrc.d = paramIntent.getIntExtra("PhotoConst.RECENT_IMAGES_LIMIT_WIDTH", -1);
      this.jdField_a_of_type_Agrc.a = paramIntent.getStringArrayListExtra("PhotoConst.RECENT_IMAGES_BLOCK_PATHS");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtl
 * JD-Core Version:    0.7.0.1
 */