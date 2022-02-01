package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fkm
  extends com.tencent.mm.cd.a
{
  public String RUd;
  public int SZN;
  public boolean UJg;
  public String Ueg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32565);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ueg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32565);
        throw paramVarArgs;
      }
      if (this.RUd == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32565);
        throw paramVarArgs;
      }
      if (this.Ueg != null) {
        paramVarArgs.f(1, this.Ueg);
      }
      if (this.RUd != null) {
        paramVarArgs.f(2, this.RUd);
      }
      paramVarArgs.co(3, this.UJg);
      paramVarArgs.aY(4, this.SZN);
      AppMethodBeat.o(32565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ueg == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = g.a.a.b.b.a.g(1, this.Ueg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RUd != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RUd);
      }
      paramInt = g.a.a.b.b.a.gL(3);
      int j = g.a.a.b.b.a.bM(4, this.SZN);
      AppMethodBeat.o(32565);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Ueg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32565);
          throw paramVarArgs;
        }
        if (this.RUd == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32565);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fkm localfkm = (fkm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32565);
          return -1;
        case 1: 
          localfkm.Ueg = locala.abFh.readString();
          AppMethodBeat.o(32565);
          return 0;
        case 2: 
          localfkm.RUd = locala.abFh.readString();
          AppMethodBeat.o(32565);
          return 0;
        case 3: 
          localfkm.UJg = locala.abFh.AB();
          AppMethodBeat.o(32565);
          return 0;
        }
        localfkm.SZN = locala.abFh.AK();
        AppMethodBeat.o(32565);
        return 0;
      }
      AppMethodBeat.o(32565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkm
 * JD-Core Version:    0.7.0.1
 */