import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AbsListView;

class aioc
  implements bhpo
{
  aioc(aiob paramaiob) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((aiob.a(this.a)) && (paramInt == 0) && (((NewPhotoListActivity)this.a.mActivity).mGridView != null) && (((NewPhotoListActivity)this.a.mActivity).photoListAdapter != null) && (aiob.a(this.a).selectedMediaInfoHashMap != null)) {
      aiob.a(this.a);
    }
    if (paramInt == 0)
    {
      abqw.a().a("list_photo", false);
      return;
    }
    abqw.a().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioc
 * JD-Core Version:    0.7.0.1
 */