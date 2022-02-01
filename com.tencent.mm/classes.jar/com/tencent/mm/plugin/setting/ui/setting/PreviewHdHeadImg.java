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
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.f.c;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.wr;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.o;

public class PreviewHdHeadImg
  extends MMActivity
{
  private final int iXy = 2;
  private String username;
  private GetHdHeadImageGalleryView yUA;
  private f yUB;
  private String yUC;
  private final int yUy = 1;
  private final int yUz = 3;
  
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
          ae.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
          this.yUA.setHdHeadImage((Bitmap)localObject);
          this.yUA.setHdHeadImagePath(paramString);
          this.yUC = paramString;
          AppMethodBeat.o(73931);
          return;
        }
      }
      catch (Exception paramBitmap)
      {
        ae.printErrStackTrace("MicroMsg.PreviewHdHeadImg", paramBitmap, "", new Object[0]);
        AppMethodBeat.o(73931);
        return;
      }
      Object localObject = paramBitmap;
    }
  }
  
  private void dQJ()
  {
    AppMethodBeat.i(73929);
    if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
    {
      t.g(getContext(), null);
      d(p.aEA().cA(getContext()), null);
      AppMethodBeat.o(73929);
      return;
    }
    final Bitmap localBitmap1 = dQK();
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
    {
      ae.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.yUA.setThumbImage(localBitmap1);
    }
    for (;;)
    {
      p.aEA();
      Bitmap localBitmap2 = com.tencent.mm.aj.e.DD(this.username);
      if ((localBitmap2 == null) || (localBitmap2.isRecycled())) {
        break;
      }
      ae.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      p.aEA();
      d(localBitmap2, com.tencent.mm.aj.e.J(this.username, true));
      AppMethodBeat.o(73929);
      return;
      ae.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    this.yUB = new f();
    this.yUB.a(this.username, new f.c()
    {
      public final int df(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(190300);
        PreviewHdHeadImg.d(PreviewHdHeadImg.this).sN();
        ae.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          p.aEA();
          Bitmap localBitmap = com.tencent.mm.aj.e.DD(PreviewHdHeadImg.a(PreviewHdHeadImg.this));
          if (localBitmap != null)
          {
            PreviewHdHeadImg localPreviewHdHeadImg = PreviewHdHeadImg.this;
            p.aEA();
            PreviewHdHeadImg.a(localPreviewHdHeadImg, localBitmap, com.tencent.mm.aj.e.J(PreviewHdHeadImg.a(PreviewHdHeadImg.this), true));
          }
          for (;;)
          {
            AppMethodBeat.o(190300);
            return 0;
            PreviewHdHeadImg.a(PreviewHdHeadImg.this, localBitmap1, null);
          }
        }
        PreviewHdHeadImg.a(PreviewHdHeadImg.this, localBitmap1, null);
        AppMethodBeat.o(190300);
        return 0;
      }
    });
    AppMethodBeat.o(73929);
  }
  
  private Bitmap dQK()
  {
    AppMethodBeat.i(73930);
    Bitmap localBitmap2 = com.tencent.mm.aj.c.a(this.username, true, -1, null);
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
        h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, true);
        AppMethodBeat.o(73933);
        return true;
      }
      catch (Exception paramBitmap)
      {
        ae.printErrStackTrace("MicroMsg.PreviewHdHeadImg", paramBitmap, "", new Object[0]);
        ae.e("MicroMsg.PreviewHdHeadImg", "saveBitmapToImage failed:" + paramBitmap.toString());
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
    this.username = v.aAC();
    this.yUA = ((GetHdHeadImageGalleryView)findViewById(2131300335));
    this.yUA.setUsername(this.username);
    dQJ();
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73921);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(PreviewHdHeadImg.this, 1, false);
        paramAnonymousMenuItem.LfS = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(73919);
            paramAnonymous2l.jM(1, 2131763184);
            Bitmap localBitmap = com.tencent.mm.aj.c.a(PreviewHdHeadImg.a(PreviewHdHeadImg.this), true, -1, null);
            p.aEA();
            if (o.fB(com.tencent.mm.aj.e.K(v.aAC() + ".last", true))) {
              paramAnonymous2l.jM(3, 2131763395);
            }
            if (localBitmap != null) {
              paramAnonymous2l.jM(2, 2131760065);
            }
            AppMethodBeat.o(73919);
          }
        };
        paramAnonymousMenuItem.LfT = new n.e()
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
              com.tencent.mm.plugin.account.a.a.iUA.s(PreviewHdHeadImg.this);
              AppMethodBeat.o(73920);
              return;
              PreviewHdHeadImg.b(PreviewHdHeadImg.this);
              AppMethodBeat.o(73920);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.setClass(PreviewHdHeadImg.this.getContext(), PreviewLastHdHeadImg.class);
              p.aEA();
              paramAnonymous2MenuItem.putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.K(v.aAC() + ".crop", true));
              p.aEA();
              paramAnonymous2MenuItem.putExtra("last_avatar_path", com.tencent.mm.aj.e.K(v.aAC() + ".last", true));
              PreviewHdHeadImg.this.startActivityForResult(paramAnonymous2MenuItem, 4);
            }
          }
        };
        paramAnonymousMenuItem.cPF();
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
    ae.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null) {
      ae.e("MicroMsg.PreviewHdHeadImg", "wtf!!! data is null!!!");
    }
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 2) || (paramInt1 == 4)) {
        new aq(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(73926);
            wr localwr = new wr();
            localwr.dMh.dMj = true;
            com.tencent.mm.sdk.b.a.IvT.l(localwr);
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
      p.aEA();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.J(v.aAC() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      com.tencent.mm.plugin.setting.c.iUz.a(this, paramIntent, (Intent)localObject, d.azQ(), 4, null);
      AppMethodBeat.o(73932);
      return;
    }
    new aq(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190301);
        wr localwr = new wr();
        localwr.dMh.dMj = true;
        com.tencent.mm.sdk.b.a.IvT.l(localwr);
        AppMethodBeat.o(190301);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(73932);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = h.aRC(this.yUC);
    if (paramIntent == null)
    {
      ae.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
      AppMethodBeat.o(73932);
      return;
    }
    d(h.aRC(paramIntent), null);
    new n(getContext(), paramIntent).C(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190302);
        ae.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.ajM()), v.aAC() });
        if (com.tencent.mm.kernel.g.ajM())
        {
          if (this.val$bitmap != null)
          {
            p.aEA();
            str = com.tencent.mm.aj.e.K(v.aAC() + ".last", true);
            PreviewHdHeadImg.e(this.val$bitmap, str);
          }
          String str = com.tencent.mm.aj.c.Du(v.aAC());
          bb.hIK.BG(str);
        }
        PreviewHdHeadImg.e(PreviewHdHeadImg.this);
        AppMethodBeat.o(190302);
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