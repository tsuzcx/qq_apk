package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class czf
  extends com.tencent.mm.bw.a
{
  public String Gdj;
  public long Hzw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117911);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gdj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Query");
        AppMethodBeat.o(117911);
        throw paramVarArgs;
      }
      if (this.Gdj != null) {
        paramVarArgs.d(1, this.Gdj);
      }
      paramVarArgs.aZ(2, this.Hzw);
      AppMethodBeat.o(117911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gdj == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gdj) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.Hzw);
      AppMethodBeat.o(117911);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gdj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Query");
          AppMethodBeat.o(117911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117911);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        czf localczf = (czf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117911);
          return -1;
        case 1: 
          localczf.Gdj = locala.OmT.readString();
          AppMethodBeat.o(117911);
          return 0;
        }
        localczf.Hzw = locala.OmT.zd();
        AppMethodBeat.o(117911);
        return 0;
      }
      AppMethodBeat.o(117911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czf
 * JD-Core Version:    0.7.0.1
 */