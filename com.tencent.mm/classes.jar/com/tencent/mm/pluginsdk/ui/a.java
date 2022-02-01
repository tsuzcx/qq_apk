package com.tencent.mm.pluginsdk.ui;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.tools.MaskImageButton;
import junit.framework.Assert;

public class a
  extends j
  implements e.a
{
  public static float nZg = 0.1F;
  protected boolean pressed;
  
  public a(j.a parama, String paramString)
  {
    super(parama, paramString);
  }
  
  public void De(String paramString)
  {
    AppMethodBeat.i(152110);
    super.De(paramString);
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
    public static j.a wYb;
    
    public static void a(ImageView paramImageView, String paramString, float paramFloat, boolean paramBoolean)
    {
      AppMethodBeat.i(152106);
      if (paramImageView == null)
      {
        ad.e("MicroMsg.AvatarDrawable", "imageView is null");
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
        x(paramImageView, paramString);
        l(paramImageView);
        AppMethodBeat.o(152106);
        return;
        localObject = new c(paramString, paramFloat);
        ((c)localObject).vI(paramBoolean);
      }
    }
    
    public static void a(ImageView paramImageView, String paramString, int paramInt, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(195428);
      if (paramImageView == null)
      {
        AppMethodBeat.o(195428);
        return;
      }
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof d))) {}
      for (localObject = (d)localObject;; localObject = new d(paramString))
      {
        ((d)localObject).a(paramb);
        ((d)localObject).YK(paramInt);
        ((d)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        x(paramImageView, paramString);
        AppMethodBeat.o(195428);
        return;
      }
    }
    
    public static void c(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152102);
      if (paramImageView == null)
      {
        ad.e("MicroMsg.AvatarDrawable", "imageView is null");
        AppMethodBeat.o(152102);
        return;
      }
      a(paramImageView, paramString, a.nZg, false);
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
      AppMethodBeat.i(221221);
      a(paramImageView, paramString, paramFloat, false);
      AppMethodBeat.o(221221);
    }
    
    public static j.a fbx()
    {
      AppMethodBeat.i(152101);
      if (wYb != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        j.a locala = wYb;
        AppMethodBeat.o(152101);
        return locala;
      }
    }
    
    private static void l(ImageView paramImageView)
    {
      AppMethodBeat.i(195429);
      if ((paramImageView != null) && (!(paramImageView instanceof MaskImageButton)) && ((paramImageView.isClickable()) || (paramImageView.isLongClickable()))) {
        try
        {
          paramImageView.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(195426);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              localb.bd(paramAnonymousMotionEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/AvatarDrawable$Factory$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
              int i = paramAnonymousMotionEvent.getActionMasked();
              ad.d("MicroMsg.AvatarDrawable", "touch view %s, event %s", new Object[] { paramAnonymousView, Integer.valueOf(i) });
              if (i == 0) {
                if ((this.qeK.getDrawable() != null) && ((this.qeK.getDrawable() instanceof a)))
                {
                  ((a)this.qeK.getDrawable()).setIsPressed(true);
                  this.qeK.invalidate();
                }
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/AvatarDrawable$Factory$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(195426);
                return false;
                if (((i == 1) || (i == 3)) && (this.qeK.getDrawable() != null) && ((this.qeK.getDrawable() instanceof a)))
                {
                  ((a)this.qeK.getDrawable()).setIsPressed(false);
                  this.qeK.invalidate();
                }
              }
            }
          });
          AppMethodBeat.o(195429);
          return;
        }
        catch (Exception paramImageView)
        {
          ad.printErrStackTrace("MicroMsg.AvatarDrawable", paramImageView, "", new Object[0]);
        }
      }
      AppMethodBeat.o(195429);
    }
    
    public static void v(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152105);
      a(paramImageView, paramString, 0.5F, true);
      AppMethodBeat.o(152105);
    }
    
    public static void w(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152107);
      if (paramImageView == null)
      {
        ad.e("MicroMsg.AvatarDrawable", "imageView is null");
        AppMethodBeat.o(152107);
        return;
      }
      a(paramImageView, paramString, a.nZg, false);
      AppMethodBeat.o(152107);
    }
    
    private static void x(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152109);
      if ((bu.flY()) && (paramImageView != null) && (!paramImageView.isLongClickable()) && (!(paramImageView instanceof NotCopyUserNameImageView)))
      {
        paramImageView.setOnLongClickListener(new a.b.1(paramImageView, paramString));
        if (!paramImageView.isClickable()) {
          paramImageView.setOnClickListener(new a.b.2(paramImageView));
        }
      }
      AppMethodBeat.o(152109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.a
 * JD-Core Version:    0.7.0.1
 */