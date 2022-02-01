package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqe
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b DId;
  public com.tencent.mm.bx.b Ejp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117924);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ejp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Name");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.DId == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Value");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.Ejp != null) {
        paramVarArgs.c(1, this.Ejp);
      }
      if (this.DId != null) {
        paramVarArgs.c(2, this.DId);
      }
      AppMethodBeat.o(117924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ejp == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.b(1, this.Ejp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DId != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.DId);
      }
      AppMethodBeat.o(117924);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Ejp == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Name");
          AppMethodBeat.o(117924);
          throw paramVarArgs;
        }
        if (this.DId == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Value");
          AppMethodBeat.o(117924);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117924);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cqe localcqe = (cqe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117924);
          return -1;
        case 1: 
          localcqe.Ejp = locala.KhF.fMu();
          AppMethodBeat.o(117924);
          return 0;
        }
        localcqe.DId = locala.KhF.fMu();
        AppMethodBeat.o(117924);
        return 0;
      }
      AppMethodBeat.o(117924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqe
 * JD-Core Version:    0.7.0.1
 */