package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.tools.MaskImageButton;
import junit.framework.Assert;

public class a
  extends j
  implements e.a
{
  public static float ppN = 0.1F;
  protected boolean pressed;
  
  public a(j.a parama, String paramString)
  {
    super(parama, paramString);
  }
  
  private a(String paramString)
  {
    super(b.Boe, paramString);
  }
  
  public void Mr(String paramString)
  {
    AppMethodBeat.i(152110);
    super.Mr(paramString);
    AppMethodBeat.o(152110);
  }
  
  public final void setIsPressed(boolean paramBoolean)
  {
    this.pressed = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void doInvalidate();
    
    public abstract Drawable getDrawable();
    
    public abstract void setImageDrawable(Drawable paramDrawable);
  }
  
  public static final class b
  {
    public static j.a Boe;
    
    public static void A(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152107);
      if (paramImageView == null)
      {
        Log.e("MicroMsg.AvatarDrawable", "imageView is null");
        AppMethodBeat.o(152107);
        return;
      }
      a(paramImageView, paramString, a.ppN, false);
      AppMethodBeat.o(152107);
    }
    
    private static void B(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152109);
      if ((WeChatEnvironment.hasDebugger()) && (paramImageView != null) && (!paramImageView.isLongClickable()) && (!(paramImageView instanceof NotCopyUserNameImageView)))
      {
        paramImageView.setOnLongClickListener(new a.b.1(paramImageView, paramString));
        if (!paramImageView.isClickable()) {
          paramImageView.setOnClickListener(new a.b.2(paramImageView));
        }
      }
      AppMethodBeat.o(152109);
    }
    
    public static void a(ImageView paramImageView, String paramString, float paramFloat, boolean paramBoolean)
    {
      AppMethodBeat.i(152106);
      if (paramImageView == null)
      {
        Log.e("MicroMsg.AvatarDrawable", "imageView is null");
        AppMethodBeat.o(152106);
        return;
      }
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof c))) {
        localObject = (c)localObject;
      }
      for (;;)
      {
        ((c)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        B(paramImageView, paramString);
        n(paramImageView);
        AppMethodBeat.o(152106);
        return;
        localObject = new c(paramString, paramFloat);
        ((c)localObject).zO(paramBoolean);
      }
    }
    
    public static void a(ImageView paramImageView, String paramString, b paramb)
    {
      AppMethodBeat.i(223829);
      if (paramImageView == null)
      {
        AppMethodBeat.o(223829);
        return;
      }
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof d))) {}
      for (localObject = (d)localObject;; localObject = new d(paramString))
      {
        if (((d)localObject).Kbi != null) {
          ((d)localObject).Kbi.Kbk = paramb;
        }
        if ((((d)localObject).Kbj != 2131231260) || (((d)localObject).Kbi == null) || (((d)localObject).Kbi.pqA == null) || (((d)localObject).Kbi.pqA.isRecycled()))
        {
          ((d)localObject).Kbj = 2131231260;
          paramb = BitmapUtil.getBitmapNative(2131231260);
          if (((d)localObject).Kbi != null)
          {
            d.a locala = ((d)localObject).Kbi;
            locala.pqA = paramb;
            locala.pqA = locala.aJ(locala.pqA);
          }
        }
        ((d)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        B(paramImageView, paramString);
        AppMethodBeat.o(223829);
        return;
      }
    }
    
    public static void c(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152102);
      if (paramImageView == null)
      {
        Log.e("MicroMsg.AvatarDrawable", "imageView is null");
        AppMethodBeat.o(152102);
        return;
      }
      a(paramImageView, paramString, a.ppN, false);
      AppMethodBeat.o(152102);
    }
    
    public static void d(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152103);
      a(paramImageView, paramString, 0.5F, false);
      AppMethodBeat.o(152103);
    }
    
    public static void d(ImageView paramImageView, String paramString, float paramFloat)
    {
      AppMethodBeat.i(258498);
      a(paramImageView, paramString, paramFloat, false);
      AppMethodBeat.o(258498);
    }
    
    public static j.a gov()
    {
      AppMethodBeat.i(152101);
      if (Boe != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        j.a locala = Boe;
        AppMethodBeat.o(152101);
        return locala;
      }
    }
    
    private static void n(ImageView paramImageView)
    {
      AppMethodBeat.i(223830);
      if ((paramImageView != null) && (!(paramImageView instanceof MaskImageButton)) && ((paramImageView.isClickable()) || (paramImageView.isLongClickable()))) {
        try
        {
          paramImageView.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(223826);
              int i = paramAnonymousMotionEvent.getActionMasked();
              Log.d("MicroMsg.AvatarDrawable", "touch view %s, event %s", new Object[] { paramAnonymousView, Integer.valueOf(i) });
              if (i == 0) {
                if ((this.rCk.getDrawable() != null) && ((this.rCk.getDrawable() instanceof a)))
                {
                  ((a)this.rCk.getDrawable()).setIsPressed(true);
                  this.rCk.invalidate();
                }
              }
              for (;;)
              {
                AppMethodBeat.o(223826);
                return false;
                if (((i == 1) || (i == 3)) && (this.rCk.getDrawable() != null) && ((this.rCk.getDrawable() instanceof a)))
                {
                  ((a)this.rCk.getDrawable()).setIsPressed(false);
                  this.rCk.invalidate();
                }
              }
            }
          });
          AppMethodBeat.o(223830);
          return;
        }
        catch (Exception paramImageView)
        {
          Log.printErrStackTrace("MicroMsg.AvatarDrawable", paramImageView, "", new Object[0]);
        }
      }
      AppMethodBeat.o(223830);
    }
    
    public static void y(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(223827);
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof a))) {
        localObject = (a)localObject;
      }
      for (;;)
      {
        ((a)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        B(paramImageView, paramString);
        AppMethodBeat.o(223827);
        return;
        localObject = new a(paramString, (byte)0);
        ((a)localObject).zO(true);
      }
    }
    
    public static void z(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152105);
      a(paramImageView, paramString, 0.5F, true);
      AppMethodBeat.o(152105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.a
 * JD-Core Version:    0.7.0.1
 */