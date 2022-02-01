package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bex
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int KCC;
  public String KHi;
  public String KHk;
  public String LOD;
  public int LOE;
  public int LOF;
  public int LOH;
  public String UserName;
  public String iAc;
  public String xNU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149139);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHi != null) {
        paramVarArgs.e(1, this.KHi);
      }
      paramVarArgs.aM(2, this.KCC);
      paramVarArgs.aM(3, this.CreateTime);
      if (this.KHk != null) {
        paramVarArgs.e(4, this.KHk);
      }
      if (this.xNU != null) {
        paramVarArgs.e(5, this.xNU);
      }
      if (this.LOD != null) {
        paramVarArgs.e(6, this.LOD);
      }
      if (this.UserName != null) {
        paramVarArgs.e(7, this.UserName);
      }
      paramVarArgs.aM(8, this.LOE);
      if (this.iAc != null) {
        paramVarArgs.e(9, this.iAc);
      }
      paramVarArgs.aM(10, this.LOF);
      paramVarArgs.aM(11, this.LOH);
      AppMethodBeat.o(149139);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KHi == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = g.a.a.b.b.a.f(1, this.KHi) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KCC) + g.a.a.b.b.a.bu(3, this.CreateTime);
      paramInt = i;
      if (this.KHk != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KHk);
      }
      i = paramInt;
      if (this.xNU != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xNU);
      }
      paramInt = i;
      if (this.LOD != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LOD);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.UserName);
      }
      i += g.a.a.b.b.a.bu(8, this.LOE);
      paramInt = i;
      if (this.iAc != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.iAc);
      }
      i = g.a.a.b.b.a.bu(10, this.LOF);
      int j = g.a.a.b.b.a.bu(11, this.LOH);
      AppMethodBeat.o(149139);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(149139);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bex localbex = (bex)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149139);
          return -1;
        case 1: 
          localbex.KHi = locala.UbS.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 2: 
          localbex.KCC = locala.UbS.zi();
          AppMethodBeat.o(149139);
          return 0;
        case 3: 
          localbex.CreateTime = locala.UbS.zi();
          AppMethodBeat.o(149139);
          return 0;
        case 4: 
          localbex.KHk = locala.UbS.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 5: 
          localbex.xNU = locala.UbS.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 6: 
          localbex.LOD = locala.UbS.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 7: 
          localbex.UserName = locala.UbS.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 8: 
          localbex.LOE = locala.UbS.zi();
          AppMethodBeat.o(149139);
          return 0;
        case 9: 
          localbex.iAc = locala.UbS.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 10: 
          localbex.LOF = locala.UbS.zi();
          AppMethodBeat.o(149139);
          return 0;
        }
        localbex.LOH = locala.UbS.zi();
        AppMethodBeat.o(149139);
        return 0;
      }
      AppMethodBeat.o(149139);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bex
 * JD-Core Version:    0.7.0.1
 */