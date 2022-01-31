package com.tencent.mm.wear.app.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.emoji.gif.MMGIFImageView;
import java.io.File;

public final class b
{
  private i acS;
  private com.tencent.mm.a.a<String, Bitmap> acT;
  private com.tencent.mm.a.a<String, byte[]> acU;
  private Context context;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
    this.acU = new com.tencent.mm.a.a(10);
    this.acT = new com.tencent.mm.a.a(40);
    this.acS = new i();
    new i.1(this.acS).start();
  }
  
  private boolean c(a parama)
  {
    switch (parama.type)
    {
    default: 
      return false;
    case 1: 
      if (parama.acQ == 1)
      {
        localObject = (byte[])this.acU.get(parama.acK);
        if (localObject != null)
        {
          MMGIFImageView localMMGIFImageView = (MMGIFImageView)parama.acL;
          localMMGIFImageView.a((byte[])localObject, parama.acK);
          localMMGIFImageView.start();
          com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "render emoji with cache %s", new Object[] { parama.acK });
          return true;
        }
      }
      else
      {
        localObject = new File(h.ml(), parama.acJ);
        if (((File)localObject).exists())
        {
          parama = (MMGIFImageView)parama.acL;
          parama.G(((File)localObject).getAbsolutePath());
          parama.start();
          com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "render emoji with file %s", new Object[] { ((File)localObject).getAbsolutePath() });
          return true;
        }
      }
      if (parama.acM > 0)
      {
        localObject = this.context.getResources().getDrawable(parama.acM);
        parama.acL.setImageDrawable((Drawable)localObject);
      }
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "not find emoji in cache %s", new Object[] { parama.acK });
      return false;
    case 3: 
      localObject = (Bitmap)this.acT.get(parama.acK);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        d.a(this.context.getResources(), (Bitmap)localObject, parama.acL);
        com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "render avatar with cache %s", new Object[] { parama.acK });
        return true;
      }
      if (parama.acM > 0)
      {
        localObject = this.context.getResources().getDrawable(parama.acM);
        parama.acL.setImageDrawable((Drawable)localObject);
      }
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "not find avatar in cache %s", new Object[] { parama.acK });
      return false;
    }
    Object localObject = (Bitmap)this.acT.get(parama.acK);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      d.a(this.context.getResources(), (Bitmap)localObject, parama.acL);
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "render msg image with cache %s", new Object[] { parama.acK });
      return true;
    }
    if (parama.acM > 0)
    {
      localObject = this.context.getResources().getDrawable(parama.acM);
      parama.acL.setImageDrawable((Drawable)localObject);
    }
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "not msg imager in cache %s", new Object[] { parama.acK });
    return false;
  }
  
  private static final String d(a parama)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (parama.type == 1)
    {
      localStringBuffer.append(parama.type);
      localStringBuffer.append("-");
      localStringBuffer.append(parama.acG);
      localStringBuffer.append("-");
      localStringBuffer.append(parama.width);
      localStringBuffer.append("-");
      localStringBuffer.append(parama.height);
      localStringBuffer.append("-");
      localStringBuffer.append(parama.acR);
      localStringBuffer.append("-");
      localStringBuffer.append(parama.acJ);
    }
    for (;;)
    {
      return com.tencent.mm.a.c.g(localStringBuffer.toString().getBytes());
      if (parama.type == 3)
      {
        localStringBuffer.append(parama.acH);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.width);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.height);
      }
      else if (parama.type == 2)
      {
        localStringBuffer.append(parama.type);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.acG);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.width);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.height);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.acR);
      }
    }
  }
  
  public final void a(a parama)
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "loadImage %s", new Object[] { parama });
    parama.acK = d(parama);
    parama.acL.setTag(parama.acK);
    if (!c(parama)) {
      this.acS.e(new c(this, parama));
    }
  }
  
  public final Bitmap b(a parama)
  {
    return (Bitmap)this.acT.get(d(parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.c.b
 * JD-Core Version:    0.7.0.1
 */