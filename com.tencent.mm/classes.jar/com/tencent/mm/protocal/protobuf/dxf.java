package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dxf
  extends com.tencent.mm.bw.a
{
  public String FDc;
  public int FGG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32546);
        throw paramVarArgs;
      }
      if (this.FDc != null) {
        paramVarArgs.d(1, this.FDc);
      }
      paramVarArgs.aR(2, this.FGG);
      AppMethodBeat.o(32546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDc == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.FDc) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.FGG);
      AppMethodBeat.o(32546);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FDc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32546);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32546);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxf localdxf = (dxf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32546);
          return -1;
        case 1: 
          localdxf.FDc = locala.LVo.readString();
          AppMethodBeat.o(32546);
          return 0;
        }
        localdxf.FGG = locala.LVo.xF();
        AppMethodBeat.o(32546);
        return 0;
      }
      AppMethodBeat.o(32546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxf
 * JD-Core Version:    0.7.0.1
 */