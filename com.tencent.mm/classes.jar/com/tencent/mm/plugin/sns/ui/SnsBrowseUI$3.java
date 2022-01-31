package com.tencent.mm.plugin.sns.ui;

import android.graphics.BitmapFactory.Options;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.tools.e;

final class SnsBrowseUI$3
  implements ViewTreeObserver.OnPreDrawListener
{
  SnsBrowseUI$3(SnsBrowseUI paramSnsBrowseUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(38751);
    this.rOg.rNT.getViewTreeObserver().removeOnPreDrawListener(this);
    SnsBrowseUI.a(this.rOg, this.rOg.rNT.getWidth());
    SnsBrowseUI.b(this.rOg, this.rOg.rNT.getHeight());
    SnsBrowseUI.c(this.rOg, this.rOg.rNT.getWidth());
    SnsBrowseUI.d(this.rOg, this.rOg.rNT.getHeight());
    ag.cpc();
    Object localObject = g.C(this.rOg.rNT.getCntMedia());
    if (localObject != null)
    {
      localObject = d.aoT((String)localObject);
      SnsBrowseUI localSnsBrowseUI = this.rOg;
      float f = SnsBrowseUI.b(this.rOg) / ((BitmapFactory.Options)localObject).outWidth;
      SnsBrowseUI.d(localSnsBrowseUI, (int)(((BitmapFactory.Options)localObject).outHeight * f));
      if (SnsBrowseUI.c(this.rOg) > this.rOg.rNT.getHeight()) {
        SnsBrowseUI.d(this.rOg, this.rOg.rNT.getHeight());
      }
    }
    this.rOg.kip.hO(SnsBrowseUI.b(this.rOg), SnsBrowseUI.c(this.rOg));
    this.rOg.kip.a(this.rOg.rNT, SnsBrowseUI.d(this.rOg), null);
    this.rOg.cuS();
    AppMethodBeat.o(38751);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI.3
 * JD-Core Version:    0.7.0.1
 */