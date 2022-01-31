package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fz
  extends com.tencent.mm.bv.a
{
  public String fnF;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96197);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      if (this.fnF != null) {
        paramVarArgs.e(2, this.fnF);
      }
      AppMethodBeat.o(96197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fnF != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.fnF);
      }
      AppMethodBeat.o(96197);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96197);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        fz localfz = (fz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96197);
          return -1;
        case 1: 
          localfz.key = locala.CLY.readString();
          AppMethodBeat.o(96197);
          return 0;
        }
        localfz.fnF = locala.CLY.readString();
        AppMethodBeat.o(96197);
        return 0;
      }
      AppMethodBeat.o(96197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fz
 * JD-Core Version:    0.7.0.1
 */