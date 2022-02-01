package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bd
  extends com.tencent.mm.bw.a
{
  public boolean FLi;
  public boolean FLj;
  public int FLk;
  public boolean FLl;
  public b FLm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123537);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.FLi);
      paramVarArgs.bC(2, this.FLj);
      paramVarArgs.aS(3, this.FLk);
      paramVarArgs.bC(4, this.FLl);
      if (this.FLm != null) {
        paramVarArgs.c(5, this.FLm);
      }
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0 + f.a.a.b.b.a.amF(2) + f.a.a.b.b.a.bz(3, this.FLk) + f.a.a.b.b.a.amF(4);
      paramInt = i;
      if (this.FLm != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.FLm);
      }
      AppMethodBeat.o(123537);
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
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bd localbd = (bd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123537);
        return -1;
      case 1: 
        localbd.FLi = locala.OmT.gvY();
        AppMethodBeat.o(123537);
        return 0;
      case 2: 
        localbd.FLj = locala.OmT.gvY();
        AppMethodBeat.o(123537);
        return 0;
      case 3: 
        localbd.FLk = locala.OmT.zc();
        AppMethodBeat.o(123537);
        return 0;
      case 4: 
        localbd.FLl = locala.OmT.gvY();
        AppMethodBeat.o(123537);
        return 0;
      }
      localbd.FLm = locala.OmT.gCk();
      AppMethodBeat.o(123537);
      return 0;
    }
    AppMethodBeat.o(123537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bd
 * JD-Core Version:    0.7.0.1
 */