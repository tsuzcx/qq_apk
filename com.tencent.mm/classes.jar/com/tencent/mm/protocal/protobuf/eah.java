package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eah
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public int CreateTime;
  public String RMK;
  public String Sll;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134254);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMP != null) {
        paramVarArgs.f(1, this.CMP);
      }
      if (this.Sll != null) {
        paramVarArgs.f(2, this.Sll);
      }
      if (this.RMK != null) {
        paramVarArgs.f(3, this.RMK);
      }
      paramVarArgs.aY(4, this.CreateTime);
      AppMethodBeat.o(134254);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMP == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.CMP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Sll != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Sll);
      }
      i = paramInt;
      if (this.RMK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RMK);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.CreateTime);
      AppMethodBeat.o(134254);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(134254);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eah localeah = (eah)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134254);
          return -1;
        case 1: 
          localeah.CMP = locala.abFh.readString();
          AppMethodBeat.o(134254);
          return 0;
        case 2: 
          localeah.Sll = locala.abFh.readString();
          AppMethodBeat.o(134254);
          return 0;
        case 3: 
          localeah.RMK = locala.abFh.readString();
          AppMethodBeat.o(134254);
          return 0;
        }
        localeah.CreateTime = locala.abFh.AK();
        AppMethodBeat.o(134254);
        return 0;
      }
      AppMethodBeat.o(134254);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eah
 * JD-Core Version:    0.7.0.1
 */