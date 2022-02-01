package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bxn
  extends com.tencent.mm.bx.a
{
  public long bpc;
  public String path;
  public long start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215804);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(215804);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.d(1, this.path);
      }
      paramVarArgs.aY(2, this.start);
      paramVarArgs.aY(3, this.bpc);
      AppMethodBeat.o(215804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.b.b.a.e(1, this.path) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.start);
      int j = f.a.a.b.b.a.p(3, this.bpc);
      AppMethodBeat.o(215804);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(215804);
          throw paramVarArgs;
        }
        AppMethodBeat.o(215804);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxn localbxn = (bxn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(215804);
          return -1;
        case 1: 
          localbxn.path = locala.NPN.readString();
          AppMethodBeat.o(215804);
          return 0;
        case 2: 
          localbxn.start = locala.NPN.zd();
          AppMethodBeat.o(215804);
          return 0;
        }
        localbxn.bpc = locala.NPN.zd();
        AppMethodBeat.o(215804);
        return 0;
      }
      AppMethodBeat.o(215804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxn
 * JD-Core Version:    0.7.0.1
 */