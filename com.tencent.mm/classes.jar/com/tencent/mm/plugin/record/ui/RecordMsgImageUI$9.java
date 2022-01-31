package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.h.a.cd;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.h.a.nb.a;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.n.d;
import java.util.Map;

final class RecordMsgImageUI$9
  implements n.d
{
  RecordMsgImageUI$9(RecordMsgImageUI paramRecordMsgImageUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      do
      {
        return;
        RecordMsgImageUI.f(this.nuo);
        return;
        paramMenuItem = this.nuo;
        localObject = new cj();
        e.a((cj)localObject, paramMenuItem.getIntent().getIntExtra("key_favorite_source_type", 1), paramMenuItem.bvO());
        ((cj)localObject).bIw.bID = 10;
        ((cj)localObject).bIw.activity = paramMenuItem;
        a.udP.m((b)localObject);
        return;
        RecordMsgImageUI.g(this.nuo);
        return;
        paramMenuItem = RecordMsgImageUI.h(this.nuo);
      } while (bk.bl(paramMenuItem));
      paramMenuItem = (nb)RecordMsgImageUI.i(this.nuo).get(paramMenuItem);
    } while (paramMenuItem == null);
    Object localObject = new cd();
    ((cd)localObject).bIi.activity = this.nuo;
    ((cd)localObject).bIi.bGE = paramMenuItem.bWI.result;
    ((cd)localObject).bIi.bIj = paramMenuItem.bWI.bIj;
    ((cd)localObject).bIi.bIl = 8;
    RecordMsgImageUI.a(this.nuo, (cd)localObject);
    ((cd)localObject).bIi.bIk = paramMenuItem.bWI.bIk;
    if (this.nuo.getIntent() != null) {
      ((cd)localObject).bIi.bIo = this.nuo.getIntent().getBundleExtra("_stat_obj");
    }
    a.udP.m((b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI.9
 * JD-Core Version:    0.7.0.1
 */