import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AbsListView;

public class aime
  implements bhpo
{
  public aime(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      abqw.a().a("list_photo", false);
      return;
    }
    abqw.a().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aime
 * JD-Core Version:    0.7.0.1
 */