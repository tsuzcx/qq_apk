package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayl
  extends com.tencent.mm.bw.a
{
  public String LIM;
  public long LIN;
  public LinkedList<String> LIO;
  
  public ayl()
  {
    AppMethodBeat.i(209592);
    this.LIO = new LinkedList();
    AppMethodBeat.o(209592);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209593);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LIM != null) {
        paramVarArgs.e(1, this.LIM);
      }
      paramVarArgs.bb(2, this.LIN);
      paramVarArgs.e(3, 1, this.LIO);
      AppMethodBeat.o(209593);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LIM == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.LIM) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.LIN);
      int j = g.a.a.a.c(3, 1, this.LIO);
      AppMethodBeat.o(209593);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LIO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209593);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ayl localayl = (ayl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209593);
          return -1;
        case 1: 
          localayl.LIM = locala.UbS.readString();
          AppMethodBeat.o(209593);
          return 0;
        case 2: 
          localayl.LIN = locala.UbS.zl();
          AppMethodBeat.o(209593);
          return 0;
        }
        localayl.LIO.add(locala.UbS.readString());
        AppMethodBeat.o(209593);
        return 0;
      }
      AppMethodBeat.o(209593);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayl
 * JD-Core Version:    0.7.0.1
 */