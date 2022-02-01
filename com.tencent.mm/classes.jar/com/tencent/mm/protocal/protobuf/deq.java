package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class deq
  extends com.tencent.mm.bx.a
{
  public awq YGb;
  public float latitude;
  public float longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258544);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGb != null)
      {
        paramVarArgs.qD(1, this.YGb.computeSize());
        this.YGb.writeFields(paramVarArgs);
      }
      paramVarArgs.l(2, this.longitude);
      paramVarArgs.l(3, this.latitude);
      AppMethodBeat.o(258544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGb == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = i.a.a.a.qC(1, this.YGb.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(258544);
      return paramInt + (i + 4) + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        deq localdeq = (deq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258544);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            awq localawq = new awq();
            if ((localObject != null) && (localObject.length > 0)) {
              localawq.parseFrom((byte[])localObject);
            }
            localdeq.YGb = localawq;
            paramInt += 1;
          }
          AppMethodBeat.o(258544);
          return 0;
        case 2: 
          localdeq.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(258544);
          return 0;
        }
        localdeq.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
        AppMethodBeat.o(258544);
        return 0;
      }
      AppMethodBeat.o(258544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deq
 * JD-Core Version:    0.7.0.1
 */