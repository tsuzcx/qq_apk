package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.wc;
import com.tencent.mm.g.a.we;
import com.tencent.mm.g.a.we.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@com.tencent.mm.ui.chatting.c.a.a(foJ=am.class)
public class ax
  extends a
  implements am
{
  private int HYV;
  private bd HYY;
  private HashMap<Long, ChattingItemTranslate.b> HYZ;
  private int HZa;
  private boolean HZb;
  private int HZc;
  private boolean mxl;
  private com.tencent.mm.sdk.b.c wkL;
  private Pattern wkM;
  private Pattern wkN;
  
  public ax()
  {
    AppMethodBeat.i(35731);
    this.HYY = new bd(5, "msg-translate-update-worker");
    this.HYZ = new HashMap();
    this.HZa = -1;
    this.mxl = false;
    this.wkL = new ax.2(this);
    this.wkM = Pattern.compile("[a-zA-z]");
    this.wkN = Pattern.compile("[一-龥]");
    this.HYV = -1;
    AppMethodBeat.o(35731);
  }
  
  private void a(bo parambo, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(196520);
    if ((parambo.fbO()) && (!paramBoolean))
    {
      if (parambo.fbY())
      {
        parambo.fca();
        a(parambo.field_msgId, ChattingItemTranslate.b.IpD);
        com.tencent.mm.modelstat.b.hUE.a(parambo, false);
      }
      for (;;)
      {
        az.ayM();
        com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
        this.HZa = -1;
        this.cLy.bJU();
        AppMethodBeat.o(196520);
        return;
        parambo.fbZ();
        a(parambo.field_msgId, ChattingItemTranslate.b.IpG);
        com.tencent.mm.modelstat.b.hUE.a(parambo, true);
      }
    }
    if (bN(parambo) == ChattingItemTranslate.b.IpF)
    {
      AppMethodBeat.o(196520);
      return;
    }
    wc localwc = new wc();
    localwc.dyW.dyY = false;
    localwc.dyW.id = parambo.field_msgId;
    int i;
    if (parambo.cKN())
    {
      String str = parambo.field_content;
      Object localObject = str;
      if (this.cLy.foQ())
      {
        i = parambo.field_content.indexOf(':');
        localObject = str;
        if (i != -1) {
          localObject = parambo.field_content.substring(i + 1);
        }
      }
      if (localObject != null)
      {
        localObject = k.b.az((String)localObject, parambo.field_reserved);
        localwc.dyW.dyX = ((k.b)localObject).title;
      }
      i = 1;
      label260:
      localwc.dyW.dyZ = parambo.eSm;
      if ((this.cLy.foQ()) && (parambo.field_isSend != 1)) {
        break label360;
      }
      localwc.dyW.type = 0;
    }
    for (;;)
    {
      localwc.dyW.source = this.cLy.getTalkerUserName();
      com.tencent.mm.sdk.b.a.GpY.l(localwc);
      a(parambo.field_msgId, ChattingItemTranslate.b.IpF);
      this.HZa = paramInt;
      break;
      localwc.dyW.dyX = parambo.field_content;
      i = 0;
      break label260;
      label360:
      if (i != 0) {
        localwc.dyW.type = 0;
      } else {
        localwc.dyW.type = 1;
      }
    }
  }
  
  private static void aK(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(196518);
    com.tencent.mm.plugin.report.service.h.wUl.f(19168, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1 + paramInt3) });
    AppMethodBeat.o(196518);
  }
  
  private int abf(int paramInt)
  {
    AppMethodBeat.i(196517);
    i locali = (i)this.cLy.bf(i.class);
    int i = 0;
    while ((i <= 20) && (bM(locali.aaP(paramInt + i + 1)))) {
      i += 1;
    }
    AppMethodBeat.o(196517);
    return i;
  }
  
  private boolean bM(bo parambo)
  {
    AppMethodBeat.i(196519);
    if ((parambo != null) && ((parambo.isText()) || (parambo.fbN())) && (!parambo.fbO()) && (parambo.field_isSend == 0))
    {
      String str = parambo.field_content;
      int i = str.indexOf(':');
      parambo = str;
      if (i != -1) {
        parambo = str.substring(i + 1);
      }
      if (ab.eUK())
      {
        bool = this.wkM.matcher(parambo).find();
        AppMethodBeat.o(196519);
        return bool;
      }
      boolean bool = this.wkN.matcher(parambo).find();
      AppMethodBeat.o(196519);
      return bool;
    }
    AppMethodBeat.o(196519);
    return false;
  }
  
  private void fmk()
  {
    AppMethodBeat.i(35732);
    com.tencent.mm.sdk.b.a.GpY.d(this.wkL);
    AppMethodBeat.o(35732);
  }
  
  private String ge(String paramString, int paramInt)
  {
    AppMethodBeat.i(179931);
    String str = paramString;
    if (this.cLy.foP())
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = bi.ym(paramString);
        }
      }
    }
    AppMethodBeat.o(179931);
    return str;
  }
  
  public final void a(long paramLong, ChattingItemTranslate.b paramb)
  {
    AppMethodBeat.i(35733);
    this.HYZ.put(Long.valueOf(paramLong), paramb);
    AppMethodBeat.o(35733);
  }
  
  public final boolean b(final MenuItem paramMenuItem, final bo parambo)
  {
    AppMethodBeat.i(35735);
    final int j = paramMenuItem.getItemId();
    switch (j)
    {
    default: 
      AppMethodBeat.o(35735);
      return false;
    }
    ac.d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", new Object[] { Integer.valueOf(parambo.getType()), Boolean.valueOf(parambo.fbY()) });
    int i;
    if (j == 124)
    {
      az.ayM();
      if (!((Boolean)com.tencent.mm.model.c.agA().get(327712, Boolean.FALSE)).booleanValue())
      {
        i = 2131757328;
        az.ayM();
        com.tencent.mm.model.c.agA().set(327712, Boolean.TRUE);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        d.a locala = new d.a(this.cLy.HZF.getContext());
        locala.aRI(this.cLy.HZF.getMMResources().getString(i));
        locala.aRH(this.cLy.HZF.getMMResources().getString(2131757329));
        locala.acM(2131760315).b(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35730);
            ax.c(ax.this);
            ax.d(ax.this);
            ax.e(ax.this);
            ax localax = ax.this;
            bo localbo = parambo;
            paramAnonymousInt = paramMenuItem.getGroupId();
            if (j == 125) {}
            for (boolean bool = true;; bool = false)
            {
              ax.a(localax, localbo, paramAnonymousInt, bool);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35730);
              return;
            }
          }
        });
        locala.fvp().show();
        AppMethodBeat.o(35735);
        return true;
        if (j == 125)
        {
          az.ayM();
          if (!((Boolean)com.tencent.mm.model.c.agA().get(327713, Boolean.FALSE)).booleanValue())
          {
            i = 2131757287;
            az.ayM();
            com.tencent.mm.model.c.agA().set(327713, Boolean.TRUE);
          }
        }
      }
      else
      {
        this.mxl = true;
        this.HZb = false;
        this.HZc = 0;
        i = paramMenuItem.getGroupId();
        if (j == 125) {}
        for (boolean bool = true;; bool = false)
        {
          a(parambo, i, bool);
          break;
        }
      }
      i = 0;
    }
  }
  
  public final ChattingItemTranslate.b bN(bo parambo)
  {
    AppMethodBeat.i(35734);
    ChattingItemTranslate.b localb = (ChattingItemTranslate.b)this.HYZ.get(Long.valueOf(parambo.field_msgId));
    Object localObject = localb;
    if (localb == null)
    {
      if (!parambo.fbO()) {
        break label63;
      }
      if (!parambo.fbY()) {
        break label56;
      }
      localObject = ChattingItemTranslate.b.IpG;
    }
    for (;;)
    {
      AppMethodBeat.o(35734);
      return localObject;
      label56:
      localObject = ChattingItemTranslate.b.IpD;
      continue;
      label63:
      localObject = new we();
      ((we)localObject).dzc.id = parambo.field_msgId;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if (((we)localObject).dzd.dze)
      {
        localObject = ChattingItemTranslate.b.IpF;
        a(parambo.field_msgId, (ChattingItemTranslate.b)localObject);
      }
      else
      {
        localObject = ChattingItemTranslate.b.IpD;
      }
    }
  }
  
  public final String e(bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(179930);
    if (paramBoolean)
    {
      parambo = ge(parambo.field_transContent, parambo.field_isSend);
      AppMethodBeat.o(179930);
      return parambo;
    }
    parambo = ge(parambo.field_content, parambo.field_isSend);
    AppMethodBeat.o(179930);
    return parambo;
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35738);
    this.HYZ.clear();
    com.tencent.mm.sdk.b.a.GpY.c(this.wkL);
    AppMethodBeat.o(35738);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(196521);
    super.fgk();
    this.HZb = true;
    if (this.HZa >= 0) {
      aK(this.HZc, 1, abf(this.HZa));
    }
    AppMethodBeat.o(196521);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35739);
    fmk();
    AppMethodBeat.o(35739);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35740);
    super.fmj();
    fmk();
    AppMethodBeat.o(35740);
  }
  
  public final void foF()
  {
    this.HZb = true;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(196522);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.HYV) {
      this.mxl = false;
    }
    this.HYV = paramInt1;
    AppMethodBeat.o(196522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ax
 * JD-Core Version:    0.7.0.1
 */