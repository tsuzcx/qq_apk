package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cte
  extends com.tencent.mm.cd.a
{
  public String TAZ;
  public String TBa;
  public int jump_type;
  public String qpi;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250892);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      paramVarArgs.aY(2, this.jump_type);
      if (this.qpi != null) {
        paramVarArgs.f(3, this.qpi);
      }
      if (this.TAZ != null) {
        paramVarArgs.f(4, this.TAZ);
      }
      if (this.TBa != null) {
        paramVarArgs.f(5, this.TBa);
      }
      AppMethodBeat.o(250892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.g(1, this.wording) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.jump_type);
      paramInt = i;
      if (this.qpi != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.qpi);
      }
      i = paramInt;
      if (this.TAZ != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TAZ);
      }
      paramInt = i;
      if (this.TBa != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TBa);
      }
      AppMethodBeat.o(250892);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250892);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cte localcte = (cte)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(250892);
          return -1;
        case 1: 
          localcte.wording = locala.abFh.readString();
          AppMethodBeat.o(250892);
          return 0;
        case 2: 
          localcte.jump_type = locala.abFh.AK();
          AppMethodBeat.o(250892);
          return 0;
        case 3: 
          localcte.qpi = locala.abFh.readString();
          AppMethodBeat.o(250892);
          return 0;
        case 4: 
          localcte.TAZ = locala.abFh.readString();
          AppMethodBeat.o(250892);
          return 0;
        }
        localcte.TBa = locala.abFh.readString();
        AppMethodBeat.o(250892);
        return 0;
      }
      AppMethodBeat.o(250892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cte
 * JD-Core Version:    0.7.0.1
 */