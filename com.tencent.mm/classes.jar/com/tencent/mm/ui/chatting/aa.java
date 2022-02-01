package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.k;
import com.tencent.mm.ce.f.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.eggspring.c.a;
import com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggActivity;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.storage.ca;>;
import java.util.Set;
import java.util.TreeMap;
import kotlin.g.b.p;
import kotlin.x;
import kotlinx.coroutines.bu;

public final class aa
  implements com.tencent.mm.ak.i
{
  ChattingAnimFrame PjB;
  private com.tencent.mm.plugin.eggspring.d PjC;
  private long PjD;
  private long PjE;
  private boolean dZl;
  private String name;
  private long qVk;
  
  public aa()
  {
    AppMethodBeat.i(34793);
    this.PjB = null;
    this.PjD = 0L;
    this.qVk = 0L;
    this.PjE = 0L;
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
    if (b(parame))
    {
      c.a locala = com.tencent.mm.plugin.eggspring.c.qUO;
      com.tencent.mm.plugin.eggspring.c.cEH().FE(2);
      if (parame.type == 3)
      {
        if (this.PjC == null) {
          this.PjC = new com.tencent.mm.plugin.eggspring.d();
        }
        this.PjC.qUT = new kotlin.g.a.b() {};
        this.PjC.fM(parame.gXT.appId, paramString);
        AppMethodBeat.o(34801);
        return;
      }
      Log.i("MicroMsg.EggMgr", "initLuckyBagOrNot: game lucky egg %s", new Object[] { parame.gWY.appId });
      if (this.PjB != null)
      {
        this.PjB.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(232905);
            aa.this.PjB.gNr();
            aa localaa = aa.this;
            e locale = parame;
            if ((localaa.PjB != null) && (locale.gWY != null)) {
              localaa.PjB.a(null);
            }
            AppMethodBeat.o(232905);
          }
        });
        com.tencent.mm.cr.d.bpI("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
      }
    }
    AppMethodBeat.o(34801);
  }
  
  public static boolean amp(int paramInt)
  {
    AppMethodBeat.i(232910);
    if (paramInt == 3001)
    {
      c.a locala = com.tencent.mm.plugin.eggspring.c.qUO;
      com.tencent.mm.plugin.eggspring.c.cEH().FF(16);
      AppMethodBeat.o(232910);
      return true;
    }
    AppMethodBeat.o(232910);
    return false;
  }
  
  static boolean b(e parame)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parame != null) {
      if ((parame.type != 1) && (parame.type != 2))
      {
        bool1 = bool2;
        if (parame.type != 3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void bG(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34800);
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new StringBuilder();
        bg.aVF();
        localObject1 = s.aW(com.tencent.mm.model.c.azM() + "eggresult.rep", 0, -1);
        com.tencent.mm.bb.h localh;
        if (localObject1 != null)
        {
          Log.d("MicroMsg.EggMgr", "data not null, parse it");
          localObject1 = (com.tencent.mm.bb.i)new com.tencent.mm.bb.i().parseFrom((byte[])localObject1);
          localObject2 = ((com.tencent.mm.bb.i)localObject1).jgW.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label308;
          }
          localh = (com.tencent.mm.bb.h)((Iterator)localObject2).next();
          if (localh.dYn != paramInt) {
            continue;
          }
          if (paramBoolean)
          {
            localh.jgU += 1;
            break label313;
            if (i == 0)
            {
              localObject2 = new com.tencent.mm.bb.h();
              ((com.tencent.mm.bb.h)localObject2).dYn = paramInt;
              if (!paramBoolean) {
                break label299;
              }
              ((com.tencent.mm.bb.h)localObject2).jgU = 1;
              ((com.tencent.mm.bb.i)localObject1).jgW.add(localObject2);
            }
            localObject2 = ((com.tencent.mm.bb.i)localObject1).toByteArray();
            Log.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[] { localObject1.toString() });
            localObject1 = new StringBuilder();
            bg.aVF();
            s.f(com.tencent.mm.model.c.azM() + "eggresult.rep", (byte[])localObject2, localObject2.length);
            AppMethodBeat.o(34800);
          }
        }
        else
        {
          Log.d("MicroMsg.EggMgr", "data is null, new one");
          localObject1 = new com.tencent.mm.bb.i();
          continue;
        }
        localh.jgV += 1;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[] { localException.getLocalizedMessage() });
        Log.printErrStackTrace("MicroMsg.EggMgr", localException, "", new Object[0]);
        AppMethodBeat.o(34800);
        return;
      }
      label299:
      ((com.tencent.mm.bb.h)localObject2).jgV = 1;
      continue;
      label308:
      int i = 0;
      continue;
      label313:
      i = 1;
    }
  }
  
  private static boolean bmz(String paramString)
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
  
  private static int bt(String paramString1, String paramString2, String paramString3)
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
          com.tencent.mm.ce.g.gxZ();
          MMApplicationContext.getContext();
          localObject = com.tencent.mm.ce.f.gxT().big((String)localObject);
          if (localObject == null) {
            continue;
          }
          localObject = ((f.a)localObject).text;
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
  
  public final void P(boolean paramBoolean, String paramString)
  {
    this.dZl = paramBoolean;
    this.name = paramString;
  }
  
  public final long a(final Activity paramActivity, List<ca> paramList)
  {
    AppMethodBeat.i(232906);
    long l;
    if ((this.PjB != null) && (!this.PjB.gNt()))
    {
      Log.i("MicroMsg.EggMgr", "LuckyBag, ad egg or lucky bag still exist, return.");
      l = this.PjD;
      AppMethodBeat.o(232906);
      return l;
    }
    this.PjD = 0L;
    if (paramList == null)
    {
      l = this.PjD;
      AppMethodBeat.o(232906);
      return l;
    }
    bg.aVF();
    if (Util.secondsToNow(Util.nullAs((Long)com.tencent.mm.model.c.azQ().get(68108, null), 0L)) * 1000L > 21600000L) {
      new MMHandler().postDelayed(new aa.2(this), 10000L);
    }
    Iterator localIterator1 = paramList.iterator();
    ca localca;
    String str;
    while (localIterator1.hasNext())
    {
      localca = (ca)localIterator1.next();
      str = com.tencent.mm.emoji.a.f.r(localca);
      if (!Util.isNullOrNil(str)) {
        if (localca.field_isSend != 1) {
          break label246;
        }
      }
    }
    int i;
    label218:
    label246:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramList = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFL();
      if (paramList != null) {
        break;
      }
      Log.d("MicroMsg.EggMgr", "eggList is null");
      i = 0;
      if (i == 0) {
        break label1290;
      }
      this.PjD = localca.field_msgId;
      l = this.PjD;
      AppMethodBeat.o(232906);
      return l;
    }
    int i1 = (int)Util.nowSecond();
    Log.d("MicroMsg.EggMgr", "curSecond is %d, getEggList.size is %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramList.jgS.size()) });
    Object localObject1 = null;
    int j = -1;
    Object localObject2 = null;
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator2 = paramList.jgS.iterator();
    label318:
    Object localObject5;
    Object localObject4;
    int m;
    Object localObject3;
    label377:
    int k;
    label467:
    int n;
    while (localIterator2.hasNext())
    {
      localObject5 = (e)localIterator2.next();
      if (bmz(((e)localObject5).jgO))
      {
        i = -1;
        paramList = null;
        Iterator localIterator3 = ((e)localObject5).jgK.iterator();
        localObject4 = localObject1;
        m = j;
        localObject3 = localObject2;
        for (;;)
        {
          if (localIterator3.hasNext())
          {
            localObject1 = (com.tencent.mm.bb.f)localIterator3.next();
            localObject2 = ((com.tencent.mm.bb.f)localObject1).jgR;
            if (Util.isNullOrNil((String)localObject2))
            {
              Log.e("MicroMsg.EggMgr", "error egg keyWord");
            }
            else
            {
              k = bt(str, (String)localObject2, ((com.tencent.mm.bb.f)localObject1).lang);
              if (k == -1) {
                break label1295;
              }
              if (!b((e)localObject5)) {
                break label1292;
              }
              if (-1 == i)
              {
                paramList = ((String)localObject2).toLowerCase();
                i = k;
                n = 0;
                if (m != -1)
                {
                  if (!b((e)localObject4)) {
                    break label566;
                  }
                  j = n;
                  if (b((e)localObject5))
                  {
                    j = n;
                    if (m < k) {
                      j = 1;
                    }
                  }
                  label510:
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
      break label377;
      if (i < k)
      {
        paramList = ((String)localObject2).toLowerCase();
        i = k;
        break label467;
        label566:
        if (b((e)localObject5))
        {
          j = 1;
          break label510;
        }
        j = n;
        if (m >= k) {
          break label510;
        }
        j = 1;
        break label510;
        localObject2 = localObject3;
        j = m;
        localObject1 = localObject4;
        if (i == -1) {
          break label318;
        }
        Log.d("MicroMsg.EggMgr", "rpt mp %s keyWord %s.", new Object[] { Integer.valueOf(i), paramList });
        localTreeMap.put(Integer.valueOf(i), paramList);
        localObject2 = localObject3;
        j = m;
        localObject1 = localObject4;
        break label318;
        paramList = localTreeMap.descendingKeySet();
        localObject3 = new StringBuilder();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject4 = (Integer)paramList.next();
          localObject5 = (String)localTreeMap.get(localObject4);
          Log.d("MicroMsg.EggMgr", "key: [%s] value: [%s].", new Object[] { localObject4, localObject5 });
          ((StringBuilder)localObject3).append((String)localObject5).append("#");
        }
        if (!Util.isNullOrNil(((StringBuilder)localObject3).toString()))
        {
          paramList = com.tencent.mm.plugin.eggspring.c.qUO;
          localObject4 = com.tencent.mm.plugin.eggspring.c.cEH();
          boolean bool2 = this.dZl;
          localObject5 = this.name;
          p.h(localObject5, "name");
          p.h(localObject2, "keyWord");
          if (bool1)
          {
            paramList = Integer.valueOf(1);
            label814:
            ((com.tencent.mm.plugin.eggspring.c)localObject4).qUJ = paramList;
            if (!bool2) {
              break label1028;
            }
            ((com.tencent.mm.plugin.eggspring.c)localObject4).qUK = ((String)localObject5);
            ((com.tencent.mm.plugin.eggspring.c)localObject4).userName = "";
            ((com.tencent.mm.plugin.eggspring.c)localObject4).qUM = Integer.valueOf(2);
            label849:
            ((com.tencent.mm.plugin.eggspring.c)localObject4).jgR = ((String)localObject2);
            ((com.tencent.mm.plugin.eggspring.c)localObject4).qUL = Long.valueOf(cl.aWy());
            paramList = com.tencent.mm.plugin.eggspring.c.qUO;
            com.tencent.mm.plugin.eggspring.c.cEH().aP(1, ((StringBuilder)localObject3).toString());
          }
        }
        else if (b((e)localObject1))
        {
          if (!bool1) {
            break label1055;
          }
          com.tencent.mm.plugin.report.service.h.CyF.dN(1263, 1);
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            if (((e)localObject1).gWY != null)
            {
              paramList = ((e)localObject1).gWY.jgI;
              ((com.tencent.mm.plugin.eggspring.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.eggspring.a.a.class)).prefetch(paramList);
            }
            if (this.PjB == null)
            {
              paramList = (ViewStub)paramActivity.findViewById(2131309873);
              if (paramList != null) {
                paramList.inflate();
              }
              this.PjB = ((ChattingAnimFrame)paramActivity.findViewById(2131298317));
              this.PjB.setOnLuckyBagClick(new ChattingAnimFrame.d()
              {
                public final void a(com.tencent.mm.plugin.eggspring.c.c paramAnonymousc, e paramAnonymouse)
                {
                  AppMethodBeat.i(232902);
                  if (paramAnonymouse == null)
                  {
                    AppMethodBeat.o(232902);
                    return;
                  }
                  if (paramAnonymouse.type == 3)
                  {
                    Activity localActivity = paramActivity;
                    paramAnonymousc = SpringLuckyEggActivity.a(paramActivity, paramAnonymouse, paramAnonymousc.dDv, paramAnonymousc.appId, paramAnonymousc.kZe);
                    paramAnonymousc = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousc);
                    com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramAnonymousc.axQ(), "com/tencent/mm/ui/chatting/EggMgr$1", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    localActivity.startActivity((Intent)paramAnonymousc.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/ui/chatting/EggMgr$1", "onLuckyBagClick", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;Lcom/tencent/mm/modelpackage/EggInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(232902);
                    return;
                  }
                  if ((paramAnonymouse.gWY == null) || (Util.isNullOrNil(paramAnonymouse.gWY.jgI)))
                  {
                    AppMethodBeat.o(232902);
                    return;
                  }
                  paramAnonymousc = paramAnonymouse.gWY.jgI;
                  paramAnonymouse = new Intent();
                  paramAnonymouse.putExtra("rawUrl", paramAnonymousc);
                  paramAnonymouse.putExtra("from_shortcut", true);
                  paramAnonymouse.putExtra("disable_minimize", true);
                  paramAnonymouse.putExtra("MMActivity.OverrideEnterAnimation", 2130771986);
                  paramAnonymouse.putExtra("MMActivity.OverrideExitAnimation", 2130772130);
                  com.tencent.mm.br.c.b(paramActivity, "webview", ".ui.tools.WebViewUI", paramAnonymouse, 3001);
                  paramActivity.overridePendingTransition(2130772132, 2130771986);
                  AppMethodBeat.o(232902);
                }
              });
            }
            if (this.PjB == null)
            {
              Log.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
              i = 0;
              break;
              paramList = Integer.valueOf(2);
              break label814;
              label1028:
              ((com.tencent.mm.plugin.eggspring.c)localObject4).userName = ((String)localObject5);
              ((com.tencent.mm.plugin.eggspring.c)localObject4).qUK = "";
              ((com.tencent.mm.plugin.eggspring.c)localObject4).qUM = Integer.valueOf(1);
              break label849;
              label1055:
              com.tencent.mm.plugin.report.service.h.CyF.dN(1263, 2);
              continue;
            }
            if ((((e)localObject1).jgM <= i1) && (i1 <= ((e)localObject1).jgN))
            {
              if (this.PjB.a((e)localObject1)) {
                a((e)localObject1, (String)localObject2);
              }
              bG(((e)localObject1).dYn, bool1);
              Log.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[] { localObject2, Integer.valueOf(((e)localObject1).jgM), Integer.valueOf(((e)localObject1).jgN) });
              i = 1;
              break;
            }
            if ((((e)localObject1).jgM == ((e)localObject1).jgN) && (((e)localObject1).jgM == 0))
            {
              if (this.PjB.a((e)localObject1)) {
                a((e)localObject1, (String)localObject2);
              }
              bG(((e)localObject1).dYn, bool1);
              Log.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", new Object[] { localObject2 });
              i = 1;
              break;
            }
            Log.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[] { localObject2, Integer.valueOf(((e)localObject1).jgM), Integer.valueOf(((e)localObject1).jgN) });
            i = 0;
            break;
          }
        }
        Log.d("MicroMsg.EggMgr", "no match");
        i = 0;
        break label218;
        label1290:
        break;
      }
      label1292:
      break label467;
      label1295:
      localObject1 = paramList;
      n = i;
    }
  }
  
  public final void gOi()
  {
    AppMethodBeat.i(232907);
    if (this.PjB != null) {
      this.PjB.stop();
    }
    ((com.tencent.mm.plugin.eggspring.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.eggspring.a.a.class)).cleanPrefetch();
    com.tencent.mm.plugin.eggspring.d locald;
    StringBuilder localStringBuilder;
    if (this.PjC != null)
    {
      locald = this.PjC;
      localStringBuilder = new StringBuilder("dispose: job is running: ");
      localObject = locald.qUS;
      if (localObject == null) {
        break label137;
      }
    }
    label137:
    for (Object localObject = Boolean.valueOf(((bu)localObject).isActive());; localObject = null)
    {
      Log.i("MicroMsg.SpringLuckyEggHelper", localObject);
      localObject = locald.qUS;
      if (localObject != null) {
        ((bu)localObject).a(null);
      }
      locald.qUS = null;
      Log.i("MicroMsg.EggMgr", "egg has been stop, %s", new Object[] { this.PjB });
      AppMethodBeat.o(232907);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(232909);
    com.tencent.mm.kernel.g.azz().b(2757, this);
    AppMethodBeat.o(232909);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(232908);
    com.tencent.mm.kernel.g.azz().a(2757, this);
    AppMethodBeat.o(232908);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(34803);
    Log.i("MicroMsg.EggMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.plugin.report.service.h.CyF.dN(1263, 4);
      AppMethodBeat.o(34803);
      return;
    }
    if (2757 == paramq.getType())
    {
      paramString = (com.tencent.mm.plugin.eggspring.d.b)paramq;
      if (paramString.qVk == this.qVk)
      {
        paramString = paramString.qVj;
        if (paramString != null)
        {
          Log.i("MicroMsg.EggMgr", "luckyBagInfo, %s.", new Object[] { paramString.toString() });
          this.PjE = (paramString.gTn * 1000);
        }
      }
    }
    AppMethodBeat.o(34803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aa
 * JD-Core Version:    0.7.0.1
 */