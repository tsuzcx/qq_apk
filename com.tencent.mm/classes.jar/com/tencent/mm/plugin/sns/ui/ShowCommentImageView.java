package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public class ShowCommentImageView
  extends ImageView
{
  private static Bitmap rLf;
  private static Bitmap rLg;
  private static Field rLh;
  private static Field rLi;
  private static boolean rLj = false;
  private boolean rLe;
  
  public ShowCommentImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38572);
    this.rLe = false;
    init();
    AppMethodBeat.o(38572);
  }
  
  public ShowCommentImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38573);
    this.rLe = false;
    init();
    AppMethodBeat.o(38573);
  }
  
  private void J(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(38577);
    if (paramBoolean1) {}
    try
    {
      for (Field localField = rLh; paramBoolean2; localField = rLi)
      {
        localField.set(this, null);
        AppMethodBeat.o(38577);
        return;
      }
      Bitmap localBitmap;
      if (paramBoolean1)
      {
        localBitmap = rLg;
        if (localBitmap != null) {
          break label103;
        }
      }
      label103:
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        ab.d("MicroMsg.ShowCommentImageView", "setDrawingCache, autoScale: %s, cache==null: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        if (localBitmap != null) {
          localField.set(this, localBitmap);
        }
        AppMethodBeat.o(38577);
        return;
        localBitmap = rLf;
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(38577);
    }
  }
  
  private static void init()
  {
    AppMethodBeat.i(38574);
    if ((rLh != null) && (rLi != null))
    {
      AppMethodBeat.o(38574);
      return;
    }
    try
    {
      rLh = View.class.getDeclaredField("mDrawingCache");
      rLi = View.class.getDeclaredField("mUnscaledDrawingCache");
      rLh.setAccessible(true);
      rLi.setAccessible(true);
      rLj = true;
      AppMethodBeat.o(38574);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ShowCommentImageView", "init error: %s", new Object[] { localException.getMessage() });
      rLj = false;
      AppMethodBeat.o(38574);
    }
  }
  
  private boolean ly(boolean paramBoolean)
  {
    AppMethodBeat.i(38576);
    if (!rLj)
    {
      AppMethodBeat.o(38576);
      return false;
    }
    if (paramBoolean) {}
    try
    {
      for (Field localField = rLh; (Bitmap)localField.get(this) != null; localField = rLi)
      {
        AppMethodBeat.o(38576);
        return true;
      }
      AppMethodBeat.o(38576);
      return false;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.ShowCommentImageView", localException, "", new Object[0]);
      ab.e("MicroMsg.ShowCommentImageView", "checkIfCanReuseDrawingCache error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(38576);
    }
    return false;
  }
  
  public void buildDrawingCache(boolean paramBoolean)
  {
    AppMethodBeat.i(38575);
    Object localObject;
    if (rLj) {
      if (!this.rLe) {
        if (!ly(paramBoolean))
        {
          if (paramBoolean) {}
          for (localObject = rLg; (localObject != null) && (!((Bitmap)localObject).isRecycled()); localObject = rLf)
          {
            J(paramBoolean, false);
            AppMethodBeat.o(38575);
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
        localObject = rLh;
        localObject = (Bitmap)((Field)localObject).get(this);
        if (localObject != null) {
          break label205;
        }
        bool = true;
        ab.d("MicroMsg.ShowCommentImageView", "getStaticDrawingCache, autoScale: %s, cache==null: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
        if (localObject == null) {
          break label171;
        }
        if (!paramBoolean) {
          break label167;
        }
        rLg = (Bitmap)localObject;
        AppMethodBeat.o(38575);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.ShowCommentImageView", "getStaticDrawingCache error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(38575);
        return;
      }
      Field localField = rLi;
      continue;
      label167:
      rLf = localField;
      label171:
      AppMethodBeat.o(38575);
      return;
      super.buildDrawingCache(paramBoolean);
      AppMethodBeat.o(38575);
      return;
      J(paramBoolean, true);
      super.buildDrawingCache(paramBoolean);
      AppMethodBeat.o(38575);
      return;
      label205:
      boolean bool = false;
    }
  }
  
  public void destroyDrawingCache()
  {
    AppMethodBeat.i(38579);
    super.destroyDrawingCache();
    AppMethodBeat.o(38579);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(38578);
    try
    {
      rLh.set(this, null);
      rLi.set(this, null);
      super.onDetachedFromWindow();
      AppMethodBeat.o(38578);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38581);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      postDelayed(new ShowCommentImageView.2(this), 100L);
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38581);
      return bool;
      this.rLe = true;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(38580);
    super.setOnClickListener(new ShowCommentImageView.1(this, paramOnClickListener));
    AppMethodBeat.o(38580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ShowCommentImageView
 * JD-Core Version:    0.7.0.1
 */