package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.yc;
import com.tencent.mm.g.a.yc.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@com.tencent.mm.ui.chatting.d.a.a(gRF=au.class)
public class bf
  extends a
  implements au
{
  private IListener BIE;
  private Pattern BIF;
  private Pattern BIG;
  private int PuW;
  private QueueWorkerThread PuZ;
  private HashMap<Long, ChattingItemTranslate.c> Pva;
  private int Pvb;
  private boolean Pvc;
  private int Pvd;
  private boolean ooc;
  
  public bf()
  {
    AppMethodBeat.i(35731);
    this.PuZ = new QueueWorkerThread(5, "msg-translate-update-worker");
    this.Pva = new HashMap();
    this.Pvb = -1;
    this.ooc = false;
    this.BIE = new bf.2(this);
    this.BIF = Pattern.compile("[a-zA-z]");
    this.BIG = Pattern.compile("[一-龥]");
    this.PuW = -1;
    AppMethodBeat.o(35731);
  }
  
  private static void F(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(233214);
    h.CyF.a(19168, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1 + paramInt3) });
    AppMethodBeat.o(233214);
  }
  
  private void a(ca paramca, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(233216);
    if ((paramca.gDz()) && (!paramBoolean))
    {
      if (paramca.gDI())
      {
        paramca.gDK();
        a(paramca.field_msgId, ChattingItemTranslate.c.PPm);
        b.jmd.a(paramca, false);
      }
      for (;;)
      {
        bg.aVF();
        c.aSQ().a(paramca.field_msgId, paramca);
        this.Pvb = -1;
        this.dom.cmy();
        AppMethodBeat.o(233216);
        return;
        paramca.gDJ();
        a(paramca.field_msgId, ChattingItemTranslate.c.PPp);
        b.jmd.a(paramca, true);
      }
    }
    if (cj(paramca) == ChattingItemTranslate.c.PPo)
    {
      AppMethodBeat.o(233216);
      return;
    }
    ya localya = new ya();
    localya.eep.eer = false;
    localya.eep.id = paramca.field_msgId;
    int i;
    if (paramca.dOQ())
    {
      String str = paramca.field_content;
      Object localObject = str;
      if (this.dom.gRM())
      {
        i = paramca.field_content.indexOf(':');
        localObject = str;
        if (i != -1) {
          localObject = paramca.field_content.substring(i + 1);
        }
      }
      if (localObject != null)
      {
        localObject = k.b.aD((String)localObject, paramca.field_reserved);
        localya.eep.eeq = ((k.b)localObject).title;
      }
      i = 1;
      label260:
      localya.eep.ees = paramca.fRc;
      if ((this.dom.gRM()) && (paramca.field_isSend != 1)) {
        break label360;
      }
      localya.eep.type = 0;
    }
    for (;;)
    {
      localya.eep.source = this.dom.getTalkerUserName();
      EventCenter.instance.publish(localya);
      a(paramca.field_msgId, ChattingItemTranslate.c.PPo);
      this.Pvb = paramInt;
      break;
      localya.eep.eeq = paramca.field_content;
      i = 0;
      break label260;
      label360:
      if (i != 0) {
        localya.eep.type = 0;
      } else {
        localya.eep.type = 1;
      }
    }
  }
  
  private int amJ(int paramInt)
  {
    AppMethodBeat.i(233213);
    k localk = (k)this.dom.bh(k.class);
    int i = 0;
    while ((i <= 20) && (ci(localk.amt(paramInt + i + 1)))) {
      i += 1;
    }
    AppMethodBeat.o(233213);
    return i;
  }
  
  private boolean ci(ca paramca)
  {
    AppMethodBeat.i(233215);
    if ((paramca != null) && ((paramca.isText()) || (paramca.gDy())) && (!paramca.gDz()) && (paramca.field_isSend == 0))
    {
      String str = paramca.field_content;
      int i = str.indexOf(':');
      paramca = str;
      if (i != -1) {
        paramca = str.substring(i + 1);
      }
      if (LocaleUtil.isChineseAppLang())
      {
        bool = this.BIF.matcher(paramca).find();
        AppMethodBeat.o(233215);
        return bool;
      }
      boolean bool = this.BIG.matcher(paramca).find();
      AppMethodBeat.o(233215);
      return bool;
    }
    AppMethodBeat.o(233215);
    return false;
  }
  
  private void gOL()
  {
    AppMethodBeat.i(35732);
    EventCenter.instance.removeListener(this.BIE);
    AppMethodBeat.o(35732);
  }
  
  private String hd(String paramString, int paramInt)
  {
    AppMethodBeat.i(179931);
    String str = paramString;
    if (this.dom.gRL())
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = bp.Kt(paramString);
        }
      }
    }
    AppMethodBeat.o(179931);
    return str;
  }
  
  public final void a(long paramLong, ChattingItemTranslate.c paramc)
  {
    AppMethodBeat.i(35733);
    this.Pva.put(Long.valueOf(paramLong), paramc);
    AppMethodBeat.o(35733);
  }
  
  public final boolean b(final MenuItem paramMenuItem, final ca paramca)
  {
    AppMethodBeat.i(35735);
    final int j = paramMenuItem.getItemId();
    switch (j)
    {
    default: 
      AppMethodBeat.o(35735);
      return false;
    }
    Log.d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", new Object[] { Integer.valueOf(paramca.getType()), Boolean.valueOf(paramca.gDI()) });
    int i;
    if (j == 124)
    {
      bg.aVF();
      if (!((Boolean)c.azQ().get(327712, Boolean.FALSE)).booleanValue())
      {
        if (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.dom.Pwc.getContext()))
        {
          AppMethodBeat.o(35735);
          return true;
        }
        i = 2131757542;
        bg.aVF();
        c.azQ().set(327712, Boolean.TRUE);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        d.a locala = new d.a(this.dom.Pwc.getContext());
        locala.boo(this.dom.Pwc.getMMResources().getString(i));
        locala.bon(this.dom.Pwc.getMMResources().getString(2131757543));
        locala.aoV(2131761757).c(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35730);
            bf.c(bf.this);
            bf.d(bf.this);
            bf.e(bf.this);
            bf localbf = bf.this;
            ca localca = paramca;
            paramAnonymousInt = paramMenuItem.getGroupId();
            if (j == 125) {}
            for (boolean bool = true;; bool = false)
            {
              bf.a(localbf, localca, paramAnonymousInt, bool);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35730);
              return;
            }
          }
        });
        locala.hbn().show();
        AppMethodBeat.o(35735);
        return true;
        if (j == 125)
        {
          bg.aVF();
          if (!((Boolean)c.azQ().get(327713, Boolean.FALSE)).booleanValue())
          {
            if (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.dom.Pwc.getContext()))
            {
              AppMethodBeat.o(35735);
              return true;
            }
            i = 2131757501;
            bg.aVF();
            c.azQ().set(327713, Boolean.TRUE);
          }
        }
      }
      else
      {
        this.ooc = true;
        this.Pvc = false;
        this.Pvd = 0;
        i = paramMenuItem.getGroupId();
        if (j == 125) {}
        for (boolean bool = true;; bool = false)
        {
          a(paramca, i, bool);
          break;
        }
      }
      i = 0;
    }
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(233217);
    super.cFy();
    this.Pvc = true;
    if (this.Pvb >= 0) {
      F(this.Pvd, 1, amJ(this.Pvb));
    }
    AppMethodBeat.o(233217);
  }
  
  public final ChattingItemTranslate.c cj(ca paramca)
  {
    AppMethodBeat.i(35734);
    ChattingItemTranslate.c localc = (ChattingItemTranslate.c)this.Pva.get(Long.valueOf(paramca.field_msgId));
    Object localObject = localc;
    if (localc == null)
    {
      if (!paramca.gDz()) {
        break label63;
      }
      if (!paramca.gDI()) {
        break label56;
      }
      localObject = ChattingItemTranslate.c.PPp;
    }
    for (;;)
    {
      AppMethodBeat.o(35734);
      return localObject;
      label56:
      localObject = ChattingItemTranslate.c.PPm;
      continue;
      label63:
      localObject = new yc();
      ((yc)localObject).eev.id = paramca.field_msgId;
      EventCenter.instance.publish((IEvent)localObject);
      if (((yc)localObject).eew.eex)
      {
        localObject = ChattingItemTranslate.c.PPo;
        a(paramca.field_msgId, (ChattingItemTranslate.c)localObject);
      }
      else
      {
        localObject = ChattingItemTranslate.c.PPm;
      }
    }
  }
  
  public final String g(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(179930);
    if (paramBoolean)
    {
      paramca = hd(paramca.field_transContent, paramca.field_isSend);
      AppMethodBeat.o(179930);
      return paramca;
    }
    paramca = hd(paramca.field_content, paramca.field_isSend);
    AppMethodBeat.o(179930);
    return paramca;
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35738);
    this.Pva.clear();
    EventCenter.instance.addListener(this.BIE);
    AppMethodBeat.o(35738);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35739);
    gOL();
    AppMethodBeat.o(35739);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35740);
    super.gOK();
    gOL();
    AppMethodBeat.o(35740);
  }
  
  public final void gRw()
  {
    this.Pvc = true;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(233218);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.PuW) {
      this.ooc = false;
    }
    this.PuW = paramInt1;
    AppMethodBeat.o(233218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bf
 * JD-Core Version:    0.7.0.1
 */