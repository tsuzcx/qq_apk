package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.i.a;

public final class b$a
{
  private static i.a nlL;
  public static final a nlM = new a();
  
  public static void a(ImageView paramImageView, String paramString)
  {
    g.k(paramImageView, "iv");
    g.k(paramString, "tag");
    Object localObject = paramImageView.getDrawable();
    if ((localObject != null) && ((localObject instanceof b))) {}
    for (localObject = (b)localObject;; localObject = new b(paramString, (byte)0))
    {
      ((b)localObject).Wt(paramString);
      paramImageView.setImageDrawable((Drawable)localObject);
      return;
    }
  }
  
  public static void a(i.a parama)
  {
    g.k(parama, "loader");
    nlL = parama;
  }
  
  public static i.a buE()
  {
    return nlL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.b.a
 * JD-Core Version:    0.7.0.1
 */