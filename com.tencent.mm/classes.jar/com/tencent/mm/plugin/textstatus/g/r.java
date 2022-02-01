package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  extends com.tencent.mm.bw.a
{
  public String GaO;
  public String GaP;
  public String GaQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222840);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GaO != null) {
        paramVarArgs.e(1, this.GaO);
      }
      if (this.GaP != null) {
        paramVarArgs.e(2, this.GaP);
      }
      if (this.GaQ != null) {
        paramVarArgs.e(3, this.GaQ);
      }
      AppMethodBeat.o(222840);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GaO == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.GaO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GaP != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.GaP);
      }
      i = paramInt;
      if (this.GaQ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.GaQ);
      }
      AppMethodBeat.o(222840);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(222840);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(222840);
          return -1;
        case 1: 
          localr.GaO = locala.UbS.readString();
          AppMethodBeat.o(222840);
          return 0;
        case 2: 
          localr.GaP = locala.UbS.readString();
          AppMethodBeat.o(222840);
          return 0;
        }
        localr.GaQ = locala.UbS.readString();
        AppMethodBeat.o(222840);
        return 0;
      }
      AppMethodBeat.o(222840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.r
 * JD-Core Version:    0.7.0.1
 */