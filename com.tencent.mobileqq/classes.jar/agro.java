import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AbsListView;

public class agro
  implements bfos
{
  public agro(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      zzz.a().a("list_photo", false);
      return;
    }
    zzz.a().a("list_photo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agro
 * JD-Core Version:    0.7.0.1
 */