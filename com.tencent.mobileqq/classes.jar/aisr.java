import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AbsListView;

class aisr
  implements bhtv
{
  aisr(aisq paramaisq) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((aisq.a(this.a)) && (paramInt == 0) && (((NewPhotoListActivity)this.a.mActivity).mGridView != null) && (((NewPhotoListActivity)this.a.mActivity).photoListAdapter != null) && (aisq.a(this.a).selectedMediaInfoHashMap != null)) {
      aisq.a(this.a);
    }
    if (paramInt == 0)
    {
      abvl.a().a("list_photo", false);
      return;
    }
    abvl.a().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisr
 * JD-Core Version:    0.7.0.1
 */