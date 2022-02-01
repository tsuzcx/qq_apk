package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bw.a
{
  public String HEn;
  public String HEo;
  public String HEp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91290);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.HEn != null) {
        paramVarArgs.e(1, this.HEn);
      }
      if (this.HEo != null) {
        paramVarArgs.e(2, this.HEo);
      }
      if (this.HEp != null) {
        paramVarArgs.e(3, this.HEp);
      }
      AppMethodBeat.o(91290);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HEn == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.HEn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HEo != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.HEo);
      }
      i = paramInt;
      if (this.HEp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.HEp);
      }
      AppMethodBeat.o(91290);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91290);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91290);
          return -1;
        case 1: 
          localf.HEn = locala.UbS.readString();
          AppMethodBeat.o(91290);
          return 0;
        case 2: 
          localf.HEo = locala.UbS.readString();
          AppMethodBeat.o(91290);
          return 0;
        }
        localf.HEp = locala.UbS.readString();
        AppMethodBeat.o(91290);
        return 0;
      }
      AppMethodBeat.o(91290);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.f
 * JD-Core Version:    0.7.0.1
 */