package com.tencent.mm.ui.chatting;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bc.e;
import com.tencent.mm.bc.j;
import com.tencent.mm.cg.f.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.eggspring.a.a;
import com.tencent.mm.plugin.eggspring.ui.SpringCardActivity;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public final class z
  implements com.tencent.mm.al.g
{
  public ChattingAnimFrame GpS;
  public Activity GpT;
  private long GpU;
  private boolean dwH;
  public ap mHandler;
  private String name;
  public List<bl> nrj;
  private long osg;
  
  public z()
  {
    AppMethodBeat.i(34793);
    this.GpS = null;
    this.mHandler = new z.1(this, Looper.getMainLooper());
    this.osg = 0L;
    this.GpU = 0L;
    AppMethodBeat.o(34793);
  }
  
  private void a(com.tencent.mm.bc.d paramd, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(34801);
    if ((paramd == null) || (ae.isNullOrNil(paramString)))
    {
      if (paramd != null) {}
      for (;;)
      {
        ad.e("MicroMsg.EggMgr", "egg info or keyWord err!!! info != null:[%s].", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(34801);
        return;
        bool = false;
      }
    }
    if (!b(paramd))
    {
      ad.d("MicroMsg.EggMgr", "no need lucky bag!!!");
      AppMethodBeat.o(34801);
      return;
    }
    a.a locala = com.tencent.mm.plugin.eggspring.a.orI;
    com.tencent.mm.plugin.eggspring.a.bTM().Ai(2);
    if (this.GpS != null)
    {
      this.GpS.eVg();
      if (eVZ())
      {
        paramd = new com.tencent.mm.plugin.eggspring.c.c(paramString, paramd.fNw.appId, this.osg);
        com.tencent.mm.kernel.g.aeS().a(paramd, 0);
      }
    }
    AppMethodBeat.o(34801);
  }
  
  private boolean a(final Activity paramActivity, bl parambl)
  {
    AppMethodBeat.i(34795);
    if ((this.GpS != null) && (!this.GpS.eVi()))
    {
      ad.i("MicroMsg.EggMgr", "LuckyBag, ad egg or lucky bag still exist, return.");
      AppMethodBeat.o(34795);
      return false;
    }
    Object localObject4 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUG();
    if (localObject4 == null)
    {
      ad.d("MicroMsg.EggMgr", "eggList is null");
      AppMethodBeat.o(34795);
      return false;
    }
    int i1 = (int)bt.aGK();
    ad.d("MicroMsg.EggMgr", "curSecond is %d, getEggList.size is %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(((com.tencent.mm.bc.f)localObject4).hph.size()) });
    Object localObject2 = parambl.field_content;
    Object localObject1 = localObject2;
    if (w.pF(parambl.field_talker)) {
      localObject1 = bi.ud((String)localObject2);
    }
    if (parambl.eMh())
    {
      localObject1 = k.b.ar((String)localObject1, parambl.field_reserved);
      if (localObject1 == null) {}
    }
    for (Object localObject3 = ((k.b)localObject1).title;; localObject3 = localObject1)
    {
      localObject2 = null;
      int j = -1;
      Object localObject6 = null;
      TreeMap localTreeMap = new TreeMap();
      Iterator localIterator1 = ((com.tencent.mm.bc.f)localObject4).hph.iterator();
      com.tencent.mm.bc.d locald;
      int i;
      Object localObject5;
      int m;
      label259:
      int k;
      label357:
      int n;
      while (localIterator1.hasNext())
      {
        locald = (com.tencent.mm.bc.d)localIterator1.next();
        if (aKB(locald.hpd))
        {
          i = -1;
          localObject1 = null;
          Iterator localIterator2 = locald.hoZ.iterator();
          localObject5 = localObject2;
          m = j;
          localObject4 = localObject6;
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              localObject2 = (e)localIterator2.next();
              localObject6 = ((e)localObject2).hpg;
              if (ae.isNullOrNil((String)localObject6))
              {
                ad.e("MicroMsg.EggMgr", "error egg keyWord");
                continue;
                AppMethodBeat.o(34795);
                return false;
              }
              else
              {
                k = aX((String)localObject3, (String)localObject6, ((e)localObject2).lang);
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
                    if (!b((com.tencent.mm.bc.d)localObject5)) {
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
          ad.d("MicroMsg.EggMgr", "rpt mp %s keyWord %s.", new Object[] { Integer.valueOf(i), localObject1 });
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
            ad.d("MicroMsg.EggMgr", "key: [%s] value: [%s].", new Object[] { localObject4, localObject5 });
            ((StringBuilder)localObject1).append((String)localObject5).append("#");
          }
          if (!ae.isNullOrNil(((StringBuilder)localObject1).toString()))
          {
            localObject3 = com.tencent.mm.plugin.eggspring.a.orI;
            com.tencent.mm.plugin.eggspring.a.bTM().a(parambl, this.dwH, this.name, (String)localObject6);
            localObject3 = com.tencent.mm.plugin.eggspring.a.orI;
            com.tencent.mm.plugin.eggspring.a.bTM().aG(1, ((StringBuilder)localObject1).toString());
          }
          if (b((com.tencent.mm.bc.d)localObject2))
          {
            if (parambl.field_isSend != 1) {
              break label820;
            }
            com.tencent.mm.plugin.report.service.h.vKh.dB(1263, 1);
          }
          while (localObject2 != null)
          {
            if (this.GpS == null)
            {
              localObject1 = (ViewStub)paramActivity.findViewById(2131306439);
              if (localObject1 != null) {
                ((ViewStub)localObject1).inflate();
              }
              this.GpS = ((ChattingAnimFrame)paramActivity.findViewById(2131297976));
              this.GpS.setOnLuckyBagClick(new ChattingAnimFrame.d()
              {
                public final void a(com.tencent.mm.plugin.eggspring.b.c paramAnonymousc, com.tencent.mm.bc.d paramAnonymousd)
                {
                  AppMethodBeat.i(160230);
                  Intent localIntent;
                  if ((paramAnonymousc != null) && (paramAnonymousc.orY))
                  {
                    localIntent = new Intent(paramActivity, SpringCardActivity.class);
                    localIntent.putExtra("SpringCard.KeyWord", paramAnonymousc.hpg);
                    localIntent.putExtra("SpringCard.AppId", paramAnonymousc.appId);
                    localIntent.putExtra("SpringCard.TraceId", paramAnonymousc.iYE);
                    if (paramAnonymousd != null) {
                      break label287;
                    }
                  }
                  label287:
                  for (paramAnonymousc = null;; paramAnonymousc = paramAnonymousd.fNw)
                  {
                    if (paramAnonymousc != null)
                    {
                      localIntent.putExtra("SpringCard.BtmMainTile", paramAnonymousc.hpl);
                      localIntent.putExtra("SpringCard.BtmMainTileColor", paramAnonymousc.hpm);
                      localIntent.putExtra("SpringCard.BtmSubTitle", paramAnonymousc.hpn);
                      localIntent.putExtra("SpringCard.BtmSubTitleColor", paramAnonymousc.hpo);
                      localIntent.putExtra("SpringCard.BrandIcon", paramAnonymousc.hpp);
                      localIntent.putExtra("SpringCard.BrandName", paramAnonymousc.dfM);
                      localIntent.putExtra("SpringCard.BrandBgColor", paramAnonymousc.hpq);
                      localIntent.putExtra("SpringCard.BrandBtmImg", paramAnonymousc.hpr);
                      localIntent.putExtra("SpringCard.BrandRedPocketCoverMainTitle", paramAnonymousc.hps);
                      localIntent.putExtra("SpringCard.BrandRedPocketCoverSubTitle", paramAnonymousc.hpt);
                      localIntent.putExtra("SpringCard.BrandCouponMainTitle", paramAnonymousc.hpu);
                      localIntent.putExtra("SpringCard.BrandCouponSubTitle", paramAnonymousc.hpv);
                    }
                    paramAnonymousc = paramActivity;
                    paramAnonymousd = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousc, paramAnonymousd.adn(), "com/tencent/mm/ui/chatting/EggMgr$2", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousc.startActivity((Intent)paramAnonymousd.lS(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousc, "com/tencent/mm/ui/chatting/EggMgr$2", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramActivity.overridePendingTransition(2130772108, 2130772048);
                    AppMethodBeat.o(160230);
                    return;
                  }
                }
              });
            }
            if (this.GpS == null)
            {
              ad.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
              AppMethodBeat.o(34795);
              return false;
              label820:
              com.tencent.mm.plugin.report.service.h.vKh.dB(1263, 2);
            }
            else
            {
              boolean bool;
              if ((((com.tencent.mm.bc.d)localObject2).hpb <= i1) && (i1 <= ((com.tencent.mm.bc.d)localObject2).hpc + 86400L))
              {
                if (this.GpS.a((com.tencent.mm.bc.d)localObject2)) {
                  a((com.tencent.mm.bc.d)localObject2, (String)localObject6);
                }
                i = ((com.tencent.mm.bc.d)localObject2).dvJ;
                if (parambl.field_isSend == 1) {}
                for (bool = true;; bool = false)
                {
                  aU(i, bool);
                  ad.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[] { localObject6, Integer.valueOf(((com.tencent.mm.bc.d)localObject2).hpb), Integer.valueOf(((com.tencent.mm.bc.d)localObject2).hpc) });
                  AppMethodBeat.o(34795);
                  return true;
                }
              }
              if ((((com.tencent.mm.bc.d)localObject2).hpb == ((com.tencent.mm.bc.d)localObject2).hpc) && (((com.tencent.mm.bc.d)localObject2).hpb == 0))
              {
                if (this.GpS.a((com.tencent.mm.bc.d)localObject2)) {
                  a((com.tencent.mm.bc.d)localObject2, (String)localObject6);
                }
                i = ((com.tencent.mm.bc.d)localObject2).dvJ;
                if (parambl.field_isSend == 1) {}
                for (bool = true;; bool = false)
                {
                  aU(i, bool);
                  ad.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", new Object[] { localObject6 });
                  AppMethodBeat.o(34795);
                  return true;
                }
              }
              ad.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[] { localObject6, Integer.valueOf(((com.tencent.mm.bc.d)localObject2).hpb), Integer.valueOf(((com.tencent.mm.bc.d)localObject2).hpc) });
              AppMethodBeat.o(34795);
              return false;
            }
          }
          ad.d("MicroMsg.EggMgr", "no match");
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
  
  private static boolean aKB(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(34797);
    boolean bool1;
    if (ae.isNullOrNil(paramString)) {
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
        if (paramString[i].equals(ac.eFu())) {
          break;
        }
        i += 1;
      }
      label67:
      bool1 = false;
    }
  }
  
  private static void aU(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34800);
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new StringBuilder();
        az.arV();
        localObject1 = i.aR(com.tencent.mm.model.c.aff() + "eggresult.rep", 0, -1);
        com.tencent.mm.bc.g localg;
        if (localObject1 != null)
        {
          ad.d("MicroMsg.EggMgr", "data not null, parse it");
          localObject1 = (com.tencent.mm.bc.h)new com.tencent.mm.bc.h().parseFrom((byte[])localObject1);
          localObject2 = ((com.tencent.mm.bc.h)localObject1).hpk.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label317;
          }
          localg = (com.tencent.mm.bc.g)((Iterator)localObject2).next();
          if (localg.dvJ != paramInt) {
            continue;
          }
          if (paramBoolean)
          {
            localg.hpi += 1;
            break label322;
            if (i == 0)
            {
              localObject2 = new com.tencent.mm.bc.g();
              ((com.tencent.mm.bc.g)localObject2).dvJ = paramInt;
              if (!paramBoolean) {
                break label308;
              }
              ((com.tencent.mm.bc.g)localObject2).hpi = 1;
              ((com.tencent.mm.bc.h)localObject1).hpk.add(localObject2);
            }
            localObject2 = ((com.tencent.mm.bc.h)localObject1).toByteArray();
            ad.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[] { localObject1.toString() });
            localObject1 = new StringBuilder();
            az.arV();
            i.f(com.tencent.mm.model.c.aff() + "eggresult.rep", (byte[])localObject2, localObject2.length);
            AppMethodBeat.o(34800);
          }
        }
        else
        {
          ad.d("MicroMsg.EggMgr", "data is null, new one");
          localObject1 = new com.tencent.mm.bc.h();
          continue;
        }
        localg.hpj += 1;
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[] { localException.getLocalizedMessage() });
        ad.printErrStackTrace("MicroMsg.EggMgr", localException, "", new Object[0]);
        AppMethodBeat.o(34800);
        return;
      }
      label308:
      ((com.tencent.mm.bc.g)localObject2).hpj = 1;
      continue;
      label317:
      int i = 0;
      continue;
      label322:
      i = 1;
    }
  }
  
  private static int aX(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(34798);
    if ((ae.isNullOrNil(paramString1)) || (ae.isNullOrNil(paramString2)) || (aj.getContext() == null))
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
          if ((k >= str.length() - 1) || (ae.isNullOrNil(paramString3))) {
            continue;
          }
          if ((k <= 0) || (str.charAt(k - 1) < 'a') || (str.charAt(k - 1) > 'z')) {
            continue;
          }
          ad.v("MicroMsg.EggMgr", "letter in the prefix");
          localObject = paramString1.substring(0, k);
          j = ((String)localObject).lastIndexOf('/');
          i = j;
          if (j == -1) {
            continue;
          }
          localObject = ((String)localObject).subSequence(j, ((String)localObject).length());
          com.tencent.mm.cg.g.eIa();
          aj.getContext();
          localObject = com.tencent.mm.cg.f.eHV().aGQ((String)localObject);
          if (localObject == null) {
            continue;
          }
          localObject = ((f.a)localObject).text;
          i = j;
          if (ae.isNullOrNil((String)localObject)) {
            continue;
          }
          i = j;
          if (((String)localObject).length() + j != k) {
            continue;
          }
          ad.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
          i = -2;
        }
        catch (Exception paramString1)
        {
          Object localObject;
          int m;
          ad.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", new Object[] { paramString1.getMessage() });
          ad.printErrStackTrace("MicroMsg.EggMgr", paramString1, "", new Object[0]);
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
                ad.v("MicroMsg.EggMgr", "letter in the suffix");
                j = 0;
              }
            }
          }
        }
        if (j == 0) {
          continue;
        }
        ad.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", new Object[] { Integer.valueOf(k), Integer.valueOf(str.length()), Integer.valueOf(paramString2.length()) });
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
  
  static boolean b(com.tencent.mm.bc.d paramd)
  {
    if (paramd != null) {
      return 1 == paramd.type;
    }
    return false;
  }
  
  private void eVY()
  {
    AppMethodBeat.i(34799);
    az.arV();
    if (ae.lZ(ae.c((Long)com.tencent.mm.model.c.afk().get(68108, null))) * 1000L > 21600000L) {
      new ap().postDelayed(new z.3(this), 10000L);
    }
    AppMethodBeat.o(34799);
  }
  
  private boolean eVZ()
  {
    AppMethodBeat.i(34802);
    if (1 == ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pwf, 0))
    {
      ad.i("MicroMsg.EggMgr", "forceTag enable.");
      this.GpU = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pwe, 20000);
    }
    long l = ce.asQ();
    ad.i("MicroMsg.EggMgr", "nowMs: [%s] ticket: [%s] interval: [%s].", new Object[] { Long.valueOf(l), Long.valueOf(this.osg), Long.valueOf(this.GpU) });
    if (l - this.osg > this.GpU)
    {
      this.GpU = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pwe, 20000);
      this.osg = l;
      AppMethodBeat.o(34802);
      return true;
    }
    AppMethodBeat.o(34802);
    return false;
  }
  
  public final void G(boolean paramBoolean, String paramString)
  {
    this.dwH = paramBoolean;
    this.name = paramString;
  }
  
  public final void a(Activity paramActivity, List<bl> paramList)
  {
    AppMethodBeat.i(34794);
    if (paramList == null)
    {
      AppMethodBeat.o(34794);
      return;
    }
    eVY();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a(paramActivity, (bl)paramList.next()))
      {
        AppMethodBeat.o(34794);
        return;
      }
    }
    AppMethodBeat.o(34794);
  }
  
  public final void cIO()
  {
    AppMethodBeat.i(34796);
    com.tencent.mm.kernel.g.aeS().b(2757, this);
    AppMethodBeat.o(34796);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(34803);
    ad.i("MicroMsg.EggMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.plugin.report.service.h.vKh.dB(1263, 4);
      AppMethodBeat.o(34803);
      return;
    }
    if (2757 == paramn.getType())
    {
      paramString = (com.tencent.mm.plugin.eggspring.c.c)paramn;
      if (paramString.osg == this.osg)
      {
        paramString = paramString.osf;
        if (paramString != null)
        {
          ad.i("MicroMsg.EggMgr", "luckyBagInfo, %s.", new Object[] { paramString.toString() });
          if ((paramString.orY) && (this.GpS != null) && (paramString != null) && (paramString.orY))
          {
            paramn = this.GpS;
            paramInt1 = i;
            if (paramn.Gme != null)
            {
              paramInt1 = i;
              if (1 == paramn.Gme.type)
              {
                paramInt1 = i;
                if (paramn.fnF > 0) {
                  paramInt1 = 1;
                }
              }
            }
            if (paramInt1 != 0)
            {
              paramn = this.GpS;
              if ((paramString != null) && (paramn.GlU != null) && (paramn.Gma != null) && (paramn.Gmb != null) && (!paramn.orY))
              {
                a.a locala = com.tencent.mm.plugin.eggspring.a.orI;
                com.tencent.mm.plugin.eggspring.a.bTM().Ai(3);
                paramn.orY = true;
                paramn.osf = paramString;
                paramn.addView(paramn.GlU);
                ad.d("MicroMsg.ChattingAnimFrame", "lucky bag start anim!!!");
                paramn.Gma.start();
                paramn.Gmb.start();
                paramn.GlU.start();
              }
            }
          }
          this.GpU = (paramString.fWw * 1000);
        }
      }
    }
    AppMethodBeat.o(34803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z
 * JD-Core Version:    0.7.0.1
 */