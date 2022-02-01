package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cch
  extends com.tencent.mm.bw.a
{
  public int GVd;
  public String GVe;
  public int Gnw;
  public String yBZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yBZ != null) {
        paramVarArgs.d(1, this.yBZ);
      }
      paramVarArgs.aS(2, this.GVd);
      if (this.GVe != null) {
        paramVarArgs.d(3, this.GVe);
      }
      paramVarArgs.aS(4, this.Gnw);
      AppMethodBeat.o(116456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yBZ == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.yBZ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GVd);
      paramInt = i;
      if (this.GVe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GVe);
      }
      i = f.a.a.b.b.a.bz(4, this.Gnw);
      AppMethodBeat.o(116456);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116456);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cch localcch = (cch)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116456);
          return -1;
        case 1: 
          localcch.yBZ = locala.OmT.readString();
          AppMethodBeat.o(116456);
          return 0;
        case 2: 
          localcch.GVd = locala.OmT.zc();
          AppMethodBeat.o(116456);
          return 0;
        case 3: 
          localcch.GVe = locala.OmT.readString();
          AppMethodBeat.o(116456);
          return 0;
        }
        localcch.Gnw = locala.OmT.zc();
        AppMethodBeat.o(116456);
        return 0;
      }
      AppMethodBeat.o(116456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cch
 * JD-Core Version:    0.7.0.1
 */