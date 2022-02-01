package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.zh;
import com.tencent.mm.f.a.zj;
import com.tencent.mm.f.a.zj.b;
import com.tencent.mm.f.a.zk;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@com.tencent.mm.ui.chatting.d.a.a(hRc=av.class)
public class bi
  extends a
  implements av
{
  private IListener HEM;
  private Pattern HEN;
  private Pattern HEO;
  private boolean MpG;
  private int WPp;
  private QueueWorkerThread WPs;
  private HashMap<Long, ChattingItemTranslate.c> WPt;
  private int WPu;
  private boolean WPv;
  private int WPw;
  
  public bi()
  {
    AppMethodBeat.i(35731);
    this.WPs = new QueueWorkerThread(5, "msg-translate-update-worker");
    this.WPt = new HashMap();
    this.WPu = -1;
    this.MpG = false;
    this.HEM = new IListener() {};
    this.HEN = Pattern.compile("[a-zA-z]");
    this.HEO = Pattern.compile("[一-龥]");
    this.WPp = -1;
    AppMethodBeat.o(35731);
  }
  
  private static void I(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(285573);
    com.tencent.mm.plugin.report.service.h.IzE.a(19168, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1 + paramInt3) });
    AppMethodBeat.o(285573);
  }
  
  private int avK(int paramInt)
  {
    AppMethodBeat.i(285571);
    k localk = (k)this.fgR.bC(k.class);
    int i = 0;
    while ((i <= 20) && (cB(localk.avt(paramInt + i + 1)))) {
      i += 1;
    }
    AppMethodBeat.o(285571);
    return i;
  }
  
  private void b(ca paramca, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(285578);
    if ((paramca.hzO()) && (!paramBoolean))
    {
      if (paramca.hzW())
      {
        paramca.hzY();
        a(paramca.field_msgId, ChattingItemTranslate.c.Xlo);
        b.mcf.a(paramca, false);
      }
      for (;;)
      {
        bh.beI();
        c.bbO().a(paramca.field_msgId, paramca);
        this.WPu = -1;
        this.fgR.cAe();
        AppMethodBeat.o(285578);
        return;
        paramca.hzX();
        a(paramca.field_msgId, ChattingItemTranslate.c.Xlr);
        b.mcf.a(paramca, true);
      }
    }
    if (cC(paramca) == ChattingItemTranslate.c.Xlq)
    {
      AppMethodBeat.o(285578);
      return;
    }
    zh localzh = new zh();
    localzh.fYE.fYG = false;
    localzh.fYE.id = paramca.field_msgId;
    int i;
    if (paramca.erk())
    {
      String str = paramca.field_content;
      Object localObject = str;
      if (this.fgR.hRi())
      {
        i = paramca.field_content.indexOf(':');
        localObject = str;
        if (i != -1) {
          localObject = paramca.field_content.substring(i + 1);
        }
      }
      if (localObject != null)
      {
        localObject = k.b.aG((String)localObject, paramca.field_reserved);
        localzh.fYE.fYF = ((k.b)localObject).title;
      }
      i = 1;
      label260:
      localzh.fYE.fYH = paramca.ils;
      if ((this.fgR.hRi()) && (paramca.field_isSend != 1)) {
        break label360;
      }
      localzh.fYE.type = 0;
    }
    for (;;)
    {
      localzh.fYE.source = this.fgR.getTalkerUserName();
      EventCenter.instance.publish(localzh);
      a(paramca.field_msgId, ChattingItemTranslate.c.Xlq);
      this.WPu = paramInt;
      break;
      localzh.fYE.fYF = paramca.field_content;
      i = 0;
      break label260;
      label360:
      if (i != 0) {
        localzh.fYE.type = 0;
      } else {
        localzh.fYE.type = 1;
      }
    }
  }
  
  private boolean cB(ca paramca)
  {
    AppMethodBeat.i(285574);
    if ((paramca != null) && ((paramca.hwH()) || (paramca.hzN())) && (!paramca.hzO()) && (paramca.field_isSend == 0))
    {
      String str = paramca.field_content;
      int i = str.indexOf(':');
      paramca = str;
      if (i != -1) {
        paramca = str.substring(i + 1);
      }
      if (LocaleUtil.isChineseAppLang())
      {
        bool = this.HEN.matcher(paramca).find();
        AppMethodBeat.o(285574);
        return bool;
      }
      boolean bool = this.HEO.matcher(paramca).find();
      AppMethodBeat.o(285574);
      return bool;
    }
    AppMethodBeat.o(285574);
    return false;
  }
  
  private String hM(String paramString, int paramInt)
  {
    AppMethodBeat.i(179931);
    String str = paramString;
    if (this.fgR.hRh())
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = bq.RM(paramString);
        }
      }
    }
    AppMethodBeat.o(179931);
    return str;
  }
  
  private void hOa()
  {
    AppMethodBeat.i(35732);
    EventCenter.instance.removeListener(this.HEM);
    AppMethodBeat.o(35732);
  }
  
  public final void a(long paramLong, ChattingItemTranslate.c paramc)
  {
    AppMethodBeat.i(35733);
    this.WPt.put(Long.valueOf(paramLong), paramc);
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
    Log.d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", new Object[] { Integer.valueOf(paramca.getType()), Boolean.valueOf(paramca.hzW()) });
    int i;
    if (j == 124)
    {
      bh.beI();
      if (!((Boolean)c.aHp().b(327712, Boolean.FALSE)).booleanValue())
      {
        if (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.fgR.WQv.getContext()))
        {
          AppMethodBeat.o(35735);
          return true;
        }
        i = R.l.exl;
        bh.beI();
        c.aHp().i(327712, Boolean.TRUE);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        d.a locala = new d.a(this.fgR.WQv.getContext());
        locala.bBd(this.fgR.WQv.getMMResources().getString(i));
        locala.bBc(this.fgR.WQv.getMMResources().getString(R.l.exm));
        locala.ayj(R.l.i_know_it).c(new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35730);
            bi.c(bi.this);
            bi.d(bi.this);
            bi.e(bi.this);
            bi localbi = bi.this;
            ca localca = paramca;
            paramAnonymousInt = paramMenuItem.getGroupId();
            if (j == 125) {}
            for (boolean bool = true;; bool = false)
            {
              bi.a(localbi, localca, paramAnonymousInt, bool);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35730);
              return;
            }
          }
        });
        locala.icu().show();
        AppMethodBeat.o(35735);
        return true;
        if (j == 125)
        {
          bh.beI();
          if (!((Boolean)c.aHp().b(327713, Boolean.FALSE)).booleanValue())
          {
            if (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.fgR.WQv.getContext()))
            {
              AppMethodBeat.o(35735);
              return true;
            }
            i = R.l.ewK;
            bh.beI();
            c.aHp().i(327713, Boolean.TRUE);
          }
        }
      }
      else
      {
        this.MpG = true;
        this.WPv = false;
        this.WPw = 0;
        i = paramMenuItem.getGroupId();
        if (j == 125) {}
        for (boolean bool = true;; bool = false)
        {
          b(paramca, i, bool);
          break;
        }
      }
      i = 0;
    }
  }
  
  public final ChattingItemTranslate.c cC(ca paramca)
  {
    AppMethodBeat.i(35734);
    ChattingItemTranslate.c localc = (ChattingItemTranslate.c)this.WPt.get(Long.valueOf(paramca.field_msgId));
    Object localObject = localc;
    if (localc == null)
    {
      if (!paramca.hzO()) {
        break label63;
      }
      if (!paramca.hzW()) {
        break label56;
      }
      localObject = ChattingItemTranslate.c.Xlr;
    }
    for (;;)
    {
      AppMethodBeat.o(35734);
      return localObject;
      label56:
      localObject = ChattingItemTranslate.c.Xlo;
      continue;
      label63:
      localObject = new zj();
      ((zj)localObject).fYK.id = paramca.field_msgId;
      EventCenter.instance.publish((IEvent)localObject);
      if (((zj)localObject).fYL.fYM)
      {
        localObject = ChattingItemTranslate.c.Xlq;
        a(paramca.field_msgId, (ChattingItemTranslate.c)localObject);
      }
      else
      {
        localObject = ChattingItemTranslate.c.Xlo;
      }
    }
  }
  
  public final String g(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(179930);
    if (paramBoolean)
    {
      paramca = hM(paramca.field_transContent, paramca.field_isSend);
      AppMethodBeat.o(179930);
      return paramca;
    }
    paramca = hM(paramca.field_content, paramca.field_isSend);
    AppMethodBeat.o(179930);
    return paramca;
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35738);
    this.WPt.clear();
    EventCenter.instance.addListener(this.HEM);
    AppMethodBeat.o(35738);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(285579);
    super.hGY();
    this.WPv = true;
    if (this.WPu >= 0) {
      I(this.WPw, 1, avK(this.WPu));
    }
    AppMethodBeat.o(285579);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35739);
    hOa();
    AppMethodBeat.o(35739);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35740);
    super.hNZ();
    hOa();
    AppMethodBeat.o(35740);
  }
  
  public final void hQT()
  {
    this.WPv = true;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(285580);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 < this.WPp) {
      this.MpG = false;
    }
    this.WPp = paramInt1;
    AppMethodBeat.o(285580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bi
 * JD-Core Version:    0.7.0.1
 */