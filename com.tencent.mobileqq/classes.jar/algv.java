import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import mqq.util.WeakReference;

public class algv
  extends agfo
{
  private algv(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public static agfk b(AlbumListFragment paramAlbumListFragment)
  {
    if ((a == null) || (a.a.get() != null)) {}
    try
    {
      if ((a == null) || (a.a.get() != null)) {
        a = new algv(paramAlbumListFragment);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     algv
 * JD-Core Version:    0.7.0.1
 */