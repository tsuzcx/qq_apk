package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crp
  extends com.tencent.mm.bw.a
{
  public long MwA;
  public String MwB;
  public long jii;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208703);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.MwA);
      paramVarArgs.bb(2, this.jii);
      if (this.MwB != null) {
        paramVarArgs.e(3, this.MwB);
      }
      AppMethodBeat.o(208703);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.MwA) + 0 + g.a.a.b.b.a.r(2, this.jii);
      paramInt = i;
      if (this.MwB != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MwB);
      }
      AppMethodBeat.o(208703);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(208703);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      crp localcrp = (crp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208703);
        return -1;
      case 1: 
        localcrp.MwA = locala.UbS.zl();
        AppMethodBeat.o(208703);
        return 0;
      case 2: 
        localcrp.jii = locala.UbS.zl();
        AppMethodBeat.o(208703);
        return 0;
      }
      localcrp.MwB = locala.UbS.readString();
      AppMethodBeat.o(208703);
      return 0;
    }
    AppMethodBeat.o(208703);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crp
 * JD-Core Version:    0.7.0.1
 */