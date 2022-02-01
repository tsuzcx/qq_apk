package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afa
  extends com.tencent.mm.cd.a
{
  public int mVM;
  public String mVN;
  public String mVO;
  public String mVP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117864);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.mVM);
      if (this.mVN != null) {
        paramVarArgs.f(2, this.mVN);
      }
      if (this.mVO != null) {
        paramVarArgs.f(3, this.mVO);
      }
      if (this.mVP != null) {
        paramVarArgs.f(4, this.mVP);
      }
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.mVM) + 0;
      paramInt = i;
      if (this.mVN != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.mVN);
      }
      i = paramInt;
      if (this.mVO != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.mVO);
      }
      paramInt = i;
      if (this.mVP != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.mVP);
      }
      AppMethodBeat.o(117864);
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
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      afa localafa = (afa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117864);
        return -1;
      case 1: 
        localafa.mVM = locala.abFh.AK();
        AppMethodBeat.o(117864);
        return 0;
      case 2: 
        localafa.mVN = locala.abFh.readString();
        AppMethodBeat.o(117864);
        return 0;
      case 3: 
        localafa.mVO = locala.abFh.readString();
        AppMethodBeat.o(117864);
        return 0;
      }
      localafa.mVP = locala.abFh.readString();
      AppMethodBeat.o(117864);
      return 0;
    }
    AppMethodBeat.o(117864);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afa
 * JD-Core Version:    0.7.0.1
 */