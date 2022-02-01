package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.q.a;
import com.tencent.mm.protocal.q.b;
import java.util.LinkedList;

public final class o
  extends n
{
  public static void cZW()
  {
    AppMethodBeat.i(152004);
    o localo = new o();
    h.baD().mCm.a(localo, 0);
    AppMethodBeat.o(152004);
  }
  
  protected final String getTag()
  {
    return "MicroMsg.NetSceneEncryptCheckResUpdate";
  }
  
  public final int getType()
  {
    if (f.Yxs) {
      return 784;
    }
    return 722;
  }
  
  protected final abj i(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(245037);
    params = a.a((a)params).Yym;
    AppMethodBeat.o(245037);
    return params;
  }
  
  protected final com.tencent.mm.network.s iJy()
  {
    AppMethodBeat.i(152005);
    a locala = new a();
    q.a locala1 = (q.a)locala.getReqObjImp();
    locala1.setUin(0);
    locala1.Yyj.Zvx.Zvv.ZjU.addAll(this.XWj);
    AppMethodBeat.o(152005);
    return locala;
  }
  
  static final class a
    extends com.tencent.mm.am.n
  {
    private final q.a XWn;
    private final q.b XWo;
    
    public a()
    {
      AppMethodBeat.i(152003);
      this.XWn = new q.a();
      this.XWo = new q.b();
      AppMethodBeat.o(152003);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.XWn;
    }
    
    public final l.e getRespObj()
    {
      return this.XWo;
    }
    
    public final int getType()
    {
      if (f.Yxs) {
        return 784;
      }
      return 722;
    }
    
    public final String getUri()
    {
      if (f.Yxs) {
        return "/cgi-bin/micromsg-bin/secencryptcheckresupdate";
      }
      return "/cgi-bin/micromsg-bin/encryptcheckresupdate";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.o
 * JD-Core Version:    0.7.0.1
 */