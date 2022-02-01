package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aqj
  extends esc
{
  public String CAf;
  public String Hgk;
  public String KuQ;
  public dcm ZxA;
  public int hAV;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91457);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91457);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.CAf != null) {
        paramVarArgs.g(4, this.CAf);
      }
      if (this.Hgk != null) {
        paramVarArgs.g(5, this.Hgk);
      }
      if (this.KuQ != null) {
        paramVarArgs.g(6, this.KuQ);
      }
      if (this.ZxA != null)
      {
        paramVarArgs.qD(7, this.ZxA.computeSize());
        this.ZxA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91457);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.CAf != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.CAf);
      }
      paramInt = i;
      if (this.Hgk != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Hgk);
      }
      i = paramInt;
      if (this.KuQ != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.KuQ);
      }
      paramInt = i;
      if (this.ZxA != null) {
        paramInt = i + i.a.a.a.qC(7, this.ZxA.computeSize());
      }
      AppMethodBeat.o(91457);
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
          AppMethodBeat.o(91457);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91457);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aqj localaqj = (aqj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91457);
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
            localaqj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91457);
          return 0;
        case 2: 
          localaqj.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91457);
          return 0;
        case 3: 
          localaqj.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 4: 
          localaqj.CAf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 5: 
          localaqj.Hgk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91457);
          return 0;
        case 6: 
          localaqj.KuQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91457);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dcm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dcm)localObject2).parseFrom((byte[])localObject1);
          }
          localaqj.ZxA = ((dcm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91457);
        return 0;
      }
      AppMethodBeat.o(91457);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqj
 * JD-Core Version:    0.7.0.1
 */