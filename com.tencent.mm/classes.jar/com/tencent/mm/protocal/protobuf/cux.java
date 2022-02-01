package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cux
  extends esc
{
  public fvh aaAo;
  public String aaAp;
  public String aaAq;
  public eq aaAr;
  public fvl aaAs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257629);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257629);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaAo != null)
      {
        paramVarArgs.qD(2, this.aaAo.computeSize());
        this.aaAo.writeFields(paramVarArgs);
      }
      if (this.aaAp != null) {
        paramVarArgs.g(3, this.aaAp);
      }
      if (this.aaAq != null) {
        paramVarArgs.g(4, this.aaAq);
      }
      if (this.aaAr != null)
      {
        paramVarArgs.qD(5, this.aaAr.computeSize());
        this.aaAr.writeFields(paramVarArgs);
      }
      if (this.aaAs != null)
      {
        paramVarArgs.qD(6, this.aaAs.computeSize());
        this.aaAs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label850;
      }
    }
    label850:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaAo != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaAo.computeSize());
      }
      i = paramInt;
      if (this.aaAp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaAp);
      }
      paramInt = i;
      if (this.aaAq != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaAq);
      }
      i = paramInt;
      if (this.aaAr != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaAr.computeSize());
      }
      paramInt = i;
      if (this.aaAs != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaAs.computeSize());
      }
      AppMethodBeat.o(257629);
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
          AppMethodBeat.o(257629);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cux localcux = (cux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257629);
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
            localcux.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257629);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fvh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fvh)localObject2).parseFrom((byte[])localObject1);
            }
            localcux.aaAo = ((fvh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257629);
          return 0;
        case 3: 
          localcux.aaAp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257629);
          return 0;
        case 4: 
          localcux.aaAq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257629);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eq)localObject2).parseFrom((byte[])localObject1);
            }
            localcux.aaAr = ((eq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257629);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fvl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fvl)localObject2).parseFrom((byte[])localObject1);
          }
          localcux.aaAs = ((fvl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257629);
        return 0;
      }
      AppMethodBeat.o(257629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cux
 * JD-Core Version:    0.7.0.1
 */