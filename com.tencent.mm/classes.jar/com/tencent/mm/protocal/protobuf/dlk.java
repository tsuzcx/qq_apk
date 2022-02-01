package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dlk
  extends esc
{
  public LinkedList<dli> aaRA;
  public int aaRx;
  public int aaRz;
  public String appid;
  public String id;
  public int interval;
  
  public dlk()
  {
    AppMethodBeat.i(259092);
    this.aaRA = new LinkedList();
    AppMethodBeat.o(259092);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259098);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259098);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.id != null) {
        paramVarArgs.g(2, this.id);
      }
      paramVarArgs.bS(3, this.interval);
      paramVarArgs.bS(4, this.aaRz);
      paramVarArgs.bS(5, this.aaRx);
      if (this.appid != null) {
        paramVarArgs.g(6, this.appid);
      }
      paramVarArgs.e(7, 8, this.aaRA);
      AppMethodBeat.o(259098);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.id != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.id);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.interval) + i.a.a.b.b.a.cJ(4, this.aaRz) + i.a.a.b.b.a.cJ(5, this.aaRx);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.appid);
      }
      i = i.a.a.a.c(7, 8, this.aaRA);
      AppMethodBeat.o(259098);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaRA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(259098);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259098);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dlk localdlk = (dlk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259098);
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
            localdlk.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259098);
          return 0;
        case 2: 
          localdlk.id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259098);
          return 0;
        case 3: 
          localdlk.interval = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259098);
          return 0;
        case 4: 
          localdlk.aaRz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259098);
          return 0;
        case 5: 
          localdlk.aaRx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259098);
          return 0;
        case 6: 
          localdlk.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259098);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dli();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dli)localObject2).parseFrom((byte[])localObject1);
          }
          localdlk.aaRA.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259098);
        return 0;
      }
      AppMethodBeat.o(259098);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlk
 * JD-Core Version:    0.7.0.1
 */