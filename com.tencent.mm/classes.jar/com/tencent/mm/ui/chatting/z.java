package com.tencent.mm.ui.chatting;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bc.e;
import com.tencent.mm.bc.h;
import com.tencent.mm.bc.j;
import com.tencent.mm.cf.f.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.eggspring.a;
import com.tencent.mm.plugin.eggspring.a.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.j.a.a.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public final class z
  implements com.tencent.mm.al.f
{
  public Activity JDA;
  private long JDB;
  public ChattingAnimFrame JDz;
  private boolean dGu;
  public ap mHandler;
  private String name;
  public List<bu> oxE;
  private long pzq;
  
  public z()
  {
    AppMethodBeat.i(34793);
    this.JDz = null;
    this.mHandler = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(34790);
        if ((z.this.oxE == null) || (!ba.ajx()))
        {
          AppMethodBeat.o(34790);
          return;
        }
        ad.d("MicroMsg.EggMgr", "post start egg");
        z.this.a(z.this.JDA, z.this.oxE);
        AppMethodBeat.o(34790);
      }
    };
    this.pzq = 0L;
    this.JDB = 0L;
    AppMethodBeat.o(34793);
  }
  
  private void a(com.tencent.mm.bc.d paramd, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(34801);
    if ((paramd == null) || (af.isNullOrNil(paramString)))
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
    a.a locala = a.pyS;
    a.cfE().BI(2);
    if (this.JDz != null)
    {
      this.JDz.fBh();
      if (fCc())
      {
        paramd = new com.tencent.mm.plugin.eggspring.c.c(paramString, paramd.gkH.appId, this.pzq);
        com.tencent.mm.kernel.g.aiU().a(paramd, 0);
      }
    }
    AppMethodBeat.o(34801);
  }
  
  private boolean a(Activity paramActivity, bu parambu)
  {
    AppMethodBeat.i(34795);
    if ((this.JDz != null) && (!this.JDz.fBj()))
    {
      ad.i("MicroMsg.EggMgr", "LuckyBag, ad egg or lucky bag still exist, return.");
      AppMethodBeat.o(34795);
      return false;
    }
    Object localObject4 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cgx();
    if (localObject4 == null)
    {
      ad.d("MicroMsg.EggMgr", "eggList is null");
      AppMethodBeat.o(34795);
      return false;
    }
    int i1 = (int)bt.aQJ();
    ad.d("MicroMsg.EggMgr", "curSecond is %d, getEggList.size is %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(((com.tencent.mm.bc.f)localObject4).iiX.size()) });
    Object localObject2 = parambu.field_content;
    Object localObject1 = localObject2;
    if (w.vF(parambu.field_talker)) {
      localObject1 = bj.Bi((String)localObject2);
    }
    if (parambu.frQ())
    {
      localObject1 = k.b.aA((String)localObject1, parambu.field_reserved);
      if (localObject1 == null) {}
    }
    for (Object localObject3 = ((k.b)localObject1).title;; localObject3 = localObject1)
    {
      localObject2 = null;
      int j = -1;
      Object localObject6 = null;
      TreeMap localTreeMap = new TreeMap();
      Iterator localIterator1 = ((com.tencent.mm.bc.f)localObject4).iiX.iterator();
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
        if (aVU(locald.iiT))
        {
          i = -1;
          localObject1 = null;
          Iterator localIterator2 = locald.iiP.iterator();
          localObject5 = localObject2;
          m = j;
          localObject4 = localObject6;
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              localObject2 = (e)localIterator2.next();
              localObject6 = ((e)localObject2).iiW;
              if (af.isNullOrNil((String)localObject6))
              {
                ad.e("MicroMsg.EggMgr", "error egg keyWord");
                continue;
                AppMethodBeat.o(34795);
                return false;
              }
              else
              {
                k = bj((String)localObject3, (String)localObject6, ((e)localObject2).lang);
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
          if (!af.isNullOrNil(((StringBuilder)localObject1).toString()))
          {
            localObject3 = a.pyS;
            a.cfE().a(parambu, this.dGu, this.name, (String)localObject6);
            localObject3 = a.pyS;
            a.cfE().aL(1, ((StringBuilder)localObject1).toString());
          }
          if (b((com.tencent.mm.bc.d)localObject2))
          {
            if (parambu.field_isSend != 1) {
              break label820;
            }
            com.tencent.mm.plugin.report.service.g.yhR.dD(1263, 1);
          }
          while (localObject2 != null)
          {
            if (this.JDz == null)
            {
              localObject1 = (ViewStub)paramActivity.findViewById(2131306439);
              if (localObject1 != null) {
                ((ViewStub)localObject1).inflate();
              }
              this.JDz = ((ChattingAnimFrame)paramActivity.findViewById(2131297976));
              this.JDz.setOnLuckyBagClick(new z.2(this, paramActivity));
            }
            if (this.JDz == null)
            {
              ad.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
              AppMethodBeat.o(34795);
              return false;
              label820:
              com.tencent.mm.plugin.report.service.g.yhR.dD(1263, 2);
            }
            else
            {
              boolean bool;
              if ((((com.tencent.mm.bc.d)localObject2).iiR <= i1) && (i1 <= ((com.tencent.mm.bc.d)localObject2).iiS + 86400L))
              {
                if (this.JDz.a((com.tencent.mm.bc.d)localObject2)) {
                  a((com.tencent.mm.bc.d)localObject2, (String)localObject6);
                }
                i = ((com.tencent.mm.bc.d)localObject2).dFx;
                if (parambu.field_isSend == 1) {}
                for (bool = true;; bool = false)
                {
                  bf(i, bool);
                  ad.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[] { localObject6, Integer.valueOf(((com.tencent.mm.bc.d)localObject2).iiR), Integer.valueOf(((com.tencent.mm.bc.d)localObject2).iiS) });
                  AppMethodBeat.o(34795);
                  return true;
                }
              }
              if ((((com.tencent.mm.bc.d)localObject2).iiR == ((com.tencent.mm.bc.d)localObject2).iiS) && (((com.tencent.mm.bc.d)localObject2).iiR == 0))
              {
                if (this.JDz.a((com.tencent.mm.bc.d)localObject2)) {
                  a((com.tencent.mm.bc.d)localObject2, (String)localObject6);
                }
                i = ((com.tencent.mm.bc.d)localObject2).dFx;
                if (parambu.field_isSend == 1) {}
                for (bool = true;; bool = false)
                {
                  bf(i, bool);
                  ad.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", new Object[] { localObject6 });
                  AppMethodBeat.o(34795);
                  return true;
                }
              }
              ad.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[] { localObject6, Integer.valueOf(((com.tencent.mm.bc.d)localObject2).iiR), Integer.valueOf(((com.tencent.mm.bc.d)localObject2).iiS) });
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
  
  private static boolean aVU(String paramString)
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
        if (paramString[i].equals(ac.fks())) {
          break;
        }
        i += 1;
      }
      label67:
      bool1 = false;
    }
  }
  
  static boolean b(com.tencent.mm.bc.d paramd)
  {
    if (paramd != null) {
      return 1 == paramd.type;
    }
    return false;
  }
  
  private static void bf(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34800);
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new StringBuilder();
        ba.aBQ();
        localObject1 = i.aY(com.tencent.mm.model.c.ajh() + "eggresult.rep", 0, -1);
        com.tencent.mm.bc.g localg;
        if (localObject1 != null)
        {
          ad.d("MicroMsg.EggMgr", "data not null, parse it");
          localObject1 = (h)new h().parseFrom((byte[])localObject1);
          localObject2 = ((h)localObject1).ija.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label317;
          }
          localg = (com.tencent.mm.bc.g)((Iterator)localObject2).next();
          if (localg.dFx != paramInt) {
            continue;
          }
          if (paramBoolean)
          {
            localg.iiY += 1;
            break label322;
            if (i == 0)
            {
              localObject2 = new com.tencent.mm.bc.g();
              ((com.tencent.mm.bc.g)localObject2).dFx = paramInt;
              if (!paramBoolean) {
                break label308;
              }
              ((com.tencent.mm.bc.g)localObject2).iiY = 1;
              ((h)localObject1).ija.add(localObject2);
            }
            localObject2 = ((h)localObject1).toByteArray();
            ad.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[] { localObject1.toString() });
            localObject1 = new StringBuilder();
            ba.aBQ();
            i.f(com.tencent.mm.model.c.ajh() + "eggresult.rep", (byte[])localObject2, localObject2.length);
            AppMethodBeat.o(34800);
          }
        }
        else
        {
          ad.d("MicroMsg.EggMgr", "data is null, new one");
          localObject1 = new h();
          continue;
        }
        localg.iiZ += 1;
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[] { localException.getLocalizedMessage() });
        ad.printErrStackTrace("MicroMsg.EggMgr", localException, "", new Object[0]);
        AppMethodBeat.o(34800);
        return;
      }
      label308:
      ((com.tencent.mm.bc.g)localObject2).iiZ = 1;
      continue;
      label317:
      int i = 0;
      continue;
      label322:
      i = 1;
    }
  }
  
  private static int bj(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(34798);
    if ((af.isNullOrNil(paramString1)) || (af.isNullOrNil(paramString2)) || (aj.getContext() == null))
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
          ad.v("MicroMsg.EggMgr", "letter in the prefix");
          localObject = paramString1.substring(0, k);
          j = ((String)localObject).lastIndexOf('/');
          i = j;
          if (j == -1) {
            continue;
          }
          localObject = ((String)localObject).subSequence(j, ((String)localObject).length());
          com.tencent.mm.cf.g.fng();
          aj.getContext();
          localObject = com.tencent.mm.cf.f.fnb().aRP((String)localObject);
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
  
  private void fCb()
  {
    AppMethodBeat.i(34799);
    ba.aBQ();
    if (af.rM(af.d((Long)com.tencent.mm.model.c.ajl().get(68108, null))) * 1000L > 21600000L) {
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34792);
          if (!ba.ajx())
          {
            AppMethodBeat.o(34792);
            return;
          }
          ba.aBQ();
          if (af.rM(af.d((Long)com.tencent.mm.model.c.ajl().get(68108, null))) * 1000L > 21600000L)
          {
            m localm = new m(37);
            ba.aiU().a(localm, 0);
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(68108, Long.valueOf(af.aQJ()));
          }
          AppMethodBeat.o(34792);
        }
      }, 10000L);
    }
    AppMethodBeat.o(34799);
  }
  
  private boolean fCc()
  {
    AppMethodBeat.i(34802);
    if (1 == ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qFP, 0))
    {
      ad.i("MicroMsg.EggMgr", "forceTag enable.");
      this.JDB = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qFO, 20000);
    }
    long l = cf.aCK();
    ad.i("MicroMsg.EggMgr", "nowMs: [%s] ticket: [%s] interval: [%s].", new Object[] { Long.valueOf(l), Long.valueOf(this.pzq), Long.valueOf(this.JDB) });
    if (l - this.pzq > this.JDB)
    {
      this.JDB = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qFO, 20000);
      this.pzq = l;
      AppMethodBeat.o(34802);
      return true;
    }
    AppMethodBeat.o(34802);
    return false;
  }
  
  public final void M(boolean paramBoolean, String paramString)
  {
    this.dGu = paramBoolean;
    this.name = paramString;
  }
  
  public final void a(Activity paramActivity, List<bu> paramList)
  {
    AppMethodBeat.i(34794);
    if (paramList == null)
    {
      AppMethodBeat.o(34794);
      return;
    }
    fCb();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a(paramActivity, (bu)paramList.next()))
      {
        AppMethodBeat.o(34794);
        return;
      }
    }
    AppMethodBeat.o(34794);
  }
  
  public final void dfk()
  {
    AppMethodBeat.i(34796);
    com.tencent.mm.kernel.g.aiU().b(2757, this);
    AppMethodBeat.o(34796);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(34803);
    ad.i("MicroMsg.EggMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.plugin.report.service.g.yhR.dD(1263, 4);
      AppMethodBeat.o(34803);
      return;
    }
    if (2757 == paramn.getType())
    {
      paramString = (com.tencent.mm.plugin.eggspring.c.c)paramn;
      if (paramString.pzq == this.pzq)
      {
        paramString = paramString.pzp;
        if (paramString != null)
        {
          ad.i("MicroMsg.EggMgr", "luckyBagInfo, %s.", new Object[] { paramString.toString() });
          if ((paramString.pzi) && (this.JDz != null) && (paramString != null) && (paramString.pzi))
          {
            paramn = this.JDz;
            paramInt1 = i;
            if (paramn.JzK != null)
            {
              paramInt1 = i;
              if (1 == paramn.JzK.type)
              {
                paramInt1 = i;
                if (paramn.fJg > 0) {
                  paramInt1 = 1;
                }
              }
            }
            if (paramInt1 != 0)
            {
              paramn = this.JDz;
              if ((paramString != null) && (paramn.JzA != null) && (paramn.JzG != null) && (paramn.JzH != null) && (!paramn.pzi))
              {
                a.a locala = a.pyS;
                a.cfE().BI(3);
                paramn.pzi = true;
                paramn.pzp = paramString;
                paramn.addView(paramn.JzA);
                ad.d("MicroMsg.ChattingAnimFrame", "lucky bag start anim!!!");
                paramn.JzG.start();
                paramn.JzH.start();
                paramn.JzA.start();
              }
            }
          }
          this.JDB = (paramString.guN * 1000);
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