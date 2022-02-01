package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class yt
  extends esc
{
  public geo OhU;
  public int Okq;
  public String Osd;
  public String Otb;
  public String Zhp;
  public boolean Zhq;
  public int hAV;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72449);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72449);
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
      if (this.Zhp != null) {
        paramVarArgs.g(4, this.Zhp);
      }
      if (this.Otb != null) {
        paramVarArgs.g(5, this.Otb);
      }
      paramVarArgs.di(6, this.Zhq);
      if (this.Osd != null) {
        paramVarArgs.g(7, this.Osd);
      }
      paramVarArgs.bS(8, this.Okq);
      if (this.OhU != null)
      {
        paramVarArgs.qD(9, this.OhU.computeSize());
        this.OhU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.Zhp != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Zhp);
      }
      paramInt = i;
      if (this.Otb != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Otb);
      }
      i = paramInt + (i.a.a.b.b.a.ko(6) + 1);
      paramInt = i;
      if (this.Osd != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Osd);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.Okq);
      paramInt = i;
      if (this.OhU != null) {
        paramInt = i + i.a.a.a.qC(9, this.OhU.computeSize());
      }
      AppMethodBeat.o(72449);
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
          AppMethodBeat.o(72449);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        yt localyt = (yt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72449);
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
            localyt.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72449);
          return 0;
        case 2: 
          localyt.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72449);
          return 0;
        case 3: 
          localyt.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 4: 
          localyt.Zhp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 5: 
          localyt.Otb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 6: 
          localyt.Zhq = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(72449);
          return 0;
        case 7: 
          localyt.Osd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 8: 
          localyt.Okq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72449);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new geo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((geo)localObject2).parseFrom((byte[])localObject1);
          }
          localyt.OhU = ((geo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72449);
        return 0;
      }
      AppMethodBeat.o(72449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yt
 * JD-Core Version:    0.7.0.1
 */