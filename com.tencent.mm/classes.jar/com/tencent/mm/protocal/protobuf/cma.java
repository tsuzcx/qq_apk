package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cma
  extends com.tencent.mm.bw.a
{
  public String dQx;
  public String lHA;
  public String lHB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72513);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dQx != null) {
        paramVarArgs.e(1, this.dQx);
      }
      if (this.lHA != null) {
        paramVarArgs.e(2, this.lHA);
      }
      if (this.lHB != null) {
        paramVarArgs.e(4, this.lHB);
      }
      AppMethodBeat.o(72513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dQx == null) {
        break label338;
      }
    }
    label338:
    for (int i = g.a.a.b.b.a.f(1, this.dQx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lHA != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.lHA);
      }
      i = paramInt;
      if (this.lHB != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.lHB);
      }
      AppMethodBeat.o(72513);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72513);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cma localcma = (cma)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(72513);
          return -1;
        case 1: 
          localcma.dQx = locala.UbS.readString();
          AppMethodBeat.o(72513);
          return 0;
        case 2: 
          localcma.lHA = locala.UbS.readString();
          AppMethodBeat.o(72513);
          return 0;
        }
        localcma.lHB = locala.UbS.readString();
        AppMethodBeat.o(72513);
        return 0;
      }
      AppMethodBeat.o(72513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cma
 * JD-Core Version:    0.7.0.1
 */