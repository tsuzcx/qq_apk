package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ciy
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public int xTg;
  public String xTh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114989);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(2, this.jKs);
      paramVarArgs.aO(3, this.xTg);
      if (this.xTh != null) {
        paramVarArgs.e(4, this.xTh);
      }
      AppMethodBeat.o(114989);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(2, this.jKs) + 0 + e.a.a.b.b.a.bl(3, this.xTg);
      paramInt = i;
      if (this.xTh != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xTh);
      }
      AppMethodBeat.o(114989);
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
      AppMethodBeat.o(114989);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ciy localciy = (ciy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(114989);
        return -1;
      case 2: 
        localciy.jKs = locala.CLY.sl();
        AppMethodBeat.o(114989);
        return 0;
      case 3: 
        localciy.xTg = locala.CLY.sl();
        AppMethodBeat.o(114989);
        return 0;
      }
      localciy.xTh = locala.CLY.readString();
      AppMethodBeat.o(114989);
      return 0;
    }
    AppMethodBeat.o(114989);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciy
 * JD-Core Version:    0.7.0.1
 */