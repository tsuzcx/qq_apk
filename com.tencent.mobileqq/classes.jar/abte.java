import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.mobileqq.bubble.ReversedNinePatchDrawable;

public final class abte
  extends Drawable.ConstantState
{
  public final NinePatch a;
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  public Drawable newDrawable()
  {
    return new ReversedNinePatchDrawable(null, this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new ReversedNinePatchDrawable(paramResources, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abte
 * JD-Core Version:    0.7.0.1
 */