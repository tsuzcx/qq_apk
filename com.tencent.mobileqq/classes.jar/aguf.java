import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AbsListView;
import mqq.util.WeakReference;

class aguf
  implements bfos
{
  aguf(ague paramague) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((ague.a(this.a)) && (paramInt == 0) && (((NewPhotoListActivity)this.a.a.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView != null) && (((NewPhotoListActivity)this.a.a.get()).jdField_a_of_type_Agrs != null) && (ague.a(this.a).a != null)) {
      ague.a(this.a);
    }
    if (paramInt == 0)
    {
      zzz.a().a("list_photo", false);
      return;
    }
    zzz.a().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aguf
 * JD-Core Version:    0.7.0.1
 */