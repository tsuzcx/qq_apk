package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adh
  extends com.tencent.mm.bv.a
{
  public String wIJ;
  public long wVP;
  public long wVQ;
  public long wVR;
  public String wVS;
  public long wVT;
  public String wVU;
  public String wVV;
  public String wVW;
  public String wVX;
  public String wVY;
  public String wVZ;
  public int wWa;
  public String wWb;
  public int wWc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56792);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.wVP);
      paramVarArgs.am(2, this.wVQ);
      paramVarArgs.am(3, this.wVR);
      if (this.wVS != null) {
        paramVarArgs.e(4, this.wVS);
      }
      paramVarArgs.am(5, this.wVT);
      if (this.wVU != null) {
        paramVarArgs.e(6, this.wVU);
      }
      if (this.wVV != null) {
        paramVarArgs.e(7, this.wVV);
      }
      if (this.wVW != null) {
        paramVarArgs.e(8, this.wVW);
      }
      if (this.wVX != null) {
        paramVarArgs.e(9, this.wVX);
      }
      if (this.wVY != null) {
        paramVarArgs.e(10, this.wVY);
      }
      if (this.wVZ != null) {
        paramVarArgs.e(11, this.wVZ);
      }
      paramVarArgs.aO(12, this.wWa);
      if (this.wWb != null) {
        paramVarArgs.e(13, this.wWb);
      }
      paramVarArgs.aO(14, this.wWc);
      if (this.wIJ != null) {
        paramVarArgs.e(15, this.wIJ);
      }
      AppMethodBeat.o(56792);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.wVP) + 0 + e.a.a.b.b.a.p(2, this.wVQ) + e.a.a.b.b.a.p(3, this.wVR);
      paramInt = i;
      if (this.wVS != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wVS);
      }
      i = paramInt + e.a.a.b.b.a.p(5, this.wVT);
      paramInt = i;
      if (this.wVU != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wVU);
      }
      i = paramInt;
      if (this.wVV != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wVV);
      }
      paramInt = i;
      if (this.wVW != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wVW);
      }
      i = paramInt;
      if (this.wVX != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wVX);
      }
      paramInt = i;
      if (this.wVY != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wVY);
      }
      i = paramInt;
      if (this.wVZ != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wVZ);
      }
      i += e.a.a.b.b.a.bl(12, this.wWa);
      paramInt = i;
      if (this.wWb != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.wWb);
      }
      i = paramInt + e.a.a.b.b.a.bl(14, this.wWc);
      paramInt = i;
      if (this.wIJ != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.wIJ);
      }
      AppMethodBeat.o(56792);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56792);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      adh localadh = (adh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56792);
        return -1;
      case 1: 
        localadh.wVP = locala.CLY.sm();
        AppMethodBeat.o(56792);
        return 0;
      case 2: 
        localadh.wVQ = locala.CLY.sm();
        AppMethodBeat.o(56792);
        return 0;
      case 3: 
        localadh.wVR = locala.CLY.sm();
        AppMethodBeat.o(56792);
        return 0;
      case 4: 
        localadh.wVS = locala.CLY.readString();
        AppMethodBeat.o(56792);
        return 0;
      case 5: 
        localadh.wVT = locala.CLY.sm();
        AppMethodBeat.o(56792);
        return 0;
      case 6: 
        localadh.wVU = locala.CLY.readString();
        AppMethodBeat.o(56792);
        return 0;
      case 7: 
        localadh.wVV = locala.CLY.readString();
        AppMethodBeat.o(56792);
        return 0;
      case 8: 
        localadh.wVW = locala.CLY.readString();
        AppMethodBeat.o(56792);
        return 0;
      case 9: 
        localadh.wVX = locala.CLY.readString();
        AppMethodBeat.o(56792);
        return 0;
      case 10: 
        localadh.wVY = locala.CLY.readString();
        AppMethodBeat.o(56792);
        return 0;
      case 11: 
        localadh.wVZ = locala.CLY.readString();
        AppMethodBeat.o(56792);
        return 0;
      case 12: 
        localadh.wWa = locala.CLY.sl();
        AppMethodBeat.o(56792);
        return 0;
      case 13: 
        localadh.wWb = locala.CLY.readString();
        AppMethodBeat.o(56792);
        return 0;
      case 14: 
        localadh.wWc = locala.CLY.sl();
        AppMethodBeat.o(56792);
        return 0;
      }
      localadh.wIJ = locala.CLY.readString();
      AppMethodBeat.o(56792);
      return 0;
    }
    AppMethodBeat.o(56792);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adh
 * JD-Core Version:    0.7.0.1
 */