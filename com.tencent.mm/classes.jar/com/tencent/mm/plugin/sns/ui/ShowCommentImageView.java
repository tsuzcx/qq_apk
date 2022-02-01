package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;

public class ShowCommentImageView
  extends ImageView
{
  private static Bitmap zVY;
  private static Bitmap zVZ;
  private static Field zWa;
  private static Field zWb;
  private static boolean zWc = false;
  private boolean zVX;
  
  public ShowCommentImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98260);
    this.zVX = false;
    init();
    AppMethodBeat.o(98260);
  }
  
  public ShowCommentImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98261);
    this.zVX = false;
    init();
    AppMethodBeat.o(98261);
  }
  
  private void ai(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(98265);
    if (paramBoolean1) {}
    try
    {
      for (Field localField = zWa; paramBoolean2; localField = zWb)
      {
        localField.set(this, null);
        AppMethodBeat.o(98265);
        return;
      }
      Bitmap localBitmap;
      if (paramBoolean1)
      {
        localBitmap = zVZ;
        if (localBitmap != null) {
          break label103;
        }
      }
      label103:
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        ad.d("MicroMsg.ShowCommentImageView", "setDrawingCache, autoScale: %s, cache==null: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        if (localBitmap != null) {
          localField.set(this, localBitmap);
        }
        AppMethodBeat.o(98265);
        return;
        localBitmap = zVY;
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(98265);
    }
  }
  
  private static void init()
  {
    AppMethodBeat.i(98262);
    if ((zWa != null) && (zWb != null))
    {
      AppMethodBeat.o(98262);
      return;
    }
    try
    {
      zWa = View.class.getDeclaredField("mDrawingCache");
      zWb = View.class.getDeclaredField("mUnscaledDrawingCache");
      zWa.setAccessible(true);
      zWb.setAccessible(true);
      zWc = true;
      AppMethodBeat.o(98262);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ShowCommentImageView", "init error: %s", new Object[] { localException.getMessage() });
      zWc = false;
      AppMethodBeat.o(98262);
    }
  }
  
  private boolean rL(boolean paramBoolean)
  {
    AppMethodBeat.i(98264);
    if (!zWc)
    {
      AppMethodBeat.o(98264);
      return false;
    }
    if (paramBoolean) {}
    try
    {
      for (Field localField = zWa; (Bitmap)localField.get(this) != null; localField = zWb)
      {
        AppMethodBeat.o(98264);
        return true;
      }
      AppMethodBeat.o(98264);
      return false;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.ShowCommentImageView", localException, "", new Object[0]);
      ad.e("MicroMsg.ShowCommentImageView", "checkIfCanReuseDrawingCache error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(98264);
    }
    return false;
  }
  
  public void buildDrawingCache(boolean paramBoolean)
  {
    AppMethodBeat.i(98263);
    Object localObject;
    if (zWc) {
      if (!this.zVX) {
        if (!rL(paramBoolean))
        {
          if (paramBoolean) {}
          for (localObject = zVZ; (localObject != null) && (!((Bitmap)localObject).isRecycled()); localObject = zVY)
          {
            ai(paramBoolean, false);
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
        localObject = zWa;
        localObject = (Bitmap)((Field)localObject).get(this);
        if (localObject != null) {
          break label205;
        }
        bool = true;
        ad.d("MicroMsg.ShowCommentImageView", "getStaticDrawingCache, autoScale: %s, cache==null: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
        if (localObject == null) {
          break label171;
        }
        if (!paramBoolean) {
          break label167;
        }
        zVZ = (Bitmap)localObject;
        AppMethodBeat.o(98263);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.ShowCommentImageView", "getStaticDrawingCache error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(98263);
        return;
      }
      Field localField = zWb;
      continue;
      label167:
      zVY = localField;
      label171:
      AppMethodBeat.o(98263);
      return;
      super.buildDrawingCache(paramBoolean);
      AppMethodBeat.o(98263);
      return;
      ai(paramBoolean, true);
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
      zWa.set(this, null);
      zWb.set(this, null);
      super.onDetachedFromWindow();
      AppMethodBeat.o(98266);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[] { localException.getMessage() });
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
      this.zVX = true;
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
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/ShowCommentImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ShowCommentImageView.a(ShowCommentImageView.this, true);
        paramOnClickListener.onClick(paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/sns/ui/ShowCommentImageView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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