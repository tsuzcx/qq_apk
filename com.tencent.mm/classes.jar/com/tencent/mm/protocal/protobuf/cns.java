package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cns
  extends erp
{
  public int Njs;
  public long Njv;
  public int NkN;
  public int NkO;
  public int NkP;
  public etl YFE;
  public etl YFF;
  public int aava;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152572);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFE == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152572);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Njs);
      if (this.YFE != null)
      {
        paramVarArgs.qD(3, this.YFE.computeSize());
        this.YFE.writeFields(paramVarArgs);
      }
      if (this.YFF != null)
      {
        paramVarArgs.qD(4, this.YFF.computeSize());
        this.YFF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.NkN);
      paramVarArgs.bS(6, this.NkO);
      paramVarArgs.bS(7, this.NkP);
      paramVarArgs.bS(8, this.aava);
      paramVarArgs.bv(9, this.Njv);
      AppMethodBeat.o(152572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label924;
      }
    }
    label924:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Njs);
      paramInt = i;
      if (this.YFE != null) {
        paramInt = i + i.a.a.a.qC(3, this.YFE.computeSize());
      }
      i = paramInt;
      if (this.YFF != null) {
        i = paramInt + i.a.a.a.qC(4, this.YFF.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.NkN);
      int j = i.a.a.b.b.a.cJ(6, this.NkO);
      int k = i.a.a.b.b.a.cJ(7, this.NkP);
      int m = i.a.a.b.b.a.cJ(8, this.aava);
      int n = i.a.a.b.b.a.q(9, this.Njv);
      AppMethodBeat.o(152572);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YFE == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        if (this.YFF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cns localcns = (cns)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152572);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localcns.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 2: 
          localcns.Njs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152572);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localcns.YFE = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localcns.YFF = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152572);
          return 0;
        case 5: 
          localcns.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152572);
          return 0;
        case 6: 
          localcns.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152572);
          return 0;
        case 7: 
          localcns.NkP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152572);
          return 0;
        case 8: 
          localcns.aava = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152572);
          return 0;
        }
        localcns.Njv = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(152572);
        return 0;
      }
      AppMethodBeat.o(152572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cns
 * JD-Core Version:    0.7.0.1
 */