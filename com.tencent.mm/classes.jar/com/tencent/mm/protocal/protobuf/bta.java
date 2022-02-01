package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bta
  extends com.tencent.mm.bw.a
{
  public String dlQ;
  public String unW;
  public String unX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlQ != null) {
        paramVarArgs.d(1, this.dlQ);
      }
      if (this.unW != null) {
        paramVarArgs.d(2, this.unW);
      }
      if (this.unX != null) {
        paramVarArgs.d(4, this.unX);
      }
      AppMethodBeat.o(72513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlQ == null) {
        break label338;
      }
    }
    label338:
    for (int i = f.a.a.b.b.a.e(1, this.dlQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.unW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.unW);
      }
      i = paramInt;
      if (this.unX != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.unX);
      }
      AppMethodBeat.o(72513);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72513);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bta localbta = (bta)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(72513);
          return -1;
        case 1: 
          localbta.dlQ = locala.LVo.readString();
          AppMethodBeat.o(72513);
          return 0;
        case 2: 
          localbta.unW = locala.LVo.readString();
          AppMethodBeat.o(72513);
          return 0;
        }
        localbta.unX = locala.LVo.readString();
        AppMethodBeat.o(72513);
        return 0;
      }
      AppMethodBeat.o(72513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bta
 * JD-Core Version:    0.7.0.1
 */