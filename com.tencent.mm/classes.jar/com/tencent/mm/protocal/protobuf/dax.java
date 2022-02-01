package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dax
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b GNb;
  public com.tencent.mm.bx.b HqP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117924);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HqP == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Name");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.GNb == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Value");
        AppMethodBeat.o(117924);
        throw paramVarArgs;
      }
      if (this.HqP != null) {
        paramVarArgs.c(1, this.HqP);
      }
      if (this.GNb != null) {
        paramVarArgs.c(2, this.GNb);
      }
      AppMethodBeat.o(117924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HqP == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.b(1, this.HqP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GNb != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.GNb);
      }
      AppMethodBeat.o(117924);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HqP == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Name");
          AppMethodBeat.o(117924);
          throw paramVarArgs;
        }
        if (this.GNb == null)
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
        dax localdax = (dax)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117924);
          return -1;
        case 1: 
          localdax.HqP = locala.NPN.gxI();
          AppMethodBeat.o(117924);
          return 0;
        }
        localdax.GNb = locala.NPN.gxI();
        AppMethodBeat.o(117924);
        return 0;
      }
      AppMethodBeat.o(117924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dax
 * JD-Core Version:    0.7.0.1
 */