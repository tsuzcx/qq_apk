import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import mqq.util.WeakReference;

public class agtk
  extends agrk
{
  protected agtk(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public static agrh b(AlbumListFragment paramAlbumListFragment)
  {
    if ((a == null) || (a.a.get() != paramAlbumListFragment)) {}
    try
    {
      if ((a == null) || (a.a.get() != paramAlbumListFragment)) {
        a = new agtk(paramAlbumListFragment);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtk
 * JD-Core Version:    0.7.0.1
 */