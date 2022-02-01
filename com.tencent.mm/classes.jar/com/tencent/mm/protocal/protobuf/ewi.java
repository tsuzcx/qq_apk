package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ewi
  extends esc
{
  public fup ZqU;
  public com.tencent.mm.bx.b aazX;
  public LinkedList<fun> aazY;
  public int aazZ;
  
  public ewi()
  {
    AppMethodBeat.i(74667);
    this.aazY = new LinkedList();
    AppMethodBeat.o(74667);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74668);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(74668);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZqU != null)
      {
        paramVarArgs.qD(2, this.ZqU.computeSize());
        this.ZqU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.aazY);
      if (this.aazX != null) {
        paramVarArgs.d(4, this.aazX);
      }
      paramVarArgs.bS(5, this.aazZ);
      AppMethodBeat.o(74668);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label688;
      }
    }
    label688:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZqU != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZqU.computeSize());
      }
      i += i.a.a.a.c(3, 8, this.aazY);
      paramInt = i;
      if (this.aazX != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.aazX);
      }
      i = i.a.a.b.b.a.cJ(5, this.aazZ);
      AppMethodBeat.o(74668);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aazY.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(74668);
          throw paramVarArgs;
        }
        AppMethodBeat.o(74668);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ewi localewi = (ewi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74668);
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
            localewi.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(74668);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fup();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fup)localObject2).parseFrom((byte[])localObject1);
            }
            localewi.ZqU = ((fup)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(74668);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fun();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fun)localObject2).parseFrom((byte[])localObject1);
            }
            localewi.aazY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(74668);
          return 0;
        case 4: 
          localewi.aazX = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(74668);
          return 0;
        }
        localewi.aazZ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(74668);
        return 0;
      }
      AppMethodBeat.o(74668);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewi
 * JD-Core Version:    0.7.0.1
 */