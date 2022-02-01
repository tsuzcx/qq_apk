package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.dqx;
import java.util.List;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public float angle;
  private f callback;
  public int dmM;
  public b rr;
  public List<dqx> yCO;
  public long yCP;
  
  public k(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(120856);
    b.a locala = new b.a();
    cdg localcdg = new cdg();
    localcdg.HpH = paramInt2;
    localcdg.HpI = paramInt3;
    localcdg.HpM = paramString1;
    localcdg.HpN = paramString2;
    localcdg.Scene = paramInt1;
    locala.hQF = localcdg;
    locala.hQG = new cdh();
    locala.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.dmM = paramInt2;
    AppMethodBeat.o(120856);
  }
  
  public k(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this(0, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public final float dOj()
  {
    return this.angle;
  }
  
  public final List<dqx> dOk()
  {
    return this.yCO;
  }
  
  public final String dOl()
  {
    return ((cdh)this.rr.hQE.hQJ).HpQ;
  }
  
  public final long dOm()
  {
    return this.yCP;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(120857);
    this.callback = paramf;
    this.yCP = System.currentTimeMillis();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(120857);
    return i;
  }
  
  public final int getSessionId()
  {
    return this.dmM;
  }
  
  public final int getType()
  {
    return 294;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120858);
    this.angle = ((cdh)((b)paramq).hQE.hQJ).HpO;
    this.yCO = ((cdh)((b)paramq).hQE.hQJ).GSo;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(120858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.k
 * JD-Core Version:    0.7.0.1
 */