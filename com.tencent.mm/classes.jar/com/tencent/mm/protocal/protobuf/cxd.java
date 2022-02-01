package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxd
  extends com.tencent.mm.cd.a
{
  public String TFH;
  public String TFI;
  public boolean TFJ;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206718);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TFH != null) {
        paramVarArgs.f(1, this.TFH);
      }
      if (this.TFI != null) {
        paramVarArgs.f(2, this.TFI);
      }
      paramVarArgs.aY(3, this.rWu);
      paramVarArgs.co(4, this.TFJ);
      AppMethodBeat.o(206718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TFH == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.g(1, this.TFH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TFI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TFI);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.rWu);
      int j = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(206718);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206718);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cxd localcxd = (cxd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(206718);
          return -1;
        case 1: 
          localcxd.TFH = locala.abFh.readString();
          AppMethodBeat.o(206718);
          return 0;
        case 2: 
          localcxd.TFI = locala.abFh.readString();
          AppMethodBeat.o(206718);
          return 0;
        case 3: 
          localcxd.rWu = locala.abFh.AK();
          AppMethodBeat.o(206718);
          return 0;
        }
        localcxd.TFJ = locala.abFh.AB();
        AppMethodBeat.o(206718);
        return 0;
      }
      AppMethodBeat.o(206718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxd
 * JD-Core Version:    0.7.0.1
 */