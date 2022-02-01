package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cak
  extends com.tencent.mm.bx.a
{
  public String DWW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43122);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DWW == null)
      {
        paramVarArgs = new b("Not all required fields were included: PhoneNum");
        AppMethodBeat.o(43122);
        throw paramVarArgs;
      }
      if (this.DWW != null) {
        paramVarArgs.d(1, this.DWW);
      }
      AppMethodBeat.o(43122);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DWW == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.DWW) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(43122);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DWW == null)
        {
          paramVarArgs = new b("Not all required fields were included: PhoneNum");
          AppMethodBeat.o(43122);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43122);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cak localcak = (cak)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43122);
          return -1;
        }
        localcak.DWW = locala.KhF.readString();
        AppMethodBeat.o(43122);
        return 0;
      }
      AppMethodBeat.o(43122);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cak
 * JD-Core Version:    0.7.0.1
 */