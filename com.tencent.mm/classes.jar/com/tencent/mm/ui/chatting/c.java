package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.az;
import com.tencent.mm.ui.v.a;

public final class c
  implements View.OnClickListener, f, com.tencent.mm.pluginsdk.model.app.t
{
  private ProgressDialog eeN;
  private a zwk;
  
  public c(a parama)
  {
    this.zwk = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, x paramx)
  {
    AppMethodBeat.i(30384);
    ab.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.eeN != null) && (this.eeN.isShowing()))
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    al.caf().b(2, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.bO(this.zwk.zJz.getContext(), this.zwk.zJz.getMMResources().getString(2131300445));
      AppMethodBeat.o(30384);
      return;
    }
    if (v.a.a(this.zwk.zJz.getContext(), paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(30384);
      return;
    }
    Toast.makeText(this.zwk.zJz.getContext(), this.zwk.zJz.getMMResources().getString(2131300391, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(30384);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = true;
    int i = 0;
    AppMethodBeat.i(30383);
    if (paramView.getTag() == null)
    {
      ab.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
      AppMethodBeat.o(30383);
      return;
    }
    Object localObject1;
    if ((paramView.getTag() instanceof az))
    {
      localObject1 = (az)paramView.getTag();
      if (localObject1 == null)
      {
        ab.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
        AppMethodBeat.o(30383);
        return;
      }
      paramView = ((az)localObject1).cEn.appId;
      if (bo.isNullOrNil(paramView)) {
        ab.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
      }
      while (i == 0)
      {
        AppMethodBeat.o(30383);
        return;
        if (g.ca(paramView, false) == null) {
          ab.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = ".concat(String.valueOf(paramView)));
        } else {
          i = 1;
        }
      }
      al.caf().a(2, this);
      if (this.zwk.dJG())
      {
        i = 2;
        paramView = this.zwk.getTalkerUserName();
        if (!com.tencent.mm.model.t.lA(paramView)) {
          break label509;
        }
        paramView = bf.pu(((az)localObject1).cEE.field_content);
      }
    }
    label509:
    for (;;)
    {
      localObject1 = ((az)localObject1).cEn;
      h.d(this.zwk.zJz.getContext(), this.zwk.zJz.getMMResources().getString(2131296993), this.zwk.zJz.getMMResources().getString(2131296994), this.zwk.zJz.getMMResources().getString(2131296391), this.zwk.zJz.getMMResources().getString(2131302372), new c.2(this, (j.b)localObject1, paramView, i), new c.3(this, (j.b)localObject1, paramView, i));
      AppMethodBeat.o(30383);
      return;
      i = 1;
      break;
      if ((paramView.getTag() instanceof s.o))
      {
        Object localObject2 = (s.o)paramView.getTag();
        if (localObject2 == null)
        {
          ab.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
          AppMethodBeat.o(30383);
          return;
        }
        if ((localObject2 == null) || (bo.isNullOrNil(((s.o)localObject2).fhC)) || (((s.o)localObject2).cEE == null))
        {
          if (localObject2 == null) {}
          for (;;)
          {
            ab.e("MicroMsg.AppSpamClickListener", "wrong args, tag is null ? ", new Object[] { Boolean.valueOf(bool) });
            AppMethodBeat.o(30383);
            return;
            bool = false;
          }
        }
        paramView = this.zwk.zJz.getMMResources().getString(2131304270);
        localObject1 = this.zwk.zJz.getMMResources().getString(2131304271);
        String str = this.zwk.zJz.getMMResources().getString(2131296888);
        Activity localActivity = this.zwk.zJz.getContext();
        localObject2 = new c.1(this, (s.o)localObject2);
        h.a(localActivity, null, new String[] { paramView, localObject1, str }, null, true, (h.c)localObject2);
      }
      AppMethodBeat.o(30383);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(30385);
    if ((this.eeN != null) && (this.eeN.isShowing()))
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    aw.Rc().b(1030, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.bO(this.zwk.zJz.getContext(), this.zwk.zJz.getMMResources().getString(2131300445));
      AppMethodBeat.o(30385);
      return;
    }
    Toast.makeText(this.zwk.zJz.getContext(), this.zwk.zJz.getMMResources().getString(2131304272, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(30385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c
 * JD-Core Version:    0.7.0.1
 */