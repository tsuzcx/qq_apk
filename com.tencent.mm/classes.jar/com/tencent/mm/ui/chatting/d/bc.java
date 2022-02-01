package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.wz;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.g.a.xb.b;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.ar.class)
public class bc
  extends a
  implements com.tencent.mm.ui.chatting.d.b.ar
{
  private int KiY;
  private bf Kjb;
  private HashMap<Long, ChattingItemTranslate.b> Kjc;
  private int Kjd;
  private boolean Kje;
  private int Kjf;
  private boolean ncW;
  private com.tencent.mm.sdk.b.c xIC;
  private Pattern xID;
  private Pattern xIE;
  
  public bc()
  {
    AppMethodBeat.i(35731);
    this.Kjb = new bf(5, "msg-translate-update-worker");
    this.Kjc = new HashMap();
    this.Kjd = -1;
    this.ncW = false;
    this.xIC = new com.tencent.mm.sdk.b.c() {};
    this.xID = Pattern.compile("[a-zA-z]");
    this.xIE = Pattern.compile("[一-龥]");
    this.KiY = -1;
    AppMethodBeat.o(35731);
  }
  
  private static void F(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187417);
    g.yxI.f(19168, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1 + paramInt3) });
    AppMethodBeat.o(187417);
  }
  
  private void a(bv parambv, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187419);
    if ((parambv.fvS()) && (!paramBoolean))
    {
      if (parambv.fwc())
      {
        parambv.fwe();
        a(parambv.field_msgId, ChattingItemTranslate.b.KCw);
        com.tencent.mm.modelstat.b.iqT.a(parambv, false);
      }
      for (;;)
      {
        com.tencent.mm.model.bc.aCg();
        com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
        this.Kjd = -1;
        this.cXJ.bPl();
        AppMethodBeat.o(187419);
        return;
        parambv.fwd();
        a(parambv.field_msgId, ChattingItemTranslate.b.KCz);
        com.tencent.mm.modelstat.b.iqT.a(parambv, true);
      }
    }
    if (bT(parambv) == ChattingItemTranslate.b.KCy)
    {
      AppMethodBeat.o(187419);
      return;
    }
    wz localwz = new wz();
    localwz.dMx.dMz = false;
    localwz.dMx.id = parambv.field_msgId;
    int i;
    if (parambv.cVH())
    {
      String str = parambv.field_content;
      Object localObject = str;
      if (this.cXJ.fJC())
      {
        i = parambv.field_content.indexOf(':');
        localObject = str;
        if (i != -1) {
          localObject = parambv.field_content.substring(i + 1);
        }
      }
      if (localObject != null)
      {
        localObject = k.b.aB((String)localObject, parambv.field_reserved);
        localwz.dMx.dMy = ((k.b)localObject).title;
      }
      i = 1;
      label260:
      localwz.dMx.dMA = parambv.fmy;
      if ((this.cXJ.fJC()) && (parambv.field_isSend != 1)) {
        break label360;
      }
      localwz.dMx.type = 0;
    }
    for (;;)
    {
      localwz.dMx.source = this.cXJ.getTalkerUserName();
      com.tencent.mm.sdk.b.a.IvT.l(localwz);
      a(parambv.field_msgId, ChattingItemTranslate.b.KCy);
      this.Kjd = paramInt;
      break;
      localwz.dMx.dMy = parambv.field_content;
      i = 0;
      break label260;
      label360:
      if (i != 0) {
        localwz.dMx.type = 0;
      } else {
        localwz.dMx.type = 1;
      }
    }
  }
  
  private int adY(int paramInt)
  {
    AppMethodBeat.i(187416);
    k localk = (k)this.cXJ.bh(k.class);
    int i = 0;
    while ((i <= 20) && (bS(localk.adI(paramInt + i + 1)))) {
      i += 1;
    }
    AppMethodBeat.o(187416);
    return i;
  }
  
  private boolean bS(bv parambv)
  {
    AppMethodBeat.i(187418);
    if ((parambv != null) && ((parambv.isText()) || (parambv.fvR())) && (!parambv.fvS()) && (parambv.field_isSend == 0))
    {
      String str = parambv.field_content;
      int i = str.indexOf(':');
      parambv = str;
      if (i != -1) {
        parambv = str.substring(i + 1);
      }
      if (ad.foi())
      {
        bool = this.xID.matcher(parambv).find();
        AppMethodBeat.o(187418);
        return bool;
      }
      boolean bool = this.xIE.matcher(parambv).find();
      AppMethodBeat.o(187418);
      return bool;
    }
    AppMethodBeat.o(187418);
    return false;
  }
  
  private void fGF()
  {
    AppMethodBeat.i(35732);
    com.tencent.mm.sdk.b.a.IvT.d(this.xIC);
    AppMethodBeat.o(35732);
  }
  
  private String gK(String paramString, int paramInt)
  {
    AppMethodBeat.i(179931);
    String str = paramString;
    if (this.cXJ.fJB())
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = bl.BN(paramString);
        }
      }
    }
    AppMethodBeat.o(179931);
    return str;
  }
  
  public final void a(long paramLong, ChattingItemTranslate.b paramb)
  {
    AppMethodBeat.i(35733);
    this.Kjc.put(Long.valueOf(paramLong), paramb);
    AppMethodBeat.o(35733);
  }
  
  public final boolean b(final MenuItem paramMenuItem, final bv parambv)
  {
    AppMethodBeat.i(35735);
    final int j = paramMenuItem.getItemId();
    switch (j)
    {
    default: 
      AppMethodBeat.o(35735);
      return false;
    }
    ae.d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", new Object[] { Integer.valueOf(parambv.getType()), Boolean.valueOf(parambv.fwc()) });
    int i;
    if (j == 124)
    {
      com.tencent.mm.model.bc.aCg();
      if (!((Boolean)com.tencent.mm.model.c.ajA().get(327712, Boolean.FALSE)).booleanValue())
      {
        i = 2131757328;
        com.tencent.mm.model.bc.aCg();
        com.tencent.mm.model.c.ajA().set(327712, Boolean.TRUE);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        d.a locala = new d.a(this.cXJ.Kkd.getContext());
        locala.aZi(this.cXJ.Kkd.getMMResources().getString(i));
        locala.aZh(this.cXJ.Kkd.getMMResources().getString(2131757329));
        locala.afU(2131760315).c(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35730);
            bc.c(bc.this);
            bc.d(bc.this);
            bc.e(bc.this);
            bc localbc = bc.this;
            bv localbv = parambv;
            paramAnonymousInt = paramMenuItem.getGroupId();
            if (j == 125) {}
            for (boolean bool = true;; bool = false)
            {
              bc.a(localbc, localbv, paramAnonymousInt, bool);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35730);
              return;
            }
          }
        });
        locala.fQv().show();
        AppMethodBeat.o(35735);
        return true;
        if (j == 125)
        {
          com.tencent.mm.model.bc.aCg();
          if (!((Boolean)com.tencent.mm.model.c.ajA().get(327713, Boolean.FALSE)).booleanValue())
          {
            i = 2131757287;
            com.tencent.mm.model.bc.aCg();
            com.tencent.mm.model.c.ajA().set(327713, Boolean.TRUE);
          }
        }
      }
      else
      {
        this.ncW = true;
        this.Kje = false;
        this.Kjf = 0;
        i = paramMenuItem.getGroupId();
        if (j == 125) {}
        for (boolean bool = true;; bool = false)
        {
          a(parambv, i, bool);
          break;
        }
      }
      i = 0;
    }
  }
  
  public final ChattingItemTranslate.b bT(bv parambv)
  {
    AppMethodBeat.i(35734);
    ChattingItemTranslate.b localb = (ChattingItemTranslate.b)this.Kjc.get(Long.valueOf(parambv.field_msgId));
    Object localObject = localb;
    if (localb == null)
    {
      if (!parambv.fvS()) {
        break label63;
      }
      if (!parambv.fwc()) {
        break label56;
      }
      localObject = ChattingItemTranslate.b.KCz;
    }
    for (;;)
    {
      AppMethodBeat.o(35734);
      return localObject;
      label56:
      localObject = ChattingItemTranslate.b.KCw;
      continue;
      label63:
      localObject = new xb();
      ((xb)localObject).dMD.id = parambv.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if (((xb)localObject).dME.dMF)
      {
        localObject = ChattingItemTranslate.b.KCy;
        a(parambv.field_msgId, (ChattingItemTranslate.b)localObject);
      }
      else
      {
        localObject = ChattingItemTranslate.b.KCw;
      }
    }
  }
  
  public final String f(bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(179930);
    if (paramBoolean)
    {
      parambv = gK(parambv.field_transContent, parambv.field_isSend);
      AppMethodBeat.o(179930);
      return parambv;
    }
    parambv = gK(parambv.field_content, parambv.field_isSend);
    AppMethodBeat.o(179930);
    return parambv;
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35738);
    this.Kjc.clear();
    com.tencent.mm.sdk.b.a.IvT.c(this.xIC);
    AppMethodBeat.o(35738);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(187420);
    super.fAw();
    this.Kje = true;
    if (this.Kjd >= 0) {
      F(this.Kjf, 1, adY(this.Kjd));
    }
    AppMethodBeat.o(187420);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35739);
    fGF();
    AppMethodBeat.o(35739);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35740);
    super.fGE();
    fGF();
    AppMethodBeat.o(35740);
  }
  
  public final void fJm()
  {
    this.Kje = true;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187421);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.KiY) {
      this.ncW = false;
    }
    this.KiY = paramInt1;
    AppMethodBeat.o(187421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bc
 * JD-Core Version:    0.7.0.1
 */