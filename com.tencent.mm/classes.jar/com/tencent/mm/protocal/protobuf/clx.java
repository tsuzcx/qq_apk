package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class clx
  extends com.tencent.mm.bv.a
{
  public int uin;
  public b xVU;
  public String xVV;
  public b xVW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10244);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xVU != null) {
        paramVarArgs.c(1, this.xVU);
      }
      if (this.xVV != null) {
        paramVarArgs.e(2, this.xVV);
      }
      if (this.xVW != null) {
        paramVarArgs.c(3, this.xVW);
      }
      paramVarArgs.aO(4, this.uin);
      AppMethodBeat.o(10244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xVU == null) {
        break label388;
      }
    }
    label388:
    for (int i = e.a.a.b.b.a.b(1, this.xVU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xVV != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xVV);
      }
      i = paramInt;
      if (this.xVW != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.xVW);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.uin);
      AppMethodBeat.o(10244);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10244);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        clx localclx = (clx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(10244);
          return -1;
        case 1: 
          localclx.xVU = locala.CLY.eqS();
          AppMethodBeat.o(10244);
          return 0;
        case 2: 
          localclx.xVV = locala.CLY.readString();
          AppMethodBeat.o(10244);
          return 0;
        case 3: 
          localclx.xVW = locala.CLY.eqS();
          AppMethodBeat.o(10244);
          return 0;
        }
        localclx.uin = locala.CLY.sl();
        AppMethodBeat.o(10244);
        return 0;
      }
      AppMethodBeat.o(10244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clx
 * JD-Core Version:    0.7.0.1
 */