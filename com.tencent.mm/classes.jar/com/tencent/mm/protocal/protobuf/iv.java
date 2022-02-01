package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class iv
  extends com.tencent.mm.bw.a
{
  public b DWH;
  public b DWI;
  public int DWJ;
  public b DWK;
  public int Scene;
  public int pAs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DWH != null) {
        paramVarArgs.c(1, this.DWH);
      }
      paramVarArgs.aR(2, this.pAs);
      if (this.DWI != null) {
        paramVarArgs.c(3, this.DWI);
      }
      paramVarArgs.aR(4, this.DWJ);
      if (this.DWK != null) {
        paramVarArgs.c(5, this.DWK);
      }
      paramVarArgs.aR(6, this.Scene);
      AppMethodBeat.o(133156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DWH == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.b(1, this.DWH) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.pAs);
      paramInt = i;
      if (this.DWI != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.DWI);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.DWJ);
      paramInt = i;
      if (this.DWK != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.DWK);
      }
      i = f.a.a.b.b.a.bx(6, this.Scene);
      AppMethodBeat.o(133156);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(133156);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        iv localiv = (iv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133156);
          return -1;
        case 1: 
          localiv.DWH = locala.LVo.gfk();
          AppMethodBeat.o(133156);
          return 0;
        case 2: 
          localiv.pAs = locala.LVo.xF();
          AppMethodBeat.o(133156);
          return 0;
        case 3: 
          localiv.DWI = locala.LVo.gfk();
          AppMethodBeat.o(133156);
          return 0;
        case 4: 
          localiv.DWJ = locala.LVo.xF();
          AppMethodBeat.o(133156);
          return 0;
        case 5: 
          localiv.DWK = locala.LVo.gfk();
          AppMethodBeat.o(133156);
          return 0;
        }
        localiv.Scene = locala.LVo.xF();
        AppMethodBeat.o(133156);
        return 0;
      }
      AppMethodBeat.o(133156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iv
 * JD-Core Version:    0.7.0.1
 */