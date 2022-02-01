package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cal
  extends com.tencent.mm.bx.a
{
  public int GUG;
  public String GUK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43111);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GUK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactUsername");
        AppMethodBeat.o(43111);
        throw paramVarArgs;
      }
      if (this.GUK != null) {
        paramVarArgs.d(1, this.GUK);
      }
      paramVarArgs.aS(2, this.GUG);
      AppMethodBeat.o(43111);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GUK == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.GUK) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GUG);
      AppMethodBeat.o(43111);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GUK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactUsername");
          AppMethodBeat.o(43111);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43111);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cal localcal = (cal)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43111);
          return -1;
        case 1: 
          localcal.GUK = locala.NPN.readString();
          AppMethodBeat.o(43111);
          return 0;
        }
        localcal.GUG = locala.NPN.zc();
        AppMethodBeat.o(43111);
        return 0;
      }
      AppMethodBeat.o(43111);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cal
 * JD-Core Version:    0.7.0.1
 */