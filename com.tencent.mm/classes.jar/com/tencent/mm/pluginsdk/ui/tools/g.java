package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import android.widget.ImageView;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class g
{
  public byte[] dMQ = new byte[0];
  ah dPi;
  volatile boolean smc = false;
  private HandlerThread smd = e.aap("ImageEngine_handlerThread" + System.currentTimeMillis());
  private ah sme;
  public HashMap<String, ImageView> smf = new HashMap();
  public HashMap<ImageView, String> smg = new HashMap();
  g.c<String, Bitmap> smh;
  private SparseArray<Bitmap> smi;
  g.a<g.e> smj;
  g.a<g.b> smk;
  private boolean sml = true;
  private x.a smm = new g.6(this);
  
  public g(int paramInt)
  {
    this.smd.start();
    this.sme = new ah(this.smd.getLooper());
    this.dPi = new ah(Looper.getMainLooper());
    this.smj = new g.1(this, this.smd.getLooper());
    this.smk = new g.2(this, Looper.getMainLooper());
    this.smi = new SparseArray();
    this.smh = new g.3(this, paramInt);
    x.b(this.smm);
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    if (paramInt == 0)
    {
      g.d.g(paramImageView);
      return;
    }
    Bitmap localBitmap2 = (Bitmap)this.smi.get(paramInt);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap1 = a.decodeResource(paramImageView.getResources(), paramInt);
      this.smi.put(paramInt, localBitmap1);
    }
    g.d.b(paramImageView, localBitmap1);
  }
  
  static String q(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return bk.aM(paramString1, "null") + "_" + bk.aM(paramString2, "null") + "_" + paramInt1 + "_" + paramInt2;
  }
  
  public final void a(ImageView paramImageView, String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 0;
    if (!this.sml) {
      return;
    }
    if (this.smc)
    {
      y.w("MicroMsg.ImageEngine", "on attach, isQuit, return");
      return;
    }
    if (paramImageView == null)
    {
      y.w("MicroMsg.ImageEngine", "attach from file path fail, imageview is null");
      return;
    }
    if (((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) && (bk.bl(paramString)))
    {
      y.w("MicroMsg.ImageEngine", "attach from file path fail, path and url are null or empty");
      a(paramImageView, paramInt1);
      return;
    }
    String str1;
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
      str1 = null;
    }
    for (;;)
    {
      str1 = q(str1, paramString, paramInt2, paramInt3);
      synchronized (this.dMQ)
      {
        String str2 = (String)this.smg.get(paramImageView);
        if (str2 != null) {
          this.smf.remove(str2);
        }
        this.smg.put(paramImageView, str1);
        ??? = (Bitmap)this.smh.get(str1);
        if ((??? != null) && (!((Bitmap)???).isRecycled()))
        {
          g.d.b(paramImageView, (Bitmap)???);
          return;
          str1 = paramArrayOfString[0];
        }
      }
    }
    y.v("MicroMsg.ImageEngine", "get first render bmp fail, key[%s]", new Object[] { str1 });
    int j = k;
    int i;
    if (paramArrayOfString != null)
    {
      j = k;
      if (paramArrayOfString.length > 1) {
        i = 1;
      }
    }
    for (;;)
    {
      j = k;
      boolean bool;
      if (i < paramArrayOfString.length)
      {
        ??? = q(paramArrayOfString[i], paramString, paramInt2, paramInt3);
        ??? = (Bitmap)this.smh.get(???);
        if (??? != null)
        {
          bool = true;
          label276:
          y.v("MicroMsg.ImageEngine", "get next render bmp, key[%s], result[%B]", new Object[] { str1, Boolean.valueOf(bool) });
          if (??? == null) {
            break label416;
          }
          g.d.b(paramImageView, (Bitmap)???);
          j = 1;
        }
      }
      else if (j == 0)
      {
        y.v("MicroMsg.ImageEngine", "use default res to render");
        a(paramImageView, paramInt1);
      }
      synchronized (this.dMQ)
      {
        this.smf.put(str1, paramImageView);
        paramImageView = (g.b)this.smk.cok();
        g.b.a(paramImageView, paramArrayOfString);
        g.b.a(paramImageView, paramString);
        g.b.b(paramImageView, str1);
        g.b.a(paramImageView, paramInt2);
        g.b.b(paramImageView, paramInt3);
        this.sme.postAtFrontOfQueueV2(paramImageView);
        return;
        bool = false;
        break label276;
        label416:
        i += 1;
      }
    }
  }
  
  public final void destroy()
  {
    y.d("MicroMsg.ImageEngine", "do destroy");
    this.smc = true;
    this.smd.quit();
    x.c(this.smm);
    SparseArray localSparseArray = this.smi;
    g.c localc = this.smh;
    this.smi = new SparseArray();
    this.smh = new g.4(this);
    e.post(new g.5(this, localSparseArray, localc), "ImageEngine_destroy_" + System.currentTimeMillis());
  }
  
  public v h(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */