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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;

public class PreviewHdHeadImg
  extends MMActivity
{
  private final int iUF = 2;
  private String username;
  private final int yEt = 1;
  private final int yEu = 3;
  private GetHdHeadImageGalleryView yEv;
  private f yEw;
  private String yEx;
  
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
          this.yEv.setHdHeadImage((Bitmap)localObject);
          this.yEv.setHdHeadImagePath(paramString);
          this.yEx = paramString;
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
  
  private void dNn()
  {
    AppMethodBeat.i(73929);
    if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
    {
      t.g(getContext(), null);
      d(p.aEk().cy(getContext()), null);
      AppMethodBeat.o(73929);
      return;
    }
    final Bitmap localBitmap1 = dNo();
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
    {
      ad.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.yEv.setThumbImage(localBitmap1);
    }
    for (;;)
    {
      p.aEk();
      Bitmap localBitmap2 = com.tencent.mm.ak.e.Db(this.username);
      if ((localBitmap2 == null) || (localBitmap2.isRecycled())) {
        break;
      }
      ad.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      p.aEk();
      d(localBitmap2, com.tencent.mm.ak.e.J(this.username, true));
      AppMethodBeat.o(73929);
      return;
      ad.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    this.yEw = new f();
    this.yEw.a(this.username, new f.c()
    {
      public final int df(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(220938);
        PreviewHdHeadImg.d(PreviewHdHeadImg.this).sN();
        ad.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          p.aEk();
          Bitmap localBitmap = com.tencent.mm.ak.e.Db(PreviewHdHeadImg.a(PreviewHdHeadImg.this));
          if (localBitmap != null)
          {
            PreviewHdHeadImg localPreviewHdHeadImg = PreviewHdHeadImg.this;
            p.aEk();
            PreviewHdHeadImg.a(localPreviewHdHeadImg, localBitmap, com.tencent.mm.ak.e.J(PreviewHdHeadImg.a(PreviewHdHeadImg.this), true));
          }
          for (;;)
          {
            AppMethodBeat.o(220938);
            return 0;
            PreviewHdHeadImg.a(PreviewHdHeadImg.this, localBitmap1, null);
          }
        }
        PreviewHdHeadImg.a(PreviewHdHeadImg.this, localBitmap1, null);
        AppMethodBeat.o(220938);
        return 0;
      }
    });
    AppMethodBeat.o(73929);
  }
  
  private Bitmap dNo()
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
        com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, true);
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
    this.username = u.aAm();
    this.yEv = ((GetHdHeadImageGalleryView)findViewById(2131300335));
    this.yEv.setUsername(this.username);
    dNn();
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73921);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(PreviewHdHeadImg.this, 1, false);
        paramAnonymousMenuItem.KJy = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(73919);
            paramAnonymous2l.jI(1, 2131763184);
            Bitmap localBitmap = c.a(PreviewHdHeadImg.a(PreviewHdHeadImg.this), true, -1, null);
            p.aEk();
            if (i.fv(com.tencent.mm.ak.e.K(u.aAm() + ".last", true))) {
              paramAnonymous2l.jI(3, 2131763395);
            }
            if (localBitmap != null) {
              paramAnonymous2l.jI(2, 2131760065);
            }
            AppMethodBeat.o(73919);
          }
        };
        paramAnonymousMenuItem.KJz = new n.e()
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
              com.tencent.mm.plugin.account.a.a.iRH.s(PreviewHdHeadImg.this);
              AppMethodBeat.o(73920);
              return;
              PreviewHdHeadImg.b(PreviewHdHeadImg.this);
              AppMethodBeat.o(73920);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.setClass(PreviewHdHeadImg.this.getContext(), PreviewLastHdHeadImg.class);
              p.aEk();
              paramAnonymous2MenuItem.putExtra("CropImage_OutputPath", com.tencent.mm.ak.e.K(u.aAm() + ".crop", true));
              p.aEk();
              paramAnonymous2MenuItem.putExtra("last_avatar_path", com.tencent.mm.ak.e.K(u.aAm() + ".last", true));
              PreviewHdHeadImg.this.startActivityForResult(paramAnonymous2MenuItem, 4);
            }
          }
        };
        paramAnonymousMenuItem.cMW();
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
            wn localwn = new wn();
            localwn.dKS.dKU = true;
            com.tencent.mm.sdk.b.a.IbL.l(localwn);
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
      p.aEk();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.ak.e.J(u.aAm() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      com.tencent.mm.plugin.setting.b.iRG.a(this, paramIntent, (Intent)localObject, d.azA(), 4, null);
      AppMethodBeat.o(73932);
      return;
    }
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220939);
        wn localwn = new wn();
        localwn.dKS.dKU = true;
        com.tencent.mm.sdk.b.a.IbL.l(localwn);
        AppMethodBeat.o(220939);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(73932);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = com.tencent.mm.sdk.platformtools.g.aQf(this.yEx);
    if (paramIntent == null)
    {
      ad.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
      AppMethodBeat.o(73932);
      return;
    }
    d(com.tencent.mm.sdk.platformtools.g.aQf(paramIntent), null);
    new n(getContext(), paramIntent).E(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220940);
        ad.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.ajx()), u.aAm() });
        if (com.tencent.mm.kernel.g.ajx())
        {
          if (this.val$bitmap != null)
          {
            p.aEk();
            str = com.tencent.mm.ak.e.K(u.aAm() + ".last", true);
            PreviewHdHeadImg.e(this.val$bitmap, str);
          }
          String str = c.CS(u.aAm());
          az.hFS.Be(str);
        }
        PreviewHdHeadImg.e(PreviewHdHeadImg.this);
        AppMethodBeat.o(220940);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg
 * JD-Core Version:    0.7.0.1
 */