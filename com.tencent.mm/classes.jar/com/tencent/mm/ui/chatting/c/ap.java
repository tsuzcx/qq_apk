package com.tencent.mm.ui.chatting.c;

import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.g.a.tv.b;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ah;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.c.a.a(dJy=ah.class)
public class ap
  extends a
  implements ah
{
  private com.tencent.mm.sdk.b.c qaa;
  private az zIY;
  private HashMap<Long, ChattingItemTranslate.b> zIZ;
  
  public ap()
  {
    AppMethodBeat.i(31829);
    this.zIY = new az(5, "msg-translate-update-worker");
    this.zIZ = new HashMap();
    this.qaa = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(31829);
  }
  
  private void d(bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(31835);
    if ((parambi.dya()) && (!paramBoolean))
    {
      if (parambi.dyh())
      {
        parambi.dyj();
        a(parambi.field_msgId, ChattingItemTranslate.b.zXu);
        com.tencent.mm.modelstat.b.fRu.a(parambi, false);
      }
      for (;;)
      {
        aw.aaz();
        com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
        this.caz.aWN();
        AppMethodBeat.o(31835);
        return;
        parambi.dyi();
        a(parambi.field_msgId, ChattingItemTranslate.b.zXx);
        com.tencent.mm.modelstat.b.fRu.a(parambi, true);
      }
    }
    if (bm(parambi) == ChattingItemTranslate.b.zXw)
    {
      AppMethodBeat.o(31835);
      return;
    }
    tt localtt = new tt();
    localtt.cKm.cKo = false;
    localtt.cKm.id = parambi.field_msgId;
    localtt.cKm.cKn = parambi.field_content;
    localtt.cKm.cKp = parambi.dHc;
    if ((!this.caz.dJG()) || (parambi.field_isSend == 1)) {}
    for (localtt.cKm.type = 0;; localtt.cKm.type = 1)
    {
      localtt.cKm.source = this.caz.getTalkerUserName();
      com.tencent.mm.sdk.b.a.ymk.l(localtt);
      a(parambi.field_msgId, ChattingItemTranslate.b.zXw);
      break;
    }
  }
  
  private void dHr()
  {
    AppMethodBeat.i(31830);
    com.tencent.mm.sdk.b.a.ymk.d(this.qaa);
    AppMethodBeat.o(31830);
  }
  
  public final void a(long paramLong, ChattingItemTranslate.b paramb)
  {
    AppMethodBeat.i(31831);
    this.zIZ.put(Long.valueOf(paramLong), paramb);
    AppMethodBeat.o(31831);
  }
  
  public final boolean b(MenuItem paramMenuItem, bi parambi)
  {
    AppMethodBeat.i(31833);
    int j = paramMenuItem.getItemId();
    switch (j)
    {
    default: 
      AppMethodBeat.o(31833);
      return false;
    }
    ab.d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", new Object[] { Integer.valueOf(parambi.getType()), Boolean.valueOf(parambi.dyh()) });
    int i;
    if (j == 124)
    {
      aw.aaz();
      if (!((Boolean)com.tencent.mm.model.c.Ru().get(327712, Boolean.FALSE)).booleanValue())
      {
        i = 2131298337;
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(327712, Boolean.TRUE);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        c.a locala = new c.a(this.caz.zJz.getContext());
        locala.avn(this.caz.zJz.getMMResources().getString(i));
        locala.avm(this.caz.zJz.getMMResources().getString(2131298338));
        locala.Ri(2131300718).a(new ap.3(this, parambi, paramMenuItem, j));
        locala.aLZ().show();
        AppMethodBeat.o(31833);
        return true;
        if (j == 125)
        {
          aw.aaz();
          if (!((Boolean)com.tencent.mm.model.c.Ru().get(327713, Boolean.FALSE)).booleanValue())
          {
            i = 2131298296;
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(327713, Boolean.TRUE);
          }
        }
      }
      else
      {
        paramMenuItem.getGroupId();
        if (j == 125) {}
        for (boolean bool = true;; bool = false)
        {
          d(parambi, bool);
          break;
        }
      }
      i = 0;
    }
  }
  
  public final ChattingItemTranslate.b bm(bi parambi)
  {
    AppMethodBeat.i(31832);
    ChattingItemTranslate.b localb = (ChattingItemTranslate.b)this.zIZ.get(Long.valueOf(parambi.field_msgId));
    Object localObject = localb;
    if (localb == null)
    {
      if (!parambi.dya()) {
        break label63;
      }
      if (!parambi.dyh()) {
        break label56;
      }
      localObject = ChattingItemTranslate.b.zXx;
    }
    for (;;)
    {
      AppMethodBeat.o(31832);
      return localObject;
      label56:
      localObject = ChattingItemTranslate.b.zXu;
      continue;
      label63:
      localObject = new tv();
      ((tv)localObject).cKs.id = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      if (((tv)localObject).cKt.cKu)
      {
        localObject = ChattingItemTranslate.b.zXw;
        a(parambi.field_msgId, (ChattingItemTranslate.b)localObject);
      }
      else
      {
        localObject = ChattingItemTranslate.b.zXu;
      }
    }
  }
  
  public final String bn(bi parambi)
  {
    AppMethodBeat.i(31834);
    String str = parambi.field_content;
    int i = parambi.field_isSend;
    parambi = str;
    if (this.caz.dJF())
    {
      parambi = str;
      if (str != null)
      {
        parambi = str;
        if (i == 0) {
          parambi = bf.pv(str);
        }
      }
    }
    AppMethodBeat.o(31834);
    return parambi;
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31836);
    this.zIZ.clear();
    com.tencent.mm.sdk.b.a.ymk.c(this.qaa);
    AppMethodBeat.o(31836);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31837);
    dHr();
    AppMethodBeat.o(31837);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31838);
    super.dHq();
    dHr();
    AppMethodBeat.o(31838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ap
 * JD-Core Version:    0.7.0.1
 */