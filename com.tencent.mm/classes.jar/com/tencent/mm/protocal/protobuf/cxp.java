package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxp
  extends com.tencent.mm.cd.a
{
  public String RFo;
  public int RFq;
  public String TFY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199027);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TFY != null) {
        paramVarArgs.f(1, this.TFY);
      }
      if (this.RFo != null) {
        paramVarArgs.f(2, this.RFo);
      }
      paramVarArgs.aY(3, this.RFq);
      AppMethodBeat.o(199027);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TFY == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.TFY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RFo != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RFo);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.RFq);
      AppMethodBeat.o(199027);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199027);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cxp localcxp = (cxp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199027);
          return -1;
        case 1: 
          localcxp.TFY = locala.abFh.readString();
          AppMethodBeat.o(199027);
          return 0;
        case 2: 
          localcxp.RFo = locala.abFh.readString();
          AppMethodBeat.o(199027);
          return 0;
        }
        localcxp.RFq = locala.abFh.AK();
        AppMethodBeat.o(199027);
        return 0;
      }
      AppMethodBeat.o(199027);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxp
 * JD-Core Version:    0.7.0.1
 */