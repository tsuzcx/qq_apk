package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bd
  extends com.tencent.mm.bx.a
{
  public boolean FsK;
  public boolean FsL;
  public int FsM;
  public boolean FsN;
  public b FsO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123537);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.FsK);
      paramVarArgs.bt(2, this.FsL);
      paramVarArgs.aS(3, this.FsM);
      paramVarArgs.bt(4, this.FsN);
      if (this.FsO != null) {
        paramVarArgs.c(5, this.FsO);
      }
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0 + f.a.a.b.b.a.alV(2) + f.a.a.b.b.a.bz(3, this.FsM) + f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.FsO != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.FsO);
      }
      AppMethodBeat.o(123537);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bd localbd = (bd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123537);
        return -1;
      case 1: 
        localbd.FsK = locala.NPN.grw();
        AppMethodBeat.o(123537);
        return 0;
      case 2: 
        localbd.FsL = locala.NPN.grw();
        AppMethodBeat.o(123537);
        return 0;
      case 3: 
        localbd.FsM = locala.NPN.zc();
        AppMethodBeat.o(123537);
        return 0;
      case 4: 
        localbd.FsN = locala.NPN.grw();
        AppMethodBeat.o(123537);
        return 0;
      }
      localbd.FsO = locala.NPN.gxI();
      AppMethodBeat.o(123537);
      return 0;
    }
    AppMethodBeat.o(123537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bd
 * JD-Core Version:    0.7.0.1
 */