package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cka
  extends com.tencent.mm.cd.a
{
  public int ChC;
  public String EtJ;
  public String Igp;
  public String TfK;
  public int TrA;
  public int TrB;
  public String TrC;
  public long Trw;
  public String Try;
  public String llP;
  public int qJt;
  public int state;
  public int tnN;
  public String tpo;
  public String ufC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72506);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TfK != null) {
        paramVarArgs.f(1, this.TfK);
      }
      if (this.llP != null) {
        paramVarArgs.f(2, this.llP);
      }
      paramVarArgs.bm(3, this.Trw);
      paramVarArgs.aY(4, this.state);
      paramVarArgs.aY(5, this.ChC);
      paramVarArgs.aY(6, this.tnN);
      paramVarArgs.aY(7, this.TrA);
      paramVarArgs.aY(8, this.TrB);
      if (this.TrC != null) {
        paramVarArgs.f(9, this.TrC);
      }
      if (this.tpo != null) {
        paramVarArgs.f(10, this.tpo);
      }
      if (this.EtJ != null) {
        paramVarArgs.f(11, this.EtJ);
      }
      if (this.ufC != null) {
        paramVarArgs.f(12, this.ufC);
      }
      if (this.Igp != null) {
        paramVarArgs.f(13, this.Igp);
      }
      if (this.Try != null) {
        paramVarArgs.f(14, this.Try);
      }
      paramVarArgs.aY(15, this.qJt);
      AppMethodBeat.o(72506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TfK == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = g.a.a.b.b.a.g(1, this.TfK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.llP != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.llP);
      }
      i = i + g.a.a.b.b.a.p(3, this.Trw) + g.a.a.b.b.a.bM(4, this.state) + g.a.a.b.b.a.bM(5, this.ChC) + g.a.a.b.b.a.bM(6, this.tnN) + g.a.a.b.b.a.bM(7, this.TrA) + g.a.a.b.b.a.bM(8, this.TrB);
      paramInt = i;
      if (this.TrC != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TrC);
      }
      i = paramInt;
      if (this.tpo != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.tpo);
      }
      paramInt = i;
      if (this.EtJ != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.EtJ);
      }
      i = paramInt;
      if (this.ufC != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.ufC);
      }
      paramInt = i;
      if (this.Igp != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Igp);
      }
      i = paramInt;
      if (this.Try != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.Try);
      }
      paramInt = g.a.a.b.b.a.bM(15, this.qJt);
      AppMethodBeat.o(72506);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72506);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cka localcka = (cka)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72506);
          return -1;
        case 1: 
          localcka.TfK = locala.abFh.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 2: 
          localcka.llP = locala.abFh.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 3: 
          localcka.Trw = locala.abFh.AN();
          AppMethodBeat.o(72506);
          return 0;
        case 4: 
          localcka.state = locala.abFh.AK();
          AppMethodBeat.o(72506);
          return 0;
        case 5: 
          localcka.ChC = locala.abFh.AK();
          AppMethodBeat.o(72506);
          return 0;
        case 6: 
          localcka.tnN = locala.abFh.AK();
          AppMethodBeat.o(72506);
          return 0;
        case 7: 
          localcka.TrA = locala.abFh.AK();
          AppMethodBeat.o(72506);
          return 0;
        case 8: 
          localcka.TrB = locala.abFh.AK();
          AppMethodBeat.o(72506);
          return 0;
        case 9: 
          localcka.TrC = locala.abFh.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 10: 
          localcka.tpo = locala.abFh.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 11: 
          localcka.EtJ = locala.abFh.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 12: 
          localcka.ufC = locala.abFh.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 13: 
          localcka.Igp = locala.abFh.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 14: 
          localcka.Try = locala.abFh.readString();
          AppMethodBeat.o(72506);
          return 0;
        }
        localcka.qJt = locala.abFh.AK();
        AppMethodBeat.o(72506);
        return 0;
      }
      AppMethodBeat.o(72506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cka
 * JD-Core Version:    0.7.0.1
 */