package com.tencent.mm.pluginsdk.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

public final class a$b
{
  public static i.a pFL;
  
  public static void a(ImageView paramImageView, String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(79661);
    if (paramImageView == null)
    {
      ab.e("MicroMsg.AvatarDrawable", "imageView is null");
      AppMethodBeat.o(79661);
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
      AppMethodBeat.o(79661);
      return;
      localObject = new b(paramString, paramFloat);
      ((b)localObject).pb(paramBoolean);
    }
  }
  
  public static void b(ImageView paramImageView, String paramString, float paramFloat)
  {
    AppMethodBeat.i(156860);
    a(paramImageView, paramString, paramFloat, false);
    AppMethodBeat.o(156860);
  }
  
  public static void c(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(79657);
    if (paramImageView == null)
    {
      ab.e("MicroMsg.AvatarDrawable", "imageView is null");
      AppMethodBeat.o(79657);
      return;
    }
    a(paramImageView, paramString, a.Iy(), false);
    AppMethodBeat.o(79657);
  }
  
  public static i.a dmT()
  {
    AppMethodBeat.i(79656);
    if (pFL != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      i.a locala = pFL;
      AppMethodBeat.o(79656);
      return locala;
    }
  }
  
  public static void f(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(79663);
    if (paramImageView == null)
    {
      AppMethodBeat.o(79663);
      return;
    }
    Object localObject = paramImageView.getDrawable();
    if ((localObject != null) && ((localObject instanceof c))) {}
    for (localObject = (c)localObject;; localObject = new c(paramString))
    {
      ((c)localObject).LR(paramInt);
      ((c)localObject).setTag(paramString);
      paramImageView.setImageDrawable((Drawable)localObject);
      paramImageView.invalidate();
      AppMethodBeat.o(79663);
      return;
    }
  }
  
  public static void s(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(79658);
    a(paramImageView, paramString, 0.5F, false);
    AppMethodBeat.o(79658);
  }
  
  public static void t(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(79660);
    a(paramImageView, paramString, 0.5F, true);
    AppMethodBeat.o(79660);
  }
  
  public static void u(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(79662);
    if (paramImageView == null)
    {
      ab.e("MicroMsg.AvatarDrawable", "imageView is null");
      AppMethodBeat.o(79662);
      return;
    }
    a(paramImageView, paramString, a.Iy(), false);
    AppMethodBeat.o(79662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.a.b
 * JD-Core Version:    0.7.0.1
 */