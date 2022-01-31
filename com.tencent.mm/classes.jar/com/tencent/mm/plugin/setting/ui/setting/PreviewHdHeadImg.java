package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;

public class PreviewHdHeadImg
  extends MMActivity
{
  private final int qGi = 1;
  private final int qGj = 2;
  private final int qGk = 3;
  private GetHdHeadImageGalleryView qGl;
  private com.tencent.mm.ah.e qGm;
  private String qGn;
  private String username;
  
  private void cjU()
  {
    AppMethodBeat.i(126997);
    if (!g.RL().isSDCardAvailable())
    {
      t.ii(getContext());
      d(o.acQ().bZ(getContext()), null);
      AppMethodBeat.o(126997);
      return;
    }
    Bitmap localBitmap1 = cjV();
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
    {
      ab.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.qGl.setThumbImage(localBitmap1);
    }
    for (;;)
    {
      o.acQ();
      Bitmap localBitmap2 = com.tencent.mm.ah.d.rb(this.username);
      if ((localBitmap2 == null) || (localBitmap2.isRecycled())) {
        break;
      }
      ab.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      o.acQ();
      d(localBitmap2, com.tencent.mm.ah.d.D(this.username, true));
      AppMethodBeat.o(126997);
      return;
      ab.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    this.qGm = new com.tencent.mm.ah.e();
    this.qGm.a(this.username, new PreviewHdHeadImg.3(this, localBitmap1));
    AppMethodBeat.o(126997);
  }
  
  private Bitmap cjV()
  {
    AppMethodBeat.i(126998);
    Bitmap localBitmap2 = com.tencent.mm.ah.b.b(this.username, true, -1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = BitmapFactory.decodeResource(getResources(), 2130838493);
    }
    AppMethodBeat.o(126998);
    return localBitmap1;
  }
  
  private void d(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(126999);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(126999);
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
          ab.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
          this.qGl.setHdHeadImage((Bitmap)localObject);
          this.qGl.setHdHeadImagePath(paramString);
          this.qGn = paramString;
          AppMethodBeat.o(126999);
          return;
        }
      }
      catch (Exception paramBitmap)
      {
        ab.printErrStackTrace("MicroMsg.PreviewHdHeadImg", paramBitmap, "", new Object[0]);
        AppMethodBeat.o(126999);
        return;
      }
      Object localObject = paramBitmap;
    }
  }
  
  public static boolean e(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(127001);
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        com.tencent.mm.sdk.platformtools.d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, true);
        AppMethodBeat.o(127001);
        return true;
      }
      catch (Exception paramBitmap)
      {
        ab.printErrStackTrace("MicroMsg.PreviewHdHeadImg", paramBitmap, "", new Object[0]);
        ab.e("MicroMsg.PreviewHdHeadImg", "saveBitmapToImage failed:" + paramBitmap.toString());
      }
    }
    AppMethodBeat.o(127001);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130969838;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126996);
    setMMTitle(2131303214);
    setActionbarColor(getResources().getColor(2131690605));
    setNavigationbarColor(getResources().getColor(2131689481));
    this.username = r.Zn();
    this.qGl = ((GetHdHeadImageGalleryView)findViewById(2131822137));
    this.qGl.setUsername(this.username);
    cjU();
    addIconOptionMenu(0, 2130839668, new PreviewHdHeadImg.1(this));
    setBackBtn(new PreviewHdHeadImg.2(this));
    AppMethodBeat.o(126996);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(127000);
    ab.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 2) || (paramInt1 == 4)) {
        new ak(Looper.getMainLooper()).post(new PreviewHdHeadImg.4(this));
      }
      AppMethodBeat.o(127000);
      return;
    }
    switch (paramInt1)
    {
    case 3: 
    default: 
      AppMethodBeat.o(127000);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(127000);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_Filter", true);
      o.acQ();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.ah.d.D(r.Zn() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      com.tencent.mm.plugin.setting.b.gmO.a(this, paramIntent, (Intent)localObject, c.YK(), 4, null);
      AppMethodBeat.o(127000);
      return;
    }
    new ak(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126993);
        tm localtm = new tm();
        localtm.cJY.cKa = true;
        a.ymk.l(localtm);
        AppMethodBeat.o(126993);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(127000);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = com.tencent.mm.sdk.platformtools.d.aoV(this.qGn);
    if (paramIntent == null)
    {
      ab.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
      AppMethodBeat.o(127000);
      return;
    }
    d(com.tencent.mm.sdk.platformtools.d.aoV(paramIntent), null);
    new m(getContext(), paramIntent).v(new PreviewHdHeadImg.6(this, (Bitmap)localObject));
    AppMethodBeat.o(127000);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126995);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    AppMethodBeat.o(126995);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg
 * JD-Core Version:    0.7.0.1
 */