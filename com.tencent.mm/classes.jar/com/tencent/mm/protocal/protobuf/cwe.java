package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cwe
  extends esc
{
  public LinkedList<bzs> ZIU;
  public LinkedList<String> aaBz;
  
  public cwe()
  {
    AppMethodBeat.i(32311);
    this.aaBz = new LinkedList();
    this.ZIU = new LinkedList();
    AppMethodBeat.o(32311);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32312);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32312);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.aaBz);
      paramVarArgs.e(3, 8, this.ZIU);
      AppMethodBeat.o(32312);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label523;
      }
    }
    label523:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.aaBz);
      int j = i.a.a.a.c(3, 8, this.ZIU);
      AppMethodBeat.o(32312);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaBz.clear();
        this.ZIU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32312);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32312);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cwe localcwe = (cwe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32312);
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
            localcwe.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32312);
          return 0;
        case 2: 
          localcwe.aaBz.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(32312);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bzs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bzs)localObject2).parseFrom((byte[])localObject1);
          }
          localcwe.ZIU.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32312);
        return 0;
      }
      AppMethodBeat.o(32312);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwe
 * JD-Core Version:    0.7.0.1
 */