package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apn
  extends com.tencent.mm.cd.a
{
  public String SCQ;
  public String SCR;
  public String SCS;
  public int SCT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206603);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SCQ != null) {
        paramVarArgs.f(1, this.SCQ);
      }
      if (this.SCR != null) {
        paramVarArgs.f(2, this.SCR);
      }
      if (this.SCS != null) {
        paramVarArgs.f(3, this.SCS);
      }
      paramVarArgs.aY(4, this.SCT);
      AppMethodBeat.o(206603);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SCQ == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.SCQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SCR != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SCR);
      }
      i = paramInt;
      if (this.SCS != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SCS);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.SCT);
      AppMethodBeat.o(206603);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206603);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        apn localapn = (apn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(206603);
          return -1;
        case 1: 
          localapn.SCQ = locala.abFh.readString();
          AppMethodBeat.o(206603);
          return 0;
        case 2: 
          localapn.SCR = locala.abFh.readString();
          AppMethodBeat.o(206603);
          return 0;
        case 3: 
          localapn.SCS = locala.abFh.readString();
          AppMethodBeat.o(206603);
          return 0;
        }
        localapn.SCT = locala.abFh.AK();
        AppMethodBeat.o(206603);
        return 0;
      }
      AppMethodBeat.o(206603);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apn
 * JD-Core Version:    0.7.0.1
 */