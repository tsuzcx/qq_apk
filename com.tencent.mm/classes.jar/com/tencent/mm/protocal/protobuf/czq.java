package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czq
  extends com.tencent.mm.bw.a
{
  public String BrH;
  public long MEU;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72541);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BrH != null) {
        paramVarArgs.e(1, this.BrH);
      }
      paramVarArgs.bb(2, this.MEU);
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      AppMethodBeat.o(72541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BrH == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.BrH) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.MEU);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.url);
      }
      AppMethodBeat.o(72541);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72541);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        czq localczq = (czq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72541);
          return -1;
        case 1: 
          localczq.BrH = locala.UbS.readString();
          AppMethodBeat.o(72541);
          return 0;
        case 2: 
          localczq.MEU = locala.UbS.zl();
          AppMethodBeat.o(72541);
          return 0;
        }
        localczq.url = locala.UbS.readString();
        AppMethodBeat.o(72541);
        return 0;
      }
      AppMethodBeat.o(72541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czq
 * JD-Core Version:    0.7.0.1
 */