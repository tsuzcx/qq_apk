package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehr
  extends com.tencent.mm.bx.a
{
  public String GLe;
  public String HSj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123709);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HSj != null) {
        paramVarArgs.d(1, this.HSj);
      }
      if (this.GLe != null) {
        paramVarArgs.d(2, this.GLe);
      }
      AppMethodBeat.o(123709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HSj == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.HSj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GLe != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GLe);
      }
      AppMethodBeat.o(123709);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123709);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ehr localehr = (ehr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123709);
          return -1;
        case 1: 
          localehr.HSj = locala.NPN.readString();
          AppMethodBeat.o(123709);
          return 0;
        }
        localehr.GLe = locala.NPN.readString();
        AppMethodBeat.o(123709);
        return 0;
      }
      AppMethodBeat.o(123709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehr
 * JD-Core Version:    0.7.0.1
 */