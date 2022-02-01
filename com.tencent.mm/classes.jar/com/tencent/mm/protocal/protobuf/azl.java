package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azl
  extends esc
{
  public int ZFm;
  public bip liveInfo;
  public String recommend_reason;
  public int refreshInterval;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259146);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.liveInfo != null)
      {
        paramVarArgs.qD(2, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.ZFm);
      paramVarArgs.bS(4, this.refreshInterval);
      if (this.recommend_reason != null) {
        paramVarArgs.g(5, this.recommend_reason);
      }
      AppMethodBeat.o(259146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.liveInfo != null) {
        i = paramInt + i.a.a.a.qC(2, this.liveInfo.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.ZFm) + i.a.a.b.b.a.cJ(4, this.refreshInterval);
      paramInt = i;
      if (this.recommend_reason != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.recommend_reason);
      }
      AppMethodBeat.o(259146);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azl localazl = (azl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259146);
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
            localazl.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259146);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bip();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bip)localObject2).parseFrom((byte[])localObject1);
            }
            localazl.liveInfo = ((bip)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259146);
          return 0;
        case 3: 
          localazl.ZFm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259146);
          return 0;
        case 4: 
          localazl.refreshInterval = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259146);
          return 0;
        }
        localazl.recommend_reason = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259146);
        return 0;
      }
      AppMethodBeat.o(259146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azl
 * JD-Core Version:    0.7.0.1
 */