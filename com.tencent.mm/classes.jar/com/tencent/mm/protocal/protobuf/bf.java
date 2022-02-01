package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public class bf
  extends com.tencent.mm.cd.a
{
  public boolean RGa;
  public boolean RGb;
  public int RGc;
  public boolean RGd;
  public b RGe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123537);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.RGa);
      paramVarArgs.co(2, this.RGb);
      paramVarArgs.aY(3, this.RGc);
      paramVarArgs.co(4, this.RGd);
      if (this.RGe != null) {
        paramVarArgs.c(5, this.RGe);
      }
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0 + (g.a.a.b.b.a.gL(2) + 1) + g.a.a.b.b.a.bM(3, this.RGc) + (g.a.a.b.b.a.gL(4) + 1);
      paramInt = i;
      if (this.RGe != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.RGe);
      }
      AppMethodBeat.o(123537);
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
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bf localbf = (bf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123537);
        return -1;
      case 1: 
        localbf.RGa = locala.abFh.AB();
        AppMethodBeat.o(123537);
        return 0;
      case 2: 
        localbf.RGb = locala.abFh.AB();
        AppMethodBeat.o(123537);
        return 0;
      case 3: 
        localbf.RGc = locala.abFh.AK();
        AppMethodBeat.o(123537);
        return 0;
      case 4: 
        localbf.RGd = locala.abFh.AB();
        AppMethodBeat.o(123537);
        return 0;
      }
      localbf.RGe = locala.abFh.iUw();
      AppMethodBeat.o(123537);
      return 0;
    }
    AppMethodBeat.o(123537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bf
 * JD-Core Version:    0.7.0.1
 */