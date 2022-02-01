package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dwx
  extends com.tencent.mm.bw.a
{
  public String FDc;
  public long GdF;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32536);
        throw paramVarArgs;
      }
      if (this.ndW == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(32536);
        throw paramVarArgs;
      }
      if (this.FDc != null) {
        paramVarArgs.d(1, this.FDc);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      paramVarArgs.aO(3, this.GdF);
      AppMethodBeat.o(32536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDc == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.FDc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ndW);
      }
      paramInt = f.a.a.b.b.a.p(3, this.GdF);
      AppMethodBeat.o(32536);
      return i + paramInt;
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
          AppMethodBeat.o(32536);
          throw paramVarArgs;
        }
        if (this.ndW == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(32536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32536);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dwx localdwx = (dwx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32536);
          return -1;
        case 1: 
          localdwx.FDc = locala.LVo.readString();
          AppMethodBeat.o(32536);
          return 0;
        case 2: 
          localdwx.ndW = locala.LVo.readString();
          AppMethodBeat.o(32536);
          return 0;
        }
        localdwx.GdF = locala.LVo.xG();
        AppMethodBeat.o(32536);
        return 0;
      }
      AppMethodBeat.o(32536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwx
 * JD-Core Version:    0.7.0.1
 */