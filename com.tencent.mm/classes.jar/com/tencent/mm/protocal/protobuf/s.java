package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class s
  extends esc
{
  public String Hgk;
  public String OiN;
  public String YAg;
  public String YzN;
  public a YzY;
  public int hAV = 268513600;
  public String hWO;
  public String wYI = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91327);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91327);
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
      if (this.Hgk != null) {
        paramVarArgs.g(4, this.Hgk);
      }
      if (this.hWO != null) {
        paramVarArgs.g(5, this.hWO);
      }
      if (this.OiN != null) {
        paramVarArgs.g(7, this.OiN);
      }
      if (this.YzN != null) {
        paramVarArgs.g(8, this.YzN);
      }
      if (this.YzY != null)
      {
        paramVarArgs.qD(9, this.YzY.computeSize());
        this.YzY.writeFields(paramVarArgs);
      }
      if (this.YAg != null) {
        paramVarArgs.g(10, this.YAg);
      }
      AppMethodBeat.o(91327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.Hgk != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Hgk);
      }
      paramInt = i;
      if (this.hWO != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.hWO);
      }
      i = paramInt;
      if (this.OiN != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.OiN);
      }
      paramInt = i;
      if (this.YzN != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YzN);
      }
      i = paramInt;
      if (this.YzY != null) {
        i = paramInt + i.a.a.a.qC(9, this.YzY.computeSize());
      }
      paramInt = i;
      if (this.YAg != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YAg);
      }
      AppMethodBeat.o(91327);
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
          AppMethodBeat.o(91327);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91327);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        s locals = (s)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(91327);
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
            locals.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91327);
          return 0;
        case 2: 
          locals.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91327);
          return 0;
        case 3: 
          locals.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 4: 
          locals.Hgk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 5: 
          locals.hWO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 7: 
          locals.OiN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 8: 
          locals.YzN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91327);
          return 0;
        case 9: 
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
            locals.YzY = ((a)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91327);
          return 0;
        }
        locals.YAg = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91327);
        return 0;
      }
      AppMethodBeat.o(91327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.s
 * JD-Core Version:    0.7.0.1
 */