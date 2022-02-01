package com.tencent.mm.plugin.patmsg;

import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PluginPatMsg
  extends com.tencent.mm.kernel.b.f
  implements c, com.tencent.mm.plugin.patmsg.a.e
{
  private a wVk;
  private Map<String, com.tencent.mm.plugin.patmsg.a.f> wVl;
  private Animation wVm;
  private Animation wVn;
  private Animation wVo;
  private Map<Long, cjb> wVp;
  private b wVq;
  
  public PluginPatMsg()
  {
    AppMethodBeat.i(220325);
    this.wVk = new a();
    this.wVl = new HashMap();
    this.wVm = AnimationUtils.loadAnimation(ak.getContext(), 2130772172);
    this.wVn = AnimationUtils.loadAnimation(ak.getContext(), 2130772182);
    this.wVo = AnimationUtils.loadAnimation(ak.getContext(), 2130772181);
    this.wVp = new HashMap();
    this.wVq = null;
    AppMethodBeat.o(220325);
  }
  
  private void syncRecvRecord()
  {
    AppMethodBeat.i(220339);
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220324);
        LinkedList localLinkedList = new LinkedList();
        synchronized (PluginPatMsg.this.wVp)
        {
          localLinkedList.addAll(PluginPatMsg.this.wVp.values());
          if (PluginPatMsg.this.wVq != null) {
            PluginPatMsg.this.wVq.r(localLinkedList);
          }
          AppMethodBeat.o(220324);
          return;
        }
      }
    }, "sync_pat_recv_record_thread");
    AppMethodBeat.o(220339);
  }
  
  public void addRecvRecord(long paramLong, cja paramcja)
  {
    AppMethodBeat.i(220336);
    synchronized (this.wVp)
    {
      cjb localcjb = new cjb();
      localcjb.HvF = paramLong;
      localcjb.HvG = paramcja;
      this.wVp.put(Long.valueOf(paramcja.nCM), localcjb);
      syncRecvRecord();
      AppMethodBeat.o(220336);
      return;
    }
  }
  
  public void clearTemplate()
  {
    AppMethodBeat.i(220334);
    this.wVl.clear();
    AppMethodBeat.o(220334);
  }
  
  public void deleteRecvRecord(long paramLong)
  {
    AppMethodBeat.i(220337);
    synchronized (this.wVp)
    {
      this.wVp.remove(Long.valueOf(paramLong));
      syncRecvRecord();
      AppMethodBeat.o(220337);
      return;
    }
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public String getAccPatMsgPath()
  {
    AppMethodBeat.i(220335);
    String str = com.tencent.mm.kernel.g.ajR().gDT + "patmsg/";
    AppMethodBeat.o(220335);
    return str;
  }
  
  public cjb getRecvRecord(long paramLong)
  {
    AppMethodBeat.i(220338);
    synchronized (this.wVp)
    {
      cjb localcjb = (cjb)this.wVp.get(Long.valueOf(paramLong));
      AppMethodBeat.o(220338);
      return localcjb;
    }
  }
  
  public boolean isNickClickable()
  {
    AppMethodBeat.i(220331);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("SendPatUserShowBitVal", 0) != 0)
    {
      AppMethodBeat.o(220331);
      return true;
    }
    AppMethodBeat.o(220331);
    return false;
  }
  
  public boolean isPatEnable()
  {
    AppMethodBeat.i(220330);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("DisableSendPat", 1);
    ae.i("MicroMsg.PluginPatMsg", "disable sendPat %d", new Object[] { Integer.valueOf(i) });
    if ((j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE) || (j.DEBUG))
    {
      AppMethodBeat.o(220330);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(220330);
      return true;
    }
    AppMethodBeat.o(220330);
    return false;
  }
  
  public boolean isRevokePatMsgEnable()
  {
    AppMethodBeat.i(220332);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPQ, 1) == 1)
    {
      AppMethodBeat.o(220332);
      return true;
    }
    AppMethodBeat.o(220332);
    return false;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(220326);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.patmsg.a.b.class, this.wVk);
    com.tencent.mm.kernel.g.ajj().a(849, this.wVk);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("pat", this.wVk.wVe);
    this.wVq = new b(((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).getAccPatMsgPath() + "pat_recv_record");
    com.tencent.e.h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220323);
        Object localObject1 = PluginPatMsg.this.wVq.aQM();
        if (localObject1 != null)
        {
          synchronized (PluginPatMsg.this.wVp)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              cjb localcjb = (cjb)((Iterator)localObject1).next();
              PluginPatMsg.this.wVp.put(Long.valueOf(localcjb.HvG.nCM), localcjb);
            }
          }
          AppMethodBeat.o(220323);
          return;
        }
        AppMethodBeat.o(220323);
      }
    });
    AppMethodBeat.o(220326);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(220327);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.patmsg.a.b.class);
    com.tencent.mm.kernel.g.ajj().b(849, this.wVk);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("pat", this.wVk.wVe);
    AppMethodBeat.o(220327);
  }
  
  public com.tencent.mm.plugin.patmsg.a.f parseDisplayTemplate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220333);
    Object localObject = com.tencent.mm.plugin.messenger.a.h.aqC(paramString1);
    if (this.wVl.containsKey(paramString1))
    {
      ae.i("MicroMsg.PluginPatMsg", "find %s (%s) in cache", new Object[] { paramString1, this.wVl.get(paramString1) });
      paramString1 = (com.tencent.mm.plugin.patmsg.a.f)this.wVl.get(paramString1);
      AppMethodBeat.o(220333);
      return paramString1;
    }
    com.tencent.mm.plugin.patmsg.a.f localf = new com.tencent.mm.plugin.patmsg.a.f();
    Iterator localIterator = ((List)localObject).iterator();
    h.a locala;
    String str;
    for (localObject = paramString1; localIterator.hasNext(); localObject = ((String)localObject).replace(locala.group, str))
    {
      locala = (h.a)localIterator.next();
      str = w.getDisplayName(locala.value, paramString2);
      int i = ((String)localObject).indexOf(locala.group);
      localf.wVt.add(Pair.create(Integer.valueOf(i), Integer.valueOf(i + str.length())));
      localf.hUu.add(locala.value);
    }
    localf.result = ((String)localObject);
    this.wVl.put(paramString1, localf);
    AppMethodBeat.o(220333);
    return localf;
  }
  
  public void playPatAnimation(View paramView)
  {
    AppMethodBeat.i(220328);
    paramView.startAnimation(this.wVm);
    AppMethodBeat.o(220328);
  }
  
  public void playRevokePatAnimation(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(220329);
    if (paramBoolean) {}
    for (Animation localAnimation = this.wVn;; localAnimation = this.wVo)
    {
      paramView.startAnimation(localAnimation);
      AppMethodBeat.o(220329);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.PluginPatMsg
 * JD-Core Version:    0.7.0.1
 */