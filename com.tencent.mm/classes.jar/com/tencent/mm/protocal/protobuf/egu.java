package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egu
  extends esc
{
  public com.tencent.mm.bx.b ZoR;
  public dcl ablX;
  public aga abmg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259251);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259251);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZoR != null) {
        paramVarArgs.d(2, this.ZoR);
      }
      if (this.abmg != null)
      {
        paramVarArgs.qD(3, this.abmg.computeSize());
        this.abmg.writeFields(paramVarArgs);
      }
      if (this.ablX != null)
      {
        paramVarArgs.qD(100, this.ablX.computeSize());
        this.ablX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259251);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label672;
      }
    }
    label672:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZoR != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZoR);
      }
      i = paramInt;
      if (this.abmg != null) {
        i = paramInt + i.a.a.a.qC(3, this.abmg.computeSize());
      }
      paramInt = i;
      if (this.ablX != null) {
        paramInt = i + i.a.a.a.qC(100, this.ablX.computeSize());
      }
      AppMethodBeat.o(259251);
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
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(259251);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259251);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        egu localegu = (egu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259251);
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
            localegu.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259251);
          return 0;
        case 2: 
          localegu.ZoR = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259251);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aga();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aga)localObject2).parseFrom((byte[])localObject1);
            }
            localegu.abmg = ((aga)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259251);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dcl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dcl)localObject2).parseFrom((byte[])localObject1);
          }
          localegu.ablX = ((dcl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259251);
        return 0;
      }
      AppMethodBeat.o(259251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egu
 * JD-Core Version:    0.7.0.1
 */