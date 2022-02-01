package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bro
  extends com.tencent.mm.bw.a
{
  public String FgH;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.FgH != null) {
        paramVarArgs.d(2, this.FgH);
      }
      AppMethodBeat.o(177341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FgH != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FgH);
      }
      AppMethodBeat.o(177341);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(177341);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bro localbro = (bro)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(177341);
          return -1;
        case 1: 
          localbro.url = locala.LVo.readString();
          AppMethodBeat.o(177341);
          return 0;
        }
        localbro.FgH = locala.LVo.readString();
        AppMethodBeat.o(177341);
        return 0;
      }
      AppMethodBeat.o(177341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bro
 * JD-Core Version:    0.7.0.1
 */