package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnh
  extends com.tencent.mm.bw.a
{
  public String Hzq;
  public int Hzr;
  public String dyI;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104374);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyI != null) {
        paramVarArgs.d(1, this.dyI);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.Hzq != null) {
        paramVarArgs.d(3, this.Hzq);
      }
      paramVarArgs.aS(4, this.Hzr);
      AppMethodBeat.o(104374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyI == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.dyI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.Hzq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hzq);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Hzr);
      AppMethodBeat.o(104374);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104374);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cnh localcnh = (cnh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104374);
          return -1;
        case 1: 
          localcnh.dyI = locala.OmT.readString();
          AppMethodBeat.o(104374);
          return 0;
        case 2: 
          localcnh.url = locala.OmT.readString();
          AppMethodBeat.o(104374);
          return 0;
        case 3: 
          localcnh.Hzq = locala.OmT.readString();
          AppMethodBeat.o(104374);
          return 0;
        }
        localcnh.Hzr = locala.OmT.zc();
        AppMethodBeat.o(104374);
        return 0;
      }
      AppMethodBeat.o(104374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnh
 * JD-Core Version:    0.7.0.1
 */