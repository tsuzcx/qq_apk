import com.tencent.gdtad.views.image.GdtGifImageView;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;
import java.net.URL;

public class aapy
  implements aapx
{
  public aapy(GdtGifImageView paramGdtGifImageView) {}
  
  public void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (String str = paramURLDrawable.getURL().toString();; str = null)
    {
      aanp.b("GdtImageView", String.format("onLoadSuccessful %s", new Object[] { str }));
      GdtGifImageView.a(this.a, paramURLDrawable, str);
      if ((GdtGifImageView.a(this.a) != null) && (GdtGifImageView.a(this.a).get() != null) && (GdtGifImageView.a(this.a))) {
        ((aapz)GdtGifImageView.a(this.a).get()).a(true);
      }
      return;
    }
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (String str = paramURLDrawable.getURL().toString();; str = null)
    {
      aanp.b("GdtImageView", String.format("onLoadFailed %s", new Object[] { str }));
      GdtGifImageView.a(this.a, paramURLDrawable, str);
      if ((GdtGifImageView.a(this.a) != null) && (GdtGifImageView.a(this.a).get() != null)) {
        ((aapz)GdtGifImageView.a(this.a).get()).a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapy
 * JD-Core Version:    0.7.0.1
 */