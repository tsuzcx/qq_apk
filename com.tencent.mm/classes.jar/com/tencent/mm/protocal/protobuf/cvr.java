package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvr
  extends com.tencent.mm.cd.a
{
  public int Cqs;
  public int Crm;
  public String SessionId;
  public int TDC;
  public int TwA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125742);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Cqs);
      paramVarArgs.aY(2, this.Crm);
      paramVarArgs.aY(3, this.TDC);
      if (this.SessionId != null) {
        paramVarArgs.f(4, this.SessionId);
      }
      paramVarArgs.aY(5, this.TwA);
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Cqs) + 0 + g.a.a.b.b.a.bM(2, this.Crm) + g.a.a.b.b.a.bM(3, this.TDC);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SessionId);
      }
      i = g.a.a.b.b.a.bM(5, this.TwA);
      AppMethodBeat.o(125742);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cvr localcvr = (cvr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125742);
        return -1;
      case 1: 
        localcvr.Cqs = locala.abFh.AK();
        AppMethodBeat.o(125742);
        return 0;
      case 2: 
        localcvr.Crm = locala.abFh.AK();
        AppMethodBeat.o(125742);
        return 0;
      case 3: 
        localcvr.TDC = locala.abFh.AK();
        AppMethodBeat.o(125742);
        return 0;
      case 4: 
        localcvr.SessionId = locala.abFh.readString();
        AppMethodBeat.o(125742);
        return 0;
      }
      localcvr.TwA = locala.abFh.AK();
      AppMethodBeat.o(125742);
      return 0;
    }
    AppMethodBeat.o(125742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvr
 * JD-Core Version:    0.7.0.1
 */