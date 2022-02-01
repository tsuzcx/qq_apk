package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cnp
  extends esc
{
  public int aaqL;
  public eao aauU;
  public int aauV;
  public String wuA;
  public int wuz;
  public int xlj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114031);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114031);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.bS(4, this.xlj);
      paramVarArgs.bS(5, this.aaqL);
      if (this.aauU != null)
      {
        paramVarArgs.qD(6, this.aauU.computeSize());
        this.aauU.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.aauV);
      AppMethodBeat.o(114031);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.xlj) + i.a.a.b.b.a.cJ(5, this.aaqL);
      paramInt = i;
      if (this.aauU != null) {
        paramInt = i + i.a.a.a.qC(6, this.aauU.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.aauV);
      AppMethodBeat.o(114031);
      return paramInt + i;
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
          AppMethodBeat.o(114031);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114031);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cnp localcnp = (cnp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114031);
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
            localcnp.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114031);
          return 0;
        case 2: 
          localcnp.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114031);
          return 0;
        case 3: 
          localcnp.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114031);
          return 0;
        case 4: 
          localcnp.xlj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114031);
          return 0;
        case 5: 
          localcnp.aaqL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114031);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eao();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eao)localObject2).parseFrom((byte[])localObject1);
            }
            localcnp.aauU = ((eao)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114031);
          return 0;
        }
        localcnp.aauV = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(114031);
        return 0;
      }
      AppMethodBeat.o(114031);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnp
 * JD-Core Version:    0.7.0.1
 */