import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URL;

@Deprecated
public class abgj
  extends AbstractImageAdapter
{
  public View a(URL paramURL, ViewGroup paramViewGroup)
  {
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      URLImageView localURLImageView = (URLImageView)paramViewGroup.getChildAt(i);
      Object localObject = localURLImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof URLDrawable)))
      {
        localObject = (URLDrawable)localObject;
        if ((((URLDrawable)localObject).getURL() != null) && (((URLDrawable)localObject).getURL().equals(paramURL))) {
          return localURLImageView;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public URLDrawable a(URL paramURL, ViewGroup paramViewGroup)
  {
    if (paramURL == null) {
      return null;
    }
    paramURL = paramURL.toString();
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      Object localObject = ((URLImageView)paramViewGroup.getChildAt(i)).getDrawable();
      if ((localObject != null) && ((localObject instanceof URLDrawable)))
      {
        localObject = (URLDrawable)localObject;
        if ((((URLDrawable)localObject).getURL() != null) && (((URLDrawable)localObject).getURL().toString().equals(paramURL)))
        {
          localObject = ((URLDrawable)localObject).getConstantState();
          if (localObject != null) {
            return (URLDrawable)((Drawable.ConstantState)localObject).newDrawable(paramViewGroup.getContext().getResources());
          }
        }
      }
      i += 1;
    }
    return null;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (URLImageView)paramView;
    URLDrawable localURLDrawable = (URLDrawable)paramView.getDrawable();
    if ((localURLDrawable.getStatus() != 1) && (localURLDrawable.getStatus() != 2))
    {
      int i = localURLDrawable.getProgress();
      if (i == 0) {
        return;
      }
      a(paramInt, i / 100);
      paramView.setMinimumHeight(10);
      paramView.setMinimumWidth(10);
      return;
    }
    if (localURLDrawable.getStatus() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool);
      break;
    }
  }
  
  protected void a(View paramView, URLDrawable paramURLDrawable)
  {
    if (!paramURLDrawable.isAnim()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setTag(2131296390, Boolean.valueOf(bool));
      String str = paramURLDrawable.getURL().toString();
      if ((paramURLDrawable.getStatus() == 1) && (bdsh.b(str)))
      {
        paramURLDrawable = bdsh.a(str);
        if ((paramURLDrawable != null) && (paramURLDrawable.exists())) {
          paramView.setTag(2131296389, Integer.valueOf(bgmo.d(paramURLDrawable.getAbsolutePath())));
        }
      }
      return;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    paramView = new URLImageView(paramViewGroup.getContext());
    paramView.setAdjustViewBounds(true);
    abgi localabgi = (abgi)getItem(paramInt);
    if (localabgi != null)
    {
      localObject = a(localabgi.a(), paramViewGroup);
      if (localObject != null) {
        break label198;
      }
      localObject = (URLDrawable)localabgi.b();
    }
    label198:
    for (;;)
    {
      paramView.setImageDrawable((Drawable)localObject);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 4) && (((URLDrawable)localObject).getStatus() != 2))
      {
        i = ((URLDrawable)localObject).getProgress();
        paramView.setURLDrawableDownListener(new abgk(this, paramInt, paramViewGroup));
        a(paramInt, i / 100);
      }
      while (localObject == null)
      {
        int i;
        localObject = paramView;
        break;
      }
      if (((URLDrawable)localObject).getStatus() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramInt, bool);
        a(paramView, (URLDrawable)localObject);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abgj
 * JD-Core Version:    0.7.0.1
 */