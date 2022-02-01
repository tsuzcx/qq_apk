package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djh
  extends com.tencent.mm.cd.a
{
  public int RPq;
  public String TQI;
  public String TQJ;
  public String TQK;
  public String TQL;
  public String TQM;
  public String TQN;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91577);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TQI != null) {
        paramVarArgs.f(1, this.TQI);
      }
      paramVarArgs.aY(2, this.rVU);
      if (this.TQJ != null) {
        paramVarArgs.f(3, this.TQJ);
      }
      if (this.TQK != null) {
        paramVarArgs.f(4, this.TQK);
      }
      if (this.TQL != null) {
        paramVarArgs.f(5, this.TQL);
      }
      paramVarArgs.aY(6, this.RPq);
      if (this.TQM != null) {
        paramVarArgs.f(7, this.TQM);
      }
      if (this.TQN != null) {
        paramVarArgs.f(8, this.TQN);
      }
      AppMethodBeat.o(91577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TQI == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = g.a.a.b.b.a.g(1, this.TQI) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rVU);
      paramInt = i;
      if (this.TQJ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TQJ);
      }
      i = paramInt;
      if (this.TQK != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TQK);
      }
      paramInt = i;
      if (this.TQL != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TQL);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.RPq);
      paramInt = i;
      if (this.TQM != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TQM);
      }
      i = paramInt;
      if (this.TQN != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TQN);
      }
      AppMethodBeat.o(91577);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91577);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        djh localdjh = (djh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91577);
          return -1;
        case 1: 
          localdjh.TQI = locala.abFh.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 2: 
          localdjh.rVU = locala.abFh.AK();
          AppMethodBeat.o(91577);
          return 0;
        case 3: 
          localdjh.TQJ = locala.abFh.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 4: 
          localdjh.TQK = locala.abFh.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 5: 
          localdjh.TQL = locala.abFh.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 6: 
          localdjh.RPq = locala.abFh.AK();
          AppMethodBeat.o(91577);
          return 0;
        case 7: 
          localdjh.TQM = locala.abFh.readString();
          AppMethodBeat.o(91577);
          return 0;
        }
        localdjh.TQN = locala.abFh.readString();
        AppMethodBeat.o(91577);
        return 0;
      }
      AppMethodBeat.o(91577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djh
 * JD-Core Version:    0.7.0.1
 */