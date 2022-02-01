package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfa
  extends com.tencent.mm.cd.a
{
  public long SPH;
  public int fSo;
  public String objectNonceId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199246);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SPH);
      paramVarArgs.aY(2, this.fSo);
      if (this.objectNonceId != null) {
        paramVarArgs.f(3, this.objectNonceId);
      }
      AppMethodBeat.o(199246);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.SPH) + 0 + g.a.a.b.b.a.bM(2, this.fSo);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.objectNonceId);
      }
      AppMethodBeat.o(199246);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(199246);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bfa localbfa = (bfa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(199246);
        return -1;
      case 1: 
        localbfa.SPH = locala.abFh.AN();
        AppMethodBeat.o(199246);
        return 0;
      case 2: 
        localbfa.fSo = locala.abFh.AK();
        AppMethodBeat.o(199246);
        return 0;
      }
      localbfa.objectNonceId = locala.abFh.readString();
      AppMethodBeat.o(199246);
      return 0;
    }
    AppMethodBeat.o(199246);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfa
 * JD-Core Version:    0.7.0.1
 */