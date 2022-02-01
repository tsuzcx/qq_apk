package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfb
  extends com.tencent.mm.cd.a
{
  public int SLO;
  public String TML;
  public String TMM;
  public int TMN;
  public String TMO;
  public String TMP;
  public String TMQ;
  public int TMR;
  public int TMS;
  public long TMT;
  public String announcement;
  public String bec;
  public String topic;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152632);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.bec != null) {
        paramVarArgs.f(1, this.bec);
      }
      if (this.TML != null) {
        paramVarArgs.f(2, this.TML);
      }
      if (this.TMM != null) {
        paramVarArgs.f(3, this.TMM);
      }
      paramVarArgs.aY(4, this.TMN);
      if (this.topic != null) {
        paramVarArgs.f(5, this.topic);
      }
      if (this.TMO != null) {
        paramVarArgs.f(6, this.TMO);
      }
      if (this.TMP != null) {
        paramVarArgs.f(7, this.TMP);
      }
      if (this.announcement != null) {
        paramVarArgs.f(8, this.announcement);
      }
      if (this.TMQ != null) {
        paramVarArgs.f(9, this.TMQ);
      }
      paramVarArgs.aY(10, this.TMR);
      paramVarArgs.aY(11, this.TMS);
      paramVarArgs.aY(12, this.SLO);
      paramVarArgs.bm(13, this.TMT);
      AppMethodBeat.o(152632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bec == null) {
        break label878;
      }
    }
    label878:
    for (int i = g.a.a.b.b.a.g(1, this.bec) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TML != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TML);
      }
      i = paramInt;
      if (this.TMM != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TMM);
      }
      i += g.a.a.b.b.a.bM(4, this.TMN);
      paramInt = i;
      if (this.topic != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.topic);
      }
      i = paramInt;
      if (this.TMO != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TMO);
      }
      paramInt = i;
      if (this.TMP != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TMP);
      }
      i = paramInt;
      if (this.announcement != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.announcement);
      }
      paramInt = i;
      if (this.TMQ != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TMQ);
      }
      i = g.a.a.b.b.a.bM(10, this.TMR);
      int j = g.a.a.b.b.a.bM(11, this.TMS);
      int k = g.a.a.b.b.a.bM(12, this.SLO);
      int m = g.a.a.b.b.a.p(13, this.TMT);
      AppMethodBeat.o(152632);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152632);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dfb localdfb = (dfb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152632);
          return -1;
        case 1: 
          localdfb.bec = locala.abFh.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 2: 
          localdfb.TML = locala.abFh.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 3: 
          localdfb.TMM = locala.abFh.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 4: 
          localdfb.TMN = locala.abFh.AK();
          AppMethodBeat.o(152632);
          return 0;
        case 5: 
          localdfb.topic = locala.abFh.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 6: 
          localdfb.TMO = locala.abFh.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 7: 
          localdfb.TMP = locala.abFh.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 8: 
          localdfb.announcement = locala.abFh.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 9: 
          localdfb.TMQ = locala.abFh.readString();
          AppMethodBeat.o(152632);
          return 0;
        case 10: 
          localdfb.TMR = locala.abFh.AK();
          AppMethodBeat.o(152632);
          return 0;
        case 11: 
          localdfb.TMS = locala.abFh.AK();
          AppMethodBeat.o(152632);
          return 0;
        case 12: 
          localdfb.SLO = locala.abFh.AK();
          AppMethodBeat.o(152632);
          return 0;
        }
        localdfb.TMT = locala.abFh.AN();
        AppMethodBeat.o(152632);
        return 0;
      }
      AppMethodBeat.o(152632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfb
 * JD-Core Version:    0.7.0.1
 */