package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fcq
  extends com.tencent.mm.bw.a
{
  public int Cya;
  public int Cyb;
  public int IPh;
  public int LQr;
  public String Lru;
  public String Nyw;
  public String Nyx;
  public String Nyy;
  public int Nyz;
  public String SessionId;
  public int ecU;
  public String ecV;
  public String jfi;
  public String nIU;
  public int nIY;
  public int oUv;
  public int rBX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123693);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oUv);
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      if (this.Nyw != null) {
        paramVarArgs.e(3, this.Nyw);
      }
      paramVarArgs.aM(4, this.Cya);
      paramVarArgs.aM(5, this.rBX);
      paramVarArgs.aM(6, this.Cyb);
      if (this.Nyx != null) {
        paramVarArgs.e(7, this.Nyx);
      }
      paramVarArgs.aM(8, this.LQr);
      if (this.SessionId != null) {
        paramVarArgs.e(9, this.SessionId);
      }
      if (this.Nyy != null) {
        paramVarArgs.e(10, this.Nyy);
      }
      paramVarArgs.aM(11, this.IPh);
      paramVarArgs.aM(12, this.Nyz);
      if (this.Lru != null) {
        paramVarArgs.e(13, this.Lru);
      }
      if (this.nIU != null) {
        paramVarArgs.e(14, this.nIU);
      }
      paramVarArgs.aM(15, this.ecU);
      if (this.ecV != null) {
        paramVarArgs.e(16, this.ecV);
      }
      paramVarArgs.aM(17, this.nIY);
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.oUv) + 0;
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.Nyw != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nyw);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Cya) + g.a.a.b.b.a.bu(5, this.rBX) + g.a.a.b.b.a.bu(6, this.Cyb);
      paramInt = i;
      if (this.Nyx != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Nyx);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.LQr);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.SessionId);
      }
      i = paramInt;
      if (this.Nyy != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.Nyy);
      }
      i = i + g.a.a.b.b.a.bu(11, this.IPh) + g.a.a.b.b.a.bu(12, this.Nyz);
      paramInt = i;
      if (this.Lru != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Lru);
      }
      i = paramInt;
      if (this.nIU != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.nIU);
      }
      i += g.a.a.b.b.a.bu(15, this.ecU);
      paramInt = i;
      if (this.ecV != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.ecV);
      }
      i = g.a.a.b.b.a.bu(17, this.nIY);
      AppMethodBeat.o(123693);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fcq localfcq = (fcq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123693);
        return -1;
      case 1: 
        localfcq.oUv = locala.UbS.zi();
        AppMethodBeat.o(123693);
        return 0;
      case 2: 
        localfcq.jfi = locala.UbS.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 3: 
        localfcq.Nyw = locala.UbS.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 4: 
        localfcq.Cya = locala.UbS.zi();
        AppMethodBeat.o(123693);
        return 0;
      case 5: 
        localfcq.rBX = locala.UbS.zi();
        AppMethodBeat.o(123693);
        return 0;
      case 6: 
        localfcq.Cyb = locala.UbS.zi();
        AppMethodBeat.o(123693);
        return 0;
      case 7: 
        localfcq.Nyx = locala.UbS.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 8: 
        localfcq.LQr = locala.UbS.zi();
        AppMethodBeat.o(123693);
        return 0;
      case 9: 
        localfcq.SessionId = locala.UbS.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 10: 
        localfcq.Nyy = locala.UbS.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 11: 
        localfcq.IPh = locala.UbS.zi();
        AppMethodBeat.o(123693);
        return 0;
      case 12: 
        localfcq.Nyz = locala.UbS.zi();
        AppMethodBeat.o(123693);
        return 0;
      case 13: 
        localfcq.Lru = locala.UbS.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 14: 
        localfcq.nIU = locala.UbS.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 15: 
        localfcq.ecU = locala.UbS.zi();
        AppMethodBeat.o(123693);
        return 0;
      case 16: 
        localfcq.ecV = locala.UbS.readString();
        AppMethodBeat.o(123693);
        return 0;
      }
      localfcq.nIY = locala.UbS.zi();
      AppMethodBeat.o(123693);
      return 0;
    }
    AppMethodBeat.o(123693);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcq
 * JD-Core Version:    0.7.0.1
 */