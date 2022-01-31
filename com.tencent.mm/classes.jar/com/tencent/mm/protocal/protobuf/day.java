package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class day
  extends com.tencent.mm.bv.a
{
  public String xmJ;
  public String yhg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96345);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yhg != null) {
        paramVarArgs.e(1, this.yhg);
      }
      if (this.xmJ != null) {
        paramVarArgs.e(2, this.xmJ);
      }
      AppMethodBeat.o(96345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yhg == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.yhg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xmJ != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xmJ);
      }
      AppMethodBeat.o(96345);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96345);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        day localday = (day)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96345);
          return -1;
        case 1: 
          localday.yhg = locala.CLY.readString();
          AppMethodBeat.o(96345);
          return 0;
        }
        localday.xmJ = locala.CLY.readString();
        AppMethodBeat.o(96345);
        return 0;
      }
      AppMethodBeat.o(96345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.day
 * JD-Core Version:    0.7.0.1
 */