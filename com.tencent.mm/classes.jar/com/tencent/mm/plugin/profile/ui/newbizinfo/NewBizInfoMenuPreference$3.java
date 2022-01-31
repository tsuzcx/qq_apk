package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.b;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;
import java.util.List;

final class NewBizInfoMenuPreference$3
  implements n.d
{
  NewBizInfoMenuPreference$3(NewBizInfoMenuPreference paramNewBizInfoMenuPreference, lv paramlv) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(23872);
    paramMenuItem = (lv)this.pDJ.wAq.get(paramInt);
    if (paramMenuItem.type == 2)
    {
      g.a(paramMenuItem, NewBizInfoMenuPreference.b(this.pDK), NewBizInfoMenuPreference.a(this.pDK).field_username);
      b.b(NewBizInfoMenuPreference.a(this.pDK).field_username, String.valueOf(this.pDJ.id), this.pDJ.key, b.pFE, this.pDJ.name, b.fj(NewBizInfoMenuPreference.c(this.pDK).indexOf(this.pDJ), paramInt), this.pDJ.ugX);
      AppMethodBeat.o(23872);
      return;
    }
    if (paramMenuItem.type == 5)
    {
      g.b(paramMenuItem, NewBizInfoMenuPreference.b(this.pDK), NewBizInfoMenuPreference.a(this.pDK).field_username);
      b.b(NewBizInfoMenuPreference.a(this.pDK).field_username, String.valueOf(this.pDJ.id), this.pDJ.key, b.pFE, this.pDJ.name, b.fj(NewBizInfoMenuPreference.c(this.pDK).indexOf(this.pDJ), paramInt), this.pDJ.value);
    }
    AppMethodBeat.o(23872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference.3
 * JD-Core Version:    0.7.0.1
 */