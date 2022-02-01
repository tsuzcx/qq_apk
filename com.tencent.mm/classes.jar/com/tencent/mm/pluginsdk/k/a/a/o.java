package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.zl;
import com.tencent.mm.protocal.protobuf.zm;
import com.tencent.mm.protocal.q.a;
import com.tencent.mm.protocal.q.b;
import java.util.LinkedList;

public final class o
  extends n
{
  public static void cxi()
  {
    AppMethodBeat.i(152004);
    o localo = new o();
    h.aHF().kcd.a(localo, 0);
    AppMethodBeat.o(152004);
  }
  
  protected final String getTag()
  {
    return "MicroMsg.NetSceneEncryptCheckResUpdate";
  }
  
  public final int getType()
  {
    if (f.RAO) {
      return 784;
    }
    return 722;
  }
  
  protected final s hiz()
  {
    AppMethodBeat.i(152005);
    a locala = new a();
    q.a locala1 = (q.a)locala.getReqObjImp();
    locala1.setUin(0);
    locala1.RBG.Svs.Svq.SlK.addAll(this.Raf);
    AppMethodBeat.o(152005);
    return locala;
  }
  
  protected final zm i(s params)
  {
    AppMethodBeat.i(197894);
    params = a.a((a)params).RBJ;
    AppMethodBeat.o(197894);
    return params;
  }
  
  static final class a
    extends com.tencent.mm.an.o
  {
    private final q.a Raj;
    private final q.b Rak;
    
    public a()
    {
      AppMethodBeat.i(152003);
      this.Raj = new q.a();
      this.Rak = new q.b();
      AppMethodBeat.o(152003);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.Raj;
    }
    
    public final l.e getRespObj()
    {
      return this.Rak;
    }
    
    public final int getType()
    {
      if (f.RAO) {
        return 784;
      }
      return 722;
    }
    
    public final String getUri()
    {
      if (f.RAO) {
        return "/cgi-bin/micromsg-bin/secencryptcheckresupdate";
      }
      return "/cgi-bin/micromsg-bin/encryptcheckresupdate";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.o
 * JD-Core Version:    0.7.0.1
 */