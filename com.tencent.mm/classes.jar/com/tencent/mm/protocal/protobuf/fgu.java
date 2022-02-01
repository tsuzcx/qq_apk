package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fgu
  extends com.tencent.mm.cd.a
{
  public String CNM;
  public String CRR;
  public String TVo;
  public String UHe;
  public String UHf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32506);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TVo != null) {
        paramVarArgs.f(1, this.TVo);
      }
      if (this.UHe != null) {
        paramVarArgs.f(2, this.UHe);
      }
      if (this.CRR != null) {
        paramVarArgs.f(3, this.CRR);
      }
      if (this.CNM != null) {
        paramVarArgs.f(4, this.CNM);
      }
      if (this.UHf != null) {
        paramVarArgs.f(5, this.UHf);
      }
      AppMethodBeat.o(32506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TVo == null) {
        break label465;
      }
    }
    label465:
    for (int i = g.a.a.b.b.a.g(1, this.TVo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UHe != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UHe);
      }
      i = paramInt;
      if (this.CRR != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRR);
      }
      paramInt = i;
      if (this.CNM != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CNM);
      }
      i = paramInt;
      if (this.UHf != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UHf);
      }
      AppMethodBeat.o(32506);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32506);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fgu localfgu = (fgu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32506);
          return -1;
        case 1: 
          localfgu.TVo = locala.abFh.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 2: 
          localfgu.UHe = locala.abFh.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 3: 
          localfgu.CRR = locala.abFh.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 4: 
          localfgu.CNM = locala.abFh.readString();
          AppMethodBeat.o(32506);
          return 0;
        }
        localfgu.UHf = locala.abFh.readString();
        AppMethodBeat.o(32506);
        return 0;
      }
      AppMethodBeat.o(32506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgu
 * JD-Core Version:    0.7.0.1
 */