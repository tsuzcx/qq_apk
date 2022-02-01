package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bre
  extends com.tencent.mm.bx.a
{
  public int DOH;
  public String DOL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43111);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DOL == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactUsername");
        AppMethodBeat.o(43111);
        throw paramVarArgs;
      }
      if (this.DOL != null) {
        paramVarArgs.d(1, this.DOL);
      }
      paramVarArgs.aR(2, this.DOH);
      AppMethodBeat.o(43111);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DOL == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.DOL) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DOH);
      AppMethodBeat.o(43111);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DOL == null)
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
        bre localbre = (bre)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43111);
          return -1;
        case 1: 
          localbre.DOL = locala.KhF.readString();
          AppMethodBeat.o(43111);
          return 0;
        }
        localbre.DOH = locala.KhF.xS();
        AppMethodBeat.o(43111);
        return 0;
      }
      AppMethodBeat.o(43111);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bre
 * JD-Core Version:    0.7.0.1
 */