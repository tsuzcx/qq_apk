import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

public class akmd
  extends RecyclerView.OnScrollListener
{
  public akmd(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      DropFrameMonitor.getInstance().stopMonitorScene("list_photo", false);
      return;
    }
    DropFrameMonitor.getInstance().startMonitorScene("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmd
 * JD-Core Version:    0.7.0.1
 */