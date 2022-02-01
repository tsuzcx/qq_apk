package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyl
  extends com.tencent.mm.bw.a
{
  public int FHF;
  public int FHG;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152694);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      paramVarArgs.aR(2, this.FHF);
      paramVarArgs.aR(3, this.FHG);
      AppMethodBeat.o(152694);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.FHF);
      int j = f.a.a.b.b.a.bx(3, this.FHG);
      AppMethodBeat.o(152694);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152694);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cyl localcyl = (cyl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152694);
          return -1;
        case 1: 
          localcyl.url = locala.LVo.readString();
          AppMethodBeat.o(152694);
          return 0;
        case 2: 
          localcyl.FHF = locala.LVo.xF();
          AppMethodBeat.o(152694);
          return 0;
        }
        localcyl.FHG = locala.LVo.xF();
        AppMethodBeat.o(152694);
        return 0;
      }
      AppMethodBeat.o(152694);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyl
 * JD-Core Version:    0.7.0.1
 */