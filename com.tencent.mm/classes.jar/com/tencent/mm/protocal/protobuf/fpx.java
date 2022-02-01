package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fpx
  extends com.tencent.mm.cd.a
{
  public String UNM;
  public String UNN;
  public String appid;
  public int qLQ;
  public int qNx;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123710);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      if (this.UNM != null) {
        paramVarArgs.f(3, this.UNM);
      }
      if (this.UNN != null) {
        paramVarArgs.f(4, this.UNN);
      }
      paramVarArgs.aY(5, this.qLQ);
      paramVarArgs.aY(6, this.qNx);
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appid);
      }
      i = paramInt;
      if (this.UNM != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UNM);
      }
      paramInt = i;
      if (this.UNN != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UNN);
      }
      i = g.a.a.b.b.a.bM(5, this.qLQ);
      int j = g.a.a.b.b.a.bM(6, this.qNx);
      AppMethodBeat.o(123710);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fpx localfpx = (fpx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123710);
        return -1;
      case 1: 
        localfpx.type = locala.abFh.AK();
        AppMethodBeat.o(123710);
        return 0;
      case 2: 
        localfpx.appid = locala.abFh.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 3: 
        localfpx.UNM = locala.abFh.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 4: 
        localfpx.UNN = locala.abFh.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 5: 
        localfpx.qLQ = locala.abFh.AK();
        AppMethodBeat.o(123710);
        return 0;
      }
      localfpx.qNx = locala.abFh.AK();
      AppMethodBeat.o(123710);
      return 0;
    }
    AppMethodBeat.o(123710);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpx
 * JD-Core Version:    0.7.0.1
 */