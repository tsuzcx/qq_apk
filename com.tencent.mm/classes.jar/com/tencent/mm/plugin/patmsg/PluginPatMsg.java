package com.tencent.mm.plugin.patmsg;

import android.util.Pair;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.patmsg.a.e;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PluginPatMsg
  extends com.tencent.mm.kernel.b.f
  implements c, e
{
  private a GKr;
  private Map<String, com.tencent.mm.plugin.patmsg.a.f> GKs;
  private b GKt;
  LinkedList<div> GKu;
  
  public PluginPatMsg()
  {
    AppMethodBeat.i(186562);
    this.GKr = new a();
    this.GKs = new HashMap();
    this.GKt = null;
    this.GKu = null;
    AppMethodBeat.o(186562);
  }
  
  private void syncRecvRecord()
  {
    AppMethodBeat.i(186580);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186554);
        if (PluginPatMsg.this.GKt != null)
        {
          LinkedList localLinkedList = new LinkedList();
          int i = 0;
          while ((i < 100) && (i < PluginPatMsg.this.GKu.size()))
          {
            localLinkedList.add(PluginPatMsg.this.GKu.get(i));
            i += 1;
          }
          PluginPatMsg.this.GKt.r(localLinkedList);
        }
        AppMethodBeat.o(186554);
      }
    }, "sync_pat_recv_record_thread");
    AppMethodBeat.o(186580);
  }
  
  public void addRecvRecord(long paramLong, diu paramdiu)
  {
    AppMethodBeat.i(186577);
    synchronized (this.GKu)
    {
      div localdiv = new div();
      localdiv.TQn = paramLong;
      localdiv.TQo = paramdiu;
      this.GKu.addFirst(localdiv);
      syncRecvRecord();
      AppMethodBeat.o(186577);
      return;
    }
  }
  
  public void clearTemplate()
  {
    AppMethodBeat.i(186575);
    this.GKs.clear();
    AppMethodBeat.o(186575);
  }
  
  public void deleteRecvRecord(long paramLong)
  {
    AppMethodBeat.i(186578);
    syncRecvRecord();
    AppMethodBeat.o(186578);
  }
  
  public void execute(g paramg) {}
  
  public String getAccPatMsgPath()
  {
    AppMethodBeat.i(186576);
    String str = com.tencent.mm.kernel.h.aHG().cachePath + "patmsg/";
    AppMethodBeat.o(186576);
    return str;
  }
  
  public div getRecvRecord(long paramLong)
  {
    AppMethodBeat.i(186579);
    synchronized (this.GKu)
    {
      Iterator localIterator = this.GKu.iterator();
      while (localIterator.hasNext())
      {
        div localdiv = (div)localIterator.next();
        if ((localdiv.TQo != null) && (localdiv.TQo.rPF == paramLong))
        {
          AppMethodBeat.o(186579);
          return localdiv;
        }
      }
      AppMethodBeat.o(186579);
      return null;
    }
  }
  
  public boolean isNickClickable()
  {
    AppMethodBeat.i(186572);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("SendPatUserShowBitVal", 0) != 0)
    {
      AppMethodBeat.o(186572);
      return true;
    }
    AppMethodBeat.o(186572);
    return false;
  }
  
  public boolean isPatEnable()
  {
    AppMethodBeat.i(186571);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("DisableSendPat", 1);
    Log.i("MicroMsg.PluginPatMsg", "disable sendPat %d", new Object[] { Integer.valueOf(i) });
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(186571);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(186571);
      return true;
    }
    AppMethodBeat.o(186571);
    return false;
  }
  
  public boolean isRevokePatMsgEnable()
  {
    AppMethodBeat.i(186573);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYd, 1) == 1)
    {
      AppMethodBeat.o(186573);
      return true;
    }
    AppMethodBeat.o(186573);
    return false;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(186564);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.patmsg.a.b.class, this.GKr);
    com.tencent.mm.kernel.h.aGY().a(849, this.GKr);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("pat", this.GKr.GKl);
    if (paramc.kcX) {
      u.deleteDir(com.tencent.mm.kernel.h.aHG().kcB + "patmsg/");
    }
    this.GKt = new b(((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).getAccPatMsgPath() + "pat_recv_record");
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186607);
        PluginPatMsg.this.GKu = PluginPatMsg.this.GKt.bvg();
        if (PluginPatMsg.this.GKu == null) {
          PluginPatMsg.this.GKu = new LinkedList();
        }
        AppMethodBeat.o(186607);
      }
    });
    AppMethodBeat.o(186564);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(186566);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.patmsg.a.b.class);
    com.tencent.mm.kernel.h.aGY().b(849, this.GKr);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("pat", this.GKr.GKl);
    AppMethodBeat.o(186566);
  }
  
  public com.tencent.mm.plugin.patmsg.a.f parseDisplayTemplate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186574);
    Object localObject = com.tencent.mm.plugin.messenger.a.h.aOh(paramString1);
    if (this.GKs.containsKey(paramString1))
    {
      Log.i("MicroMsg.PluginPatMsg", "find %s (%s) in cache", new Object[] { paramString1, this.GKs.get(paramString1) });
      paramString1 = (com.tencent.mm.plugin.patmsg.a.f)this.GKs.get(paramString1);
      AppMethodBeat.o(186574);
      return paramString1;
    }
    com.tencent.mm.plugin.patmsg.a.f localf = new com.tencent.mm.plugin.patmsg.a.f();
    Iterator localIterator = ((List)localObject).iterator();
    h.a locala;
    String str;
    for (localObject = paramString1; localIterator.hasNext(); localObject = ((String)localObject).replace(locala.group, str))
    {
      locala = (h.a)localIterator.next();
      str = aa.aL(locala.value, paramString2);
      int i = ((String)localObject).indexOf(locala.group);
      localf.GKx.add(Pair.create(Integer.valueOf(i), Integer.valueOf(i + str.length())));
      localf.lFX.add(locala.value);
    }
    localf.result = ((String)localObject);
    this.GKs.put(paramString1, localf);
    AppMethodBeat.o(186574);
    return localf;
  }
  
  public void playPatAnimation(View paramView)
  {
    AppMethodBeat.i(186568);
    paramView.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), d.a.anim_shake_avatar));
    AppMethodBeat.o(186568);
  }
  
  public void playRevokePatAnimation(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(186570);
    if (paramBoolean)
    {
      paramView.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), d.a.anim_rotate_avatar_right));
      AppMethodBeat.o(186570);
      return;
    }
    paramView.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), d.a.anim_rotate_avatar_left));
    AppMethodBeat.o(186570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.PluginPatMsg
 * JD-Core Version:    0.7.0.1
 */