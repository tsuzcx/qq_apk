package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csx
  extends com.tencent.mm.bx.a
{
  public String Ekz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114078);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ekz != null) {
        paramVarArgs.d(1, this.Ekz);
      }
      AppMethodBeat.o(114078);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ekz == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ekz) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(114078);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114078);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        csx localcsx = (csx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114078);
          return -1;
        }
        localcsx.Ekz = locala.KhF.readString();
        AppMethodBeat.o(114078);
        return 0;
      }
      AppMethodBeat.o(114078);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csx
 * JD-Core Version:    0.7.0.1
 */