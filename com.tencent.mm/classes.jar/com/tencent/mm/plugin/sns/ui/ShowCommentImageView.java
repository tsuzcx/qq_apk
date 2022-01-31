package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;

public class ShowCommentImageView
  extends ImageView
{
  private static Bitmap oTi;
  private static Bitmap oTj;
  private static Field oTk;
  private static Field oTl;
  private static boolean oTm = false;
  private boolean oTh = false;
  
  public ShowCommentImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ShowCommentImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void F(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (;;)
    {
      try
      {
        Field localField = oTk;
        if (paramBoolean2)
        {
          localField.set(this, null);
          return;
          localField = oTl;
          continue;
        }
        if (paramBoolean1)
        {
          localBitmap = oTj;
          if (localBitmap != null) {
            break label108;
          }
          paramBoolean2 = true;
          y.d("MicroMsg.ShowCommentImageView", "setDrawingCache, autoScale: %s, cache==null: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
          if (localBitmap == null) {
            break;
          }
          localField.set(this, localBitmap);
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[] { localException.getMessage() });
        return;
      }
      Bitmap localBitmap = oTi;
      continue;
      label108:
      paramBoolean2 = false;
    }
  }
  
  private static void init()
  {
    if ((oTk != null) && (oTl != null)) {
      return;
    }
    try
    {
      oTk = View.class.getDeclaredField("mDrawingCache");
      oTl = View.class.getDeclaredField("mUnscaledDrawingCache");
      oTk.setAccessible(true);
      oTl.setAccessible(true);
      oTm = true;
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ShowCommentImageView", "init error: %s", new Object[] { localException.getMessage() });
      oTm = false;
    }
  }
  
  private boolean js(boolean paramBoolean)
  {
    if (!oTm) {
      return false;
    }
    if (paramBoolean) {}
    try
    {
      for (Field localField = oTk; (Bitmap)localField.get(this) != null; localField = oTl) {
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.ShowCommentImageView", localException, "", new Object[0]);
      y.e("MicroMsg.ShowCommentImageView", "checkIfCanReuseDrawingCache error: %s", new Object[] { localException.getMessage() });
    }
    return false;
  }
  
  public void buildDrawingCache(boolean paramBoolean)
  {
    Object localObject;
    if (oTm) {
      if (!this.oTh) {
        if (!js(paramBoolean))
        {
          if (paramBoolean) {}
          for (localObject = oTj; (localObject != null) && (!((Bitmap)localObject).isRecycled()); localObject = oTi)
          {
            F(paramBoolean, false);
            return;
          }
          super.buildDrawingCache(paramBoolean);
          if (!paramBoolean) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = oTk;
        localObject = (Bitmap)((Field)localObject).get(this);
        if (localObject != null) {
          break label170;
        }
        bool = true;
        y.d("MicroMsg.ShowCommentImageView", "getStaticDrawingCache, autoScale: %s, cache==null: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
        if (localObject == null) {
          break;
        }
        if (!paramBoolean) {
          break label147;
        }
        oTj = (Bitmap)localObject;
        return;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.ShowCommentImageView", "getStaticDrawingCache error: %s", new Object[] { localException.getMessage() });
        return;
      }
      Field localField = oTl;
      continue;
      label147:
      oTi = localField;
      return;
      super.buildDrawingCache(paramBoolean);
      return;
      F(paramBoolean, true);
      super.buildDrawingCache(paramBoolean);
      return;
      label170:
      boolean bool = false;
    }
  }
  
  public void destroyDrawingCache()
  {
    super.destroyDrawingCache();
  }
  
  protected void onDetachedFromWindow()
  {
    try
    {
      oTk.set(this, null);
      oTl.set(this, null);
      super.onDetachedFromWindow();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      postDelayed(new ShowCommentImageView.2(this), 100L);
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.oTh = true;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(new ShowCommentImageView.1(this, paramOnClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ShowCommentImageView
 * JD-Core Version:    0.7.0.1
 */