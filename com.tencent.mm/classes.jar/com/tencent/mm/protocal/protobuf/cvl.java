package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvl
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b FGn;
  public com.tencent.mm.bw.b Fdy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117924);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FGn == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Name");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.Fdy == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Value");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.FGn != null) {
        paramVarArgs.c(1, this.FGn);
      }
      if (this.Fdy != null) {
        paramVarArgs.c(2, this.Fdy);
      }
      AppMethodBeat.o(117924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FGn == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.b(1, this.FGn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fdy != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.Fdy);
      }
      AppMethodBeat.o(117924);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FGn == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Name");
          AppMethodBeat.o(117924);
          throw paramVarArgs;
        }
        if (this.Fdy == null)
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
        cvl localcvl = (cvl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117924);
          return -1;
        case 1: 
          localcvl.FGn = locala.LVo.gfk();
          AppMethodBeat.o(117924);
          return 0;
        }
        localcvl.Fdy = locala.LVo.gfk();
        AppMethodBeat.o(117924);
        return 0;
      }
      AppMethodBeat.o(117924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvl
 * JD-Core Version:    0.7.0.1
 */