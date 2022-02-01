package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cqh
  extends erp
{
  public gol aawN;
  public int aawO;
  public int aawP;
  public gol aawQ;
  public int oOK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63273);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aawN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(63273);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.oOK);
      if (this.aawN != null)
      {
        paramVarArgs.qD(3, this.aawN.computeSize());
        this.aawN.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.aawO);
      paramVarArgs.bS(5, this.aawP);
      if (this.aawQ != null)
      {
        paramVarArgs.qD(6, this.aawQ.computeSize());
        this.aawQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(63273);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label728;
      }
    }
    label728:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.oOK);
      paramInt = i;
      if (this.aawN != null) {
        paramInt = i + i.a.a.a.qC(3, this.aawN.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.aawO) + i.a.a.b.b.a.cJ(5, this.aawP);
      paramInt = i;
      if (this.aawQ != null) {
        paramInt = i + i.a.a.a.qC(6, this.aawQ.computeSize());
      }
      AppMethodBeat.o(63273);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aawN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(63273);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63273);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cqh localcqh = (cqh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63273);
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
            localcqh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(63273);
          return 0;
        case 2: 
          localcqh.oOK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(63273);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localcqh.aawN = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(63273);
          return 0;
        case 4: 
          localcqh.aawO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(63273);
          return 0;
        case 5: 
          localcqh.aawP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(63273);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localcqh.aawQ = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(63273);
        return 0;
      }
      AppMethodBeat.o(63273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqh
 * JD-Core Version:    0.7.0.1
 */