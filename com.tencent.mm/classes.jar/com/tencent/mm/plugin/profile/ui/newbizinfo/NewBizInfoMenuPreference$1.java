package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class NewBizInfoMenuPreference$1
  implements View.OnClickListener
{
  NewBizInfoMenuPreference$1(NewBizInfoMenuPreference paramNewBizInfoMenuPreference, lv paramlv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23870);
    if (this.pDJ == null)
    {
      ab.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
      AppMethodBeat.o(23870);
      return;
    }
    c.cZ(NewBizInfoMenuPreference.a(this.pDK).field_username, 1100);
    ab.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", new Object[] { Integer.valueOf(this.pDJ.type) });
    switch (this.pDJ.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23870);
      return;
      NewBizInfoMenuPreference.a(this.pDK, this.pDJ);
      AppMethodBeat.o(23870);
      return;
      g.a(this.pDJ, NewBizInfoMenuPreference.b(this.pDK), NewBizInfoMenuPreference.a(this.pDK).field_username);
      b.b(NewBizInfoMenuPreference.a(this.pDK).field_username, String.valueOf(this.pDJ.id), this.pDJ.key, b.pFE, this.pDJ.name, b.fj(NewBizInfoMenuPreference.c(this.pDK).indexOf(this.pDJ), -1), this.pDJ.ugX);
      AppMethodBeat.o(23870);
      return;
      g.b(this.pDJ, NewBizInfoMenuPreference.b(this.pDK), NewBizInfoMenuPreference.a(this.pDK).field_username);
      b.b(NewBizInfoMenuPreference.a(this.pDK).field_username, String.valueOf(this.pDJ.id), this.pDJ.key, b.pFE, this.pDJ.name, b.fj(NewBizInfoMenuPreference.c(this.pDK).indexOf(this.pDJ), -1), this.pDJ.value);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference.1
 * JD-Core Version:    0.7.0.1
 */