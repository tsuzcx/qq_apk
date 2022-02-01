package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fw
  extends com.tencent.mm.bx.a
{
  public int Fyg;
  public String gsT;
  public String gsX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gsT != null) {
        paramVarArgs.d(1, this.gsT);
      }
      paramVarArgs.aS(2, this.Fyg);
      if (this.gsX != null) {
        paramVarArgs.d(3, this.gsX);
      }
      AppMethodBeat.o(152494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gsT == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.gsT) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Fyg);
      paramInt = i;
      if (this.gsX != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.gsX);
      }
      AppMethodBeat.o(152494);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152494);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fw localfw = (fw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152494);
          return -1;
        case 1: 
          localfw.gsT = locala.NPN.readString();
          AppMethodBeat.o(152494);
          return 0;
        case 2: 
          localfw.Fyg = locala.NPN.zc();
          AppMethodBeat.o(152494);
          return 0;
        }
        localfw.gsX = locala.NPN.readString();
        AppMethodBeat.o(152494);
        return 0;
      }
      AppMethodBeat.o(152494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fw
 * JD-Core Version:    0.7.0.1
 */