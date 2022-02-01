package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fdi
  extends esc
{
  public fdk YGn;
  public fey abqV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125763);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125763);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YGn != null)
      {
        paramVarArgs.qD(2, this.YGn.computeSize());
        this.YGn.writeFields(paramVarArgs);
      }
      if (this.abqV != null)
      {
        paramVarArgs.qD(3, this.abqV.computeSize());
        this.abqV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125763);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label596;
      }
    }
    label596:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YGn != null) {
        paramInt = i + i.a.a.a.qC(2, this.YGn.computeSize());
      }
      i = paramInt;
      if (this.abqV != null) {
        i = paramInt + i.a.a.a.qC(3, this.abqV.computeSize());
      }
      AppMethodBeat.o(125763);
      return i;
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
          AppMethodBeat.o(125763);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125763);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fdi localfdi = (fdi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125763);
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
            localfdi.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125763);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdk)localObject2).parseFrom((byte[])localObject1);
            }
            localfdi.YGn = ((fdk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125763);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fey();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fey)localObject2).parseFrom((byte[])localObject1);
          }
          localfdi.abqV = ((fey)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125763);
        return 0;
      }
      AppMethodBeat.o(125763);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdi
 * JD-Core Version:    0.7.0.1
 */