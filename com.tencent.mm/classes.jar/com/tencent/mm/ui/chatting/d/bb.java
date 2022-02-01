package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.wx;
import com.tencent.mm.g.a.wx.b;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
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

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.aq.class)
public class bb
  extends a
  implements com.tencent.mm.ui.chatting.d.b.aq
{
  private int JOb;
  private be JOe;
  private HashMap<Long, ChattingItemTranslate.b> JOf;
  private int JOg;
  private boolean JOh;
  private int JOi;
  private boolean mXP;
  private com.tencent.mm.sdk.b.c xsF;
  private Pattern xsG;
  private Pattern xsH;
  
  public bb()
  {
    AppMethodBeat.i(35731);
    this.JOe = new be(5, "msg-translate-update-worker");
    this.JOf = new HashMap();
    this.JOg = -1;
    this.mXP = false;
    this.xsF = new com.tencent.mm.sdk.b.c() {};
    this.xsG = Pattern.compile("[a-zA-z]");
    this.xsH = Pattern.compile("[一-龥]");
    this.JOb = -1;
    AppMethodBeat.o(35731);
  }
  
  private static void F(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194104);
    g.yhR.f(19168, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1 + paramInt3) });
    AppMethodBeat.o(194104);
  }
  
  private void a(bu parambu, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(194106);
    if ((parambu.frS()) && (!paramBoolean))
    {
      if (parambu.fsb())
      {
        parambu.fsd();
        a(parambu.field_msgId, ChattingItemTranslate.b.Kgd);
        com.tencent.mm.modelstat.b.inZ.a(parambu, false);
      }
      for (;;)
      {
        ba.aBQ();
        com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
        this.JOg = -1;
        this.cWM.bOo();
        AppMethodBeat.o(194106);
        return;
        parambu.fsc();
        a(parambu.field_msgId, ChattingItemTranslate.b.Kgg);
        com.tencent.mm.modelstat.b.inZ.a(parambu, true);
      }
    }
    if (bT(parambu) == ChattingItemTranslate.b.Kgf)
    {
      AppMethodBeat.o(194106);
      return;
    }
    wv localwv = new wv();
    localwv.dLi.dLk = false;
    localwv.dLi.id = parambu.field_msgId;
    int i;
    if (parambu.cTc())
    {
      String str = parambu.field_content;
      Object localObject = str;
      if (this.cWM.fFv())
      {
        i = parambu.field_content.indexOf(':');
        localObject = str;
        if (i != -1) {
          localObject = parambu.field_content.substring(i + 1);
        }
      }
      if (localObject != null)
      {
        localObject = k.b.aA((String)localObject, parambu.field_reserved);
        localwv.dLi.dLj = ((k.b)localObject).title;
      }
      i = 1;
      label260:
      localwv.dLi.dLl = parambu.fkB;
      if ((this.cWM.fFv()) && (parambu.field_isSend != 1)) {
        break label360;
      }
      localwv.dLi.type = 0;
    }
    for (;;)
    {
      localwv.dLi.source = this.cWM.getTalkerUserName();
      com.tencent.mm.sdk.b.a.IbL.l(localwv);
      a(parambu.field_msgId, ChattingItemTranslate.b.Kgf);
      this.JOg = paramInt;
      break;
      localwv.dLi.dLj = parambu.field_content;
      i = 0;
      break label260;
      label360:
      if (i != 0) {
        localwv.dLi.type = 0;
      } else {
        localwv.dLi.type = 1;
      }
    }
  }
  
  private int adr(int paramInt)
  {
    AppMethodBeat.i(194103);
    k localk = (k)this.cWM.bh(k.class);
    int i = 0;
    while ((i <= 20) && (bS(localk.ada(paramInt + i + 1)))) {
      i += 1;
    }
    AppMethodBeat.o(194103);
    return i;
  }
  
  private boolean bS(bu parambu)
  {
    AppMethodBeat.i(194105);
    if ((parambu != null) && ((parambu.isText()) || (parambu.frR())) && (!parambu.frS()) && (parambu.field_isSend == 0))
    {
      String str = parambu.field_content;
      int i = str.indexOf(':');
      parambu = str;
      if (i != -1) {
        parambu = str.substring(i + 1);
      }
      if (ac.fko())
      {
        bool = this.xsG.matcher(parambu).find();
        AppMethodBeat.o(194105);
        return bool;
      }
      boolean bool = this.xsH.matcher(parambu).find();
      AppMethodBeat.o(194105);
      return bool;
    }
    AppMethodBeat.o(194105);
    return false;
  }
  
  private void fCD()
  {
    AppMethodBeat.i(35732);
    com.tencent.mm.sdk.b.a.IbL.d(this.xsF);
    AppMethodBeat.o(35732);
  }
  
  private String gB(String paramString, int paramInt)
  {
    AppMethodBeat.i(179931);
    String str = paramString;
    if (this.cWM.fFu())
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = bj.Bl(paramString);
        }
      }
    }
    AppMethodBeat.o(179931);
    return str;
  }
  
  public final void a(long paramLong, ChattingItemTranslate.b paramb)
  {
    AppMethodBeat.i(35733);
    this.JOf.put(Long.valueOf(paramLong), paramb);
    AppMethodBeat.o(35733);
  }
  
  public final boolean b(final MenuItem paramMenuItem, final bu parambu)
  {
    AppMethodBeat.i(35735);
    final int j = paramMenuItem.getItemId();
    switch (j)
    {
    default: 
      AppMethodBeat.o(35735);
      return false;
    }
    ad.d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", new Object[] { Integer.valueOf(parambu.getType()), Boolean.valueOf(parambu.fsb()) });
    int i;
    if (j == 124)
    {
      ba.aBQ();
      if (!((Boolean)com.tencent.mm.model.c.ajl().get(327712, Boolean.FALSE)).booleanValue())
      {
        i = 2131757328;
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(327712, Boolean.TRUE);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        d.a locala = new d.a(this.cWM.JOR.getContext());
        locala.aXG(this.cWM.JOR.getMMResources().getString(i));
        locala.aXF(this.cWM.JOR.getMMResources().getString(2131757329));
        locala.afl(2131760315).c(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35730);
            bb.c(bb.this);
            bb.d(bb.this);
            bb.e(bb.this);
            bb localbb = bb.this;
            bu localbu = parambu;
            paramAnonymousInt = paramMenuItem.getGroupId();
            if (j == 125) {}
            for (boolean bool = true;; bool = false)
            {
              bb.a(localbb, localbu, paramAnonymousInt, bool);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35730);
              return;
            }
          }
        });
        locala.fMb().show();
        AppMethodBeat.o(35735);
        return true;
        if (j == 125)
        {
          ba.aBQ();
          if (!((Boolean)com.tencent.mm.model.c.ajl().get(327713, Boolean.FALSE)).booleanValue())
          {
            i = 2131757287;
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(327713, Boolean.TRUE);
          }
        }
      }
      else
      {
        this.mXP = true;
        this.JOh = false;
        this.JOi = 0;
        i = paramMenuItem.getGroupId();
        if (j == 125) {}
        for (boolean bool = true;; bool = false)
        {
          a(parambu, i, bool);
          break;
        }
      }
      i = 0;
    }
  }
  
  public final ChattingItemTranslate.b bT(bu parambu)
  {
    AppMethodBeat.i(35734);
    ChattingItemTranslate.b localb = (ChattingItemTranslate.b)this.JOf.get(Long.valueOf(parambu.field_msgId));
    Object localObject = localb;
    if (localb == null)
    {
      if (!parambu.frS()) {
        break label63;
      }
      if (!parambu.fsb()) {
        break label56;
      }
      localObject = ChattingItemTranslate.b.Kgg;
    }
    for (;;)
    {
      AppMethodBeat.o(35734);
      return localObject;
      label56:
      localObject = ChattingItemTranslate.b.Kgd;
      continue;
      label63:
      localObject = new wx();
      ((wx)localObject).dLo.id = parambu.field_msgId;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if (((wx)localObject).dLp.dLq)
      {
        localObject = ChattingItemTranslate.b.Kgf;
        a(parambu.field_msgId, (ChattingItemTranslate.b)localObject);
      }
      else
      {
        localObject = ChattingItemTranslate.b.Kgd;
      }
    }
  }
  
  public final String e(bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(179930);
    if (paramBoolean)
    {
      parambu = gB(parambu.field_transContent, parambu.field_isSend);
      AppMethodBeat.o(179930);
      return parambu;
    }
    parambu = gB(parambu.field_content, parambu.field_isSend);
    AppMethodBeat.o(179930);
    return parambu;
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35740);
    super.fCC();
    fCD();
    AppMethodBeat.o(35740);
  }
  
  public final void fFj()
  {
    this.JOh = true;
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35738);
    this.JOf.clear();
    com.tencent.mm.sdk.b.a.IbL.c(this.xsF);
    AppMethodBeat.o(35738);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(194107);
    super.fww();
    this.JOh = true;
    if (this.JOg >= 0) {
      F(this.JOi, 1, adr(this.JOg));
    }
    AppMethodBeat.o(194107);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35739);
    fCD();
    AppMethodBeat.o(35739);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194108);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.JOb) {
      this.mXP = false;
    }
    this.JOb = paramInt1;
    AppMethodBeat.o(194108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bb
 * JD-Core Version:    0.7.0.1
 */