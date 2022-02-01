package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhh
  extends esc
{
  public bgq ZMY;
  public bmh ZQT;
  public String app_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257784);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.g(2, this.app_id);
      }
      if (this.ZQT != null)
      {
        paramVarArgs.qD(3, this.ZQT.computeSize());
        this.ZQT.writeFields(paramVarArgs);
      }
      if (this.ZMY != null)
      {
        paramVarArgs.qD(4, this.ZMY.computeSize());
        this.ZMY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257784);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label608;
      }
    }
    label608:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.app_id);
      }
      i = paramInt;
      if (this.ZQT != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZQT.computeSize());
      }
      paramInt = i;
      if (this.ZMY != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZMY.computeSize());
      }
      AppMethodBeat.o(257784);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257784);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bhh localbhh = (bhh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257784);
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
            localbhh.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257784);
          return 0;
        case 2: 
          localbhh.app_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257784);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmh)localObject2).parseFrom((byte[])localObject1);
            }
            localbhh.ZQT = ((bmh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257784);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bgq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bgq)localObject2).parseFrom((byte[])localObject1);
          }
          localbhh.ZMY = ((bgq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257784);
        return 0;
      }
      AppMethodBeat.o(257784);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhh
 * JD-Core Version:    0.7.0.1
 */