package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axz
  extends com.tencent.mm.cd.a
{
  public String SKs;
  public String SKt;
  public String SKu;
  public String SKv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230014);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SKs != null) {
        paramVarArgs.f(1, this.SKs);
      }
      if (this.SKt != null) {
        paramVarArgs.f(2, this.SKt);
      }
      if (this.SKu != null) {
        paramVarArgs.f(101, this.SKu);
      }
      if (this.SKv != null) {
        paramVarArgs.f(102, this.SKv);
      }
      AppMethodBeat.o(230014);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SKs == null) {
        break label410;
      }
    }
    label410:
    for (int i = g.a.a.b.b.a.g(1, this.SKs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SKt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SKt);
      }
      i = paramInt;
      if (this.SKu != null) {
        i = paramInt + g.a.a.b.b.a.g(101, this.SKu);
      }
      paramInt = i;
      if (this.SKv != null) {
        paramInt = i + g.a.a.b.b.a.g(102, this.SKv);
      }
      AppMethodBeat.o(230014);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230014);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        axz localaxz = (axz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(230014);
          return -1;
        case 1: 
          localaxz.SKs = locala.abFh.readString();
          AppMethodBeat.o(230014);
          return 0;
        case 2: 
          localaxz.SKt = locala.abFh.readString();
          AppMethodBeat.o(230014);
          return 0;
        case 101: 
          localaxz.SKu = locala.abFh.readString();
          AppMethodBeat.o(230014);
          return 0;
        }
        localaxz.SKv = locala.abFh.readString();
        AppMethodBeat.o(230014);
        return 0;
      }
      AppMethodBeat.o(230014);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axz
 * JD-Core Version:    0.7.0.1
 */