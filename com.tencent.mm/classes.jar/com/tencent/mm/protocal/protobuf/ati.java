package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ati
  extends com.tencent.mm.bx.a
{
  public String Dts;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104789);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dts == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityId");
        AppMethodBeat.o(104789);
        throw paramVarArgs;
      }
      if (this.Dts != null) {
        paramVarArgs.d(1, this.Dts);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(2, this.Md5);
      }
      AppMethodBeat.o(104789);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dts == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.Dts) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Md5);
      }
      AppMethodBeat.o(104789);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dts == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityId");
          AppMethodBeat.o(104789);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104789);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ati localati = (ati)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104789);
          return -1;
        case 1: 
          localati.Dts = locala.KhF.readString();
          AppMethodBeat.o(104789);
          return 0;
        }
        localati.Md5 = locala.KhF.readString();
        AppMethodBeat.o(104789);
        return 0;
      }
      AppMethodBeat.o(104789);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ati
 * JD-Core Version:    0.7.0.1
 */