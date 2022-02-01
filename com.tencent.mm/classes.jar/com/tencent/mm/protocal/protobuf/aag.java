package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aag
  extends com.tencent.mm.bx.a
{
  public long FZe;
  public String FZf;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152990);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(152990);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      paramVarArgs.aY(2, this.FZe);
      if (this.FZf != null) {
        paramVarArgs.d(3, this.FZf);
      }
      AppMethodBeat.o(152990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.FZe);
      paramInt = i;
      if (this.FZf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FZf);
      }
      AppMethodBeat.o(152990);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(152990);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152990);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aag localaag = (aag)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152990);
          return -1;
        case 1: 
          localaag.key = locala.NPN.readString();
          AppMethodBeat.o(152990);
          return 0;
        case 2: 
          localaag.FZe = locala.NPN.zd();
          AppMethodBeat.o(152990);
          return 0;
        }
        localaag.FZf = locala.NPN.readString();
        AppMethodBeat.o(152990);
        return 0;
      }
      AppMethodBeat.o(152990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aag
 * JD-Core Version:    0.7.0.1
 */