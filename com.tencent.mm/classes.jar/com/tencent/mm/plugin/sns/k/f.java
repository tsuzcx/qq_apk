package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class f
  extends com.tencent.mm.bx.a
{
  public int QCG;
  public String QCH;
  public long QCI;
  public String hHB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(306336);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hHB != null) {
        paramVarArgs.g(1, this.hHB);
      }
      paramVarArgs.bS(2, this.QCG);
      if (this.QCH != null) {
        paramVarArgs.g(3, this.QCH);
      }
      paramVarArgs.bv(4, this.QCI);
      AppMethodBeat.o(306336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hHB == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = i.a.a.b.b.a.h(1, this.hHB) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.QCG);
      paramInt = i;
      if (this.QCH != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.QCH);
      }
      i = i.a.a.b.b.a.q(4, this.QCI);
      AppMethodBeat.o(306336);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(306336);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(306336);
          return -1;
        case 1: 
          localf.hHB = locala.ajGk.readString();
          AppMethodBeat.o(306336);
          return 0;
        case 2: 
          localf.QCG = locala.ajGk.aar();
          AppMethodBeat.o(306336);
          return 0;
        case 3: 
          localf.QCH = locala.ajGk.readString();
          AppMethodBeat.o(306336);
          return 0;
        }
        localf.QCI = locala.ajGk.aaw();
        AppMethodBeat.o(306336);
        return 0;
      }
      AppMethodBeat.o(306336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.f
 * JD-Core Version:    0.7.0.1
 */