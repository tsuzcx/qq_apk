package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bnp
  extends com.tencent.mm.bx.a
{
  public b ZWn;
  public String ZWo;
  public int infoType;
  public int oUj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258620);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.infoType);
      if (this.ZWn != null) {
        paramVarArgs.d(2, this.ZWn);
      }
      if (this.ZWo != null) {
        paramVarArgs.g(3, this.ZWo);
      }
      paramVarArgs.bS(4, this.oUj);
      AppMethodBeat.o(258620);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.infoType) + 0;
      paramInt = i;
      if (this.ZWn != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZWn);
      }
      i = paramInt;
      if (this.ZWo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZWo);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.oUj);
      AppMethodBeat.o(258620);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258620);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bnp localbnp = (bnp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258620);
        return -1;
      case 1: 
        localbnp.infoType = locala.ajGk.aar();
        AppMethodBeat.o(258620);
        return 0;
      case 2: 
        localbnp.ZWn = locala.ajGk.kFX();
        AppMethodBeat.o(258620);
        return 0;
      case 3: 
        localbnp.ZWo = locala.ajGk.readString();
        AppMethodBeat.o(258620);
        return 0;
      }
      localbnp.oUj = locala.ajGk.aar();
      AppMethodBeat.o(258620);
      return 0;
    }
    AppMethodBeat.o(258620);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnp
 * JD-Core Version:    0.7.0.1
 */