package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnd
  extends com.tencent.mm.bx.a
{
  public String HfS;
  public String HfT;
  public String ozD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209417);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HfS != null) {
        paramVarArgs.d(1, this.HfS);
      }
      if (this.HfT != null) {
        paramVarArgs.d(2, this.HfT);
      }
      if (this.ozD != null) {
        paramVarArgs.d(3, this.ozD);
      }
      AppMethodBeat.o(209417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HfS == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.HfS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HfT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HfT);
      }
      i = paramInt;
      if (this.ozD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ozD);
      }
      AppMethodBeat.o(209417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209417);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dnd localdnd = (dnd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209417);
          return -1;
        case 1: 
          localdnd.HfS = locala.NPN.readString();
          AppMethodBeat.o(209417);
          return 0;
        case 2: 
          localdnd.HfT = locala.NPN.readString();
          AppMethodBeat.o(209417);
          return 0;
        }
        localdnd.ozD = locala.NPN.readString();
        AppMethodBeat.o(209417);
        return 0;
      }
      AppMethodBeat.o(209417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnd
 * JD-Core Version:    0.7.0.1
 */