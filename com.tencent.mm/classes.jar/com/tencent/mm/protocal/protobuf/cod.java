package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cod
  extends com.tencent.mm.bx.a
{
  public String CNs;
  public String Eik;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117919);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CNs != null) {
        paramVarArgs.d(1, this.CNs);
      }
      if (this.Eik != null) {
        paramVarArgs.d(2, this.Eik);
      }
      AppMethodBeat.o(117919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNs == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.CNs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eik != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eik);
      }
      AppMethodBeat.o(117919);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117919);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cod localcod = (cod)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117919);
          return -1;
        case 1: 
          localcod.CNs = locala.KhF.readString();
          AppMethodBeat.o(117919);
          return 0;
        }
        localcod.Eik = locala.KhF.readString();
        AppMethodBeat.o(117919);
        return 0;
      }
      AppMethodBeat.o(117919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cod
 * JD-Core Version:    0.7.0.1
 */