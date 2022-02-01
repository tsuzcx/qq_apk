package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqo
  extends com.tencent.mm.bx.a
{
  public clf CLb;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117944);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CLb != null)
      {
        paramVarArgs.kX(1, this.CLb.computeSize());
        this.CLb.writeFields(paramVarArgs);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      AppMethodBeat.o(117944);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLb == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.a.kW(1, this.CLb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mAQ);
      }
      AppMethodBeat.o(117944);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117944);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqo localdqo = (dqo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117944);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((clf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqo.CLb = ((clf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117944);
          return 0;
        }
        localdqo.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117944);
        return 0;
      }
      AppMethodBeat.o(117944);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqo
 * JD-Core Version:    0.7.0.1
 */