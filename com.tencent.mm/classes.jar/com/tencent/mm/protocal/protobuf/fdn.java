package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class fdn
  extends com.tencent.mm.cd.a
{
  public long Svv;
  public int UDA;
  public int UDB;
  public b UDC;
  public int UDy;
  public int UDz;
  public long Urf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125501);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Urf);
      paramVarArgs.bm(2, this.Svv);
      paramVarArgs.aY(3, this.UDy);
      paramVarArgs.aY(4, this.UDz);
      paramVarArgs.aY(5, this.UDA);
      paramVarArgs.aY(6, this.UDB);
      if (this.UDC != null) {
        paramVarArgs.c(7, this.UDC);
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.Urf) + 0 + g.a.a.b.b.a.p(2, this.Svv) + g.a.a.b.b.a.bM(3, this.UDy) + g.a.a.b.b.a.bM(4, this.UDz) + g.a.a.b.b.a.bM(5, this.UDA) + g.a.a.b.b.a.bM(6, this.UDB);
      paramInt = i;
      if (this.UDC != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.UDC);
      }
      AppMethodBeat.o(125501);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125501);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fdn localfdn = (fdn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125501);
        return -1;
      case 1: 
        localfdn.Urf = locala.abFh.AN();
        AppMethodBeat.o(125501);
        return 0;
      case 2: 
        localfdn.Svv = locala.abFh.AN();
        AppMethodBeat.o(125501);
        return 0;
      case 3: 
        localfdn.UDy = locala.abFh.AK();
        AppMethodBeat.o(125501);
        return 0;
      case 4: 
        localfdn.UDz = locala.abFh.AK();
        AppMethodBeat.o(125501);
        return 0;
      case 5: 
        localfdn.UDA = locala.abFh.AK();
        AppMethodBeat.o(125501);
        return 0;
      case 6: 
        localfdn.UDB = locala.abFh.AK();
        AppMethodBeat.o(125501);
        return 0;
      }
      localfdn.UDC = locala.abFh.iUw();
      AppMethodBeat.o(125501);
      return 0;
    }
    AppMethodBeat.o(125501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdn
 * JD-Core Version:    0.7.0.1
 */