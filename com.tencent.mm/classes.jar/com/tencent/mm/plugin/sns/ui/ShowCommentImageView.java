package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;

public class ShowCommentImageView
  extends ImageView
{
  private static Bitmap yED;
  private static Bitmap yEE;
  private static Field yEF;
  private static Field yEG;
  private static boolean yEH = false;
  private boolean yEC;
  
  public ShowCommentImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98260);
    this.yEC = false;
    init();
    AppMethodBeat.o(98260);
  }
  
  public ShowCommentImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98261);
    this.yEC = false;
    init();
    AppMethodBeat.o(98261);
  }
  
  private void ae(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(98265);
    if (paramBoolean1) {}
    try
    {
      for (Field localField = yEF; paramBoolean2; localField = yEG)
      {
        localField.set(this, null);
        AppMethodBeat.o(98265);
        return;
      }
      Bitmap localBitmap;
      if (paramBoolean1)
      {
        localBitmap = yEE;
        if (localBitmap != null) {
          break label103;
        }
      }
      label103:
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        ac.d("MicroMsg.ShowCommentImageView", "setDrawingCache, autoScale: %s, cache==null: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        if (localBitmap != null) {
          localField.set(this, localBitmap);
        }
        AppMethodBeat.o(98265);
        return;
        localBitmap = yED;
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(98265);
    }
  }
  
  private static void init()
  {
    AppMethodBeat.i(98262);
    if ((yEF != null) && (yEG != null))
    {
      AppMethodBeat.o(98262);
      return;
    }
    try
    {
      yEF = View.class.getDeclaredField("mDrawingCache");
      yEG = View.class.getDeclaredField("mUnscaledDrawingCache");
      yEF.setAccessible(true);
      yEG.setAccessible(true);
      yEH = true;
      AppMethodBeat.o(98262);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ShowCommentImageView", "init error: %s", new Object[] { localException.getMessage() });
      yEH = false;
      AppMethodBeat.o(98262);
    }
  }
  
  private boolean rh(boolean paramBoolean)
  {
    AppMethodBeat.i(98264);
    if (!yEH)
    {
      AppMethodBeat.o(98264);
      return false;
    }
    if (paramBoolean) {}
    try
    {
      for (Field localField = yEF; (Bitmap)localField.get(this) != null; localField = yEG)
      {
        AppMethodBeat.o(98264);
        return true;
      }
      AppMethodBeat.o(98264);
      return false;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.ShowCommentImageView", localException, "", new Object[0]);
      ac.e("MicroMsg.ShowCommentImageView", "checkIfCanReuseDrawingCache error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(98264);
    }
    return false;
  }
  
  public void buildDrawingCache(boolean paramBoolean)
  {
    AppMethodBeat.i(98263);
    Object localObject;
    if (yEH) {
      if (!this.yEC) {
        if (!rh(paramBoolean))
        {
          if (paramBoolean) {}
          for (localObject = yEE; (localObject != null) && (!((Bitmap)localObject).isRecycled()); localObject = yED)
          {
            ae(paramBoolean, false);
            AppMethodBeat.o(98263);
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
        localObject = yEF;
        localObject = (Bitmap)((Field)localObject).get(this);
        if (localObject != null) {
          break label205;
        }
        bool = true;
        ac.d("MicroMsg.ShowCommentImageView", "getStaticDrawingCache, autoScale: %s, cache==null: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
        if (localObject == null) {
          break label171;
        }
        if (!paramBoolean) {
          break label167;
        }
        yEE = (Bitmap)localObject;
        AppMethodBeat.o(98263);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.ShowCommentImageView", "getStaticDrawingCache error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(98263);
        return;
      }
      Field localField = yEG;
      continue;
      label167:
      yED = localField;
      label171:
      AppMethodBeat.o(98263);
      return;
      super.buildDrawingCache(paramBoolean);
      AppMethodBeat.o(98263);
      return;
      ae(paramBoolean, true);
      super.buildDrawingCache(paramBoolean);
      AppMethodBeat.o(98263);
      return;
      label205:
      boolean bool = false;
    }
  }
  
  public void destroyDrawingCache()
  {
    AppMethodBeat.i(98267);
    super.destroyDrawingCache();
    AppMethodBeat.o(98267);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(98266);
    try
    {
      yEF.set(this, null);
      yEG.set(this, null);
      super.onDetachedFromWindow();
      AppMethodBeat.o(98266);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(98269);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98259);
          ShowCommentImageView.a(ShowCommentImageView.this, false);
          AppMethodBeat.o(98259);
        }
      }, 100L);
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(98269);
      return bool;
      this.yEC = true;
    }
  }
  
  public void setOnClickListener(final View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98268);
    super.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98258);
        ShowCommentImageView.a(ShowCommentImageView.this, true);
        paramOnClickListener.onClick(paramAnonymousView);
        AppMethodBeat.o(98258);
      }
    });
    AppMethodBeat.o(98268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ShowCommentImageView
 * JD-Core Version:    0.7.0.1
 */