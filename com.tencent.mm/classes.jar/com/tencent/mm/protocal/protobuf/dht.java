package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dht
  extends com.tencent.mm.cd.a
{
  public boolean TOM = false;
  public String TON;
  public boolean TOO;
  public int aNf = 0;
  public long endTime = 0L;
  public String fFe = "";
  public int fKG = -1;
  public String fLj = "";
  public String nnJ = "";
  public long seq = 0L;
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122521);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fLj != null) {
        paramVarArgs.f(1, this.fLj);
      }
      paramVarArgs.co(2, this.TOM);
      paramVarArgs.bm(3, this.seq);
      paramVarArgs.bm(4, this.startTime);
      paramVarArgs.bm(5, this.endTime);
      paramVarArgs.aY(6, this.fKG);
      if (this.fFe != null) {
        paramVarArgs.f(7, this.fFe);
      }
      paramVarArgs.aY(8, this.aNf);
      if (this.TON != null) {
        paramVarArgs.f(9, this.TON);
      }
      paramVarArgs.co(10, this.TOO);
      if (this.nnJ != null) {
        paramVarArgs.f(11, this.nnJ);
      }
      AppMethodBeat.o(122521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fLj == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = g.a.a.b.b.a.g(1, this.fLj) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 1) + g.a.a.b.b.a.p(3, this.seq) + g.a.a.b.b.a.p(4, this.startTime) + g.a.a.b.b.a.p(5, this.endTime) + g.a.a.b.b.a.bM(6, this.fKG);
      paramInt = i;
      if (this.fFe != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.fFe);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.aNf);
      paramInt = i;
      if (this.TON != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TON);
      }
      i = paramInt + (g.a.a.b.b.a.gL(10) + 1);
      paramInt = i;
      if (this.nnJ != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.nnJ);
      }
      AppMethodBeat.o(122521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122521);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dht localdht = (dht)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122521);
          return -1;
        case 1: 
          localdht.fLj = locala.abFh.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 2: 
          localdht.TOM = locala.abFh.AB();
          AppMethodBeat.o(122521);
          return 0;
        case 3: 
          localdht.seq = locala.abFh.AN();
          AppMethodBeat.o(122521);
          return 0;
        case 4: 
          localdht.startTime = locala.abFh.AN();
          AppMethodBeat.o(122521);
          return 0;
        case 5: 
          localdht.endTime = locala.abFh.AN();
          AppMethodBeat.o(122521);
          return 0;
        case 6: 
          localdht.fKG = locala.abFh.AK();
          AppMethodBeat.o(122521);
          return 0;
        case 7: 
          localdht.fFe = locala.abFh.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 8: 
          localdht.aNf = locala.abFh.AK();
          AppMethodBeat.o(122521);
          return 0;
        case 9: 
          localdht.TON = locala.abFh.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 10: 
          localdht.TOO = locala.abFh.AB();
          AppMethodBeat.o(122521);
          return 0;
        }
        localdht.nnJ = locala.abFh.readString();
        AppMethodBeat.o(122521);
        return 0;
      }
      AppMethodBeat.o(122521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dht
 * JD-Core Version:    0.7.0.1
 */