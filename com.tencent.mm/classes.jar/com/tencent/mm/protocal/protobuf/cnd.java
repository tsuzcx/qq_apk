package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cnd
  extends esc
{
  public LinkedList<dmp> aauH;
  public LinkedList<dmq> aauI;
  
  public cnd()
  {
    AppMethodBeat.i(260260);
    this.aauH = new LinkedList();
    this.aauI = new LinkedList();
    AppMethodBeat.o(260260);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260264);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(260264);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aauH);
      paramVarArgs.e(3, 8, this.aauI);
      AppMethodBeat.o(260264);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.aauH);
      int j = i.a.a.a.c(3, 8, this.aauI);
      AppMethodBeat.o(260264);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aauH.clear();
        this.aauI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(260264);
          throw paramVarArgs;
        }
        AppMethodBeat.o(260264);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cnd localcnd = (cnd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260264);
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
            localcnd.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260264);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmp)localObject2).parseFrom((byte[])localObject1);
            }
            localcnd.aauH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260264);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dmq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dmq)localObject2).parseFrom((byte[])localObject1);
          }
          localcnd.aauI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260264);
        return 0;
      }
      AppMethodBeat.o(260264);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnd
 * JD-Core Version:    0.7.0.1
 */