package com.tencent.mm.plugin.patmsg;

import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PluginPatMsg
  extends com.tencent.mm.kernel.b.f
  implements c, com.tencent.mm.plugin.patmsg.a.e
{
  private Map<String, com.tencent.mm.plugin.patmsg.a.f> wFA;
  private Animation wFB;
  private Animation wFC;
  private Animation wFD;
  private Map<Long, cih> wFE;
  private b wFF;
  private a wFz;
  
  public PluginPatMsg()
  {
    AppMethodBeat.i(215691);
    this.wFz = new a();
    this.wFA = new HashMap();
    this.wFB = AnimationUtils.loadAnimation(aj.getContext(), 2130772172);
    this.wFC = AnimationUtils.loadAnimation(aj.getContext(), 2130772182);
    this.wFD = AnimationUtils.loadAnimation(aj.getContext(), 2130772181);
    this.wFE = new HashMap();
    this.wFF = null;
    AppMethodBeat.o(215691);
  }
  
  private void syncRecvRecord()
  {
    AppMethodBeat.i(215705);
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215690);
        LinkedList localLinkedList = new LinkedList();
        synchronized (PluginPatMsg.this.wFE)
        {
          localLinkedList.addAll(PluginPatMsg.this.wFE.values());
          if (PluginPatMsg.this.wFF != null) {
            PluginPatMsg.this.wFF.r(localLinkedList);
          }
          AppMethodBeat.o(215690);
          return;
        }
      }
    }, "sync_pat_recv_record_thread");
    AppMethodBeat.o(215705);
  }
  
  public void addRecvRecord(long paramLong, cig paramcig)
  {
    AppMethodBeat.i(215702);
    synchronized (this.wFE)
    {
      cih localcih = new cih();
      localcih.Hcf = paramLong;
      localcih.Hcg = paramcig;
      this.wFE.put(Long.valueOf(paramcig.nxr), localcih);
      syncRecvRecord();
      AppMethodBeat.o(215702);
      return;
    }
  }
  
  public void clearTemplate()
  {
    AppMethodBeat.i(215700);
    this.wFA.clear();
    AppMethodBeat.o(215700);
  }
  
  public void deleteRecvRecord(long paramLong)
  {
    AppMethodBeat.i(215703);
    synchronized (this.wFE)
    {
      this.wFE.remove(Long.valueOf(paramLong));
      syncRecvRecord();
      AppMethodBeat.o(215703);
      return;
    }
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public String getAccPatMsgPath()
  {
    AppMethodBeat.i(215701);
    String str = com.tencent.mm.kernel.g.ajC().gBm + "patmsg/";
    AppMethodBeat.o(215701);
    return str;
  }
  
  public cih getRecvRecord(long paramLong)
  {
    AppMethodBeat.i(215704);
    synchronized (this.wFE)
    {
      cih localcih = (cih)this.wFE.get(Long.valueOf(paramLong));
      AppMethodBeat.o(215704);
      return localcih;
    }
  }
  
  public boolean isNickClickable()
  {
    AppMethodBeat.i(215697);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("SendPatUserShowBitVal", 0) != 0)
    {
      AppMethodBeat.o(215697);
      return true;
    }
    AppMethodBeat.o(215697);
    return false;
  }
  
  public boolean isPatEnable()
  {
    AppMethodBeat.i(215696);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("DisableSendPat", 1);
    ad.i("MicroMsg.PluginPatMsg", "disable sendPat %d", new Object[] { Integer.valueOf(i) });
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.DEBUG))
    {
      AppMethodBeat.o(215696);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(215696);
      return true;
    }
    AppMethodBeat.o(215696);
    return false;
  }
  
  public boolean isRevokePatMsgEnable()
  {
    AppMethodBeat.i(215698);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIj, 1) == 1)
    {
      AppMethodBeat.o(215698);
      return true;
    }
    AppMethodBeat.o(215698);
    return false;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(215692);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.patmsg.a.b.class, this.wFz);
    com.tencent.mm.kernel.g.aiU().a(849, this.wFz);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("pat", this.wFz.wFt);
    this.wFF = new b(((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).getAccPatMsgPath() + "pat_recv_record");
    com.tencent.e.h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215689);
        Object localObject1 = PluginPatMsg.this.wFF.aQn();
        if (localObject1 != null)
        {
          synchronized (PluginPatMsg.this.wFE)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              cih localcih = (cih)((Iterator)localObject1).next();
              PluginPatMsg.this.wFE.put(Long.valueOf(localcih.Hcg.nxr), localcih);
            }
          }
          AppMethodBeat.o(215689);
          return;
        }
        AppMethodBeat.o(215689);
      }
    });
    AppMethodBeat.o(215692);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(215693);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.patmsg.a.b.class);
    com.tencent.mm.kernel.g.aiU().b(849, this.wFz);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("pat", this.wFz.wFt);
    AppMethodBeat.o(215693);
  }
  
  public com.tencent.mm.plugin.patmsg.a.f parseDisplayTemplate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215699);
    Object localObject = com.tencent.mm.plugin.messenger.a.h.apx(paramString1);
    if (this.wFA.containsKey(paramString1))
    {
      ad.i("MicroMsg.PluginPatMsg", "find %s (%s) in cache", new Object[] { paramString1, this.wFA.get(paramString1) });
      paramString1 = (com.tencent.mm.plugin.patmsg.a.f)this.wFA.get(paramString1);
      AppMethodBeat.o(215699);
      return paramString1;
    }
    com.tencent.mm.plugin.patmsg.a.f localf = new com.tencent.mm.plugin.patmsg.a.f();
    Iterator localIterator = ((List)localObject).iterator();
    h.a locala;
    String str;
    for (localObject = paramString1; localIterator.hasNext(); localObject = ((String)localObject).replace(locala.group, str))
    {
      locala = (h.a)localIterator.next();
      str = v.getDisplayName(locala.value, paramString2);
      int i = ((String)localObject).indexOf(locala.group);
      localf.wFI.add(Pair.create(Integer.valueOf(i), Integer.valueOf(i + str.length())));
      localf.hRC.add(locala.value);
    }
    localf.result = ((String)localObject);
    this.wFA.put(paramString1, localf);
    AppMethodBeat.o(215699);
    return localf;
  }
  
  public void playPatAnimation(View paramView)
  {
    AppMethodBeat.i(215694);
    paramView.startAnimation(this.wFB);
    AppMethodBeat.o(215694);
  }
  
  public void playRevokePatAnimation(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(215695);
    if (paramBoolean) {}
    for (Animation localAnimation = this.wFC;; localAnimation = this.wFD)
    {
      paramView.startAnimation(localAnimation);
      AppMethodBeat.o(215695);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.PluginPatMsg
 * JD-Core Version:    0.7.0.1
 */