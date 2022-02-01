package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class l
  extends esc
{
  public String YzL;
  public String YzN;
  public ac YzX;
  public a YzY;
  public int hAV = 268513600;
  public String wYI = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91320);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91320);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.YzL != null) {
        paramVarArgs.g(4, this.YzL);
      }
      if (this.YzN != null) {
        paramVarArgs.g(6, this.YzN);
      }
      if (this.YzX != null)
      {
        paramVarArgs.qD(7, this.YzX.computeSize());
        this.YzX.writeFields(paramVarArgs);
      }
      if (this.YzY != null)
      {
        paramVarArgs.qD(8, this.YzY.computeSize());
        this.YzY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91320);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label832;
      }
    }
    label832:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.YzL != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YzL);
      }
      paramInt = i;
      if (this.YzN != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YzN);
      }
      i = paramInt;
      if (this.YzX != null) {
        i = paramInt + i.a.a.a.qC(7, this.YzX.computeSize());
      }
      paramInt = i;
      if (this.YzY != null) {
        paramInt = i + i.a.a.a.qC(8, this.YzY.computeSize());
      }
      AppMethodBeat.o(91320);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91320);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91320);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(91320);
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
            locall.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91320);
          return 0;
        case 2: 
          locall.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91320);
          return 0;
        case 3: 
          locall.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 4: 
          locall.YzL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 6: 
          locall.YzN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ac();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ac)localObject2).parseFrom((byte[])localObject1);
            }
            locall.YzX = ((ac)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91320);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((a)localObject2).parseFrom((byte[])localObject1);
          }
          locall.YzY = ((a)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91320);
        return 0;
      }
      AppMethodBeat.o(91320);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.l
 * JD-Core Version:    0.7.0.1
 */