package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mc
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public String kXm;
  public int qUB;
  public String wAA;
  public int wAB;
  public int wAC;
  public int wAD;
  public String wAE;
  public int wAx;
  public int wAy;
  public int wAz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124290);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc != null) {
        paramVarArgs.e(1, this.cwc);
      }
      paramVarArgs.aO(2, this.wAx);
      paramVarArgs.aO(3, this.wAy);
      if (this.kXm != null) {
        paramVarArgs.e(4, this.kXm);
      }
      paramVarArgs.aO(5, this.wAz);
      if (this.wAA != null) {
        paramVarArgs.e(6, this.wAA);
      }
      paramVarArgs.aO(7, this.wAB);
      paramVarArgs.aO(8, this.wAC);
      paramVarArgs.aO(9, this.wAD);
      if (this.wAE != null) {
        paramVarArgs.e(10, this.wAE);
      }
      paramVarArgs.aO(15, this.qUB);
      AppMethodBeat.o(124290);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cwc == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = e.a.a.b.b.a.f(1, this.cwc) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wAx) + e.a.a.b.b.a.bl(3, this.wAy);
      paramInt = i;
      if (this.kXm != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kXm);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wAz);
      paramInt = i;
      if (this.wAA != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wAA);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.wAB) + e.a.a.b.b.a.bl(8, this.wAC) + e.a.a.b.b.a.bl(9, this.wAD);
      paramInt = i;
      if (this.wAE != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wAE);
      }
      i = e.a.a.b.b.a.bl(15, this.qUB);
      AppMethodBeat.o(124290);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124290);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        mc localmc = (mc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        default: 
          AppMethodBeat.o(124290);
          return -1;
        case 1: 
          localmc.cwc = locala.CLY.readString();
          AppMethodBeat.o(124290);
          return 0;
        case 2: 
          localmc.wAx = locala.CLY.sl();
          AppMethodBeat.o(124290);
          return 0;
        case 3: 
          localmc.wAy = locala.CLY.sl();
          AppMethodBeat.o(124290);
          return 0;
        case 4: 
          localmc.kXm = locala.CLY.readString();
          AppMethodBeat.o(124290);
          return 0;
        case 5: 
          localmc.wAz = locala.CLY.sl();
          AppMethodBeat.o(124290);
          return 0;
        case 6: 
          localmc.wAA = locala.CLY.readString();
          AppMethodBeat.o(124290);
          return 0;
        case 7: 
          localmc.wAB = locala.CLY.sl();
          AppMethodBeat.o(124290);
          return 0;
        case 8: 
          localmc.wAC = locala.CLY.sl();
          AppMethodBeat.o(124290);
          return 0;
        case 9: 
          localmc.wAD = locala.CLY.sl();
          AppMethodBeat.o(124290);
          return 0;
        case 10: 
          localmc.wAE = locala.CLY.readString();
          AppMethodBeat.o(124290);
          return 0;
        }
        localmc.qUB = locala.CLY.sl();
        AppMethodBeat.o(124290);
        return 0;
      }
      AppMethodBeat.o(124290);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mc
 * JD-Core Version:    0.7.0.1
 */