package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ip
  extends com.tencent.mm.cd.a
{
  public String DNV;
  public String GHy;
  public String ROq;
  public String fvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91356);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ROq != null) {
        paramVarArgs.f(1, this.ROq);
      }
      if (this.fvP != null) {
        paramVarArgs.f(2, this.fvP);
      }
      if (this.DNV != null) {
        paramVarArgs.f(3, this.DNV);
      }
      if (this.GHy != null) {
        paramVarArgs.f(4, this.GHy);
      }
      AppMethodBeat.o(91356);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ROq == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.ROq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fvP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fvP);
      }
      i = paramInt;
      if (this.DNV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.DNV);
      }
      paramInt = i;
      if (this.GHy != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.GHy);
      }
      AppMethodBeat.o(91356);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91356);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ip localip = (ip)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91356);
          return -1;
        case 1: 
          localip.ROq = locala.abFh.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 2: 
          localip.fvP = locala.abFh.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 3: 
          localip.DNV = locala.abFh.readString();
          AppMethodBeat.o(91356);
          return 0;
        }
        localip.GHy = locala.abFh.readString();
        AppMethodBeat.o(91356);
        return 0;
      }
      AppMethodBeat.o(91356);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ip
 * JD-Core Version:    0.7.0.1
 */