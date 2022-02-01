package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddv
  extends com.tencent.mm.bx.a
{
  public String Hsm;
  public String duW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153300);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      if (this.Hsm != null) {
        paramVarArgs.d(2, this.Hsm);
      }
      AppMethodBeat.o(153300);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.duW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hsm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hsm);
      }
      AppMethodBeat.o(153300);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153300);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ddv localddv = (ddv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153300);
          return -1;
        case 1: 
          localddv.duW = locala.NPN.readString();
          AppMethodBeat.o(153300);
          return 0;
        }
        localddv.Hsm = locala.NPN.readString();
        AppMethodBeat.o(153300);
        return 0;
      }
      AppMethodBeat.o(153300);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddv
 * JD-Core Version:    0.7.0.1
 */