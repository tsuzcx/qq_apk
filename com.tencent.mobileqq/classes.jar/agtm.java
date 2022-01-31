import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import mqq.util.WeakReference;

public class agtm
  extends agrm
{
  protected agtm(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public static agrj b(AlbumListFragment paramAlbumListFragment)
  {
    if ((a == null) || (a.a.get() != paramAlbumListFragment)) {}
    try
    {
      if ((a == null) || (a.a.get() != paramAlbumListFragment)) {
        a = new agtm(paramAlbumListFragment);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtm
 * JD-Core Version:    0.7.0.1
 */