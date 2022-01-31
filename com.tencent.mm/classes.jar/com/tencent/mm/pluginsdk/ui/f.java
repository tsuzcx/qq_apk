package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.e;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

public final class f
{
  private static final Drawable lXq = new ColorDrawable();
  private Activity activity;
  private String fRz = null;
  public com.tencent.mm.ui.base.o lXp;
  private GetHdHeadImageGalleryView lXr;
  private e nSo;
  private String rZG = null;
  private f.b rZH;
  private f.a rZI;
  private String username;
  
  public f(Activity paramActivity, String paramString)
  {
    this(paramActivity, paramString, null);
  }
  
  public f(Activity paramActivity, String paramString1, String paramString2)
  {
    this(paramActivity, paramString1, paramString2, f.a.rZL);
  }
  
  public f(Activity paramActivity, String paramString1, String paramString2, f.a parama)
  {
    this(paramActivity, paramString1, paramString2, parama, (byte)0);
  }
  
  private f(Activity paramActivity, String paramString1, String paramString2, f.a parama, byte paramByte)
  {
    this.activity = paramActivity;
    this.username = paramString1;
    this.fRz = paramString2;
    this.rZH = null;
    this.rZI = parama;
  }
  
  private void d(Bitmap paramBitmap, String paramString)
  {
    for (;;)
    {
      try
      {
        if (paramBitmap.getWidth() < 480)
        {
          float f = 480 / paramBitmap.getWidth();
          localObject = new Matrix();
          ((Matrix)localObject).postScale(f, f);
          localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
          y.d("MicroMsg.GetHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
          this.lXr.setHdHeadImage((Bitmap)localObject);
          this.lXr.setHdHeadImagePath(paramString);
          return;
        }
      }
      catch (Exception paramBitmap)
      {
        y.printErrStackTrace("MicroMsg.GetHdHeadImg", paramBitmap, "", new Object[0]);
        return;
      }
      Object localObject = paramBitmap;
    }
  }
  
  public final void cmi()
  {
    Object localObject1 = LayoutInflater.from(this.activity).inflate(R.i.get_hd_head_image_gallery_view, null);
    this.lXp = new com.tencent.mm.ui.base.o((View)localObject1, -1, -1);
    switch (f.3.rZK[this.rZI.ordinal()])
    {
    }
    for (;;)
    {
      this.lXp.setFocusable(true);
      this.lXp.setOutsideTouchable(true);
      this.lXp.setBackgroundDrawable(lXq);
      this.lXp.showAtLocation(this.activity.getWindow().getDecorView(), 49, 0, 0);
      this.lXp.setOnDismissListener(new f.1(this));
      this.lXr = ((GetHdHeadImageGalleryView)((View)localObject1).findViewById(R.h.gallery));
      this.lXr.setParentWindow(this.lXp);
      this.lXr.setUsername(this.username);
      com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(1);
      au.Hx();
      if (c.isSDCardAvailable()) {
        break;
      }
      s.gM(this.activity);
      d(com.tencent.mm.ag.o.JQ().bv(this.activity), null);
      return;
      this.lXp.setAnimationStyle(R.m.PopLeftTopAnimation);
      continue;
      this.lXp.setAnimationStyle(R.m.PopRightTopAnimation);
      continue;
      this.lXp.setAnimationStyle(R.m.PopLeftBottomAnimation);
    }
    Object localObject2;
    if (!bk.bl(this.fRz))
    {
      localObject1 = m.f(this.username, this.fRz, R.g.nosdcard_headimg);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = BitmapFactory.decodeResource(this.activity.getResources(), R.g.default_avatar);
      }
      if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
        break label416;
      }
      y.i("MicroMsg.GetHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.lXr.setThumbImage((Bitmap)localObject2);
    }
    for (;;)
    {
      if (!bk.bl(this.rZG)) {
        this.username = this.rZG;
      }
      com.tencent.mm.ag.o.JQ();
      localObject1 = d.kh(this.username);
      if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
        break label438;
      }
      y.i("MicroMsg.GetHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      com.tencent.mm.ag.o.JQ();
      d((Bitmap)localObject1, d.z(this.username, true));
      return;
      localObject1 = b.a(this.username, true, -1);
      break;
      label416:
      y.i("MicroMsg.GetHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    label438:
    this.nSo = new e();
    this.nSo.a(this.username, new f.2(this, (Bitmap)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.f
 * JD-Core Version:    0.7.0.1
 */