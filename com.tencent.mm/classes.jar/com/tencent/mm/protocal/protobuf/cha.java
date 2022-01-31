package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cha
  extends com.tencent.mm.bv.a
{
  public String rlS;
  public int rlT;
  public String rlU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56506);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.rlS == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(56506);
        throw paramVarArgs;
      }
      if (this.rlS != null) {
        paramVarArgs.e(1, this.rlS);
      }
      paramVarArgs.aO(2, this.rlT);
      if (this.rlU != null) {
        paramVarArgs.e(3, this.rlU);
      }
      AppMethodBeat.o(56506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rlS == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = e.a.a.b.b.a.f(1, this.rlS) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.rlT);
      paramInt = i;
      if (this.rlU != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.rlU);
      }
      AppMethodBeat.o(56506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.rlS == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(56506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56506);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cha localcha = (cha)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56506);
          return -1;
        case 1: 
          localcha.rlS = locala.CLY.readString();
          AppMethodBeat.o(56506);
          return 0;
        case 2: 
          localcha.rlT = locala.CLY.sl();
          AppMethodBeat.o(56506);
          return 0;
        }
        localcha.rlU = locala.CLY.readString();
        AppMethodBeat.o(56506);
        return 0;
      }
      AppMethodBeat.o(56506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cha
 * JD-Core Version:    0.7.0.1
 */