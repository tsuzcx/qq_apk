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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.q;
import com.tencent.mm.f.a.yy;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p.a;
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
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.u;

public class PreviewHdHeadImg
  extends MMActivity
{
  private final int JeP = 1;
  private final int JeQ = 3;
  private GetHdHeadImageGalleryView JeR;
  private g JeS;
  private String JeT;
  private final int mLJ = 2;
  private String username;
  
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
          Log.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
          this.JeR.setHdHeadImage((Bitmap)localObject);
          this.JeR.setHdHeadImagePath(paramString);
          this.JeT = paramString;
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
  
  public static boolean e(Bitmap paramBitmap, String paramString)
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
  
  private void fFO()
  {
    AppMethodBeat.i(73929);
    if (!h.aHG().isSDCardAvailable())
    {
      w.g(getContext(), null);
      d(q.bhz().cT(getContext()), null);
      AppMethodBeat.o(73929);
      return;
    }
    final Bitmap localBitmap1 = fFP();
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled()))
    {
      Log.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", new Object[] { this.username });
      this.JeR.setThumbImage(localBitmap1);
    }
    for (;;)
    {
      q.bhz();
      Bitmap localBitmap2 = com.tencent.mm.am.f.TJ(this.username);
      if ((localBitmap2 == null) || (localBitmap2.isRecycled())) {
        break;
      }
      Log.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", new Object[] { this.username });
      q.bhz();
      d(localBitmap2, com.tencent.mm.am.f.N(this.username, true));
      AppMethodBeat.o(73929);
      return;
      Log.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[] { this.username });
    }
    this.JeS = new g();
    this.JeS.a(this.username, new g.c()
    {
      public final int dL(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(263331);
        PreviewHdHeadImg.d(PreviewHdHeadImg.this).qE();
        Log.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          q.bhz();
          Bitmap localBitmap = com.tencent.mm.am.f.TJ(PreviewHdHeadImg.a(PreviewHdHeadImg.this));
          if (localBitmap != null)
          {
            PreviewHdHeadImg localPreviewHdHeadImg = PreviewHdHeadImg.this;
            q.bhz();
            PreviewHdHeadImg.a(localPreviewHdHeadImg, localBitmap, com.tencent.mm.am.f.N(PreviewHdHeadImg.a(PreviewHdHeadImg.this), true));
          }
          for (;;)
          {
            AppMethodBeat.o(263331);
            return 0;
            PreviewHdHeadImg.a(PreviewHdHeadImg.this, localBitmap1, null);
          }
        }
        PreviewHdHeadImg.a(PreviewHdHeadImg.this, localBitmap1, null);
        AppMethodBeat.o(263331);
        return 0;
      }
    });
    AppMethodBeat.o(73929);
  }
  
  private Bitmap fFP()
  {
    AppMethodBeat.i(73930);
    Bitmap localBitmap2 = com.tencent.mm.am.d.a(this.username, true, -1, null);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = BitmapFactory.decodeResource(getResources(), b.e.default_avatar);
    }
    AppMethodBeat.o(73930);
    return localBitmap1;
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
    this.username = z.bcZ();
    this.JeR = ((GetHdHeadImageGalleryView)findViewById(b.f.gallery));
    this.JeR.setUsername(this.username);
    fFO();
    addIconOptionMenu(0, b.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73921);
        paramAnonymousMenuItem = new e(PreviewHdHeadImg.this, 1, false);
        paramAnonymousMenuItem.ODT = new q.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
          {
            AppMethodBeat.i(73919);
            paramAnonymous2o.mn(1, b.i.settings_avatar_select_from_album);
            Bitmap localBitmap = com.tencent.mm.am.d.a(PreviewHdHeadImg.a(PreviewHdHeadImg.this), true, -1, null);
            q.bhz();
            if (u.agG(com.tencent.mm.am.f.O(z.bcZ() + ".last", true))) {
              paramAnonymous2o.mn(3, b.i.settings_see_last_avatar);
            }
            if (localBitmap != null) {
              paramAnonymous2o.mn(2, b.i.get_hd_head_img_save_alert);
            }
            AppMethodBeat.o(73919);
          }
        };
        paramAnonymousMenuItem.ODU = new q.g()
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
              a.mIH.r(PreviewHdHeadImg.this);
              AppMethodBeat.o(73920);
              return;
              PreviewHdHeadImg.b(PreviewHdHeadImg.this);
              AppMethodBeat.o(73920);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.setClass(PreviewHdHeadImg.this.getContext(), PreviewLastHdHeadImg.class);
              q.bhz();
              paramAnonymous2MenuItem.putExtra("CropImage_OutputPath", com.tencent.mm.am.f.O(z.bcZ() + ".crop", true));
              q.bhz();
              paramAnonymous2MenuItem.putExtra("last_avatar_path", com.tencent.mm.am.f.O(z.bcZ() + ".last", true));
              PreviewHdHeadImg.this.startActivityForResult(paramAnonymous2MenuItem, 4);
            }
          }
        };
        paramAnonymousMenuItem.eik();
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
            AppMethodBeat.i(73925);
            yy localyy = new yy();
            localyy.fYl.fYn = true;
            EventCenter.instance.publish(localyy);
            AppMethodBeat.o(73925);
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
      q.bhz();
      ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.am.f.N(z.bcZ() + ".crop", true));
      ((Intent)localObject).putExtra("CropImage_ImgPath", null);
      ((Intent)localObject).putExtra("CropImage_from_scene", 3);
      c.mIG.a(this, paramIntent, (Intent)localObject, com.tencent.mm.plugin.image.d.bbW(), 4, null);
      AppMethodBeat.o(73932);
      return;
    }
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(73926);
        yy localyy = new yy();
        localyy.fYl.fYn = true;
        EventCenter.instance.publish(localyy);
        AppMethodBeat.o(73926);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(73932);
      return;
    }
    paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
    Object localObject = BitmapUtil.getBitmapNative(this.JeT);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
      AppMethodBeat.o(73932);
      return;
    }
    d(BitmapUtil.getBitmapNative(paramIntent), null);
    new com.tencent.mm.am.o(getContext(), paramIntent).G(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264678);
        Log.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", new Object[] { Boolean.valueOf(h.aHB()), z.bcZ() });
        if (h.aHB())
        {
          if (this.val$bitmap != null)
          {
            q.bhz();
            str = com.tencent.mm.am.f.O(z.bcZ() + ".last", true);
            PreviewHdHeadImg.e(this.val$bitmap, str);
          }
          String str = com.tencent.mm.am.d.Tz(z.bcZ());
          bg.ltv.RF(str);
        }
        PreviewHdHeadImg.e(PreviewHdHeadImg.this);
        AppMethodBeat.o(264678);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg
 * JD-Core Version:    0.7.0.1
 */