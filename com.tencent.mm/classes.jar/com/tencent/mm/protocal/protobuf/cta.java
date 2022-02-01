package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cta
  extends com.tencent.mm.cd.a
{
  public String RRg;
  public int SXb;
  public String TAF;
  public int TAH;
  public String UUID;
  public String UserName;
  public int rVU;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(269001);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UUID != null) {
        paramVarArgs.f(1, this.UUID);
      }
      paramVarArgs.aY(2, this.rVU);
      if (this.UserName != null) {
        paramVarArgs.f(3, this.UserName);
      }
      if (this.RRg != null) {
        paramVarArgs.f(4, this.RRg);
      }
      if (this.TAF != null) {
        paramVarArgs.f(5, this.TAF);
      }
      paramVarArgs.aY(6, this.TAH);
      if (this.rWI != null) {
        paramVarArgs.f(7, this.rWI);
      }
      paramVarArgs.aY(8, this.SXb);
      AppMethodBeat.o(269001);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UUID == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = g.a.a.b.b.a.g(1, this.UUID) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rVU);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UserName);
      }
      i = paramInt;
      if (this.RRg != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RRg);
      }
      paramInt = i;
      if (this.TAF != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TAF);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.TAH);
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.rWI);
      }
      i = g.a.a.b.b.a.bM(8, this.SXb);
      AppMethodBeat.o(269001);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(269001);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cta localcta = (cta)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(269001);
          return -1;
        case 1: 
          localcta.UUID = locala.abFh.readString();
          AppMethodBeat.o(269001);
          return 0;
        case 2: 
          localcta.rVU = locala.abFh.AK();
          AppMethodBeat.o(269001);
          return 0;
        case 3: 
          localcta.UserName = locala.abFh.readString();
          AppMethodBeat.o(269001);
          return 0;
        case 4: 
          localcta.RRg = locala.abFh.readString();
          AppMethodBeat.o(269001);
          return 0;
        case 5: 
          localcta.TAF = locala.abFh.readString();
          AppMethodBeat.o(269001);
          return 0;
        case 6: 
          localcta.TAH = locala.abFh.AK();
          AppMethodBeat.o(269001);
          return 0;
        case 7: 
          localcta.rWI = locala.abFh.readString();
          AppMethodBeat.o(269001);
          return 0;
        }
        localcta.SXb = locala.abFh.AK();
        AppMethodBeat.o(269001);
        return 0;
      }
      AppMethodBeat.o(269001);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cta
 * JD-Core Version:    0.7.0.1
 */