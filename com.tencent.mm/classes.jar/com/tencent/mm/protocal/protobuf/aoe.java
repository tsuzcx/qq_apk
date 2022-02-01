package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoe
  extends com.tencent.mm.cd.a
{
  public int fWQ;
  public int index;
  public String query;
  public int scene;
  public String sessionId;
  public int wGA;
  public String wGC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.scene);
      paramVarArgs.aY(2, this.wGA);
      paramVarArgs.aY(3, this.index);
      if (this.sessionId != null) {
        paramVarArgs.f(4, this.sessionId);
      }
      if (this.query != null) {
        paramVarArgs.f(5, this.query);
      }
      if (this.wGC != null) {
        paramVarArgs.f(6, this.wGC);
      }
      paramVarArgs.aY(7, this.fWQ);
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.scene) + 0 + g.a.a.b.b.a.bM(2, this.wGA) + g.a.a.b.b.a.bM(3, this.index);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.sessionId);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.query);
      }
      paramInt = i;
      if (this.wGC != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.wGC);
      }
      i = g.a.a.b.b.a.bM(7, this.fWQ);
      AppMethodBeat.o(127475);
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
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aoe localaoe = (aoe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127475);
        return -1;
      case 1: 
        localaoe.scene = locala.abFh.AK();
        AppMethodBeat.o(127475);
        return 0;
      case 2: 
        localaoe.wGA = locala.abFh.AK();
        AppMethodBeat.o(127475);
        return 0;
      case 3: 
        localaoe.index = locala.abFh.AK();
        AppMethodBeat.o(127475);
        return 0;
      case 4: 
        localaoe.sessionId = locala.abFh.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 5: 
        localaoe.query = locala.abFh.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 6: 
        localaoe.wGC = locala.abFh.readString();
        AppMethodBeat.o(127475);
        return 0;
      }
      localaoe.fWQ = locala.abFh.AK();
      AppMethodBeat.o(127475);
      return 0;
    }
    AppMethodBeat.o(127475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoe
 * JD-Core Version:    0.7.0.1
 */