package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anv
  extends com.tencent.mm.bw.a
{
  public String EFm;
  public float dmL;
  public float doB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164044);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EFm != null) {
        paramVarArgs.d(1, this.EFm);
      }
      paramVarArgs.x(2, this.doB);
      paramVarArgs.x(3, this.dmL);
      AppMethodBeat.o(164044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFm == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = f.a.a.b.b.a.e(1, this.EFm) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(164044);
      return paramInt + (i + 4) + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(164044);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        anv localanv = (anv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(164044);
          return -1;
        case 1: 
          localanv.EFm = locala.LVo.readString();
          AppMethodBeat.o(164044);
          return 0;
        case 2: 
          localanv.doB = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(164044);
          return 0;
        }
        localanv.dmL = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(164044);
        return 0;
      }
      AppMethodBeat.o(164044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anv
 * JD-Core Version:    0.7.0.1
 */