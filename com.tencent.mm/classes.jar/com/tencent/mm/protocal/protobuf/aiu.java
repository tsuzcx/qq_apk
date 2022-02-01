package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class aiu
  extends com.tencent.mm.cd.a
{
  public int Stn;
  public int Sto;
  public String wdY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(252250);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wdY == null)
      {
        paramVarArgs = new b("Not all required fields were included: configID");
        AppMethodBeat.o(252250);
        throw paramVarArgs;
      }
      if (this.wdY != null) {
        paramVarArgs.f(1, this.wdY);
      }
      paramVarArgs.aY(2, this.Stn);
      paramVarArgs.aY(3, this.Sto);
      AppMethodBeat.o(252250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wdY == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = g.a.a.b.b.a.g(1, this.wdY) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Stn);
      int j = g.a.a.b.b.a.bM(3, this.Sto);
      AppMethodBeat.o(252250);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.wdY == null)
        {
          paramVarArgs = new b("Not all required fields were included: configID");
          AppMethodBeat.o(252250);
          throw paramVarArgs;
        }
        AppMethodBeat.o(252250);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aiu localaiu = (aiu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(252250);
          return -1;
        case 1: 
          localaiu.wdY = locala.abFh.readString();
          AppMethodBeat.o(252250);
          return 0;
        case 2: 
          localaiu.Stn = locala.abFh.AK();
          AppMethodBeat.o(252250);
          return 0;
        }
        localaiu.Sto = locala.abFh.AK();
        AppMethodBeat.o(252250);
        return 0;
      }
      AppMethodBeat.o(252250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiu
 * JD-Core Version:    0.7.0.1
 */