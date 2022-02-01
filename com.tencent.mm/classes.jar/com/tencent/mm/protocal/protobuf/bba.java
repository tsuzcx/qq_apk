package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bba
  extends com.tencent.mm.bw.a
{
  public String GRa;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104789);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GRa == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityId");
        AppMethodBeat.o(104789);
        throw paramVarArgs;
      }
      if (this.GRa != null) {
        paramVarArgs.d(1, this.GRa);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(2, this.Md5);
      }
      AppMethodBeat.o(104789);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GRa == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.GRa) + 0;; paramInt = 0)
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
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GRa == null)
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
        bba localbba = (bba)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104789);
          return -1;
        case 1: 
          localbba.GRa = locala.OmT.readString();
          AppMethodBeat.o(104789);
          return 0;
        }
        localbba.Md5 = locala.OmT.readString();
        AppMethodBeat.o(104789);
        return 0;
      }
      AppMethodBeat.o(104789);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bba
 * JD-Core Version:    0.7.0.1
 */