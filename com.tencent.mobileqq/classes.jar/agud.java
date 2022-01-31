import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import mqq.util.WeakReference;

public class agud
  extends agsj
{
  protected agud(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static agsc b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((a == null) || (a.a.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((a == null) || (a.a.get() != paramNewPhotoListActivity)) {
        a = new agud(paramNewPhotoListActivity);
      }
      return a;
    }
    finally {}
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agud
 * JD-Core Version:    0.7.0.1
 */