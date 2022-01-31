import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.CircleBubbleImageView;
import java.net.URL;

class adzt
  extends CircleBubbleImageView
{
  URLDrawable a;
  URLDrawable b;
  
  public adzt(Context paramContext)
  {
    super(paramContext);
    a(true);
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (this.a != null) {
      this.a.setURLDrawableListener(null);
    }
    paramURLDrawable.setURLDrawableListener(this);
    this.a = paramURLDrawable;
    paramURLDrawable.startDownload();
  }
  
  public boolean a(String paramString)
  {
    return (this.b == null) || (!this.b.getURL().getPath().equals(paramString));
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    setImageDrawable(paramURLDrawable);
    if (this.b != paramURLDrawable) {
      this.b = paramURLDrawable;
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.a)
    {
      b(paramURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.a) {
      b(paramURLDrawable);
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.a != null)
    {
      this.a.setURLDrawableListener(null);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzt
 * JD-Core Version:    0.7.0.1
 */