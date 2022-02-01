package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eji
  extends com.tencent.mm.bw.a
{
  public String HeF;
  public String Imq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123709);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Imq != null) {
        paramVarArgs.d(1, this.Imq);
      }
      if (this.HeF != null) {
        paramVarArgs.d(2, this.HeF);
      }
      AppMethodBeat.o(123709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Imq == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Imq) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HeF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HeF);
      }
      AppMethodBeat.o(123709);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123709);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eji localeji = (eji)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123709);
          return -1;
        case 1: 
          localeji.Imq = locala.OmT.readString();
          AppMethodBeat.o(123709);
          return 0;
        }
        localeji.HeF = locala.OmT.readString();
        AppMethodBeat.o(123709);
        return 0;
      }
      AppMethodBeat.o(123709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eji
 * JD-Core Version:    0.7.0.1
 */