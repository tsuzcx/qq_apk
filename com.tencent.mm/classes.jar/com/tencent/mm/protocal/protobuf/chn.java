package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chn
  extends com.tencent.mm.bw.a
{
  public String FvK;
  public int FvL;
  public String dlQ;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104374);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlQ != null) {
        paramVarArgs.d(1, this.dlQ);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.FvK != null) {
        paramVarArgs.d(3, this.FvK);
      }
      paramVarArgs.aR(4, this.FvL);
      AppMethodBeat.o(104374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlQ == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.dlQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.FvK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FvK);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.FvL);
      AppMethodBeat.o(104374);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104374);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chn localchn = (chn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104374);
          return -1;
        case 1: 
          localchn.dlQ = locala.LVo.readString();
          AppMethodBeat.o(104374);
          return 0;
        case 2: 
          localchn.url = locala.LVo.readString();
          AppMethodBeat.o(104374);
          return 0;
        case 3: 
          localchn.FvK = locala.LVo.readString();
          AppMethodBeat.o(104374);
          return 0;
        }
        localchn.FvL = locala.LVo.xF();
        AppMethodBeat.o(104374);
        return 0;
      }
      AppMethodBeat.o(104374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chn
 * JD-Core Version:    0.7.0.1
 */