package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awp
  extends com.tencent.mm.bx.a
{
  public String DvP;
  public dlh DvQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115839);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DvP != null) {
        paramVarArgs.d(1, this.DvP);
      }
      if (this.DvQ != null)
      {
        paramVarArgs.kX(2, this.DvQ.computeSize());
        this.DvQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115839);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DvP == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.DvP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DvQ != null) {
        i = paramInt + f.a.a.a.kW(2, this.DvQ.computeSize());
      }
      AppMethodBeat.o(115839);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(115839);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awp localawp = (awp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115839);
          return -1;
        case 1: 
          localawp.DvP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115839);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localawp.DvQ = ((dlh)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awp
 * JD-Core Version:    0.7.0.1
 */