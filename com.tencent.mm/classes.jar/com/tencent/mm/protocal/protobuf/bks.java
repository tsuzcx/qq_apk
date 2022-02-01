package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bks
  extends com.tencent.mm.bx.a
{
  public bcc ZMQ;
  public aui ZMX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259574);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZMQ != null)
      {
        paramVarArgs.qD(1, this.ZMQ.computeSize());
        this.ZMQ.writeFields(paramVarArgs);
      }
      if (this.ZMX != null)
      {
        paramVarArgs.qD(2, this.ZMX.computeSize());
        this.ZMX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZMQ == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.ZMQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZMX != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZMX.computeSize());
      }
      AppMethodBeat.o(259574);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259574);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bks localbks = (bks)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259574);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcc)localObject2).parseFrom((byte[])localObject1);
            }
            localbks.ZMQ = ((bcc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259574);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aui();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aui)localObject2).parseFrom((byte[])localObject1);
          }
          localbks.ZMX = ((aui)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259574);
        return 0;
      }
      AppMethodBeat.o(259574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bks
 * JD-Core Version:    0.7.0.1
 */