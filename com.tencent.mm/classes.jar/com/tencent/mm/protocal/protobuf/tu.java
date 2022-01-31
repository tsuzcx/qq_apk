package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class tu
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String jKg;
  public String nqD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63688);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqD == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(63688);
        throw paramVarArgs;
      }
      if (this.nqD != null) {
        paramVarArgs.e(1, this.nqD);
      }
      if (this.jKg != null) {
        paramVarArgs.e(2, this.jKg);
      }
      paramVarArgs.aO(3, this.Scene);
      AppMethodBeat.o(63688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqD == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = e.a.a.b.b.a.f(1, this.nqD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jKg != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jKg);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.Scene);
      AppMethodBeat.o(63688);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.nqD == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(63688);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63688);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        tu localtu = (tu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(63688);
          return -1;
        case 1: 
          localtu.nqD = locala.CLY.readString();
          AppMethodBeat.o(63688);
          return 0;
        case 2: 
          localtu.jKg = locala.CLY.readString();
          AppMethodBeat.o(63688);
          return 0;
        }
        localtu.Scene = locala.CLY.sl();
        AppMethodBeat.o(63688);
        return 0;
      }
      AppMethodBeat.o(63688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tu
 * JD-Core Version:    0.7.0.1
 */