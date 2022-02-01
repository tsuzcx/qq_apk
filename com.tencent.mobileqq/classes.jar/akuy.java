import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;

class akuy
  extends RecyclerView.OnScrollListener
{
  akuy(akux paramakux) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    if ((akux.a(this.a)) && (paramInt == 0) && (((NewPhotoListActivity)this.a.mActivity).mGridView != null) && (((NewPhotoListActivity)this.a.mActivity).photoListAdapter != null) && (akux.a(this.a).selectedMediaInfoHashMap != null)) {
      akux.a(this.a);
    }
    if (paramInt == 0)
    {
      adlb.a().a("list_photo", false);
      return;
    }
    adlb.a().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuy
 * JD-Core Version:    0.7.0.1
 */