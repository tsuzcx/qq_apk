package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bil
  extends com.tencent.mm.bv.a
{
  public String cAr;
  public String gfM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80140);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfM != null) {
        paramVarArgs.e(1, this.gfM);
      }
      if (this.cAr != null) {
        paramVarArgs.e(2, this.cAr);
      }
      AppMethodBeat.o(80140);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfM == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.gfM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cAr != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cAr);
      }
      AppMethodBeat.o(80140);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80140);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bil localbil = (bil)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80140);
          return -1;
        case 1: 
          localbil.gfM = locala.CLY.readString();
          AppMethodBeat.o(80140);
          return 0;
        }
        localbil.cAr = locala.CLY.readString();
        AppMethodBeat.o(80140);
        return 0;
      }
      AppMethodBeat.o(80140);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bil
 * JD-Core Version:    0.7.0.1
 */