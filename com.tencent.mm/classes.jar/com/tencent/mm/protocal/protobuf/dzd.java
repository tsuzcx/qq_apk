package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzd
  extends com.tencent.mm.cd.a
{
  public String UeJ;
  public int UeK;
  public int UeL;
  public int interval;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91673);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UeJ != null) {
        paramVarArgs.f(1, this.UeJ);
      }
      paramVarArgs.aY(2, this.interval);
      paramVarArgs.aY(3, this.UeK);
      paramVarArgs.aY(4, this.UeL);
      AppMethodBeat.o(91673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UeJ == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = g.a.a.b.b.a.g(1, this.UeJ) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.interval);
      int j = g.a.a.b.b.a.bM(3, this.UeK);
      int k = g.a.a.b.b.a.bM(4, this.UeL);
      AppMethodBeat.o(91673);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91673);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dzd localdzd = (dzd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91673);
          return -1;
        case 1: 
          localdzd.UeJ = locala.abFh.readString();
          AppMethodBeat.o(91673);
          return 0;
        case 2: 
          localdzd.interval = locala.abFh.AK();
          AppMethodBeat.o(91673);
          return 0;
        case 3: 
          localdzd.UeK = locala.abFh.AK();
          AppMethodBeat.o(91673);
          return 0;
        }
        localdzd.UeL = locala.abFh.AK();
        AppMethodBeat.o(91673);
        return 0;
      }
      AppMethodBeat.o(91673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzd
 * JD-Core Version:    0.7.0.1
 */