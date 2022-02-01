package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class bni
  extends com.tencent.mm.cd.a
{
  public String RIC;
  public int RXp;
  public String SYm;
  public String SYt;
  public String jUi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42637);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jUi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.SYt == null)
      {
        paramVarArgs = new b("Not all required fields were included: RecommendKey");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.jUi != null) {
        paramVarArgs.f(1, this.jUi);
      }
      if (this.SYt != null) {
        paramVarArgs.f(2, this.SYt);
      }
      if (this.RIC != null) {
        paramVarArgs.f(3, this.RIC);
      }
      paramVarArgs.aY(4, this.RXp);
      if (this.SYm != null) {
        paramVarArgs.f(5, this.SYm);
      }
      AppMethodBeat.o(42637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jUi == null) {
        break label534;
      }
    }
    label534:
    for (int i = g.a.a.b.b.a.g(1, this.jUi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SYt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SYt);
      }
      i = paramInt;
      if (this.RIC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RIC);
      }
      i += g.a.a.b.b.a.bM(4, this.RXp);
      paramInt = i;
      if (this.SYm != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SYm);
      }
      AppMethodBeat.o(42637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.jUi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        if (this.SYt == null)
        {
          paramVarArgs = new b("Not all required fields were included: RecommendKey");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42637);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bni localbni = (bni)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42637);
          return -1;
        case 1: 
          localbni.jUi = locala.abFh.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 2: 
          localbni.SYt = locala.abFh.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 3: 
          localbni.RIC = locala.abFh.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 4: 
          localbni.RXp = locala.abFh.AK();
          AppMethodBeat.o(42637);
          return 0;
        }
        localbni.SYm = locala.abFh.readString();
        AppMethodBeat.o(42637);
        return 0;
      }
      AppMethodBeat.o(42637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bni
 * JD-Core Version:    0.7.0.1
 */