import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class acck
  implements URLDrawable.URLDrawableListener
{
  public acck(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = bdhj.a(paramURLDrawable);
      QQAppInterface localQQAppInterface = this.a.app;
      paramURLDrawable = QQAppInterface.a(paramURLDrawable, 50, 50);
      this.a.a.setImageDrawable(new BitmapDrawable(paramURLDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acck
 * JD-Core Version:    0.7.0.1
 */