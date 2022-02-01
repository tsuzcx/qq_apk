package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class kr
  extends esc
{
  public LinkedList<gb> YMM;
  public LinkedList<euj> YMN;
  
  public kr()
  {
    AppMethodBeat.i(6396);
    this.YMM = new LinkedList();
    this.YMN = new LinkedList();
    AppMethodBeat.o(6396);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6397);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(6397);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YMM);
      paramVarArgs.e(3, 8, this.YMN);
      AppMethodBeat.o(6397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label581;
      }
    }
    label581:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.YMM);
      int j = i.a.a.a.c(3, 8, this.YMN);
      AppMethodBeat.o(6397);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YMM.clear();
        this.YMN.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(6397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        kr localkr = (kr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6397);
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
            localkr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6397);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gb)localObject2).parseFrom((byte[])localObject1);
            }
            localkr.YMM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6397);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new euj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((euj)localObject2).parseFrom((byte[])localObject1);
          }
          localkr.YMN.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(6397);
        return 0;
      }
      AppMethodBeat.o(6397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kr
 * JD-Core Version:    0.7.0.1
 */