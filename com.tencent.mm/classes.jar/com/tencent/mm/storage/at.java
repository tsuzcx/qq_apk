package com.tencent.mm.storage;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.a;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.h;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.p;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class at
{
  private static int cfk = -1;
  public static boolean uBn = false;
  public static boolean uBo = false;
  public static boolean uBp = false;
  public static boolean uBq = false;
  public static boolean uBr = false;
  public static ArrayList<EmojiGroupInfo> uBs = new ArrayList();
  public static HashMap<String, ArrayList<EmojiInfo>> uBt = new HashMap();
  public d uBb = new d(g.DP().dKu);
  public a uBc = new a(g.DP().dKu);
  public com.tencent.mm.storage.emotion.c uBd = new com.tencent.mm.storage.emotion.c(g.DP().dKu);
  public p uBe = new p(g.DP().dKu);
  public j uBf = new j(g.DP().dKu);
  public l uBg = new l(g.DP().dKu);
  public h uBh = new h(g.DP().dKu);
  public n uBi = new n(g.DP().dKu);
  public r uBj = new r(g.DP().dKu);
  public t uBk = new t(g.DP().dKu);
  public f uBl = new f(g.DP().dKu);
  public v uBm = new v();
  public final j.a uBu = new at.1(this);
  public final j.a uBv = new at.2(this);
  public final j.a uBw = new at.3(this);
  public final com.tencent.mm.sdk.b.c uBx = new at.4(this);
  public String uBy;
  
  public final ArrayList<EmojiGroupInfo> aHn()
  {
    if (uBs == null) {
      uBs = new ArrayList();
    }
    if ((uBs.size() == 0) || (uBn)) {
      if (!g.DP().isSDCardAvailable()) {
        break label58;
      }
    }
    label58:
    for (uBs = this.uBc.cwq();; uBs = (ArrayList)this.uBc.cwi())
    {
      uBn = false;
      return uBs;
    }
  }
  
  public final int aHo()
  {
    if ((cfk == -1) || (uBr)) {
      cfk = this.uBc.cwm();
    }
    return cfk;
  }
  
  public final ArrayList<EmojiInfo> aHp()
  {
    if (uBt == null) {
      uBt = new HashMap();
    }
    if ((!uBt.containsKey("custom")) || (uBp))
    {
      HashMap localHashMap = uBt;
      d locald = this.uBb;
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(locald.Fx(EmojiGroupInfo.uCS));
      localArrayList.addAll(locald.Fx(EmojiGroupInfo.uCR));
      localHashMap.put("custom", (ArrayList)localArrayList);
    }
    uBp = false;
    return (ArrayList)uBt.get("custom");
  }
  
  public final d avg()
  {
    return this.uBb;
  }
  
  public final boolean cuS()
  {
    if (this.uBy == null) {
      this.uBy = ((String)g.DP().Dz().get(ac.a.uzH, ""));
    }
    return !bk.bl(this.uBy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.at
 * JD-Core Version:    0.7.0.1
 */