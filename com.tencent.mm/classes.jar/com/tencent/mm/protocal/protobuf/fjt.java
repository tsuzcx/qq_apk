package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fjt
  extends esc
{
  public int YJF;
  public String ZpZ;
  public ih abKp;
  public id abzA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123658);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123658);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abzA != null)
      {
        paramVarArgs.qD(2, this.abzA.computeSize());
        this.abzA.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.YJF);
      if (this.abKp != null)
      {
        paramVarArgs.qD(4, this.abKp.computeSize());
        this.abKp.writeFields(paramVarArgs);
      }
      if (this.ZpZ != null) {
        paramVarArgs.g(5, this.ZpZ);
      }
      AppMethodBeat.o(123658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label700;
      }
    }
    label700:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abzA != null) {
        i = paramInt + i.a.a.a.qC(2, this.abzA.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.YJF);
      paramInt = i;
      if (this.abKp != null) {
        paramInt = i + i.a.a.a.qC(4, this.abKp.computeSize());
      }
      i = paramInt;
      if (this.ZpZ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZpZ);
      }
      AppMethodBeat.o(123658);
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
          AppMethodBeat.o(123658);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123658);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fjt localfjt = (fjt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123658);
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
            localfjt.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new id();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((id)localObject2).parseFrom((byte[])localObject1);
            }
            localfjt.abzA = ((id)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        case 3: 
          localfjt.YJF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123658);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ih();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ih)localObject2).parseFrom((byte[])localObject1);
            }
            localfjt.abKp = ((ih)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        }
        localfjt.ZpZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(123658);
        return 0;
      }
      AppMethodBeat.o(123658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjt
 * JD-Core Version:    0.7.0.1
 */