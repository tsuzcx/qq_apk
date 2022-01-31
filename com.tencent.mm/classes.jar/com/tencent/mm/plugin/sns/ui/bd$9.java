package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class bd$9
  implements View.OnClickListener
{
  bd$9(bd parambd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39872);
    if ((paramView.getTag() instanceof ba))
    {
      paramView = (ba)paramView.getTag();
      if (bo.isNullOrNil(paramView.scg))
      {
        ab.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
        Toast.makeText(this.scK.context, this.scK.context.getString(2131300095, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
        AppMethodBeat.o(39872);
        return;
      }
      g.RM();
      Object localObject = ((j)g.E(j.class)).YA().arw(paramView.scg);
      if ((localObject != null) && (((aq)localObject).field_username.equals(paramView.scg)))
      {
        localObject = new Intent();
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("Contact_User", paramView.scg);
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, paramView.scg + ",37");
        ((Intent)localObject).putExtra("Contact_Scene", 37);
        a.gmO.c((Intent)localObject, this.scK.context);
        AppMethodBeat.o(39872);
        return;
      }
      ao.a.flI.a(paramView.scg, "", new bd.9.1(this));
      localObject = this.scK;
      Context localContext = this.scK.context;
      this.scK.context.getString(2131297087);
      ((bd)localObject).tipDialog = com.tencent.mm.ui.base.h.b(localContext, this.scK.context.getString(2131297112), true, new bd.9.2(this, paramView));
    }
    AppMethodBeat.o(39872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd.9
 * JD-Core Version:    0.7.0.1
 */