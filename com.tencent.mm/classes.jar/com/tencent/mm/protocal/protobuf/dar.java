package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class dar
  extends com.tencent.mm.bv.a
{
  public int ygW;
  public boolean ygX;
  public String ygY;
  public b ygZ;
  public int yha;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143703);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ygX);
      paramVarArgs.aO(2, this.ygW);
      if (this.ygY != null) {
        paramVarArgs.e(3, this.ygY);
      }
      if (this.ygZ != null) {
        paramVarArgs.c(4, this.ygZ);
      }
      paramVarArgs.aO(5, this.yha);
      AppMethodBeat.o(143703);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 1 + 0 + e.a.a.b.b.a.bl(2, this.ygW);
      paramInt = i;
      if (this.ygY != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.ygY);
      }
      i = paramInt;
      if (this.ygZ != null) {
        i = paramInt + e.a.a.b.b.a.b(4, this.ygZ);
      }
      paramInt = e.a.a.b.b.a.bl(5, this.yha);
      AppMethodBeat.o(143703);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(143703);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dar localdar = (dar)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143703);
        return -1;
      case 1: 
        localdar.ygX = locala.CLY.emu();
        AppMethodBeat.o(143703);
        return 0;
      case 2: 
        localdar.ygW = locala.CLY.sl();
        AppMethodBeat.o(143703);
        return 0;
      case 3: 
        localdar.ygY = locala.CLY.readString();
        AppMethodBeat.o(143703);
        return 0;
      case 4: 
        localdar.ygZ = locala.CLY.eqS();
        AppMethodBeat.o(143703);
        return 0;
      }
      localdar.yha = locala.CLY.sl();
      AppMethodBeat.o(143703);
      return 0;
    }
    AppMethodBeat.o(143703);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dar
 * JD-Core Version:    0.7.0.1
 */