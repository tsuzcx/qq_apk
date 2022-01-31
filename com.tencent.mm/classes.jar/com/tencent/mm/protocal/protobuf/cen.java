package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cen
  extends com.tencent.mm.bv.a
{
  public int rLq;
  public int rLr;
  public String wpV;
  public String wpW;
  public String wpX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94594);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wpV != null) {
        paramVarArgs.e(1, this.wpV);
      }
      if (this.wpW != null) {
        paramVarArgs.e(2, this.wpW);
      }
      if (this.wpX != null) {
        paramVarArgs.e(3, this.wpX);
      }
      paramVarArgs.aO(4, this.rLq);
      paramVarArgs.aO(5, this.rLr);
      AppMethodBeat.o(94594);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wpV == null) {
        break label426;
      }
    }
    label426:
    for (int i = e.a.a.b.b.a.f(1, this.wpV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wpW != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wpW);
      }
      i = paramInt;
      if (this.wpX != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wpX);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.rLq);
      int j = e.a.a.b.b.a.bl(5, this.rLr);
      AppMethodBeat.o(94594);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94594);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cen localcen = (cen)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94594);
          return -1;
        case 1: 
          localcen.wpV = locala.CLY.readString();
          AppMethodBeat.o(94594);
          return 0;
        case 2: 
          localcen.wpW = locala.CLY.readString();
          AppMethodBeat.o(94594);
          return 0;
        case 3: 
          localcen.wpX = locala.CLY.readString();
          AppMethodBeat.o(94594);
          return 0;
        case 4: 
          localcen.rLq = locala.CLY.sl();
          AppMethodBeat.o(94594);
          return 0;
        }
        localcen.rLr = locala.CLY.sl();
        AppMethodBeat.o(94594);
        return 0;
      }
      AppMethodBeat.o(94594);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cen
 * JD-Core Version:    0.7.0.1
 */