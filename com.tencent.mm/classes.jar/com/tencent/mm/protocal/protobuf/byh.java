package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class byh
  extends com.tencent.mm.bw.a
{
  public long bpc;
  public String path;
  public long start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(212475);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.d(1, this.path);
      }
      paramVarArgs.aZ(2, this.start);
      paramVarArgs.aZ(3, this.bpc);
      AppMethodBeat.o(212475);
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
      AppMethodBeat.o(212475);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(212475);
          throw paramVarArgs;
        }
        AppMethodBeat.o(212475);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byh localbyh = (byh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212475);
          return -1;
        case 1: 
          localbyh.path = locala.OmT.readString();
          AppMethodBeat.o(212475);
          return 0;
        case 2: 
          localbyh.start = locala.OmT.zd();
          AppMethodBeat.o(212475);
          return 0;
        }
        localbyh.bpc = locala.OmT.zd();
        AppMethodBeat.o(212475);
        return 0;
      }
      AppMethodBeat.o(212475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byh
 * JD-Core Version:    0.7.0.1
 */