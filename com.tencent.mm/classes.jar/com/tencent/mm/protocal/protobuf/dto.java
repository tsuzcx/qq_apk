package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dto
  extends com.tencent.mm.bx.a
{
  public b HGn;
  public int HGo;
  public long HGp;
  public int Height;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117938);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGn != null) {
        paramVarArgs.c(1, this.HGn);
      }
      paramVarArgs.aS(2, this.HGo);
      paramVarArgs.aY(3, this.HGp);
      paramVarArgs.aS(4, this.Width);
      paramVarArgs.aS(5, this.Height);
      AppMethodBeat.o(117938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HGn == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.b(1, this.HGn) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HGo);
      int j = f.a.a.b.b.a.p(3, this.HGp);
      int k = f.a.a.b.b.a.bz(4, this.Width);
      int m = f.a.a.b.b.a.bz(5, this.Height);
      AppMethodBeat.o(117938);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117938);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dto localdto = (dto)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117938);
          return -1;
        case 1: 
          localdto.HGn = locala.NPN.gxI();
          AppMethodBeat.o(117938);
          return 0;
        case 2: 
          localdto.HGo = locala.NPN.zc();
          AppMethodBeat.o(117938);
          return 0;
        case 3: 
          localdto.HGp = locala.NPN.zd();
          AppMethodBeat.o(117938);
          return 0;
        case 4: 
          localdto.Width = locala.NPN.zc();
          AppMethodBeat.o(117938);
          return 0;
        }
        localdto.Height = locala.NPN.zc();
        AppMethodBeat.o(117938);
        return 0;
      }
      AppMethodBeat.o(117938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dto
 * JD-Core Version:    0.7.0.1
 */