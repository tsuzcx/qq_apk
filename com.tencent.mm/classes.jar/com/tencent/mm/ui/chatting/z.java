package com.tencent.mm.ui.chatting;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.j;
import com.tencent.mm.cf.f.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.eggspring.a.a;
import com.tencent.mm.plugin.eggspring.ui.SpringCardActivity;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public final class z
  implements com.tencent.mm.ak.g
{
  public ChattingAnimFrame HPK;
  public Activity HPL;
  private long HPM;
  private boolean duu;
  public ao mHandler;
  public List<bo> nUj;
  private String name;
  private long oVG;
  
  public z()
  {
    AppMethodBeat.i(34793);
    this.HPK = null;
    this.mHandler = new z.1(this, Looper.getMainLooper());
    this.oVG = 0L;
    this.HPM = 0L;
    AppMethodBeat.o(34793);
  }
  
  private void a(com.tencent.mm.bb.d paramd, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(34801);
    if ((paramd == null) || (com.tencent.mm.platformtools.ae.isNullOrNil(paramString)))
    {
      if (paramd != null) {}
      for (;;)
      {
        ac.e("MicroMsg.EggMgr", "egg info or keyWord err!!! info != null:[%s].", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(34801);
        return;
        bool = false;
      }
    }
    if (!b(paramd))
    {
      ac.d("MicroMsg.EggMgr", "no need lucky bag!!!");
      AppMethodBeat.o(34801);
      return;
    }
    a.a locala = com.tencent.mm.plugin.eggspring.a.oVi;
    com.tencent.mm.plugin.eggspring.a.cba().Ba(2);
    if (this.HPK != null)
    {
      this.HPK.fkS();
      if (flL())
      {
        paramd = new com.tencent.mm.plugin.eggspring.c.c(paramString, paramd.fRh.appId, this.oVG);
        com.tencent.mm.kernel.g.agi().a(paramd, 0);
      }
    }
    AppMethodBeat.o(34801);
  }
  
  private boolean a(final Activity paramActivity, bo parambo)
  {
    AppMethodBeat.i(34795);
    if ((this.HPK != null) && (!this.HPK.fkU()))
    {
      ac.i("MicroMsg.EggMgr", "LuckyBag, ad egg or lucky bag still exist, return.");
      AppMethodBeat.o(34795);
      return false;
    }
    Object localObject4 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbT();
    if (localObject4 == null)
    {
      ac.d("MicroMsg.EggMgr", "eggList is null");
      AppMethodBeat.o(34795);
      return false;
    }
    int i1 = (int)bs.aNx();
    ac.d("MicroMsg.EggMgr", "curSecond is %d, getEggList.size is %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(((com.tencent.mm.bb.f)localObject4).hPJ.size()) });
    Object localObject2 = parambo.field_content;
    Object localObject1 = localObject2;
    if (w.sQ(parambo.field_talker)) {
      localObject1 = bi.yj((String)localObject2);
    }
    if (parambo.fbM())
    {
      localObject1 = k.b.az((String)localObject1, parambo.field_reserved);
      if (localObject1 == null) {}
    }
    for (Object localObject3 = ((k.b)localObject1).title;; localObject3 = localObject1)
    {
      localObject2 = null;
      int j = -1;
      Object localObject6 = null;
      TreeMap localTreeMap = new TreeMap();
      Iterator localIterator1 = ((com.tencent.mm.bb.f)localObject4).hPJ.iterator();
      com.tencent.mm.bb.d locald;
      int i;
      Object localObject5;
      int m;
      label259:
      int k;
      label357:
      int n;
      while (localIterator1.hasNext())
      {
        locald = (com.tencent.mm.bb.d)localIterator1.next();
        if (aQe(locald.hPF))
        {
          i = -1;
          localObject1 = null;
          Iterator localIterator2 = locald.hPB.iterator();
          localObject5 = localObject2;
          m = j;
          localObject4 = localObject6;
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              localObject2 = (e)localIterator2.next();
              localObject6 = ((e)localObject2).hPI;
              if (com.tencent.mm.platformtools.ae.isNullOrNil((String)localObject6))
              {
                ac.e("MicroMsg.EggMgr", "error egg keyWord");
                continue;
                AppMethodBeat.o(34795);
                return false;
              }
              else
              {
                k = ba((String)localObject3, (String)localObject6, ((e)localObject2).lang);
                if (k == -1) {
                  break label1113;
                }
                if (!b(locald)) {
                  break label1110;
                }
                if (-1 == i)
                {
                  localObject1 = ((String)localObject6).toLowerCase();
                  i = k;
                  n = 0;
                  if (m != -1)
                  {
                    if (!b((com.tencent.mm.bb.d)localObject5)) {
                      break label460;
                    }
                    j = n;
                    if (b(locald))
                    {
                      j = n;
                      if (m < k) {
                        j = 1;
                      }
                    }
                    label400:
                    localObject2 = localObject1;
                    n = i;
                    if (j == 0) {
                      break;
                    }
                  }
                  else
                  {
                    localObject4 = localObject6;
                    localObject5 = locald;
                    m = k;
                    n = i;
                    localObject2 = localObject1;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        i = n;
        break label259;
        if (i < k)
        {
          localObject1 = ((String)localObject6).toLowerCase();
          i = k;
          break label357;
          label460:
          if (b(locald))
          {
            j = 1;
            break label400;
          }
          j = n;
          if (m >= k) {
            break label400;
          }
          j = 1;
          break label400;
          localObject6 = localObject4;
          j = m;
          localObject2 = localObject5;
          if (i == -1) {
            break;
          }
          ac.d("MicroMsg.EggMgr", "rpt mp %s keyWord %s.", new Object[] { Integer.valueOf(i), localObject1 });
          localTreeMap.put(Integer.valueOf(i), localObject1);
          localObject6 = localObject4;
          j = m;
          localObject2 = localObject5;
          break;
          localObject3 = localTreeMap.descendingKeySet();
          localObject1 = new StringBuilder();
          localObject3 = ((Set)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Integer)((Iterator)localObject3).next();
            localObject5 = (String)localTreeMap.get(localObject4);
            ac.d("MicroMsg.EggMgr", "key: [%s] value: [%s].", new Object[] { localObject4, localObject5 });
            ((StringBuilder)localObject1).append((String)localObject5).append("#");
          }
          if (!com.tencent.mm.platformtools.ae.isNullOrNil(((StringBuilder)localObject1).toString()))
          {
            localObject3 = com.tencent.mm.plugin.eggspring.a.oVi;
            com.tencent.mm.plugin.eggspring.a.cba().a(parambo, this.duu, this.name, (String)localObject6);
            localObject3 = com.tencent.mm.plugin.eggspring.a.oVi;
            com.tencent.mm.plugin.eggspring.a.cba().aI(1, ((StringBuilder)localObject1).toString());
          }
          if (b((com.tencent.mm.bb.d)localObject2))
          {
            if (parambo.field_isSend != 1) {
              break label820;
            }
            com.tencent.mm.plugin.report.service.h.wUl.dB(1263, 1);
          }
          while (localObject2 != null)
          {
            if (this.HPK == null)
            {
              localObject1 = (ViewStub)paramActivity.findViewById(2131306439);
              if (localObject1 != null) {
                ((ViewStub)localObject1).inflate();
              }
              this.HPK = ((ChattingAnimFrame)paramActivity.findViewById(2131297976));
              this.HPK.setOnLuckyBagClick(new ChattingAnimFrame.d()
              {
                public final void a(com.tencent.mm.plugin.eggspring.b.c paramAnonymousc, com.tencent.mm.bb.d paramAnonymousd)
                {
                  AppMethodBeat.i(160230);
                  Intent localIntent;
                  if ((paramAnonymousc != null) && (paramAnonymousc.oVy))
                  {
                    localIntent = new Intent(paramActivity, SpringCardActivity.class);
                    localIntent.putExtra("SpringCard.KeyWord", paramAnonymousc.hPI);
                    localIntent.putExtra("SpringCard.AppId", paramAnonymousc.appId);
                    localIntent.putExtra("SpringCard.TraceId", paramAnonymousc.jyU);
                    if (paramAnonymousd != null) {
                      break label287;
                    }
                  }
                  label287:
                  for (paramAnonymousc = null;; paramAnonymousc = paramAnonymousd.fRh)
                  {
                    if (paramAnonymousc != null)
                    {
                      localIntent.putExtra("SpringCard.BtmMainTile", paramAnonymousc.hPN);
                      localIntent.putExtra("SpringCard.BtmMainTileColor", paramAnonymousc.hPO);
                      localIntent.putExtra("SpringCard.BtmSubTitle", paramAnonymousc.hPP);
                      localIntent.putExtra("SpringCard.BtmSubTitleColor", paramAnonymousc.hPQ);
                      localIntent.putExtra("SpringCard.BrandIcon", paramAnonymousc.hPR);
                      localIntent.putExtra("SpringCard.BrandName", paramAnonymousc.ddh);
                      localIntent.putExtra("SpringCard.BrandBgColor", paramAnonymousc.hPS);
                      localIntent.putExtra("SpringCard.BrandBtmImg", paramAnonymousc.hPT);
                      localIntent.putExtra("SpringCard.BrandRedPocketCoverMainTitle", paramAnonymousc.hPU);
                      localIntent.putExtra("SpringCard.BrandRedPocketCoverSubTitle", paramAnonymousc.hPV);
                      localIntent.putExtra("SpringCard.BrandCouponMainTitle", paramAnonymousc.hPW);
                      localIntent.putExtra("SpringCard.BrandCouponSubTitle", paramAnonymousc.hPX);
                    }
                    paramAnonymousc = paramActivity;
                    paramAnonymousd = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousc, paramAnonymousd.aeD(), "com/tencent/mm/ui/chatting/EggMgr$2", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousc.startActivity((Intent)paramAnonymousd.lR(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousc, "com/tencent/mm/ui/chatting/EggMgr$2", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramActivity.overridePendingTransition(2130772108, 2130772048);
                    AppMethodBeat.o(160230);
                    return;
                  }
                }
              });
            }
            if (this.HPK == null)
            {
              ac.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
              AppMethodBeat.o(34795);
              return false;
              label820:
              com.tencent.mm.plugin.report.service.h.wUl.dB(1263, 2);
            }
            else
            {
              boolean bool;
              if ((((com.tencent.mm.bb.d)localObject2).hPD <= i1) && (i1 <= ((com.tencent.mm.bb.d)localObject2).hPE + 86400L))
              {
                if (this.HPK.a((com.tencent.mm.bb.d)localObject2)) {
                  a((com.tencent.mm.bb.d)localObject2, (String)localObject6);
                }
                i = ((com.tencent.mm.bb.d)localObject2).dtw;
                if (parambo.field_isSend == 1) {}
                for (bool = true;; bool = false)
                {
                  aY(i, bool);
                  ac.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[] { localObject6, Integer.valueOf(((com.tencent.mm.bb.d)localObject2).hPD), Integer.valueOf(((com.tencent.mm.bb.d)localObject2).hPE) });
                  AppMethodBeat.o(34795);
                  return true;
                }
              }
              if ((((com.tencent.mm.bb.d)localObject2).hPD == ((com.tencent.mm.bb.d)localObject2).hPE) && (((com.tencent.mm.bb.d)localObject2).hPD == 0))
              {
                if (this.HPK.a((com.tencent.mm.bb.d)localObject2)) {
                  a((com.tencent.mm.bb.d)localObject2, (String)localObject6);
                }
                i = ((com.tencent.mm.bb.d)localObject2).dtw;
                if (parambo.field_isSend == 1) {}
                for (bool = true;; bool = false)
                {
                  aY(i, bool);
                  ac.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", new Object[] { localObject6 });
                  AppMethodBeat.o(34795);
                  return true;
                }
              }
              ac.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[] { localObject6, Integer.valueOf(((com.tencent.mm.bb.d)localObject2).hPD), Integer.valueOf(((com.tencent.mm.bb.d)localObject2).hPE) });
              AppMethodBeat.o(34795);
              return false;
            }
          }
          ac.d("MicroMsg.EggMgr", "no match");
          AppMethodBeat.o(34795);
          return false;
        }
        label1110:
        break label357;
        label1113:
        localObject2 = localObject1;
        n = i;
      }
    }
  }
  
  private static boolean aQe(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(34797);
    boolean bool1;
    if (com.tencent.mm.platformtools.ae.isNullOrNil(paramString)) {
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
        if (paramString[i].equals(ab.eUO())) {
          break;
        }
        i += 1;
      }
      label67:
      bool1 = false;
    }
  }
  
  private static void aY(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34800);
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new StringBuilder();
        az.ayM();
        localObject1 = i.aU(com.tencent.mm.model.c.agv() + "eggresult.rep", 0, -1);
        com.tencent.mm.bb.g localg;
        if (localObject1 != null)
        {
          ac.d("MicroMsg.EggMgr", "data not null, parse it");
          localObject1 = (com.tencent.mm.bb.h)new com.tencent.mm.bb.h().parseFrom((byte[])localObject1);
          localObject2 = ((com.tencent.mm.bb.h)localObject1).hPM.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label317;
          }
          localg = (com.tencent.mm.bb.g)((Iterator)localObject2).next();
          if (localg.dtw != paramInt) {
            continue;
          }
          if (paramBoolean)
          {
            localg.hPK += 1;
            break label322;
            if (i == 0)
            {
              localObject2 = new com.tencent.mm.bb.g();
              ((com.tencent.mm.bb.g)localObject2).dtw = paramInt;
              if (!paramBoolean) {
                break label308;
              }
              ((com.tencent.mm.bb.g)localObject2).hPK = 1;
              ((com.tencent.mm.bb.h)localObject1).hPM.add(localObject2);
            }
            localObject2 = ((com.tencent.mm.bb.h)localObject1).toByteArray();
            ac.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[] { localObject1.toString() });
            localObject1 = new StringBuilder();
            az.ayM();
            i.f(com.tencent.mm.model.c.agv() + "eggresult.rep", (byte[])localObject2, localObject2.length);
            AppMethodBeat.o(34800);
          }
        }
        else
        {
          ac.d("MicroMsg.EggMgr", "data is null, new one");
          localObject1 = new com.tencent.mm.bb.h();
          continue;
        }
        localg.hPL += 1;
      }
      catch (Exception localException)
      {
        ac.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[] { localException.getLocalizedMessage() });
        ac.printErrStackTrace("MicroMsg.EggMgr", localException, "", new Object[0]);
        AppMethodBeat.o(34800);
        return;
      }
      label308:
      ((com.tencent.mm.bb.g)localObject2).hPL = 1;
      continue;
      label317:
      int i = 0;
      continue;
      label322:
      i = 1;
    }
  }
  
  static boolean b(com.tencent.mm.bb.d paramd)
  {
    if (paramd != null) {
      return 1 == paramd.type;
    }
    return false;
  }
  
  private static int ba(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(34798);
    if ((com.tencent.mm.platformtools.ae.isNullOrNil(paramString1)) || (com.tencent.mm.platformtools.ae.isNullOrNil(paramString2)) || (ai.getContext() == null))
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
          if ((k >= str.length() - 1) || (com.tencent.mm.platformtools.ae.isNullOrNil(paramString3))) {
            continue;
          }
          if ((k <= 0) || (str.charAt(k - 1) < 'a') || (str.charAt(k - 1) > 'z')) {
            continue;
          }
          ac.v("MicroMsg.EggMgr", "letter in the prefix");
          localObject = paramString1.substring(0, k);
          j = ((String)localObject).lastIndexOf('/');
          i = j;
          if (j == -1) {
            continue;
          }
          localObject = ((String)localObject).subSequence(j, ((String)localObject).length());
          com.tencent.mm.cf.g.eXw();
          ai.getContext();
          localObject = com.tencent.mm.cf.f.eXr().aMi((String)localObject);
          if (localObject == null) {
            continue;
          }
          localObject = ((f.a)localObject).text;
          i = j;
          if (com.tencent.mm.platformtools.ae.isNullOrNil((String)localObject)) {
            continue;
          }
          i = j;
          if (((String)localObject).length() + j != k) {
            continue;
          }
          ac.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
          i = -2;
        }
        catch (Exception paramString1)
        {
          Object localObject;
          int m;
          ac.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", new Object[] { paramString1.getMessage() });
          ac.printErrStackTrace("MicroMsg.EggMgr", paramString1, "", new Object[0]);
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
                ac.v("MicroMsg.EggMgr", "letter in the suffix");
                j = 0;
              }
            }
          }
        }
        if (j == 0) {
          continue;
        }
        ac.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", new Object[] { Integer.valueOf(k), Integer.valueOf(str.length()), Integer.valueOf(paramString2.length()) });
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
  
  private void flK()
  {
    AppMethodBeat.i(34799);
    az.ayM();
    if (com.tencent.mm.platformtools.ae.pN(com.tencent.mm.platformtools.ae.d((Long)com.tencent.mm.model.c.agA().get(68108, null))) * 1000L > 21600000L) {
      new ao().postDelayed(new z.3(this), 10000L);
    }
    AppMethodBeat.o(34799);
  }
  
  private boolean flL()
  {
    AppMethodBeat.i(34802);
    if (1 == ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qat, 0))
    {
      ac.i("MicroMsg.EggMgr", "forceTag enable.");
      this.HPM = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qas, 20000);
    }
    long l = ce.azH();
    ac.i("MicroMsg.EggMgr", "nowMs: [%s] ticket: [%s] interval: [%s].", new Object[] { Long.valueOf(l), Long.valueOf(this.oVG), Long.valueOf(this.HPM) });
    if (l - this.oVG > this.HPM)
    {
      this.HPM = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qas, 20000);
      this.oVG = l;
      AppMethodBeat.o(34802);
      return true;
    }
    AppMethodBeat.o(34802);
    return false;
  }
  
  public final void H(boolean paramBoolean, String paramString)
  {
    this.duu = paramBoolean;
    this.name = paramString;
  }
  
  public final void a(Activity paramActivity, List<bo> paramList)
  {
    AppMethodBeat.i(34794);
    if (paramList == null)
    {
      AppMethodBeat.o(34794);
      return;
    }
    flK();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a(paramActivity, (bo)paramList.next()))
      {
        AppMethodBeat.o(34794);
        return;
      }
    }
    AppMethodBeat.o(34794);
  }
  
  public final void cVZ()
  {
    AppMethodBeat.i(34796);
    com.tencent.mm.kernel.g.agi().b(2757, this);
    AppMethodBeat.o(34796);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(34803);
    ac.i("MicroMsg.EggMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.plugin.report.service.h.wUl.dB(1263, 4);
      AppMethodBeat.o(34803);
      return;
    }
    if (2757 == paramn.getType())
    {
      paramString = (com.tencent.mm.plugin.eggspring.c.c)paramn;
      if (paramString.oVG == this.oVG)
      {
        paramString = paramString.oVF;
        if (paramString != null)
        {
          ac.i("MicroMsg.EggMgr", "luckyBagInfo, %s.", new Object[] { paramString.toString() });
          if ((paramString.oVy) && (this.HPK != null) && (paramString != null) && (paramString.oVy))
          {
            paramn = this.HPK;
            paramInt1 = i;
            if (paramn.HLU != null)
            {
              paramInt1 = i;
              if (1 == paramn.HLU.type)
              {
                paramInt1 = i;
                if (paramn.fqZ > 0) {
                  paramInt1 = 1;
                }
              }
            }
            if (paramInt1 != 0)
            {
              paramn = this.HPK;
              if ((paramString != null) && (paramn.HLJ != null) && (paramn.HLP != null) && (paramn.HLQ != null) && (!paramn.oVy))
              {
                a.a locala = com.tencent.mm.plugin.eggspring.a.oVi;
                com.tencent.mm.plugin.eggspring.a.cba().Ba(3);
                paramn.oVy = true;
                paramn.oVF = paramString;
                paramn.addView(paramn.HLJ);
                ac.d("MicroMsg.ChattingAnimFrame", "lucky bag start anim!!!");
                paramn.HLP.start();
                paramn.HLQ.start();
                paramn.HLJ.start();
              }
            }
          }
          this.HPM = (paramString.gbd * 1000);
        }
      }
    }
    AppMethodBeat.o(34803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z
 * JD-Core Version:    0.7.0.1
 */