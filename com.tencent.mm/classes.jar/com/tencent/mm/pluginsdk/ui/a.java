package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class a
  extends i
  implements d.a
{
  private a(String paramString)
  {
    super(b.nav, paramString);
  }
  
  private a(String paramString, byte paramByte)
  {
    super(b.nav, paramString, (byte)0);
  }
  
  public final void kk(String paramString)
  {
    super.kk(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void doInvalidate();
    
    public abstract Drawable getDrawable();
    
    public abstract void setImageDrawable(Drawable paramDrawable);
  }
  
  public static final class b
  {
    public static i.a nav;
    
    public static void a(ImageView paramImageView, String paramString)
    {
      if (paramImageView == null)
      {
        y.e("MicroMsg.AvatarDrawable", "imageView is null");
        return;
      }
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof a))) {}
      for (localObject = (a)localObject;; localObject = new a(paramString, '\000'))
      {
        ((a)localObject).Wt(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        return;
      }
    }
    
    public static void a(ImageView paramImageView, String paramString, float paramFloat, boolean paramBoolean)
    {
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof b))) {
        localObject = (b)localObject;
      }
      for (;;)
      {
        ((b)localObject).Wt(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        return;
        localObject = new b(paramString, paramFloat);
        ((b)localObject).lP(paramBoolean);
      }
    }
    
    public static void a(a.a parama, String paramString)
    {
      Object localObject = parama.getDrawable();
      if ((localObject != null) && ((localObject instanceof a))) {}
      for (localObject = (a)localObject;; localObject = new a(paramString, '\000'))
      {
        ((a)localObject).Wt(paramString);
        parama.setImageDrawable((Drawable)localObject);
        parama.doInvalidate();
        return;
      }
    }
    
    public static i.a cmd()
    {
      if (nav != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        return nav;
      }
    }
    
    public static void g(ImageView paramImageView, String paramString, int paramInt)
    {
      if (paramImageView == null) {
        return;
      }
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof c))) {}
      for (localObject = (c)localObject;; localObject = new c(paramString))
      {
        if ((((c)localObject).rZd != paramInt) || (((c)localObject).rZc == null) || (((c)localObject).rZc.iez == null) || (((c)localObject).rZc.iez.isRecycled()))
        {
          ((c)localObject).rZd = paramInt;
          Bitmap localBitmap = com.tencent.mm.sdk.platformtools.c.EX(paramInt);
          if (((c)localObject).rZc != null) {
            ((c)localObject).rZc.iez = localBitmap;
          }
        }
        ((c)localObject).Wt(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        return;
      }
    }
    
    public static void n(ImageView paramImageView, String paramString)
    {
      a(paramImageView, paramString, 0.5F, false);
    }
    
    public static void o(ImageView paramImageView, String paramString)
    {
      a(paramImageView, paramString, 0.5F, true);
    }
    
    public static void p(ImageView paramImageView, String paramString)
    {
      Object localObject = paramImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof a))) {}
      for (localObject = (a)localObject;; localObject = new a(paramString, (short)0))
      {
        ((a)localObject).Wt(paramString);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.invalidate();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.a
 * JD-Core Version:    0.7.0.1
 */