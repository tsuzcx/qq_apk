package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fax
  extends com.tencent.mm.bw.a
{
  public int Dzt = -1;
  public String NhM;
  public String Nxj;
  public String Nxk;
  public String Nxl;
  public String Nxm;
  public String Nxn;
  public int Nxo;
  public float Nxp;
  public int dLt;
  public String domain;
  public String dtX;
  public int duration = -1;
  public int idx;
  public long msgId;
  public int pHw;
  public long prZ;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212148);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.duration);
      paramVarArgs.aM(2, this.Dzt);
      if (this.dtX != null) {
        paramVarArgs.e(3, this.dtX);
      }
      if (this.Nxj != null) {
        paramVarArgs.e(4, this.Nxj);
      }
      paramVarArgs.aM(5, this.dLt);
      if (this.NhM != null) {
        paramVarArgs.e(6, this.NhM);
      }
      paramVarArgs.bb(7, this.msgId);
      paramVarArgs.aM(8, this.idx);
      if (this.Nxk != null) {
        paramVarArgs.e(9, this.Nxk);
      }
      if (this.Nxl != null) {
        paramVarArgs.e(10, this.Nxl);
      }
      if (this.Nxm != null) {
        paramVarArgs.e(11, this.Nxm);
      }
      if (this.Nxn != null) {
        paramVarArgs.e(12, this.Nxn);
      }
      paramVarArgs.bb(13, this.prZ);
      paramVarArgs.aM(14, this.scene);
      paramVarArgs.aM(15, this.pHw);
      paramVarArgs.aM(16, this.Nxo);
      if (this.domain != null) {
        paramVarArgs.e(17, this.domain);
      }
      paramVarArgs.E(18, this.Nxp);
      AppMethodBeat.o(212148);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.duration) + 0 + g.a.a.b.b.a.bu(2, this.Dzt);
      paramInt = i;
      if (this.dtX != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dtX);
      }
      i = paramInt;
      if (this.Nxj != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Nxj);
      }
      i += g.a.a.b.b.a.bu(5, this.dLt);
      paramInt = i;
      if (this.NhM != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.NhM);
      }
      i = paramInt + g.a.a.b.b.a.r(7, this.msgId) + g.a.a.b.b.a.bu(8, this.idx);
      paramInt = i;
      if (this.Nxk != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Nxk);
      }
      i = paramInt;
      if (this.Nxl != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.Nxl);
      }
      paramInt = i;
      if (this.Nxm != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Nxm);
      }
      i = paramInt;
      if (this.Nxn != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Nxn);
      }
      i = i + g.a.a.b.b.a.r(13, this.prZ) + g.a.a.b.b.a.bu(14, this.scene) + g.a.a.b.b.a.bu(15, this.pHw) + g.a.a.b.b.a.bu(16, this.Nxo);
      paramInt = i;
      if (this.domain != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.domain);
      }
      i = g.a.a.b.b.a.fS(18);
      AppMethodBeat.o(212148);
      return paramInt + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(212148);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fax localfax = (fax)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(212148);
        return -1;
      case 1: 
        localfax.duration = locala.UbS.zi();
        AppMethodBeat.o(212148);
        return 0;
      case 2: 
        localfax.Dzt = locala.UbS.zi();
        AppMethodBeat.o(212148);
        return 0;
      case 3: 
        localfax.dtX = locala.UbS.readString();
        AppMethodBeat.o(212148);
        return 0;
      case 4: 
        localfax.Nxj = locala.UbS.readString();
        AppMethodBeat.o(212148);
        return 0;
      case 5: 
        localfax.dLt = locala.UbS.zi();
        AppMethodBeat.o(212148);
        return 0;
      case 6: 
        localfax.NhM = locala.UbS.readString();
        AppMethodBeat.o(212148);
        return 0;
      case 7: 
        localfax.msgId = locala.UbS.zl();
        AppMethodBeat.o(212148);
        return 0;
      case 8: 
        localfax.idx = locala.UbS.zi();
        AppMethodBeat.o(212148);
        return 0;
      case 9: 
        localfax.Nxk = locala.UbS.readString();
        AppMethodBeat.o(212148);
        return 0;
      case 10: 
        localfax.Nxl = locala.UbS.readString();
        AppMethodBeat.o(212148);
        return 0;
      case 11: 
        localfax.Nxm = locala.UbS.readString();
        AppMethodBeat.o(212148);
        return 0;
      case 12: 
        localfax.Nxn = locala.UbS.readString();
        AppMethodBeat.o(212148);
        return 0;
      case 13: 
        localfax.prZ = locala.UbS.zl();
        AppMethodBeat.o(212148);
        return 0;
      case 14: 
        localfax.scene = locala.UbS.zi();
        AppMethodBeat.o(212148);
        return 0;
      case 15: 
        localfax.pHw = locala.UbS.zi();
        AppMethodBeat.o(212148);
        return 0;
      case 16: 
        localfax.Nxo = locala.UbS.zi();
        AppMethodBeat.o(212148);
        return 0;
      case 17: 
        localfax.domain = locala.UbS.readString();
        AppMethodBeat.o(212148);
        return 0;
      }
      localfax.Nxp = Float.intBitsToFloat(locala.UbS.zm());
      AppMethodBeat.o(212148);
      return 0;
    }
    AppMethodBeat.o(212148);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fax
 * JD-Core Version:    0.7.0.1
 */