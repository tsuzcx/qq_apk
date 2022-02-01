package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public final class au
  extends dyy
{
  public am HnB;
  public ay HnC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250249);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HnB != null)
      {
        paramVarArgs.oE(2, this.HnB.computeSize());
        this.HnB.writeFields(paramVarArgs);
      }
      if (this.HnC != null)
      {
        paramVarArgs.oE(3, this.HnC.computeSize());
        this.HnC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(250249);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label552;
      }
    }
    label552:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HnB != null) {
        paramInt = i + g.a.a.a.oD(2, this.HnB.computeSize());
      }
      i = paramInt;
      if (this.HnC != null) {
        i = paramInt + g.a.a.a.oD(3, this.HnC.computeSize());
      }
      AppMethodBeat.o(250249);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250249);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        au localau = (au)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250249);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localau.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250249);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new am();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((am)localObject2).parseFrom((byte[])localObject1);
            }
            localau.HnB = ((am)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250249);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ay();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ay)localObject2).parseFrom((byte[])localObject1);
          }
          localau.HnC = ((ay)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250249);
        return 0;
      }
      AppMethodBeat.o(250249);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.au
 * JD-Core Version:    0.7.0.1
 */