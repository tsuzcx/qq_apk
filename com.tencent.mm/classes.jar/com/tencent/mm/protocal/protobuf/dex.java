package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dex
  extends com.tencent.mm.bx.a
{
  public b Ewx;
  public String Ewy;
  public b Ewz;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82480);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ewx != null) {
        paramVarArgs.c(1, this.Ewx);
      }
      if (this.Ewy != null) {
        paramVarArgs.d(2, this.Ewy);
      }
      if (this.Ewz != null) {
        paramVarArgs.c(3, this.Ewz);
      }
      paramVarArgs.aR(4, this.uin);
      AppMethodBeat.o(82480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ewx == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.b(1, this.Ewx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ewy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ewy);
      }
      i = paramInt;
      if (this.Ewz != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Ewz);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.uin);
      AppMethodBeat.o(82480);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82480);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dex localdex = (dex)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82480);
          return -1;
        case 1: 
          localdex.Ewx = locala.KhF.fMu();
          AppMethodBeat.o(82480);
          return 0;
        case 2: 
          localdex.Ewy = locala.KhF.readString();
          AppMethodBeat.o(82480);
          return 0;
        case 3: 
          localdex.Ewz = locala.KhF.fMu();
          AppMethodBeat.o(82480);
          return 0;
        }
        localdex.uin = locala.KhF.xS();
        AppMethodBeat.o(82480);
        return 0;
      }
      AppMethodBeat.o(82480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dex
 * JD-Core Version:    0.7.0.1
 */