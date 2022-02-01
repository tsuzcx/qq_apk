package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class jc
  extends com.tencent.mm.bw.a
{
  public int FUA;
  public b FUB;
  public b FUy;
  public b FUz;
  public int Scene;
  public int qkC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUy != null) {
        paramVarArgs.c(1, this.FUy);
      }
      paramVarArgs.aS(2, this.qkC);
      if (this.FUz != null) {
        paramVarArgs.c(3, this.FUz);
      }
      paramVarArgs.aS(4, this.FUA);
      if (this.FUB != null) {
        paramVarArgs.c(5, this.FUB);
      }
      paramVarArgs.aS(6, this.Scene);
      AppMethodBeat.o(133156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FUy == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.b(1, this.FUy) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qkC);
      paramInt = i;
      if (this.FUz != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.FUz);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.FUA);
      paramInt = i;
      if (this.FUB != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.FUB);
      }
      i = f.a.a.b.b.a.bz(6, this.Scene);
      AppMethodBeat.o(133156);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(133156);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        jc localjc = (jc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133156);
          return -1;
        case 1: 
          localjc.FUy = locala.OmT.gCk();
          AppMethodBeat.o(133156);
          return 0;
        case 2: 
          localjc.qkC = locala.OmT.zc();
          AppMethodBeat.o(133156);
          return 0;
        case 3: 
          localjc.FUz = locala.OmT.gCk();
          AppMethodBeat.o(133156);
          return 0;
        case 4: 
          localjc.FUA = locala.OmT.zc();
          AppMethodBeat.o(133156);
          return 0;
        case 5: 
          localjc.FUB = locala.OmT.gCk();
          AppMethodBeat.o(133156);
          return 0;
        }
        localjc.Scene = locala.OmT.zc();
        AppMethodBeat.o(133156);
        return 0;
      }
      AppMethodBeat.o(133156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jc
 * JD-Core Version:    0.7.0.1
 */