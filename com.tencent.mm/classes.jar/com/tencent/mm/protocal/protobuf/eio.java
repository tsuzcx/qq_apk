package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eio
  extends com.tencent.mm.bw.a
{
  public String IlO;
  public int IlP;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123704);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IlO != null) {
        paramVarArgs.d(1, this.IlO);
      }
      paramVarArgs.aS(2, this.scene);
      paramVarArgs.aS(3, this.IlP);
      AppMethodBeat.o(123704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IlO == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.IlO) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.scene);
      int j = f.a.a.b.b.a.bz(3, this.IlP);
      AppMethodBeat.o(123704);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123704);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eio localeio = (eio)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123704);
          return -1;
        case 1: 
          localeio.IlO = locala.OmT.readString();
          AppMethodBeat.o(123704);
          return 0;
        case 2: 
          localeio.scene = locala.OmT.zc();
          AppMethodBeat.o(123704);
          return 0;
        }
        localeio.IlP = locala.OmT.zc();
        AppMethodBeat.o(123704);
        return 0;
      }
      AppMethodBeat.o(123704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eio
 * JD-Core Version:    0.7.0.1
 */