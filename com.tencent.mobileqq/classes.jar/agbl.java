import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.widget.AbsListView;

public class agbl
  implements begh
{
  public agbl(PhotoListActivity paramPhotoListActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((PhotoListActivity.b(this.a)) && (paramInt == 0) && (this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView != null) && (this.a.jdField_a_of_type_Agbx != null) && (this.a.c != null)) {
      PhotoListActivity.a(this.a);
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
 * Qualified Name:     agbl
 * JD-Core Version:    0.7.0.1
 */