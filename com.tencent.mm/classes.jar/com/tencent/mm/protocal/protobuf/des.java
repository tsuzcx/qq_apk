package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class des
  extends com.tencent.mm.bw.a
{
  public int HLP;
  public int HLQ;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152694);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      paramVarArgs.aS(2, this.HLP);
      paramVarArgs.aS(3, this.HLQ);
      AppMethodBeat.o(152694);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HLP);
      int j = f.a.a.b.b.a.bz(3, this.HLQ);
      AppMethodBeat.o(152694);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152694);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        des localdes = (des)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152694);
          return -1;
        case 1: 
          localdes.url = locala.OmT.readString();
          AppMethodBeat.o(152694);
          return 0;
        case 2: 
          localdes.HLP = locala.OmT.zc();
          AppMethodBeat.o(152694);
          return 0;
        }
        localdes.HLQ = locala.OmT.zc();
        AppMethodBeat.o(152694);
        return 0;
      }
      AppMethodBeat.o(152694);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.des
 * JD-Core Version:    0.7.0.1
 */