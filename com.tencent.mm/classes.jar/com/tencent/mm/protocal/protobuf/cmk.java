package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmk
  extends com.tencent.mm.bw.a
{
  public String FzH;
  public String FzI;
  public int FzJ;
  public int FzK = 0;
  public String FzL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117895);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FzH != null) {
        paramVarArgs.d(1, this.FzH);
      }
      if (this.FzI != null) {
        paramVarArgs.d(2, this.FzI);
      }
      paramVarArgs.aR(3, this.FzJ);
      paramVarArgs.aR(4, this.FzK);
      if (this.FzL != null) {
        paramVarArgs.d(5, this.FzL);
      }
      AppMethodBeat.o(117895);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FzH == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.FzH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FzI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FzI);
      }
      i = i + f.a.a.b.b.a.bx(3, this.FzJ) + f.a.a.b.b.a.bx(4, this.FzK);
      paramInt = i;
      if (this.FzL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FzL);
      }
      AppMethodBeat.o(117895);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117895);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cmk localcmk = (cmk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117895);
          return -1;
        case 1: 
          localcmk.FzH = locala.LVo.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 2: 
          localcmk.FzI = locala.LVo.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 3: 
          localcmk.FzJ = locala.LVo.xF();
          AppMethodBeat.o(117895);
          return 0;
        case 4: 
          localcmk.FzK = locala.LVo.xF();
          AppMethodBeat.o(117895);
          return 0;
        }
        localcmk.FzL = locala.LVo.readString();
        AppMethodBeat.o(117895);
        return 0;
      }
      AppMethodBeat.o(117895);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmk
 * JD-Core Version:    0.7.0.1
 */