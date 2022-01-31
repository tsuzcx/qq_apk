package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdo
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String xOg;
  public int xOh;
  public String xOi;
  public int xOj;
  public int xpo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94565);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xOg != null) {
        paramVarArgs.e(1, this.xOg);
      }
      paramVarArgs.aO(2, this.xOh);
      if (this.jJA != null) {
        paramVarArgs.e(3, this.jJA);
      }
      if (this.xOi != null) {
        paramVarArgs.e(4, this.xOi);
      }
      paramVarArgs.aO(5, this.xpo);
      paramVarArgs.aO(6, this.xOj);
      AppMethodBeat.o(94565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xOg == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = e.a.a.b.b.a.f(1, this.xOg) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xOh);
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.jJA);
      }
      i = paramInt;
      if (this.xOi != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xOi);
      }
      paramInt = e.a.a.b.b.a.bl(5, this.xpo);
      int j = e.a.a.b.b.a.bl(6, this.xOj);
      AppMethodBeat.o(94565);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94565);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cdo localcdo = (cdo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94565);
          return -1;
        case 1: 
          localcdo.xOg = locala.CLY.readString();
          AppMethodBeat.o(94565);
          return 0;
        case 2: 
          localcdo.xOh = locala.CLY.sl();
          AppMethodBeat.o(94565);
          return 0;
        case 3: 
          localcdo.jJA = locala.CLY.readString();
          AppMethodBeat.o(94565);
          return 0;
        case 4: 
          localcdo.xOi = locala.CLY.readString();
          AppMethodBeat.o(94565);
          return 0;
        case 5: 
          localcdo.xpo = locala.CLY.sl();
          AppMethodBeat.o(94565);
          return 0;
        }
        localcdo.xOj = locala.CLY.sl();
        AppMethodBeat.o(94565);
        return 0;
      }
      AppMethodBeat.o(94565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdo
 * JD-Core Version:    0.7.0.1
 */