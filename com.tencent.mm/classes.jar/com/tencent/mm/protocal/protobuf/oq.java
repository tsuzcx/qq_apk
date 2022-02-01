package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oq
  extends com.tencent.mm.bw.a
{
  public String KSV;
  public LinkedList<String> KUB;
  
  public oq()
  {
    AppMethodBeat.i(212242);
    this.KUB = new LinkedList();
    AppMethodBeat.o(212242);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212243);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KSV != null) {
        paramVarArgs.e(1, this.KSV);
      }
      paramVarArgs.e(2, 1, this.KUB);
      AppMethodBeat.o(212243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KSV == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.KSV) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.KUB);
      AppMethodBeat.o(212243);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KUB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212243);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        oq localoq = (oq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212243);
          return -1;
        case 1: 
          localoq.KSV = locala.UbS.readString();
          AppMethodBeat.o(212243);
          return 0;
        }
        localoq.KUB.add(locala.UbS.readString());
        AppMethodBeat.o(212243);
        return 0;
      }
      AppMethodBeat.o(212243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oq
 * JD-Core Version:    0.7.0.1
 */