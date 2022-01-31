package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.api.g;
import com.tencent.mm.api.s;
import com.tencent.mm.api.s.a.a;
import com.tencent.mm.api.s.b;
import com.tencent.mm.api.s.c;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.vfs.e;

@a(19)
public class MMNewPhotoEditUI
  extends MMActivity
  implements g
{
  private p ehb;
  private int ejF;
  private s oQJ;
  private PhotoEditProxy qaM;
  private final d qaN;
  private Dialog uba;
  private String zcm;
  private long zcn;
  private String zco;
  private String zcp;
  private boolean zcq;
  private boolean zcr;
  
  public MMNewPhotoEditUI()
  {
    AppMethodBeat.i(11927);
    this.qaN = new d(this);
    this.ehb = null;
    AppMethodBeat.o(11927);
  }
  
  private void Oh(int paramInt)
  {
    AppMethodBeat.i(11935);
    fV(true);
    this.oQJ.a(new MMNewPhotoEditUI.5(this, paramInt));
    AppMethodBeat.o(11935);
  }
  
  private void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(11936);
    ab.i("MicroMsg.MMNewPhotoEditUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.ehb = p.b(this, getString(2131306206), true, null);
      AppMethodBeat.o(11936);
      return;
    }
    if ((this.ehb != null) && (this.ehb.isShowing()))
    {
      this.ehb.dismiss();
      this.ehb = null;
    }
    AppMethodBeat.o(11936);
  }
  
  protected int getForceOrientation()
  {
    return 1;
  }
  
  protected int getLayoutId()
  {
    return 2130970360;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(11929);
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131820946);
    this.oQJ = s.bWe.Ab();
    Object localObject = this.oQJ;
    s.a.a locala = new s.a.a();
    if ((this.ejF != 291) && (this.ejF != 293)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.bWg = bool;
      locala.bWj = true;
      locala.bWf = s.c.bWm;
      locala.path = this.zcm;
      ((s)localObject).a(locala.Ax());
      localObject = this.oQJ.aV(getContext());
      ((c)localObject).setActionBarCallback(this);
      localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      ((c)localObject).setSelectedFeatureListener(new MMNewPhotoEditUI.2(this));
      AppMethodBeat.o(11929);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(11934);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      String str = paramIntent.getStringExtra("Select_Conv_User");
      ab.d("MicroMsg.MMNewPhotoEditUI", "select %s for sending imagePath:%s", new Object[] { str, this.zcp });
      this.uba = com.tencent.mm.ui.base.h.b(getContext(), getString(2131306205), false, null);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      this.qaM.sendImage(paramIntent, this.zcp, this.qaM.getSelfUsername(), str);
      if (this.uba != null) {
        this.uba.dismiss();
      }
      if (!this.zcq) {
        e.deleteFile(this.zcp);
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(11934);
        return;
        com.tencent.mm.sdk.f.b.a(this.zcp, this);
      }
    }
    if ((paramIntent == null) && (!bo.isNullOrNil(this.zcp)) && (this.ejF == 291)) {
      e.deleteFile(this.zcp);
    }
    AppMethodBeat.o(11934);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(11931);
    if (!this.oQJ.zY())
    {
      if ((this.ejF != 290) && (this.ejF != 291)) {
        break label74;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(13859, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(11931);
      return;
      label74:
      if ((this.ejF == 4) || (this.ejF == 293)) {
        com.tencent.mm.plugin.report.service.h.qsU.e(13859, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      } else {
        com.tencent.mm.plugin.report.service.h.qsU.e(13859, new Object[] { Integer.valueOf(0), Integer.valueOf(2) });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(11928);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true, 0L);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
      b.c(this, false);
    }
    this.qaM = new PhotoEditProxy(this.qaN);
    this.qaN.connect(new MMNewPhotoEditUI.1(this));
    AppMethodBeat.o(11928);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(11930);
    super.onDestroy();
    this.oQJ.onDestroy();
    this.qaN.release();
    AppMethodBeat.o(11930);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(11933);
    onBackPressed();
    AppMethodBeat.o(11933);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(11932);
    if ((this.ejF == 290) || (this.ejF == 291)) {
      com.tencent.mm.plugin.report.service.h.qsU.e(13859, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
    while ((this.ejF == 291) || (this.ejF == 293))
    {
      l locall = new l(getContext());
      locall.sao = new MMNewPhotoEditUI.3(this);
      locall.sap = new MMNewPhotoEditUI.4(this);
      com.tencent.mm.ui.base.h.a(getContext(), locall.cwt());
      AppMethodBeat.o(11932);
      return;
      if ((this.ejF == 4) || (this.ejF == 293)) {
        com.tencent.mm.plugin.report.service.h.qsU.e(13859, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.h.qsU.e(13859, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
      }
    }
    Oh(-1);
    AppMethodBeat.o(11932);
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