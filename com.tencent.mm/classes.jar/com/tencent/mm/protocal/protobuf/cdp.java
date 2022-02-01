package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdp
  extends com.tencent.mm.bw.a
{
  public long Fsp;
  public String url;
  public String xpb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72541);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xpb != null) {
        paramVarArgs.d(1, this.xpb);
      }
      paramVarArgs.aO(2, this.Fsp);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      AppMethodBeat.o(72541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xpb == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.xpb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Fsp);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      AppMethodBeat.o(72541);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72541);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cdp localcdp = (cdp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72541);
          return -1;
        case 1: 
          localcdp.xpb = locala.LVo.readString();
          AppMethodBeat.o(72541);
          return 0;
        case 2: 
          localcdp.Fsp = locala.LVo.xG();
          AppMethodBeat.o(72541);
          return 0;
        }
        localcdp.url = locala.LVo.readString();
        AppMethodBeat.o(72541);
        return 0;
      }
      AppMethodBeat.o(72541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdp
 * JD-Core Version:    0.7.0.1
 */