package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dus
  extends com.tencent.mm.bx.a
{
  public b CIu;
  public String DII;
  public String dlB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123700);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DII != null) {
        paramVarArgs.d(1, this.DII);
      }
      if (this.CIu != null) {
        paramVarArgs.c(2, this.CIu);
      }
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      AppMethodBeat.o(123700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DII == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.DII) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CIu != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.CIu);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlB);
      }
      AppMethodBeat.o(123700);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123700);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dus localdus = (dus)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123700);
          return -1;
        case 1: 
          localdus.DII = locala.KhF.readString();
          AppMethodBeat.o(123700);
          return 0;
        case 2: 
          localdus.CIu = locala.KhF.fMu();
          AppMethodBeat.o(123700);
          return 0;
        }
        localdus.dlB = locala.KhF.readString();
        AppMethodBeat.o(123700);
        return 0;
      }
      AppMethodBeat.o(123700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dus
 * JD-Core Version:    0.7.0.1
 */