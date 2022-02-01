package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ega
  extends esc
{
  public flc ablu;
  public LinkedList<flc> ablv;
  
  public ega()
  {
    AppMethodBeat.i(153291);
    this.ablv = new LinkedList();
    AppMethodBeat.o(153291);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153292);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153292);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ablu != null)
      {
        paramVarArgs.qD(2, this.ablu.computeSize());
        this.ablu.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.ablv);
      AppMethodBeat.o(153292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ablu != null) {
        i = paramInt + i.a.a.a.qC(2, this.ablu.computeSize());
      }
      paramInt = i.a.a.a.c(3, 8, this.ablv);
      AppMethodBeat.o(153292);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ablv.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153292);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153292);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ega localega = (ega)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153292);
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
            localega.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153292);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new flc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((flc)localObject2).parseFrom((byte[])localObject1);
            }
            localega.ablu = ((flc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153292);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new flc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((flc)localObject2).parseFrom((byte[])localObject1);
          }
          localega.ablv.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153292);
        return 0;
      }
      AppMethodBeat.o(153292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ega
 * JD-Core Version:    0.7.0.1
 */