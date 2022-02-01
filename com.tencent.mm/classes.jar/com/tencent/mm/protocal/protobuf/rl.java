package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rl
  extends com.tencent.mm.bx.a
{
  public String YWs;
  public String YWt;
  public String YWu;
  public long YWv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257641);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YWs != null) {
        paramVarArgs.g(1, this.YWs);
      }
      if (this.YWt != null) {
        paramVarArgs.g(2, this.YWt);
      }
      if (this.YWu != null) {
        paramVarArgs.g(3, this.YWu);
      }
      paramVarArgs.bv(4, this.YWv);
      AppMethodBeat.o(257641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YWs == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.YWs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YWt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YWt);
      }
      i = paramInt;
      if (this.YWu != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YWu);
      }
      paramInt = i.a.a.b.b.a.q(4, this.YWv);
      AppMethodBeat.o(257641);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257641);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        rl localrl = (rl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257641);
          return -1;
        case 1: 
          localrl.YWs = locala.ajGk.readString();
          AppMethodBeat.o(257641);
          return 0;
        case 2: 
          localrl.YWt = locala.ajGk.readString();
          AppMethodBeat.o(257641);
          return 0;
        case 3: 
          localrl.YWu = locala.ajGk.readString();
          AppMethodBeat.o(257641);
          return 0;
        }
        localrl.YWv = locala.ajGk.aaw();
        AppMethodBeat.o(257641);
        return 0;
      }
      AppMethodBeat.o(257641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rl
 * JD-Core Version:    0.7.0.1
 */