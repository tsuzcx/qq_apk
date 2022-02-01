package com.tencent.mm.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a.a;
import com.tencent.mm.api.ac.b;
import com.tencent.mm.api.ac.c;
import com.tencent.mm.api.f;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import java.io.IOException;
import java.util.Locale;

@a(19)
public class MMNewPhotoEditUI
  extends MMActivity
  implements com.tencent.mm.api.k
{
  private ac Les;
  private Dialog VsX;
  private String adGD;
  private long adGE;
  private String adGF;
  private String adGG;
  private boolean adGH;
  private boolean adGI;
  private final d adGJ;
  private PhotoEditProxy adGK;
  private int lCR;
  private com.tencent.mm.ui.base.w lKp;
  private boolean rPj;
  
  public MMNewPhotoEditUI()
  {
    AppMethodBeat.i(103219);
    this.adGJ = new d(this);
    this.lKp = null;
    AppMethodBeat.o(103219);
  }
  
  private void aAo(final int paramInt)
  {
    AppMethodBeat.i(103227);
    na(true);
    this.Les.a(new com.tencent.mm.api.w()
    {
      public final void b(Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(103218);
        Log.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] w:%s h:%s", new Object[] { Integer.valueOf(paramAnonymousBitmap.getWidth()), Integer.valueOf(paramAnonymousBitmap.getHeight()) });
        String str;
        try
        {
          if (MMNewPhotoEditUI.c(MMNewPhotoEditUI.this)) {}
          for (str = AndroidMediaUtil.getExportImagePath("jpg");; str = str + String.format(Locale.US, "%s%d.%s", new Object[] { "mmexport", Long.valueOf(System.currentTimeMillis()), "jpg" }))
          {
            BitmapUtil.saveBitmapToImage(paramAnonymousBitmap, 100, Bitmap.CompressFormat.PNG, str, true);
            Log.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] photoPath:%s", new Object[] { str });
            MMNewPhotoEditUI.g(MMNewPhotoEditUI.this).recordImage(MMNewPhotoEditUI.d(MMNewPhotoEditUI.this), str, MMNewPhotoEditUI.e(MMNewPhotoEditUI.this), MMNewPhotoEditUI.f(MMNewPhotoEditUI.this).aAy().aBG(), MMNewPhotoEditUI.f(MMNewPhotoEditUI.this).aAy().aBH());
            if ((MMNewPhotoEditUI.h(MMNewPhotoEditUI.this)) || (paramInt == 2)) {
              AndroidMediaUtil.refreshMediaScanner(str, MMNewPhotoEditUI.this);
            }
            if ((paramInt != 0) && (!paramAnonymousBitmap.isRecycled()))
            {
              Log.i("MicroMsg.MMNewPhotoEditUI", "bitmap recycle %s", new Object[] { paramAnonymousBitmap.toString() });
              paramAnonymousBitmap.recycle();
            }
            MMNewPhotoEditUI.a(MMNewPhotoEditUI.this, str);
            if ((MMNewPhotoEditUI.i(MMNewPhotoEditUI.this) != 291) && (MMNewPhotoEditUI.i(MMNewPhotoEditUI.this) != 293)) {
              break label477;
            }
            if (paramInt != 0) {
              break;
            }
            MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, str);
            MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
            MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 1);
            AppMethodBeat.o(103218);
            return;
            str = b.bmx();
            if (!com.tencent.mm.vfs.y.ZC(str)) {
              com.tencent.mm.vfs.y.bDX(str);
            }
          }
          if (paramInt == 1)
          {
            MMNewPhotoEditUI.c(MMNewPhotoEditUI.this, str);
            MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 2);
            Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getString(am.g.fav_edit_photo_successfully), 1).show();
            MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
            MMNewPhotoEditUI.this.finish();
            AppMethodBeat.o(103218);
            return;
          }
        }
        catch (IOException paramAnonymousBitmap)
        {
          f(paramAnonymousBitmap);
          AppMethodBeat.o(103218);
          return;
        }
        if (paramInt == 2)
        {
          Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getString(am.g.exports_saved, new Object[] { AndroidMediaUtil.getSysCameraDirPath() }), 1).show();
          MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 3);
          MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
          MMNewPhotoEditUI.this.finish();
          AppMethodBeat.o(103218);
          return;
          label477:
          MMNewPhotoEditUI.d(MMNewPhotoEditUI.this, str);
        }
        AppMethodBeat.o(103218);
      }
      
      public final void f(Exception paramAnonymousException)
      {
        AppMethodBeat.i(103217);
        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
        Log.e("MicroMsg.MMNewPhotoEditUI", "[onRefreshed] %s", new Object[] { paramAnonymousException });
        Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getResources().getString(am.g.err_save_edit_photo), 1).show();
        MMNewPhotoEditUI.this.setResult(0);
        MMNewPhotoEditUI.this.finish();
        AppMethodBeat.o(103217);
      }
    });
    AppMethodBeat.o(103227);
  }
  
  private void na(boolean paramBoolean)
  {
    AppMethodBeat.i(103228);
    Log.i("MicroMsg.MMNewPhotoEditUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.lKp = com.tencent.mm.ui.base.w.a(this, getString(am.g.processing), true, 0, null);
      AppMethodBeat.o(103228);
      return;
    }
    if ((this.lKp != null) && (this.lKp.isShowing()))
    {
      this.lKp.dismiss();
      this.lKp = null;
    }
    AppMethodBeat.o(103228);
  }
  
  protected int getForceOrientation()
  {
    return 1;
  }
  
  protected int getLayoutId()
  {
    return am.e.new_photo_edit_ui;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(103221);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(am.d.content);
    this.Les = ac.hdY.aAA();
    Object localObject = this.Les;
    ac.a.a locala = new ac.a.a();
    if ((this.lCR != 291) && (this.lCR != 293)) {}
    for (boolean bool = true;; bool = false)
    {
      ((ac)localObject).a(locala.dR(bool).dQ(true).a(ac.c.heg).hX(this.adGD).hee);
      localObject = this.Les.cn(getContext());
      ((f)localObject).setActionBarCallback(this);
      localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      ((f)localObject).setSelectedFeatureListener(new aa()
      {
        public final void a(com.tencent.mm.api.i paramAnonymousi)
        {
          AppMethodBeat.i(103212);
          Log.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedFeature] features:%s", new Object[] { paramAnonymousi.name() });
          AppMethodBeat.o(103212);
        }
        
        public final void a(com.tencent.mm.api.i paramAnonymousi, int paramAnonymousInt, Object paramAnonymousObject)
        {
          AppMethodBeat.i(168715);
          Log.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousi.name(), Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(168715);
        }
        
        public final void dP(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(103214);
          if (paramAnonymousBoolean)
          {
            MMNewPhotoEditUI.this.showVKB();
            AppMethodBeat.o(103214);
            return;
          }
          MMNewPhotoEditUI.this.hideVKB(MMNewPhotoEditUI.this.getContentView());
          AppMethodBeat.o(103214);
        }
      });
      AppMethodBeat.o(103221);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(103226);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("Select_Conv_User");
      Log.d("MicroMsg.MMNewPhotoEditUI", "select %s for sending imagePath:%s", new Object[] { str, this.adGG });
      this.VsX = com.tencent.mm.ui.base.k.a(getContext(), getString(am.g.photo_edit_forward_tips), false, null);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      this.adGK.sendImage(paramIntent, this.adGG, this.adGK.getSelfUsername(), str);
      if (this.VsX != null) {
        this.VsX.dismiss();
      }
      if (!this.adGH) {
        com.tencent.mm.vfs.y.deleteFile(this.adGG);
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(103226);
        return;
        AndroidMediaUtil.refreshMediaScanner(this.adGG, this);
      }
    }
    if ((paramIntent == null) && (!Util.isNullOrNil(this.adGG)) && (this.lCR == 291)) {
      com.tencent.mm.vfs.y.deleteFile(this.adGG);
    }
    AppMethodBeat.o(103226);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(103223);
    if (!this.Les.aAx())
    {
      if ((this.lCR != 290) && (this.lCR != 291)) {
        break label74;
      }
      h.OAn.b(13859, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(103223);
      return;
      label74:
      if ((this.lCR == 4) || (this.lCR == 293)) {
        h.OAn.b(13859, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      } else {
        h.OAn.b(13859, new Object[] { Integer.valueOf(0), Integer.valueOf(2) });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103220);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true, 0L);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
      c.h(this, false);
    }
    this.adGK = new PhotoEditProxy(this.adGJ);
    this.adGJ.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103211);
        Log.i("MicroMsg.MMNewPhotoEditUI", "connected!!!");
        MMNewPhotoEditUI.a(MMNewPhotoEditUI.this);
        MMNewPhotoEditUI.this.initView();
        AppMethodBeat.o(103211);
      }
    });
    this.rPj = com.tencent.luggage.l.i.s(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    Log.i("MicroMsg.MMNewPhotoEditUI", "has external storage permission: %b", new Object[] { Boolean.valueOf(this.rPj) });
    AppMethodBeat.o(103220);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(103222);
    super.onDestroy();
    this.Les.onDestroy();
    this.adGJ.release();
    AppMethodBeat.o(103222);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(103225);
    onBackPressed();
    AppMethodBeat.o(103225);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(103224);
    if ((this.lCR == 290) || (this.lCR == 291)) {
      h.OAn.b(13859, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
    while ((this.lCR == 291) || (this.lCR == 293))
    {
      l locall = new l(getContext());
      locall.Vtg = new u.g()
      {
        public final void onCreateMMMenu(s paramAnonymouss)
        {
          AppMethodBeat.i(103215);
          paramAnonymouss.c(0, MMNewPhotoEditUI.this.getString(am.g.retransmits));
          paramAnonymouss.c(1, MMNewPhotoEditUI.this.getString(am.g.plugin_favorite_opt));
          paramAnonymouss.c(2, MMNewPhotoEditUI.this.getString(am.g.save_img_to_local));
          AppMethodBeat.o(103215);
        }
      };
      locall.GAC = new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, final int paramAnonymousInt)
        {
          AppMethodBeat.i(103216);
          ExportFileUtil.a(MMNewPhotoEditUI.this, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(250666);
              MMNewPhotoEditUI.a(MMNewPhotoEditUI.this, paramAnonymousInt);
              AppMethodBeat.o(250666);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(250261);
              Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getResources().getString(am.g.err_save_edit_photo), 1).show();
              AppMethodBeat.o(250261);
            }
          });
          AppMethodBeat.o(103216);
        }
      };
      com.tencent.mm.ui.base.k.a(getContext(), locall.jDd());
      AppMethodBeat.o(103224);
      return;
      if ((this.lCR == 4) || (this.lCR == 293)) {
        h.OAn.b(13859, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      } else {
        h.OAn.b(13859, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
      }
    }
    aAo(-1);
    AppMethodBeat.o(103224);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.MMNewPhotoEditUI
 * JD-Core Version:    0.7.0.1
 */