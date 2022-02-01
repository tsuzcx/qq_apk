package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ans
  extends esc
{
  public esh ZoV;
  public anu Zvq;
  public gin Zvr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260066);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(260066);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Zvq != null)
      {
        paramVarArgs.qD(2, this.Zvq.computeSize());
        this.Zvq.writeFields(paramVarArgs);
      }
      if (this.Zvr != null)
      {
        paramVarArgs.qD(3, this.Zvr.computeSize());
        this.Zvr.writeFields(paramVarArgs);
      }
      if (this.ZoV != null)
      {
        paramVarArgs.qD(100, this.ZoV.computeSize());
        this.ZoV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260066);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label742;
      }
    }
    label742:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zvq != null) {
        paramInt = i + i.a.a.a.qC(2, this.Zvq.computeSize());
      }
      i = paramInt;
      if (this.Zvr != null) {
        i = paramInt + i.a.a.a.qC(3, this.Zvr.computeSize());
      }
      paramInt = i;
      if (this.ZoV != null) {
        paramInt = i + i.a.a.a.qC(100, this.ZoV.computeSize());
      }
      AppMethodBeat.o(260066);
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
          AppMethodBeat.o(260066);
          throw paramVarArgs;
        }
        AppMethodBeat.o(260066);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ans localans = (ans)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260066);
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
            localans.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260066);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anu)localObject2).parseFrom((byte[])localObject1);
            }
            localans.Zvq = ((anu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260066);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gin();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gin)localObject2).parseFrom((byte[])localObject1);
            }
            localans.Zvr = ((gin)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260066);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new esh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((esh)localObject2).parseFrom((byte[])localObject1);
          }
          localans.ZoV = ((esh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260066);
        return 0;
      }
      AppMethodBeat.o(260066);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ans
 * JD-Core Version:    0.7.0.1
 */