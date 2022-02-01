package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eid
  extends esc
{
  public LinkedList<ehs> YKL;
  public long ZvA;
  public int Zvz;
  public LinkedList<ehs> abnc;
  
  public eid()
  {
    AppMethodBeat.i(32384);
    this.YKL = new LinkedList();
    this.abnc = new LinkedList();
    AppMethodBeat.o(32384);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32385);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32385);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.e(4, 8, this.YKL);
      paramVarArgs.e(5, 8, this.abnc);
      AppMethodBeat.o(32385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label675;
      }
    }
    label675:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Zvz);
      int j = i.a.a.b.b.a.q(3, this.ZvA);
      int k = i.a.a.a.c(4, 8, this.YKL);
      int m = i.a.a.a.c(5, 8, this.abnc);
      AppMethodBeat.o(32385);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YKL.clear();
        this.abnc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32385);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32385);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eid localeid = (eid)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32385);
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
            localeid.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32385);
          return 0;
        case 2: 
          localeid.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32385);
          return 0;
        case 3: 
          localeid.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(32385);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehs)localObject2).parseFrom((byte[])localObject1);
            }
            localeid.YKL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32385);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ehs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ehs)localObject2).parseFrom((byte[])localObject1);
          }
          localeid.abnc.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32385);
        return 0;
      }
      AppMethodBeat.o(32385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eid
 * JD-Core Version:    0.7.0.1
 */