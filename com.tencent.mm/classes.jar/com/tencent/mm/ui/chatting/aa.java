package com.tencent.mm.ui.chatting;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.h;
import com.tencent.mm.bb.j;
import com.tencent.mm.ce.f.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.eggspring.a.a;
import com.tencent.mm.plugin.eggspring.ui.SpringCardActivity;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.j.a.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public final class aa
  implements com.tencent.mm.ak.f
{
  public ChattingAnimFrame JYq;
  public Activity JYr;
  private long JYs;
  private boolean dHA;
  public aq mHandler;
  private String name;
  public List<bv> oEg;
  private long pFU;
  
  public aa()
  {
    AppMethodBeat.i(34793);
    this.JYq = null;
    this.mHandler = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34790);
        if ((aa.this.oEg == null) || (!bc.ajM()))
        {
          AppMethodBeat.o(34790);
          return;
        }
        ae.d("MicroMsg.EggMgr", "post start egg");
        aa.this.a(aa.this.JYr, aa.this.oEg);
        AppMethodBeat.o(34790);
      }
    };
    this.pFU = 0L;
    this.JYs = 0L;
    AppMethodBeat.o(34793);
  }
  
  private void a(com.tencent.mm.bb.d paramd, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(34801);
    if ((paramd == null) || (af.isNullOrNil(paramString)))
    {
      if (paramd != null) {}
      for (;;)
      {
        ae.e("MicroMsg.EggMgr", "egg info or keyWord err!!! info != null:[%s].", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(34801);
        return;
        bool = false;
      }
    }
    if (!b(paramd))
    {
      ae.d("MicroMsg.EggMgr", "no need lucky bag!!!");
      AppMethodBeat.o(34801);
      return;
    }
    a.a locala = com.tencent.mm.plugin.eggspring.a.pFw;
    com.tencent.mm.plugin.eggspring.a.cgU().BU(2);
    if (this.JYq != null)
    {
      this.JYq.fFj();
      if (fGe())
      {
        paramd = new com.tencent.mm.plugin.eggspring.c.c(paramString, paramd.gnb.appId, this.pFU);
        com.tencent.mm.kernel.g.ajj().a(paramd, 0);
      }
    }
    AppMethodBeat.o(34801);
  }
  
  private boolean a(final Activity paramActivity, bv parambv)
  {
    AppMethodBeat.i(34795);
    if ((this.JYq != null) && (!this.JYq.fFl()))
    {
      ae.i("MicroMsg.EggMgr", "LuckyBag, ad egg or lucky bag still exist, return.");
      AppMethodBeat.o(34795);
      return false;
    }
    Object localObject4 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().chN();
    if (localObject4 == null)
    {
      ae.d("MicroMsg.EggMgr", "eggList is null");
      AppMethodBeat.o(34795);
      return false;
    }
    int i1 = (int)bu.aRi();
    ae.d("MicroMsg.EggMgr", "curSecond is %d, getEggList.size is %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(((com.tencent.mm.bb.f)localObject4).ilQ.size()) });
    Object localObject2 = parambv.field_content;
    Object localObject1 = localObject2;
    if (x.wb(parambv.field_talker)) {
      localObject1 = bl.BK((String)localObject2);
    }
    if (parambv.fvQ())
    {
      localObject1 = k.b.aB((String)localObject1, parambv.field_reserved);
      if (localObject1 == null) {}
    }
    for (Object localObject3 = ((k.b)localObject1).title;; localObject3 = localObject1)
    {
      localObject2 = null;
      int j = -1;
      Object localObject6 = null;
      TreeMap localTreeMap = new TreeMap();
      Iterator localIterator1 = ((com.tencent.mm.bb.f)localObject4).ilQ.iterator();
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
        if (aXv(locald.ilM))
        {
          i = -1;
          localObject1 = null;
          Iterator localIterator2 = locald.ilI.iterator();
          localObject5 = localObject2;
          m = j;
          localObject4 = localObject6;
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              localObject2 = (e)localIterator2.next();
              localObject6 = ((e)localObject2).ilP;
              if (af.isNullOrNil((String)localObject6))
              {
                ae.e("MicroMsg.EggMgr", "error egg keyWord");
                continue;
                AppMethodBeat.o(34795);
                return false;
              }
              else
              {
                k = bk((String)localObject3, (String)localObject6, ((e)localObject2).lang);
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
          ae.d("MicroMsg.EggMgr", "rpt mp %s keyWord %s.", new Object[] { Integer.valueOf(i), localObject1 });
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
            ae.d("MicroMsg.EggMgr", "key: [%s] value: [%s].", new Object[] { localObject4, localObject5 });
            ((StringBuilder)localObject1).append((String)localObject5).append("#");
          }
          if (!af.isNullOrNil(((StringBuilder)localObject1).toString()))
          {
            localObject3 = com.tencent.mm.plugin.eggspring.a.pFw;
            com.tencent.mm.plugin.eggspring.a.cgU().a(parambv, this.dHA, this.name, (String)localObject6);
            localObject3 = com.tencent.mm.plugin.eggspring.a.pFw;
            com.tencent.mm.plugin.eggspring.a.cgU().aK(1, ((StringBuilder)localObject1).toString());
          }
          if (b((com.tencent.mm.bb.d)localObject2))
          {
            if (parambv.field_isSend != 1) {
              break label820;
            }
            com.tencent.mm.plugin.report.service.g.yxI.dD(1263, 1);
          }
          while (localObject2 != null)
          {
            if (this.JYq == null)
            {
              localObject1 = (ViewStub)paramActivity.findViewById(2131306439);
              if (localObject1 != null) {
                ((ViewStub)localObject1).inflate();
              }
              this.JYq = ((ChattingAnimFrame)paramActivity.findViewById(2131297976));
              this.JYq.setOnLuckyBagClick(new ChattingAnimFrame.d()
              {
                public final void a(com.tencent.mm.plugin.eggspring.b.c paramAnonymousc, com.tencent.mm.bb.d paramAnonymousd)
                {
                  AppMethodBeat.i(160230);
                  Intent localIntent;
                  if ((paramAnonymousc != null) && (paramAnonymousc.pFM))
                  {
                    localIntent = new Intent(paramActivity, SpringCardActivity.class);
                    localIntent.putExtra("SpringCard.KeyWord", paramAnonymousc.ilP);
                    localIntent.putExtra("SpringCard.AppId", paramAnonymousc.appId);
                    localIntent.putExtra("SpringCard.TraceId", paramAnonymousc.jWi);
                    if (paramAnonymousd != null) {
                      break label287;
                    }
                  }
                  label287:
                  for (paramAnonymousc = null;; paramAnonymousc = paramAnonymousd.gnb)
                  {
                    if (paramAnonymousc != null)
                    {
                      localIntent.putExtra("SpringCard.BtmMainTile", paramAnonymousc.ilU);
                      localIntent.putExtra("SpringCard.BtmMainTileColor", paramAnonymousc.ilV);
                      localIntent.putExtra("SpringCard.BtmSubTitle", paramAnonymousc.ilW);
                      localIntent.putExtra("SpringCard.BtmSubTitleColor", paramAnonymousc.ilX);
                      localIntent.putExtra("SpringCard.BrandIcon", paramAnonymousc.ilY);
                      localIntent.putExtra("SpringCard.BrandName", paramAnonymousc.dpI);
                      localIntent.putExtra("SpringCard.BrandBgColor", paramAnonymousc.ilZ);
                      localIntent.putExtra("SpringCard.BrandBtmImg", paramAnonymousc.ima);
                      localIntent.putExtra("SpringCard.BrandRedPocketCoverMainTitle", paramAnonymousc.imb);
                      localIntent.putExtra("SpringCard.BrandRedPocketCoverSubTitle", paramAnonymousc.imc);
                      localIntent.putExtra("SpringCard.BrandCouponMainTitle", paramAnonymousc.imd);
                      localIntent.putExtra("SpringCard.BrandCouponSubTitle", paramAnonymousc.ime);
                    }
                    paramAnonymousc = paramActivity;
                    paramAnonymousd = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousc, paramAnonymousd.ahE(), "com/tencent/mm/ui/chatting/EggMgr$2", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousc.startActivity((Intent)paramAnonymousd.mt(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousc, "com/tencent/mm/ui/chatting/EggMgr$2", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramActivity.overridePendingTransition(2130772108, 2130772048);
                    AppMethodBeat.o(160230);
                    return;
                  }
                }
              });
            }
            if (this.JYq == null)
            {
              ae.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
              AppMethodBeat.o(34795);
              return false;
              label820:
              com.tencent.mm.plugin.report.service.g.yxI.dD(1263, 2);
            }
            else
            {
              boolean bool;
              if ((((com.tencent.mm.bb.d)localObject2).ilK <= i1) && (i1 <= ((com.tencent.mm.bb.d)localObject2).ilL + 86400L))
              {
                if (this.JYq.a((com.tencent.mm.bb.d)localObject2)) {
                  a((com.tencent.mm.bb.d)localObject2, (String)localObject6);
                }
                i = ((com.tencent.mm.bb.d)localObject2).dGC;
                if (parambv.field_isSend == 1) {}
                for (bool = true;; bool = false)
                {
                  bl(i, bool);
                  ae.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[] { localObject6, Integer.valueOf(((com.tencent.mm.bb.d)localObject2).ilK), Integer.valueOf(((com.tencent.mm.bb.d)localObject2).ilL) });
                  AppMethodBeat.o(34795);
                  return true;
                }
              }
              if ((((com.tencent.mm.bb.d)localObject2).ilK == ((com.tencent.mm.bb.d)localObject2).ilL) && (((com.tencent.mm.bb.d)localObject2).ilK == 0))
              {
                if (this.JYq.a((com.tencent.mm.bb.d)localObject2)) {
                  a((com.tencent.mm.bb.d)localObject2, (String)localObject6);
                }
                i = ((com.tencent.mm.bb.d)localObject2).dGC;
                if (parambv.field_isSend == 1) {}
                for (bool = true;; bool = false)
                {
                  bl(i, bool);
                  ae.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", new Object[] { localObject6 });
                  AppMethodBeat.o(34795);
                  return true;
                }
              }
              ae.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[] { localObject6, Integer.valueOf(((com.tencent.mm.bb.d)localObject2).ilK), Integer.valueOf(((com.tencent.mm.bb.d)localObject2).ilL) });
              AppMethodBeat.o(34795);
              return false;
            }
          }
          ae.d("MicroMsg.EggMgr", "no match");
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
  
  private static boolean aXv(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(34797);
    boolean bool1;
    if (af.isNullOrNil(paramString)) {
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
        if (paramString[i].equals(ad.fom())) {
          break;
        }
        i += 1;
      }
      label67:
      bool1 = false;
    }
  }
  
  static boolean b(com.tencent.mm.bb.d paramd)
  {
    if (paramd != null) {
      return 1 == paramd.type;
    }
    return false;
  }
  
  private static int bk(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(34798);
    if ((af.isNullOrNil(paramString1)) || (af.isNullOrNil(paramString2)) || (ak.getContext() == null))
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
          if ((k >= str.length() - 1) || (af.isNullOrNil(paramString3))) {
            continue;
          }
          if ((k <= 0) || (str.charAt(k - 1) < 'a') || (str.charAt(k - 1) > 'z')) {
            continue;
          }
          ae.v("MicroMsg.EggMgr", "letter in the prefix");
          localObject = paramString1.substring(0, k);
          j = ((String)localObject).lastIndexOf('/');
          i = j;
          if (j == -1) {
            continue;
          }
          localObject = ((String)localObject).subSequence(j, ((String)localObject).length());
          com.tencent.mm.ce.g.fqZ();
          ak.getContext();
          localObject = com.tencent.mm.ce.f.fqV().aTm((String)localObject);
          if (localObject == null) {
            continue;
          }
          localObject = ((f.a)localObject).text;
          i = j;
          if (af.isNullOrNil((String)localObject)) {
            continue;
          }
          i = j;
          if (((String)localObject).length() + j != k) {
            continue;
          }
          ae.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
          i = -2;
        }
        catch (Exception paramString1)
        {
          Object localObject;
          int m;
          ae.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", new Object[] { paramString1.getMessage() });
          ae.printErrStackTrace("MicroMsg.EggMgr", paramString1, "", new Object[0]);
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
                ae.v("MicroMsg.EggMgr", "letter in the suffix");
                j = 0;
              }
            }
          }
        }
        if (j == 0) {
          continue;
        }
        ae.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", new Object[] { Integer.valueOf(k), Integer.valueOf(str.length()), Integer.valueOf(paramString2.length()) });
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
  
  private static void bl(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34800);
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new StringBuilder();
        bc.aCg();
        localObject1 = o.bb(com.tencent.mm.model.c.ajw() + "eggresult.rep", 0, -1);
        com.tencent.mm.bb.g localg;
        if (localObject1 != null)
        {
          ae.d("MicroMsg.EggMgr", "data not null, parse it");
          localObject1 = (h)new h().parseFrom((byte[])localObject1);
          localObject2 = ((h)localObject1).ilT.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label317;
          }
          localg = (com.tencent.mm.bb.g)((Iterator)localObject2).next();
          if (localg.dGC != paramInt) {
            continue;
          }
          if (paramBoolean)
          {
            localg.ilR += 1;
            break label322;
            if (i == 0)
            {
              localObject2 = new com.tencent.mm.bb.g();
              ((com.tencent.mm.bb.g)localObject2).dGC = paramInt;
              if (!paramBoolean) {
                break label308;
              }
              ((com.tencent.mm.bb.g)localObject2).ilR = 1;
              ((h)localObject1).ilT.add(localObject2);
            }
            localObject2 = ((h)localObject1).toByteArray();
            ae.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[] { localObject1.toString() });
            localObject1 = new StringBuilder();
            bc.aCg();
            o.f(com.tencent.mm.model.c.ajw() + "eggresult.rep", (byte[])localObject2, localObject2.length);
            AppMethodBeat.o(34800);
          }
        }
        else
        {
          ae.d("MicroMsg.EggMgr", "data is null, new one");
          localObject1 = new h();
          continue;
        }
        localg.ilS += 1;
      }
      catch (Exception localException)
      {
        ae.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[] { localException.getLocalizedMessage() });
        ae.printErrStackTrace("MicroMsg.EggMgr", localException, "", new Object[0]);
        AppMethodBeat.o(34800);
        return;
      }
      label308:
      ((com.tencent.mm.bb.g)localObject2).ilS = 1;
      continue;
      label317:
      int i = 0;
      continue;
      label322:
      i = 1;
    }
  }
  
  private void fGd()
  {
    AppMethodBeat.i(34799);
    bc.aCg();
    if (af.rZ(af.d((Long)com.tencent.mm.model.c.ajA().get(68108, null))) * 1000L > 21600000L) {
      new aq().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34792);
          if (!bc.ajM())
          {
            AppMethodBeat.o(34792);
            return;
          }
          bc.aCg();
          if (af.rZ(af.d((Long)com.tencent.mm.model.c.ajA().get(68108, null))) * 1000L > 21600000L)
          {
            m localm = new m(37);
            bc.ajj().a(localm, 0);
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(68108, Long.valueOf(af.aRi()));
          }
          AppMethodBeat.o(34792);
        }
      }, 10000L);
    }
    AppMethodBeat.o(34799);
  }
  
  private boolean fGe()
  {
    AppMethodBeat.i(34802);
    if (1 == ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qNv, 0))
    {
      ae.i("MicroMsg.EggMgr", "forceTag enable.");
      this.JYs = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qNu, 20000);
    }
    long l = ch.aDa();
    ae.i("MicroMsg.EggMgr", "nowMs: [%s] ticket: [%s] interval: [%s].", new Object[] { Long.valueOf(l), Long.valueOf(this.pFU), Long.valueOf(this.JYs) });
    if (l - this.pFU > this.JYs)
    {
      this.JYs = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qNu, 20000);
      this.pFU = l;
      AppMethodBeat.o(34802);
      return true;
    }
    AppMethodBeat.o(34802);
    return false;
  }
  
  public final void O(boolean paramBoolean, String paramString)
  {
    this.dHA = paramBoolean;
    this.name = paramString;
  }
  
  public final void a(Activity paramActivity, List<bv> paramList)
  {
    AppMethodBeat.i(34794);
    if (paramList == null)
    {
      AppMethodBeat.o(34794);
      return;
    }
    fGd();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a(paramActivity, (bv)paramList.next()))
      {
        AppMethodBeat.o(34794);
        return;
      }
    }
    AppMethodBeat.o(34794);
  }
  
  public final void dic()
  {
    AppMethodBeat.i(34796);
    com.tencent.mm.kernel.g.ajj().b(2757, this);
    AppMethodBeat.o(34796);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(34803);
    ae.i("MicroMsg.EggMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.plugin.report.service.g.yxI.dD(1263, 4);
      AppMethodBeat.o(34803);
      return;
    }
    if (2757 == paramn.getType())
    {
      paramString = (com.tencent.mm.plugin.eggspring.c.c)paramn;
      if (paramString.pFU == this.pFU)
      {
        paramString = paramString.pFT;
        if (paramString != null)
        {
          ae.i("MicroMsg.EggMgr", "luckyBagInfo, %s.", new Object[] { paramString.toString() });
          if ((paramString.pFM) && (this.JYq != null) && (paramString != null) && (paramString.pFM))
          {
            paramn = this.JYq;
            paramInt1 = i;
            if (paramn.JUA != null)
            {
              paramInt1 = i;
              if (1 == paramn.JUA.type)
              {
                paramInt1 = i;
                if (paramn.cpF > 0) {
                  paramInt1 = 1;
                }
              }
            }
            if (paramInt1 != 0)
            {
              paramn = this.JYq;
              if ((paramString != null) && (paramn.JUq != null) && (paramn.JUw != null) && (paramn.JUx != null) && (!paramn.pFM))
              {
                a.a locala = com.tencent.mm.plugin.eggspring.a.pFw;
                com.tencent.mm.plugin.eggspring.a.cgU().BU(3);
                paramn.pFM = true;
                paramn.pFT = paramString;
                paramn.addView(paramn.JUq);
                ae.d("MicroMsg.ChattingAnimFrame", "lucky bag start anim!!!");
                paramn.JUw.start();
                paramn.JUx.start();
                paramn.JUq.start();
              }
            }
          }
          this.JYs = (paramString.gxu * 1000);
        }
      }
    }
    AppMethodBeat.o(34803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aa
 * JD-Core Version:    0.7.0.1
 */