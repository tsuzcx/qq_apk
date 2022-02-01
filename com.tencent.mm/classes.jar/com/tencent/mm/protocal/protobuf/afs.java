package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afs
  extends com.tencent.mm.bw.a
{
  public String dOe;
  public LinkedList<String> ybk;
  
  public afs()
  {
    AppMethodBeat.i(218983);
    this.ybk = new LinkedList();
    AppMethodBeat.o(218983);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218984);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dOe != null) {
        paramVarArgs.e(1, this.dOe);
      }
      paramVarArgs.e(2, 1, this.ybk);
      AppMethodBeat.o(218984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dOe == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.dOe) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.ybk);
      AppMethodBeat.o(218984);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ybk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(218984);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        afs localafs = (afs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(218984);
          return -1;
        case 1: 
          localafs.dOe = locala.UbS.readString();
          AppMethodBeat.o(218984);
          return 0;
        }
        localafs.ybk.add(locala.UbS.readString());
        AppMethodBeat.o(218984);
        return 0;
      }
      AppMethodBeat.o(218984);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afs
 * JD-Core Version:    0.7.0.1
 */