package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyu
  extends com.tencent.mm.bw.a
{
  public String Lso;
  public int MDN;
  public int MDO;
  public int MDP;
  public long MDQ;
  public int MDR;
  public int MDS;
  public String xNU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104825);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MDN);
      paramVarArgs.aM(2, this.MDO);
      paramVarArgs.aM(3, this.MDP);
      if (this.xNU != null) {
        paramVarArgs.e(4, this.xNU);
      }
      paramVarArgs.bb(5, this.MDQ);
      paramVarArgs.aM(6, this.MDR);
      if (this.Lso != null) {
        paramVarArgs.e(7, this.Lso);
      }
      paramVarArgs.aM(8, this.MDS);
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MDN) + 0 + g.a.a.b.b.a.bu(2, this.MDO) + g.a.a.b.b.a.bu(3, this.MDP);
      paramInt = i;
      if (this.xNU != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xNU);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.MDQ) + g.a.a.b.b.a.bu(6, this.MDR);
      paramInt = i;
      if (this.Lso != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Lso);
      }
      i = g.a.a.b.b.a.bu(8, this.MDS);
      AppMethodBeat.o(104825);
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
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cyu localcyu = (cyu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104825);
        return -1;
      case 1: 
        localcyu.MDN = locala.UbS.zi();
        AppMethodBeat.o(104825);
        return 0;
      case 2: 
        localcyu.MDO = locala.UbS.zi();
        AppMethodBeat.o(104825);
        return 0;
      case 3: 
        localcyu.MDP = locala.UbS.zi();
        AppMethodBeat.o(104825);
        return 0;
      case 4: 
        localcyu.xNU = locala.UbS.readString();
        AppMethodBeat.o(104825);
        return 0;
      case 5: 
        localcyu.MDQ = locala.UbS.zl();
        AppMethodBeat.o(104825);
        return 0;
      case 6: 
        localcyu.MDR = locala.UbS.zi();
        AppMethodBeat.o(104825);
        return 0;
      case 7: 
        localcyu.Lso = locala.UbS.readString();
        AppMethodBeat.o(104825);
        return 0;
      }
      localcyu.MDS = locala.UbS.zi();
      AppMethodBeat.o(104825);
      return 0;
    }
    AppMethodBeat.o(104825);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyu
 * JD-Core Version:    0.7.0.1
 */