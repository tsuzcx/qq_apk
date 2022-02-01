package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cih
  extends com.tencent.mm.bw.a
{
  public String KPG;
  public String KPH;
  public String KPI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43103);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KPH != null) {
        paramVarArgs.e(1, this.KPH);
      }
      if (this.KPG != null) {
        paramVarArgs.e(2, this.KPG);
      }
      if (this.KPI != null) {
        paramVarArgs.e(3, this.KPI);
      }
      AppMethodBeat.o(43103);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KPH == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.KPH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KPG != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KPG);
      }
      i = paramInt;
      if (this.KPI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KPI);
      }
      AppMethodBeat.o(43103);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(43103);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cih localcih = (cih)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43103);
          return -1;
        case 1: 
          localcih.KPH = locala.UbS.readString();
          AppMethodBeat.o(43103);
          return 0;
        case 2: 
          localcih.KPG = locala.UbS.readString();
          AppMethodBeat.o(43103);
          return 0;
        }
        localcih.KPI = locala.UbS.readString();
        AppMethodBeat.o(43103);
        return 0;
      }
      AppMethodBeat.o(43103);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cih
 * JD-Core Version:    0.7.0.1
 */