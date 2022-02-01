package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.util.SparseArray;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelpackage.e;
import com.tencent.mm.modelpackage.j;
import com.tencent.mm.modelpackage.k;
import com.tencent.mm.q.d.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.l;
import com.tencent.mm.smiley.n;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.cb;

public final class ac
{
  Activity activity;
  com.tencent.mm.plugin.eggspring.c.c aegA;
  public com.tencent.mm.ui.n.a.b aekA;
  private com.tencent.mm.plugin.eggspring.g aekB;
  private com.tencent.mm.plugin.eggspring.d aekC;
  private com.tencent.mm.plugin.eggspring.c aekD;
  public com.tencent.mm.ui.n.a.a aekE;
  private com.tencent.mm.q.d aekF;
  private String aekG;
  private long aekH;
  private com.tencent.mm.plugin.emoji.magicemoji.bean.b aekI;
  boolean aekJ;
  ChattingAnimFrame aekz;
  public boolean hZc;
  e mdu;
  private com.tencent.mm.modelpackage.g mhI;
  public String name;
  
  public ac()
  {
    AppMethodBeat.i(34793);
    this.aekz = null;
    this.aekA = null;
    this.aekE = new com.tencent.mm.ui.n.a.a()
    {
      public final void a(com.tencent.mm.plugin.emoji.magicemoji.bean.b paramAnonymousb)
      {
        AppMethodBeat.i(253701);
        Log.i("MicroMsg.EggMgr", "onStart: %s, %s", new Object[] { paramAnonymousb.xIb, paramAnonymousb.xIa });
        ac.this.aekJ = true;
        if (ac.this.aekz != null) {
          ac.this.aekz.stop();
        }
        AppMethodBeat.o(253701);
      }
      
      public final void b(com.tencent.mm.plugin.emoji.magicemoji.bean.b paramAnonymousb)
      {
        AppMethodBeat.i(253703);
        Log.i("MicroMsg.EggMgr", "onClick: %s, %s", new Object[] { paramAnonymousb.xIb, paramAnonymousb.xIa });
        ac.a(ac.this, ac.this.aegA, ac.this.mdu, ac.this.activity, ac.this.hZc);
        AppMethodBeat.o(253703);
      }
      
      public final void c(com.tencent.mm.plugin.emoji.magicemoji.bean.b paramAnonymousb)
      {
        AppMethodBeat.i(253706);
        Log.i("MicroMsg.EggMgr", "onEnd: %s, %s", new Object[] { paramAnonymousb.xIb, paramAnonymousb.xIa });
        ac.this.aekJ = false;
        AppMethodBeat.o(253706);
      }
    };
    this.aekJ = false;
    AppMethodBeat.o(34793);
  }
  
