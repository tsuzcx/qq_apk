package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.protocal.protobuf.emb;
import com.tencent.mm.protocal.protobuf.ffb;
import com.tencent.mm.protocal.protobuf.ffc;

public final class k
  extends n<ffb, ffc>
{
  public k(emb paramemb)
  {
    AppMethodBeat.i(115250);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ffb();
    ((d.a)localObject).lBV = new ffc();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedtest";
    ((d.a)localObject).funcId = 765;
    ((d.a)localObject).lBW = 765;
    ((d.a)localObject).respCmdId = 1000000765;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ffb)d.b.b(this.rr.lBR);
    ((ffb)localObject).Svu = paramemb.Svu;
    ((ffb)localObject).Uon = paramemb.Uon;
    ((ffb)localObject).SmH = paramemb.SmH;
    ((ffb)localObject).Uoo = paramemb.Uoo;
    ((ffb)localObject).Uop = paramemb.Uop;
    ((ffb)localObject).Uoq = paramemb.Uoq;
    ((ffb)localObject).Uor = paramemb.Uor;
    ((ffb)localObject).Uos = paramemb.Uos;
    ((ffb)localObject).Uot = paramemb.Uot;
    ((ffb)localObject).Uou = paramemb.Uou;
    ((ffb)localObject).Uov = paramemb.Uov;
    ((ffb)localObject).Uow = paramemb.Uow;
    ((ffb)localObject).Uox = paramemb.Uox;
    AppMethodBeat.o(115250);
  }
  
  public final i gAU()
  {
    AppMethodBeat.i(115251);
    k.1 local1 = new k.1(this);
    AppMethodBeat.o(115251);
    return local1;
  }
  
  public final int getType()
  {
    return 765;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k
 * JD-Core Version:    0.7.0.1
 */