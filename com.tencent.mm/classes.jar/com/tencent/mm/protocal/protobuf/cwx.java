package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cwx
  extends esc
{
  public gjx ZiP;
  public LinkedList<aod> aaCs;
  
  public cwx()
  {
    AppMethodBeat.i(179489);
    this.aaCs = new LinkedList();
    AppMethodBeat.o(179489);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179490);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(179490);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZiP != null)
      {
        paramVarArgs.qD(2, this.ZiP.computeSize());
        this.ZiP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.aaCs);
      AppMethodBeat.o(179490);
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
      if (this.ZiP != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZiP.computeSize());
      }
      paramInt = i.a.a.a.c(3, 8, this.aaCs);
      AppMethodBeat.o(179490);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaCs.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(179490);
          throw paramVarArgs;
        }
        AppMethodBeat.o(179490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cwx localcwx = (cwx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(179490);
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
            localcwx.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(179490);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gjx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gjx)localObject2).parseFrom((byte[])localObject1);
            }
            localcwx.ZiP = ((gjx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(179490);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aod();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aod)localObject2).parseFrom((byte[])localObject1);
          }
          localcwx.aaCs.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(179490);
        return 0;
      }
      AppMethodBeat.o(179490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwx
 * JD-Core Version:    0.7.0.1
 */