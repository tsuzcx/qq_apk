package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ef
  extends com.tencent.mm.bw.a
{
  public int DQO;
  public String DQP;
  public String hOf;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hOf != null) {
        paramVarArgs.d(1, this.hOf);
      }
      paramVarArgs.aR(2, this.ndI);
      paramVarArgs.aR(3, this.DQO);
      if (this.DQP != null) {
        paramVarArgs.d(4, this.DQP);
      }
      AppMethodBeat.o(123539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hOf == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.hOf) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI) + f.a.a.b.b.a.bx(3, this.DQO);
      paramInt = i;
      if (this.DQP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DQP);
      }
      AppMethodBeat.o(123539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123539);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ef localef = (ef)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123539);
          return -1;
        case 1: 
          localef.hOf = locala.LVo.readString();
          AppMethodBeat.o(123539);
          return 0;
        case 2: 
          localef.ndI = locala.LVo.xF();
          AppMethodBeat.o(123539);
          return 0;
        case 3: 
          localef.DQO = locala.LVo.xF();
          AppMethodBeat.o(123539);
          return 0;
        }
        localef.DQP = locala.LVo.readString();
        AppMethodBeat.o(123539);
        return 0;
      }
      AppMethodBeat.o(123539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ef
 * JD-Core Version:    0.7.0.1
 */