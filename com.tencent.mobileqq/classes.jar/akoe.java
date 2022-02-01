import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;

class akoe
  extends RecyclerView.OnScrollListener
{
  akoe(akod paramakod) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    if ((akod.a(this.a)) && (paramInt == 0) && (((NewPhotoListActivity)this.a.mActivity).mGridView != null) && (((NewPhotoListActivity)this.a.mActivity).photoListAdapter != null) && (akod.a(this.a).selectedMediaInfoHashMap != null)) {
      akod.a(this.a);
    }
    if (paramInt == 0)
    {
      DropFrameMonitor.getInstance().stopMonitorScene("list_photo", false);
      return;
    }
    DropFrameMonitor.getInstance().startMonitorScene("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoe
 * JD-Core Version:    0.7.0.1
 */