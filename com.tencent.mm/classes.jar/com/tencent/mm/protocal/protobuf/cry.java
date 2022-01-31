package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class cry
  extends com.tencent.mm.bv.a
{
  public long wQQ;
  public long xSP;
  public int yaP;
  public int yaQ;
  public int yaR;
  public int yaS;
  public b yaT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135450);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.xSP);
      paramVarArgs.am(2, this.wQQ);
      paramVarArgs.aO(3, this.yaP);
      paramVarArgs.aO(4, this.yaQ);
      paramVarArgs.aO(5, this.yaR);
      paramVarArgs.aO(6, this.yaS);
      if (this.yaT != null) {
        paramVarArgs.c(7, this.yaT);
      }
      AppMethodBeat.o(135450);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.xSP) + 0 + e.a.a.b.b.a.p(2, this.wQQ) + e.a.a.b.b.a.bl(3, this.yaP) + e.a.a.b.b.a.bl(4, this.yaQ) + e.a.a.b.b.a.bl(5, this.yaR) + e.a.a.b.b.a.bl(6, this.yaS);
      paramInt = i;
      if (this.yaT != null) {
        paramInt = i + e.a.a.b.b.a.b(7, this.yaT);
      }
      AppMethodBeat.o(135450);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(135450);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cry localcry = (cry)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(135450);
        return -1;
      case 1: 
        localcry.xSP = locala.CLY.sm();
        AppMethodBeat.o(135450);
        return 0;
      case 2: 
        localcry.wQQ = locala.CLY.sm();
        AppMethodBeat.o(135450);
        return 0;
      case 3: 
        localcry.yaP = locala.CLY.sl();
        AppMethodBeat.o(135450);
        return 0;
      case 4: 
        localcry.yaQ = locala.CLY.sl();
        AppMethodBeat.o(135450);
        return 0;
      case 5: 
        localcry.yaR = locala.CLY.sl();
        AppMethodBeat.o(135450);
        return 0;
      case 6: 
        localcry.yaS = locala.CLY.sl();
        AppMethodBeat.o(135450);
        return 0;
      }
      localcry.yaT = locala.CLY.eqS();
      AppMethodBeat.o(135450);
      return 0;
    }
    AppMethodBeat.o(135450);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cry
 * JD-Core Version:    0.7.0.1
 */