package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dfp
  extends com.tencent.mm.bw.a
{
  public int FUF;
  public String ProductID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104838);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104838);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.d(1, this.ProductID);
      }
      paramVarArgs.aS(2, this.FUF);
      AppMethodBeat.o(104838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.ProductID) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FUF);
      AppMethodBeat.o(104838);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(104838);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104838);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dfp localdfp = (dfp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104838);
          return -1;
        case 1: 
          localdfp.ProductID = locala.OmT.readString();
          AppMethodBeat.o(104838);
          return 0;
        }
        localdfp.FUF = locala.OmT.zc();
        AppMethodBeat.o(104838);
        return 0;
      }
      AppMethodBeat.o(104838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfp
 * JD-Core Version:    0.7.0.1
 */