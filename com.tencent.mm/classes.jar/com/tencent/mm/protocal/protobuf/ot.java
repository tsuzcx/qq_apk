package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ot
  extends com.tencent.mm.bx.a
{
  public ow YRT;
  public String YRU;
  public String YRV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124421);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRT != null)
      {
        paramVarArgs.qD(1, this.YRT.computeSize());
        this.YRT.writeFields(paramVarArgs);
      }
      if (this.YRU != null) {
        paramVarArgs.g(2, this.YRU);
      }
      if (this.YRV != null) {
        paramVarArgs.g(3, this.YRV);
      }
      AppMethodBeat.o(124421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRT == null) {
        break label404;
      }
    }
    label404:
    for (int i = i.a.a.a.qC(1, this.YRT.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YRU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YRU);
      }
      i = paramInt;
      if (this.YRV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YRV);
      }
      AppMethodBeat.o(124421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ot localot = (ot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124421);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ow localow = new ow();
            if ((localObject != null) && (localObject.length > 0)) {
              localow.parseFrom((byte[])localObject);
            }
            localot.YRT = localow;
            paramInt += 1;
          }
          AppMethodBeat.o(124421);
          return 0;
        case 2: 
          localot.YRU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124421);
          return 0;
        }
        localot.YRV = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(124421);
        return 0;
      }
      AppMethodBeat.o(124421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ot
 * JD-Core Version:    0.7.0.1
 */