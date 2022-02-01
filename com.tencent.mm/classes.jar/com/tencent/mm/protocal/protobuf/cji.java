package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cji
  extends com.tencent.mm.cd.a
{
  public String OzZ;
  public String desc;
  public String lkF;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72498);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      if (this.lkF != null) {
        paramVarArgs.f(3, this.lkF);
      }
      if (this.OzZ != null) {
        paramVarArgs.f(4, this.OzZ);
      }
      AppMethodBeat.o(72498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.desc);
      }
      i = paramInt;
      if (this.lkF != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lkF);
      }
      paramInt = i;
      if (this.OzZ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.OzZ);
      }
      AppMethodBeat.o(72498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72498);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cji localcji = (cji)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72498);
          return -1;
        case 1: 
          localcji.title = locala.abFh.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 2: 
          localcji.desc = locala.abFh.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 3: 
          localcji.lkF = locala.abFh.readString();
          AppMethodBeat.o(72498);
          return 0;
        }
        localcji.OzZ = locala.abFh.readString();
        AppMethodBeat.o(72498);
        return 0;
      }
      AppMethodBeat.o(72498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cji
 * JD-Core Version:    0.7.0.1
 */