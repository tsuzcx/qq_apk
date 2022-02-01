import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class afyv
  extends GestureDetector
{
  private VasAvatar a;
  
  public afyv(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    super(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public VasAvatar a()
  {
    return this.a;
  }
  
  public void a(VasAvatar paramVasAvatar)
  {
    this.a = paramVasAvatar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyv
 * JD-Core Version:    0.7.0.1
 */