package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dra
  extends com.tencent.mm.bw.a
{
  public b HYa;
  public String HYb;
  public b HYc;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82480);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HYa != null) {
        paramVarArgs.c(1, this.HYa);
      }
      if (this.HYb != null) {
        paramVarArgs.d(2, this.HYb);
      }
      if (this.HYc != null) {
        paramVarArgs.c(3, this.HYc);
      }
      paramVarArgs.aS(4, this.uin);
      AppMethodBeat.o(82480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HYa == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.b(1, this.HYa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HYb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HYb);
      }
      i = paramInt;
      if (this.HYc != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.HYc);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.uin);
      AppMethodBeat.o(82480);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82480);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dra localdra = (dra)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82480);
          return -1;
        case 1: 
          localdra.HYa = locala.OmT.gCk();
          AppMethodBeat.o(82480);
          return 0;
        case 2: 
          localdra.HYb = locala.OmT.readString();
          AppMethodBeat.o(82480);
          return 0;
        case 3: 
          localdra.HYc = locala.OmT.gCk();
          AppMethodBeat.o(82480);
          return 0;
        }
        localdra.uin = locala.OmT.zc();
        AppMethodBeat.o(82480);
        return 0;
      }
      AppMethodBeat.o(82480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dra
 * JD-Core Version:    0.7.0.1
 */