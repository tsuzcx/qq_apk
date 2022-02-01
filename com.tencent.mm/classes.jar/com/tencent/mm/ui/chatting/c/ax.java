package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;

@com.tencent.mm.ui.chatting.c.a.a(eYT=am.class)
public class ax
  extends a
  implements am
{
  private be Gzh;
  private HashMap<Long, ChattingItemTranslate.b> Gzi;
  private com.tencent.mm.sdk.b.c vbW;
  
  public ax()
  {
    AppMethodBeat.i(35731);
    this.Gzh = new be(5, "msg-translate-update-worker");
    this.Gzi = new HashMap();
    this.vbW = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(35731);
  }
  
  private void eWy()
  {
    AppMethodBeat.i(35732);
    com.tencent.mm.sdk.b.a.ESL.d(this.vbW);
    AppMethodBeat.o(35732);
  }
  
  private void f(bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(35737);
    if ((parambl.eMj()) && (!paramBoolean))
    {
      if (parambl.eMt())
      {
        parambl.eMv();
        a(parambl.field_msgId, ChattingItemTranslate.b.GPB);
        com.tencent.mm.modelstat.b.huc.a(parambl, false);
      }
      for (;;)
      {
        az.arV();
        com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
        this.cOd.bCM();
        AppMethodBeat.o(35737);
        return;
        parambl.eMu();
        a(parambl.field_msgId, ChattingItemTranslate.b.GPE);
        com.tencent.mm.modelstat.b.huc.a(parambl, true);
      }
    }
    if (bK(parambl) == ChattingItemTranslate.b.GPD)
    {
      AppMethodBeat.o(35737);
      return;
    }
    vr localvr = new vr();
    localvr.dBi.dBk = false;
    localvr.dBi.id = parambl.field_msgId;
    int i;
    if (parambl.cxB())
    {
      String str = parambl.field_content;
      Object localObject = str;
      if (this.cOd.eZb())
      {
        i = parambl.field_content.indexOf(':');
        localObject = str;
        if (i != -1) {
          localObject = parambl.field_content.substring(i + 1);
        }
      }
      if (localObject != null)
      {
        localObject = k.b.ar((String)localObject, parambl.field_reserved);
        localvr.dBi.dBj = ((k.b)localObject).title;
      }
      i = 1;
      label251:
      localvr.dBi.dBl = parambl.ePe;
      if ((this.cOd.eZb()) && (parambl.field_isSend != 1)) {
        break label345;
      }
      localvr.dBi.type = 0;
    }
    for (;;)
    {
      localvr.dBi.source = this.cOd.getTalkerUserName();
      com.tencent.mm.sdk.b.a.ESL.l(localvr);
      a(parambl.field_msgId, ChattingItemTranslate.b.GPD);
      break;
      localvr.dBi.dBj = parambl.field_content;
      i = 0;
      break label251;
      label345:
      if (i != 0) {
        localvr.dBi.type = 0;
      } else {
        localvr.dBi.type = 1;
      }
    }
  }
  
  private String ga(String paramString, int paramInt)
  {
    AppMethodBeat.i(179931);
    String str = paramString;
    if (this.cOd.eZa())
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = bi.ug(paramString);
        }
      }
    }
    AppMethodBeat.o(179931);
    return str;
  }
  
  public final void a(long paramLong, ChattingItemTranslate.b paramb)
  {
    AppMethodBeat.i(35733);
    this.Gzi.put(Long.valueOf(paramLong), paramb);
    AppMethodBeat.o(35733);
  }
  
  public final boolean b(final MenuItem paramMenuItem, final bl parambl)
  {
    AppMethodBeat.i(35735);
    final int j = paramMenuItem.getItemId();
    switch (j)
    {
    default: 
      AppMethodBeat.o(35735);
      return false;
    }
    ad.d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", new Object[] { Integer.valueOf(parambl.getType()), Boolean.valueOf(parambl.eMt()) });
    int i;
    if (j == 124)
    {
      az.arV();
      if (!((Boolean)com.tencent.mm.model.c.afk().get(327712, Boolean.FALSE)).booleanValue())
      {
        i = 2131757328;
        az.arV();
        com.tencent.mm.model.c.afk().set(327712, Boolean.TRUE);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        d.a locala = new d.a(this.cOd.GzJ.getContext());
        locala.aMg(this.cOd.GzJ.getMMResources().getString(i));
        locala.aMf(this.cOd.GzJ.getMMResources().getString(2131757329));
        locala.aaB(2131760315).b(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35730);
            ax localax = ax.this;
            bl localbl = parambl;
            paramMenuItem.getGroupId();
            if (j == 125) {}
            for (boolean bool = true;; bool = false)
            {
              ax.a(localax, localbl, bool);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35730);
              return;
            }
          }
        });
        locala.fft().show();
        AppMethodBeat.o(35735);
        return true;
        if (j == 125)
        {
          az.arV();
          if (!((Boolean)com.tencent.mm.model.c.afk().get(327713, Boolean.FALSE)).booleanValue())
          {
            i = 2131757287;
            az.arV();
            com.tencent.mm.model.c.afk().set(327713, Boolean.TRUE);
          }
        }
      }
      else
      {
        paramMenuItem.getGroupId();
        if (j == 125) {}
        for (boolean bool = true;; bool = false)
        {
          f(parambl, bool);
          break;
        }
      }
      i = 0;
    }
  }
  
  public final ChattingItemTranslate.b bK(bl parambl)
  {
    AppMethodBeat.i(35734);
    ChattingItemTranslate.b localb = (ChattingItemTranslate.b)this.Gzi.get(Long.valueOf(parambl.field_msgId));
    Object localObject = localb;
    if (localb == null)
    {
      if (!parambl.eMj()) {
        break label63;
      }
      if (!parambl.eMt()) {
        break label56;
      }
      localObject = ChattingItemTranslate.b.GPE;
    }
    for (;;)
    {
      AppMethodBeat.o(35734);
      return localObject;
      label56:
      localObject = ChattingItemTranslate.b.GPB;
      continue;
      label63:
      localObject = new vt();
      ((vt)localObject).dBo.id = parambl.field_msgId;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if (((vt)localObject).dBp.dBq)
      {
        localObject = ChattingItemTranslate.b.GPD;
        a(parambl.field_msgId, (ChattingItemTranslate.b)localObject);
      }
      else
      {
        localObject = ChattingItemTranslate.b.GPB;
      }
    }
  }
  
  public final String e(bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(179930);
    if (paramBoolean)
    {
      parambl = ga(parambl.field_transContent, parambl.field_isSend);
      AppMethodBeat.o(179930);
      return parambl;
    }
    parambl = ga(parambl.field_content, parambl.field_isSend);
    AppMethodBeat.o(179930);
    return parambl;
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35738);
    this.Gzi.clear();
    com.tencent.mm.sdk.b.a.ESL.c(this.vbW);
    AppMethodBeat.o(35738);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35739);
    eWy();
    AppMethodBeat.o(35739);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35740);
    super.eWx();
    eWy();
    AppMethodBeat.o(35740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ax
 * JD-Core Version:    0.7.0.1
 */