package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dr
  extends com.tencent.mm.bx.a
{
  public String odc;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.signature != null) {
        paramVarArgs.d(1, this.signature);
      }
      if (this.odc != null) {
        paramVarArgs.d(2, this.odc);
      }
      AppMethodBeat.o(152489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.signature == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.signature) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.odc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.odc);
      }
      AppMethodBeat.o(152489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152489);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dr localdr = (dr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152489);
          return -1;
        case 1: 
          localdr.signature = locala.KhF.readString();
          AppMethodBeat.o(152489);
          return 0;
        }
        localdr.odc = locala.KhF.readString();
        AppMethodBeat.o(152489);
        return 0;
      }
      AppMethodBeat.o(152489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dr
 * JD-Core Version:    0.7.0.1
 */