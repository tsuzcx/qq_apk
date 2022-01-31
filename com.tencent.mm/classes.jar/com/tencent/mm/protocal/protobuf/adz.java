package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adz
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public String jJA;
  public String ntu;
  public String nuz;
  public String wWR;
  public int wWS;
  public int wWT;
  public int wWU;
  public int wlc;
  public String woM;
  public String woO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51020);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.woM != null) {
        paramVarArgs.e(1, this.woM);
      }
      paramVarArgs.aO(2, this.wlc);
      paramVarArgs.aO(3, this.CreateTime);
      if (this.woO != null) {
        paramVarArgs.e(4, this.woO);
      }
      if (this.nuz != null) {
        paramVarArgs.e(5, this.nuz);
      }
      if (this.wWR != null) {
        paramVarArgs.e(6, this.wWR);
      }
      if (this.jJA != null) {
        paramVarArgs.e(7, this.jJA);
      }
      paramVarArgs.aO(8, this.wWS);
      if (this.ntu != null) {
        paramVarArgs.e(9, this.ntu);
      }
      paramVarArgs.aO(10, this.wWT);
      paramVarArgs.aO(11, this.wWU);
      AppMethodBeat.o(51020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.woM == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = e.a.a.b.b.a.f(1, this.woM) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wlc) + e.a.a.b.b.a.bl(3, this.CreateTime);
      paramInt = i;
      if (this.woO != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.woO);
      }
      i = paramInt;
      if (this.nuz != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nuz);
      }
      paramInt = i;
      if (this.wWR != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wWR);
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.jJA);
      }
      i += e.a.a.b.b.a.bl(8, this.wWS);
      paramInt = i;
      if (this.ntu != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.ntu);
      }
      i = e.a.a.b.b.a.bl(10, this.wWT);
      int j = e.a.a.b.b.a.bl(11, this.wWU);
      AppMethodBeat.o(51020);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51020);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        adz localadz = (adz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51020);
          return -1;
        case 1: 
          localadz.woM = locala.CLY.readString();
          AppMethodBeat.o(51020);
          return 0;
        case 2: 
          localadz.wlc = locala.CLY.sl();
          AppMethodBeat.o(51020);
          return 0;
        case 3: 
          localadz.CreateTime = locala.CLY.sl();
          AppMethodBeat.o(51020);
          return 0;
        case 4: 
          localadz.woO = locala.CLY.readString();
          AppMethodBeat.o(51020);
          return 0;
        case 5: 
          localadz.nuz = locala.CLY.readString();
          AppMethodBeat.o(51020);
          return 0;
        case 6: 
          localadz.wWR = locala.CLY.readString();
          AppMethodBeat.o(51020);
          return 0;
        case 7: 
          localadz.jJA = locala.CLY.readString();
          AppMethodBeat.o(51020);
          return 0;
        case 8: 
          localadz.wWS = locala.CLY.sl();
          AppMethodBeat.o(51020);
          return 0;
        case 9: 
          localadz.ntu = locala.CLY.readString();
          AppMethodBeat.o(51020);
          return 0;
        case 10: 
          localadz.wWT = locala.CLY.sl();
          AppMethodBeat.o(51020);
          return 0;
        }
        localadz.wWU = locala.CLY.sl();
        AppMethodBeat.o(51020);
        return 0;
      }
      AppMethodBeat.o(51020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adz
 * JD-Core Version:    0.7.0.1
 */