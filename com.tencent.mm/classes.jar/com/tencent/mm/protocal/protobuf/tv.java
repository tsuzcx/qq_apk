package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tv
  extends com.tencent.mm.bw.a
{
  public String GkK;
  public String code;
  public String dwb;
  public String oEo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113977);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oEo != null) {
        paramVarArgs.d(1, this.oEo);
      }
      if (this.code != null) {
        paramVarArgs.d(2, this.code);
      }
      if (this.GkK != null) {
        paramVarArgs.d(3, this.GkK);
      }
      if (this.dwb != null) {
        paramVarArgs.d(4, this.dwb);
      }
      AppMethodBeat.o(113977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oEo == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.oEo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.code != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.code);
      }
      i = paramInt;
      if (this.GkK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GkK);
      }
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dwb);
      }
      AppMethodBeat.o(113977);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113977);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        tv localtv = (tv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113977);
          return -1;
        case 1: 
          localtv.oEo = locala.OmT.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 2: 
          localtv.code = locala.OmT.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 3: 
          localtv.GkK = locala.OmT.readString();
          AppMethodBeat.o(113977);
          return 0;
        }
        localtv.dwb = locala.OmT.readString();
        AppMethodBeat.o(113977);
        return 0;
      }
      AppMethodBeat.o(113977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tv
 * JD-Core Version:    0.7.0.1
 */