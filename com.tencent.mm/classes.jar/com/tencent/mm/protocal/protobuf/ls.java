package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ls
  extends esc
{
  public boolean YNn;
  public LinkedList<eyr> YNo;
  
  public ls()
  {
    AppMethodBeat.i(153264);
    this.YNo = new LinkedList();
    AppMethodBeat.o(153264);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153265);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153265);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.YNn);
      paramVarArgs.e(3, 8, this.YNo);
      AppMethodBeat.o(153265);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.a.c(3, 8, this.YNo);
      AppMethodBeat.o(153265);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YNo.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153265);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153265);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ls localls = (ls)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153265);
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
            localls.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153265);
          return 0;
        case 2: 
          localls.YNn = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153265);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eyr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eyr)localObject2).parseFrom((byte[])localObject1);
          }
          localls.YNo.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153265);
        return 0;
      }
      AppMethodBeat.o(153265);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ls
 * JD-Core Version:    0.7.0.1
 */