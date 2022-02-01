package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ach
  extends com.tencent.mm.cd.a
{
  public int RKb;
  public String RWs;
  public int SnQ;
  public int SnR;
  public int SnS;
  public boolean SnT;
  public boolean SnU;
  public int pos;
  public int qJt;
  public int time;
  public String zaX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208908);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SnQ);
      paramVarArgs.aY(2, this.SnR);
      paramVarArgs.aY(3, this.SnS);
      paramVarArgs.aY(4, this.time);
      paramVarArgs.aY(5, this.RKb);
      paramVarArgs.aY(6, this.qJt);
      paramVarArgs.aY(7, this.pos);
      paramVarArgs.co(8, this.SnT);
      paramVarArgs.co(9, this.SnU);
      if (this.zaX != null) {
        paramVarArgs.f(10, this.zaX);
      }
      if (this.RWs != null) {
        paramVarArgs.f(11, this.RWs);
      }
      AppMethodBeat.o(208908);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SnQ) + 0 + g.a.a.b.b.a.bM(2, this.SnR) + g.a.a.b.b.a.bM(3, this.SnS) + g.a.a.b.b.a.bM(4, this.time) + g.a.a.b.b.a.bM(5, this.RKb) + g.a.a.b.b.a.bM(6, this.qJt) + g.a.a.b.b.a.bM(7, this.pos) + (g.a.a.b.b.a.gL(8) + 1) + (g.a.a.b.b.a.gL(9) + 1);
      paramInt = i;
      if (this.zaX != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.zaX);
      }
      i = paramInt;
      if (this.RWs != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.RWs);
      }
      AppMethodBeat.o(208908);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(208908);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ach localach = (ach)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208908);
        return -1;
      case 1: 
        localach.SnQ = locala.abFh.AK();
        AppMethodBeat.o(208908);
        return 0;
      case 2: 
        localach.SnR = locala.abFh.AK();
        AppMethodBeat.o(208908);
        return 0;
      case 3: 
        localach.SnS = locala.abFh.AK();
        AppMethodBeat.o(208908);
        return 0;
      case 4: 
        localach.time = locala.abFh.AK();
        AppMethodBeat.o(208908);
        return 0;
      case 5: 
        localach.RKb = locala.abFh.AK();
        AppMethodBeat.o(208908);
        return 0;
      case 6: 
        localach.qJt = locala.abFh.AK();
        AppMethodBeat.o(208908);
        return 0;
      case 7: 
        localach.pos = locala.abFh.AK();
        AppMethodBeat.o(208908);
        return 0;
      case 8: 
        localach.SnT = locala.abFh.AB();
        AppMethodBeat.o(208908);
        return 0;
      case 9: 
        localach.SnU = locala.abFh.AB();
        AppMethodBeat.o(208908);
        return 0;
      case 10: 
        localach.zaX = locala.abFh.readString();
        AppMethodBeat.o(208908);
        return 0;
      }
      localach.RWs = locala.abFh.readString();
      AppMethodBeat.o(208908);
      return 0;
    }
    AppMethodBeat.o(208908);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ach
 * JD-Core Version:    0.7.0.1
 */