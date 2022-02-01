package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkq
  extends com.tencent.mm.bw.a
{
  public String KWA;
  public LinkedList<String> KWr;
  public long MOF;
  
  public dkq()
  {
    AppMethodBeat.i(212292);
    this.KWr = new LinkedList();
    AppMethodBeat.o(212292);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212293);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KWA != null) {
        paramVarArgs.e(1, this.KWA);
      }
      paramVarArgs.bb(2, this.MOF);
      paramVarArgs.e(3, 1, this.KWr);
      AppMethodBeat.o(212293);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KWA == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.KWA) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.MOF);
      int j = g.a.a.a.c(3, 1, this.KWr);
      AppMethodBeat.o(212293);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KWr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212293);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dkq localdkq = (dkq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212293);
          return -1;
        case 1: 
          localdkq.KWA = locala.UbS.readString();
          AppMethodBeat.o(212293);
          return 0;
        case 2: 
          localdkq.MOF = locala.UbS.zl();
          AppMethodBeat.o(212293);
          return 0;
        }
        localdkq.KWr.add(locala.UbS.readString());
        AppMethodBeat.o(212293);
        return 0;
      }
      AppMethodBeat.o(212293);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkq
 * JD-Core Version:    0.7.0.1
 */