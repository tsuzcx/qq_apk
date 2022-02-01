package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alj
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public int CRP;
  public int SaG;
  public String SuH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91446);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMP != null) {
        paramVarArgs.f(1, this.CMP);
      }
      paramVarArgs.aY(2, this.SaG);
      if (this.SuH != null) {
        paramVarArgs.f(3, this.SuH);
      }
      paramVarArgs.aY(4, this.CRP);
      AppMethodBeat.o(91446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMP == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.g(1, this.CMP) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SaG);
      paramInt = i;
      if (this.SuH != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SuH);
      }
      i = g.a.a.b.b.a.bM(4, this.CRP);
      AppMethodBeat.o(91446);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91446);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        alj localalj = (alj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91446);
          return -1;
        case 1: 
          localalj.CMP = locala.abFh.readString();
          AppMethodBeat.o(91446);
          return 0;
        case 2: 
          localalj.SaG = locala.abFh.AK();
          AppMethodBeat.o(91446);
          return 0;
        case 3: 
          localalj.SuH = locala.abFh.readString();
          AppMethodBeat.o(91446);
          return 0;
        }
        localalj.CRP = locala.abFh.AK();
        AppMethodBeat.o(91446);
        return 0;
      }
      AppMethodBeat.o(91446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alj
 * JD-Core Version:    0.7.0.1
 */