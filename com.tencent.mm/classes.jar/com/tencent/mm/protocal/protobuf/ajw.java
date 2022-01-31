package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class ajw
  extends com.tencent.mm.bv.a
{
  public String Md5;
  public String xbi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62553);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xbi == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityId");
        AppMethodBeat.o(62553);
        throw paramVarArgs;
      }
      if (this.xbi != null) {
        paramVarArgs.e(1, this.xbi);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(2, this.Md5);
      }
      AppMethodBeat.o(62553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xbi == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = e.a.a.b.b.a.f(1, this.xbi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Md5);
      }
      AppMethodBeat.o(62553);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xbi == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityId");
          AppMethodBeat.o(62553);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62553);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ajw localajw = (ajw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62553);
          return -1;
        case 1: 
          localajw.xbi = locala.CLY.readString();
          AppMethodBeat.o(62553);
          return 0;
        }
        localajw.Md5 = locala.CLY.readString();
        AppMethodBeat.o(62553);
        return 0;
      }
      AppMethodBeat.o(62553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajw
 * JD-Core Version:    0.7.0.1
 */