package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxw
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public int jJu;
  public int jKs;
  public String nul;
  public String woU;
  public int xtf;
  public int yfb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28761);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nul != null) {
        paramVarArgs.e(1, this.nul);
      }
      paramVarArgs.aO(2, this.jKs);
      paramVarArgs.aO(3, this.jJu);
      paramVarArgs.aO(4, this.CreateTime);
      paramVarArgs.aO(5, this.xtf);
      if (this.woU != null) {
        paramVarArgs.e(6, this.woU);
      }
      paramVarArgs.aO(7, this.yfb);
      AppMethodBeat.o(28761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nul == null) {
        break label507;
      }
    }
    label507:
    for (paramInt = e.a.a.b.b.a.f(1, this.nul) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKs) + e.a.a.b.b.a.bl(3, this.jJu) + e.a.a.b.b.a.bl(4, this.CreateTime) + e.a.a.b.b.a.bl(5, this.xtf);
      paramInt = i;
      if (this.woU != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.woU);
      }
      i = e.a.a.b.b.a.bl(7, this.yfb);
      AppMethodBeat.o(28761);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28761);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cxw localcxw = (cxw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28761);
          return -1;
        case 1: 
          localcxw.nul = locala.CLY.readString();
          AppMethodBeat.o(28761);
          return 0;
        case 2: 
          localcxw.jKs = locala.CLY.sl();
          AppMethodBeat.o(28761);
          return 0;
        case 3: 
          localcxw.jJu = locala.CLY.sl();
          AppMethodBeat.o(28761);
          return 0;
        case 4: 
          localcxw.CreateTime = locala.CLY.sl();
          AppMethodBeat.o(28761);
          return 0;
        case 5: 
          localcxw.xtf = locala.CLY.sl();
          AppMethodBeat.o(28761);
          return 0;
        case 6: 
          localcxw.woU = locala.CLY.readString();
          AppMethodBeat.o(28761);
          return 0;
        }
        localcxw.yfb = locala.CLY.sl();
        AppMethodBeat.o(28761);
        return 0;
      }
      AppMethodBeat.o(28761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxw
 * JD-Core Version:    0.7.0.1
 */