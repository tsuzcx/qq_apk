import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import mqq.util.WeakReference;

public class aghj
  extends agfo
{
  protected aghj(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public static agfk b(AlbumListFragment paramAlbumListFragment)
  {
    if ((a == null) || (a.a.get() != paramAlbumListFragment)) {}
    try
    {
      if ((a == null) || (a.a.get() != paramAlbumListFragment)) {
        a = new aghj(paramAlbumListFragment);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghj
 * JD-Core Version:    0.7.0.1
 */