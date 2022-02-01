package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.protocal.q.a;
import com.tencent.mm.protocal.q.b;
import java.util.LinkedList;

public final class o
  extends n
{
  public static void bMY()
  {
    AppMethodBeat.i(152004);
    o localo = new o();
    g.ajQ().gDv.a(localo, 0);
    AppMethodBeat.o(152004);
  }
  
  protected final com.tencent.mm.network.q feI()
  {
    AppMethodBeat.i(152005);
    a locala = new a();
    q.a locala1 = (q.a)locala.getReqObjImp();
    locala1.setUin(0);
    locala1.FGF.Gxo.Gxm.GpP.addAll(this.FiI);
    AppMethodBeat.o(152005);
    return locala;
  }
  
  protected final String getTag()
  {
    return "MicroMsg.NetSceneEncryptCheckResUpdate";
  }
  
  public final int getType()
  {
    if (f.FFQ) {
      return 784;
    }
    return 722;
  }
  
  protected final xw h(com.tencent.mm.network.q paramq)
  {
    return ((a)paramq).FiN.FGI;
  }
  
  static final class a
    extends l
  {
    private final q.a FiM;
    final q.b FiN;
    
    public a()
    {
      AppMethodBeat.i(152003);
      this.FiM = new q.a();
      this.FiN = new q.b();
      AppMethodBeat.o(152003);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.FiM;
    }
    
    public final l.e getRespObj()
    {
      return this.FiN;
    }
    
    public final int getType()
    {
      if (f.FFQ) {
        return 784;
      }
      return 722;
    }
    
    public final String getUri()
    {
      if (f.FFQ) {
        return "/cgi-bin/micromsg-bin/secencryptcheckresupdate";
      }
      return "/cgi-bin/micromsg-bin/encryptcheckresupdate";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.o
 * JD-Core Version:    0.7.0.1
 */