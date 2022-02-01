package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class do
  extends com.tencent.mm.bw.a
{
  public String DQC;
  public String dlQ;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168751);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      if (this.DQC != null) {
        paramVarArgs.d(3, this.DQC);
      }
      AppMethodBeat.o(168751);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt;
      if (this.DQC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DQC);
      }
      AppMethodBeat.o(168751);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168751);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        do localdo = (do)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168751);
          return -1;
        case 1: 
          localdo.title = locala.LVo.readString();
          AppMethodBeat.o(168751);
          return 0;
        case 2: 
          localdo.dlQ = locala.LVo.readString();
          AppMethodBeat.o(168751);
          return 0;
        }
        localdo.DQC = locala.LVo.readString();
        AppMethodBeat.o(168751);
        return 0;
      }
      AppMethodBeat.o(168751);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.do
 * JD-Core Version:    0.7.0.1
 */