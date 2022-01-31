package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cke
  extends com.tencent.mm.bv.a
{
  public String kmm;
  public int weight;
  public String wqR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11819);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wqR != null) {
        paramVarArgs.e(1, this.wqR);
      }
      if (this.kmm != null) {
        paramVarArgs.e(2, this.kmm);
      }
      paramVarArgs.aO(3, this.weight);
      AppMethodBeat.o(11819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wqR == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = e.a.a.b.b.a.f(1, this.wqR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kmm != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.kmm);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.weight);
      AppMethodBeat.o(11819);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11819);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cke localcke = (cke)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11819);
          return -1;
        case 1: 
          localcke.wqR = locala.CLY.readString();
          AppMethodBeat.o(11819);
          return 0;
        case 2: 
          localcke.kmm = locala.CLY.readString();
          AppMethodBeat.o(11819);
          return 0;
        }
        localcke.weight = locala.CLY.sl();
        AppMethodBeat.o(11819);
        return 0;
      }
      AppMethodBeat.o(11819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cke
 * JD-Core Version:    0.7.0.1
 */