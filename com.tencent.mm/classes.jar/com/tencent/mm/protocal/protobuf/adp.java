package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class adp
  extends com.tencent.mm.bv.a
{
  public int jKn;
  public String wWA;
  public long wWB;
  public String wWC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63689);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wWA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(63689);
        throw paramVarArgs;
      }
      if (this.wWC == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(63689);
        throw paramVarArgs;
      }
      if (this.wWA != null) {
        paramVarArgs.e(1, this.wWA);
      }
      paramVarArgs.am(2, this.wWB);
      paramVarArgs.aO(3, this.jKn);
      if (this.wWC != null) {
        paramVarArgs.e(4, this.wWC);
      }
      AppMethodBeat.o(63689);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wWA == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = e.a.a.b.b.a.f(1, this.wWA) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.wWB) + e.a.a.b.b.a.bl(3, this.jKn);
      paramInt = i;
      if (this.wWC != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wWC);
      }
      AppMethodBeat.o(63689);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wWA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(63689);
          throw paramVarArgs;
        }
        if (this.wWC == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(63689);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63689);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        adp localadp = (adp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(63689);
          return -1;
        case 1: 
          localadp.wWA = locala.CLY.readString();
          AppMethodBeat.o(63689);
          return 0;
        case 2: 
          localadp.wWB = locala.CLY.sm();
          AppMethodBeat.o(63689);
          return 0;
        case 3: 
          localadp.jKn = locala.CLY.sl();
          AppMethodBeat.o(63689);
          return 0;
        }
        localadp.wWC = locala.CLY.readString();
        AppMethodBeat.o(63689);
        return 0;
      }
      AppMethodBeat.o(63689);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adp
 * JD-Core Version:    0.7.0.1
 */