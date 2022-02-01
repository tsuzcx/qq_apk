package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqx
  extends com.tencent.mm.bw.a
{
  public String LYu;
  public esq LYv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115839);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LYu != null) {
        paramVarArgs.e(1, this.LYu);
      }
      if (this.LYv != null)
      {
        paramVarArgs.ni(2, this.LYv.computeSize());
        this.LYv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115839);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LYu == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.LYu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LYv != null) {
        i = paramInt + g.a.a.a.nh(2, this.LYv.computeSize());
      }
      AppMethodBeat.o(115839);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(115839);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqx localbqx = (bqx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115839);
          return -1;
        case 1: 
          localbqx.LYu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115839);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new esq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((esq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbqx.LYv = ((esq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115839);
        return 0;
      }
      AppMethodBeat.o(115839);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqx
 * JD-Core Version:    0.7.0.1
 */