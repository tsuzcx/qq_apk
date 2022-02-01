package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aur
  extends dyy
{
  public int SCU;
  public int SDW;
  public bac liveInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231436);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.liveInfo != null)
      {
        paramVarArgs.oE(2, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.SDW);
      paramVarArgs.aY(4, this.SCU);
      AppMethodBeat.o(231436);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.liveInfo != null) {
        i = paramInt + g.a.a.a.oD(2, this.liveInfo.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(3, this.SDW);
      int j = g.a.a.b.b.a.bM(4, this.SCU);
      AppMethodBeat.o(231436);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231436);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aur localaur = (aur)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231436);
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
            localaur.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231436);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bac();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bac)localObject2).parseFrom((byte[])localObject1);
            }
            localaur.liveInfo = ((bac)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231436);
          return 0;
        case 3: 
          localaur.SDW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(231436);
          return 0;
        }
        localaur.SCU = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(231436);
        return 0;
      }
      AppMethodBeat.o(231436);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aur
 * JD-Core Version:    0.7.0.1
 */