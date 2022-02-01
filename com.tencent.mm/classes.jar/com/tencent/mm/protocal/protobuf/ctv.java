package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ctv
  extends com.tencent.mm.bw.a
{
  public int FFu;
  public int FFv;
  public b FFw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149128);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FFu);
      paramVarArgs.aR(2, this.FFv);
      if (this.FFw != null) {
        paramVarArgs.c(3, this.FFw);
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FFu) + 0 + f.a.a.b.b.a.bx(2, this.FFv);
      paramInt = i;
      if (this.FFw != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.FFw);
      }
      AppMethodBeat.o(149128);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ctv localctv = (ctv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149128);
        return -1;
      case 1: 
        localctv.FFu = locala.LVo.xF();
        AppMethodBeat.o(149128);
        return 0;
      case 2: 
        localctv.FFv = locala.LVo.xF();
        AppMethodBeat.o(149128);
        return 0;
      }
      localctv.FFw = locala.LVo.gfk();
      AppMethodBeat.o(149128);
      return 0;
    }
    AppMethodBeat.o(149128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctv
 * JD-Core Version:    0.7.0.1
 */