package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dvc
  extends com.tencent.mm.bw.a
{
  public int IaM;
  public b IaN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115856);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.IaM);
      if (this.IaN != null) {
        paramVarArgs.c(2, this.IaN);
      }
      AppMethodBeat.o(115856);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.IaM) + 0;
      paramInt = i;
      if (this.IaN != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.IaN);
      }
      AppMethodBeat.o(115856);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115856);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dvc localdvc = (dvc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115856);
        return -1;
      case 1: 
        localdvc.IaM = locala.OmT.zc();
        AppMethodBeat.o(115856);
        return 0;
      }
      localdvc.IaN = locala.OmT.gCk();
      AppMethodBeat.o(115856);
      return 0;
    }
    AppMethodBeat.o(115856);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvc
 * JD-Core Version:    0.7.0.1
 */