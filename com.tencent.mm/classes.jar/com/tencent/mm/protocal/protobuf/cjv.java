package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cjv
  extends esc
{
  public String ZpZ;
  public int aast;
  public String aasu;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104372);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104372);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.ZpZ != null) {
        paramVarArgs.g(4, this.ZpZ);
      }
      paramVarArgs.bS(5, this.aast);
      if (this.aasu != null) {
        paramVarArgs.g(6, this.aasu);
      }
      AppMethodBeat.o(104372);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label604;
      }
    }
    label604:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.ZpZ != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZpZ);
      }
      i += i.a.a.b.b.a.cJ(5, this.aast);
      paramInt = i;
      if (this.aasu != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aasu);
      }
      AppMethodBeat.o(104372);
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
          AppMethodBeat.o(104372);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104372);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cjv localcjv = (cjv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104372);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localcjv.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(104372);
          return 0;
        case 2: 
          localcjv.wuz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104372);
          return 0;
        case 3: 
          localcjv.wuA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104372);
          return 0;
        case 4: 
          localcjv.ZpZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104372);
          return 0;
        case 5: 
          localcjv.aast = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104372);
          return 0;
        }
        localcjv.aasu = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(104372);
        return 0;
      }
      AppMethodBeat.o(104372);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjv
 * JD-Core Version:    0.7.0.1
 */