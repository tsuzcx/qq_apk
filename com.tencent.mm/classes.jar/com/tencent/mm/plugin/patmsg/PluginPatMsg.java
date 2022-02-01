package com.tencent.mm.plugin.patmsg;

import android.util.Pair;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.a.h.a;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PluginPatMsg
  extends com.tencent.mm.kernel.b.f
  implements c, com.tencent.mm.plugin.patmsg.a.e
{
  private a ARg;
  private Map<String, com.tencent.mm.plugin.patmsg.a.f> ARh;
  private b ARi;
  LinkedList<czi> ARj;
  
  public PluginPatMsg()
  {
    AppMethodBeat.i(206947);
    this.ARg = new a();
    this.ARh = new HashMap();
    this.ARi = null;
    this.ARj = null;
    AppMethodBeat.o(206947);
  }
  
  private void syncRecvRecord()
  {
    AppMethodBeat.i(206961);
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206946);
        if (PluginPatMsg.this.ARi != null)
        {
          LinkedList localLinkedList = new LinkedList();
          int i = 0;
          while ((i < 100) && (i < PluginPatMsg.this.ARj.size()))
          {
            localLinkedList.add(PluginPatMsg.this.ARj.get(i));
            i += 1;
          }
          PluginPatMsg.this.ARi.r(localLinkedList);
        }
        AppMethodBeat.o(206946);
      }
    }, "sync_pat_recv_record_thread");
    AppMethodBeat.o(206961);
  }
  
  public void addRecvRecord(long paramLong, czh paramczh)
  {
    AppMethodBeat.i(206958);
    synchronized (this.ARj)
    {
      czi localczi = new czi();
      localczi.MED = paramLong;
      localczi.MEE = paramczh;
      this.ARj.addFirst(localczi);
      syncRecvRecord();
      AppMethodBeat.o(206958);
      return;
    }
  }
  
  public void clearTemplate()
  {
    AppMethodBeat.i(206956);
    this.ARh.clear();
    AppMethodBeat.o(206956);
  }
  
  public void deleteRecvRecord(long paramLong)
  {
    AppMethodBeat.i(206959);
    syncRecvRecord();
    AppMethodBeat.o(206959);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public String getAccPatMsgPath()
  {
    AppMethodBeat.i(206957);
    String str = com.tencent.mm.kernel.g.aAh().cachePath + "patmsg/";
    AppMethodBeat.o(206957);
    return str;
  }
  
  public czi getRecvRecord(long paramLong)
  {
    AppMethodBeat.i(206960);
    synchronized (this.ARj)
    {
      Iterator localIterator = this.ARj.iterator();
      while (localIterator.hasNext())
      {
        czi localczi = (czi)localIterator.next();
        if ((localczi.MEE != null) && (localczi.MEE.oNJ == paramLong))
        {
          AppMethodBeat.o(206960);
          return localczi;
        }
      }
      AppMethodBeat.o(206960);
      return null;
    }
  }
  
  public boolean isNickClickable()
  {
    AppMethodBeat.i(206953);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("SendPatUserShowBitVal", 0) != 0)
    {
      AppMethodBeat.o(206953);
      return true;
    }
    AppMethodBeat.o(206953);
    return false;
  }
  
  public boolean isPatEnable()
  {
    AppMethodBeat.i(206952);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("DisableSendPat", 1);
    Log.i("MicroMsg.PluginPatMsg", "disable sendPat %d", new Object[] { Integer.valueOf(i) });
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(206952);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(206952);
      return true;
    }
    AppMethodBeat.o(206952);
    return false;
  }
  
  public boolean isRevokePatMsgEnable()
  {
    AppMethodBeat.i(206954);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.snb, 1) == 1)
    {
      AppMethodBeat.o(206954);
      return true;
    }
    AppMethodBeat.o(206954);
    return false;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(206948);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.patmsg.a.b.class, this.ARg);
    com.tencent.mm.kernel.g.azz().a(849, this.ARg);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("pat", this.ARg.ARa);
    if (paramc.hrc) {
      com.tencent.mm.vfs.s.dy(com.tencent.mm.kernel.g.aAh().hqG + "patmsg/", true);
    }
    this.ARi = new b(((PluginPatMsg)com.tencent.mm.kernel.g.ah(PluginPatMsg.class)).getAccPatMsgPath() + "pat_recv_record");
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206945);
        PluginPatMsg.this.ARj = PluginPatMsg.this.ARi.blq();
        if (PluginPatMsg.this.ARj == null) {
          PluginPatMsg.this.ARj = new LinkedList();
        }
        AppMethodBeat.o(206945);
      }
    });
    AppMethodBeat.o(206948);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(206949);
    com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.patmsg.a.b.class);
    com.tencent.mm.kernel.g.azz().b(849, this.ARg);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("pat", this.ARg.ARa);
    AppMethodBeat.o(206949);
  }
  
  public com.tencent.mm.plugin.patmsg.a.f parseDisplayTemplate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206955);
    Object localObject = com.tencent.mm.plugin.messenger.a.h.aDX(paramString1);
    if (this.ARh.containsKey(paramString1))
    {
      Log.i("MicroMsg.PluginPatMsg", "find %s (%s) in cache", new Object[] { paramString1, this.ARh.get(paramString1) });
      paramString1 = (com.tencent.mm.plugin.patmsg.a.f)this.ARh.get(paramString1);
      AppMethodBeat.o(206955);
      return paramString1;
    }
    com.tencent.mm.plugin.patmsg.a.f localf = new com.tencent.mm.plugin.patmsg.a.f();
    Iterator localIterator = ((List)localObject).iterator();
    h.a locala;
    String str;
    for (localObject = paramString1; localIterator.hasNext(); localObject = ((String)localObject).replace(locala.group, str))
    {
      locala = (h.a)localIterator.next();
      str = aa.getDisplayName(locala.value, paramString2);
      int i = ((String)localObject).indexOf(locala.group);
      localf.ARm.add(Pair.create(Integer.valueOf(i), Integer.valueOf(i + str.length())));
      localf.iPH.add(locala.value);
    }
    localf.result = ((String)localObject);
    this.ARh.put(paramString1, localf);
    AppMethodBeat.o(206955);
    return localf;
  }
  
  public void playPatAnimation(View paramView)
  {
    AppMethodBeat.i(206950);
    paramView.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130771994));
    AppMethodBeat.o(206950);
  }
  
  public void playRevokePatAnimation(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(206951);
    if (paramBoolean)
    {
      paramView.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130771991));
      AppMethodBeat.o(206951);
      return;
    }
    paramView.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130771990));
    AppMethodBeat.o(206951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.PluginPatMsg
 * JD-Core Version:    0.7.0.1
 */