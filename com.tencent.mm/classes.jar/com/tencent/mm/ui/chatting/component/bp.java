package com.tencent.mm.ui.chatting.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.abb;
import com.tencent.mm.autogen.a.abd;
import com.tencent.mm.autogen.a.abd.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.bc;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.c;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=bc.class)
public class bp
  extends a
  implements bc
{
  private IListener NCo;
  private Pattern NCp;
  private Pattern NCq;
  private boolean STa;
  private int aexU;
  private QueueWorkerThread aexX;
  private HashMap<Long, ChattingItemTranslate.c> aexY;
  private int aexZ;
  private boolean aeya;
  private int aeyb;
  
  public bp()
  {
    AppMethodBeat.i(35731);
    this.aexX = new QueueWorkerThread(5, "msg-translate-update-worker");
    this.aexY = new HashMap();
    this.aexZ = -1;
    this.STa = false;
    this.NCo = new TranslateComponent.2(this, f.hfK);
    this.NCp = Pattern.compile("[a-zA-z]");
    this.NCq = Pattern.compile("[一-龥]");
    this.aexU = -1;
    AppMethodBeat.o(35731);
  }
  
  private static void Y(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(256342);
    h.OAn.b(19168, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1 + paramInt3) });
    AppMethodBeat.o(256342);
  }
  
  private int aCn(int paramInt)
  {
    AppMethodBeat.i(256340);
    m localm = (m)this.hlc.cm(m.class);
    int i = 0;
    while ((i <= 20) && (cY(localm.aBV(paramInt + i + 1)))) {
      i += 1;
    }
    AppMethodBeat.o(256340);
    return i;
  }
  
  private void b(cc paramcc, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(256352);
    if ((paramcc.jbT()) && (!paramBoolean))
    {
      if (paramcc.jca())
      {
        paramcc.jcc();
        a(paramcc.field_msgId, ChattingItemTranslate.c.aeWe);
        b.oUZ.a(paramcc, false);
      }
      for (;;)
      {
        bh.bCz();
        c.bzD().a(paramcc.field_msgId, paramcc);
        this.aexZ = -1;
        this.hlc.dcZ();
        AppMethodBeat.o(256352);
        return;
        paramcc.jcb();
        a(paramcc.field_msgId, ChattingItemTranslate.c.aeWh);
        b.oUZ.a(paramcc, true);
      }
    }
    if (cZ(paramcc) == ChattingItemTranslate.c.aeWg)
    {
      AppMethodBeat.o(256352);
      return;
    }
    abb localabb = new abb();
    localabb.ieG.ieI = false;
    localabb.ieG.id = paramcc.field_msgId;
    int i;
    if (paramcc.fxR())
    {
      String str = paramcc.field_content;
      Object localObject = str;
      if (this.hlc.juG())
      {
        i = paramcc.field_content.indexOf(':');
        localObject = str;
        if (i != -1) {
          localObject = paramcc.field_content.substring(i + 1);
        }
      }
      if (localObject != null)
      {
        localObject = k.b.aP((String)localObject, paramcc.field_reserved);
        localabb.ieG.ieH = ((k.b)localObject).title;
      }
      i = 1;
      label260:
      localabb.ieG.ieJ = paramcc.kLr;
      if ((this.hlc.juG()) && (paramcc.field_isSend != 1)) {
        break label357;
      }
      localabb.ieG.type = 0;
    }
    for (;;)
    {
      localabb.ieG.source = this.hlc.getTalkerUserName();
      localabb.publish();
      a(paramcc.field_msgId, ChattingItemTranslate.c.aeWg);
      this.aexZ = paramInt;
      break;
      localabb.ieG.ieH = paramcc.field_content;
      i = 0;
      break label260;
      label357:
      if (i != 0) {
        localabb.ieG.type = 0;
      } else {
        localabb.ieG.type = 1;
      }
    }
  }
  
  private boolean cY(cc paramcc)
  {
    AppMethodBeat.i(256348);
    if ((paramcc != null) && ((paramcc.iYl()) || (paramcc.jbS())) && (!paramcc.jbT()) && (paramcc.field_isSend == 0))
    {
      String str = paramcc.field_content;
      int i = str.indexOf(':');
      paramcc = str;
      if (i != -1) {
        paramcc = str.substring(i + 1);
      }
      if (LocaleUtil.isChineseAppLang())
      {
        bool = this.NCp.matcher(paramcc).find();
        AppMethodBeat.o(256348);
        return bool;
      }
      boolean bool = this.NCq.matcher(paramcc).find();
      AppMethodBeat.o(256348);
      return bool;
    }
    AppMethodBeat.o(256348);
    return false;
  }
  
  private String iT(String paramString, int paramInt)
  {
    AppMethodBeat.i(179931);
    String str = paramString;
    if (this.hlc.juF())
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = br.JK(paramString);
        }
      }
    }
    AppMethodBeat.o(179931);
    return str;
  }
  
  public final void a(long paramLong, ChattingItemTranslate.c paramc)
  {
    AppMethodBeat.i(35733);
    this.aexY.put(Long.valueOf(paramLong), paramc);
    AppMethodBeat.o(35733);
  }
  
  public final boolean b(final MenuItem paramMenuItem, final cc paramcc)
  {
    AppMethodBeat.i(35735);
    final int j = paramMenuItem.getItemId();
    switch (j)
    {
    default: 
      AppMethodBeat.o(35735);
      return false;
    }
    Log.d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", new Object[] { Integer.valueOf(paramcc.getType()), Boolean.valueOf(paramcc.jca()) });
    int i;
    if (j == 124)
    {
      bh.bCz();
      if (!((Boolean)c.ban().d(327712, Boolean.FALSE)).booleanValue())
      {
        if (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.hlc.aezO.getContext()))
        {
          AppMethodBeat.o(35735);
          return true;
        }
        i = R.l.gzV;
        bh.bCz();
        c.ban().B(327712, Boolean.TRUE);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        e.a locala = new e.a(this.hlc.aezO.getContext());
        locala.bDw(this.hlc.aezO.getMMResources().getString(i));
        locala.bDv(this.hlc.aezO.getMMResources().getString(R.l.gzW));
        locala.aER(R.l.i_know_it).c(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35730);
            bp.c(bp.this);
            bp.d(bp.this);
            bp.e(bp.this);
            bp localbp = bp.this;
            cc localcc = paramcc;
            paramAnonymousInt = paramMenuItem.getGroupId();
            if (j == 125) {}
            for (boolean bool = true;; bool = false)
            {
              bp.a(localbp, localcc, paramAnonymousInt, bool);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35730);
              return;
            }
          }
        });
        locala.jHH().show();
        AppMethodBeat.o(35735);
        return true;
        if (j == 125)
        {
          bh.bCz();
          if (!((Boolean)c.ban().d(327713, Boolean.FALSE)).booleanValue())
          {
            if (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.hlc.aezO.getContext()))
            {
              AppMethodBeat.o(35735);
              return true;
            }
            i = R.l.gzn;
            bh.bCz();
            c.ban().B(327713, Boolean.TRUE);
          }
        }
      }
      else
      {
        this.STa = true;
        this.aeya = false;
        this.aeyb = 0;
        i = paramMenuItem.getGroupId();
        if (j == 125) {}
        for (boolean bool = true;; bool = false)
        {
          b(paramcc, i, bool);
          break;
        }
      }
      i = 0;
    }
  }
  
  public final ChattingItemTranslate.c cZ(cc paramcc)
  {
    AppMethodBeat.i(35734);
    ChattingItemTranslate.c localc = (ChattingItemTranslate.c)this.aexY.get(Long.valueOf(paramcc.field_msgId));
    Object localObject = localc;
    if (localc == null)
    {
      if (!paramcc.jbT()) {
        break label63;
      }
      if (!paramcc.jca()) {
        break label56;
      }
      localObject = ChattingItemTranslate.c.aeWh;
    }
    for (;;)
    {
      AppMethodBeat.o(35734);
      return localObject;
      label56:
      localObject = ChattingItemTranslate.c.aeWe;
      continue;
      label63:
      localObject = new abd();
      ((abd)localObject).ieM.id = paramcc.field_msgId;
      ((abd)localObject).publish();
      if (((abd)localObject).ieN.ieO)
      {
        localObject = ChattingItemTranslate.c.aeWg;
        a(paramcc.field_msgId, (ChattingItemTranslate.c)localObject);
      }
      else
      {
        localObject = ChattingItemTranslate.c.aeWe;
      }
    }
  }
  
  public final String h(cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(179930);
    if (paramBoolean)
    {
      paramcc = iT(paramcc.field_transContent, paramcc.field_isSend);
      AppMethodBeat.o(179930);
      return paramcc;
    }
    paramcc = iT(paramcc.field_content, paramcc.field_isSend);
    AppMethodBeat.o(179930);
    return paramcc;
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35738);
    this.aexY.clear();
    this.NCo.alive();
    AppMethodBeat.o(35738);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(256405);
    super.jjj();
    this.aeya = true;
    if (this.aexZ >= 0) {
      Y(this.aeyb, 1, aCn(this.aexZ));
    }
    AppMethodBeat.o(256405);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35732);
    this.NCo.dead();
    AppMethodBeat.o(35732);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35740);
    super.jqF();
    this.NCo.dead();
    AppMethodBeat.o(35740);
  }
  
  public final void jtW()
  {
    this.aeya = true;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(256408);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.aexU) {
      this.STa = false;
    }
    this.aexU = paramInt1;
    AppMethodBeat.o(256408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bp
 * JD-Core Version:    0.7.0.1
 */