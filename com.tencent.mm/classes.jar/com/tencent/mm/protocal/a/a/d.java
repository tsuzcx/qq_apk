package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bv.a
{
  public int count;
  public int qNK;
  public int wjb;
  public com.tencent.mm.bv.b wjk;
  public int wjl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72819);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wjk == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(72819);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.wjb);
      if (this.wjk != null) {
        paramVarArgs.c(2, this.wjk);
      }
      paramVarArgs.aO(3, this.wjl);
      paramVarArgs.aO(4, this.qNK);
      paramVarArgs.aO(5, this.count);
      AppMethodBeat.o(72819);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wjb) + 0;
      paramInt = i;
      if (this.wjk != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.wjk);
      }
      i = e.a.a.b.b.a.bl(3, this.wjl);
      int j = e.a.a.b.b.a.bl(4, this.qNK);
      int k = e.a.a.b.b.a.bl(5, this.count);
      AppMethodBeat.o(72819);
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
      if (this.wjk == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(72819);
        throw paramVarArgs;
      }
      AppMethodBeat.o(72819);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72819);
        return -1;
      case 1: 
        locald.wjb = locala.CLY.sl();
        AppMethodBeat.o(72819);
        return 0;
      case 2: 
        locald.wjk = locala.CLY.eqS();
        AppMethodBeat.o(72819);
        return 0;
      case 3: 
        locald.wjl = locala.CLY.sl();
        AppMethodBeat.o(72819);
        return 0;
      case 4: 
        locald.qNK = locala.CLY.sl();
        AppMethodBeat.o(72819);
        return 0;
      }
      locald.count = locala.CLY.sl();
      AppMethodBeat.o(72819);
      return 0;
    }
    AppMethodBeat.o(72819);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.d
 * JD-Core Version:    0.7.0.1
 */