package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ip
  extends com.tencent.mm.bx.a
{
  public b CEh;
  public b CEi;
  public int CEj;
  public b CEk;
  public int Scene;
  public int oXh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CEh != null) {
        paramVarArgs.c(1, this.CEh);
      }
      paramVarArgs.aR(2, this.oXh);
      if (this.CEi != null) {
        paramVarArgs.c(3, this.CEi);
      }
      paramVarArgs.aR(4, this.CEj);
      if (this.CEk != null) {
        paramVarArgs.c(5, this.CEk);
      }
      paramVarArgs.aR(6, this.Scene);
      AppMethodBeat.o(133156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CEh == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.b(1, this.CEh) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.oXh);
      paramInt = i;
      if (this.CEi != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.CEi);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.CEj);
      paramInt = i;
      if (this.CEk != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.CEk);
      }
      i = f.a.a.b.b.a.bA(6, this.Scene);
      AppMethodBeat.o(133156);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(133156);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ip localip = (ip)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133156);
          return -1;
        case 1: 
          localip.CEh = locala.KhF.fMu();
          AppMethodBeat.o(133156);
          return 0;
        case 2: 
          localip.oXh = locala.KhF.xS();
          AppMethodBeat.o(133156);
          return 0;
        case 3: 
          localip.CEi = locala.KhF.fMu();
          AppMethodBeat.o(133156);
          return 0;
        case 4: 
          localip.CEj = locala.KhF.xS();
          AppMethodBeat.o(133156);
          return 0;
        case 5: 
          localip.CEk = locala.KhF.fMu();
          AppMethodBeat.o(133156);
          return 0;
        }
        localip.Scene = locala.KhF.xS();
        AppMethodBeat.o(133156);
        return 0;
      }
      AppMethodBeat.o(133156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ip
 * JD-Core Version:    0.7.0.1
 */