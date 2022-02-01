package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public class bnm
  extends com.tencent.mm.bx.a
{
  public b ZTU;
  public int ZVV;
  public int ZVW;
  public int ZVX;
  public int ZVY;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258614);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.id);
      paramVarArgs.bS(2, this.ZVV);
      if (this.ZTU != null) {
        paramVarArgs.d(3, this.ZTU);
      }
      paramVarArgs.bS(4, this.ZVW);
      paramVarArgs.bS(5, this.ZVX);
      paramVarArgs.bS(6, this.ZVY);
      AppMethodBeat.o(258614);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.id) + 0 + i.a.a.b.b.a.cJ(2, this.ZVV);
      paramInt = i;
      if (this.ZTU != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZTU);
      }
      i = i.a.a.b.b.a.cJ(4, this.ZVW);
      int j = i.a.a.b.b.a.cJ(5, this.ZVX);
      int k = i.a.a.b.b.a.cJ(6, this.ZVY);
      AppMethodBeat.o(258614);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258614);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bnm localbnm = (bnm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258614);
        return -1;
      case 1: 
        localbnm.id = locala.ajGk.aaw();
        AppMethodBeat.o(258614);
        return 0;
      case 2: 
        localbnm.ZVV = locala.ajGk.aar();
        AppMethodBeat.o(258614);
        return 0;
      case 3: 
        localbnm.ZTU = locala.ajGk.kFX();
        AppMethodBeat.o(258614);
        return 0;
      case 4: 
        localbnm.ZVW = locala.ajGk.aar();
        AppMethodBeat.o(258614);
        return 0;
      case 5: 
        localbnm.ZVX = locala.ajGk.aar();
        AppMethodBeat.o(258614);
        return 0;
      }
      localbnm.ZVY = locala.ajGk.aar();
      AppMethodBeat.o(258614);
      return 0;
    }
    AppMethodBeat.o(258614);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnm
 * JD-Core Version:    0.7.0.1
 */