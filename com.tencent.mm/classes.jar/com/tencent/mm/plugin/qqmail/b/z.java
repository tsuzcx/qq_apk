package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;

public final class z
{
  ArrayList<aa> pJW;
  ab pJX;
  y pJY;
  boolean pJZ;
  ab.f pKa;
  ab.e pKb;
  
  public z()
  {
    AppMethodBeat.i(68033);
    this.pJW = new ArrayList();
    this.pJX = ac.cdR();
    this.pJY = null;
    this.pJZ = false;
    this.pKa = new z.1(this);
    this.pKb = new z.2(this);
    AppMethodBeat.o(68033);
  }
  
  public final void a(aa paramaa)
  {
    AppMethodBeat.i(68034);
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(68034);
      return;
    }
    if (this.pJY == null) {
      this.pJY = new y();
    }
    y localy = this.pJY;
    String str = paramaa.pIO;
    if (bo.isNullOrNil(str)) {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ShareMailInfoMgr", "add info fail, info is null");
    }
    for (;;)
    {
      this.pJW.add(paramaa);
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ShareMailQueue", "add a new job, queue.size: %d", new Object[] { Integer.valueOf(this.pJW.size()) });
      if (!this.pJZ)
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ShareMailQueue", "start execute");
        if (this.pJW.size() > 0)
        {
          this.pJZ = true;
          b((aa)this.pJW.remove(0));
          this.pJX.a(this.pKa, this.pKb);
        }
      }
      AppMethodBeat.o(68034);
      return;
      w localw = new w();
      localw.pIO = str;
      localy.pJV.oBk.add(localw);
      localy.save();
    }
  }
  
  final void b(aa paramaa)
  {
    AppMethodBeat.i(68035);
    this.pJX.clearData();
    this.pJX.czp = paramaa.czp;
    this.pJX.pIO = paramaa.pIO;
    this.pJX.pJq = paramaa.pJq;
    this.pJX.pJr = paramaa.pJr;
    this.pJX.pKd = paramaa.pKd;
    this.pJX.X(paramaa.pKe);
    this.pJX.Y(paramaa.pKf);
    this.pJX.Z(paramaa.pKg);
    AppMethodBeat.o(68035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.z
 * JD-Core Version:    0.7.0.1
 */