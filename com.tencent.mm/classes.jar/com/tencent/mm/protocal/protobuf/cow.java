package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cow
  extends esc
{
  public fq aavM;
  public bb aavN;
  public LinkedList<gjh> aavO;
  
  public cow()
  {
    AppMethodBeat.i(152584);
    this.aavO = new LinkedList();
    AppMethodBeat.o(152584);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152585);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aavM != null)
      {
        paramVarArgs.qD(2, this.aavM.computeSize());
        this.aavM.writeFields(paramVarArgs);
      }
      if (this.aavN != null)
      {
        paramVarArgs.qD(3, this.aavN.computeSize());
        this.aavN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.aavO);
      AppMethodBeat.o(152585);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label670;
      }
    }
    label670:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aavM != null) {
        paramInt = i + i.a.a.a.qC(2, this.aavM.computeSize());
      }
      i = paramInt;
      if (this.aavN != null) {
        i = paramInt + i.a.a.a.qC(3, this.aavN.computeSize());
      }
      paramInt = i.a.a.a.c(4, 8, this.aavO);
      AppMethodBeat.o(152585);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aavO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152585);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cow localcow = (cow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152585);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcow.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152585);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fq)localObject2).parseFrom((byte[])localObject1);
            }
            localcow.aavM = ((fq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152585);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bb)localObject2).parseFrom((byte[])localObject1);
            }
            localcow.aavN = ((bb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152585);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gjh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gjh)localObject2).parseFrom((byte[])localObject1);
          }
          localcow.aavO.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152585);
        return 0;
      }
      AppMethodBeat.o(152585);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cow
 * JD-Core Version:    0.7.0.1
 */