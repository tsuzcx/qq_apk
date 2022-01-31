import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import mqq.util.WeakReference;

public class agum
  extends agsl
{
  public agum(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static agse b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((a == null) || (a.a.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((a == null) || (a.a.get() != paramNewPhotoListActivity)) {
        a = new agum(paramNewPhotoListActivity);
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
 * Qualified Name:     agum
 * JD-Core Version:    0.7.0.1
 */