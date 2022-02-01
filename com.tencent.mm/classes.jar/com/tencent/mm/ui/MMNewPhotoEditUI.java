package com.tencent.mm.ui;

import android.app.Activity;
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
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.a.a;
import com.tencent.mm.api.ab.b;
import com.tencent.mm.api.ab.c;
import com.tencent.mm.api.e;
import com.tencent.mm.api.j;
import com.tencent.mm.api.x;
import com.tencent.mm.api.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.m;
import java.io.IOException;

@a(19)
public class MMNewPhotoEditUI
  extends MMActivity
  implements j
{
  private ab FiU;
  private Dialog ODJ;
  private String Wbg;
  private long Wbh;
  private String Wbi;
  private String Wbj;
  private boolean Wbk;
  private boolean Wbl;
  private final d Wbm;
  private PhotoEditProxy Wbn;
  private int jaR;
  private s jhZ;
  
  public MMNewPhotoEditUI()
  {
    AppMethodBeat.i(103219);
    this.Wbm = new d(this);
    this.jhZ = null;
    AppMethodBeat.o(103219);
  }
  
  private void atV(final int paramInt)
  {
    AppMethodBeat.i(103227);
    lG(true);
    this.FiU.a(new com.tencent.mm.api.u()
    {
      public final void a(Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(103218);
        Log.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] w:%s h:%s", new Object[] { Integer.valueOf(paramAnonymousBitmap.getWidth()), Integer.valueOf(paramAnonymousBitmap.getHeight()) });
        String str;
        try
        {
          str = AndroidMediaUtil.getExportImagePath("jpg");
          BitmapUtil.saveBitmapToImage(paramAnonymousBitmap, 100, Bitmap.CompressFormat.PNG, str, true);
          Log.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] photoPath:%s", new Object[] { str });
          MMNewPhotoEditUI.f(MMNewPhotoEditUI.this).recordImage(MMNewPhotoEditUI.c(MMNewPhotoEditUI.this), str, MMNewPhotoEditUI.d(MMNewPhotoEditUI.this), MMNewPhotoEditUI.e(MMNewPhotoEditUI.this).YE().aaa(), MMNewPhotoEditUI.e(MMNewPhotoEditUI.this).YE().aab());
          if ((MMNewPhotoEditUI.g(MMNewPhotoEditUI.this)) || (paramInt == 2)) {
            AndroidMediaUtil.refreshMediaScanner(str, MMNewPhotoEditUI.this);
          }
          if ((paramInt != 0) && (!paramAnonymousBitmap.isRecycled()))
          {
            Log.i("MicroMsg.MMNewPhotoEditUI", "bitmap recycle %s", new Object[] { paramAnonymousBitmap.toString() });
            paramAnonymousBitmap.recycle();
          }
          MMNewPhotoEditUI.a(MMNewPhotoEditUI.this, str);
          if ((MMNewPhotoEditUI.h(MMNewPhotoEditUI.this) != 291) && (MMNewPhotoEditUI.h(MMNewPhotoEditUI.this) != 293)) {
            break label399;
          }
          if (paramInt == 0)
          {
            MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, str);
            MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
            MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 1);
            AppMethodBeat.o(103218);
            return;
          }
          if (paramInt == 1)
          {
            MMNewPhotoEditUI.c(MMNewPhotoEditUI.this, str);
            MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 2);
            Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getString(ai.f.fav_edit_photo_successfully), 1).show();
            MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
            MMNewPhotoEditUI.this.finish();
            AppMethodBeat.o(103218);
            return;
          }
        }
        catch (IOException paramAnonymousBitmap)
        {
          onError(paramAnonymousBitmap);
          AppMethodBeat.o(103218);
          return;
        }
        if (paramInt == 2)
        {
          Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getString(ai.f.exports_saved, new Object[] { AndroidMediaUtil.getSysCameraDirPath() }), 1).show();
          MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 3);
          MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
          MMNewPhotoEditUI.this.finish();
          AppMethodBeat.o(103218);
          return;
          label399:
          MMNewPhotoEditUI.d(MMNewPhotoEditUI.this, str);
        }
        AppMethodBeat.o(103218);
      }
      
      public final void onError(Exception paramAnonymousException)
      {
        AppMethodBeat.i(103217);
        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
        Log.e("MicroMsg.MMNewPhotoEditUI", "[onRefreshed] %s", new Object[] { paramAnonymousException });
        Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getResources().getString(ai.f.err_save_edit_photo), 1).show();
        MMNewPhotoEditUI.this.setResult(0);
        MMNewPhotoEditUI.this.finish();
        AppMethodBeat.o(103217);
      }
    });
    AppMethodBeat.o(103227);
  }
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(103228);
    Log.i("MicroMsg.MMNewPhotoEditUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.jhZ = s.a(this, getString(ai.f.processing), true, 0, null);
      AppMethodBeat.o(103228);
      return;
    }
    if ((this.jhZ != null) && (this.jhZ.isShowing()))
    {
      this.jhZ.dismiss();
      this.jhZ = null;
    }
    AppMethodBeat.o(103228);
  }
  
  protected int getForceOrientation()
  {
    return 1;
  }
  
  protected int getLayoutId()
  {
    return ai.d.new_photo_edit_ui;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(103221);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(ai.c.content);
    this.FiU = ab.fax.YG();
    Object localObject = this.FiU;
    ab.a.a locala = new ab.a.a();
    if ((this.jaR != 291) && (this.jaR != 293)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.faz = bool;
      locala.faD = true;
      locala.fay = ab.c.faG;
      locala.path = this.Wbg;
      ((ab)localObject).a(locala.aae());
      localObject = this.FiU.bA(getContext());
      ((e)localObject).setActionBarCallback(this);
      localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      ((e)localObject).setSelectedFeatureListener(new z()
      {
        public final void a(com.tencent.mm.api.h paramAnonymoush)
        {
          AppMethodBeat.i(103212);
          Log.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedFeature] features:%s", new Object[] { paramAnonymoush.name() });
          AppMethodBeat.o(103212);
        }
        
        public final void a(com.tencent.mm.api.h paramAnonymoush, int paramAnonymousInt, Object paramAnonymousObject)
        {
          AppMethodBeat.i(168715);
          Log.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymoush.name(), Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(168715);
        }
        
        public final void dd(boolean paramAnonymousBoolean)
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
      Log.d("MicroMsg.MMNewPhotoEditUI", "select %s for sending imagePath:%s", new Object[] { str, this.Wbj });
      this.ODJ = com.tencent.mm.ui.base.h.a(getContext(), getString(ai.f.photo_edit_forward_tips), false, null);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      this.Wbn.sendImage(paramIntent, this.Wbj, this.Wbn.getSelfUsername(), str);
      if (this.ODJ != null) {
        this.ODJ.dismiss();
      }
      if (!this.Wbk) {
        com.tencent.mm.vfs.u.deleteFile(this.Wbj);
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(103226);
        return;
        AndroidMediaUtil.refreshMediaScanner(this.Wbj, this);
      }
    }
    if ((paramIntent == null) && (!Util.isNullOrNil(this.Wbj)) && (this.jaR == 291)) {
      com.tencent.mm.vfs.u.deleteFile(this.Wbj);
    }
    AppMethodBeat.o(103226);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(103223);
    if (!this.FiU.YD())
    {
      if ((this.jaR != 290) && (this.jaR != 291)) {
        break label74;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(13859, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(103223);
      return;
      label74:
      if ((this.jaR == 4) || (this.jaR == 293)) {
        com.tencent.mm.plugin.report.service.h.IzE.a(13859, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      } else {
        com.tencent.mm.plugin.report.service.h.IzE.a(13859, new Object[] { Integer.valueOf(0), Integer.valueOf(2) });
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
      c.f(this, false);
    }
    this.Wbn = new PhotoEditProxy(this.Wbm);
    this.Wbm.connect(new Runnable()
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
    AppMethodBeat.o(103220);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(103222);
    super.onDestroy();
    this.FiU.onDestroy();
    this.Wbm.release();
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
    if ((this.jaR == 290) || (this.jaR == 291)) {
      com.tencent.mm.plugin.report.service.h.IzE.a(13859, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
    while ((this.jaR == 291) || (this.jaR == 293))
    {
      m localm = new m(getContext());
      localm.ODT = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(103215);
          paramAnonymouso.d(0, MMNewPhotoEditUI.this.getString(ai.f.retransmits));
          paramAnonymouso.d(1, MMNewPhotoEditUI.this.getString(ai.f.plugin_favorite_opt));
          paramAnonymouso.d(2, MMNewPhotoEditUI.this.getString(ai.f.save_img_to_local));
          AppMethodBeat.o(103215);
        }
      };
      localm.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, final int paramAnonymousInt)
        {
          AppMethodBeat.i(103216);
          p.a(MMNewPhotoEditUI.this, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(262186);
              MMNewPhotoEditUI.a(MMNewPhotoEditUI.this, paramAnonymousInt);
              AppMethodBeat.o(262186);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(262180);
              Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getResources().getString(ai.f.err_save_edit_photo), 1).show();
              AppMethodBeat.o(262180);
            }
          });
          AppMethodBeat.o(103216);
        }
      };
      com.tencent.mm.ui.base.h.a(getContext(), localm.hYu());
      AppMethodBeat.o(103224);
      return;
      if ((this.jaR == 4) || (this.jaR == 293)) {
        com.tencent.mm.plugin.report.service.h.IzE.a(13859, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.h.IzE.a(13859, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
      }
    }
    atV(-1);
    AppMethodBeat.o(103224);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MMNewPhotoEditUI
 * JD-Core Version:    0.7.0.1
 */