package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxp
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public int MCa;
  public String MCb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50095);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MCa);
      if (this.IconUrl != null) {
        paramVarArgs.e(2, this.IconUrl);
      }
      if (this.MCb != null) {
        paramVarArgs.e(3, this.MCb);
      }
      AppMethodBeat.o(50095);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MCa) + 0;
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.IconUrl);
      }
      i = paramInt;
      if (this.MCb != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MCb);
      }
      AppMethodBeat.o(50095);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(50095);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cxp localcxp = (cxp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50095);
        return -1;
      case 1: 
        localcxp.MCa = locala.UbS.zi();
        AppMethodBeat.o(50095);
        return 0;
      case 2: 
        localcxp.IconUrl = locala.UbS.readString();
        AppMethodBeat.o(50095);
        return 0;
      }
      localcxp.MCb = locala.UbS.readString();
      AppMethodBeat.o(50095);
      return 0;
    }
    AppMethodBeat.o(50095);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxp
 * JD-Core Version:    0.7.0.1
 */