package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

final class NearLifeCreatePoiUI$4
  implements MenuItem.OnMenuItemClickListener
{
  NearLifeCreatePoiUI$4(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(11138, new Object[] { "2", "0", NearLifeCreatePoiUI.b(this.mFF) });
    paramMenuItem = this.mFF;
    Object localObject = this.mFF.mController.uMN;
    this.mFF.getString(R.l.nl_create_poi_title);
    NearLifeCreatePoiUI.a(paramMenuItem, com.tencent.mm.ui.base.h.b((Context)localObject, this.mFF.getString(R.l.nl_creating), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        au.Dk().c(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI.4.this.mFF));
      }
    }));
    NearLifeCreatePoiUI.a(this.mFF, NearLifeCreatePoiUI.d(this.mFF).getText().toString());
    NearLifeCreatePoiUI.b(this.mFF, NearLifeCreatePoiUI.e(this.mFF).getText().toString());
    NearLifeCreatePoiUI.c(this.mFF, NearLifeCreatePoiUI.f(this.mFF).getText().toString());
    paramMenuItem = ((EditText)this.mFF.findViewById(R.h.et_position_tel)).getText().toString();
    localObject = NearLifeCreatePoiUI.g(this.mFF);
    NearLifeCreatePoiUI.a(this.mFF, new b(NearLifeCreatePoiUI.h(this.mFF), NearLifeCreatePoiUI.i(this.mFF), NearLifeCreatePoiUI.j(this.mFF), NearLifeCreatePoiUI.k(this.mFF), ((LinkedList)localObject).size(), (LinkedList)localObject, paramMenuItem));
    au.Dk().a(NearLifeCreatePoiUI.c(this.mFF), 0);
    y.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.4
 * JD-Core Version:    0.7.0.1
 */