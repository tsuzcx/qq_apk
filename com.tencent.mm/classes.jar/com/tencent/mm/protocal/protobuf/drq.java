package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drq
  extends com.tencent.mm.bw.a
{
  public String HLI;
  public int HLM;
  public String HLO;
  public String content;
  public int dmy;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153308);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HLO != null) {
        paramVarArgs.d(1, this.HLO);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.content != null) {
        paramVarArgs.d(3, this.content);
      }
      if (this.HLI != null) {
        paramVarArgs.d(4, this.HLI);
      }
      paramVarArgs.aS(5, this.HLM);
      paramVarArgs.aS(6, this.state);
      AppMethodBeat.o(153308);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HLO == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.e(1, this.HLO) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.content);
      }
      i = paramInt;
      if (this.HLI != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HLI);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.HLM);
      int j = f.a.a.b.b.a.bz(6, this.state);
      AppMethodBeat.o(153308);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153308);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        drq localdrq = (drq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153308);
          return -1;
        case 1: 
          localdrq.HLO = locala.OmT.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 2: 
          localdrq.dmy = locala.OmT.zc();
          AppMethodBeat.o(153308);
          return 0;
        case 3: 
          localdrq.content = locala.OmT.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 4: 
          localdrq.HLI = locala.OmT.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 5: 
          localdrq.HLM = locala.OmT.zc();
          AppMethodBeat.o(153308);
          return 0;
        }
        localdrq.state = locala.OmT.zc();
        AppMethodBeat.o(153308);
        return 0;
      }
      AppMethodBeat.o(153308);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drq
 * JD-Core Version:    0.7.0.1
 */