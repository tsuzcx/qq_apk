package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class k
  extends esc
{
  public i acjc;
  public j acjd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259687);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.acjc != null)
      {
        paramVarArgs.qD(2, this.acjc.computeSize());
        this.acjc.writeFields(paramVarArgs);
      }
      if (this.acjd != null)
      {
        paramVarArgs.qD(3, this.acjd.computeSize());
        this.acjd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259687);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.acjc != null) {
        paramInt = i + i.a.a.a.qC(2, this.acjc.computeSize());
      }
      i = paramInt;
      if (this.acjd != null) {
        i = paramInt + i.a.a.a.qC(3, this.acjd.computeSize());
      }
      AppMethodBeat.o(259687);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259687);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259687);
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
            localk.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259687);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new i();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((i)localObject2).parseFrom((byte[])localObject1);
            }
            localk.acjc = ((i)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259687);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new j();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((j)localObject2).parseFrom((byte[])localObject1);
          }
          localk.acjd = ((j)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259687);
        return 0;
      }
      AppMethodBeat.o(259687);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.k
 * JD-Core Version:    0.7.0.1
 */