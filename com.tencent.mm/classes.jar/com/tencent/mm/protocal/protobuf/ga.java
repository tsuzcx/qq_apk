package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ga
  extends esc
{
  public LinkedList<pb> YHx;
  public boolean YHy;
  public int YHz;
  public int enabled;
  public int xlj;
  
  public ga()
  {
    AppMethodBeat.i(103190);
    this.YHx = new LinkedList();
    AppMethodBeat.o(103190);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103191);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(103191);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YHx);
      paramVarArgs.di(3, this.YHy);
      paramVarArgs.bS(4, this.YHz);
      paramVarArgs.bS(5, this.enabled);
      paramVarArgs.bS(6, this.xlj);
      AppMethodBeat.o(103191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.YHx);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.cJ(4, this.YHz);
      int m = i.a.a.b.b.a.cJ(5, this.enabled);
      int n = i.a.a.b.b.a.cJ(6, this.xlj);
      AppMethodBeat.o(103191);
      return paramInt + i + (j + 1) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YHx.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(103191);
          throw paramVarArgs;
        }
        AppMethodBeat.o(103191);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ga localga = (ga)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103191);
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
            localga.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(103191);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new pb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((pb)localObject2).parseFrom((byte[])localObject1);
            }
            localga.YHx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(103191);
          return 0;
        case 3: 
          localga.YHy = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(103191);
          return 0;
        case 4: 
          localga.YHz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(103191);
          return 0;
        case 5: 
          localga.enabled = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(103191);
          return 0;
        }
        localga.xlj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(103191);
        return 0;
      }
      AppMethodBeat.o(103191);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ga
 * JD-Core Version:    0.7.0.1
 */