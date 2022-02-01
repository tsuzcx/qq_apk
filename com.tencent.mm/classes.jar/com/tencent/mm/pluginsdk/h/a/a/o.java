package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.protocal.q.a;
import com.tencent.mm.protocal.q.b;
import java.util.LinkedList;

public final class o
  extends n
{
  public static void bHP()
  {
    AppMethodBeat.i(152004);
    o localo = new o();
    g.agQ().ghe.a(localo, 0);
    AppMethodBeat.o(152004);
  }
  
  protected final com.tencent.mm.network.q eLX()
  {
    AppMethodBeat.i(152005);
    a locala = new a();
    q.a locala1 = (q.a)locala.getReqObjImp();
    locala1.setUin(0);
    locala1.DJa.Exd.Exb.Eqf.addAll(this.Dll);
    AppMethodBeat.o(152005);
    return locala;
  }
  
  protected final String getTag()
  {
    return "MicroMsg.NetSceneEncryptCheckResUpdate";
  }
  
  public final int getType()
  {
    if (f.DIl) {
      return 784;
    }
    return 722;
  }
  
  protected final vu h(com.tencent.mm.network.q paramq)
  {
    return ((a)paramq).Dlq.DJd;
  }
  
  static final class a
    extends l
  {
    private final q.a Dlp;
    final q.b Dlq;
    
    public a()
    {
      AppMethodBeat.i(152003);
      this.Dlp = new q.a();
      this.Dlq = new q.b();
      AppMethodBeat.o(152003);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.Dlp;
    }
    
    public final l.e getRespObj()
    {
      return this.Dlq;
    }
    
    public final int getType()
    {
      if (f.DIl) {
        return 784;
      }
      return 722;
    }
    
    public final String getUri()
    {
      if (f.DIl) {
        return "/cgi-bin/micromsg-bin/secencryptcheckresupdate";
      }
      return "/cgi-bin/micromsg-bin/encryptcheckresupdate";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.o
 * JD-Core Version:    0.7.0.1
 */