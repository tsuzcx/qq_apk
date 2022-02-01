package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sx
  extends com.tencent.mm.bw.a
{
  public String LaR;
  public String dWw;
  public String dXf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LaR != null) {
        paramVarArgs.e(1, this.LaR);
      }
      if (this.dWw != null) {
        paramVarArgs.e(2, this.dWw);
      }
      if (this.dXf != null) {
        paramVarArgs.e(3, this.dXf);
      }
      AppMethodBeat.o(72426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LaR == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.LaR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dWw != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dWw);
      }
      i = paramInt;
      if (this.dXf != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dXf);
      }
      AppMethodBeat.o(72426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72426);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        sx localsx = (sx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72426);
          return -1;
        case 1: 
          localsx.LaR = locala.UbS.readString();
          AppMethodBeat.o(72426);
          return 0;
        case 2: 
          localsx.dWw = locala.UbS.readString();
          AppMethodBeat.o(72426);
          return 0;
        }
        localsx.dXf = locala.UbS.readString();
        AppMethodBeat.o(72426);
        return 0;
      }
      AppMethodBeat.o(72426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sx
 * JD-Core Version:    0.7.0.1
 */