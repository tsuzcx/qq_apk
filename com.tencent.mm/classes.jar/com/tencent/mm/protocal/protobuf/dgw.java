package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dgw
  extends esc
{
  public aat aaMa;
  public giz aaMi;
  public gjb aaMj;
  public gnl aaMk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123627);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123627);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaMi != null)
      {
        paramVarArgs.qD(2, this.aaMi.computeSize());
        this.aaMi.writeFields(paramVarArgs);
      }
      if (this.aaMa != null)
      {
        paramVarArgs.qD(3, this.aaMa.computeSize());
        this.aaMa.writeFields(paramVarArgs);
      }
      if (this.aaMj != null)
      {
        paramVarArgs.qD(4, this.aaMj.computeSize());
        this.aaMj.writeFields(paramVarArgs);
      }
      if (this.aaMk != null)
      {
        paramVarArgs.qD(5, this.aaMk.computeSize());
        this.aaMk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label860;
      }
    }
    label860:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaMi != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaMi.computeSize());
      }
      i = paramInt;
      if (this.aaMa != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaMa.computeSize());
      }
      paramInt = i;
      if (this.aaMj != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaMj.computeSize());
      }
      i = paramInt;
      if (this.aaMk != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaMk.computeSize());
      }
      AppMethodBeat.o(123627);
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
          AppMethodBeat.o(123627);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123627);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dgw localdgw = (dgw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123627);
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
            localdgw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new giz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((giz)localObject2).parseFrom((byte[])localObject1);
            }
            localdgw.aaMi = ((giz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aat();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aat)localObject2).parseFrom((byte[])localObject1);
            }
            localdgw.aaMa = ((aat)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gjb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gjb)localObject2).parseFrom((byte[])localObject1);
            }
            localdgw.aaMj = ((gjb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123627);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gnl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gnl)localObject2).parseFrom((byte[])localObject1);
          }
          localdgw.aaMk = ((gnl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123627);
        return 0;
      }
      AppMethodBeat.o(123627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgw
 * JD-Core Version:    0.7.0.1
 */