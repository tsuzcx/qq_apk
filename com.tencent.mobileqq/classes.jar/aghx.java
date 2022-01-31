import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AbsListView;
import mqq.util.WeakReference;

class aghx
  implements begh
{
  aghx(aghw paramaghw) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((aghw.a(this.a)) && (paramInt == 0) && (((NewPhotoListActivity)this.a.a.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView != null) && (((NewPhotoListActivity)this.a.a.get()).jdField_a_of_type_Agfv != null) && (aghw.a(this.a).a != null)) {
      aghw.a(this.a);
    }
    if (paramInt == 0)
    {
      zqk.a().a("list_photo", false);
      return;
    }
    zqk.a().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghx
 * JD-Core Version:    0.7.0.1
 */