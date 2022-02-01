package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acr
  extends com.tencent.mm.bw.a
{
  public String FXs;
  public String data;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.data != null) {
        paramVarArgs.d(1, this.data);
      }
      if (this.FXs != null) {
        paramVarArgs.d(2, this.FXs);
      }
      AppMethodBeat.o(123567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.data == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.data) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FXs != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FXs);
      }
      AppMethodBeat.o(123567);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123567);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        acr localacr = (acr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123567);
          return -1;
        case 1: 
          localacr.data = locala.OmT.readString();
          AppMethodBeat.o(123567);
          return 0;
        }
        localacr.FXs = locala.OmT.readString();
        AppMethodBeat.o(123567);
        return 0;
      }
      AppMethodBeat.o(123567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acr
 * JD-Core Version:    0.7.0.1
 */