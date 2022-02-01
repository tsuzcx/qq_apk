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
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;

public class PreviewHdHeadImg
  extends MMActivity
{
  private final int ibs = 2;
  private String username;
  private final int weC = 1;
  private final int weD = 3;
  private GetHdHeadImageGalleryView weE;
  private com.tencent.mm.ak.f weF;
  private String weG;
  
  private void d(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(73931);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(73931);
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
          ad.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
          this.weE.setHdHeadImage((Bitmap)localObject);
          this.weE.setHdHeadImagePath(paramString);
          this.weG = paramString;
          AppMethodBeat.o(73931);
          return;
        }
      }
      catch (Exception paramBitmap)
      {
        ad.printErrStackTrace("MicroMsg.PreviewHdHeadImg", paramBitmap, "", new Object[0]);
        AppMethodBeat.o(73931);
        return;
      }
      Object localObject = paramBitmap;
    }
  }
  
  private void dnD()
  {
    AppMethodBeat.i(73929);
    if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
    {
      t.g(getContext(), null);
      d(p.auq().cs(getContext()), null);
      AppMethodBeat.o(73929);
      return;
    }
    final Bitmap localBitmap1 = dnE();
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
    {
      ad.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.weE.setThumbImage(localBitmap1);
    }
    for (;;)
    {
      p.auq();
      Bitmap localBitmap2 = com.tencent.mm.ak.e.vW(this.username);
      if ((localBitmap2 == null) || (localBitmap2.isRecycled())) {
        break;
      }
      ad.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      p.auq();
      d(localBitmap2, com.tencent.mm.ak.e.I(this.username, true));
      AppMethodBeat.o(73929);
      return;
      ad.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    this.weF = new com.tencent.mm.ak.f();
    this.weF.a(this.username, new f.c()
    {
      public final int dd(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(186510);
        PreviewHdHeadImg.d(PreviewHdHeadImg.this).auu();
        ad.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          p.auq();
          Bitmap localBitmap = com.tencent.mm.ak.e.vW(PreviewHdHeadImg.a(PreviewHdHeadImg.this));
          if (localBitmap != null)
          {
            PreviewHdHeadImg localPreviewHdHeadImg = PreviewHdHeadImg.this;
            p.auq();
            PreviewHdHeadImg.a(localPreviewHdHeadImg, localBitmap, com.tencent.mm.ak.e.I(PreviewHdHeadImg.a(PreviewHdHeadImg.this), true));
          }
          for (;;)
          {
            AppMethodBeat.o(186510);
            return 0;
            PreviewHdHeadImg.a(PreviewHdHeadImg.this, localBitmap1, null);
          }
        }
        PreviewHdHeadImg.a(PreviewHdHeadImg.this, localBitmap1, null);
        AppMethodBeat.o(186510);
        return 0;
      }
    });
    AppMethodBeat.o(73929);
  }
  
  private Bitmap dnE()
  {
    AppMethodBeat.i(73930);
    Bitmap localBitmap2 = c.a(this.username, true, -1, null);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = BitmapFactory.decodeResource(getResources(), 2131231875);
    }
    AppMethodBeat.o(73930);
    return localBitmap1;
  }
  
  public static boolean e(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(73933);
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, true);
        AppMethodBeat.o(73933);
        return true;
      }
      catch (Exception paramBitmap)
      {
        ad.printErrStackTrace("MicroMsg.PreviewHdHeadImg", paramBitmap, "", new Object[0]);
        ad.e("MicroMsg.PreviewHdHeadImg", "saveBitmapToImage failed:" + paramBitmap.toString());
      }
    }
    AppMethodBeat.o(73933);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131494409;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73928);
    setMMTitle(2131763182);
    setActionbarColor(getResources().getColor(2131101053));
    setNavigationbarColor(getResources().getColor(2131099654));
    this.username = u.aqG();
    this.weE = ((GetHdHeadImageGalleryView)findViewById(2131300335));
    this.weE.setUsername(this.username);
    dnD();
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73921);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(PreviewHdHeadImg.this, 1, false);
        paramAnonymousMenuItem.HrX = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(73919);
            paramAnonymous2l.jj(1, 2131763184);
            Bitmap localBitmap = c.a(PreviewHdHeadImg.a(PreviewHdHeadImg.this), true, -1, null);
            p.auq();
            if (i.eK(com.tencent.mm.ak.e.J(u.aqG() + ".last", true))) {
              paramAnonymous2l.jj(3, 2131763395);
            }
            if (localBitmap != null) {
              paramAnonymous2l.jj(2, 2131760065);
            }
            AppMethodBeat.o(73919);
          }
        };
        paramAnonymousMenuItem.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(73920);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(73920);
              return;
              com.tencent.mm.plugin.account.a.a.hYu.s(PreviewHdHeadImg.this);
              AppMethodBeat.o(73920);
              return;
              PreviewHdHeadImg.b(PreviewHdHeadImg.this);
              AppMethodBeat.o(73920);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.setClass(PreviewHdHeadImg.this.getContext(), PreviewLastHdHeadImg.class);
              p.auq();
              paramAnonymous2MenuItem.putExtra("CropImage_OutputPath", com.tencent.mm.ak.e.J(u.aqG() + ".crop", true));
              p.auq();
              paramAnonymous2MenuItem.putExtra("last_avatar_path", com.tencent.mm.ak.e.J(u.aqG() + ".last", true));
              PreviewHdHeadImg.this.startActivityForResult(paramAnonymous2MenuItem, 4);
            }
          }
        };
        paramAnonymousMenuItem.csG();
        AppMethodBeat.o(73921);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73922);
        PreviewHdHeadImg.this.finish();
        AppMethodBeat.o(73922);
        return true;
      }
    });
    AppMethodBeat.o(73928);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(73932);
    ad.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null) {
      ad.e("MicroMsg.PreviewHdHeadImg", "wtf!!! data is null!!!");
    }
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 2) || (paramInt1 == 4)) {
        new ap(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(73926);
            vk localvk = new vk();
            localvk.dAU.dAW = true;
            com.tencent.mm.sdk.b.a.ESL.l(localvk);
            AppMethodBeat.o(73926);
          }
        });
      }
      AppMethodBeat.o(73932);
      return;
    }
    switch (paramInt1)
    {
    case 3: 
    default: 
      AppMethodBeat.o(73932);
      return;
    case 2: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(73932);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CropImageMode", 1);
      ((Intent)localObject).putExtra("CropImage_Filter", true);
      p.auq();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.ak.e.I(u.aqG() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      com.tencent.mm.plugin.setting.b.hYt.a(this, paramIntent, (Intent)localObject, d.apW(), 4, null);
      AppMethodBeat.o(73932);
      return;
    }
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186511);
        vk localvk = new vk();
        localvk.dAU.dAW = true;
        com.tencent.mm.sdk.b.a.ESL.l(localvk);
        AppMethodBeat.o(186511);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(73932);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = com.tencent.mm.sdk.platformtools.f.aFi(this.weG);
    if (paramIntent == null)
    {
      ad.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
      AppMethodBeat.o(73932);
      return;
    }
    d(com.tencent.mm.sdk.platformtools.f.aFi(paramIntent), null);
    new n(getContext(), paramIntent).D(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186512);
        ad.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.afw()), u.aqG() });
        if (com.tencent.mm.kernel.g.afw())
        {
          if (this.val$bitmap != null)
          {
            p.auq();
            str = com.tencent.mm.ak.e.J(u.aqG() + ".last", true);
            PreviewHdHeadImg.e(this.val$bitmap, str);
          }
          String str = c.vN(u.aqG());
          ay.gNa.ua(str);
        }
        PreviewHdHeadImg.e(PreviewHdHeadImg.this);
        AppMethodBeat.o(186512);
      }
    });
    AppMethodBeat.o(73932);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73927);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    initView();
    AppMethodBeat.o(73927);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg
 * JD-Core Version:    0.7.0.1
 */