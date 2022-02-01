package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ezs
  extends com.tencent.mm.bw.a
{
  public String NvP;
  public String NvQ;
  public String NvR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32562);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NvP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Plugin");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.NvQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityPath");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.NvP != null) {
        paramVarArgs.e(1, this.NvP);
      }
      if (this.NvQ != null) {
        paramVarArgs.e(2, this.NvQ);
      }
      if (this.NvR != null) {
        paramVarArgs.e(3, this.NvR);
      }
      AppMethodBeat.o(32562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NvP == null) {
        break label443;
      }
    }
    label443:
    for (int i = g.a.a.b.b.a.f(1, this.NvP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NvQ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NvQ);
      }
      i = paramInt;
      if (this.NvR != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.NvR);
      }
      AppMethodBeat.o(32562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NvP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Plugin");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        if (this.NvQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityPath");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32562);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezs localezs = (ezs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32562);
          return -1;
        case 1: 
          localezs.NvP = locala.UbS.readString();
          AppMethodBeat.o(32562);
          return 0;
        case 2: 
          localezs.NvQ = locala.UbS.readString();
          AppMethodBeat.o(32562);
          return 0;
        }
        localezs.NvR = locala.UbS.readString();
        AppMethodBeat.o(32562);
        return 0;
      }
      AppMethodBeat.o(32562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezs
 * JD-Core Version:    0.7.0.1
 */