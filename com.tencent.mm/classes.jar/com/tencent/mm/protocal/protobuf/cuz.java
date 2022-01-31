package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuz
  extends com.tencent.mm.bv.a
{
  public String gwY;
  public String xKK;
  public int ydI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28708);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xKK != null) {
        paramVarArgs.e(1, this.xKK);
      }
      if (this.gwY != null) {
        paramVarArgs.e(2, this.gwY);
      }
      paramVarArgs.aO(3, this.ydI);
      AppMethodBeat.o(28708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xKK == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = e.a.a.b.b.a.f(1, this.xKK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gwY != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.gwY);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.ydI);
      AppMethodBeat.o(28708);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28708);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cuz localcuz = (cuz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28708);
          return -1;
        case 1: 
          localcuz.xKK = locala.CLY.readString();
          AppMethodBeat.o(28708);
          return 0;
        case 2: 
          localcuz.gwY = locala.CLY.readString();
          AppMethodBeat.o(28708);
          return 0;
        }
        localcuz.ydI = locala.CLY.sl();
        AppMethodBeat.o(28708);
        return 0;
      }
      AppMethodBeat.o(28708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuz
 * JD-Core Version:    0.7.0.1
 */