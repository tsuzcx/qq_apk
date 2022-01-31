import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

public class agrd
  implements View.OnClickListener
{
  public agrd(AlbumListFragment paramAlbumListFragment) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoListActivity)this.a.getActivity()).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrd
 * JD-Core Version:    0.7.0.1
 */