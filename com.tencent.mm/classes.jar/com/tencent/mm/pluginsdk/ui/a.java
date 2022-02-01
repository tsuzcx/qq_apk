package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.tools.MaskImageButton;
import junit.framework.Assert;

public class a
  extends j
  implements AvatarStorage.a
{
  protected boolean aLn;
  
  public a(j.a parama, String paramString)
  {
    super(parama, paramString);
  }
  
  private a(String paramString)
  {
    super(b.Ngk, paramString);
  }
  
  public void LM(String paramString)
  {
    AppMethodBeat.i(152110);
    super.LM(paramString);
    AppMethodBeat.o(152110);
  }
  
  public final void setIsPressed(boolean paramBoolean)
  {
    this.aLn = paramBoolean;
  }
  
  public static final class b
  {
    static j.a Ngk;
    
    public static void A(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(245050);
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
        AppMethodBeat.o(245050);
        return;
        localObject = new a(paramString, (byte)0);
        ((a)localObject).JB(true);
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
      a(paramImageView, paramString, 0.1F, false);
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
      if ((localObject != null) && ((localObject instanceof c)))
      {
        localObject = (c)localObject;
        ((c)localObject).XXQ = paramFloat;
      }
      for (;;)
      {
        ((c)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        D(paramImageView, paramString);
        x(paramImageView);
        AppMethodBeat.o(152106);
        return;
        localObject = new c(paramString, paramFloat);
        ((c)localObject).JB(paramBoolean);
      }
    }
    
    public static void a(ImageView paramImageView, String paramString, int paramInt, com.tencent.mm.modelavatar.c paramc)
    {
      AppMethodBeat.i(245065);
      if (paramImageView == null)
      {
        AppMethodBeat.o(245065);
        return;
      }
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof d))) {}
      for (localObject = (d)localObject;; localObject = new d(paramString))
      {
        if (((d)localObject).XXS != null) {
          ((d)localObject).XXS.XXU = paramc;
        }
        if ((((d)localObject).XXT != paramInt) || (((d)localObject).XXS == null) || (((d)localObject).XXS.hkp == null) || (((d)localObject).XXS.hkp.isRecycled()))
        {
          ((d)localObject).XXT = paramInt;
          paramc = BitmapUtil.getBitmapNative(paramInt);
          if (((d)localObject).XXS != null)
          {
            d.a locala = ((d)localObject).XXS;
            locala.hkp = paramc;
            locala.hkp = locala.aZ(locala.hkp);
          }
        }
        ((d)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        D(paramImageView, paramString);
        AppMethodBeat.o(245065);
        return;
      }
    }
    
    public static void a(j.a parama)
    {
      AppMethodBeat.i(245046);
      Log.d("MicroMsg.AvatarDrawable", "setLoader".concat(String.valueOf(parama)));
      Ngk = parama;
      AppMethodBeat.o(245046);
    }
    
    public static void g(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152102);
      if (paramImageView == null)
      {
        Log.e("MicroMsg.AvatarDrawable", "imageView is null");
        AppMethodBeat.o(152102);
        return;
      }
      a(paramImageView, paramString, 0.1F, false);
      AppMethodBeat.o(152102);
    }
    
    public static void h(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152103);
      a(paramImageView, paramString, 0.5F, false);
      AppMethodBeat.o(152103);
    }
    
    public static j.a iKa()
    {
      AppMethodBeat.i(152101);
      if (Ngk != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        j.a locala = Ngk;
        AppMethodBeat.o(152101);
        return locala;
      }
    }
    
    private static void x(ImageView paramImageView)
    {
      AppMethodBeat.i(245071);
      if ((paramImageView != null) && (!(paramImageView instanceof MaskImageButton)) && ((paramImageView.isClickable()) || (paramImageView.isLongClickable()))) {
        try
        {
          paramImageView.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(245130);
              int i = paramAnonymousMotionEvent.getActionMasked();
              Log.d("MicroMsg.AvatarDrawable", "touch view %s, event %s", new Object[] { paramAnonymousView, Integer.valueOf(i) });
              if (i == 0) {
                if ((a.b.this.getDrawable() != null) && ((a.b.this.getDrawable() instanceof a)))
                {
                  ((a)a.b.this.getDrawable()).setIsPressed(true);
                  a.b.this.invalidate();
                }
              }
              for (;;)
              {
                AppMethodBeat.o(245130);
                return false;
                if (((i == 1) || (i == 3)) && (a.b.this.getDrawable() != null) && ((a.b.this.getDrawable() instanceof a)))
                {
                  ((a)a.b.this.getDrawable()).setIsPressed(false);
                  a.b.this.invalidate();
                }
              }
            }
          });
          AppMethodBeat.o(245071);
          return;
        }
        catch (Exception paramImageView)
        {
          Log.printErrStackTrace("MicroMsg.AvatarDrawable", paramImageView, "", new Object[0]);
        }
      }
      AppMethodBeat.o(245071);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.a
 * JD-Core Version:    0.7.0.1
 */