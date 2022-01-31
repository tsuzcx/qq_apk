package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public final class z
{
  ArrayList<aa> neH = new ArrayList();
  ab neI = ac.btG();
  y neJ = null;
  boolean neK = false;
  ab.f neL = new z.1(this);
  ab.e neM = new z.2(this);
  
  public final void a(aa paramaa)
  {
    if (!g.DN().Dc()) {
      return;
    }
    if (this.neJ == null) {
      this.neJ = new y();
    }
    y localy = this.neJ;
    String str = paramaa.ndx;
    if (bk.bl(str)) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ShareMailInfoMgr", "add info fail, info is null");
    }
    for (;;)
    {
      this.neH.add(paramaa);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ShareMailQueue", "add a new job, queue.size: %d", new Object[] { Integer.valueOf(this.neH.size()) });
      if (this.neK) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ShareMailQueue", "start execute");
      if (this.neH.size() <= 0) {
        break;
      }
      this.neK = true;
      b((aa)this.neH.remove(0));
      this.neI.a(this.neL, this.neM);
      return;
      w localw = new w();
      localw.ndx = str;
      localy.neG.maL.add(localw);
      localy.save();
    }
  }
  
  final void b(aa paramaa)
  {
    ab localab = this.neI;
    localab.neX.clear();
    localab.nec = null;
    localab.neZ = 0;
    localab.nfb = null;
    localab.nfc = null;
    localab.nfd.clear();
    localab.nfa.clear();
    localab.bRO = null;
    localab.neW.clear();
    localab.neP.clear();
    localab.neO = null;
    localab.ndx = null;
    localab.nfg = 0;
    localab.nea = null;
    localab.neQ.clear();
    localab.neU.clear();
    localab.neY.clear();
    localab.neV = null;
    localab.neM = null;
    this.neI.bRO = paramaa.bRO;
    this.neI.ndx = paramaa.ndx;
    this.neI.nea = paramaa.nea;
    this.neI.neb = paramaa.neb;
    this.neI.neO = paramaa.neO;
    localab = this.neI;
    Map localMap = paramaa.neP;
    localab.neP = new HashMap();
    localab.neP.putAll(localMap);
    localab = this.neI;
    localMap = paramaa.neQ;
    localab.neQ = new LinkedHashMap();
    localab.neQ.putAll(localMap);
    localab = this.neI;
    paramaa = paramaa.neR;
    localab.neR = new LinkedHashMap();
    localab.neR.putAll(paramaa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.z
 * JD-Core Version:    0.7.0.1
 */