  private void a(final e parame, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(34801);
    if ((parame == null) || (Util.isNullOrNil(paramString)))
    {
      if (parame != null) {}
      for (;;)
      {
        Log.e("MicroMsg.EggMgr", "egg info or keyWord err!!! info != null:[%s].", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(34801);
        return;
        bool = false;
      }
    }
    com.tencent.mm.plugin.eggspring.f localf = com.tencent.mm.plugin.eggspring.f.xEl;
    com.tencent.mm.plugin.eggspring.f.bb(2, com.tencent.mm.plugin.eggspring.f.oQy);
    if (b(parame))
    {
      if (parame.type == 3)
      {
        if (this.aekB == null) {
          this.aekB = new com.tencent.mm.plugin.eggspring.g();
        }
        this.aekB.xEt = new kotlin.g.a.b() {};
        this.aekB.gD(parame.mij.appId, paramString);
        AppMethodBeat.o(34801);
        return;
      }
      if (parame.type == 2)
      {
        Log.i("MicroMsg.EggMgr", "initLuckyBagOrNot: game lucky egg %s", new Object[] { parame.mhD.appId });
        if (this.aekz != null)
        {
          this.aekz.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(253705);
              ac.a(ac.this, parame, null);
              AppMethodBeat.o(253705);
            }
          });
          com.tencent.mm.xwebutil.c.jQG();
          AppMethodBeat.o(34801);
        }
      }
      else
      {
        if (parame.type == 4)
        {
          if (this.aekC == null) {
            this.aekC = new com.tencent.mm.plugin.eggspring.d();
          }
          this.aekC.mgM = new kotlin.g.a.m() {};
          this.aekC.dxG();
          AppMethodBeat.o(34801);
          return;
        }
        if (parame.type == 5)
        {
          if (this.aekD == null) {
            this.aekD = new com.tencent.mm.plugin.eggspring.c();
          }
          this.aekD.mgM = new kotlin.g.a.m() {};
          parame = this.aekD;
          paramString = com.tencent.mm.plugin.eggspring.f.xEl;
          parame.y(com.tencent.mm.plugin.eggspring.f.dxH());
        }
      }
    }
    AppMethodBeat.o(34801);
  }
  
  private void a(com.tencent.mm.plugin.emoji.magicemoji.bean.b paramb, boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(253821);
    if (paramb == null)
    {
      Log.w("MicroMsg.EggMgr", "meta is null");
      AppMethodBeat.o(253821);
      return;
    }
    Log.i("MicroMsg.EggMgr", "playMagicEgg: %s, %s, %s, %s, %s", new Object[] { paramb.xIa, paramb.xIb, Boolean.valueOf(paramBoolean), paramString, Long.valueOf(paramLong) });
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new com.tencent.mm.plugin.emoji.magicemoji.bean.a(str, paramLong);
    if (this.aekA != null)
    {
      if (paramBoolean)
      {
        paramString = com.tencent.mm.plugin.emoji.magicemoji.bean.a.xHW;
        paramString = com.tencent.mm.plugin.emoji.magicemoji.bean.a.dyH();
      }
      this.aekA.a(paramb, paramBoolean, paramString);
    }
    AppMethodBeat.o(253821);
  }
  
  static boolean b(e parame)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parame != null) {
      if ((parame.type != 1) && (parame.type != 2) && (parame.type != 3) && (parame.type != 4))
      {
        bool1 = bool2;
        if (parame.type != 5) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean bAE(String paramString)
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
  
  private static void cF(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34800);
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new StringBuilder();
        bh.bCz();
        localObject1 = y.bi(com.tencent.mm.model.c.baj() + "eggresult.rep", 0, -1);
        j localj;
        if (localObject1 != null)
        {
          Log.d("MicroMsg.EggMgr", "data not null, parse it");
          localObject1 = (k)new k().parseFrom((byte[])localObject1);
          localObject2 = ((k)localObject1).oQC.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label316;
          }
          localj = (j)((Iterator)localObject2).next();
          if (localj.hYb != paramInt) {
            continue;
          }
          if (paramBoolean)
          {
            localj.oQA += 1;
            break label321;
            if (i == 0)
            {
              localObject2 = new j();
              ((j)localObject2).hYb = paramInt;
              if (!paramBoolean) {
                break label307;
              }
              ((j)localObject2).oQA = 1;
              ((k)localObject1).oQC.add(localObject2);
            }
            localObject2 = ((k)localObject1).toByteArray();
            Log.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[] { localObject1.toString() });
            localObject1 = new StringBuilder();
            bh.bCz();
            y.f(com.tencent.mm.model.c.baj() + "eggresult.rep", (byte[])localObject2, localObject2.length);
            AppMethodBeat.o(34800);
          }
        }
        else
        {
          Log.d("MicroMsg.EggMgr", "data is null, new one");
          localObject1 = new k();
          continue;
        }
        localj.oQB += 1;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[] { localException.getLocalizedMessage() });
        Log.printErrStackTrace("MicroMsg.EggMgr", localException, "", new Object[0]);
        AppMethodBeat.o(34800);
        return;
      }
      label307:
      ((j)localObject2).oQB = 1;
      continue;
      label316:
      int i = 0;
      continue;
      label321:
      i = 1;
    }
  }
  
  private boolean isPlaying()
  {
    AppMethodBeat.i(253813);
    if (this.mdu == null)
    {
      AppMethodBeat.o(253813);
      return true;
    }
    if (this.aekJ)
    {
      AppMethodBeat.o(253813);
      return true;
    }
    if ((this.aekz != null) && (this.aekz.isPlaying()))
    {
      AppMethodBeat.o(253813);
      return true;
    }
    AppMethodBeat.o(253813);
    return false;
  }
  
  private boolean jpY()
  {
    AppMethodBeat.i(253810);
    if (this.mdu == null)
    {
      AppMethodBeat.o(253810);
      return true;
    }
    if (this.mdu.type <= 0)
    {
      AppMethodBeat.o(253810);
      return true;
    }
    if ((!this.aekJ) && (!this.aekz.isPlaying()))
    {
      AppMethodBeat.o(253810);
      return true;
    }
    AppMethodBeat.o(253810);
    return false;
  }
  
  public final void a(final Activity paramActivity, List<cc> paramList)
  {
    AppMethodBeat.i(34794);
    this.activity = paramActivity;
    Iterator localIterator = paramList.iterator();
    Object localObject1;
    boolean bool1;
    final boolean bool2;
    long l;
    int i;
    while (localIterator.hasNext())
    {
      localObject1 = (cc)localIterator.next();
      paramList = com.tencent.mm.emoji.a.f.s((cc)localObject1);
      if (!Util.isNullOrNil(paramList))
      {
        if (((fi)localObject1).field_isSend != 1) {
          break label130;
        }
        bool1 = true;
        bool2 = au.bwE(((fi)localObject1).field_talker);
        l = ((fi)localObject1).field_msgId;
        localObject1 = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzx();
        if (localObject1 != null) {
          break label136;
        }
        Log.d("MicroMsg.EggMgr", "eggList is null");
        i = 0;
      }
    }
    label119:
    Object localObject2;
    label130:
    label136:
    Object localObject3;
    Object localObject4;
    int j;
    for (;;)
    {
      if (i != 0)
      {
        AppMethodBeat.o(34794);
        return;
        bool1 = false;
        break;
        if ((this.mhI != localObject1) || (this.aekF == null))
        {
          this.aekF = new com.tencent.mm.q.d();
          localObject2 = this.aekF;
          s.u(localObject1, "eggList");
          ((com.tencent.mm.q.d)localObject2).mdy.acwL.clear();
          localObject3 = ((com.tencent.mm.modelpackage.g)localObject1).oQz;
          s.s(localObject3, "eggList.eggList");
          localObject3 = ((Iterable)localObject3).iterator();
          i = 0;
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = ((Iterator)localObject3).next();
            if (i < 0) {
              p.kkW();
            }
            localObject4 = (e)localObject4;
            Object localObject5 = ((e)localObject4).oQp;
            s.s(localObject5, "info.keyWords");
            localObject5 = ((Iterable)localObject5).iterator();
            label383:
            while (((Iterator)localObject5).hasNext())
            {
              com.tencent.mm.modelpackage.f localf = (com.tencent.mm.modelpackage.f)((Iterator)localObject5).next();
              Object localObject6 = (CharSequence)localf.oQy;
              if ((localObject6 == null) || (((CharSequence)localObject6).length() == 0)) {}
              for (j = 1;; j = 0)
              {
                if (j != 0) {
                  break label383;
                }
                localObject6 = ((com.tencent.mm.q.d)localObject2).mdy;
                s.s(localObject4, "info");
                s.s(localf, "eggKeyWord");
                ((com.tencent.mm.q.b)localObject6).a((l)new com.tencent.mm.q.a((e)localObject4, i, localf), 0);
                break;
              }
            }
            i += 1;
          }
        }
        this.mhI = ((com.tencent.mm.modelpackage.g)localObject1);
        j = (int)Util.nowSecond();
        Log.i("MicroMsg.EggMgr", "curSecond is %d, getEggList.size is %d", new Object[] { Integer.valueOf(j), Integer.valueOf(((com.tencent.mm.modelpackage.g)localObject1).oQz.size()) });
        localObject1 = this.aekF;
        paramList = paramList.toLowerCase();
        localObject2 = new LinkedList();
        localObject3 = (com.tencent.mm.smiley.m)new d.a((LinkedList)localObject2);
        s.u(localObject3, "matchCallback");
        new com.tencent.mm.smiley.f((n)((com.tencent.mm.q.d)localObject1).mdy).b(paramList, 0, -1, (com.tencent.mm.smiley.m)localObject3);
        localObject3 = (List)localObject2;
        paramList = ((List)localObject3).iterator();
        while (paramList.hasNext())
        {
          localObject1 = ((com.tencent.mm.q.c)paramList.next()).mdu;
          if (!bAE(((e)localObject1).oQt))
          {
            paramList.remove();
          }
          else if (((((e)localObject1).oQr > j) || (j > ((e)localObject1).oQs)) && ((((e)localObject1).oQr != ((e)localObject1).oQs) || (((e)localObject1).oQr != 0)))
          {
            if (((e)localObject1).mij != null)
            {
              localObject2 = com.tencent.mm.plugin.eggspring.e.a.xFF;
              com.tencent.mm.plugin.eggspring.e.a.anF(((e)localObject1).mij.appId);
            }
            paramList.remove();
          }
          else if (((e)localObject1).mij != null)
          {
            localObject2 = com.tencent.mm.plugin.eggspring.e.a.xFF;
            if (com.tencent.mm.plugin.eggspring.e.a.anG(((e)localObject1).mij.appId)) {
              paramList.remove();
            }
          }
        }
        if (((List)localObject3).isEmpty())
        {
          i = 0;
        }
        else
        {
          paramList = ((com.tencent.mm.q.c)((List)localObject3).get(0)).mdu;
          localObject1 = ((com.tencent.mm.q.c)((List)localObject3).get(0)).mdw.oQy;
          localObject2 = new StringBuilder();
          localObject3 = ((List)localObject3).iterator();
          label738:
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (com.tencent.mm.q.c)((Iterator)localObject3).next();
            if ((!b(((com.tencent.mm.q.c)localObject4).mdu)) && (b(paramList))) {
              break label1471;
            }
            paramList = ((com.tencent.mm.q.c)localObject4).mdu;
            localObject1 = ((com.tencent.mm.q.c)localObject4).mdw.oQy;
          }
        }
      }
    }
    label897:
    label1471:
    for (;;)
    {
      ((StringBuilder)localObject2).append(((com.tencent.mm.q.c)localObject4).mdw.oQy).append("#");
      break label738;
      if (!jpY())
      {
        if (this.aekJ)
        {
          localObject3 = this.mdu;
          if ((localObject3 != null) && (paramList != null)) {
            break label857;
          }
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            break label897;
          }
          i = 0;
          break;
          label857:
          if ((Util.isEqual(((e)localObject3).name, paramList.name)) && (Util.isEqual(((e)localObject3).oQx, paramList.oQx))) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject3 = com.tencent.mm.plugin.eggspring.f.xEl;
        com.tencent.mm.plugin.eggspring.f.a(bool1, this.hZc, this.name, (String)localObject1, paramList.oQw);
        if ((isPlaying()) && (paramList.oQw == 1))
        {
          Log.i("MicroMsg.EggMgr", "continue easter egg %s", new Object[] { this.aekG });
          localObject2 = com.tencent.mm.plugin.eggspring.f.xEl;
          com.tencent.mm.plugin.eggspring.f.bb(5, (String)localObject1);
        }
      }
      else
      {
        label974:
        if (b(paramList))
        {
          if (!bool1) {
            break label1099;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1263, 1);
        }
      }
      for (;;)
      {
        if (paramList != null)
        {
          if (this.aekz == null)
          {
            localObject2 = (ViewStub)paramActivity.findViewById(R.h.gcd);
            if (localObject2 != null) {
              ((ViewStub)localObject2).inflate();
            }
            this.aekz = ((ChattingAnimFrame)paramActivity.findViewById(R.h.fvK));
            this.aekz.setOnLuckyBagClick(new ChattingAnimFrame.d()
            {
              public final void a(com.tencent.mm.plugin.eggspring.c.c paramAnonymousc, e paramAnonymouse)
              {
                AppMethodBeat.i(160230);
                ac.a(ac.this, paramAnonymousc, paramAnonymouse, paramActivity, bool2);
                AppMethodBeat.o(160230);
              }
            });
          }
          if (this.aekz == null)
          {
            Log.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
            i = 0;
            break;
            localObject3 = com.tencent.mm.plugin.eggspring.f.xEl;
            com.tencent.mm.plugin.eggspring.f.bb(1, ((StringBuilder)localObject2).toString());
            break label974;
            label1099:
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1263, 2);
            continue;
          }
          if (((paramList.oQr <= j) && (j <= paramList.oQs)) || ((paramList.oQr == paramList.oQs) && (paramList.oQr == 0)))
          {
            this.mdu = paramList;
            bool2 = isPlaying();
            if (!bool2)
            {
              this.aekG = ((String)localObject1);
              this.aekH = l;
            }
            if (paramList.mhD != null)
            {
              localObject2 = paramList.mhD.oQn;
              ((com.tencent.mm.plugin.eggspring.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.eggspring.a.a.class)).prefetch((String)localObject2);
            }
            if ((paramList.mhJ != null) && (!Util.isNullOrNil(paramList.mhJ.userName))) {
              ((com.tencent.mm.plugin.eggspring.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.eggspring.a.a.class)).preloadMiniProgram(paramList.mhJ.userName);
            }
            if (paramList.oQw == 1)
            {
              this.aekI = new com.tencent.mm.plugin.emoji.magicemoji.bean.b(paramList.oQx, String.valueOf(this.aekH), this.name);
              a(this.aekI, false, (String)localObject1, l);
              if (!bool2) {
                a(paramList, (String)localObject1);
              }
            }
            for (;;)
            {
              cF(paramList.hYb, bool1);
              Log.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[] { localObject1, Integer.valueOf(paramList.oQr), Integer.valueOf(paramList.oQs) });
              i = 1;
              break;
              if ((this.aekA != null) && (this.aekI != null)) {
                this.aekA.a(this.aekI, 2);
              }
              if (this.aekz.a(paramList)) {
                a(paramList, (String)localObject1);
              }
            }
          }
          this.mdu = null;
          Log.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[] { localObject1, Integer.valueOf(paramList.oQr), Integer.valueOf(paramList.oQs) });
          i = 0;
          break;
        }
      }
      this.mdu = null;
      Log.d("MicroMsg.EggMgr", "no match");
      i = 0;
      break label119;
      break;
    }
  }
  
  public final void jpX()
  {
    AppMethodBeat.i(253867);
    if (this.aekz != null) {
      this.aekz.stop();
    }
    Object localObject2;
    String str;
    if (this.aekB != null)
    {
      localObject2 = this.aekB;
      localObject1 = ((com.tencent.mm.plugin.eggspring.g)localObject2).xDh;
      if (localObject1 == null)
      {
        localObject1 = null;
        Log.i("MicroMsg.SpringLuckyEggHelper", s.X("dispose: job is running: ", localObject1));
        localObject1 = ((com.tencent.mm.plugin.eggspring.g)localObject2).xDh;
        if (localObject1 != null) {
          ((cb)localObject1).a(null);
        }
        ((com.tencent.mm.plugin.eggspring.g)localObject2).xDh = null;
      }
    }
    else if (this.aekC != null)
    {
      localObject2 = this.aekC;
      str = ((com.tencent.mm.plugin.eggspring.d)localObject2).TAG;
      localObject1 = ((com.tencent.mm.plugin.eggspring.d)localObject2).xDh;
      if (localObject1 != null) {
        break label197;
      }
    }
    label197:
    for (Object localObject1 = null;; localObject1 = Boolean.valueOf(((cb)localObject1).isActive()))
    {
      Log.i(str, s.X("dispose: ", localObject1));
      localObject1 = ((com.tencent.mm.plugin.eggspring.d)localObject2).xDh;
      if (localObject1 != null) {
        ((cb)localObject1).a(null);
      }
      ((com.tencent.mm.plugin.eggspring.d)localObject2).xDh = null;
      ((com.tencent.mm.plugin.eggspring.d)localObject2).mgM = null;
      this.aekJ = false;
      this.aekG = "";
      this.aekH = 0L;
      Log.i("MicroMsg.EggMgr", "egg has been stop, %s", new Object[] { this.aekz });
      AppMethodBeat.o(253867);
      return;
      localObject1 = Boolean.valueOf(((cb)localObject1).isActive());
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(253869);
    ((com.tencent.mm.plugin.eggspring.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.eggspring.a.a.class)).cleanPrefetch();
    this.aekF = null;
    AppMethodBeat.o(253869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ac
 * JD-Core Version:    0.7.0.1
 */