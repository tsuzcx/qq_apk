package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class fnx
  extends com.tencent.mm.cd.a
{
  public b RTT;
  public String Txp;
  public String appid;
  public String tVp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123700);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Txp != null) {
        paramVarArgs.f(1, this.Txp);
      }
      if (this.RTT != null) {
        paramVarArgs.c(2, this.RTT);
      }
      if (this.appid != null) {
        paramVarArgs.f(3, this.appid);
      }
      if (this.tVp != null) {
        paramVarArgs.f(4, this.tVp);
      }
      AppMethodBeat.o(123700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Txp == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.Txp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RTT != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.RTT);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.appid);
      }
      paramInt = i;
      if (this.tVp != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.tVp);
      }
      AppMethodBeat.o(123700);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123700);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fnx localfnx = (fnx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123700);
          return -1;
        case 1: 
          localfnx.Txp = locala.abFh.readString();
          AppMethodBeat.o(123700);
          return 0;
        case 2: 
          localfnx.RTT = locala.abFh.iUw();
          AppMethodBeat.o(123700);
          return 0;
        case 3: 
          localfnx.appid = locala.abFh.readString();
          AppMethodBeat.o(123700);
          return 0;
        }
        localfnx.tVp = locala.abFh.readString();
        AppMethodBeat.o(123700);
        return 0;
      }
      AppMethodBeat.o(123700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnx
 * JD-Core Version:    0.7.0.1
 */