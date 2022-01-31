package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgo
  extends com.tencent.mm.bv.a
{
  public int Timestamp;
  public int jKr;
  public int xRo;
  public int xRp;
  public int xRq;
  public int xRr;
  public int xRs;
  public int xRt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28659);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jKr);
      paramVarArgs.aO(2, this.Timestamp);
      paramVarArgs.aO(3, this.xRo);
      paramVarArgs.aO(4, this.xRp);
      paramVarArgs.aO(5, this.xRq);
      paramVarArgs.aO(6, this.xRr);
      paramVarArgs.aO(7, this.xRs);
      paramVarArgs.aO(8, this.xRt);
      AppMethodBeat.o(28659);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.jKr);
      int i = e.a.a.b.b.a.bl(2, this.Timestamp);
      int j = e.a.a.b.b.a.bl(3, this.xRo);
      int k = e.a.a.b.b.a.bl(4, this.xRp);
      int m = e.a.a.b.b.a.bl(5, this.xRq);
      int n = e.a.a.b.b.a.bl(6, this.xRr);
      int i1 = e.a.a.b.b.a.bl(7, this.xRs);
      int i2 = e.a.a.b.b.a.bl(8, this.xRt);
      AppMethodBeat.o(28659);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28659);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cgo localcgo = (cgo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28659);
        return -1;
      case 1: 
        localcgo.jKr = locala.CLY.sl();
        AppMethodBeat.o(28659);
        return 0;
      case 2: 
        localcgo.Timestamp = locala.CLY.sl();
        AppMethodBeat.o(28659);
        return 0;
      case 3: 
        localcgo.xRo = locala.CLY.sl();
        AppMethodBeat.o(28659);
        return 0;
      case 4: 
        localcgo.xRp = locala.CLY.sl();
        AppMethodBeat.o(28659);
        return 0;
      case 5: 
        localcgo.xRq = locala.CLY.sl();
        AppMethodBeat.o(28659);
        return 0;
      case 6: 
        localcgo.xRr = locala.CLY.sl();
        AppMethodBeat.o(28659);
        return 0;
      case 7: 
        localcgo.xRs = locala.CLY.sl();
        AppMethodBeat.o(28659);
        return 0;
      }
      localcgo.xRt = locala.CLY.sl();
      AppMethodBeat.o(28659);
      return 0;
    }
    AppMethodBeat.o(28659);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgo
 * JD-Core Version:    0.7.0.1
 */