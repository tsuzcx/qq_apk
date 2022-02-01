package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class bmp
  extends com.tencent.mm.bw.a
{
  public String LVq;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104789);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LVq == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityId");
        AppMethodBeat.o(104789);
        throw paramVarArgs;
      }
      if (this.LVq != null) {
        paramVarArgs.e(1, this.LVq);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(2, this.Md5);
      }
      AppMethodBeat.o(104789);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LVq == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = g.a.a.b.b.a.f(1, this.LVq) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Md5);
      }
      AppMethodBeat.o(104789);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LVq == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bmp localbmp = (bmp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104789);
          return -1;
        case 1: 
          localbmp.LVq = locala.UbS.readString();
          AppMethodBeat.o(104789);
          return 0;
        }
        localbmp.Md5 = locala.UbS.readString();
        AppMethodBeat.o(104789);
        return 0;
      }
      AppMethodBeat.o(104789);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmp
 * JD-Core Version:    0.7.0.1
 */