package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class na
  extends com.tencent.mm.bx.a
{
  public String FGU;
  public String FHb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124417);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FHb != null) {
        paramVarArgs.d(2, this.FHb);
      }
      if (this.FGU != null) {
        paramVarArgs.d(3, this.FGU);
      }
      AppMethodBeat.o(124417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FHb == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(2, this.FHb) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FGU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FGU);
      }
      AppMethodBeat.o(124417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124417);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        na localna = (na)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124417);
          return -1;
        case 2: 
          localna.FHb = locala.NPN.readString();
          AppMethodBeat.o(124417);
          return 0;
        }
        localna.FGU = locala.NPN.readString();
        AppMethodBeat.o(124417);
        return 0;
      }
      AppMethodBeat.o(124417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.na
 * JD-Core Version:    0.7.0.1
 */