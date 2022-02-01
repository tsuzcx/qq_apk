import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

public class akho
  extends RecyclerView.OnScrollListener
{
  public akho(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      adcd.a().a("list_photo", false);
      return;
    }
    adcd.a().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akho
 * JD-Core Version:    0.7.0.1
 */