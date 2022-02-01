package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esl
  extends com.tencent.mm.cd.a
{
  public int TZU;
  public LinkedList<String> TZW;
  public int Tei;
  public long Uuj;
  public int Uuk;
  public String lpy;
  
  public esl()
  {
    AppMethodBeat.i(152998);
    this.TZW = new LinkedList();
    AppMethodBeat.o(152998);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152999);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lpy != null) {
        paramVarArgs.f(1, this.lpy);
      }
      paramVarArgs.bm(2, this.Uuj);
      paramVarArgs.aY(3, this.TZU);
      paramVarArgs.aY(4, this.Uuk);
      paramVarArgs.aY(5, this.Tei);
      paramVarArgs.e(6, 1, this.TZW);
      AppMethodBeat.o(152999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lpy == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = g.a.a.b.b.a.g(1, this.lpy) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.Uuj);
      int j = g.a.a.b.b.a.bM(3, this.TZU);
      int k = g.a.a.b.b.a.bM(4, this.Uuk);
      int m = g.a.a.b.b.a.bM(5, this.Tei);
      int n = g.a.a.a.c(6, 1, this.TZW);
      AppMethodBeat.o(152999);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TZW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152999);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        esl localesl = (esl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152999);
          return -1;
        case 1: 
          localesl.lpy = locala.abFh.readString();
          AppMethodBeat.o(152999);
          return 0;
        case 2: 
          localesl.Uuj = locala.abFh.AN();
          AppMethodBeat.o(152999);
          return 0;
        case 3: 
          localesl.TZU = locala.abFh.AK();
          AppMethodBeat.o(152999);
          return 0;
        case 4: 
          localesl.Uuk = locala.abFh.AK();
          AppMethodBeat.o(152999);
          return 0;
        case 5: 
          localesl.Tei = locala.abFh.AK();
          AppMethodBeat.o(152999);
          return 0;
        }
        localesl.TZW.add(locala.abFh.readString());
        AppMethodBeat.o(152999);
        return 0;
      }
      AppMethodBeat.o(152999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esl
 * JD-Core Version:    0.7.0.1
 */