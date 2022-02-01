package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class axh
  extends com.tencent.mm.cd.a
{
  public String SJO;
  public int SJP;
  public String SJQ;
  public String SJR;
  public String SJS;
  public int SJT;
  public b SJU;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231139);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SJO != null) {
        paramVarArgs.f(1, this.SJO);
      }
      paramVarArgs.aY(2, this.SJP);
      if (this.SJQ != null) {
        paramVarArgs.f(3, this.SJQ);
      }
      if (this.SJR != null) {
        paramVarArgs.f(4, this.SJR);
      }
      if (this.SJS != null) {
        paramVarArgs.f(101, this.SJS);
      }
      paramVarArgs.aY(102, this.SJT);
      if (this.SJU != null) {
        paramVarArgs.c(103, this.SJU);
      }
      paramVarArgs.bm(104, this.seq);
      AppMethodBeat.o(231139);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SJO == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = g.a.a.b.b.a.g(1, this.SJO) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SJP);
      paramInt = i;
      if (this.SJQ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SJQ);
      }
      i = paramInt;
      if (this.SJR != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.SJR);
      }
      paramInt = i;
      if (this.SJS != null) {
        paramInt = i + g.a.a.b.b.a.g(101, this.SJS);
      }
      i = paramInt + g.a.a.b.b.a.bM(102, this.SJT);
      paramInt = i;
      if (this.SJU != null) {
        paramInt = i + g.a.a.b.b.a.b(103, this.SJU);
      }
      i = g.a.a.b.b.a.p(104, this.seq);
      AppMethodBeat.o(231139);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231139);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        axh localaxh = (axh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(231139);
          return -1;
        case 1: 
          localaxh.SJO = locala.abFh.readString();
          AppMethodBeat.o(231139);
          return 0;
        case 2: 
          localaxh.SJP = locala.abFh.AK();
          AppMethodBeat.o(231139);
          return 0;
        case 3: 
          localaxh.SJQ = locala.abFh.readString();
          AppMethodBeat.o(231139);
          return 0;
        case 4: 
          localaxh.SJR = locala.abFh.readString();
          AppMethodBeat.o(231139);
          return 0;
        case 101: 
          localaxh.SJS = locala.abFh.readString();
          AppMethodBeat.o(231139);
          return 0;
        case 102: 
          localaxh.SJT = locala.abFh.AK();
          AppMethodBeat.o(231139);
          return 0;
        case 103: 
          localaxh.SJU = locala.abFh.iUw();
          AppMethodBeat.o(231139);
          return 0;
        }
        localaxh.seq = locala.abFh.AN();
        AppMethodBeat.o(231139);
        return 0;
      }
      AppMethodBeat.o(231139);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axh
 * JD-Core Version:    0.7.0.1
 */