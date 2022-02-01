package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpj
  extends com.tencent.mm.bw.a
{
  public int DSv;
  public String EvK;
  public int FWL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152724);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DSv);
      if (this.EvK != null) {
        paramVarArgs.d(2, this.EvK);
      }
      paramVarArgs.aR(3, this.FWL);
      AppMethodBeat.o(152724);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.DSv) + 0;
      paramInt = i;
      if (this.EvK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EvK);
      }
      i = f.a.a.b.b.a.bx(3, this.FWL);
      AppMethodBeat.o(152724);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(152724);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dpj localdpj = (dpj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152724);
        return -1;
      case 1: 
        localdpj.DSv = locala.LVo.xF();
        AppMethodBeat.o(152724);
        return 0;
      case 2: 
        localdpj.EvK = locala.LVo.readString();
        AppMethodBeat.o(152724);
        return 0;
      }
      localdpj.FWL = locala.LVo.xF();
      AppMethodBeat.o(152724);
      return 0;
    }
    AppMethodBeat.o(152724);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpj
 * JD-Core Version:    0.7.0.1
 */