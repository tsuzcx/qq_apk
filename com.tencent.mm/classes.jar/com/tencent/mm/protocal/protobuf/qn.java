package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qn
  extends com.tencent.mm.cd.a
{
  public int JtF;
  public int RYL;
  public int RYM;
  public int RYN;
  public String RYO;
  public int RYP;
  public int RYQ;
  public int RYR;
  public String RYS;
  public String appid;
  public String ugq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117838);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      paramVarArgs.aY(2, this.RYL);
      paramVarArgs.aY(3, this.RYM);
      if (this.ugq != null) {
        paramVarArgs.f(4, this.ugq);
      }
      paramVarArgs.aY(5, this.RYN);
      if (this.RYO != null) {
        paramVarArgs.f(6, this.RYO);
      }
      paramVarArgs.aY(7, this.RYP);
      paramVarArgs.aY(8, this.RYQ);
      paramVarArgs.aY(9, this.RYR);
      if (this.RYS != null) {
        paramVarArgs.f(10, this.RYS);
      }
      paramVarArgs.aY(15, this.JtF);
      AppMethodBeat.o(117838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = g.a.a.b.b.a.g(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RYL) + g.a.a.b.b.a.bM(3, this.RYM);
      paramInt = i;
      if (this.ugq != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ugq);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RYN);
      paramInt = i;
      if (this.RYO != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RYO);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.RYP) + g.a.a.b.b.a.bM(8, this.RYQ) + g.a.a.b.b.a.bM(9, this.RYR);
      paramInt = i;
      if (this.RYS != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RYS);
      }
      i = g.a.a.b.b.a.bM(15, this.JtF);
      AppMethodBeat.o(117838);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117838);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        qn localqn = (qn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        default: 
          AppMethodBeat.o(117838);
          return -1;
        case 1: 
          localqn.appid = locala.abFh.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 2: 
          localqn.RYL = locala.abFh.AK();
          AppMethodBeat.o(117838);
          return 0;
        case 3: 
          localqn.RYM = locala.abFh.AK();
          AppMethodBeat.o(117838);
          return 0;
        case 4: 
          localqn.ugq = locala.abFh.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 5: 
          localqn.RYN = locala.abFh.AK();
          AppMethodBeat.o(117838);
          return 0;
        case 6: 
          localqn.RYO = locala.abFh.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 7: 
          localqn.RYP = locala.abFh.AK();
          AppMethodBeat.o(117838);
          return 0;
        case 8: 
          localqn.RYQ = locala.abFh.AK();
          AppMethodBeat.o(117838);
          return 0;
        case 9: 
          localqn.RYR = locala.abFh.AK();
          AppMethodBeat.o(117838);
          return 0;
        case 10: 
          localqn.RYS = locala.abFh.readString();
          AppMethodBeat.o(117838);
          return 0;
        }
        localqn.JtF = locala.abFh.AK();
        AppMethodBeat.o(117838);
        return 0;
      }
      AppMethodBeat.o(117838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qn
 * JD-Core Version:    0.7.0.1
 */