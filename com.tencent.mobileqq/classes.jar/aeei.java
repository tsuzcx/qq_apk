import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.TroopShortcutbarFragment;
import com.tencent.util.Pair;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class aeei
  implements URLDrawable.URLDrawableListener
{
  public aeei(TroopShortcutbarFragment paramTroopShortcutbarFragment) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((paramURLDrawable.getCurrDrawable() instanceof RegionDrawable))
    {
      paramThrowable = this.a.a.iterator();
      while (paramThrowable.hasNext())
      {
        Pair localPair = (Pair)paramThrowable.next();
        if ((((URLDrawable)localPair.first).getURL().equals(paramURLDrawable.getURL())) && (localPair.second != null)) {
          ((URLImageView)localPair.second).setImageDrawable(this.a.getResources().getDrawable(2130843290));
        }
      }
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Drawable localDrawable = paramURLDrawable.getCurrDrawable();
    if ((localDrawable instanceof RegionDrawable))
    {
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if ((((URLDrawable)localPair.first).getURL().equals(paramURLDrawable.getURL())) && (localPair.second != null))
        {
          Bitmap localBitmap = ((RegionDrawable)localDrawable).getBitmap();
          ((URLImageView)localPair.second).setImageBitmap(localBitmap);
          ((URLImageView)localPair.second).setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeei
 * JD-Core Version:    0.7.0.1
 */