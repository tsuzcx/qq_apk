package com.tencent.mm.plugin.radar.b;

import a.k;
import android.content.Context;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.bil;
import com.tencent.mm.protocal.c.bim;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.protocal.c.biq;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public final class e
  implements f
{
  private static final String TAG = "MicroMsg.Radar.RadarManager";
  private static final int nlm = 3000;
  private static final int nln = 5000;
  private static final int nlo = 1;
  public static final e.b nlp = new e.b((byte)0);
  private String bJY;
  private final Context context;
  public final a.a dig;
  private boolean edT;
  public c egs;
  private final LinkedList<bio> evN;
  private Location nla;
  private b nlb;
  private e.f nlc;
  public LinkedList<bim> nld;
  public Map<String, String> nle;
  private Map<String, c.e> nlf;
  private Map<String, c.e> nlg;
  public Map<Long, e.c> nlh;
  public Map<String, e.a> nli;
  private final am nlj;
  private final e.g nlk;
  private final e.d nll;
  
  public e(e.d paramd, Context paramContext)
  {
    this.nll = paramd;
    this.context = paramContext;
    this.nlc = e.f.nlB;
    this.evN = new LinkedList();
    this.nle = ((Map)new LinkedHashMap());
    this.nlf = ((Map)new LinkedHashMap());
    this.nlg = ((Map)new LinkedHashMap());
    this.nlh = ((Map)new LinkedHashMap());
    this.nli = ((Map)new LinkedHashMap());
    this.nlj = new am((am.a)new e.h(this), false);
    this.nlk = new e.g();
    this.dig = ((a.a)new e.i(this));
  }
  
  private final void a(int paramInt1, int paramInt2, LinkedList<bio> paramLinkedList)
  {
    this.nll.a(paramInt1, paramInt2, paramLinkedList);
  }
  
  private final c.e aS(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (c.e)this.nlg.get(paramString);
    }
    return (c.e)this.nlf.get(paramString);
  }
  
  private final void b(int paramInt1, int paramInt2, LinkedList<bil> paramLinkedList)
  {
    this.nll.b(paramInt1, paramInt2, paramLinkedList);
  }
  
  private final void buA()
  {
    this.nlk.sendEmptyMessageDelayed(nlo, nln);
  }
  
  public final c.e Ly(String paramString)
  {
    a.d.b.g.k(paramString, "username");
    return aS(paramString, false);
  }
  
  public final c.e a(bio parambio, boolean paramBoolean)
  {
    a.d.b.g.k(parambio, "member");
    Object localObject = parambio.hPY;
    a.d.b.g.j(localObject, "member.UserName");
    c.e locale = aS((String)localObject, paramBoolean);
    localObject = locale;
    if (locale == null)
    {
      parambio = parambio.sUr;
      a.d.b.g.j(parambio, "member.EncodeUserName");
      localObject = aS(parambio, paramBoolean);
    }
    return localObject;
  }
  
  public final void a(bio parambio)
  {
    if (parambio != null)
    {
      com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.nnt;
      parambio = com.tencent.mm.plugin.radar.ui.g.b(parambio);
      if (this.nli.containsKey(parambio)) {
        this.nli.remove(parambio);
      }
    }
    else
    {
      return;
    }
    this.nli.put(parambio, e.a.nlq);
  }
  
  public final void a(String paramString, c.e parame)
  {
    c.e locale = (c.e)this.nlf.get(paramString);
    if ((locale != null) && ((a.d.b.g.e(locale, parame) ^ true))) {
      this.nlg.put(paramString, locale);
    }
  }
  
  public final void b(String paramString, c.e parame)
  {
    a.d.b.g.k(paramString, "username");
    a.d.b.g.k(parame, "state");
    if (!a.h.e.X((CharSequence)paramString))
    {
      a(paramString, parame);
      this.nlf.put(paramString, parame);
    }
  }
  
  public final void buy()
  {
    buz();
    this.edT = false;
    this.nla = null;
    this.nlc = e.f.nlB;
    this.nlj.stopTimer();
    y.d(TAG, "start radar");
    if (this.egs == null) {
      this.egs = c.Ob();
    }
    this.nlc = e.f.nlC;
    c localc = this.egs;
    if (localc != null) {
      localc.b(this.dig);
    }
    y.d(TAG, "status: %s", new Object[] { this.nlc });
  }
  
  public final void buz()
  {
    e.f localf = this.nlc;
    switch (f.fHS[localf.ordinal()])
    {
    }
    for (;;)
    {
      y.d(TAG, "stop radar");
      return;
      stop();
      continue;
      if (this.nlb != null)
      {
        stop();
        com.tencent.mm.kernel.g.Dk().c((m)this.nlb);
        buA();
        continue;
        stop();
        buA();
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    Iterator localIterator = null;
    a.d.b.g.k(paramm, "scene");
    switch (paramm.getType())
    {
    default: 
    case 425: 
      do
      {
        return;
      } while (this.nlb != paramm);
      if (((b)paramm).bMC == 1)
      {
        this.nlc = e.f.nlE;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          y.d(TAG, "rader members count: %s ticket: %s", new Object[] { Integer.valueOf(((b)paramm).buw()), this.bJY });
          this.nlj.hq(nlm);
          paramString = ((b)paramm).dmK;
          if (paramString != null) {}
          for (paramString = paramString.Ko();; paramString = null)
          {
            Object localObject = (biq)paramString;
            paramString = localIterator;
            if (localObject != null) {
              paramString = ((biq)localObject).svo;
            }
            if (paramString == null) {
              break;
            }
            localIterator = paramString.iterator();
            while (localIterator.hasNext())
            {
              localObject = (bio)localIterator.next();
              com.tencent.mm.plugin.c.a locala = com.tencent.mm.plugin.c.a.YT();
              a.d.b.g.j(locala, "PinAntispam.instance()");
              locala.Ga().gm(((bio)localObject).hPY, ((bio)localObject).tac);
            }
          }
          if (paramString != null)
          {
            this.evN.clear();
            this.evN.addAll((Collection)paramString);
          }
          paramString = this.evN;
          ((b)paramm).buw();
          a(paramInt1, paramInt2, paramString);
          y.d(TAG, "status: %s", new Object[] { this.nlc });
          return;
        }
        stop();
        a(paramInt1, paramInt2, null);
        return;
      }
      a(paramInt1, paramInt2, null);
      return;
    }
    y.d(TAG, " MMFunc_MMRadarRelationChain ");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((a)paramm).dmK.Ko();
      if (paramString == null) {
        throw new k("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
      }
      paramString = (bin)paramString;
      this.bJY = paramString.sRr;
      if (paramString.dne > 0)
      {
        paramm = paramString.svo;
        int i = paramString.dne;
        b(paramInt1, paramInt2, paramm);
        return;
      }
      b(paramInt1, paramInt2, null);
      return;
    }
    b(paramInt1, paramInt2, null);
  }
  
  public final void stop()
  {
    this.edT = true;
    this.nlc = e.f.nlB;
    this.nlj.stopTimer();
  }
  
  public static enum e
  {
    static
    {
      e locale1 = new e("SEARCHING", 0);
      nlv = locale1;
      e locale2 = new e("SEARCH_RETRUN", 1);
      nlw = locale2;
      e locale3 = new e("RALATIONCHAIN", 2);
      nlx = locale3;
      e locale4 = new e("RALATIONCHAIN_RETRUN", 3);
      nly = locale4;
      e locale5 = new e("CREATING_CHAT", 4);
      nlz = locale5;
      nlA = new e[] { locale1, locale2, locale3, locale4, locale5 };
    }
    
    private e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e
 * JD-Core Version:    0.7.0.1
 */