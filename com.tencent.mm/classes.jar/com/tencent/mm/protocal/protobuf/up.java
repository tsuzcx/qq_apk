package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class up
  extends com.tencent.mm.bv.a
{
  public String key;
  public long wMM;
  public String wMN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55699);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(55699);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      paramVarArgs.am(2, this.wMM);
      if (this.wMN != null) {
        paramVarArgs.e(3, this.wMN);
      }
      AppMethodBeat.o(55699);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = e.a.a.b.b.a.f(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.wMM);
      paramInt = i;
      if (this.wMN != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wMN);
      }
      AppMethodBeat.o(55699);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(55699);
          throw paramVarArgs;
        }
        AppMethodBeat.o(55699);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        up localup = (up)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(55699);
          return -1;
        case 1: 
          localup.key = locala.CLY.readString();
          AppMethodBeat.o(55699);
          return 0;
        case 2: 
          localup.wMM = locala.CLY.sm();
          AppMethodBeat.o(55699);
          return 0;
        }
        localup.wMN = locala.CLY.readString();
        AppMethodBeat.o(55699);
        return 0;
      }
      AppMethodBeat.o(55699);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.up
 * JD-Core Version:    0.7.0.1
 */