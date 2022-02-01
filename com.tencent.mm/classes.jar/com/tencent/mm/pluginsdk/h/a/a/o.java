package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.protocal.q.a;
import com.tencent.mm.protocal.q.b;
import java.util.LinkedList;

public final class o
  extends n
{
  public static void bAT()
  {
    AppMethodBeat.i(152004);
    o localo = new o();
    g.afA().gcy.a(localo, 0);
    AppMethodBeat.o(152004);
  }
  
  protected final com.tencent.mm.network.q ewD()
  {
    AppMethodBeat.i(152005);
    a locala = new a();
    q.a locala1 = (q.a)locala.getReqObjImp();
    locala1.setUin(0);
    locala1.CqI.DdX.DdV.CXw.addAll(this.BSV);
    AppMethodBeat.o(152005);
    return locala;
  }
  
  protected final String getTag()
  {
    return "MicroMsg.NetSceneEncryptCheckResUpdate";
  }
  
  public final int getType()
  {
    if (f.CpT) {
      return 784;
    }
    return 722;
  }
  
  protected final vk h(com.tencent.mm.network.q paramq)
  {
    return ((a)paramq).BTa.CqL;
  }
  
  static final class a
    extends l
  {
    private final q.a BSZ;
    final q.b BTa;
    
    public a()
    {
      AppMethodBeat.i(152003);
      this.BSZ = new q.a();
      this.BTa = new q.b();
      AppMethodBeat.o(152003);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.BSZ;
    }
    
    public final l.e getRespObj()
    {
      return this.BTa;
    }
    
    public final int getType()
    {
      if (f.CpT) {
        return 784;
      }
      return 722;
    }
    
    public final String getUri()
    {
      if (f.CpT) {
        return "/cgi-bin/micromsg-bin/secencryptcheckresupdate";
      }
      return "/cgi-bin/micromsg-bin/encryptcheckresupdate";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.o
 * JD-Core Version:    0.7.0.1
 */