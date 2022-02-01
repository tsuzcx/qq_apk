package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bug
  extends com.tencent.mm.bx.a
{
  public String FDA;
  public String FDB;
  public String FDC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43103);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDB != null) {
        paramVarArgs.d(1, this.FDB);
      }
      if (this.FDA != null) {
        paramVarArgs.d(2, this.FDA);
      }
      if (this.FDC != null) {
        paramVarArgs.d(3, this.FDC);
      }
      AppMethodBeat.o(43103);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDB == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.FDB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FDA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FDA);
      }
      i = paramInt;
      if (this.FDC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FDC);
      }
      AppMethodBeat.o(43103);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(43103);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bug localbug = (bug)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43103);
          return -1;
        case 1: 
          localbug.FDB = locala.NPN.readString();
          AppMethodBeat.o(43103);
          return 0;
        case 2: 
          localbug.FDA = locala.NPN.readString();
          AppMethodBeat.o(43103);
          return 0;
        }
        localbug.FDC = locala.NPN.readString();
        AppMethodBeat.o(43103);
        return 0;
      }
      AppMethodBeat.o(43103);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bug
 * JD-Core Version:    0.7.0.1
 */