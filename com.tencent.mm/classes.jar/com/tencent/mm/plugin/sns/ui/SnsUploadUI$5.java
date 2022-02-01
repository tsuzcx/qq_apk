package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Parcel;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class SnsUploadUI$5
  implements MenuItem.OnMenuItemClickListener
{
  SnsUploadUI$5(SnsUploadUI paramSnsUploadUI, boolean[] paramArrayOfBoolean) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(369954);
    if (this.REd.isFinishing())
    {
      Log.i("MicroMsg.SnsUploadUI", "skip commit, is finishing");
      AppMethodBeat.o(369954);
      return false;
    }
    if ((SnsUploadUI.r(this.REd)) && (SnsUploadUI.b(this.REd) != null) && (!SnsUploadUI.b(this.REd).hlP()))
    {
      this.REd.getIntent().putExtra("Ksnsupload_type", 9);
      this.REd.getIntent().putExtra("Kdescription", SnsUploadUI.a(this.REd).getText().toString());
      this.REd.hqu();
      SnsUploadUI.b(this.REd, "draft_normal");
    }
    if ((SnsUploadUI.b(this.REd) != null) && (!SnsUploadUI.b(this.REd).hlR()))
    {
      Log.i("MicroMsg.SnsUploadUI", "skip commit, beforeCommit: false");
      AppMethodBeat.o(369954);
      return false;
    }
    if (System.currentTimeMillis() - SnsUploadUI.s(this.REd) < 500L)
    {
      Log.i("MicroMsg.SnsUploadUI", "skip commit, click frequently");
      AppMethodBeat.o(369954);
      return false;
    }
    if (SnsUploadUI.t(this.REd))
    {
      Log.i("MicroMsg.SnsUploadUI", "skip commit, has commited");
      AppMethodBeat.o(369954);
      return false;
    }
    al.fAG().removeCallbacks(SnsUploadUI.e(this.REd));
    paramMenuItem = Parcel.obtain();
    this.REd.getIntent().putExtra("Kdescription", SnsUploadUI.a(this.REd).getText().toString());
    this.REd.getIntent().putExtra("KparseLen", SnsUploadUI.a(this.REd).getPasterLen());
    SnsUploadUI.c(this.REd);
    this.REd.getIntent().writeToParcel(paramMenuItem, 0);
    paramMenuItem = paramMenuItem.marshall();
    SnsUploadUI.a(this.REd, paramMenuItem, 2);
    SnsUploadUI.j(this.REd);
    if (this.qbm[0] != 0) {
      this.qbm[0] = false;
    }
    for (;;)
    {
      SnsUploadUI.a(this.REd, System.currentTimeMillis());
      g.ahw(22);
      com.tencent.mm.ui.widget.cedit.api.d.a(SnsUploadUI.a(this.REd)).aEg(com.tencent.mm.k.c.aRc()).Nc(true).a(new SnsUploadUI.5.1(this));
      AppMethodBeat.o(369954);
      return false;
      com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_sns_upload", "<SnsUpload>");
      paramMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
      com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_sns_upload", paramMenuItem);
      com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_sns_upload");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.5
 * JD-Core Version:    0.7.0.1
 */