package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.be.j;
import com.tencent.mm.be.l;
import com.tencent.mm.cl.g.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.eggspring.c.a;
import com.tencent.mm.plugin.eggspring.f.b;
import com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggActivity;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.storage.ca;>;
import java.util.Set;
import java.util.TreeMap;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;
import kotlinx.coroutines.by;

public final class aa
  implements com.tencent.mm.an.i
{
  private long AYh;
  private ChattingAnimFrame WDd;
  private com.tencent.mm.plugin.eggspring.f WDe;
  private com.tencent.mm.plugin.eggspring.c WDf;
  private long WDg;
  private long WDh;
  private boolean fTe;
  private String name;
  
  public aa()
  {
    AppMethodBeat.i(34793);
    this.WDd = null;
    this.WDg = 0L;
    this.AYh = 0L;
    this.WDh = 0L;
    AppMethodBeat.o(34793);
  }
  
  static boolean b(com.tencent.mm.be.e parame)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parame != null) {
      if ((parame.type != 1) && (parame.type != 2) && (parame.type != 3))
      {
        bool1 = bool2;
        if (parame.type != 4) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void bT(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34800);
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new StringBuilder();
        bh.beI();
        localObject1 = u.aY(com.tencent.mm.model.c.aHl() + "eggresult.rep", 0, -1);
        com.tencent.mm.be.i locali;
        if (localObject1 != null)
        {
          Log.d("MicroMsg.EggMgr", "data not null, parse it");
          localObject1 = (j)new j().parseFrom((byte[])localObject1);
          localObject2 = ((j)localObject1).lXy.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label307;
          }
          locali = (com.tencent.mm.be.i)((Iterator)localObject2).next();
          if (locali.fSe != paramInt) {
            continue;
          }
          if (paramBoolean)
          {
            locali.lXw += 1;
            break label312;
            if (i == 0)
            {
              localObject2 = new com.tencent.mm.be.i();
              ((com.tencent.mm.be.i)localObject2).fSe = paramInt;
              if (!paramBoolean) {
                break label298;
              }
              ((com.tencent.mm.be.i)localObject2).lXw = 1;
              ((j)localObject1).lXy.add(localObject2);
            }
            localObject2 = ((j)localObject1).toByteArray();
            Log.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[] { localObject1.toString() });
            localObject1 = new StringBuilder();
            bh.beI();
            u.f(com.tencent.mm.model.c.aHl() + "eggresult.rep", (byte[])localObject2, localObject2.length);
            AppMethodBeat.o(34800);
          }
        }
        else
        {
          Log.d("MicroMsg.EggMgr", "data is null, new one");
          localObject1 = new j();
          continue;
        }
        locali.lXx += 1;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[] { localException.getLocalizedMessage() });
        Log.printErrStackTrace("MicroMsg.EggMgr", localException, "", new Object[0]);
        AppMethodBeat.o(34800);
        return;
      }
      label298:
      ((com.tencent.mm.be.i)localObject2).lXx = 1;
      continue;
      label307:
      int i = 0;
      continue;
      label312:
      i = 1;
    }
  }
  
  private static int bo(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(34798);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (MMApplicationContext.getContext() == null))
    {
      AppMethodBeat.o(34798);
      return -1;
    }
    String str = paramString1.toLowerCase();
    i = str.lastIndexOf(paramString2.toLowerCase());
    int k = i;
    if (i == -1)
    {
      AppMethodBeat.o(34798);
      return -1;
    }
    do
    {
      for (;;)
      {
        try
        {
          if ((k >= str.length() - 1) || (Util.isNullOrNil(paramString3))) {
            continue;
          }
          if ((k <= 0) || (str.charAt(k - 1) < 'a') || (str.charAt(k - 1) > 'z')) {
            continue;
          }
          Log.v("MicroMsg.EggMgr", "letter in the prefix");
          localObject = paramString1.substring(0, k);
          j = ((String)localObject).lastIndexOf('/');
          i = j;
          if (j == -1) {
            continue;
          }
          localObject = ((String)localObject).subSequence(j, ((String)localObject).length());
          com.tencent.mm.cl.h.htZ();
          MMApplicationContext.getContext();
          localObject = com.tencent.mm.cl.g.htS().o((CharSequence)localObject, 0);
          if (localObject == null) {
            continue;
          }
          localObject = ((g.b)localObject).text;
          i = j;
          if (Util.isNullOrNil((String)localObject)) {
            continue;
          }
          i = j;
          if (((String)localObject).length() + j != k) {
            continue;
          }
          Log.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
          i = -2;
        }
        catch (Exception paramString1)
        {
          Object localObject;
          int m;
          Log.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", new Object[] { paramString1.getMessage() });
          Log.printErrStackTrace("MicroMsg.EggMgr", paramString1, "", new Object[0]);
          continue;
          i = 1;
          continue;
          int j = 1;
          continue;
          if (i == -2) {
            continue;
          }
          i = 0;
          continue;
        }
        j = i;
        if (i != 0)
        {
          j = i;
          if (paramString2.length() + k < str.length())
          {
            m = str.charAt(paramString2.length() + k);
            j = i;
            if (m >= 97)
            {
              j = i;
              if (m <= 122)
              {
                Log.v("MicroMsg.EggMgr", "letter in the suffix");
                j = 0;
              }
            }
          }
        }
        if (j == 0) {
          continue;
        }
        Log.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", new Object[] { Integer.valueOf(k), Integer.valueOf(str.length()), Integer.valueOf(paramString2.length()) });
        AppMethodBeat.o(34798);
        return k;
        localObject = null;
      }
      i = str.lastIndexOf(paramString2.toLowerCase(), k - 1);
      k = i;
    } while (i != -1);
    AppMethodBeat.o(34798);
    return -1;
  }
  
  private static boolean bza(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(34797);
    boolean bool1;
    if (Util.isNullOrNil(paramString)) {
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(34797);
      return bool1;
      paramString = paramString.split(",");
      int j = paramString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label67;
        }
        bool1 = bool2;
        if (paramString[i].equals(LocaleUtil.getApplicationLanguage())) {
          break;
        }
        i += 1;
      }
      label67:
      bool1 = false;
    }
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(275164);
    ((com.tencent.mm.plugin.eggspring.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.eggspring.a.a.class)).cleanPrefetch();
    AppMethodBeat.o(275164);
  }
  
  public final void V(boolean paramBoolean, String paramString)
  {
    this.fTe = paramBoolean;
    this.name = paramString;
  }
  
  public final long a(final Activity paramActivity, List<ca> paramList)
  {
    AppMethodBeat.i(275160);
    long l1;
    if ((this.WDd != null) && (!this.WDd.hMC()))
    {
      Log.i("MicroMsg.EggMgr", "LuckyBag, ad egg or lucky bag still exist, return.");
      l1 = this.WDg;
      AppMethodBeat.o(275160);
      return l1;
    }
    this.WDg = 0L;
    bh.beI();
    if (Util.secondsToNow(Util.nullAs((Long)com.tencent.mm.model.c.aHp().b(68108, null), 0L)) * 1000L > 21600000L) {
      new MMHandler().postDelayed(new aa.2(this), 10000L);
    }
    Iterator localIterator1 = paramList.iterator();
    ca localca;
    String str;
    while (localIterator1.hasNext())
    {
      localca = (ca)localIterator1.next();
      str = com.tencent.mm.emoji.a.f.s(localca);
      if (!Util.isNullOrNil(str)) {
        if (localca.field_isSend != 1) {
          break label237;
        }
      }
    }
    final boolean bool2;
    int i;
    label209:
    label237:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = ab.Lj(localca.field_talker);
      paramList = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUq();
      if (paramList != null) {
        break;
      }
      Log.d("MicroMsg.EggMgr", "eggList is null");
      i = 0;
      if (i == 0) {
        break label1746;
      }
      this.WDg = localca.field_msgId;
      l1 = this.WDg;
      AppMethodBeat.o(275160);
      return l1;
    }
    int i1 = (int)Util.nowSecond();
    Log.d("MicroMsg.EggMgr", "curSecond is %d, getEggList.size is %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramList.lXv.size()) });
    Object localObject1 = null;
    int j = -1;
    Object localObject2 = null;
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator2 = paramList.lXv.iterator();
    label309:
    Object localObject5;
    Object localObject4;
    int m;
    Object localObject3;
    label368:
    int k;
    label458:
    int n;
    while (localIterator2.hasNext())
    {
      localObject5 = (com.tencent.mm.be.e)localIterator2.next();
      if (bza(((com.tencent.mm.be.e)localObject5).lXr))
      {
        i = -1;
        paramList = null;
        Iterator localIterator3 = ((com.tencent.mm.be.e)localObject5).lXn.iterator();
        localObject4 = localObject1;
        m = j;
        localObject3 = localObject2;
        for (;;)
        {
          if (localIterator3.hasNext())
          {
            localObject1 = (com.tencent.mm.be.f)localIterator3.next();
            localObject2 = ((com.tencent.mm.be.f)localObject1).lXu;
            if (Util.isNullOrNil((String)localObject2))
            {
              Log.e("MicroMsg.EggMgr", "error egg keyWord");
            }
            else
            {
              k = bo(str, (String)localObject2, ((com.tencent.mm.be.f)localObject1).lang);
              if (k == -1) {
                break label1751;
              }
              if (!b((com.tencent.mm.be.e)localObject5)) {
                break label1748;
              }
              if (-1 == i)
              {
                paramList = ((String)localObject2).toLowerCase();
                i = k;
                n = 0;
                if (m != -1)
                {
                  if (!b((com.tencent.mm.be.e)localObject4)) {
                    break label557;
                  }
                  j = n;
                  if (b((com.tencent.mm.be.e)localObject5))
                  {
                    j = n;
                    if (m < k) {
                      j = 1;
                    }
                  }
                  label501:
                  localObject1 = paramList;
                  n = i;
                  if (j == 0) {
                    break;
                  }
                }
                else
                {
                  localObject3 = localObject2;
                  localObject4 = localObject5;
                  m = k;
                  n = i;
                  localObject1 = paramList;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramList = (List<ca>)localObject1;
      i = n;
      break label368;
      if (i < k)
      {
        paramList = ((String)localObject2).toLowerCase();
        i = k;
        break label458;
        label557:
        if (b((com.tencent.mm.be.e)localObject5))
        {
          j = 1;
          break label501;
        }
        j = n;
        if (m >= k) {
          break label501;
        }
        j = 1;
        break label501;
        localObject2 = localObject3;
        j = m;
        localObject1 = localObject4;
        if (i == -1) {
          break label309;
        }
        Log.d("MicroMsg.EggMgr", "rpt mp %s keyWord %s.", new Object[] { Integer.valueOf(i), paramList });
        localTreeMap.put(Integer.valueOf(i), paramList);
        localObject2 = localObject3;
        j = m;
        localObject1 = localObject4;
        break label309;
        localObject3 = localTreeMap.descendingKeySet();
        paramList = new StringBuilder();
        localObject3 = ((Set)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Integer)((Iterator)localObject3).next();
          localObject5 = (String)localTreeMap.get(localObject4);
          Log.d("MicroMsg.EggMgr", "key: [%s] value: [%s].", new Object[] { localObject4, localObject5 });
          paramList.append((String)localObject5).append("#");
        }
        if (!Util.isNullOrNil(paramList.toString()))
        {
          localObject3 = com.tencent.mm.plugin.eggspring.e.uxF;
          com.tencent.mm.plugin.eggspring.e.b(bool1, this.fTe, this.name, (String)localObject2);
          localObject3 = com.tencent.mm.plugin.eggspring.e.uxF;
          com.tencent.mm.plugin.eggspring.e.aO(1, paramList.toString());
        }
        if (b((com.tencent.mm.be.e)localObject1))
        {
          if (!bool1) {
            break label900;
          }
          com.tencent.mm.plugin.report.service.h.IzE.el(1263, 1);
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            if (this.WDd == null)
            {
              paramList = (ViewStub)paramActivity.findViewById(R.h.dZj);
              if (paramList != null) {
                paramList.inflate();
              }
              this.WDd = ((ChattingAnimFrame)paramActivity.findViewById(R.h.dvt));
              this.WDd.setOnLuckyBagClick(new ChattingAnimFrame.d()
              {
                public final void a(com.tencent.mm.plugin.eggspring.c.c paramAnonymousc, com.tencent.mm.be.e paramAnonymouse)
                {
                  AppMethodBeat.i(280984);
                  if (paramAnonymouse == null)
                  {
                    AppMethodBeat.o(280984);
                    return;
                  }
                  if (paramAnonymouse.type == 3)
                  {
                    if (paramAnonymousc == null)
                    {
                      AppMethodBeat.o(280984);
                      return;
                    }
                    Activity localActivity = paramActivity;
                    paramAnonymousc = SpringLuckyEggActivity.a(paramActivity, paramAnonymouse, paramAnonymousc.fwe, paramAnonymousc.appId, paramAnonymousc.nTp, bool2);
                    paramAnonymousc = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousc);
                    com.tencent.mm.hellhoundlib.a.a.b(localActivity, paramAnonymousc.aFh(), "com/tencent/mm/ui/chatting/EggMgr$1", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    localActivity.startActivity((Intent)paramAnonymousc.sf(0));
                    com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/ui/chatting/EggMgr$1", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(280984);
                    return;
                  }
                  if (paramAnonymouse.type == 2)
                  {
                    if ((paramAnonymouse.jHW == null) || (Util.isNullOrNil(paramAnonymouse.jHW.lXl)))
                    {
                      AppMethodBeat.o(280984);
                      return;
                    }
                    paramAnonymousc = paramAnonymouse.jHW.lXl;
                    paramAnonymouse = new Intent();
                    paramAnonymouse.putExtra("rawUrl", paramAnonymousc);
                    paramAnonymouse.putExtra("from_shortcut", true);
                    paramAnonymouse.putExtra("disable_minimize", true);
                    paramAnonymouse.putExtra("MMActivity.OverrideEnterAnimation", R.a.anim_not_change);
                    paramAnonymouse.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
                    com.tencent.mm.by.c.b(paramActivity, "webview", ".ui.tools.WebViewUI", paramAnonymouse, 3001);
                    paramActivity.overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
                    AppMethodBeat.o(280984);
                    return;
                  }
                  if (paramAnonymouse.type == 4)
                  {
                    if ((paramAnonymousc == null) || (Util.isNullOrNil(paramAnonymousc.url)))
                    {
                      AppMethodBeat.o(280984);
                      return;
                    }
                    paramAnonymousc = paramAnonymousc.url;
                    paramAnonymouse = new Intent();
                    paramAnonymouse.putExtra("rawUrl", paramAnonymousc);
                    paramAnonymouse.putExtra("MMActivity.OverrideEnterAnimation", R.a.anim_not_change);
                    paramAnonymouse.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
                    com.tencent.mm.by.c.b(paramActivity, "webview", ".ui.tools.WebViewUI", paramAnonymouse, 3001);
                    paramActivity.overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
                  }
                  AppMethodBeat.o(280984);
                }
              });
            }
            if (this.WDd == null)
            {
              Log.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
              i = 0;
              break;
              label900:
              com.tencent.mm.plugin.report.service.h.IzE.el(1263, 2);
              continue;
            }
            if (((((com.tencent.mm.be.e)localObject1).lXp <= i1) && (i1 <= ((com.tencent.mm.be.e)localObject1).lXq)) || ((((com.tencent.mm.be.e)localObject1).lXp == ((com.tencent.mm.be.e)localObject1).lXq) && (((com.tencent.mm.be.e)localObject1).lXp == 0)))
            {
              if (((com.tencent.mm.be.e)localObject1).jHW != null)
              {
                paramList = ((com.tencent.mm.be.e)localObject1).jHW.lXl;
                ((com.tencent.mm.plugin.eggspring.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.eggspring.a.a.class)).prefetch(paramList);
              }
              if (this.WDd.a((com.tencent.mm.be.e)localObject1))
              {
                if ((localObject1 != null) && (!Util.isNullOrNil((String)localObject2))) {
                  break label1099;
                }
                if (localObject1 == null) {
                  break label1093;
                }
                bool2 = true;
                label1019:
                Log.e("MicroMsg.EggMgr", "egg info or keyWord err!!! info != null:[%s].", new Object[] { Boolean.valueOf(bool2) });
              }
              for (;;)
              {
                bT(((com.tencent.mm.be.e)localObject1).fSe, bool1);
                Log.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[] { localObject2, Integer.valueOf(((com.tencent.mm.be.e)localObject1).lXp), Integer.valueOf(((com.tencent.mm.be.e)localObject1).lXq) });
                i = 1;
                break;
                label1093:
                bool2 = false;
                break label1019;
                label1099:
                if (b((com.tencent.mm.be.e)localObject1))
                {
                  paramList = com.tencent.mm.plugin.eggspring.e.uxF;
                  com.tencent.mm.plugin.eggspring.e.aO(2, com.tencent.mm.plugin.eggspring.e.lXu);
                  if (((com.tencent.mm.be.e)localObject1).type == 3)
                  {
                    if (this.WDe == null) {
                      this.WDe = new com.tencent.mm.plugin.eggspring.f();
                    }
                    this.WDe.uxG = new kotlin.g.a.b() {};
                    paramList = this.WDe;
                    localObject3 = ((com.tencent.mm.be.e)localObject1).jIS.appId;
                    p.k(localObject2, "keyword");
                    Log.i("MicroMsg.SpringLuckyEggHelper", "start check egg: appId=" + (String)localObject3 + ", keyword=" + (String)localObject2);
                    l1 = SystemClock.elapsedRealtime();
                    if ((paramList.lastCheckTime > 0L) && (paramList.interval > 0))
                    {
                      long l2 = l1 - paramList.lastCheckTime;
                      if (l2 < paramList.interval * 1000)
                      {
                        Log.w("MicroMsg.SpringLuckyEggHelper", "The check is too frequent, interval=" + paramList.interval + ", delta=" + l2);
                        continue;
                      }
                    }
                    paramList.lastCheckTime = l1;
                    localObject4 = paramList.uwI;
                    if (localObject4 != null) {
                      ((by)localObject4).a(null);
                    }
                    paramList.uwI = kotlinx.coroutines.g.b(paramList.rcY, null, (m)new f.b(paramList, (String)localObject2, (String)localObject3, null), 3);
                  }
                  else if (((com.tencent.mm.be.e)localObject1).type == 2)
                  {
                    Log.i("MicroMsg.EggMgr", "initLuckyBagOrNot: game lucky egg %s", new Object[] { ((com.tencent.mm.be.e)localObject1).jHW.appId });
                    if (this.WDd != null)
                    {
                      this.WDd.post(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(272719);
                          aa.a(aa.this).hMA();
                          aa.a(aa.this, this.WDl);
                          AppMethodBeat.o(272719);
                        }
                      });
                      com.tencent.mm.xwebutil.c.bCF("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
                    }
                  }
                  else if (((com.tencent.mm.be.e)localObject1).type == 4)
                  {
                    if (this.WDf == null) {
                      this.WDf = new com.tencent.mm.plugin.eggspring.c();
                    }
                    this.WDf.jHk = new m() {};
                    paramList = this.WDf;
                    Log.i(paramList.TAG, "checkShowEgg: ");
                    l1 = Util.currentTicks();
                    if (Util.ticksToNow(paramList.lastCheckTime) <= paramList.interval)
                    {
                      Log.w(paramList.TAG, "checkShowEgg: " + paramList.lastCheckTime + ", " + paramList.interval + ", " + l1);
                    }
                    else
                    {
                      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUM, 100);
                      localObject3 = kotlin.j.c.aaBL;
                      j = kotlin.j.c.iCt().Nz(100);
                      Log.i(paramList.TAG, "checkShowEgg: percent " + i + ", " + j);
                      if (j < i)
                      {
                        paramList.lastCheckTime = l1;
                        localObject3 = paramList.uwI;
                        if (localObject3 != null) {
                          ((by)localObject3).a(null);
                        }
                        paramList.uwI = kotlinx.coroutines.g.b(paramList.rcY, null, (m)new c.a(paramList, null), 3);
                      }
                    }
                  }
                }
              }
            }
            Log.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[] { localObject2, Integer.valueOf(((com.tencent.mm.be.e)localObject1).lXp), Integer.valueOf(((com.tencent.mm.be.e)localObject1).lXq) });
            i = 0;
            break;
          }
        }
        Log.d("MicroMsg.EggMgr", "no match");
        i = 0;
        break label209;
        label1746:
        break;
      }
      label1748:
      break label458;
      label1751:
      localObject1 = paramList;
      n = i;
    }
  }
  
  public final void hNs()
  {
    AppMethodBeat.i(275161);
    if (this.WDd != null) {
      this.WDd.stop();
    }
    Object localObject2;
    Object localObject3;
    StringBuilder localStringBuilder;
    if (this.WDe != null)
    {
      localObject2 = this.WDe;
      localObject3 = new StringBuilder("dispose: job is running: ");
      localObject1 = ((com.tencent.mm.plugin.eggspring.f)localObject2).uwI;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((by)localObject1).isActive());
        Log.i("MicroMsg.SpringLuckyEggHelper", localObject1);
        localObject1 = ((com.tencent.mm.plugin.eggspring.f)localObject2).uwI;
        if (localObject1 != null) {
          ((by)localObject1).a(null);
        }
        ((com.tencent.mm.plugin.eggspring.f)localObject2).uwI = null;
      }
    }
    else if (this.WDf != null)
    {
      localObject2 = this.WDf;
      localObject3 = ((com.tencent.mm.plugin.eggspring.c)localObject2).TAG;
      localStringBuilder = new StringBuilder("dispose: ");
      localObject1 = ((com.tencent.mm.plugin.eggspring.c)localObject2).uwI;
      if (localObject1 == null) {
        break label215;
      }
    }
    label215:
    for (Object localObject1 = Boolean.valueOf(((by)localObject1).isActive());; localObject1 = null)
    {
      Log.i((String)localObject3, localObject1);
      localObject1 = ((com.tencent.mm.plugin.eggspring.c)localObject2).uwI;
      if (localObject1 != null) {
        ((by)localObject1).a(null);
      }
      ((com.tencent.mm.plugin.eggspring.c)localObject2).uwI = null;
      ((com.tencent.mm.plugin.eggspring.c)localObject2).jHk = null;
      Log.i("MicroMsg.EggMgr", "egg has been stop, %s", new Object[] { this.WDd });
      AppMethodBeat.o(275161);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(275163);
    com.tencent.mm.kernel.h.aGY().b(2757, this);
    AppMethodBeat.o(275163);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(275162);
    com.tencent.mm.kernel.h.aGY().a(2757, this);
    AppMethodBeat.o(275162);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(34803);
    Log.i("MicroMsg.EggMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.plugin.report.service.h.IzE.el(1263, 4);
      AppMethodBeat.o(34803);
      return;
    }
    if (2757 == paramq.getType())
    {
      AppMethodBeat.o(34803);
      throw null;
    }
    AppMethodBeat.o(34803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aa
 * JD-Core Version:    0.7.0.1
 */