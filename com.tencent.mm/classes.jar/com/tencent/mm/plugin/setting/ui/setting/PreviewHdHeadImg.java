package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aar;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.f.d;
import com.tencent.mm.modelavatar.o;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.account.sdk.a;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.vfs.y;

public class PreviewHdHeadImg
  extends MMActivity
{
  private final int Ppm = 1;
  private final int Ppn = 3;
  private GetHdHeadImageGalleryView Ppo;
  private com.tencent.mm.modelavatar.f Ppp;
  private String Ppq;
  private boolean Ppr = false;
  private final int pIr = 2;
  private String username;
  
  private void g(Bitmap paramBitmap, String paramString)
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
          Log.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
          this.Ppo.setHdHeadImage((Bitmap)localObject);
          this.Ppo.setHdHeadImagePath(paramString);
          this.Ppq = paramString;
          AppMethodBeat.o(73931);
          return;
        }
      }
      catch (Exception paramBitmap)
      {
        Log.printErrStackTrace("MicroMsg.PreviewHdHeadImg", paramBitmap, "", new Object[0]);
        AppMethodBeat.o(73931);
        return;
      }
      Object localObject = paramBitmap;
    }
  }
  
  private void gVc()
  {
    AppMethodBeat.i(73929);
    if (!h.baE().isSDCardAvailable())
    {
      aa.j(getContext(), null);
      g(q.bFp().dO(getContext()), null);
      AppMethodBeat.o(73929);
      return;
    }
    final Bitmap localBitmap1 = gVd();
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
    {
      Log.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.Ppo.setThumbImage(localBitmap1);
    }
    for (;;)
    {
      q.bFp();
      Bitmap localBitmap2 = AvatarStorage.LJ(this.username);
      if ((localBitmap2 == null) || (localBitmap2.isRecycled())) {
        break;
      }
      Log.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      q.bFp();
      g(localBitmap2, AvatarStorage.Q(this.username, true));
      AppMethodBeat.o(73929);
      return;
      Log.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    this.Ppp = new com.tencent.mm.modelavatar.f();
    this.Ppp.a(this.username, new f.d()
    {
      public final int resultCallback(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(298738);
        PreviewHdHeadImg.e(PreviewHdHeadImg.this).Qh();
        Log.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          q.bFp();
          Bitmap localBitmap = AvatarStorage.LJ(PreviewHdHeadImg.b(PreviewHdHeadImg.this));
          if (localBitmap != null)
          {
            PreviewHdHeadImg localPreviewHdHeadImg = PreviewHdHeadImg.this;
            q.bFp();
            PreviewHdHeadImg.a(localPreviewHdHeadImg, localBitmap, AvatarStorage.Q(PreviewHdHeadImg.b(PreviewHdHeadImg.this), true));
          }
          for (;;)
          {
            AppMethodBeat.o(298738);
            return 0;
            PreviewHdHeadImg.a(PreviewHdHeadImg.this, localBitmap1, null);
          }
        }
        PreviewHdHeadImg.a(PreviewHdHeadImg.this, localBitmap1, null);
        AppMethodBeat.o(298738);
        return 0;
      }
    });
    AppMethodBeat.o(73929);
  }
  
  private Bitmap gVd()
  {
    AppMethodBeat.i(73930);
    Bitmap localBitmap2 = com.tencent.mm.modelavatar.d.a(this.username, true, -1, null);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = BitmapFactory.decodeResource(getResources(), b.e.default_avatar);
    }
    AppMethodBeat.o(73930);
    return localBitmap1;
  }
  
  public static boolean h(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(73933);
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, true);
        AppMethodBeat.o(73933);
        return true;
      }
      catch (Exception paramBitmap)
      {
        Log.printErrStackTrace("MicroMsg.PreviewHdHeadImg", paramBitmap, "", new Object[0]);
        Log.e("MicroMsg.PreviewHdHeadImg", "saveBitmapToImage failed:" + paramBitmap.toString());
      }
    }
    AppMethodBeat.o(73933);
    return false;
  }
  
  public int getLayoutId()
  {
    return b.g.get_hd_head_image_gallery_view;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73928);
    setMMTitle(b.i.settings_avatar);
    setActionbarColor(getResources().getColor(b.c.transparent));
    setNavigationbarColor(getResources().getColor(b.c.BW_0));
    this.username = z.bAM();
    this.Ppr = getIntent().getBooleanExtra("need_show_menu_choose", false);
    this.Ppo = ((GetHdHeadImageGalleryView)findViewById(b.f.gallery));
    this.Ppo.setUsername(this.username);
    gVc();
    addIconOptionMenu(0, b.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73921);
        PreviewHdHeadImg.a(PreviewHdHeadImg.this);
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
    if (this.Ppr) {
      this.Ppo.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(298758);
          PreviewHdHeadImg.a(PreviewHdHeadImg.this);
          AppMethodBeat.o(298758);
        }
      }, 150L);
    }
    AppMethodBeat.o(73928);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(73932);
    Log.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null) {
      Log.e("MicroMsg.PreviewHdHeadImg", "wtf!!! data is null!!!");
    }
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 2) || (paramInt1 == 4)) {
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(298731);
            aar localaar = new aar();
            localaar.iel.ien = true;
            localaar.publish();
            AppMethodBeat.o(298731);
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
      q.bFp();
      ((Intent)localObject).putExtra("CropImage_OutputPath", AvatarStorage.Q(z.bAM() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      c.pFn.a(this, paramIntent, (Intent)localObject, com.tencent.mm.plugin.image.d.bzL(), null);
      AppMethodBeat.o(73932);
      return;
    }
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(298784);
        aar localaar = new aar();
        localaar.iel.ien = true;
        localaar.publish();
        AppMethodBeat.o(298784);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(73932);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = BitmapUtil.getBitmapNative(this.Ppq);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
      AppMethodBeat.o(73932);
      return;
    }
    g(BitmapUtil.getBitmapNative(paramIntent), null);
    new o(getContext(), paramIntent, false).L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(298689);
        Log.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(h.baz()), z.bAM() });
        if (h.baz())
        {
          if (this.val$bitmap != null)
          {
            q.bFp();
            str = AvatarStorage.R(z.bAM() + ".last", true);
            PreviewHdHeadImg.h(this.val$bitmap, str);
          }
          String str = com.tencent.mm.modelavatar.d.Lz(z.bAM());
          bg.okT.JD(str);
        }
        PreviewHdHeadImg.f(PreviewHdHeadImg.this);
        AppMethodBeat.o(298689);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg
 * JD-Core Version:    0.7.0.1
 */