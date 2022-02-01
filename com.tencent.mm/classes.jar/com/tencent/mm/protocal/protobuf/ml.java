package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ml
  extends com.tencent.mm.bx.a
{
  public String gPh;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(191087);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(191087);
        throw paramVarArgs;
      }
      if (this.gPh == null)
      {
        paramVarArgs = new b("Not all required fields were included: val");
        AppMethodBeat.o(191087);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      if (this.gPh != null) {
        paramVarArgs.d(2, this.gPh);
      }
      AppMethodBeat.o(191087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gPh != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gPh);
      }
      AppMethodBeat.o(191087);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(191087);
          throw paramVarArgs;
        }
        if (this.gPh == null)
        {
          paramVarArgs = new b("Not all required fields were included: val");
          AppMethodBeat.o(191087);
          throw paramVarArgs;
        }
        AppMethodBeat.o(191087);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ml localml = (ml)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(191087);
          return -1;
        case 1: 
          localml.key = locala.KhF.readString();
          AppMethodBeat.o(191087);
          return 0;
        }
        localml.gPh = locala.KhF.readString();
        AppMethodBeat.o(191087);
        return 0;
      }
      AppMethodBeat.o(191087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ml
 * JD-Core Version:    0.7.0.1
 */