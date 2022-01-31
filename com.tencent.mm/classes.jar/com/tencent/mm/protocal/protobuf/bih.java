package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bih
  extends com.tencent.mm.bv.a
{
  public String gfM;
  public int xxu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80136);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfM != null) {
        paramVarArgs.e(1, this.gfM);
      }
      paramVarArgs.aO(2, this.xxu);
      AppMethodBeat.o(80136);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfM == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = e.a.a.b.b.a.f(1, this.gfM) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xxu);
      AppMethodBeat.o(80136);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80136);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bih localbih = (bih)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80136);
          return -1;
        case 1: 
          localbih.gfM = locala.CLY.readString();
          AppMethodBeat.o(80136);
          return 0;
        }
        localbih.xxu = locala.CLY.sl();
        AppMethodBeat.o(80136);
        return 0;
      }
      AppMethodBeat.o(80136);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bih
 * JD-Core Version:    0.7.0.1
 */