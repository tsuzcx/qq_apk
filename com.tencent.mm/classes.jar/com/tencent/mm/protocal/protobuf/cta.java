package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cta
  extends com.tencent.mm.bx.a
{
  public int EkH;
  public int EkI;
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
      paramVarArgs.aR(2, this.EkH);
      paramVarArgs.aR(3, this.EkI);
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
      int i = f.a.a.b.b.a.bA(2, this.EkH);
      int j = f.a.a.b.b.a.bA(3, this.EkI);
      AppMethodBeat.o(152694);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152694);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cta localcta = (cta)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152694);
          return -1;
        case 1: 
          localcta.url = locala.KhF.readString();
          AppMethodBeat.o(152694);
          return 0;
        case 2: 
          localcta.EkH = locala.KhF.xS();
          AppMethodBeat.o(152694);
          return 0;
        }
        localcta.EkI = locala.KhF.xS();
        AppMethodBeat.o(152694);
        return 0;
      }
      AppMethodBeat.o(152694);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cta
 * JD-Core Version:    0.7.0.1
 */