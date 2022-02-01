package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class biw
  extends com.tencent.mm.bx.a
{
  public String YIJ;
  public String ZSA;
  public int ZSB;
  public int ZSC;
  public int ZSD;
  public int ZSr;
  public String ZSs;
  public String ZSt;
  public int ZSu;
  public String ZSv;
  public String ZSw;
  public int ZSx;
  public String ZSy;
  public int ZSz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260177);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZSr);
      if (this.ZSs != null) {
        paramVarArgs.g(2, this.ZSs);
      }
      if (this.ZSt != null) {
        paramVarArgs.g(3, this.ZSt);
      }
      paramVarArgs.bS(4, this.ZSu);
      if (this.YIJ != null) {
        paramVarArgs.g(5, this.YIJ);
      }
      if (this.ZSv != null) {
        paramVarArgs.g(6, this.ZSv);
      }
      if (this.ZSw != null) {
        paramVarArgs.g(7, this.ZSw);
      }
      paramVarArgs.bS(8, this.ZSx);
      if (this.ZSy != null) {
        paramVarArgs.g(9, this.ZSy);
      }
      paramVarArgs.bS(10, this.ZSz);
      if (this.ZSA != null) {
        paramVarArgs.g(11, this.ZSA);
      }
      paramVarArgs.bS(12, this.ZSB);
      paramVarArgs.bS(13, this.ZSC);
      paramVarArgs.bS(14, this.ZSD);
      AppMethodBeat.o(260177);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZSr) + 0;
      paramInt = i;
      if (this.ZSs != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZSs);
      }
      i = paramInt;
      if (this.ZSt != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZSt);
      }
      i += i.a.a.b.b.a.cJ(4, this.ZSu);
      paramInt = i;
      if (this.YIJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YIJ);
      }
      i = paramInt;
      if (this.ZSv != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZSv);
      }
      paramInt = i;
      if (this.ZSw != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZSw);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.ZSx);
      paramInt = i;
      if (this.ZSy != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZSy);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.ZSz);
      paramInt = i;
      if (this.ZSA != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZSA);
      }
      i = i.a.a.b.b.a.cJ(12, this.ZSB);
      int j = i.a.a.b.b.a.cJ(13, this.ZSC);
      int k = i.a.a.b.b.a.cJ(14, this.ZSD);
      AppMethodBeat.o(260177);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260177);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      biw localbiw = (biw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260177);
        return -1;
      case 1: 
        localbiw.ZSr = locala.ajGk.aar();
        AppMethodBeat.o(260177);
        return 0;
      case 2: 
        localbiw.ZSs = locala.ajGk.readString();
        AppMethodBeat.o(260177);
        return 0;
      case 3: 
        localbiw.ZSt = locala.ajGk.readString();
        AppMethodBeat.o(260177);
        return 0;
      case 4: 
        localbiw.ZSu = locala.ajGk.aar();
        AppMethodBeat.o(260177);
        return 0;
      case 5: 
        localbiw.YIJ = locala.ajGk.readString();
        AppMethodBeat.o(260177);
        return 0;
      case 6: 
        localbiw.ZSv = locala.ajGk.readString();
        AppMethodBeat.o(260177);
        return 0;
      case 7: 
        localbiw.ZSw = locala.ajGk.readString();
        AppMethodBeat.o(260177);
        return 0;
      case 8: 
        localbiw.ZSx = locala.ajGk.aar();
        AppMethodBeat.o(260177);
        return 0;
      case 9: 
        localbiw.ZSy = locala.ajGk.readString();
        AppMethodBeat.o(260177);
        return 0;
      case 10: 
        localbiw.ZSz = locala.ajGk.aar();
        AppMethodBeat.o(260177);
        return 0;
      case 11: 
        localbiw.ZSA = locala.ajGk.readString();
        AppMethodBeat.o(260177);
        return 0;
      case 12: 
        localbiw.ZSB = locala.ajGk.aar();
        AppMethodBeat.o(260177);
        return 0;
      case 13: 
        localbiw.ZSC = locala.ajGk.aar();
        AppMethodBeat.o(260177);
        return 0;
      }
      localbiw.ZSD = locala.ajGk.aar();
      AppMethodBeat.o(260177);
      return 0;
    }
    AppMethodBeat.o(260177);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biw
 * JD-Core Version:    0.7.0.1
 */