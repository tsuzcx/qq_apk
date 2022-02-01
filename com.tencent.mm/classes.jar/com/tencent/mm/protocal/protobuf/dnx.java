package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dnx
  extends com.tencent.mm.bw.a
{
  public int FVA;
  public long FVB;
  public b FVz;
  public int Height;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117938);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVz != null) {
        paramVarArgs.c(1, this.FVz);
      }
      paramVarArgs.aR(2, this.FVA);
      paramVarArgs.aO(3, this.FVB);
      paramVarArgs.aR(4, this.Width);
      paramVarArgs.aR(5, this.Height);
      AppMethodBeat.o(117938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FVz == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.b(1, this.FVz) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.FVA);
      int j = f.a.a.b.b.a.p(3, this.FVB);
      int k = f.a.a.b.b.a.bx(4, this.Width);
      int m = f.a.a.b.b.a.bx(5, this.Height);
      AppMethodBeat.o(117938);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117938);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dnx localdnx = (dnx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117938);
          return -1;
        case 1: 
          localdnx.FVz = locala.LVo.gfk();
          AppMethodBeat.o(117938);
          return 0;
        case 2: 
          localdnx.FVA = locala.LVo.xF();
          AppMethodBeat.o(117938);
          return 0;
        case 3: 
          localdnx.FVB = locala.LVo.xG();
          AppMethodBeat.o(117938);
          return 0;
        case 4: 
          localdnx.Width = locala.LVo.xF();
          AppMethodBeat.o(117938);
          return 0;
        }
        localdnx.Height = locala.LVo.xF();
        AppMethodBeat.o(117938);
        return 0;
      }
      AppMethodBeat.o(117938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnx
 * JD-Core Version:    0.7.0.1
 */