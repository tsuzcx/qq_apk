package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.tools.MaskImageButton;
import junit.framework.Assert;

public class a
  extends j
  implements f.a
{
  public static float syM = 0.1F;
  protected boolean RbI;
  
  public a(j.a parama, String paramString)
  {
    super(parama, paramString);
  }
  
  private a(String paramString)
  {
    super(b.Hix, paramString);
  }
  
  public void TM(String paramString)
  {
    AppMethodBeat.i(152110);
    super.TM(paramString);
    AppMethodBeat.o(152110);
  }
  
  public final void setIsPressed(boolean paramBoolean)
  {
    this.RbI = paramBoolean;
  }
  
  public static final class b
  {
    static j.a Hix;
    
    public static void A(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(222251);
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof a))) {
        localObject = (a)localObject;
      }
      for (;;)
      {
        ((a)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        D(paramImageView, paramString);
        AppMethodBeat.o(222251);
        return;
        localObject = new a(paramString, (byte)0);
        ((a)localObject).DT(true);
      }
    }
    
    public static void B(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152105);
      a(paramImageView, paramString, 0.5F, true);
      AppMethodBeat.o(152105);
    }
    
    public static void C(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152107);
      if (paramImageView == null)
      {
        Log.e("MicroMsg.AvatarDrawable", "imageView is null");
        AppMethodBeat.o(152107);
        return;
      }
      a(paramImageView, paramString, a.syM, false);
      AppMethodBeat.o(152107);
    }
    
    private static void D(ImageView paramImageView, String paramString)
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
        D(paramImageView, paramString);
        o(paramImageView);
        AppMethodBeat.o(152106);
        return;
        localObject = new c(paramString, paramFloat);
        ((c)localObject).DT(paramBoolean);
      }
    }
    
    public static void a(ImageView paramImageView, String paramString, int paramInt, com.tencent.mm.am.c paramc)
    {
      AppMethodBeat.i(222266);
      if (paramImageView == null)
      {
        AppMethodBeat.o(222266);
        return;
      }
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof d))) {}
      for (localObject = (d)localObject;; localObject = new d(paramString))
      {
        if (((d)localObject).RbN != null) {
          ((d)localObject).RbN.RbP = paramc;
        }
        if ((((d)localObject).RbO != paramInt) || (((d)localObject).RbN == null) || (((d)localObject).RbN.fgf == null) || (((d)localObject).RbN.fgf.isRecycled()))
        {
          ((d)localObject).RbO = paramInt;
          paramc = BitmapUtil.getBitmapNative(paramInt);
          if (((d)localObject).RbN != null)
          {
            d.a locala = ((d)localObject).RbN;
            locala.fgf = paramc;
            locala.fgf = locala.aG(locala.fgf);
          }
        }
        ((d)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        D(paramImageView, paramString);
        AppMethodBeat.o(222266);
        return;
      }
    }
    
    public static void a(j.a parama)
    {
      AppMethodBeat.i(222247);
      Log.d("MicroMsg.AvatarDrawable", "setLoader".concat(String.valueOf(parama)));
      Hix = parama;
      AppMethodBeat.o(222247);
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
      a(paramImageView, paramString, a.syM, false);
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
      AppMethodBeat.i(292957);
      a(paramImageView, paramString, paramFloat, false);
      AppMethodBeat.o(292957);
    }
    
    public static j.a hjf()
    {
      AppMethodBeat.i(152101);
      if (Hix != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        j.a locala = Hix;
        AppMethodBeat.o(152101);
        return locala;
      }
    }
    
    private static void o(ImageView paramImageView)
    {
      AppMethodBeat.i(222272);
      if ((paramImageView != null) && (!(paramImageView instanceof MaskImageButton)) && ((paramImageView.isClickable()) || (paramImageView.isLongClickable()))) {
        try
        {
          paramImageView.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(228314);
              int i = paramAnonymousMotionEvent.getActionMasked();
              Log.d("MicroMsg.AvatarDrawable", "touch view %s, event %s", new Object[] { paramAnonymousView, Integer.valueOf(i) });
              if (i == 0) {
                if ((this.vhS.getDrawable() != null) && ((this.vhS.getDrawable() instanceof a)))
                {
                  ((a)this.vhS.getDrawable()).setIsPressed(true);
                  this.vhS.invalidate();
                }
              }
              for (;;)
              {
                AppMethodBeat.o(228314);
                return false;
                if (((i == 1) || (i == 3)) && (this.vhS.getDrawable() != null) && ((this.vhS.getDrawable() instanceof a)))
                {
                  ((a)this.vhS.getDrawable()).setIsPressed(false);
                  this.vhS.invalidate();
                }
              }
            }
          });
          AppMethodBeat.o(222272);
          return;
        }
        catch (Exception paramImageView)
        {
          Log.printErrStackTrace("MicroMsg.AvatarDrawable", paramImageView, "", new Object[0]);
        }
      }
      AppMethodBeat.o(222272);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.a
 * JD-Core Version:    0.7.0.1
 */