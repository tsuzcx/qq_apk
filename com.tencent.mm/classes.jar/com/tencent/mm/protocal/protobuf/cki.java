package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cki
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public String Md5;
  public String RNi;
  public String ScV;
  public String SuY;
  public String TrU;
  public String Url;
  public int rWo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32325);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SuY != null) {
        paramVarArgs.f(1, this.SuY);
      }
      if (this.CMP != null) {
        paramVarArgs.f(2, this.CMP);
      }
      paramVarArgs.aY(3, this.rWo);
      if (this.Md5 != null) {
        paramVarArgs.f(4, this.Md5);
      }
      if (this.RNi != null) {
        paramVarArgs.f(5, this.RNi);
      }
      if (this.ScV != null) {
        paramVarArgs.f(6, this.ScV);
      }
      if (this.Url != null) {
        paramVarArgs.f(7, this.Url);
      }
      if (this.TrU != null) {
        paramVarArgs.f(8, this.TrU);
      }
      AppMethodBeat.o(32325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SuY == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = g.a.a.b.b.a.g(1, this.SuY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CMP != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CMP);
      }
      i += g.a.a.b.b.a.bM(3, this.rWo);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Md5);
      }
      i = paramInt;
      if (this.RNi != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RNi);
      }
      paramInt = i;
      if (this.ScV != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ScV);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Url);
      }
      paramInt = i;
      if (this.TrU != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TrU);
      }
      AppMethodBeat.o(32325);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32325);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cki localcki = (cki)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32325);
          return -1;
        case 1: 
          localcki.SuY = locala.abFh.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 2: 
          localcki.CMP = locala.abFh.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 3: 
          localcki.rWo = locala.abFh.AK();
          AppMethodBeat.o(32325);
          return 0;
        case 4: 
          localcki.Md5 = locala.abFh.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 5: 
          localcki.RNi = locala.abFh.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 6: 
          localcki.ScV = locala.abFh.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 7: 
          localcki.Url = locala.abFh.readString();
          AppMethodBeat.o(32325);
          return 0;
        }
        localcki.TrU = locala.abFh.readString();
        AppMethodBeat.o(32325);
        return 0;
      }
      AppMethodBeat.o(32325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cki
 * JD-Core Version:    0.7.0.1
 */