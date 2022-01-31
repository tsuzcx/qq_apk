package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.k;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.an.a;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.pluginsdk.f.f.a;
import com.tencent.mm.pluginsdk.f.f.b;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.z;
import org.json.JSONObject;

final class aa$1
  implements Runnable
{
  aa$1(aa paramaa) {}
  
  public final void run()
  {
    if (!com.tencent.mm.kernel.g.DN().Dc())
    {
      y.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
      return;
    }
    if (this.uPf.uOZ == null)
    {
      y.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
      return;
    }
    int i;
    if (!au.DK())
    {
      y.w("MicroMsg.UnreadCountHelper", "getFindTabUnreadCount, but mmcore not ready");
      i = 0;
      this.uPf.uOZ.mH(false);
      this.uPf.uOZ.FJ(i);
      if ((i <= 0) && (com.tencent.mm.bp.a.cki()) && (com.tencent.mm.bh.d.RZ().aAo() > 0)) {
        this.uPf.uOZ.mH(true);
      }
      if ((i > 0) || ((q.Gu() & 0x8000) != 0)) {
        break label424;
      }
      au.Hx();
      if (!ah.e((Boolean)com.tencent.mm.model.c.Dz().get(68384, null))) {
        break label424;
      }
      au.Hx();
      if (!ah.bl((String)com.tencent.mm.model.c.Dz().get(68377, null))) {
        this.uPf.uOZ.mH(true);
      }
    }
    else
    {
      i = q.Gn();
      if (((q.Gu() & 0x40) != 0) || ((i & 0x8000) != 0)) {
        break label1128;
      }
    }
    label424:
    label869:
    label1128:
    for (int j = k.Gf() + 0;; j = 0)
    {
      if (((q.Gu() & 0x200) == 0) && (!com.tencent.mm.bp.a.cki())) {}
      for (i = com.tencent.mm.bh.d.RZ().aAo() + 0;; i = 0)
      {
        int k = i;
        if ((q.Gu() & 0x100) == 0)
        {
          localObject = com.tencent.mm.bh.d.Sa();
          k = i;
          if (localObject != null) {
            k = i + ((bu)localObject).aAo();
          }
          k += o.a.ckl().bzN();
        }
        j += k;
        i = j;
        if ((q.Gu() & 0x8000) == 0)
        {
          i = j;
          if (n.omE != null) {
            i = j + n.omE.aAo();
          }
        }
        break;
        au.Hx();
        if (((Boolean)com.tencent.mm.model.c.Dz().get(589825, Boolean.valueOf(false))).booleanValue())
        {
          this.uPf.uOZ.mH(true);
          return;
        }
        Object localObject = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzz, null);
        if (localObject == null) {}
        for (long l = 0L; (l != 0L) && (((m)com.tencent.mm.kernel.g.r(m.class)).fE(l)); l = ((Long)localObject).longValue())
        {
          this.uPf.uOZ.mH(true);
          return;
        }
        boolean bool;
        if (i <= 0)
        {
          if ((q.Go() & 0x400000) != 0L) {}
          for (j = 1;; j = 0)
          {
            localObject = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigName");
            String str1 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigIconUrl");
            String str2 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigJumpUrl");
            y.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd tryshow configName " + (String)localObject + " iconUrl " + str1 + " jumpUrl " + str2);
            if ((j != 0) || (ah.bl((String)localObject)) || (ah.bl(str1)) || (ah.bl(str2))) {
              break label645;
            }
            localObject = f.rVL;
            if (localObject == null) {
              break label645;
            }
            bool = ((f.b)localObject).bLM();
            y.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend " + bool);
            if (!bool) {
              break label645;
            }
            localObject = ((f.b)localObject).bLU();
            if ((!((f.a)localObject).aiS()) || (((f.a)localObject).bLD())) {
              break;
            }
            this.uPf.uOZ.mH(true);
            return;
          }
          y.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd time is not start or jd time isExpire");
        }
        if ((q.Go() & 0x2000000) != 0L)
        {
          j = 1;
          if (!com.tencent.mm.plugin.ipcall.d.bbM()) {
            break label1058;
          }
          if ((j == 0) && (!this.uPf.uOZ.getShowFriendPoint()) && (i <= 0))
          {
            au.Hx();
            if (((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uqq, Integer.valueOf(0))).intValue() >= com.tencent.mm.m.g.AA().getInt("WCOEntranceRedDot", 0))
            {
              au.Hx();
              if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uqs, Boolean.valueOf(false))).booleanValue() != true) {}
            }
            else
            {
              this.uPf.uOZ.mH(true);
            }
          }
          label764:
          if ((q.Go() & 0x200000) == 0L) {
            break label1078;
          }
          i = 1;
          if (i == 0)
          {
            localObject = an.bZJ();
            if ((((an)localObject).qUQ == null) || (!((an)localObject).qUQ.isValid()) || (((an)localObject).qUQ.qUU != 1)) {
              break label1101;
            }
            localObject = ac.Ru("discoverSearchEntry");
            if (!((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.a.class)).Ul("labs1de6f3")) {
              break label1083;
            }
            if (!((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.a.class)).Uj("labs1de6f3")) {
              break label1117;
            }
            bool = true;
          }
        }
        for (;;)
        {
          y.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "search show %b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            i = 1;
            if (i != 0) {
              this.uPf.uOZ.mH(true);
            }
            an.bZJ();
            an.bZK();
            if (com.tencent.mm.y.c.BS().a(ac.a.uzK, 266241)) {
              this.uPf.uOZ.mH(true);
            }
            au.Hx();
            if ((com.tencent.mm.model.c.Dz().getInt(40, 0) & 0x20000) != 0) {
              break label1112;
            }
          }
          for (i = 1;; i = 0)
          {
            if (bk.getInt(com.tencent.mm.m.g.AA().getValue("VoiceprintEntry"), 0) == 1) {
              au.Hx();
            }
            for (bool = ((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uou, Boolean.valueOf(true))).booleanValue();; bool = false)
            {
              if ((bool) && (i != 0))
              {
                y.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
                this.uPf.uOZ.mI(true);
              }
              this.uPf.uPa = false;
              return;
              j = 0;
              break;
              au.Hx();
              com.tencent.mm.model.c.Dz().c(ac.a.uqp, Boolean.valueOf(false));
              break label764;
              i = 0;
              break label778;
              if (((JSONObject)localObject).optInt("entrySwitch") != 1) {
                break label1117;
              }
              bool = true;
              break label869;
              i = 0;
              break label897;
            }
          }
          bool = false;
        }
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|setTagRunnable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.aa.1
 * JD-Core Version:    0.7.0.1
 */