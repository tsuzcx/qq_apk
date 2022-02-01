package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class fpj
  extends com.tencent.mm.cd.a
{
  public String CNj;
  public String CqK;
  public String RIC;
  public int RTb;
  public float UNb;
  public float UNc;
  public int UNd;
  public String UNe;
  public String Uhd;
  public b Uhs;
  public String UserName;
  public String lVG;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117960);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uhd != null) {
        paramVarArgs.f(1, this.Uhd);
      }
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      if (this.CNj != null) {
        paramVarArgs.f(3, this.CNj);
      }
      if (this.UserName != null) {
        paramVarArgs.f(4, this.UserName);
      }
      paramVarArgs.aY(5, this.RTb);
      if (this.RIC != null) {
        paramVarArgs.f(6, this.RIC);
      }
      if (this.CqK != null) {
        paramVarArgs.f(7, this.CqK);
      }
      paramVarArgs.i(8, this.UNb);
      paramVarArgs.i(9, this.UNc);
      paramVarArgs.aY(10, this.UNd);
      if (this.lVG != null) {
        paramVarArgs.f(11, this.lVG);
      }
      if (this.UNe != null) {
        paramVarArgs.f(12, this.UNe);
      }
      if (this.Uhs != null) {
        paramVarArgs.c(13, this.Uhs);
      }
      AppMethodBeat.o(117960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Uhd == null) {
        break label884;
      }
    }
    label884:
    for (int i = g.a.a.b.b.a.g(1, this.Uhd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rWI);
      }
      i = paramInt;
      if (this.CNj != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CNj);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UserName);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RTb);
      paramInt = i;
      if (this.RIC != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RIC);
      }
      i = paramInt;
      if (this.CqK != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.CqK);
      }
      i = i + (g.a.a.b.b.a.gL(8) + 4) + (g.a.a.b.b.a.gL(9) + 4) + g.a.a.b.b.a.bM(10, this.UNd);
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.lVG);
      }
      i = paramInt;
      if (this.UNe != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.UNe);
      }
      paramInt = i;
      if (this.Uhs != null) {
        paramInt = i + g.a.a.b.b.a.b(13, this.Uhs);
      }
      AppMethodBeat.o(117960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117960);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fpj localfpj = (fpj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117960);
          return -1;
        case 1: 
          localfpj.Uhd = locala.abFh.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 2: 
          localfpj.rWI = locala.abFh.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 3: 
          localfpj.CNj = locala.abFh.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 4: 
          localfpj.UserName = locala.abFh.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 5: 
          localfpj.RTb = locala.abFh.AK();
          AppMethodBeat.o(117960);
          return 0;
        case 6: 
          localfpj.RIC = locala.abFh.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 7: 
          localfpj.CqK = locala.abFh.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 8: 
          localfpj.UNb = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(117960);
          return 0;
        case 9: 
          localfpj.UNc = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(117960);
          return 0;
        case 10: 
          localfpj.UNd = locala.abFh.AK();
          AppMethodBeat.o(117960);
          return 0;
        case 11: 
          localfpj.lVG = locala.abFh.readString();
          AppMethodBeat.o(117960);
          return 0;
        case 12: 
          localfpj.UNe = locala.abFh.readString();
          AppMethodBeat.o(117960);
          return 0;
        }
        localfpj.Uhs = locala.abFh.iUw();
        AppMethodBeat.o(117960);
        return 0;
      }
      AppMethodBeat.o(117960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpj
 * JD-Core Version:    0.7.0.1
 */