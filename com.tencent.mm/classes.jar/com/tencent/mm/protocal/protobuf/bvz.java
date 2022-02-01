package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvz
  extends com.tencent.mm.bx.a
{
  public int DSS;
  public String hNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152651);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hNH != null) {
        paramVarArgs.d(1, this.hNH);
      }
      paramVarArgs.aR(2, this.DSS);
      AppMethodBeat.o(152651);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hNH == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.hNH) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DSS);
      AppMethodBeat.o(152651);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152651);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvz localbvz = (bvz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152651);
          return -1;
        case 1: 
          localbvz.hNH = locala.KhF.readString();
          AppMethodBeat.o(152651);
          return 0;
        }
        localbvz.DSS = locala.KhF.xS();
        AppMethodBeat.o(152651);
        return 0;
      }
      AppMethodBeat.o(152651);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvz
 * JD-Core Version:    0.7.0.1
 */