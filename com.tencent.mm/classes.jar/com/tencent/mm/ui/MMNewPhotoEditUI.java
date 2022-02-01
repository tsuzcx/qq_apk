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
import com.tencent.mm.api.e;
import com.tencent.mm.api.g;
import com.tencent.mm.api.s;
import com.tencent.mm.api.u;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.a.a;
import com.tencent.mm.api.y.b;
import com.tencent.mm.api.y.c;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.io.IOException;

@a(19)
public class MMNewPhotoEditUI
  extends MMActivity
  implements com.tencent.mm.api.i
{
  private Dialog BnV;
  private String Hpb;
  private long Hpc;
  private String Hpd;
  private String Hpe;
  private boolean Hpf;
  private boolean Hpg;
  private final d Hph;
  private PhotoEditProxy Hpi;
  private int fwc;
  private com.tencent.mm.ui.base.p fxw;
  private y uUi;
  
  public MMNewPhotoEditUI()
  {
    AppMethodBeat.i(103219);
    this.Hph = new d(this);
    this.fxw = null;
    AppMethodBeat.o(103219);
  }
  
  private void Zz(final int paramInt)
  {
    AppMethodBeat.i(103227);
    ji(true);
    this.uUi.a(new s()
    {
      public final void a(Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(103218);
        ac.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] w:%s h:%s", new Object[] { Integer.valueOf(paramAnonymousBitmap.getWidth()), Integer.valueOf(paramAnonymousBitmap.getHeight()) });
        String str;
        try
        {
          str = com.tencent.mm.sdk.f.b.alY("jpg");
          f.a(paramAnonymousBitmap, 100, Bitmap.CompressFormat.PNG, str, true);
          ac.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] photoPath:%s", new Object[] { str });
          MMNewPhotoEditUI.f(MMNewPhotoEditUI.this).recordImage(MMNewPhotoEditUI.c(MMNewPhotoEditUI.this), str, MMNewPhotoEditUI.d(MMNewPhotoEditUI.this), MMNewPhotoEditUI.e(MMNewPhotoEditUI.this).Iv().JL(), MMNewPhotoEditUI.e(MMNewPhotoEditUI.this).Iv().JM());
          if ((MMNewPhotoEditUI.g(MMNewPhotoEditUI.this)) || (paramInt == 2)) {
            com.tencent.mm.sdk.f.b.k(str, MMNewPhotoEditUI.this);
          }
          if ((paramInt != 0) && (!paramAnonymousBitmap.isRecycled()))
          {
            ac.i("MicroMsg.MMNewPhotoEditUI", "bitmap recycle %s", new Object[] { paramAnonymousBitmap.toString() });
            paramAnonymousBitmap.recycle();
          }
          MMNewPhotoEditUI.a(MMNewPhotoEditUI.this, str);
          if ((MMNewPhotoEditUI.h(MMNewPhotoEditUI.this) != 291) && (MMNewPhotoEditUI.h(MMNewPhotoEditUI.this) != 293)) {
            break label397;
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
            Toast.makeText(ai.getContext(), MMNewPhotoEditUI.this.getString(2131758829), 1).show();
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
          Toast.makeText(ai.getContext(), MMNewPhotoEditUI.this.getString(2131758632, new Object[] { com.tencent.mm.loader.j.b.aps() }), 1).show();
          MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 3);
          MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
          MMNewPhotoEditUI.this.finish();
          AppMethodBeat.o(103218);
          return;
          label397:
          MMNewPhotoEditUI.d(MMNewPhotoEditUI.this, str);
        }
        AppMethodBeat.o(103218);
      }
      
      public final void onError(Exception paramAnonymousException)
      {
        AppMethodBeat.i(103217);
        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
        ac.e("MicroMsg.MMNewPhotoEditUI", "[onRefreshed] %s", new Object[] { paramAnonymousException });
        Toast.makeText(ai.getContext(), MMNewPhotoEditUI.this.getResources().getString(2131758458), 1).show();
        MMNewPhotoEditUI.this.setResult(0);
        MMNewPhotoEditUI.this.finish();
        AppMethodBeat.o(103217);
      }
    });
    AppMethodBeat.o(103227);
  }
  
  private void ji(boolean paramBoolean)
  {
    AppMethodBeat.i(103228);
    ac.i("MicroMsg.MMNewPhotoEditUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.fxw = com.tencent.mm.ui.base.p.a(this, getString(2131762020), true, 0, null);
      AppMethodBeat.o(103228);
      return;
    }
    if ((this.fxw != null) && (this.fxw.isShowing()))
    {
      this.fxw.dismiss();
      this.fxw = null;
    }
    AppMethodBeat.o(103228);
  }
  
  protected int getForceOrientation()
  {
    return 1;
  }
  
  protected int getLayoutId()
  {
    return 2131495017;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(103221);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131298739);
    this.uUi = y.cGI.Ix();
    Object localObject = this.uUi;
    y.a.a locala = new y.a.a();
    if ((this.fwc != 291) && (this.fwc != 293)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.cGK = bool;
      locala.cGN = true;
      locala.cGJ = y.c.cGQ;
      locala.path = this.Hpb;
      ((y)localObject).a(locala.JO());
      localObject = this.uUi.bg(getContext());
      ((e)localObject).setActionBarCallback(this);
      localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      ((e)localObject).setSelectedFeatureListener(new w()
      {
        public final void a(g paramAnonymousg)
        {
          AppMethodBeat.i(103212);
          ac.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedFeature] features:%s", new Object[] { paramAnonymousg.name() });
          AppMethodBeat.o(103212);
        }
        
        public final void a(g paramAnonymousg, int paramAnonymousInt, Object paramAnonymousObject)
        {
          AppMethodBeat.i(168715);
          ac.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousg.name(), Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(168715);
        }
        
        public final void bW(boolean paramAnonymousBoolean)
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
      ac.d("MicroMsg.MMNewPhotoEditUI", "select %s for sending imagePath:%s", new Object[] { str, this.Hpe });
      this.BnV = com.tencent.mm.ui.base.h.b(getContext(), getString(2131761896), false, null);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      this.Hpi.sendImage(paramIntent, this.Hpe, this.Hpi.getSelfUsername(), str);
      if (this.BnV != null) {
        this.BnV.dismiss();
      }
      if (!this.Hpf) {
        com.tencent.mm.vfs.i.deleteFile(this.Hpe);
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(103226);
        return;
        com.tencent.mm.sdk.f.b.k(this.Hpe, this);
      }
    }
    if ((paramIntent == null) && (!bs.isNullOrNil(this.Hpe)) && (this.fwc == 291)) {
      com.tencent.mm.vfs.i.deleteFile(this.Hpe);
    }
    AppMethodBeat.o(103226);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(103223);
    if (!this.uUi.Iu())
    {
      if ((this.fwc != 290) && (this.fwc != 291)) {
        break label74;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(13859, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(103223);
      return;
      label74:
      if ((this.fwc == 4) || (this.fwc == 293)) {
        com.tencent.mm.plugin.report.service.h.wUl.f(13859, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      } else {
        com.tencent.mm.plugin.report.service.h.wUl.f(13859, new Object[] { Integer.valueOf(0), Integer.valueOf(2) });
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
      b.c(this, false);
    }
    this.Hpi = new PhotoEditProxy(this.Hph);
    this.Hph.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103211);
        ac.i("MicroMsg.MMNewPhotoEditUI", "connected!!!");
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
    this.uUi.onDestroy();
    this.Hph.release();
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
    if ((this.fwc == 290) || (this.fwc == 291)) {
      com.tencent.mm.plugin.report.service.h.wUl.f(13859, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
    while ((this.fwc == 291) || (this.fwc == 293))
    {
      com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(getContext());
      locall.ISu = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(103215);
          paramAnonymousl.c(0, MMNewPhotoEditUI.this.getString(2131762566));
          paramAnonymousl.c(1, MMNewPhotoEditUI.this.getString(2131761941));
          paramAnonymousl.c(2, MMNewPhotoEditUI.this.getString(2131762781));
          AppMethodBeat.o(103215);
        }
      };
      locall.ISv = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, final int paramAnonymousInt)
        {
          AppMethodBeat.i(103216);
          com.tencent.mm.platformtools.p.a(MMNewPhotoEditUI.this, new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(199896);
              MMNewPhotoEditUI.a(MMNewPhotoEditUI.this, paramAnonymousInt);
              AppMethodBeat.o(199896);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(199897);
              Toast.makeText(ai.getContext(), MMNewPhotoEditUI.this.getResources().getString(2131758458), 1).show();
              AppMethodBeat.o(199897);
            }
          });
          AppMethodBeat.o(103216);
        }
      };
      com.tencent.mm.ui.base.h.a(getContext(), locall.ftL());
      AppMethodBeat.o(103224);
      return;
      if ((this.fwc == 4) || (this.fwc == 293)) {
        com.tencent.mm.plugin.report.service.h.wUl.f(13859, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.h.wUl.f(13859, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
      }
    }
    Zz(-1);
    AppMethodBeat.o(103224);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MMNewPhotoEditUI
 * JD-Core Version:    0.7.0.1
 */