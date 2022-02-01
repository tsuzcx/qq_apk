package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anl
  extends com.tencent.mm.cd.a
{
  public String RTv;
  public String ScV;
  public int ScW;
  public String Skl;
  public String Skm;
  public String Skn;
  public int Sko;
  public String SxF;
  public int SxG;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127456);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Skl != null) {
        paramVarArgs.f(1, this.Skl);
      }
      if (this.Skm != null) {
        paramVarArgs.f(2, this.Skm);
      }
      if (this.Skn != null) {
        paramVarArgs.f(3, this.Skn);
      }
      paramVarArgs.aY(4, this.Sko);
      if (this.SxF != null) {
        paramVarArgs.f(5, this.SxF);
      }
      if (this.ScV != null) {
        paramVarArgs.f(6, this.ScV);
      }
      paramVarArgs.aY(7, this.ScW);
      if (this.RTv != null) {
        paramVarArgs.f(8, this.RTv);
      }
      paramVarArgs.aY(9, this.rVU);
      paramVarArgs.aY(10, this.SxG);
      AppMethodBeat.o(127456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Skl == null) {
        break label702;
      }
    }
    label702:
    for (int i = g.a.a.b.b.a.g(1, this.Skl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Skm != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Skm);
      }
      i = paramInt;
      if (this.Skn != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Skn);
      }
      i += g.a.a.b.b.a.bM(4, this.Sko);
      paramInt = i;
      if (this.SxF != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SxF);
      }
      i = paramInt;
      if (this.ScV != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ScV);
      }
      i += g.a.a.b.b.a.bM(7, this.ScW);
      paramInt = i;
      if (this.RTv != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RTv);
      }
      i = g.a.a.b.b.a.bM(9, this.rVU);
      int j = g.a.a.b.b.a.bM(10, this.SxG);
      AppMethodBeat.o(127456);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127456);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        anl localanl = (anl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127456);
          return -1;
        case 1: 
          localanl.Skl = locala.abFh.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 2: 
          localanl.Skm = locala.abFh.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 3: 
          localanl.Skn = locala.abFh.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 4: 
          localanl.Sko = locala.abFh.AK();
          AppMethodBeat.o(127456);
          return 0;
        case 5: 
          localanl.SxF = locala.abFh.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 6: 
          localanl.ScV = locala.abFh.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 7: 
          localanl.ScW = locala.abFh.AK();
          AppMethodBeat.o(127456);
          return 0;
        case 8: 
          localanl.RTv = locala.abFh.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 9: 
          localanl.rVU = locala.abFh.AK();
          AppMethodBeat.o(127456);
          return 0;
        }
        localanl.SxG = locala.abFh.AK();
        AppMethodBeat.o(127456);
        return 0;
      }
      AppMethodBeat.o(127456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anl
 * JD-Core Version:    0.7.0.1
 */