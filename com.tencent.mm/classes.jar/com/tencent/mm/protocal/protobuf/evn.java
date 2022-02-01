package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class evn
  extends com.tencent.mm.bw.a
{
  public String Ntb;
  public LinkedList<String> Ntc;
  
  public evn()
  {
    AppMethodBeat.i(147798);
    this.Ntc = new LinkedList();
    AppMethodBeat.o(147798);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147799);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ntb != null) {
        paramVarArgs.e(1, this.Ntb);
      }
      paramVarArgs.e(2, 1, this.Ntc);
      AppMethodBeat.o(147799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ntb == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.Ntb) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.Ntc);
      AppMethodBeat.o(147799);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ntc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147799);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        evn localevn = (evn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147799);
          return -1;
        case 1: 
          localevn.Ntb = locala.UbS.readString();
          AppMethodBeat.o(147799);
          return 0;
        }
        localevn.Ntc.add(locala.UbS.readString());
        AppMethodBeat.o(147799);
        return 0;
      }
      AppMethodBeat.o(147799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evn
 * JD-Core Version:    0.7.0.1
 */