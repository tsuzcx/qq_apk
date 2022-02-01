package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fey
  extends com.tencent.mm.bx.a
{
  public SnsObject abCS;
  public etl abEE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125809);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abCS == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsObject");
        AppMethodBeat.o(125809);
        throw paramVarArgs;
      }
      if (this.abCS != null)
      {
        paramVarArgs.qD(1, this.abCS.computeSize());
        this.abCS.writeFields(paramVarArgs);
      }
      if (this.abEE != null)
      {
        paramVarArgs.qD(2, this.abEE.computeSize());
        this.abEE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abCS == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(1, this.abCS.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abEE != null) {
        i = paramInt + i.a.a.a.qC(2, this.abEE.computeSize());
      }
      AppMethodBeat.o(125809);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abCS == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsObject");
          AppMethodBeat.o(125809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fey localfey = (fey)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125809);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new SnsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((SnsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localfey.abCS = ((SnsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125809);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localfey.abEE = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125809);
        return 0;
      }
      AppMethodBeat.o(125809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fey
 * JD-Core Version:    0.7.0.1
 */