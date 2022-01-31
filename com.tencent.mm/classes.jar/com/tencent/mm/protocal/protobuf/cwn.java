package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cwn
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String jKG;
  public int jKs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28718);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(28718);
        throw paramVarArgs;
      }
      if (this.jKG == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(28718);
        throw paramVarArgs;
      }
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      paramVarArgs.aO(3, this.jKs);
      AppMethodBeat.o(28718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jKG != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jKG);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.jKs);
      AppMethodBeat.o(28718);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jJA == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(28718);
          throw paramVarArgs;
        }
        if (this.jKG == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(28718);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28718);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cwn localcwn = (cwn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28718);
          return -1;
        case 1: 
          localcwn.jJA = locala.CLY.readString();
          AppMethodBeat.o(28718);
          return 0;
        case 2: 
          localcwn.jKG = locala.CLY.readString();
          AppMethodBeat.o(28718);
          return 0;
        }
        localcwn.jKs = locala.CLY.sl();
        AppMethodBeat.o(28718);
        return 0;
      }
      AppMethodBeat.o(28718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwn
 * JD-Core Version:    0.7.0.1
 */