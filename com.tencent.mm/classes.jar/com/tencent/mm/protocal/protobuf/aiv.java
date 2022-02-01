package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aiv
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> EyF;
  public int Stn;
  public String wdY;
  
  public aiv()
  {
    AppMethodBeat.i(250948);
    this.EyF = new LinkedList();
    AppMethodBeat.o(250948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250952);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wdY == null)
      {
        paramVarArgs = new b("Not all required fields were included: configID");
        AppMethodBeat.o(250952);
        throw paramVarArgs;
      }
      if (this.wdY != null) {
        paramVarArgs.f(1, this.wdY);
      }
      paramVarArgs.aY(2, this.Stn);
      paramVarArgs.e(3, 1, this.EyF);
      AppMethodBeat.o(250952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wdY == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.g(1, this.wdY) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Stn);
      int j = g.a.a.a.c(3, 1, this.EyF);
      AppMethodBeat.o(250952);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EyF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.wdY == null)
        {
          paramVarArgs = new b("Not all required fields were included: configID");
          AppMethodBeat.o(250952);
          throw paramVarArgs;
        }
        AppMethodBeat.o(250952);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aiv localaiv = (aiv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(250952);
          return -1;
        case 1: 
          localaiv.wdY = locala.abFh.readString();
          AppMethodBeat.o(250952);
          return 0;
        case 2: 
          localaiv.Stn = locala.abFh.AK();
          AppMethodBeat.o(250952);
          return 0;
        }
        localaiv.EyF.add(locala.abFh.readString());
        AppMethodBeat.o(250952);
        return 0;
      }
      AppMethodBeat.o(250952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiv
 * JD-Core Version:    0.7.0.1
 */