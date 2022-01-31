import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

public class agfg
  implements View.OnClickListener
{
  public agfg(AlbumListFragment paramAlbumListFragment) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoListActivity)this.a.getActivity()).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfg
 * JD-Core Version:    0.7.0.1
 */