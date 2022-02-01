package com.tencent.mm.wear.app.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.a.e;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.emoji.gif.MMGIFImageView;
import java.io.File;

public final class b
{
  private i agt;
  private com.tencent.mm.a.a<String, Bitmap> agu;
  private com.tencent.mm.a.a<String, byte[]> agv;
  private Context context;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
    this.agv = new e(10);
    this.agu = new e(40);
    this.agt = new i();
    new i.1(this.agt).start();
  }
  
  private boolean c(a parama)
  {
    switch (parama.type)
    {
    default: 
      return false;
    case 1: 
      if (parama.agr == 1)
      {
        localObject = (byte[])this.agv.get(parama.agl);
        if (localObject != null)
        {
          MMGIFImageView localMMGIFImageView = (MMGIFImageView)parama.agm;
          localMMGIFImageView.a((byte[])localObject, parama.agl);
          localMMGIFImageView.start();
          com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "render emoji with cache %s", new Object[] { parama.agl });
          return true;
        }
      }
      else
      {
        localObject = new File(h.mX(), parama.agk);
        if (((File)localObject).exists())
        {
          parama = (MMGIFImageView)parama.agm;
          parama.L(((File)localObject).getAbsolutePath());
          parama.start();
          com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "render emoji with file %s", new Object[] { ((File)localObject).getAbsolutePath() });
          return true;
        }
      }
      if (parama.agn > 0)
      {
        localObject = this.context.getResources().getDrawable(parama.agn);
        parama.agm.setImageDrawable((Drawable)localObject);
      }
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "not find emoji in cache %s", new Object[] { parama.agl });
      return false;
    case 3: 
      localObject = (Bitmap)this.agu.get(parama.agl);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        d.a(this.context.getResources(), (Bitmap)localObject, parama.agm);
        com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "render avatar with cache %s", new Object[] { parama.agl });
        return true;
      }
      if (parama.agn > 0)
      {
        localObject = this.context.getResources().getDrawable(parama.agn);
        parama.agm.setImageDrawable((Drawable)localObject);
      }
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "not find avatar in cache %s", new Object[] { parama.agl });
      return false;
    }
    Object localObject = (Bitmap)this.agu.get(parama.agl);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      d.a(this.context.getResources(), (Bitmap)localObject, parama.agm);
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "render msg image with cache %s", new Object[] { parama.agl });
      return true;
    }
    if (parama.agn > 0)
    {
      localObject = this.context.getResources().getDrawable(parama.agn);
      parama.agm.setImageDrawable((Drawable)localObject);
    }
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "not msg imager in cache %s", new Object[] { parama.agl });
    return false;
  }
  
  private static final String d(a parama)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (parama.type == 1)
    {
      localStringBuffer.append(parama.type);
      localStringBuffer.append("-");
      localStringBuffer.append(parama.agh);
      localStringBuffer.append("-");
      localStringBuffer.append(parama.width);
      localStringBuffer.append("-");
      localStringBuffer.append(parama.height);
      localStringBuffer.append("-");
      localStringBuffer.append(parama.ags);
      localStringBuffer.append("-");
      localStringBuffer.append(parama.agk);
    }
    for (;;)
    {
      return com.tencent.mm.a.d.g(localStringBuffer.toString().getBytes());
      if (parama.type == 3)
      {
        localStringBuffer.append(parama.agi);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.width);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.height);
      }
      else if (parama.type == 2)
      {
        localStringBuffer.append(parama.type);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.agh);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.width);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.height);
        localStringBuffer.append("-");
        localStringBuffer.append(parama.ags);
      }
    }
  }
  
  public final void a(a parama)
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMImageLoader", "loadImage %s", new Object[] { parama });
    parama.agl = d(parama);
    parama.agm.setTag(parama.agl);
    if (!c(parama)) {
      this.agt.o(new c(this, parama));
    }
  }
  
  public final Bitmap b(a parama)
  {
    return (Bitmap)this.agu.get(d(parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.c.b
 * JD-Core Version:    0.7.0.1
 */