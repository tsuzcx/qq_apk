package com.tencent.mm.plugin.patmsg;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.patmsg.a.e;
import com.tencent.mm.plugin.patmsg.a.f.a;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PluginPatMsg
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, e
{
  private a MHg;
  private Map<String, com.tencent.mm.plugin.patmsg.a.f> MHh;
  private b MHi;
  LinkedList<ebf> MHj;
  
  public PluginPatMsg()
  {
    AppMethodBeat.i(266349);
    this.MHg = new a();
    this.MHh = new HashMap();
    this.MHi = null;
    this.MHj = null;
    AppMethodBeat.o(266349);
  }
  
  private void syncRecvRecord()
  {
    AppMethodBeat.i(266353);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(266346);
        if (PluginPatMsg.this.MHi != null)
        {
          LinkedList localLinkedList = new LinkedList();
          int i = 0;
          while ((i < 100) && (i < PluginPatMsg.this.MHj.size()))
          {
            localLinkedList.add((ebf)PluginPatMsg.this.MHj.get(i));
            i += 1;
          }
          PluginPatMsg.this.MHi.s(localLinkedList);
        }
        AppMethodBeat.o(266346);
      }
    }, "sync_pat_recv_record_thread");
    AppMethodBeat.o(266353);
  }
  
  public void addRecvRecord(long paramLong, ebe paramebe)
  {
    AppMethodBeat.i(266440);
    synchronized (this.MHj)
    {
      ebf localebf = new ebf();
      localebf.abgM = paramLong;
      localebf.abgN = paramebe;
      this.MHj.addFirst(localebf);
      syncRecvRecord();
      AppMethodBeat.o(266440);
      return;
    }
  }
  
  public void clearTemplate()
  {
    AppMethodBeat.i(266432);
    this.MHh.clear();
    AppMethodBeat.o(266432);
  }
  
  public void deleteRecvRecord(long paramLong)
  {
    AppMethodBeat.i(266445);
    syncRecvRecord();
    AppMethodBeat.o(266445);
  }
  
  public void execute(g paramg) {}
  
  public String getAccPatMsgPath()
  {
    AppMethodBeat.i(266436);
    String str = com.tencent.mm.kernel.h.baE().cachePath + "patmsg/";
    AppMethodBeat.o(266436);
    return str;
  }
  
  public ebf getRecvRecord(long paramLong)
  {
    AppMethodBeat.i(266450);
    synchronized (this.MHj)
    {
      Iterator localIterator = this.MHj.iterator();
      while (localIterator.hasNext())
      {
        ebf localebf = (ebf)localIterator.next();
        if ((localebf.abgN != null) && (localebf.abgN.vaU == paramLong))
        {
          AppMethodBeat.o(266450);
          return localebf;
        }
      }
      AppMethodBeat.o(266450);
      return null;
    }
  }
  
  public boolean isNickClickable()
  {
    AppMethodBeat.i(266396);
    if ((((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("SendPatUserShowBitVal", 2) & 0x1) != 0)
    {
      AppMethodBeat.o(266396);
      return true;
    }
    AppMethodBeat.o(266396);
    return false;
  }
  
  public boolean isPatEnable()
  {
    AppMethodBeat.i(266388);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("DisableSendPat", 1);
    Log.i("MicroMsg.PluginPatMsg", "disable sendPat %d", new Object[] { Integer.valueOf(i) });
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(266388);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(266388);
      return true;
    }
    AppMethodBeat.o(266388);
    return false;
  }
  
  public boolean isRevokePatMsgEnable()
  {
    AppMethodBeat.i(266406);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqT, 1) == 1)
    {
      AppMethodBeat.o(266406);
      return true;
    }
    AppMethodBeat.o(266406);
    return false;
  }
  
  public boolean isStatusIconShow()
  {
    AppMethodBeat.i(266400);
    if ((((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("SendPatUserShowBitVal", 2) & 0x2) != 0)
    {
      AppMethodBeat.o(266400);
      return true;
    }
    AppMethodBeat.o(266400);
    return false;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(266361);
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.patmsg.a.b.class, this.MHg);
    com.tencent.mm.kernel.h.aZW().a(849, this.MHg);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("pat", this.MHg.MHa);
    if (paramc.mDg) {
      y.ew(com.tencent.mm.kernel.h.baE().mCJ + "patmsg/", true);
    }
    this.MHi = new b(((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).getAccPatMsgPath() + "pat_recv_record");
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(266345);
        PluginPatMsg.this.MHj = PluginPatMsg.this.MHi.bTt();
        if (PluginPatMsg.this.MHj == null) {
          PluginPatMsg.this.MHj = new LinkedList();
        }
        AppMethodBeat.o(266345);
      }
    });
    AppMethodBeat.o(266361);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(266369);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.patmsg.a.b.class);
    com.tencent.mm.kernel.h.aZW().b(849, this.MHg);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("pat", this.MHg.MHa);
    AppMethodBeat.o(266369);
  }
  
  public com.tencent.mm.plugin.patmsg.a.f parseDisplayTemplate(ebe paramebe, String paramString)
  {
    AppMethodBeat.i(266413);
    if (paramebe == null)
    {
      paramebe = new com.tencent.mm.plugin.patmsg.a.f();
      AppMethodBeat.o(266413);
      return paramebe;
    }
    paramebe = parseDisplayTemplate(paramebe.hQQ, paramebe.abgI, paramebe.nVS, paramString);
    AppMethodBeat.o(266413);
    return paramebe;
  }
  
  public com.tencent.mm.plugin.patmsg.a.f parseDisplayTemplate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(266427);
    Object localObject = (com.tencent.mm.plugin.patmsg.a.f)this.MHh.get(paramString3);
    if (localObject != null)
    {
      Log.i("MicroMsg.PluginPatMsg", "find %s (%s) in cache", new Object[] { paramString3, localObject });
      AppMethodBeat.o(266427);
      return localObject;
    }
    com.tencent.mm.plugin.patmsg.a.f localf = new com.tencent.mm.plugin.patmsg.a.f();
    Log.i("MicroMsg.PluginPatMsg", "parseDisplayTemplate realtime templateStr:%s ", new Object[] { paramString3 });
    boolean bool1 = ((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).isStatusIconShow();
    Iterator localIterator = com.tencent.mm.plugin.messenger.a.h.aLf(paramString3).iterator();
    localObject = paramString3;
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (!TextUtils.isEmpty(locala.value))
      {
        String str;
        int i;
        if (locala.value.endsWith("@textstatusicon"))
        {
          if (bool1)
          {
            str = locala.value.replace("@textstatusicon", "");
            boolean bool2;
            if (TextUtils.equals(str, "fromusername"))
            {
              bool2 = ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).hasStatus(paramString1);
              if (bool2) {}
              for (str = "​";; str = "")
              {
                i = ((String)localObject).indexOf(locala.group);
                if (bool2) {
                  localf.MHr.add(new f.a(i, str.length() + i, paramString1));
                }
                localObject = ((String)localObject).replace(locala.group, str);
                break;
              }
            }
            if (TextUtils.equals(str, "pattedusername"))
            {
              bool2 = ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).hasStatus(paramString2);
              if (bool2) {}
              for (str = "​";; str = "")
              {
                i = ((String)localObject).indexOf(locala.group);
                if (bool2) {
                  localf.MHr.add(new f.a(i, str.length() + i, paramString2));
                }
                localObject = ((String)localObject).replace(locala.group, str);
                break;
              }
            }
            localObject = ((String)localObject).replace(locala.group, "");
          }
        }
        else
        {
          str = aa.aV(locala.value, paramString4);
          i = ((String)localObject).indexOf(locala.group);
          localf.MHq.add(Pair.create(Integer.valueOf(i), Integer.valueOf(i + str.length())));
          localf.oxE.add(locala.value);
          localObject = ((String)localObject).replace(locala.group, str);
        }
      }
    }
    localf.result = ((String)localObject);
    this.MHh.put(paramString3, localf);
    AppMethodBeat.o(266427);
    return localf;
  }
  
  public void playPatAnimation(View paramView)
  {
    AppMethodBeat.i(266375);
    paramView.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), d.a.anim_shake_avatar));
    AppMethodBeat.o(266375);
  }
  
  public void playRevokePatAnimation(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(266380);
    if (paramBoolean)
    {
      paramView.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), d.a.anim_rotate_avatar_right));
      AppMethodBeat.o(266380);
      return;
    }
    paramView.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), d.a.anim_rotate_avatar_left));
    AppMethodBeat.o(266380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.PluginPatMsg
 * JD-Core Version:    0.7.0.1
 */