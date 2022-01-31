package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfj
  extends com.tencent.mm.bv.a
{
  public int gxa;
  public String gxb;
  public long gxc;
  public int xPN;
  public int xPO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60070);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.gxa);
      if (this.gxb != null) {
        paramVarArgs.e(2, this.gxb);
      }
      paramVarArgs.am(3, this.gxc);
      paramVarArgs.aO(4, this.xPN);
      paramVarArgs.aO(5, this.xPO);
      AppMethodBeat.o(60070);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.gxa) + 0;
      paramInt = i;
      if (this.gxb != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.gxb);
      }
      i = e.a.a.b.b.a.p(3, this.gxc);
      int j = e.a.a.b.b.a.bl(4, this.xPN);
      int k = e.a.a.b.b.a.bl(5, this.xPO);
      AppMethodBeat.o(60070);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(60070);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cfj localcfj = (cfj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(60070);
        return -1;
      case 1: 
        localcfj.gxa = locala.CLY.sl();
        AppMethodBeat.o(60070);
        return 0;
      case 2: 
        localcfj.gxb = locala.CLY.readString();
        AppMethodBeat.o(60070);
        return 0;
      case 3: 
        localcfj.gxc = locala.CLY.sm();
        AppMethodBeat.o(60070);
        return 0;
      case 4: 
        localcfj.xPN = locala.CLY.sl();
        AppMethodBeat.o(60070);
        return 0;
      }
      localcfj.xPO = locala.CLY.sl();
      AppMethodBeat.o(60070);
      return 0;
    }
    AppMethodBeat.o(60070);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfj
 * JD-Core Version:    0.7.0.1
 */