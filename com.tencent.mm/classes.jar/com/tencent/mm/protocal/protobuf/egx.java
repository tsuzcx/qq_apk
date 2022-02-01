package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egx
  extends com.tencent.mm.bx.a
{
  public String HRH;
  public int HRI;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123704);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HRH != null) {
        paramVarArgs.d(1, this.HRH);
      }
      paramVarArgs.aS(2, this.scene);
      paramVarArgs.aS(3, this.HRI);
      AppMethodBeat.o(123704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HRH == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.HRH) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.scene);
      int j = f.a.a.b.b.a.bz(3, this.HRI);
      AppMethodBeat.o(123704);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123704);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        egx localegx = (egx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123704);
          return -1;
        case 1: 
          localegx.HRH = locala.NPN.readString();
          AppMethodBeat.o(123704);
          return 0;
        case 2: 
          localegx.scene = locala.NPN.zc();
          AppMethodBeat.o(123704);
          return 0;
        }
        localegx.HRI = locala.NPN.zc();
        AppMethodBeat.o(123704);
        return 0;
      }
      AppMethodBeat.o(123704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egx
 * JD-Core Version:    0.7.0.1
 */