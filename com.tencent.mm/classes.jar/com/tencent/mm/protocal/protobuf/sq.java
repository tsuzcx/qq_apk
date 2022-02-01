package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class sq
  extends com.tencent.mm.cd.a
{
  public long InT;
  public String InU;
  public String InV;
  public String InW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258946);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.InU == null)
      {
        paramVarArgs = new b("Not all required fields were included: personalpay_order_id");
        AppMethodBeat.o(258946);
        throw paramVarArgs;
      }
      if (this.InU != null) {
        paramVarArgs.f(1, this.InU);
      }
      if (this.InV != null) {
        paramVarArgs.f(2, this.InV);
      }
      paramVarArgs.bm(3, this.InT);
      if (this.InW != null) {
        paramVarArgs.f(4, this.InW);
      }
      AppMethodBeat.o(258946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.InU == null) {
        break label426;
      }
    }
    label426:
    for (paramInt = g.a.a.b.b.a.g(1, this.InU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.InV != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.InV);
      }
      i += g.a.a.b.b.a.p(3, this.InT);
      paramInt = i;
      if (this.InW != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.InW);
      }
      AppMethodBeat.o(258946);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.InU == null)
        {
          paramVarArgs = new b("Not all required fields were included: personalpay_order_id");
          AppMethodBeat.o(258946);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258946);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        sq localsq = (sq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258946);
          return -1;
        case 1: 
          localsq.InU = locala.abFh.readString();
          AppMethodBeat.o(258946);
          return 0;
        case 2: 
          localsq.InV = locala.abFh.readString();
          AppMethodBeat.o(258946);
          return 0;
        case 3: 
          localsq.InT = locala.abFh.AN();
          AppMethodBeat.o(258946);
          return 0;
        }
        localsq.InW = locala.abFh.readString();
        AppMethodBeat.o(258946);
        return 0;
      }
      AppMethodBeat.o(258946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sq
 * JD-Core Version:    0.7.0.1
 */