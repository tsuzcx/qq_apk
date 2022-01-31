package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class s$5
  implements n.d
{
  s$5(s params, com.tencent.mm.plugin.sns.storage.n paramn, bcs parambcs, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(38253);
    paramInt = paramMenuItem.getItemId();
    ab.d("MicroMsg.GalleryTitleManager", "showAlertWithDel ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38253);
      return;
      if ((this.rHq != null) && (this.rHq.csh().xTS != null))
      {
        s.a(this.rHr, this.rHq, this.rdM);
        AppMethodBeat.o(38253);
        return;
        s.a(this.rHr, this.rHq, this.rdM, this.lU);
        AppMethodBeat.o(38253);
        return;
        paramMenuItem = this.rHr;
        Object localObject = new r(this.rHq.field_snsId, 3);
        g.RM();
        g.RK().eHt.a((m)localObject, 0);
        Context localContext = paramMenuItem.context;
        paramMenuItem.context.getString(2131297087);
        paramMenuItem.tipDialog = h.b(localContext, paramMenuItem.context.getString(2131303950), true, new s.12(paramMenuItem, (r)localObject));
        AppMethodBeat.o(38253);
        return;
        paramMenuItem = this.rHr;
        localObject = this.rHq;
        if ((((com.tencent.mm.plugin.sns.storage.n)localObject).csI()) || (((com.tencent.mm.plugin.sns.storage.n)localObject).csJ()))
        {
          ag.cpf().EA(((com.tencent.mm.plugin.sns.storage.n)localObject).rCV);
          AppMethodBeat.o(38253);
          return;
        }
        localObject = new r(((com.tencent.mm.plugin.sns.storage.n)localObject).field_snsId, 2);
        g.RM();
        g.RK().eHt.a((m)localObject, 0);
        localContext = paramMenuItem.context;
        paramMenuItem.context.getString(2131297087);
        paramMenuItem.tipDialog = h.b(localContext, paramMenuItem.context.getString(2131303950), true, new s.11(paramMenuItem, (r)localObject));
        AppMethodBeat.o(38253);
        return;
        if ((this.rHq != null) && (this.rHq.csh().xTS != null))
        {
          if (this.rHq.field_type != 15)
          {
            com.tencent.mm.pluginsdk.ui.tools.n.k(ao.gl(ag.getAccSnsPath(), this.rdM.Id) + i.l(this.rdM), this.rHr.context);
            AppMethodBeat.o(38253);
            return;
          }
          s.abZ(this.rHq.csH());
          AppMethodBeat.o(38253);
          return;
          if ((this.rHq != null) && (this.rHq.csh().xTS != null))
          {
            if (this.rHq.csh().xTS.wNZ == 1)
            {
              paramMenuItem = ao.gl(ag.getAccSnsPath(), this.rdM.Id) + i.l(this.rdM);
              this.rHr.abY(paramMenuItem);
              AppMethodBeat.o(38253);
              return;
            }
            s.aca(this.rHq.csH());
            AppMethodBeat.o(38253);
            return;
            if (this.rHq.csh().xTS.wOa.size() > 1)
            {
              h.a(this.rHr.context, this.rHr.context.getString(2131303926), "", new s.5.1(this), null);
              AppMethodBeat.o(38253);
              return;
            }
            h.a(this.rHr.context, this.rHr.context.getString(2131303924), "", new s.5.2(this), null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s.5
 * JD-Core Version:    0.7.0.1
 */