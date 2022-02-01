package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bji
  extends com.tencent.mm.bw.a
{
  public b DWI;
  public b DWK;
  public int fZz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124514);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DWK != null) {
        paramVarArgs.c(1, this.DWK);
      }
      if (this.DWI != null) {
        paramVarArgs.c(2, this.DWI);
      }
      paramVarArgs.aR(3, this.fZz);
      AppMethodBeat.o(124514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DWK == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.b(1, this.DWK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DWI != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.DWI);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.fZz);
      AppMethodBeat.o(124514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124514);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bji localbji = (bji)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124514);
          return -1;
        case 1: 
          localbji.DWK = locala.LVo.gfk();
          AppMethodBeat.o(124514);
          return 0;
        case 2: 
          localbji.DWI = locala.LVo.gfk();
          AppMethodBeat.o(124514);
          return 0;
        }
        localbji.fZz = locala.LVo.xF();
        AppMethodBeat.o(124514);
        return 0;
      }
      AppMethodBeat.o(124514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bji
 * JD-Core Version:    0.7.0.1
 */