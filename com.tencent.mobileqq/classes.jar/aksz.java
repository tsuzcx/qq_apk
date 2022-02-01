import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

public class aksz
  extends RecyclerView.OnScrollListener
{
  public aksz(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      adlb.a().a("list_photo", false);
      return;
    }
    adlb.a().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksz
 * JD-Core Version:    0.7.0.1
 */