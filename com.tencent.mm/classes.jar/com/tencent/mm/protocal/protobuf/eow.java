package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eow
  extends esc
{
  public dtt aapa;
  public String abtb;
  public int abtc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104376);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104376);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abtb != null) {
        paramVarArgs.g(2, this.abtb);
      }
      if (this.aapa != null)
      {
        paramVarArgs.qD(3, this.aapa.computeSize());
        this.aapa.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.abtc);
      AppMethodBeat.o(104376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label570;
      }
    }
    label570:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abtb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abtb);
      }
      i = paramInt;
      if (this.aapa != null) {
        i = paramInt + i.a.a.a.qC(3, this.aapa.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.abtc);
      AppMethodBeat.o(104376);
      return i + paramInt;
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
          AppMethodBeat.o(104376);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eow localeow = (eow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104376);
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
            localeow.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104376);
          return 0;
        case 2: 
          localeow.abtb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104376);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtt)localObject2).parseFrom((byte[])localObject1);
            }
            localeow.aapa = ((dtt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104376);
          return 0;
        }
        localeow.abtc = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(104376);
        return 0;
      }
      AppMethodBeat.o(104376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eow
 * JD-Core Version:    0.7.0.1
 */