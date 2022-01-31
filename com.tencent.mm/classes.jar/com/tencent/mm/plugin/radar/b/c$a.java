package com.tencent.mm.plugin.radar.b;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/model/RadarAddContact$AddContactHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "callback", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;)V", "lstScene", "Ljava/util/LinkedList;", "", "lstUsername", "", "mUsername", "addContact", "", "username", "finish", "ok", "", "hasSentVerify", "respUsername", "errMsg", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "onStop", "sendVerifyRequest", "verifyOk", "verifyTicket", "plugin-radar_release"})
public final class c$a
  implements f
{
  String ikj;
  final LinkedList<String> pPQ;
  LinkedList<Integer> pPR;
  private final c.d pPS;
  
  public c$a(c.d paramd)
  {
    AppMethodBeat.i(102872);
    Object localObject;
    this.pPS = localObject;
    this.pPQ = new LinkedList();
    AppMethodBeat.o(102872);
  }
  
  private final void b(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(102870);
    g.Rc().b(30, (f)this);
    c.d locald = this.pPS;
    if (locald != null)
    {
      locald.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
      AppMethodBeat.o(102870);
      return;
    }
    AppMethodBeat.o(102870);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(102871);
    j.q(paramm, "scene");
    ab.d(c.access$getTAG$cp(), "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (paramm.getType() != 30)
    {
      ab.w(c.access$getTAG$cp(), "not expected scene,  type = " + paramm.getType());
      AppMethodBeat.o(102871);
      return;
    }
    if (((com.tencent.mm.pluginsdk.model.m)paramm).dll() == 2)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        b(false, true, this.ikj, "");
        AppMethodBeat.o(102871);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -34)) {
        paramm = this.pPT.context.getString(2131300013);
      }
    }
    for (;;)
    {
      b(false, false, this.ikj, paramm);
      AppMethodBeat.o(102871);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramm = this.pPT.context.getString(2131300016);
      }
      else if ((paramInt1 == 4) && ((paramInt2 == -24) || (paramInt2 == -101)))
      {
        paramm = paramString;
        if (paramString != null) {}
      }
      else
      {
        paramm = this.pPT.context.getString(2131303126);
        continue;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          b(true, false, this.ikj, "");
          AppMethodBeat.o(102871);
          return;
        }
        if (paramInt2 == -44)
        {
          new s(this.pPT.context, null).r((List)this.pPQ, (List)this.pPR);
          AppMethodBeat.o(102871);
          return;
        }
        if (paramInt2 == -87)
        {
          b(false, false, this.ikj, this.pPT.context.getString(2131298545));
          AppMethodBeat.o(102871);
          return;
        }
        if ((paramInt2 == -24) && (!bo.isNullOrNil(paramString)))
        {
          String str = this.ikj;
          paramm = paramString;
          if (paramString == null) {
            paramm = "";
          }
          b(false, false, str, paramm);
          AppMethodBeat.o(102871);
          return;
        }
        if ((paramInt1 == 4) && (paramInt2 == -22)) {
          paramm = this.pPT.context.getString(2131296439);
        } else {
          paramm = this.pPT.context.getString(2131296438);
        }
      }
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(102869);
    g.Rc().a(30, (f)this);
    AppMethodBeat.o(102869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c.a
 * JD-Core Version:    0.7.0.1
 */