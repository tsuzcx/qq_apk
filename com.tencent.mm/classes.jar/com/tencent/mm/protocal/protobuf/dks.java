package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dks
  extends com.tencent.mm.cd.a
{
  public String CQz;
  public int CreateTime;
  public String GIh;
  public String GIj;
  public String GIk;
  public int GIl;
  public String GIm;
  public int GIn;
  public int GIo;
  public String GIq;
  public String GIr;
  public String GIs;
  public String GIt;
  public int TRD;
  public String TRS;
  public String TRT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91612);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GIh != null) {
        paramVarArgs.f(1, this.GIh);
      }
      paramVarArgs.aY(2, this.TRD);
      if (this.GIj != null) {
        paramVarArgs.f(3, this.GIj);
      }
      paramVarArgs.aY(4, this.CreateTime);
      if (this.GIk != null) {
        paramVarArgs.f(5, this.GIk);
      }
      paramVarArgs.aY(6, this.GIl);
      if (this.GIm != null) {
        paramVarArgs.f(7, this.GIm);
      }
      paramVarArgs.aY(8, this.GIn);
      paramVarArgs.aY(9, this.GIo);
      if (this.CQz != null) {
        paramVarArgs.f(11, this.CQz);
      }
      if (this.GIq != null) {
        paramVarArgs.f(12, this.GIq);
      }
      if (this.GIr != null) {
        paramVarArgs.f(13, this.GIr);
      }
      if (this.GIs != null) {
        paramVarArgs.f(14, this.GIs);
      }
      if (this.GIt != null) {
        paramVarArgs.f(15, this.GIt);
      }
      if (this.TRS != null) {
        paramVarArgs.f(18, this.TRS);
      }
      if (this.TRT != null) {
        paramVarArgs.f(19, this.TRT);
      }
      AppMethodBeat.o(91612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GIh == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = g.a.a.b.b.a.g(1, this.GIh) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TRD);
      paramInt = i;
      if (this.GIj != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.GIj);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.CreateTime);
      paramInt = i;
      if (this.GIk != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.GIk);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.GIl);
      paramInt = i;
      if (this.GIm != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.GIm);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.GIn) + g.a.a.b.b.a.bM(9, this.GIo);
      paramInt = i;
      if (this.CQz != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.CQz);
      }
      i = paramInt;
      if (this.GIq != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.GIq);
      }
      paramInt = i;
      if (this.GIr != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.GIr);
      }
      i = paramInt;
      if (this.GIs != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.GIs);
      }
      paramInt = i;
      if (this.GIt != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.GIt);
      }
      i = paramInt;
      if (this.TRS != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.TRS);
      }
      paramInt = i;
      if (this.TRT != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.TRT);
      }
      AppMethodBeat.o(91612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91612);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dks localdks = (dks)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(91612);
          return -1;
        case 1: 
          localdks.GIh = locala.abFh.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 2: 
          localdks.TRD = locala.abFh.AK();
          AppMethodBeat.o(91612);
          return 0;
        case 3: 
          localdks.GIj = locala.abFh.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 4: 
          localdks.CreateTime = locala.abFh.AK();
          AppMethodBeat.o(91612);
          return 0;
        case 5: 
          localdks.GIk = locala.abFh.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 6: 
          localdks.GIl = locala.abFh.AK();
          AppMethodBeat.o(91612);
          return 0;
        case 7: 
          localdks.GIm = locala.abFh.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 8: 
          localdks.GIn = locala.abFh.AK();
          AppMethodBeat.o(91612);
          return 0;
        case 9: 
          localdks.GIo = locala.abFh.AK();
          AppMethodBeat.o(91612);
          return 0;
        case 11: 
          localdks.CQz = locala.abFh.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 12: 
          localdks.GIq = locala.abFh.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 13: 
          localdks.GIr = locala.abFh.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 14: 
          localdks.GIs = locala.abFh.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 15: 
          localdks.GIt = locala.abFh.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 18: 
          localdks.TRS = locala.abFh.readString();
          AppMethodBeat.o(91612);
          return 0;
        }
        localdks.TRT = locala.abFh.readString();
        AppMethodBeat.o(91612);
        return 0;
      }
      AppMethodBeat.o(91612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dks
 * JD-Core Version:    0.7.0.1
 */