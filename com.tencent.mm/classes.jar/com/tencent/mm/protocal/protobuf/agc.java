package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class agc
  extends esc
{
  public long ZoU;
  public esh ZoV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259641);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259641);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.ZoU);
      if (this.ZoV != null)
      {
        paramVarArgs.qD(100, this.ZoV.computeSize());
        this.ZoV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.ZoU);
      paramInt = i;
      if (this.ZoV != null) {
        paramInt = i + i.a.a.a.qC(100, this.ZoV.computeSize());
      }
      AppMethodBeat.o(259641);
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
          AppMethodBeat.o(259641);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259641);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        agc localagc = (agc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259641);
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
            localagc.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259641);
          return 0;
        case 2: 
          localagc.ZoU = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259641);
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
          localagc.ZoV = ((esh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259641);
        return 0;
      }
      AppMethodBeat.o(259641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agc
 * JD-Core Version:    0.7.0.1
 */