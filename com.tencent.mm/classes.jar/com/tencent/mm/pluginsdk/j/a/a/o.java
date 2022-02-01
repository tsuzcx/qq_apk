package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.protocal.q.a;
import com.tencent.mm.protocal.q.b;
import java.util.LinkedList;

public final class o
  extends n
{
  public static void cjR()
  {
    AppMethodBeat.i(152004);
    o localo = new o();
    g.aAg().hqi.a(localo, 0);
    AppMethodBeat.o(152004);
  }
  
  protected final String getTag()
  {
    return "MicroMsg.NetSceneEncryptCheckResUpdate";
  }
  
  public final int getType()
  {
    if (f.KyZ) {
      return 784;
    }
    return 722;
  }
  
  protected final s gnS()
  {
    AppMethodBeat.i(152005);
    a locala = new a();
    q.a locala1 = (q.a)locala.getReqObjImp();
    locala1.setUin(0);
    locala1.KzQ.LsX.LsV.LkB.addAll(this.JZC);
    AppMethodBeat.o(152005);
    return locala;
  }
  
  protected final zi h(s params)
  {
    return ((a)params).JZH.KzT;
  }
  
  static final class a
    extends com.tencent.mm.ak.o
  {
    private final q.a JZG;
    final q.b JZH;
    
    public a()
    {
      AppMethodBeat.i(152003);
      this.JZG = new q.a();
      this.JZH = new q.b();
      AppMethodBeat.o(152003);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.JZG;
    }
    
    public final l.e getRespObj()
    {
      return this.JZH;
    }
    
    public final int getType()
    {
      if (f.KyZ) {
        return 784;
      }
      return 722;
    }
    
    public final String getUri()
    {
      if (f.KyZ) {
        return "/cgi-bin/micromsg-bin/secencryptcheckresupdate";
      }
      return "/cgi-bin/micromsg-bin/encryptcheckresupdate";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.o
 * JD-Core Version:    0.7.0.1
 */