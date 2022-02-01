package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bx.a
{
  public m zNZ;
  public String zOb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91291);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zNZ != null)
      {
        paramVarArgs.kX(1, this.zNZ.computeSize());
        this.zNZ.writeFields(paramVarArgs);
      }
      if (this.zOb != null) {
        paramVarArgs.d(2, this.zOb);
      }
      AppMethodBeat.o(91291);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zNZ == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.a.kW(1, this.zNZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.zOb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.zOb);
      }
      AppMethodBeat.o(91291);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91291);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91291);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.zNZ = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91291);
          return 0;
        }
        localg.zOb = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91291);
        return 0;
      }
      AppMethodBeat.o(91291);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.g
 * JD-Core Version:    0.7.0.1
 */