package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xr
  extends com.tencent.mm.bw.a
{
  public int GpC;
  public String dyI;
  public String title;
  public String wSB;
  public String yqC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      if (this.wSB != null) {
        paramVarArgs.d(3, this.wSB);
      }
      if (this.yqC != null) {
        paramVarArgs.d(4, this.yqC);
      }
      paramVarArgs.aS(5, this.GpC);
      AppMethodBeat.o(72459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = paramInt;
      if (this.wSB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wSB);
      }
      paramInt = i;
      if (this.yqC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.yqC);
      }
      i = f.a.a.b.b.a.bz(5, this.GpC);
      AppMethodBeat.o(72459);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72459);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        xr localxr = (xr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72459);
          return -1;
        case 1: 
          localxr.title = locala.OmT.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 2: 
          localxr.dyI = locala.OmT.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 3: 
          localxr.wSB = locala.OmT.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 4: 
          localxr.yqC = locala.OmT.readString();
          AppMethodBeat.o(72459);
          return 0;
        }
        localxr.GpC = locala.OmT.zc();
        AppMethodBeat.o(72459);
        return 0;
      }
      AppMethodBeat.o(72459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xr
 * JD-Core Version:    0.7.0.1
 */