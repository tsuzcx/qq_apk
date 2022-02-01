package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bab
  extends com.tencent.mm.cd.a
{
  public int RUA;
  public String SKd;
  public String SLD;
  public String SLE;
  public String SLF;
  public String SLG;
  public String SLH;
  public String SLI;
  public float SLJ;
  public int SLK;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231008);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SKd != null) {
        paramVarArgs.f(1, this.SKd);
      }
      paramVarArgs.aY(2, this.RUA);
      if (this.SLD != null) {
        paramVarArgs.f(3, this.SLD);
      }
      if (this.SLE != null) {
        paramVarArgs.f(4, this.SLE);
      }
      if (this.SLF != null) {
        paramVarArgs.f(5, this.SLF);
      }
      if (this.SLG != null) {
        paramVarArgs.f(6, this.SLG);
      }
      if (this.SLH != null) {
        paramVarArgs.f(7, this.SLH);
      }
      if (this.SLI != null) {
        paramVarArgs.f(8, this.SLI);
      }
      if (this.name != null) {
        paramVarArgs.f(9, this.name);
      }
      paramVarArgs.i(10, this.SLJ);
      paramVarArgs.aY(11, this.SLK);
      AppMethodBeat.o(231008);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SKd == null) {
        break label781;
      }
    }
    label781:
    for (paramInt = g.a.a.b.b.a.g(1, this.SKd) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RUA);
      paramInt = i;
      if (this.SLD != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SLD);
      }
      i = paramInt;
      if (this.SLE != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.SLE);
      }
      paramInt = i;
      if (this.SLF != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SLF);
      }
      i = paramInt;
      if (this.SLG != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.SLG);
      }
      paramInt = i;
      if (this.SLH != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SLH);
      }
      i = paramInt;
      if (this.SLI != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.SLI);
      }
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.name);
      }
      i = g.a.a.b.b.a.gL(10);
      int j = g.a.a.b.b.a.bM(11, this.SLK);
      AppMethodBeat.o(231008);
      return paramInt + (i + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231008);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bab localbab = (bab)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(231008);
          return -1;
        case 1: 
          localbab.SKd = locala.abFh.readString();
          AppMethodBeat.o(231008);
          return 0;
        case 2: 
          localbab.RUA = locala.abFh.AK();
          AppMethodBeat.o(231008);
          return 0;
        case 3: 
          localbab.SLD = locala.abFh.readString();
          AppMethodBeat.o(231008);
          return 0;
        case 4: 
          localbab.SLE = locala.abFh.readString();
          AppMethodBeat.o(231008);
          return 0;
        case 5: 
          localbab.SLF = locala.abFh.readString();
          AppMethodBeat.o(231008);
          return 0;
        case 6: 
          localbab.SLG = locala.abFh.readString();
          AppMethodBeat.o(231008);
          return 0;
        case 7: 
          localbab.SLH = locala.abFh.readString();
          AppMethodBeat.o(231008);
          return 0;
        case 8: 
          localbab.SLI = locala.abFh.readString();
          AppMethodBeat.o(231008);
          return 0;
        case 9: 
          localbab.name = locala.abFh.readString();
          AppMethodBeat.o(231008);
          return 0;
        case 10: 
          localbab.SLJ = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(231008);
          return 0;
        }
        localbab.SLK = locala.abFh.AK();
        AppMethodBeat.o(231008);
        return 0;
      }
      AppMethodBeat.o(231008);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bab
 * JD-Core Version:    0.7.0.1
 */