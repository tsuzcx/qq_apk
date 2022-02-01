package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xy
  extends com.tencent.mm.bx.a
{
  public xx ZgN;
  public xx ZgO;
  public xx ZgP;
  public xx ZgQ;
  public xx ZgR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113984);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZgN != null)
      {
        paramVarArgs.qD(1, this.ZgN.computeSize());
        this.ZgN.writeFields(paramVarArgs);
      }
      if (this.ZgO != null)
      {
        paramVarArgs.qD(2, this.ZgO.computeSize());
        this.ZgO.writeFields(paramVarArgs);
      }
      if (this.ZgP != null)
      {
        paramVarArgs.qD(3, this.ZgP.computeSize());
        this.ZgP.writeFields(paramVarArgs);
      }
      if (this.ZgQ != null)
      {
        paramVarArgs.qD(4, this.ZgQ.computeSize());
        this.ZgQ.writeFields(paramVarArgs);
      }
      if (this.ZgR != null)
      {
        paramVarArgs.qD(5, this.ZgR.computeSize());
        this.ZgR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZgN == null) {
        break label812;
      }
    }
    label812:
    for (int i = i.a.a.a.qC(1, this.ZgN.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZgO != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZgO.computeSize());
      }
      i = paramInt;
      if (this.ZgP != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZgP.computeSize());
      }
      paramInt = i;
      if (this.ZgQ != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZgQ.computeSize());
      }
      i = paramInt;
      if (this.ZgR != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZgR.computeSize());
      }
      AppMethodBeat.o(113984);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        xy localxy = (xy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        xx localxx;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113984);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localxx = new xx();
            if ((localObject != null) && (localObject.length > 0)) {
              localxx.parseFrom((byte[])localObject);
            }
            localxy.ZgN = localxx;
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localxx = new xx();
            if ((localObject != null) && (localObject.length > 0)) {
              localxx.parseFrom((byte[])localObject);
            }
            localxy.ZgO = localxx;
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localxx = new xx();
            if ((localObject != null) && (localObject.length > 0)) {
              localxx.parseFrom((byte[])localObject);
            }
            localxy.ZgP = localxx;
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localxx = new xx();
            if ((localObject != null) && (localObject.length > 0)) {
              localxx.parseFrom((byte[])localObject);
            }
            localxy.ZgQ = localxx;
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localxx = new xx();
          if ((localObject != null) && (localObject.length > 0)) {
            localxx.parseFrom((byte[])localObject);
          }
          localxy.ZgR = localxx;
          paramInt += 1;
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      AppMethodBeat.o(113984);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xy
 * JD-Core Version:    0.7.0.1
 */