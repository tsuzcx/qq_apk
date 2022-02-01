package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cnw
  extends cvw
{
  public int Gxq;
  public cxn HzP;
  public cxn HzQ;
  public cxn HzR;
  public int HzS;
  public long Hzz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HzP == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.HzQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChannelReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.HzR == null)
      {
        paramVarArgs = new b("Not all required fields were included: EngineReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HzP != null)
      {
        paramVarArgs.lJ(2, this.HzP.computeSize());
        this.HzP.writeFields(paramVarArgs);
      }
      if (this.HzQ != null)
      {
        paramVarArgs.lJ(3, this.HzQ.computeSize());
        this.HzQ.writeFields(paramVarArgs);
      }
      if (this.HzR != null)
      {
        paramVarArgs.lJ(4, this.HzR.computeSize());
        this.HzR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.Gxq);
      paramVarArgs.aZ(6, this.Hzz);
      paramVarArgs.aS(7, this.HzS);
      AppMethodBeat.o(32386);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1075;
      }
    }
    label1075:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HzP != null) {
        paramInt = i + f.a.a.a.lI(2, this.HzP.computeSize());
      }
      i = paramInt;
      if (this.HzQ != null) {
        i = paramInt + f.a.a.a.lI(3, this.HzQ.computeSize());
      }
      paramInt = i;
      if (this.HzR != null) {
        paramInt = i + f.a.a.a.lI(4, this.HzR.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.Gxq);
      int j = f.a.a.b.b.a.p(6, this.Hzz);
      int k = f.a.a.b.b.a.bz(7, this.HzS);
      AppMethodBeat.o(32386);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HzP == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.HzQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChannelReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.HzR == null)
        {
          paramVarArgs = new b("Not all required fields were included: EngineReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32386);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnw localcnw = (cnw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32386);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnw.HzP = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnw.HzQ = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnw.HzR = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 5: 
          localcnw.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32386);
          return 0;
        case 6: 
          localcnw.Hzz = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32386);
          return 0;
        }
        localcnw.HzS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32386);
        return 0;
      }
      AppMethodBeat.o(32386);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnw
 * JD-Core Version:    0.7.0.1
 */