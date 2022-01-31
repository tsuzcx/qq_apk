package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class NearLifeCreatePoiUI$4
  implements MenuItem.OnMenuItemClickListener
{
  NearLifeCreatePoiUI$4(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22975);
    com.tencent.mm.plugin.report.service.h.qsU.e(11138, new Object[] { "2", "0", NearLifeCreatePoiUI.b(this.pfL) });
    paramMenuItem = this.pfL;
    Object localObject = this.pfL.getContext();
    this.pfL.getString(2131301845);
    NearLifeCreatePoiUI.a(paramMenuItem, com.tencent.mm.ui.base.h.b((Context)localObject, this.pfL.getString(2131301846), true, new NearLifeCreatePoiUI.4.1(this)));
    NearLifeCreatePoiUI.a(this.pfL, NearLifeCreatePoiUI.d(this.pfL).getText().toString());
    NearLifeCreatePoiUI.b(this.pfL, NearLifeCreatePoiUI.e(this.pfL).getText().toString());
    NearLifeCreatePoiUI.c(this.pfL, NearLifeCreatePoiUI.f(this.pfL).getText().toString());
    paramMenuItem = ((EditText)this.pfL.findViewById(2131826478)).getText().toString();
    localObject = NearLifeCreatePoiUI.g(this.pfL);
    NearLifeCreatePoiUI.a(this.pfL, new b(NearLifeCreatePoiUI.h(this.pfL), NearLifeCreatePoiUI.i(this.pfL), NearLifeCreatePoiUI.j(this.pfL), NearLifeCreatePoiUI.k(this.pfL), ((LinkedList)localObject).size(), (LinkedList)localObject, paramMenuItem));
    aw.Rc().a(NearLifeCreatePoiUI.c(this.pfL), 0);
    ab.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
    AppMethodBeat.o(22975);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.4
 * JD-Core Version:    0.7.0.1
 */