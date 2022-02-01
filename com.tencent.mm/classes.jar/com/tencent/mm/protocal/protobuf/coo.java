package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class coo
  extends com.tencent.mm.bx.a
{
  public int Eiw;
  public int Eix;
  public b Eiy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149128);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Eiw);
      paramVarArgs.aR(2, this.Eix);
      if (this.Eiy != null) {
        paramVarArgs.c(3, this.Eiy);
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Eiw) + 0 + f.a.a.b.b.a.bA(2, this.Eix);
      paramInt = i;
      if (this.Eiy != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Eiy);
      }
      AppMethodBeat.o(149128);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      coo localcoo = (coo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149128);
        return -1;
      case 1: 
        localcoo.Eiw = locala.KhF.xS();
        AppMethodBeat.o(149128);
        return 0;
      case 2: 
        localcoo.Eix = locala.KhF.xS();
        AppMethodBeat.o(149128);
        return 0;
      }
      localcoo.Eiy = locala.KhF.fMu();
      AppMethodBeat.o(149128);
      return 0;
    }
    AppMethodBeat.o(149128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coo
 * JD-Core Version:    0.7.0.1
 */