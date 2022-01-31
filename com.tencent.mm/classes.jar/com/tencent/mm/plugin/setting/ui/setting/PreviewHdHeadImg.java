package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class PreviewHdHeadImg
  extends MMActivity
{
  private GetHdHeadImageGalleryView lXr;
  private final int nSl = 1;
  private final int nSm = 2;
  private final int nSn = 3;
  private com.tencent.mm.ag.e nSo;
  private String nSp;
  private String username;
  
  private void byK()
  {
    if (!g.DP().isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.gM(this.mController.uMN);
      d(o.JQ().bv(this.mController.uMN), null);
      return;
    }
    Bitmap localBitmap2 = com.tencent.mm.ag.b.a(this.username, true, -1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = BitmapFactory.decodeResource(getResources(), a.e.default_avatar);
    }
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
    {
      y.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.lXr.setThumbImage(localBitmap1);
    }
    for (;;)
    {
      o.JQ();
      localBitmap2 = d.kh(this.username);
      if ((localBitmap2 == null) || (localBitmap2.isRecycled())) {
        break;
      }
      y.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      o.JQ();
      d(localBitmap2, d.z(this.username, true));
      return;
      y.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    this.nSo = new com.tencent.mm.ag.e();
    this.nSo.a(this.username, new PreviewHdHeadImg.3(this, localBitmap1));
  }
  
  private void d(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramBitmap.getWidth() < 480)
        {
          float f = 480.0F / paramBitmap.getWidth();
          localObject = new Matrix();
          ((Matrix)localObject).postScale(f, f);
          localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
          y.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
          this.lXr.setHdHeadImage((Bitmap)localObject);
          this.lXr.setHdHeadImagePath(paramString);
          this.nSp = paramString;
          return;
        }
      }
      catch (Exception paramBitmap)
      {
        y.printErrStackTrace("MicroMsg.PreviewHdHeadImg", paramBitmap, "", new Object[0]);
        return;
      }
      Object localObject = paramBitmap;
    }
  }
  
  public static boolean e(Bitmap paramBitmap, String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        com.tencent.mm.sdk.platformtools.c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, true);
        return true;
      }
      catch (Exception paramBitmap)
      {
        y.printErrStackTrace("MicroMsg.PreviewHdHeadImg", paramBitmap, "", new Object[0]);
        y.e("MicroMsg.PreviewHdHeadImg", "saveBitmapToImage failed:" + paramBitmap.toString());
      }
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.get_hd_head_image_gallery_view;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_avatar);
    ta(getResources().getColor(a.c.transparent));
    this.username = q.Gj();
    this.lXr = ((GetHdHeadImageGalleryView)findViewById(a.f.gallery));
    this.lXr.setUsername(this.username);
    byK();
    addIconOptionMenu(0, a.e.mm_title_btn_menu, new PreviewHdHeadImg.1(this));
    setBackBtn(new PreviewHdHeadImg.2(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1) {
      if ((paramInt1 == 2) || (paramInt1 == 4)) {
        new ah(Looper.getMainLooper()).post(new PreviewHdHeadImg.4(this));
      }
    }
    do
    {
      do
      {
        return;
        switch (paramInt1)
        {
        case 3: 
        default: 
          return;
        }
      } while (paramIntent == null);
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_Filter", true);
      o.JQ();
      ((Intent)localObject).putExtra("CropImage_OutputPath", d.z(q.Gj() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      com.tencent.mm.plugin.setting.b.eUR.a(this, paramIntent, (Intent)localObject, com.tencent.mm.plugin.n.c.FG(), 4, null);
      return;
      new ah(Looper.getMainLooper()).post(new PreviewHdHeadImg.5(this));
    } while (paramIntent == null);
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = com.tencent.mm.sdk.platformtools.c.YW(this.nSp);
    if (paramIntent == null)
    {
      y.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
      return;
    }
    d(com.tencent.mm.sdk.platformtools.c.YW(paramIntent), null);
    new com.tencent.mm.ag.m(this.mController.uMN, paramIntent).b(1, new PreviewHdHeadImg.6(this, (Bitmap)localObject));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg
 * JD-Core Version:    0.7.0.1
 */