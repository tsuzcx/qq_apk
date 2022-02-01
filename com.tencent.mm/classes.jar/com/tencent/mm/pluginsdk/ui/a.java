package com.tencent.mm.pluginsdk.ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;

public class a
  extends i
  implements e.a
{
  public static float nxI = 0.1F;
  
  public a(i.a parama, String paramString)
  {
    super(parama, paramString);
  }
  
  public void Af(String paramString)
  {
    AppMethodBeat.i(152110);
    super.Af(paramString);
    AppMethodBeat.o(152110);
  }
  
  public static abstract interface a
  {
    public abstract void doInvalidate();
    
    public abstract Drawable getDrawable();
    
    public abstract void setImageDrawable(Drawable paramDrawable);
  }
  
  public static final class b
  {
    public static i.a vQR;
    
    public static void a(ImageView paramImageView, String paramString, float paramFloat, boolean paramBoolean)
    {
      AppMethodBeat.i(152106);
      if (paramImageView == null)
      {
        ac.e("MicroMsg.AvatarDrawable", "imageView is null");
        AppMethodBeat.o(152106);
        return;
      }
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof b))) {
        localObject = (b)localObject;
      }
      for (;;)
      {
        ((b)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        x(paramImageView, paramString);
        AppMethodBeat.o(152106);
        return;
        localObject = new b(paramString, paramFloat);
        ((b)localObject).uX(paramBoolean);
      }
    }
    
    public static void a(ImageView paramImageView, String paramString, int paramInt, com.tencent.mm.aj.b paramb)
    {
      AppMethodBeat.i(192685);
      if (paramImageView == null)
      {
        AppMethodBeat.o(192685);
        return;
      }
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof c))) {}
      for (localObject = (c)localObject;; localObject = new c(paramString))
      {
        ((c)localObject).a(paramb);
        ((c)localObject).WO(paramInt);
        ((c)localObject).setTag(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        x(paramImageView, paramString);
        AppMethodBeat.o(192685);
        return;
      }
    }
    
    public static void c(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152102);
      if (paramImageView == null)
      {
        ac.e("MicroMsg.AvatarDrawable", "imageView is null");
        AppMethodBeat.o(152102);
        return;
      }
      a(paramImageView, paramString, a.nxI, false);
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
      AppMethodBeat.i(210358);
      a(paramImageView, paramString, paramFloat, false);
      AppMethodBeat.o(210358);
    }
    
    public static i.a eMA()
    {
      AppMethodBeat.i(152101);
      if (vQR != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        i.a locala = vQR;
        AppMethodBeat.o(152101);
        return locala;
      }
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
        ac.e("MicroMsg.AvatarDrawable", "imageView is null");
        AppMethodBeat.o(152107);
        return;
      }
      a(paramImageView, paramString, a.nxI, false);
      AppMethodBeat.o(152107);
    }
    
    private static void x(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(152109);
      if ((bt.eWo()) && (paramImageView != null) && (!paramImageView.isLongClickable()) && (!(paramImageView instanceof NotCopyUserNameImageView)))
      {
        paramImageView.setOnLongClickListener(new a.b.1(paramImageView, paramString));
        if (!paramImageView.isClickable()) {
          paramImageView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(152100);
              paramAnonymousView = (View)paramAnonymousView.getParent();
              while (paramAnonymousView != null)
              {
                if (paramAnonymousView.isClickable())
                {
                  if ((paramAnonymousView instanceof AdapterView))
                  {
                    Object localObject = this.pBf.getTag();
                    if ((localObject instanceof Integer)) {
                      ((AdapterView)paramAnonymousView).performItemClick(null, ((Integer)localObject).intValue(), -1L);
                    }
                    AppMethodBeat.o(152100);
                    return;
                  }
                  paramAnonymousView.performClick();
                  AppMethodBeat.o(152100);
                  return;
                }
                if ((paramAnonymousView.getParent() instanceof View)) {
                  paramAnonymousView = (View)paramAnonymousView.getParent();
                } else {
                  paramAnonymousView = null;
                }
              }
              AppMethodBeat.o(152100);
            }
          });
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