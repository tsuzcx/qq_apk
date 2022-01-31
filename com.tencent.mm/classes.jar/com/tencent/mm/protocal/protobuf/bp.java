package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class bp
  extends com.tencent.mm.bv.a
{
  public int wog;
  public b woh;
  public long woi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94500);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wog);
      if (this.woh != null) {
        paramVarArgs.c(2, this.woh);
      }
      paramVarArgs.am(3, this.woi);
      AppMethodBeat.o(94500);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wog) + 0;
      paramInt = i;
      if (this.woh != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.woh);
      }
      i = e.a.a.b.b.a.p(3, this.woi);
      AppMethodBeat.o(94500);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94500);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bp localbp = (bp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94500);
        return -1;
      case 1: 
        localbp.wog = locala.CLY.sl();
        AppMethodBeat.o(94500);
        return 0;
      case 2: 
        localbp.woh = locala.CLY.eqS();
        AppMethodBeat.o(94500);
        return 0;
      }
      localbp.woi = locala.CLY.sm();
      AppMethodBeat.o(94500);
      return 0;
    }
    AppMethodBeat.o(94500);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bp
 * JD-Core Version:    0.7.0.1
 */