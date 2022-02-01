import com.tencent.gdtad.views.image.GdtGifImageView;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;
import java.net.URL;

public class acxp
  implements acxo
{
  public acxp(GdtGifImageView paramGdtGifImageView) {}
  
  public void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (String str = paramURLDrawable.getURL().toString();; str = null)
    {
      acvc.b("GdtImageView", String.format("onLoadSuccessful %s", new Object[] { str }));
      if ((!GdtGifImageView.a(this.a)) || (!GdtGifImageView.b(this.a))) {
        GdtGifImageView.a(this.a, paramURLDrawable, str);
      }
      if ((GdtGifImageView.a(this.a) != null) && (GdtGifImageView.a(this.a).get() != null) && (GdtGifImageView.c(this.a))) {
        ((acxq)GdtGifImageView.a(this.a).get()).a(true);
      }
      return;
    }
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (String str = paramURLDrawable.getURL().toString();; str = null)
    {
      acvc.b("GdtImageView", String.format("onLoadFailed %s", new Object[] { str }));
      if ((!GdtGifImageView.a(this.a)) || (!GdtGifImageView.b(this.a))) {
        GdtGifImageView.a(this.a, paramURLDrawable, str);
      }
      if ((GdtGifImageView.a(this.a) != null) && (GdtGifImageView.a(this.a).get() != null)) {
        ((acxq)GdtGifImageView.a(this.a).get()).a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxp
 * JD-Core Version:    0.7.0.1
 */